package scout24.realestate.repositories;


import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import scout24.realestate.model.EstateList;
import scout24.realestate.services.EstateService;

public class RealEstateRepo {

    private Subscription subscription;
    private EstateService estateService;

    public RealEstateRepo(EstateService estateService) {
        this.estateService = estateService;
    }

    public void getEstates(Observer<EstateList> observer) {
        subscription = estateService
                .getEstates()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void onDestroy() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
