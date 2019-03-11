import java.util.ArrayList;

//Main class for data parsers
//@author: Shahar Broner
public class Main {
    //Test of utils
    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String data1 = Utils.readFileAsString("data/Education.csv");
        //System.out.println(data);
        ArrayList<ElectionResults> results = Utils.parse2016ElectionResults(data);
        ArrayList<EducationData> results1 = Utils.parse2016EducationData(data1);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results1.get(i).toString());
        }
    }
}
