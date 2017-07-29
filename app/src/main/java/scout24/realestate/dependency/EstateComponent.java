package scout24.realestate.dependency;


import dagger.Component;
import scout24.realestate.views.EstatesActivity;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = EstateModule.class)
public interface EstateComponent {
    void inject(EstatesActivity activity);
}
