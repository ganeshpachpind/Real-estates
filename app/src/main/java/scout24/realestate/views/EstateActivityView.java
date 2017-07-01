package scout24.realestate.views;


import java.util.List;

import scout24.realestate.model.Estate;

public interface EstateActivityView {
    void hideProgressBar();

    void showErrorMessage();

    void populateEstateList(List<Estate> estates);
}
