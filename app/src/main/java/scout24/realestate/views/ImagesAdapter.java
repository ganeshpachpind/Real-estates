package scout24.realestate.views;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import scout24.realestate.R;
import scout24.realestate.databinding.ImagesRowBinding;
import scout24.realestate.model.Image;

public class ImagesAdapter extends PagerAdapter {

    private final LayoutInflater layoutInflater;
    private List<Image> imageList;

    ImagesAdapter(Context context, @NonNull List<Image> imageList) {
        this.imageList = imageList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImagesRowBinding imagesRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.images_row, container, false);
        SimpleDraweeView imageView = imagesRowBinding.image;
        Uri imageUri = Uri.parse(imageList.get(position).getUrl());
        imageView.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        imageView.setImageURI(imageUri);
        View rootView = imagesRowBinding.getRoot();
        container.addView(rootView, 0);
        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
