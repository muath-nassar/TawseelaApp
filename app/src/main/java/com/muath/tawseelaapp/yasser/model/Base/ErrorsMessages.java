package com.muath.tawseelaapp.yasser.model.Base;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ErrorsMessages implements Parcelable {


    @SerializedName("name")
    @Expose
    private ArrayList<String> name;
    @SerializedName("email")
    @Expose
    private ArrayList<String> email;
    @SerializedName("mobile")
    @Expose
    private ArrayList<String> mobile;
    @SerializedName("country_code")
    @Expose
    private ArrayList<String> country_code;
    @SerializedName("password")
    @Expose
    private ArrayList<String> password;
    @SerializedName("interiorIds")
    @Expose
    private ArrayList<String> interiorIds;
    @SerializedName("equipmentIds")
    @Expose
    private ArrayList<String> equipmentIds;
    @SerializedName("username")
    @Expose
    private ArrayList<String> username;
    @SerializedName("fuel_type_id")
    @Expose
    private ArrayList<String> fuel_type_id;
    @SerializedName("specificationIds")
    @Expose
    private ArrayList<String> specificationIds;
    @SerializedName("pluginIds")
    @Expose
    private ArrayList<String> pluginIds;

    @SerializedName("price")
    @Expose
    private ArrayList<String> price;

    @SerializedName("images")
    @Expose
    private ArrayList<String> images;

    @SerializedName("location")
    @Expose
    private ArrayList<String> location;
    @SerializedName("mileage_number")
    @Expose
    private ArrayList<String> mileage_number;

    public ErrorsMessages() {
    }

    public static Creator<ErrorsMessages> getCREATOR() {
        return CREATOR;
    }

    public ArrayList<String> getFuel_type_id() {
        return fuel_type_id;
    }

    public void setFuel_type_id(ArrayList<String> fuel_type_id) {
        this.fuel_type_id = fuel_type_id;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    public ArrayList<String> getMobile() {
        return mobile;
    }

    public void setMobile(ArrayList<String> mobile) {
        this.mobile = mobile;
    }

    public ArrayList<String> getInteriorIds() {
        return interiorIds;
    }

    public void setInteriorIds(ArrayList<String> interiorIds) {
        this.interiorIds = interiorIds;
    }

    public ArrayList<String> getCountry_code() {
        return country_code;
    }

    public void setCountry_code(ArrayList<String> country_code) {
        this.country_code = country_code;
    }

    public ArrayList<String> getPassword() {
        return password;
    }

    public void setPassword(ArrayList<String> password) {
        this.password = password;
    }

    public ArrayList<String> getEquipmentIds() {
        return equipmentIds;
    }

    public void setEquipmentIds(ArrayList<String> equipmentIds) {
        this.equipmentIds = equipmentIds;
    }

    public ArrayList<String> getUsername() {
        return username;
    }

    public void setUsername(ArrayList<String> username) {
        this.username = username;
    }

    public ArrayList<String> getSpecificationIds() {
        return specificationIds;
    }

    public void setSpecificationIds(ArrayList<String> specificationIds) {
        this.specificationIds = specificationIds;
    }

    public ArrayList<String> getPluginIds() {
        return pluginIds;
    }

    public void setPluginIds(ArrayList<String> pluginIds) {
        this.pluginIds = pluginIds;
    }

    @Override
    public String toString() {
        return "ErrorsMessages{" +
                "name=" + name +
                ", email=" + email +
                ", mobile=" + mobile +
                ", country_code=" + country_code +
                ", password=" + password +
                '}';
    }


    public ArrayList<String> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<String> price) {
        this.price = price;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }


    public ArrayList<String> getMileage_number() {
        return mileage_number;
    }

    public void setMileage_number(ArrayList<String> mileage_number) {
        this.mileage_number = mileage_number;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.name);
        dest.writeStringList(this.email);
        dest.writeStringList(this.mobile);
        dest.writeStringList(this.country_code);
        dest.writeStringList(this.password);
        dest.writeStringList(this.interiorIds);
        dest.writeStringList(this.equipmentIds);
        dest.writeStringList(this.username);
        dest.writeStringList(this.fuel_type_id);
        dest.writeStringList(this.specificationIds);
        dest.writeStringList(this.pluginIds);
        dest.writeStringList(this.price);
        dest.writeStringList(this.images);
        dest.writeStringList(this.location);
        dest.writeStringList(this.mileage_number);
    }

    protected ErrorsMessages(Parcel in) {
        this.name = in.createStringArrayList();
        this.email = in.createStringArrayList();
        this.mobile = in.createStringArrayList();
        this.country_code = in.createStringArrayList();
        this.password = in.createStringArrayList();
        this.interiorIds = in.createStringArrayList();
        this.equipmentIds = in.createStringArrayList();
        this.username = in.createStringArrayList();
        this.fuel_type_id = in.createStringArrayList();
        this.specificationIds = in.createStringArrayList();
        this.pluginIds = in.createStringArrayList();
        this.price = in.createStringArrayList();
        this.images = in.createStringArrayList();
        this.location = in.createStringArrayList();
        this.mileage_number = in.createStringArrayList();
    }

    public static final Creator<ErrorsMessages> CREATOR = new Creator<ErrorsMessages>() {
        @Override
        public ErrorsMessages createFromParcel(Parcel source) {
            return new ErrorsMessages(source);
        }

        @Override
        public ErrorsMessages[] newArray(int size) {
            return new ErrorsMessages[size];
        }
    };
}
