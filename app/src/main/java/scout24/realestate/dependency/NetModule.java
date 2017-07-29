package scout24.realestate.dependency;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Singleton
@Module
public class NetModule {

    private final String BASE_URL = "https://private-e618e0-mobiletask2.apiary-mock.com/";

    @Provides
    @Singleton
    Retrofit provideRetroFit(OkHttpClient okHttpClient, JacksonConverterFactory jackson,
                             RxJavaCallAdapterFactory rxFactory) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(jackson)
                .addCallAdapterFactory(rxFactory)
                .build();
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory rxAapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    JacksonConverterFactory getJackSonFactory() {
        return JacksonConverterFactory.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

}
