package com.muath.tawseelaapp.yasser.repository.local;

import android.content.Context;

import com.muath.tawseelaapp.yasser.repository.local.prefs.LocalSave;


public class Session {
    private static Session instance = null;
    private static LocalSave localSave = null;

    private Context mContext;


    private Session(Context mContext) {
        this.mContext = mContext;
    }

    public static Session getInstance(Context context) {
        if (instance == null) {
            instance = new Session(context);
            localSave = LocalSave.getInstance(context);

        }
        return instance;
    }

    public LocalSave getLocalSave() {
        return localSave;
    }

    private Context getmContext() {
        return mContext;
    }


    public String getCurrentUserToken()
    {
/*
        getLocalSave().setLoginAsGuest(false);
        return  "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjhhMDc5YTY5YjUxMmIzYWI4ZTVmN2FkNDdkZDViNjBiNzkxYWVmOTJkN2ZjNWE5NWI0M2IyODQxMDVhNmY1NDFhMGU5NWE4YTlhMGMwODgzIn0.eyJhdWQiOiI1IiwianRpIjoiOGEwNzlhNjliNTEyYjNhYjhlNWY3YWQ0N2RkNWI2MGI3OTFhZWY5MmQ3ZmM1YTk1YjQzYjI4NDEwNWE2ZjU0MWEwZTk1YThhOWEwYzA4ODMiLCJpYXQiOjE1ODI4OTIzMjQsIm5iZiI6MTU4Mjg5MjMyNCwiZXhwIjoxNjE0NTE0NzI0LCJzdWIiOiIxMDkiLCJzY29wZXMiOltdfQ.IjBkCLIZS6h9F-eKo203iyb3s-tsIIMBJxVbJSmibxN1Ey128pZMdCFipvQncwxVdkdqrruSNKJJaPSwfTwnK4T1ZV6Gs1DuOW0AaHq3-4ppP3_uUIJs7S_3ENPpXVS71gNjxu785Qc13gvUt1-ErlwKlZudhI10_kolIeAfA-qEBZFmodeEA201OjktVqRE2MPAoMloJ5OdrojeMVJ6OOawyNCE6TnNwZoYB3CgDYA_ZfNdJ3ysoBsP8FA_EMmr_6Rxgn8D_dJsfhjs0WADgOO3OoRSw_kyh9uin_LQst85z4kRnRLPYNQ0I24rZysvs_xKgVxubB1fGYF_ebXWHQhhqtCW0KLkuiFI5jS2hZOgb5QG-Imqzk2G4fTHtHCpn-RDG4KNqzPVfkZVN7RIcAcPy1IJk_Ave2b2egqj751vvkR9NqeMXazdwin3wBEwuCKXgmT-h25s9pU1HRgMmV6Qaa_oJly1Rg0NtdHvvpRhIpUEU0YPNP1Y9uRmH3OFtYSgxhnnKnuXtkXCpWYLackyKaFQ2Q5bRf56JX9GZ68VVBRyOZMPEeyLSPWGNAFb4PInNdNI47Cn0NQFJgvOVNuijyxh24LHx3HBl2n90P8aQ8okKnNGE_VGfNdels_EHfui5AAuLTN8ryUjZDhXA3UG4I_2rA749s9kj73vrvo";
*/
        return getLocalSave().getUserToken();
    }



    public void clear() {
        localSave.clear();
    }
}
