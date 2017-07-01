package scout24.realestate.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import rx.Observer;
import scout24.realestate.R;
import scout24.realestate.api.RestAPIFactory;
import scout24.realestate.databinding.ActivityEstatesBinding;
import scout24.realestate.model.EstateList;
import scout24.realestate.repositories.RealEstateRepo;

public class EstatesActivity extends AppCompatActivity implements Observer<EstateList> {

    private ActivityEstatesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_estates);

        RealEstateRepo realEstateRepo = new RealEstateRepo(new RestAPIFactory());
        realEstateRepo.getEstates(this);
    }

    @Override
    public void onCompleted() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(Throwable e) {
        binding.progressBar.setVisibility(View.GONE);
        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNext(EstateList estateList) {
        binding.estateList.setLayoutManager(new LinearLayoutManager(this));
        binding.estateList.setAdapter(new EstateAdapter(estateList.getEstates()));
    }
}
