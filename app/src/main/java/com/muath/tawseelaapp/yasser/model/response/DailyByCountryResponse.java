package com.muath.tawseelaapp.yasser.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DailyByCountryResponse {
    public ArrayList<DailyModel> getDailyModels() {
        return DailyModels;
    }

    public void setDailyModels(ArrayList<DailyModel> DailyModels) {
        this.DailyModels = DailyModels;
    }

    @SerializedName("provinces")
    @Expose
    private ArrayList<DailyModel> DailyModels;

}
