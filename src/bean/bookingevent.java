package bean;

import java.util.Date;

public class bookingevent {
    private int id;
    private User user;
    private int iid;
    private Date startTime;
    private Date endTime;
    private String comment;

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

    public int getIid() {
        return iid;
    }

    public String getComment() {
        return comment;
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

    public void setIid(int iid) {
        this.iid = iid;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
