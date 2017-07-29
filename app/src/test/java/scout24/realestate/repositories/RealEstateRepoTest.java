package scout24.realestate.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;
import scout24.realestate.RxBaseTest;
import scout24.realestate.model.Estate;
import scout24.realestate.model.EstateList;
import scout24.realestate.model.Image;
import scout24.realestate.model.Location;
import scout24.realestate.services.EstateService;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RealEstateRepoTest extends RxBaseTest {

    @Mock
    EstateService estateService;

    private RealEstateRepo realEstateRepo;
    private List<Estate> estates;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        realEstateRepo = new RealEstateRepo(estateService);

        List<Image> images = Arrays.asList(
                new Image(1, "dummyurl"),
                new Image(2, "dummyurl2"));

        estates = new ArrayList<>();
        estates.add(new Estate(1, "Estate 1", 100, new Location("address1", 10.24, 45.67), images));
        estates.add(new Estate(2, "Estate 2", 200, new Location("address2", 11.2, 5.67), images));
    }

    @Test
    public void shouldFetchListOfProperties() throws Exception {
        TestSubscriber<EstateList> testSubscriber = TestSubscriber.create();
        EstateList estateList = new EstateList(estates);
        when(estateService.getEstates()).thenReturn(Observable.just(estateList));

        realEstateRepo.getEstates(testSubscriber);


        testSubscriber.assertReceivedOnNext(Collections.singletonList(estateList));
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
    }
}