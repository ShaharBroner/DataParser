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

    public static ArrayList<EmploymentData> parse2016EmploymentData(String data) {
        ArrayList<EmploymentData> output = new ArrayList<>();
        String[] rows = data.split("\n");
        for (int i = 8; i < rows.length; i++) {
            String current = rows[i];
            EmploymentData e = new EmploymentData(0, 0, 0, 0, "", "", 0);
            e.setFips(Integer.parseInt(current.substring(0, current.indexOf(","))));
            removeExtraInfo(current);
            e.setStateName(current.substring(0, current.indexOf(",")));
            removeExtraInfo(current);
            while (current.indexOf("\"") != -1) {
                current = removeCommas(current);
            }
            e.setCountyName(current.substring(0, current.indexOf(",")));
            removeExtraInfo(current);
            String[] OneRowData = current.split(",");
            removeExtraSpaces(OneRowData);
            setEmploymentResultsAsObject(e, OneRowData);
            output.add(e);
        }
        return output;
    }

    private static void removeExtraSpaces(String[] OneRowData) {
        for (int i = 0; i < OneRowData.length; i++) {
            String current = OneRowData[i];
            if (current.indexOf(" ") != -1) {
                while (current.substring(current.length() - 1, current.length()).equals(" ")) {
                    current = current.substring(0, current.length() - 1);
                }
                while (current.indexOf(" ") != -1) {
                    current = current.substring(current.indexOf(" ") + 2, current.length());
                }
            }
            OneRowData[i] = current;
        }
    }

    private static void setEmploymentResultsAsObject(EmploymentData e, String[] OneRowData) {
        if (OneRowData.length == 51) {
            e.setTotalLaborForce(Integer.parseInt(OneRowData[OneRowData.length - 9]));
            e.setEmployedLaborForce(Integer.parseInt(OneRowData[OneRowData.length - 8]));
            e.setUnemployedLaborForce(Integer.parseInt(OneRowData[OneRowData.length - 7]));
            e.setUnemployedPercent(Double.parseDouble(OneRowData[OneRowData.length - 6]));
        } else {
            e.setTotalLaborForce(Integer.parseInt(OneRowData[OneRowData.length - 10]));
            e.setEmployedLaborForce(Integer.parseInt(OneRowData[OneRowData.length - 8]));
            e.setUnemployedLaborForce(Integer.parseInt(OneRowData[OneRowData.length - 8]));
            e.setUnemployedPercent(Double.parseDouble(OneRowData[OneRowData.length - 7]));
        }
    }

    public static ArrayList<EducationData> parse2016EducationData(String data) {
        ArrayList<EducationData> output = new ArrayList<>();
        String[] rows = data.split("\n");
        for (int i = 5; i < rows.length - 10; i++) {
            String current = rows[i];
            EducationData e = new EducationData(0, 0, 0, 0, "", "", 0);
            e.setFips(Integer.parseInt(current.substring(0, current.indexOf(","))));
            removeExtraInfo(current);
            e.setStateName(current.substring(0, current.indexOf(",")));
            removeExtraInfo(current);
            while (current.indexOf("\"") != -1) {
                current = removeCommas(current);
            }
            e.setCountyName(current.substring(0, current.indexOf(",")));
            removeExtraInfo(current);
            String[] OneRowData = current.split(",");
            setEducationResultsAsObject(e, OneRowData);
            output.add(e);
        }
        return output;
    }


    private static void setEducationResultsAsObject(EducationData e, String[] OneRowData) {
        if (OneRowData.length > 46) {
            e.setNoHighSchool(Double.parseDouble(OneRowData[43]));
            e.setOnlyHighSchool(Double.parseDouble(OneRowData[44]));
            e.setSomeCollege(Double.parseDouble(OneRowData[45]));
            e.setBachelorsOrMore(Double.parseDouble(OneRowData[46]));
        }
    }

    public static ArrayList<ElectionResults> parse2016ElectionResults(String data) {
        ArrayList<ElectionResults> output = new ArrayList<>();
        String[] rows = data.split("\n");
        for (int i = 1; i < rows.length; i++) {
            String current = removeExtraInfo(rows[i]);
            if (current.indexOf("\"") != -1) {
                current = removeCommas(current);
            }
            String[] OneRowData = current.split(",");
            ElectionResults e = setDataAsObject(OneRowData);
            output.add(e);
        }
        return output;
    }

    public static String removeExtraInfo(String current) {
        current = current.substring(current.indexOf(",") + 1, current.length());
        if (current.indexOf("%") != -1)
            current = current.substring(0, current.indexOf("%")) + current.substring(current.indexOf("%") + 1, current.length());
        return current;
    }

    public static String removeCommas(String current) {
        String partial = current.substring(current.indexOf("\"") + 1, current.length());
        partial = partial.substring(0, partial.indexOf("\""));
        while (partial.indexOf(",") != -1) {
            partial = partial.substring(0, partial.indexOf(",")) + partial.substring(partial.indexOf(",") + 1, partial.length());
        }
        String output = current.substring(0, current.indexOf("\"")) + partial + current.substring(current.indexOf("\"", current.indexOf("\"") + 1) + 1, current.length());
        return output;
    }

    public static ElectionResults setDataAsObject(String[] OneRowData) {
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
        return e;
    }
}
