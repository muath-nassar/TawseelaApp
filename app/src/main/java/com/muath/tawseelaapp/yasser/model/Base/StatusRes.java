package com.muath.tawseelaapp.yasser.model.Base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusRes {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("code")
    @Expose
    public int code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StatusRes{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
