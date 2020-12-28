package com.muath.tawseelaapp.yasser.model;

public class Message {
    private int id;
    private String message;
    private int sender_id;
    private int des_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getDes_id() {
        return des_id;
    }

    public void setDes_id(int des_id) {
        this.des_id = des_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

}
