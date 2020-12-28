package com.muath.tawseelaapp.yasser.model.response;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class DailyResponse {

    @Expose
    private ArrayList<DailyModel> dailyModels;

    public ArrayList<DailyModel> getDailyModels() {
        return dailyModels;
    }

    public void setDailyModels(ArrayList<DailyModel> dailyModels) {
        this.dailyModels = dailyModels;
    }
}
