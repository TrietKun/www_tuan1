package com.example.tuan1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "logs")
public class Logs {
    @Id
    private Long id;
    private String account_id;
    private Date login_time;
    private Date logout_time;
    private String note;

    public Logs(Long id, String account_id, Date login_time, Date logout_time, String note) {
        this.id = id;
        this.account_id = account_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.note = note;
    }

    public Logs() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id=" + id +
                ", account_id='" + account_id + '\'' +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", note='" + note + '\'' +
                '}';
    }
}
