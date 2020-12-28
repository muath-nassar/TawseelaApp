package com.muath.tawseelaapp.yasser.repository;

import android.content.Context;

import java.util.ArrayList;

import app.com.coronaapp.model.response.DailyByCountryResponse;
import app.com.coronaapp.model.response.DailyModel;
import app.com.coronaapp.model.response.TotalModel;
import app.com.coronaapp.repository.network.Rest.ApiClient;
import app.com.coronaapp.repository.network.Rest.ApiInterface;
import io.reactivex.Observable;

public class Repository {

    private static final String TAG = "Repository";
    private static Repository instance;
    private static ApiInterface apiClient;
    Context mContext;

    public Repository(Context context) {

        mContext = context;

        apiClient = ApiClient.getApiClient(context);


    }

    public static synchronized Repository getInstance(Context context) {
        if (instance == null) {
            instance = new Repository(context);
        }
        return instance;
    }

    public Observable<ArrayList<TotalModel>> getTotals(){
        return apiClient.getTotal();
    }
    public Observable<ArrayList<DailyModel>> getDaily(String date){
        return apiClient.getDaily(date);
    }
    public Observable<ArrayList<TotalModel>> getTotalByCountryCode(String countryCode){
        return apiClient.getTotalByCountryCode(countryCode);
    }
    public Observable<ArrayList<DailyByCountryResponse>> getDailyByCountryCode(String countryCode, String date){
        return apiClient.getDailyByCountryCode(countryCode,date);
    }
/*
    public Observable<BaseResponse> registerUser(RegisterRequest registerRequest) {
        return apiClient.userRegister(registerRequest)
                .doOnError(Throwable::printStackTrace);
    }

    public Observable<ActiveResponse> userActiveRequest(ActiveRequest activeRequest) {
        return apiClient.userActiveMobile(activeRequest).doOnError(Throwable::printStackTrace);
    }

    public Observable<CategoryResponse> getCategories() {
        return apiClient.getCategories().doOnError(Throwable::printStackTrace);
    }

    public Observable<MainAdsResponse> getAllAds() {
        return apiClient.getMainAds().doOnError(Throwable::printStackTrace);
    }

    public Observable<AdsShowResponse> getShowAds(int id) {
        return apiClient.getShowAds(id).doOnError(Throwable::printStackTrace);
    }

    public Observable<SubCategoriesResponse> getSubCategory(int id) {
        return apiClient.getSubCategory(id).doOnError(Throwable::printStackTrace);
    }

    public Observable<UploadImageResponse> uploadImageResponseObservable(RequestBody requestBody) {
        return apiClient.uploadImage(requestBody).doOnError(Throwable::printStackTrace);
    }

    public Observable<BaseResponse> postAd(PostAdRequest postAdRequest) {
        return apiClient.postAd(postAdRequest).doOnError(Throwable::printStackTrace);
    }

    public Observable<BaseResponse> removeImage(String name) {
        return apiClient.removeImage(name).doOnError(Throwable::printStackTrace);
    }

    public Observable<OwnAdResponse> getOwnResponse(int page) {
        return apiClient.getOwnAds(page).doOnError(Throwable::printStackTrace);
    }

    public Observable<BaseResponse> deleteAds(int id) {
        return apiClient.deleteAds(id).doOnError(Throwable::printStackTrace);
    }

    public Observable<StaticsResponse> getStatistics() {
        return apiClient.getStatisticsResponse().doOnError(Throwable::printStackTrace);
    }

    public Observable<BaseResponse> editAd(PostAdRequest postAdRequest, int id) {
        return apiClient.editAds(postAdRequest, id).doOnError(Throwable::printStackTrace);
    }

    public Observable<EditProfileResponse> editProfile(RequestBody requestBody, RequestBody name, RequestBody email, RequestBody mobile, RequestBody gender_id) {
        return apiClient.editProfile(requestBody, name, email, mobile, gender_id).doOnError(Throwable::printStackTrace);
    }

    public Observable<AdCategoryResponse> getLatsesAd(int page) {
        return apiClient.getLatestAd(page).doOnError(Throwable::printStackTrace);
    }

    public Observable<AdCategoryResponse> getMostShowAd(int page) {
        return apiClient.getMostWatchAd(page).doOnError(Throwable::printStackTrace);
    }

    public Observable<AdCategoryResponse> getSuggestAd(int page) {
        return apiClient.getSuggestedAd(page).doOnError(Throwable::printStackTrace);
    }

    public Observable<AdCategoryResponse> getAdsByCategoryId(int category_id, int page) {
        return apiClient.getAdByCategoryId(category_id, page).doOnError(Throwable::printStackTrace);
    }

    ;

    public Observable<BaseResponse> postContact(ContactRequest contactRequest) {
        return apiClient.getContact(contactRequest).doOnError(Throwable::printStackTrace);
    }

    ;

    public Observable<AboutUsResponse> getAboutUs() {
        return apiClient.getAboutUs().doOnError(Throwable::printStackTrace);
    }

    public Observable<PrivacyResponse> getPrivacy() {
        return apiClient.getPrivacy().doOnError(Throwable::printStackTrace);
    }

    public Observable<BaseResponse> changePassword(PasswordRequest passwordRequest) {
        return apiClient.changePassword(passwordRequest).doOnError(Throwable::printStackTrace);
    }

    public Observable<SpecificationResponse> getSpecification(int categoryId) {
        return apiClient.getSpecification(categoryId).doOnError(Throwable::printStackTrace);
    }

    public Observable<BaseResponse> resendActivate(String mobile, String code_country) {
        return apiClient.resendActivation(mobile, code_country).doOnError(Throwable::printStackTrace);
    }

    public Observable<BaseResponse> logout() {
        return apiClient.logout().doOnError(Throwable::printStackTrace);
    }

    public Observable<NotificationResponse> getNotification(int page) {
        return apiClient.getNotification(page).doOnError(Throwable::printStackTrace);
    }

    public Observable<SoicalLoginResponse> userSoicalLogin(String token, String type) {
        return apiClient.userSoicalLogin(token, type).doOnError(Throwable::printStackTrace);
    }
    public Observable<BaseResponse>  forgetPassword(ForgetPasswordRequest forgetPasswordRequest){
        return apiClient.forgetPassword(forgetPasswordRequest).doOnError(Throwable::printStackTrace);
    }
    public Observable<OwnAdResponse> getFiltarbleAds(FilterRequest filterRequest){
        return apiClient.getFilterableAds(filterRequest.getPage(),filterRequest.getTitle(),filterRequest.getCategory_id(),filterRequest.getSpecificationIds().toString());
    };
    public Observable<FeatureResponse> getFeatures(int id){
        return apiClient.getFeatures(id);
    }
    public Observable<FeatureResponse> getSubFeatures(int id){
        return apiClient.getSubFeature(id);
    }*/

}
