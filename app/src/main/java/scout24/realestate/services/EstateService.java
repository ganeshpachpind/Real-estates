package scout24.realestate.services;


import retrofit2.http.GET;
import rx.Observable;
import scout24.realestate.model.EstateList;

public interface EstateService {

    @GET("realestates")
    Observable<EstateList> getEstates();
}
