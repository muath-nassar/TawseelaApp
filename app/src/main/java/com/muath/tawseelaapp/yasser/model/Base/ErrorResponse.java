package com.muath.tawseelaapp.yasser.model.Base;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorResponse extends BaseResponse implements Parcelable {

    public static final Creator<ErrorResponse> CREATOR = new Creator<ErrorResponse>() {
        @Override
        public ErrorResponse createFromParcel(Parcel source) {
            return new ErrorResponse(source);
        }

        @Override
        public ErrorResponse[] newArray(int size) {
            return new ErrorResponse[size];
        }
    };
    @SerializedName("data")
    @Expose
    private ErrorsMessages errorsMessages;

    public ErrorResponse() {
    }

    protected ErrorResponse(Parcel in) {
        this.errorsMessages = in.readParcelable(ErrorsMessages.class.getClassLoader());
    }

    public ErrorsMessages getErrorsMessages() {
        return errorsMessages;
    }

    public void setErrorsMessages(ErrorsMessages errorsMessages) {
        this.errorsMessages = errorsMessages;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorsMessages=" + errorsMessages +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.errorsMessages, flags);
    }
}
