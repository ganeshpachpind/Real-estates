package scout24.realestate.views;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import scout24.realestate.R;
import scout24.realestate.databinding.EstateRowBinding;
import scout24.realestate.model.Estate;

public class EstateAdapter extends RecyclerView.Adapter<EstateViewHolder> {

    private List<Estate> estateList;

    public EstateAdapter(List<Estate> estateList) {
        this.estateList = estateList;
    }

    @Override
    public EstateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        EstateRowBinding estateRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.estate_row, parent, false);
        return new EstateViewHolder(estateRowBinding);
    }

    @Override
    public void onBindViewHolder(EstateViewHolder holder, int position) {
        holder.bind(estateList.get(position));
    }

    @Override
    public int getItemCount() {
        return estateList.size();
    }
}
