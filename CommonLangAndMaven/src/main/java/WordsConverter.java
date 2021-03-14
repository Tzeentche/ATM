
import java.lang.*;
import org.apache.commons.lang3.*;

public class WordsConverter {

    InputWords inputWords = new InputWords();
    String[] reformedArray = inputWords.wordsFilling();

        public String[] capitalizer() {


            String[] capitalizeArray = reformedArray;

                for(int i = 0; i < capitalizeArray.length; i++) {

                    capitalizeArray[i] = StringUtils.capitalize(capitalizeArray[i]);
                }
            return capitalizeArray;
        }

    public String[] leverer() {

        for(int i = 0; i < reformedArray.length; i++) {

            reformedArray[i] = reformedArray[i].toLowerCase();
        }
        return reformedArray;
    }
}
