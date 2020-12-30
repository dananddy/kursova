package kpi.faculty.domain;

import sun.util.calendar.BaseCalendar;

import java.util.Date;

public class Course {
    private int id;
    private Date date_created;
    private Date date_finished;
    private String theme;
    private String description;
    private int teacherId;
    private String nullDate_finished;

    public String getNullDate_finished() {
        return nullDate_finished;
    }

    public void setNullDate_finished(String nullDate_finished) {
        this.nullDate_finished = nullDate_finished;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_finished() {
        return date_finished;
    }

    public void setDate_finished(Date date_finished) {
        this.date_finished = date_finished;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
