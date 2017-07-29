package scout24.realestate.dependency;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import scout24.realestate.repositories.RealEstateRepo;
import scout24.realestate.services.EstateService;

@Module
public class AppModule {

    private String BASE_URL = "https://private-e618e0-mobiletask2.apiary-mock.com/";

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
    RxJavaCallAdapterFactory rxAapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    JacksonConverterFactory getJackSonFactory() {
        return JacksonConverterFactory.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    EstateService provideEstateService(Retrofit retrofit) {
        return retrofit.create(EstateService.class);
    }

    @Provides
    RealEstateRepo provideRealEsateRepo(EstateService estateService) {
        return new RealEstateRepo(estateService);
    }
}
