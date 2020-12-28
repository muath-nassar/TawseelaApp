package com.muath.tawseelaapp.yasser.repository.network.Rest;


import java.util.ArrayList;

import app.com.coronaapp.model.response.DailyByCountryResponse;
import app.com.coronaapp.model.response.DailyModel;
import app.com.coronaapp.model.response.TotalModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {



/*
    *//**
     * all api are uesed in application
     *//*
    *//**
     * Auth
     *//*


    @FormUrlEncoded
    @POST("login")
    Observable<LoginResponse> userLogin(@Field("country_code") String country_code, @Field("mobile") String email, @Field("password") String password);

    @POST("social-login")
// types : facebook|twitter
    Observable<SoicalLoginResponse> userSoicalLogin(@Field("token") String token, @Field("type") String type);

    @POST("register")
    Observable<BaseResponse> userRegister(@Body RegisterRequest registerRequest);

    @POST("activate")
    Observable<ActiveResponse> userActiveMobile(@Body ActiveRequest activeRequest);

    @GET("general/category")
    Observable<CategoryResponse> getCategories();

    @GET("general/gender")
    Observable<GenderResponse> getGender();

    //get ads in main fragemnt (الرئيسية )
    @GET("ads")
    Observable<MainAdsResponse> getMainAds();

    // للتصفية
    @GET("general/specification")
    Observable<SpecificationResponse> getSpecification();

    @DELETE("ads/{id}")
    Observable<BaseResponse> deleteAds(@Path("id") int adId);

    @POST
    Observable<BaseResponse> storeAd(@Body Ads ads);

    // pages
    @GET("pages/privacy")
    Observable<PrivacyResponse> getPrivacy();

    @GET("pages/settings")
    Observable<SettingResponse> getSettings();

    @GET("pages/about-us")
    Observable<AboutUsResponse> getAboutUs();

    @GET("ads/{id}/show")
    Observable<AdsShowResponse> getShowAds(@Path("id") int adId);

    @GET("general/{id}/subcategory")
    Observable<SubCategoriesResponse> getSubCategory(@Path("id") int id);

    @Multipart
    @POST("ads/upload")
    Observable<UploadImageResponse> uploadImage(@Part("img\"; filename=\"pp.png\" ") RequestBody requestBody);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "ads/image/delete", hasBody = true)
    Observable<BaseResponse> removeImage(@Field("name") String name);

    @POST("ads/store")
    Observable<BaseResponse> postAd(@Body PostAdRequest postAdRequest);

    @GET("ads/own")
    Observable<OwnAdResponse> getOwnAds(@Query("page") int page);

    @GET("ads/statistics")
    Observable<StaticsResponse> getStatisticsResponse();

    @PATCH("ads/{id}")
    Observable<BaseResponse> editAds(@Body PostAdRequest postAdRequest, @Path("id") int id);

    *//*
        @POST("user/profile")
        Observable<EditProfileResponse> editProfile(@Body EditProfileRequest editProfileRequest);
    *//*
    @Multipart
    @POST("user/profile")
    Observable<EditProfileResponse> editProfile(@Part("img\"; filename=\"pp.png\"") RequestBody requestBody, @Part("name") RequestBody name, @Part("email") RequestBody email, @Part("mobile") RequestBody mobile, @Part("gender_id") RequestBody gender_id);

    @GET("ads/suggested")
    Observable<AdCategoryResponse> getSuggestedAd(@Query("page") int page);

    @GET("ads/most-watch")
    Observable<AdCategoryResponse> getMostWatchAd(@Query("page") int page);

    @GET("ads/latest")
    Observable<AdCategoryResponse> getLatestAd(@Query("page") int page);

    @GET("ads/latest")
    Observable<AdCategoryResponse> getAdByCategoryId(@Query("category_id") int category_id, @Query("page") int page);

    @POST("pages/contact-us")
    Observable<BaseResponse> getContact(@Body ContactRequest contactRequest);

    @PATCH("password")
    Observable<BaseResponse> changePassword(@Body PasswordRequest passwordRequest);

    @GET("general/specification")
    Observable<SpecificationResponse> getSpecification(@Query("category_id") int category_id);

    @FormUrlEncoded
    @POST("activation/resend")
    Observable<BaseResponse> resendActivation(@Field("mobile") String mobile, @Field("country_code") String country_code);

    @GET("logout")
    Observable<BaseResponse> logout();

    @GET("user/notifications")
    Observable<NotificationResponse> getNotification(@Query("page") int page);

    @POST("password/forget")
    Observable<BaseResponse> forgetPassword(@Body ForgetPasswordRequest forgetPasswordRequest);

//    @HTTP(method = "GET", path = "ads/search", hasBody = true)
    @GET("ads/search")
    Observable<OwnAdResponse> getFilterableAds(@Query("page") int page, @Query("title") String title, @Query("category_id") int category_id, @Query("specificationIds") String specificationIds);

    @GET("general/{id}/features")
    Observable<FeatureResponse> getFeatures(@Path("id") int categoryId);

    @GET("general/{id}/subFeatures")
    Observable<FeatureResponse> getSubFeature(@Path("id") int specifcationId);*/

    @GET("totals")
    Observable<ArrayList<TotalModel>> getTotal();

    @GET("report/totals")
    Observable<ArrayList<DailyModel>> getDaily(@Query("date") String date);

    @GET("country/code")
    Observable<ArrayList<TotalModel>> getTotalByCountryCode(@Query("code") String code);

    @GET("report/country/code")
    Observable<ArrayList<DailyByCountryResponse>> getDailyByCountryCode(@Query("code") String code, @Query("date") String date);
}
