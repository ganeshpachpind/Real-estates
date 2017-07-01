package scout24.realestate.views.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import scout24.realestate.repositories.RealEstateRepo;
import scout24.realestate.views.EstateActivityView;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EstateActivityViewModelTest {

    @Mock
    RealEstateRepo realEstateRepo;
    @Mock
    EstateActivityView estateActivityView;

    private EstateActivityViewModel estateActivityViewModel;

    @Before
    public void setUp() throws Exception {
        estateActivityViewModel = new EstateActivityViewModel(realEstateRepo, estateActivityView);
    }

    @Test
    public void shouldHideProgressBarOnSuccessfulEstateFetch() throws Exception {
        estateActivityViewModel.onCompleted();

        verify(estateActivityView).hideProgressBar();
        verify(estateActivityView, never()).showErrorMessage();
    }

    @Test
    public void shouldHideProgressBarAndShowMessageOnErrorInEstateFetch() throws Exception {
        estateActivityViewModel.onError(new Exception());

        verify(estateActivityView).hideProgressBar();
        verify(estateActivityView).showErrorMessage();
    }

    @Test
    public void shouldCallRepoTOFetchEstate() throws Exception {
        estateActivityViewModel.getEstates();

        verify(realEstateRepo).getEstates(estateActivityViewModel);
    }
}