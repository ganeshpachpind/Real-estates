package scout24.realestate.views;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import scout24.realestate.R;
import scout24.realestate.databinding.AdvertiseRowBinding;
import scout24.realestate.databinding.EstateRowBinding;
import scout24.realestate.model.Estate;

public class EstateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ESTATE_VIEW = 1;
    public static final int ADVERTISE_VIEW = 0;
    private List<Estate> estateList;

    EstateAdapter(List<Estate> estateList) {
        this.estateList = estateList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ADVERTISE_VIEW:
                AdvertiseRowBinding advertiseRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.advertise_row, parent, false);
                return new AdvertisementViewHolder(advertiseRowBinding);
            default:
                EstateRowBinding estateRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.estate_row, parent, false);
                return new EstateViewHolder(estateRowBinding);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() != ADVERTISE_VIEW) {
            EstateViewHolder estateViewHolder = (EstateViewHolder) holder;
            estateViewHolder.bind(estateList.get(calculateEstatePositionInList(position)));
        }
    }

    int calculateEstatePositionInList(int position) {
        if (position == 0 || position == 1) return position;
        return position - (position / 3);
    }

    @Override
    public int getItemCount() {
        int size = estateList.size();
        return (size + (size / 2));
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == 1) {
            return ESTATE_VIEW;
        }
        return (position + 1) % 3;
    }
}
