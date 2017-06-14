package shantanu.summertraining;

/**
 * Created by SHAAN on 13-06-17.
 */

public class Course {
    private int cid;
    private String title;
    private int hours;
    private int price;

    public Course(int cid, String title, int price, int hours) {
        this.cid = cid;
        this.title = title;
        this.hours = hours;
        this.price = price;
    }

    public Course(String title, int price, int hours) {
        this.title = title;
        this.hours = hours;
        this.price = price;
    }

    public Course() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}