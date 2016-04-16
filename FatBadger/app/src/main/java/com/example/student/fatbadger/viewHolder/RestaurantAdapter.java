package com.example.student.fatbadger.viewHolder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;

/**
 * Created by student on 4/16/16.
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantItemViewHolder> {

    private ArrayList<RestaurantModel> restaurantItemCollection;
    private OnItemSelected onItemSelected;

    public RestaurantAdapter (ArrayList<RestaurantModel> restaurantItemCollection){
        this.restaurantItemCollection = restaurantItemCollection;
    }

    @Override
    public RestaurantItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_detail, parent, false);

        return new RestaurantItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder (RestaurantItemViewHolder holder, int position){
        RestaurantModel item = restaurantItemCollection.get(position);
        holder.setOnRestaurantItemClicked(new RestaurantItemViewHolder.OnRestaurantItemClicked(){
            @Override
            public void onClick(RestaurantModel item){
                if (onItemSelected != null){
                    onItemSelected.onSelected(item);
                }
            }
        });
        holder.bind(item);
    }

    @Override
    public final void onViewRecycled(final RestaurantItemViewHolder holder) {
        super.onViewRecycled(holder);
        holder.setOnRestaurantItemClicked(null);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return restaurantItemCollection.size();
    }

    public void setOnItemSelected (OnItemSelected onItemSelected) {
        this.onItemSelected = onItemSelected;
    }

    public interface OnItemSelected {
        void onSelected(RestaurantModel item);
    }
}
