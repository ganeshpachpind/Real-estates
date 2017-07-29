package scout24.realestate.dependency;


import javax.inject.Singleton;

import dagger.Component;
import scout24.realestate.views.EstatesActivity;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(EstatesActivity activity);
}
