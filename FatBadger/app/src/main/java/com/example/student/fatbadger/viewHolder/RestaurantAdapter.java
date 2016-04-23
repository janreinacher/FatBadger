package com.example.student.fatbadger.viewHolder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import com.yelp.clientlib.entities.Business;

import java.util.ArrayList;
import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;

/**
 * Created by student on 4/16/16.
 */
public class RestaurantAdapter extends RecyclerView.Adapter<BusinessViewHolder> {

    private ArrayList<RestaurantModel> businesses;
    private OnItemSelected onItemSelected;

    public RestaurantAdapter (ArrayList<RestaurantModel> businesses){
        this.businesses = businesses;
    }

    @Override
    public BusinessViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_detail, parent, false);

        return new BusinessViewHolder(view);
    }

    @Override
    public void onBindViewHolder (BusinessViewHolder holder, int position){
        RestaurantModel item = businesses.get(position);
        holder.setOnBusinessClicked(new BusinessViewHolder.OnBusinessClicked() {
            @Override
            public void onClick(RestaurantModel item) {
                if (onItemSelected != null) {
                    onItemSelected.onSelected(item);
                }
            }
        });
        holder.bind(item);
    }

    @Override
    public final void onViewRecycled(final BusinessViewHolder holder) {
        super.onViewRecycled(holder);
        holder.setOnBusinessClicked(null);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return businesses.size();
    }

    public void setOnItemSelected (OnItemSelected onItemSelected) {
        this.onItemSelected = onItemSelected;
    }

    public interface OnItemSelected {
        void onSelected(RestaurantModel item);
    }
}
