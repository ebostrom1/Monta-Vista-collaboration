public class ElectionResults {
    private double votes_dem, votes_gop,total_votes,per_dem,per_gop, per_point;
    private String state_abbr,county_name;
    private int diff, combined_fipsl;

    public ElectionResults(String[] fields) {
        for (int i = 0; i < fields.length; i++) {
           fields[i] = fields[i].replaceAll(",","");
        }
        this.votes_dem = Double.parseDouble(fields[1]);
        this.votes_gop = Double.parseDouble(fields[2]);
        this.total_votes = Double.parseDouble(fields[3]);
    }

    public void setVotes_dem(double votes_dem) {
        this.votes_dem = votes_dem;
    }

    public void setVotes_gop(double votes_gop) {
        this.votes_gop = votes_gop;
    }

    public void setTotal_votes(double total_votes) {
        this.total_votes = total_votes;
    }

    public void setPer_dem(double per_dem) {
        this.per_dem = per_dem;
    }

    public void setPer_gop(double per_gop) {
        this.per_gop = per_gop;
    }

    public void setPer_point(double per_point) {
        this.per_point = per_point;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public void setState_abbr(String state_abbr) {
        this.state_abbr = state_abbr;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public void setCombined_fipsl(int combined_fipsl) {
        this.combined_fipsl = combined_fipsl;
    }

    public double getVotes_dem() {
        return votes_dem;
    }

    public double getVotes_gop() {
        return votes_gop;
    }

    public double getTotal_votes() {
        return total_votes;
    }

    public double getPer_dem() {
        return per_dem;
    }

    public double getPer_gop() {
        return per_gop;
    }

    public double getPer_point() {
        return per_point;
    }

    public int getDiff() {
        return diff;
    }

    public String getState_abbr() {
        return state_abbr;
    }

    public String getCounty_name() {
        return county_name;
    }

    public int getCombined_fipsl() {
        return combined_fipsl;
    }

    @Override
    public String toString() {
        return "ElectionResults{" +
                "votes_dem=" + votes_dem +
                ", votes_gop=" + votes_gop +
                ", total_votes=" + total_votes +
                ", per_dem=" + per_dem +
                ", per_gop=" + per_gop +
                ", per_point=" + per_point +
                ", diff='" + diff + '\'' +
                ", state_abbr='" + state_abbr + '\'' +
                ", county_name='" + county_name + '\'' +
                ", combined_fipsl=" + combined_fipsl +
                '}';
    }
}
