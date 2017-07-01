package scout24.realestate.views;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scout24.realestate.model.Estate;
import scout24.realestate.model.Image;
import scout24.realestate.model.Location;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EstateAdapterTest {

    private static final int ESTATE_TYPE = 1;
    private static final int ADVERTISE_TYPE = 0;
    private ArrayList<Estate> estates;
    private EstateAdapter estateAdapter;

    @Before
    public void setUp() throws Exception {
        List<Image> images = Arrays.asList(
                new Image(1, "dummyurl"),
                new Image(2, "dummyurl2"));

        estates = new ArrayList<>();
        estates.add(new Estate(0, "Estate 1", 100, new Location("address1", 10.24, 45.67), images));
        estates.add(new Estate(1, "Estate 2", 200, new Location("address2", 11.2, 5.67), images));
        estates.add(new Estate(2, "Estate 3", 200, new Location("address2", 11.2, 5.67), images));
        estates.add(new Estate(3, "Estate 4", 200, new Location("address2", 11.2, 5.67), images));
        estateAdapter = new EstateAdapter(estates);
    }

    @Test
    public void shouldReturnItemCountAfterAddingAdvertisementCount() throws Exception {
        assertThat(estateAdapter.getItemCount(), is(6));
        estates.remove(3);
        estateAdapter = new EstateAdapter(estates);
        assertThat(estateAdapter.getItemCount(), is(4));
    }

    @Test
    public void shouldReturnEstateTypeForZeroPosition() throws Exception {
        int itemViewType = estateAdapter.getItemViewType(0);
        assertThat(itemViewType, is(ESTATE_TYPE));
    }

    @Test
    public void shouldReturnViewTypeAsAdvertisementForEvery3rdPosition() throws Exception {
        EstateAdapter estateAdapter = new EstateAdapter(estates);
        int itemViewType = estateAdapter.getItemViewType(5);
        assertThat(itemViewType, is(ADVERTISE_TYPE));
    }

    @Test
    public void shouldCalculateProperEstatePositionInList() throws Exception {
        assertThat(estateAdapter.calculateEstatePositionInList(0), is(0));
        assertThat(estateAdapter.calculateEstatePositionInList(1), is(1));
        assertThat(estateAdapter.calculateEstatePositionInList(6), is(4));
        assertThat(estateAdapter.calculateEstatePositionInList(9), is(6));
        assertThat(estateAdapter.calculateEstatePositionInList(12), is(8));
    }
}