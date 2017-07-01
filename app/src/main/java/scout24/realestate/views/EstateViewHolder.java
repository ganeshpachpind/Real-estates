package scout24.realestate.views;


import android.support.v7.widget.RecyclerView;

import scout24.realestate.databinding.EstateRowBinding;
import scout24.realestate.model.Estate;
import scout24.realestate.views.model.EstateViewModel;

public class EstateViewHolder extends RecyclerView.ViewHolder {

    private EstateRowBinding estateRowBinding;

    public EstateViewHolder(EstateRowBinding estateRowBinding) {
        super(estateRowBinding.getRoot());
        this.estateRowBinding = estateRowBinding;
    }

    public void bind(Estate estate) {
        EstateViewModel estateViewModel = new EstateViewModel(estate);
        estateRowBinding.setEstateViewModel(estateViewModel);
        estateRowBinding.executePendingBindings();
    }
}
