package com.muath.tawseelaapp.yasser.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyModel {
    @SerializedName("confirmed")
    @Expose
    private int confirmed;

    @SerializedName("recovered")
    @Expose
    private int recovered;

    @SerializedName("active")
    @Expose
    private int active;

    @SerializedName("deaths")
    @Expose
    private int deaths;

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
