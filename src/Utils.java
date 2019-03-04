import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResults> parse2016ElectionResults(String data) {
        ArrayList<ElectionResults> output = new ArrayList<>();
        String[] rows = data.split("\n");
        for (int i = 1; i < rows.length; i++) {
            String current = rows[i];
            current = current.substring(current.indexOf(",") + 1, current.length());
            current = current.substring(0, current.indexOf("%")) + current.substring(current.indexOf("%") + 1, current.length());
            if (current.indexOf("\"") != -1) {
                String partial = current.substring(current.indexOf("\"") + 1, current.length());
                partial = partial.substring(0, partial.indexOf("\""));
                while (partial.indexOf(",") != -1) {
                    partial = partial.substring(0, partial.indexOf(",")) + partial.substring(partial.indexOf(",") + 1, partial.length());
                }
                current = current.substring(0, current.indexOf("\"")) + partial + current.substring(current.indexOf("\"", current.indexOf("\"") + 1) + 1, current.length());
            }
            System.out.println(current);
            String[] OneRowData = current.split(",");
            double votesDem = Double.parseDouble(OneRowData[0]);
            double votesGop = Double.parseDouble(OneRowData[1]);
            double totalVotes = Double.parseDouble(OneRowData[2]);
            double perDem = Double.parseDouble(OneRowData[3]);
            double perGop = Double.parseDouble(OneRowData[4]);
            int diff = Integer.parseInt(OneRowData[5]);
            double perPointDiff = Double.parseDouble(OneRowData[6]);
            String stateAbbr = OneRowData[7];
            String countyName = OneRowData[8];
            int combinedFips = Integer.parseInt(OneRowData[9]);
            ElectionResults e = new ElectionResults(votesDem, votesGop, totalVotes, perDem, perGop, diff, perPointDiff, stateAbbr, countyName, combinedFips);
            output.add(e);
        }
        return output;
    }

}
