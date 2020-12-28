package com.muath.tawseelaapp.yasser.ui.ui.adapter;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.muath.tawseelaapp.yasser.Base.BaseViewModel;
import com.muath.tawseelaapp.yasser.model.Overview;
import com.muath.tawseelaapp.yasser.model.User;
import com.muath.tawseelaapp.yasser.model.response.DailyModel;
import com.muath.tawseelaapp.yasser.model.response.TotalModel;
import com.muath.tawseelaapp.yasser.navigation.HomeNavigator;
import com.muath.tawseelaapp.yasser.repository.local.Session;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;



public class MainMV extends BaseViewModel<HomeNavigator> {
    private FirebaseFirestore firebaseFirestore;
    private MutableLiveData<DailyModel> dailyModelMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Overview> overviewMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Overview> getOverviewMutableLiveData() {
        return overviewMutableLiveData;
    }

    public MutableLiveData<DailyModel> getDailyModelMutableLiveData() {
        return dailyModelMutableLiveData;
    }

    public MutableLiveData<TotalModel> getTotalModelMutableLiveData() {
        return totalModelMutableLiveData;
    }

    private MutableLiveData<TotalModel> totalModelMutableLiveData = new MutableLiveData<>();

    public MainMV(@NonNull Application application) {
        super(application);
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();

        firebaseFirestore.collection("users").get().addOnSuccessListener(queryDocumentSnapshots -> {
            List<DocumentSnapshot> documents = queryDocumentSnapshots.getDocuments();
            Toast.makeText(getApplication(), "" + documents.size(), Toast.LENGTH_SHORT).show();
            for (DocumentSnapshot d : documents) {
                User user = d.toObject(User.class);
                Log.v("ttt", user.toString());
                if (!(user.getId() == Session.getInstance(getApplication()).getLocalSave().userProfile().getId()))
                    userList.add(user);
                getNavigator().userSuccessFul();
            }
        });
        Toast.makeText(getApplication(), "done", Toast.LENGTH_SHORT).show();
        return userList;

    }

    public void getTotal() {
        setIsLoading(true);
        getCompositeDisposable().add(
                getDataManager().getTotals().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(totalModel -> {
                            setIsLoading(false);
                            //getTotalModelMutableLiveData().postValue(totalModel.get(0)));
                        }, throwable -> {
                            setIsLoading(false);
//                            Toast.makeText(getApplication(),    "حدث خطأ ما يرجى المحاولة مرة أخرى لاحقا", Toast.LENGTH_SHORT).show();
                            Log.v("ttt", throwable.getLocalizedMessage());
                        })
        );
    }

    public void getDaily(String date) {
        setIsLoading(true);
        getCompositeDisposable().add(
                getDataManager().getDaily(date).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(totalModel -> {
                            setIsLoading(false);
                            //getDailyModelMutableLiveData().postValue(totalModel.get(0));
                        }, throwable -> {
                            setIsLoading(false);
                            //Toast.makeText(getApplication(), "حدث خطأ ما يرجى المحاولة مرة أخرى لاحقا", Toast.LENGTH_SHORT).show();
                            Log.v("ttt", throwable.getLocalizedMessage());

                        })
        );
    }

    public void getDailyByCountryCode(String countryCode, String date) {
        setIsLoading(true);
        getCompositeDisposable().add(
                getDataManager().getDailyByCountryCode(countryCode, date).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(totalModel -> {
                            setIsLoading(false);
                            //getDailyModelMutableLiveData().postValue(totalModel.get(0));
                        }, throwable -> {
                            setIsLoading(false);
                            Toast.makeText(getApplication(), "حدث خطأ ما يرجى المحاولة مرة أخرى لاحقا", Toast.LENGTH_SHORT).show();
                            Log.v("ttt", throwable.getLocalizedMessage());

                        })
        );
    }
    public void getTotalByCountryCode(String CountryCode){
        setIsLoading(true);
        getCompositeDisposable().add(
                getDataManager().getTotalByCountryCode(CountryCode).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(totalModel -> {
                            setIsLoading(false);
                            //getTotalModelMutableLiveData().postValue(totalModel.get(0));
                        }, throwable -> {
                            setIsLoading(false);
//                            Toast.makeText(getApplication(),    "حدث خطأ ما يرجى المحاولة مرة أخرى لاحقا", Toast.LENGTH_SHORT).show();
                            Log.v("ttt", throwable.getLocalizedMessage());
                        })
        );
    }
    public void getOverviewData(){
        setIsLoading(true);
        firebaseFirestore.collection("overview").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                setIsLoading(false);
                Overview overview =queryDocumentSnapshots.getDocuments().get(0).toObject(Overview.class);
                getOverviewMutableLiveData().postValue(overview);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                setIsLoading(false);
            }
        });

    }
}
