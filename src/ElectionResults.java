public class ElectionResults {
    private double VotesDem, votesGop, totalVotes, perDem, perGop, perPointDiff;
    private int diff, combinedFips;
    private String stateAbbr, countyName;

    public double getVotesDem() {
        return VotesDem;
    }

    public void setVotesDem(double votesDem) {
        VotesDem = votesDem;
    }

    public double getVotesGop() {
        return votesGop;
    }

    public void setVotesGop(double votesGop) {
        this.votesGop = votesGop;
    }

    public double getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(double totalVotes) {
        this.totalVotes = totalVotes;
    }

    public double getPerDem() {
        return perDem;
    }

    public void setPerDem(double perDem) {
        this.perDem = perDem;
    }

    public double getPerGop() {
        return perGop;
    }

    public void setPerGop(double perGop) {
        this.perGop = perGop;
    }

    public double getPerPointDiff() {
        return perPointDiff;
    }

    public void setPerPointDiff(double perPointDiff) {
        this.perPointDiff = perPointDiff;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getCombinedFips() {
        return combinedFips;
    }

    public void setCombinedFips(int combinedFips) {
        this.combinedFips = combinedFips;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @Override
    public String toString() {
        return "ElectionResults{" +
                "VotesDem=" + VotesDem +
                ", votesGop=" + votesGop +
                ", totalVotes=" + totalVotes +
                ", perDem=" + perDem +
                ", perGop=" + perGop +
                ", diff=" + diff +
                ", perPointDiff=" + perPointDiff +
                ", stateAbbr='" + stateAbbr + '\'' +
                ", countyName='" + countyName + '\'' +
                ", combinedFips=" + combinedFips +
                '}';
    }

    public ElectionResults(double votesDem, double votesGop, double totalVotes, double perDem, double perGop, int diff, double perPointDiff, String stateAbbr, String countyName, int combinedFips) {

        VotesDem = votesDem;
        this.votesGop = votesGop;
        this.totalVotes = totalVotes;
        this.perDem = perDem;
        this.perGop = perGop;
        this.perPointDiff = perPointDiff;
        this.diff = diff;
        this.combinedFips = combinedFips;
        this.stateAbbr = stateAbbr;
        this.countyName = countyName;
    }
}
