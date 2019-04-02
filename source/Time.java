import java.util.Objects;

public class Time {
    private int year;
    private String month;
    public Time(int month, int year){
        if(month == 1) this.month=("Jan");
        if(month == 2) this.month=("Feb");
        if(month == 3) this.month=("Mar");
        if(month == 4) this.month=("Apr");
        if(month == 5) this.month=("May");
        if(month == 6) this.month=("Jun");
        if(month == 7) this.month=("Jul");
        if(month == 8) this.month=("Aug");
        if(month == 9) this.month=("Sep");
        if(month == 10) this.month=("Oct");
        if(month == 11) this.month=("Nov");
        if(month == 12) this.month=("Dec");
        this.year = year;
    }
    public Time(String month, int year){
        this.month = month;
        this.year = year;
    }
    public Time(){
        this.year = 2020;
        this.month = "January";
    }

    @Override
    public String toString() {
        return "Time{" +
                "year=" + year +
                ", month='" + month + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return year == time.year &&
                Objects.equals(month, time.month);
    }
    public int comparableTime(){
        int numMonth =0;
        if(month.equals("Jan")) numMonth = 1;
        if(month.equals("Feb")) numMonth = 2;
        if(month.equals("Mar")) numMonth = 3;
        if(month.equals("Apr")) numMonth = 4;
        if(month.equals("May")) numMonth = 5;
        if(month.equals("Jun")) numMonth = 6;
        if(month.equals("Jul")) numMonth = 7;
        if(month.equals("Aug")) numMonth = 8;
        if(month.equals("Sep")) numMonth = 9;
        if(month.equals("Oct")) numMonth = 10;
        if(month.equals("Nov")) numMonth = 11;
        if(month.equals("Dec")) numMonth = 12;
        return year*100+ numMonth;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }
}
