package com.example.student.fatbadger.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;

/**
 * Created by student on 4/16/16.
 */
public class RestaurantItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView restaurantThumbnail;
    private TextView restaurantName;
    private RestaurantModel item;
    private OnRestaurantItemClicked onRestaurantItemClicked;

    public RestaurantItemViewHolder(final View itemView) { super(itemView); }

    // A method to bring an itemModel to the layout
    public final void bind(final RestaurantModel item) {
        // assign layout instances to local versions
        this.item = item;
        restaurantThumbnail = (ImageView)itemView.findViewById(R.id.restaurantThumbnail);
        restaurantName = (TextView)itemView.findViewById(R.id.restaurantName);

        // Use the Glide library to preload an image for the thumbnail
        Glide.with(itemView.getContext())
                .load(item.getImg_url())
                .into(restaurantThumbnail);

        // Set the value of the name
        restaurantName.setText(item.getName());

        // Adding click listeners on the image and text of the RecyclerView items for touch events
        restaurantName.setOnClickListener(this);
        restaurantThumbnail.setOnClickListener(this);

    }

    public final void unbind() {
        // for later with Butterknife
    }

    @Override
    public void onClick(View v) {
        if(onRestaurantItemClicked != null) {
            onRestaurantItemClicked.onClick(item);
        }
    }

    // The setter that allows other classes to create a reference to the listener
    public void setOnRestaurantItemClicked(OnRestaurantItemClicked onRestaurantItemClicked) {
        this.onRestaurantItemClicked = onRestaurantItemClicked;
    }

    // An interface is added as an internal impolementation in our ViewHolder. This will allow
    // classes that instantiate a new instance of this ViewHolder to subscribe to this interface
    // and listen for events.
    public interface OnRestaurantItemClicked {
        void onClick(RestaurantModel item);
    }
}
