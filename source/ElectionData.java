public class ElectionData implements Data{
    private double votes_dem, votes_gop,total_votes,per_dem,per_gop, per_point;
    private String state,county;
    private int diff, combined_fipsl;

    public ElectionData(String[] fields) {
        this.county = fields[10];
        this.state = fields[9];
        this.votes_dem = Double.parseDouble(fields[1]);
        this.votes_gop = Double.parseDouble(fields[2]);
        this.total_votes = Double.parseDouble(fields[3]);
    }

    @Override
    public Object getSubClass() {
        return this;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
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

    public int getCombined_fipsl() {
        return combined_fipsl;
    }

    @Override
    public String toString() {
        return "ElectionData{" +
                "votes_dem=" + votes_dem +
                ", votes_gop=" + votes_gop +
                ", total_votes=" + total_votes +
                ", per_dem=" + per_dem +
                ", per_gop=" + per_gop +
                ", per_point=" + per_point +
                ", diff='" + diff + '\'' +
                ", state_abbr='" + state + '\'' +
                ", county_name='" + county + '\'' +
                ", combined_fipsl=" + combined_fipsl +
                '}';
    }
}
