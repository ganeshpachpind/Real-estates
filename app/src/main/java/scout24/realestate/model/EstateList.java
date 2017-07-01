package scout24.realestate.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EstateList {
    @JsonProperty("items")
    private List<Estate> estates;

    public EstateList() {
    }

    public EstateList(List<Estate> estates) {
        this.estates = estates;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}
