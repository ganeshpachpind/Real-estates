package scout24.realestate.views;


import android.support.v7.widget.RecyclerView;

import java.util.List;

import scout24.realestate.databinding.EstateRowBinding;
import scout24.realestate.model.Estate;
import scout24.realestate.model.Image;
import scout24.realestate.views.model.EstateViewModel;

class EstateViewHolder extends RecyclerView.ViewHolder {

    private EstateRowBinding estateRowBinding;

    EstateViewHolder(EstateRowBinding estateRowBinding) {
        super(estateRowBinding.getRoot());
        this.estateRowBinding = estateRowBinding;
    }

    void bind(Estate estate) {
        EstateViewModel estateViewModel = new EstateViewModel(estate);
        estateRowBinding.setEstateViewModel(estateViewModel);
        List<Image> images = estateViewModel.getEstate().getImages();
        if (images != null) {
            ImagesAdapter imagesAdapter = new ImagesAdapter(estateRowBinding.getRoot().getContext(), images);
            estateRowBinding.images.setAdapter(imagesAdapter);
            estateRowBinding.indicator.setViewPager(estateRowBinding.images);
        }
        estateRowBinding.executePendingBindings();
    }
}
