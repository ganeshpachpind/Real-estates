package scout24.realestate.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import scout24.realestate.R;
import scout24.realestate.api.RestAPIFactory;
import scout24.realestate.databinding.ActivityEstatesBinding;
import scout24.realestate.model.Estate;
import scout24.realestate.repositories.RealEstateRepo;
import scout24.realestate.views.model.EstateActivityViewModel;

public class EstatesActivity extends AppCompatActivity implements EstateActivityView {

    private ActivityEstatesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_estates);

        //TODO - Setup dagger dependency injection
        RealEstateRepo realEstateRepo = new RealEstateRepo(new RestAPIFactory());
        EstateActivityViewModel estateActivityViewModel = new EstateActivityViewModel(realEstateRepo, this);
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
}
