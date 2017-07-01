package scout24.realestate.views.model;


import scout24.realestate.model.Estate;

public class EstateViewModel {
    private Estate estate;

    public EstateViewModel(Estate estate) {
        this.estate = estate;
    }

    public Estate getEstate() {
        return estate;
    }
}
