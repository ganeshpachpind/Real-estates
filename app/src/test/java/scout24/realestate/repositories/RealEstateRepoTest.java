package scout24.realestate.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;
import scout24.realestate.RxBaseTest;
import scout24.realestate.api.RestAPIFactory;
import scout24.realestate.model.Estate;
import scout24.realestate.model.Location;
import scout24.realestate.services.EstateService;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RealEstateRepoTest extends RxBaseTest {

    @Mock
    RestAPIFactory restAPIFactory;
    @Mock
    EstateService estateService;

    private RealEstateRepo realEstateRepo;
    private List<Estate> estates;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        realEstateRepo = new RealEstateRepo(restAPIFactory);
        when(restAPIFactory.getPropertyService()).thenReturn(estateService);

        estates = Arrays.asList(
                new Estate(1, "Estate 1", 100, new Location("address1", 10.24, 45.67)),
                new Estate(2, "Estate 2", 200, new Location("address2", 11.2, 5.67)));
    }

    @Test
    public void shouldFetchListOfProperties() throws Exception {
        TestSubscriber<List<Estate>> testSubscriber = TestSubscriber.create();
        when(estateService.getEstates()).thenReturn(Observable.just(estates));

        realEstateRepo.getEstates(testSubscriber);


        testSubscriber.assertReceivedOnNext(Collections.singletonList(estates));
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
    }
}