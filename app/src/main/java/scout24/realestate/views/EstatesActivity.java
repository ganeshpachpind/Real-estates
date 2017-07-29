package scout24.realestate.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import scout24.realestate.EstateApplication;
import scout24.realestate.R;
import scout24.realestate.databinding.ActivityEstatesBinding;
import scout24.realestate.dependency.AppComponent;
import scout24.realestate.dependency.DaggerEstateComponent;
import scout24.realestate.dependency.EstateComponent;
import scout24.realestate.dependency.EstateModule;
import scout24.realestate.model.Estate;
import scout24.realestate.repositories.RealEstateRepo;
import scout24.realestate.views.adapters.EstateAdapter;
import scout24.realestate.views.model.EstateActivityViewModel;

public class EstatesActivity extends AppCompatActivity implements EstateActivityView {

    private ActivityEstatesBinding binding;

    @Inject
    RealEstateRepo realEstateRepo;

    @Inject
    EstateActivityViewModel estateActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_estates);

        AppComponent appComponent =
                ((EstateApplication) getApplication()).getAppComponent();
        EstateComponent estateComponent = DaggerEstateComponent.builder()
                .estateModule(new EstateModule(this))
                .appComponent(appComponent)
                .build();
        estateComponent.inject(this);

        estateActivityViewModel.getEstates();
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void populateEstateList(List<Estate> estates) {
        binding.estateList.setLayoutManager(new LinearLayoutManager(this));
        binding.estateList.setAdapter(new EstateAdapter(estates));
    }

    @Override
    protected void onDestroy() {
        estateActivityViewModel.onDestroy();
        super.onDestroy();
    }
}
