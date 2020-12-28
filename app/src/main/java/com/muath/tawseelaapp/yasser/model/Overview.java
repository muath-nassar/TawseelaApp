package com.muath.tawseelaapp.yasser.model;

public class Overview {
    private String Syndrome;
    private String Syndrome_img;
    private String protection;
    private String protection_img;
    private String transition;
    private String transition_img;
    private String video;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getProtection() {
        return protection;
    }

    public String getTransition() {
        return transition;
    }

    public void setTransition(String transition) {
        this.transition = transition;
    }

    public String getTransition_img() {
        return transition_img;
    }

    public void setTransition_img(String transition_img) {
        this.transition_img = transition_img;
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }

    public String getProtection_img() {
        return protection_img;
    }

    public void setProtection_img(String protection_img) {
        this.protection_img = protection_img;
    }

    public String getSyndrome() {
        return Syndrome;
    }

    public void setSyndrome(String syndrome) {
        Syndrome = syndrome;
    }

    public String getSyndrome_img() {
        return Syndrome_img;
    }

    public void setSyndrome_img(String syndrome_img) {
        Syndrome_img = syndrome_img;
    }

}
