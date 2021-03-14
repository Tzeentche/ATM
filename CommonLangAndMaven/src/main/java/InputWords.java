import org.apache.commons.lang3.RandomStringUtils;

public class InputWords {

    public String[] wordsFilling() {

        String[] lablesArray = new String[10];

        for(int i = 0; i < 10; i++) {

            lablesArray[i] = RandomStringUtils.randomAlphabetic(10);
        }


        for (int i = 0; i < lablesArray.length; i++) {

            System.out.println("Word is " + lablesArray[i]);
        }

        return lablesArray;
    }

}