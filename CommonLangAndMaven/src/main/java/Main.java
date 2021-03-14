public class Main {

    public static void main(String[] args) {

        WordsConverter wordsConverter = new WordsConverter();
        OutputResult outputResult = new OutputResult();

        wordsConverter.leverer();
        outputResult.outputter(wordsConverter.capitalizer());
    }
}
