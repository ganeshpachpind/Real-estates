package scout24.realestate.services;


import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import scout24.realestate.model.Estate;

public interface EstateService {

    @GET("realestates")
    Observable<List<Estate>> getEstates();
}
