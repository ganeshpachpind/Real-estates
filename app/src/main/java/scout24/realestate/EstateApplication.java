package scout24.realestate;


import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import scout24.realestate.dependency.AppComponent;
import scout24.realestate.dependency.DaggerAppComponent;

public class EstateApplication extends Application {

    // Application life cycle
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
