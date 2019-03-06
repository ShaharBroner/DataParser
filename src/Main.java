import java.util.ArrayList;

//Main class for data parsers
//@author: Shahar Broner
public class Main {
    //Test of utils
    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        //System.out.println(data);
        ArrayList<ElectionResults> results = Utils.parse2016ElectionResults(data);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).toString());
        }
    }
}
