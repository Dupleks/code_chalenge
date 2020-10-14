import org.json.JSONObject;

import java.util.*;

public class DayTwoTaskTwo {
    public static void main(String[] args) {
        String originText = "«Не забывайте о том, что все великие волшебники в истории в свое время были такими же, как мы, - школьниками. Если у них получилось, то получится и у нас», - Гарри Поттер.";
        int maxLength = 35;
        String[] forbiddenWords = new String[]{"волшебники", "Гарри Поттер"};
        
        analyseText(originText, maxLength, forbiddenWords);

    }

    public static void analyseText(String originText, int maxLength, String[] forbiddenWords) {
        int length = originText.length();
        int pureLength = originText.replace(" ", "").length();
        String pureText = originText;
        for (int i = 0; i < forbiddenWords.length; i++) {
            pureText = pureText.replaceAll(forbiddenWords[i], "***");
        }

        String pureShortText = originText;
        if (pureShortText.length() > maxLength)
            pureShortText = pureShortText.substring(0, maxLength) + "...";

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("length", length);
        data.put("pure_length", pureLength);
        data.put("pure_text", pureText);
        data.put("origin_text", pureShortText);

        JSONObject json = new JSONObject(data);
        System.out.printf(json.toString(2));

    }

}
