package scout24.realestate.api;


import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import scout24.realestate.services.EstateService;

public class RestAPIFactory {
    private static final String BASE_URL = "https://private-e618e0-mobiletask2.apiary-mock.com/";

    public EstateService getPropertyService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(EstateService.class);
    }

    @NonNull
    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

}
