package test.data.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="DATAMODEL")
public class DataModel {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Column(name = "CASES")
    private int cases;
    @Column(name = "TODAYS_CASE")
    private int todayCases;
    @Column(name = "DEATHS")
    private int deaths;
    @Column(name = "RECOVERED")
    private int recovered;
    @Column(name = "CRITICAL")
    private int critical;
    @Column(name = "TESTS")
    private int tests;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Column(name = "TIME")
    private Timestamp time;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }





}
