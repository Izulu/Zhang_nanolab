package bean;

import java.util.Date;

public class bookingevent {
    private int id;
    private User user;
    private Instrument instrument;
    private Date startTime;
    private Date endTime;

    public int getId() {
        return id;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public User getUser() {
        return user;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
