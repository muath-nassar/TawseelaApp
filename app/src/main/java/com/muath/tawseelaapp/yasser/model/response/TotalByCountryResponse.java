package com.muath.tawseelaapp.yasser.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TotalByCountryResponse {
    public ArrayList<TotalModel> getTotalModels() {
        return totalModels;
    }

    public void setTotalModels(ArrayList<TotalModel> totalModels) {
        this.totalModels = totalModels;
    }

    @SerializedName("provinces")
    @Expose
    private ArrayList<TotalModel> totalModels;
}
