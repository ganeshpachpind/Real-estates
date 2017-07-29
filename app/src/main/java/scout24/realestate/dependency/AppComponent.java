package scout24.realestate.dependency;


import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {
    // downstream dependency
    Retrofit getRetrofit();
}
