package scout24.realestate.views.model;


import android.databinding.BindingAdapter;
import android.net.Uri;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

import scout24.realestate.model.Estate;

public class EstateViewModel {
    private Estate estate;

    public EstateViewModel(Estate estate) {
        this.estate = estate;
    }

    public Estate getEstate() {
        return estate;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(SimpleDraweeView view, String imageUrl) {
        if (imageUrl == null) {
            return;
        }
        Uri imageUri = Uri.parse(imageUrl);
        view.getHierarchy()
                .setProgressBarImage(new ProgressBarDrawable());
        view.setImageURI(imageUri);

    }
}
