package scout24.realestate;


import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class EstateApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
