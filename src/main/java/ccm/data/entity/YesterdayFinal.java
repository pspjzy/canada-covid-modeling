package ccm.data.entity;

import javax.persistence.*;

@Entity
@Table(name="YESTERDAYFINAL")
public class YesterdayFinal {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Column(name = "DAILYDEATHS")
    private int dailyDeaths;
    @Column(name = "DAILYRECOVERED")
    private int dailyRecovered;
    @Column(name = "DAILYCRITICAL")
    private int dailyCritical;
    @Column(name = "DAILYTESTS")
    private int dailyTests;
    @Column(name = "DATE")
    private String date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDailyDeaths() {
        return dailyDeaths;
    }

    public void setDailyDeaths(int dailyDeaths) {
        this.dailyDeaths = dailyDeaths;
    }

    public int getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(int dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public int getDailyCritical() {
        return dailyCritical;
    }

    public void setDailyCritical(int dailyCritical) {
        this.dailyCritical = dailyCritical;
    }

    public int getDailyTests() {
        return dailyTests;
    }

    public void setDailyTests(int dailyTests) {
        this.dailyTests = dailyTests;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
