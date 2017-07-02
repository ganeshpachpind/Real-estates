package scout24.realestate.repositories;


import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import scout24.realestate.api.RestAPIFactory;
import scout24.realestate.model.EstateList;

public class RealEstateRepo {

    private RestAPIFactory restAPIFactory;
    private Subscription subscription;

    public RealEstateRepo(RestAPIFactory restAPIFactory) {
        this.restAPIFactory = restAPIFactory;
    }


    public void getEstates(Observer<EstateList> observer) {
        subscription = restAPIFactory
                .getPropertyService()
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
