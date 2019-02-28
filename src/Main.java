//Main class for data parsers
//@author: Shahar Broner
public class Main {
    //Test of utils
    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        System.out.println(data);
    }
}
