package model.dto;

import java.sql.Date;

public class UserDate {
    private Date date;

    public UserDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
