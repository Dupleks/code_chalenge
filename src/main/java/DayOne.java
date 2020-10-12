import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;


public class DayOne {

    public static void main(String[] args) throws IOException, ParseException {
        String name = "Egor";
        int systemHour = getHourFromSystem(); // Task 1
        int apiHour = getHourFromAPI(); // Task 2
        printGreeting(name, systemHour);
        printGreeting(name, apiHour);
    }

    public static void printGreeting(String name, int hour) {
        if (hour >= 0 && hour <= 4) {
            System.out.println("Доброй ночи, " + name);
        }
        if (hour >= 5 && hour <= 9) {
            System.out.println("Доброе утро, " + name);
        }
        if (hour >= 10 && hour <= 16) {
            System.out.println("Добрый день, " + name);
        }
        if (hour >= 17 && hour <= 23) {
            System.out.println("Добрый вечер, " + name);
        }
    }

    public static int getHourFromSystem() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public static int getHourFromAPI() throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://worldtimeapi.org/api/ip")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String jsonString = response.body().string();
            JSONObject obj = new JSONObject(jsonString);
            String datetime = obj.getString("datetime");

            TemporalAccessor ta = DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(datetime);
            Instant i = Instant.from(ta);
            Date d = Date.from(i);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            return hour;
        }

    }
}
