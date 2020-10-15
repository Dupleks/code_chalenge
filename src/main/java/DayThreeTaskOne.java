import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayThreeTaskOne {
    public static void main(String[] args) {
        String[] words = {"apple banana", "orange", "banana", "kiwi strawberry blueberry"};
        getNewArray(words);
    }

    public static String[] getNewArray(String[] words){
        String words1 = Arrays.toString(words);

        List<String> resultList = Splitter.on(CharMatcher.whitespace())
                .trimResults(CharMatcher.is(','))
                .omitEmptyStrings()
                .splitToList(words1);
        String[] strArray = resultList.toArray(new String[0]);

        return strArray;
    }
}
