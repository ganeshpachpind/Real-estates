package scout24.realestate.dependency;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import scout24.realestate.repositories.RealEstateRepo;
import scout24.realestate.services.EstateService;

@Module
@ActivityScope
public class EstateModule {
    @Provides
    EstateService provideEstateService(Retrofit retrofit) {
        return retrofit.create(EstateService.class);
    }

    @Provides
    RealEstateRepo provideRealEstateRepo(EstateService estateService) {
        return new RealEstateRepo(estateService);
    }
}
