package ccm.data.entity;


import javax.persistence.*;


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
    @Column(name = "TODAY_DEATH")
    private Integer todayDeath;
    @Column(name = "TODAY_RECOVERED")
    private Integer todayRecovered;
    @Column(name = "TODAY_CRITICAL")
    private Integer todayCritical;
    @Column(name = "TODAY_TEST")
    private Integer todayTest;
    @Column(name = "TIME")
    private String time;
    public int getTodayDeath() {
        return todayDeath;
    }

    public void setTodayDeath(int todayDeath) {
        this.todayDeath = todayDeath;

    }

    public int getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(int todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public int getTodayCritical() {
        return todayCritical;
    }

    public void setTodayCritical(int todayCritical) {
        this.todayCritical = todayCritical;
    }

    public int getTodayTest() {
        return todayTest;
    }

    public void setTodayTest(int todayTest) {
        this.todayTest = todayTest;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


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
