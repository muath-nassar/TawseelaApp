/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.muath.tawseelaapp.yasser.Base;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import com.muath.tawseelaapp.R;
import com.muath.tawseelaapp.yasser.model.Base.ErrorResponse;
import com.muath.tawseelaapp.yasser.repository.Repository;
import com.muath.tawseelaapp.yasser.utils.AppConstants;
import com.muath.tawseelaapp.yasser.utils.NetworkUtils;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.ResponseBody;


/**
 * Created by ibraheem lubbad .
 */

public abstract class BaseViewModel<N> extends AndroidViewModel {

    private static final String TAG = "BaseViewModel";
    private final Repository mDataManager;
    private final MutableLiveData<Boolean> mIsLoading = new MutableLiveData<Boolean>();

   /* public MutableLiveData<SuccessDialog> getmIsLoadingWithMessage() {
        return mIsLoadingWithMessage;
    }

    private final MutableLiveData<SuccessDialog> mIsLoadingWithMessage = new MutableLiveData<SuccessDialog>();
    private final MutableLiveData<SuccessDialog> mSucessDialog = new MutableLiveData<SuccessDialog>();
    private final MutableLiveData<SuccessDialog> mErrorDialog = new MutableLiveData<SuccessDialog>();

    public final MutableLiveData<ErrorResponse> errorResLiveData = new MutableLiveData<ErrorResponse>();*/
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private WeakReference<N> mNavigator;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mDataManager = Repository.getInstance(application.getApplicationContext());
    }

//    public MutableLiveData<ErrorResponse> getErrorResLiveData() {
//        return errorResLiveData;
//    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public Repository getDataManager() {
        return mDataManager;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    /*public MutableLiveData<SuccessDialog> getIsSuccess(){
        return mSucessDialog;
    }
    public MutableLiveData<SuccessDialog> getIsError(){
        return mErrorDialog;
    }
    public void setmSucessIsLoading(boolean isLoading,String message){
        SuccessDialog successDialog = new SuccessDialog();
        successDialog.setShow(isLoading);
        successDialog.setMessage(message);
        mSucessDialog.setValue(successDialog);
    }
    public void setErrorLoding(boolean isLoading,String message){
        SuccessDialog successDialog = new SuccessDialog();
        successDialog.setShow(isLoading);
        successDialog.setMessage(message);
        mErrorDialog.setValue(successDialog);

    }*/

    public void setIsLoading(boolean isLoading) {

        mIsLoading.setValue(isLoading);
    }
   /* public void setIsLoading(boolean isLoading,String message) {
        SuccessDialog successDialog = new SuccessDialog();
        successDialog.setShow(isLoading);
        successDialog.setMessage(message);

        mIsLoadingWithMessage.setValue(successDialog);
    }
*/
    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplication());
    }

    public void showErrorLog(String d) {
        Log.d(TAG, "showErrorLog: " + d);
    }


    public void showSuccessLog(String d) {
        Log.d(TAG, "showSuccessLog: " + d);
    }


    public void parseError(Throwable t, HandelError handelError) {

        if (t instanceof HttpException) {
            ResponseBody body = ((HttpException) t).response().errorBody();


            Log.d(TAG, "body: " + body);

            Gson gson = new Gson();
            TypeAdapter<ErrorResponse> adapter = gson.getAdapter(ErrorResponse.class);
            try {
                ErrorResponse errorParser =
                        adapter.fromJson(body.string());


//                errorResLiveData.postValue(errorParser);
                Log.v("ttt",errorParser.toString());


                if (handelError != null)
                    handelError.showError(errorParser.getMessage());


            } catch (IOException e) {
                showErrorLog(e.getMessage());
                e.printStackTrace();
            }
        } else {
            if (handelError != null)
                handelError.showError(getApplication().getString(R.string.general_error_message));

        }
    }

    private String getErrorMMessages(ArrayList<String> mobile) {

        StringBuilder errMessage = new StringBuilder("\n");

        if (mobile == null || mobile.isEmpty()) return errMessage.toString();

        for (int i = 0; i < mobile.size(); i++) {

            errMessage.append("- ").append(mobile.get(i)).append("\n");


        }
        Log.v("ttt",errMessage.toString());
        return errMessage.toString();

    }

    public String getErrorMMessages(ErrorResponse errorParser) {

        if (errorParser.getErrorsMessages() == null) {
            return errorParser.getMessage();
        }

        String errorMMessages = getErrorMMessages(errorParser.getErrorsMessages().getMobile());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getCountry_code());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getEmail());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getName());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getPassword());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getUsername());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getInteriorIds());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getEquipmentIds());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getSpecificationIds());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getPluginIds());
        errorMMessages += getErrorMMessages(errorParser.getErrorsMessages().getFuel_type_id());

        errorMMessages.trim();

        return errorMMessages;

    }


    public boolean isScuess(String status) {
        return status.equalsIgnoreCase(AppConstants.SUCCESS);
    }


}
