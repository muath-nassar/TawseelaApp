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

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.basgeekball.awesomevalidation.ValidationStyle;
import com.muath.tawseelaapp.yasser.utils.CommonUtils;
import com.muath.tawseelaapp.yasser.utils.NetworkUtils;
import com.muath.tawseelaapp.yasser.utils.Validator;

import cn.pedant.SweetAlert.SweetAlertDialog;



public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity
        implements BaseFragment.Callback {

    private static final String TAG = "BaseActivity";
    // TODO
    // this can probably depend on isLoading variable of BaseViewModel,
    // since its going to be common for all the activities
    private SweetAlertDialog mProgressDialog;
    private SweetAlertDialog mSuccessDialog;
    private SweetAlertDialog mErrorDialog;
    private T mViewDataBinding;
    Validator validator;
    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    private V mViewModel;

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();


    public abstract int getBindingVariable();

    public abstract void initItems();
    public abstract void initClicks();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeLangauge();
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());

        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;

        if (mViewModel != null) {
            mViewDataBinding.setVariable(getBindingVariable(), mViewModel);

            mViewDataBinding.executePendingBindings();
            String message = "";

            mViewModel.getIsLoading().observe(this, this::consumeResponse);
/*
            mViewModel.getIsSuccess().observe(this,this::consumeSuccessResponse);
            mViewModel.getIsError().observe(this,this::consumeErrorResponse);
            mViewModel.getmIsLoadingWithMessage().observe(this,this::consumeIsLoading);
*/

        }
        validator = new Validator(this, ValidationStyle.UNDERLABEL);

        initItems();
        initClicks();

    }

  /*  private void consumeSuccessResponse(Object o) {
        if (o instanceof SuccessDialog) {
            if (((SuccessDialog) o).isShow()) {
                showSuccess(((SuccessDialog) o).getMessage());
            } else {
                hideSuccessDialog();
            }
        }
    }
    private void consumeIsLoading(Object o) {
        if (o instanceof SuccessDialog) {
            if (((SuccessDialog) o).isShow()) {
                showLoding(((SuccessDialog) o).getMessage());
            } else {
                hideLoading();
            }
        }
    }
    private void consumeErrorResponse(Object o){
        if (o instanceof SuccessDialog) {
            if (((SuccessDialog) o).isShow()) {
                showError(((SuccessDialog) o).getMessage());
            } else {
                hideErrorDialog();
            }
        }
    }*/


    private void changeLangauge() {


        CommonUtils.changeLocale(this);
    }


    public void changeValidationStyle() {
        validator = new Validator(this, ValidationStyle.UNDERLABEL);

    }

    protected Validator getValidator() {

        return validator;
    }


    private void consumeResponse(Object o) {
        Log.d(TAG, "consumeResponse: " + o);

        if (o instanceof Boolean) {
            if ((Boolean) o) {
                showLoading();
            } else {

                hideLoading();
            }
        }
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public void hideLoading() {
        Log.d(TAG, "hideLoading: ");
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }
    public void hideSuccessDialog(){
        if(mSuccessDialog!=null&&mProgressDialog.isShowing()){
            mSuccessDialog.cancel();
        }
    }
    public void hideErrorDialog(){
        if(mSuccessDialog!=null&&mProgressDialog.isShowing()){
            mSuccessDialog.cancel();
        }
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    public void showLoading() {
        Log.d(TAG, "showLoading: ");
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }
    public void showLoding(String message){
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this,message);
    }
    public void showSuccess(String string){
        hideSuccessDialog();
        mSuccessDialog = CommonUtils.showSuccessDialog(this,string);
    }
    public void showError(String string){
        hideErrorDialog();
        mErrorDialog = CommonUtils.showErrorDialog(this,string);
    }

    protected boolean isDataValid() {
        return validator.isValid();
    }


}

