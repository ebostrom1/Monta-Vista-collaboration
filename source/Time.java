import java.util.Objects;

public class Time {
    int year;
    String month;
    public Time(int month, int year){
        if(month == 1) this.month=("January");
        if(month == 2) this.month=("Febuary ");
        if(month == 3) this.month=("March ");
        if(month == 4) this.month=("April ");
        if(month == 5) this.month=("May ");
        if(month == 6) this.month=("June ");
        if(month == 7) this.month=("July ");
        if(month == 8) this.month=("August ");
        if(month == 9) this.month=("September ");
        if(month == 10) this.month=("October ");
        if(month == 11) this.month=("November ");
        if(month == 12) this.month=("December ");
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
        if(month.equals("January")) numMonth = 1;
        if(month.equals("Febuary")) numMonth = 2;
        if(month.equals("March")) numMonth = 3;
        if(month.equals("April")) numMonth = 4;
        if(month.equals("May")) numMonth = 5;
        if(month.equals("June")) numMonth = 6;
        if(month.equals("July")) numMonth = 7;
        if(month.equals("August")) numMonth = 8;
        if(month.equals("September")) numMonth = 9;
        if(month.equals("October")) numMonth = 10;
        if(month.equals("November")) numMonth = 11;
        if(month.equals("December")) numMonth = 12;
        return year*100+ numMonth;
    }

}
