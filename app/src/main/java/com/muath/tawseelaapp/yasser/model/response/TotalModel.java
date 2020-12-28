package com.muath.tawseelaapp.yasser.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalModel {

    @SerializedName("confirmed")
    @Expose
    private int confirmed;

    @SerializedName("recovered")
    @Expose
    private int recovered;

    @SerializedName("critical")
    @Expose
    private int critical;

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

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
