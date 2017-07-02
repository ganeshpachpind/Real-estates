package scout24.realestate.views.model;


import rx.Observer;
import scout24.realestate.model.EstateList;
import scout24.realestate.repositories.RealEstateRepo;
import scout24.realestate.views.EstateActivityView;

public class EstateActivityViewModel implements Observer<EstateList> {

    private RealEstateRepo realEstateRepo;
    private EstateActivityView estateActivityView;

    public EstateActivityViewModel(RealEstateRepo realEstateRepo, EstateActivityView estateActivityView) {
        this.realEstateRepo = realEstateRepo;
        this.estateActivityView = estateActivityView;
    }

    public void getEstates() {
        realEstateRepo.getEstates(this);
    }

    @Override
    public void onCompleted() {
        estateActivityView.hideProgressBar();
    }

    @Override
    public void onError(Throwable e) {
        estateActivityView.hideProgressBar();
        estateActivityView.showErrorMessage();
    }

    @Override
    public void onNext(EstateList estateList) {

        estateActivityView.populateEstateList(estateList.getEstates());

    }

    public void onDestroy() {
        realEstateRepo.onDestroy();
    }
}