package com.example.student.fatbadger.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.student.fatbadger.R;
import com.example.student.fatbadger.model.RestaurantModel;
//import com.yelp.clientlib.entities.Business;

/**
 * Created by Jack on 4/16/16.
 */
public class BusinessViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView thumbnail;
    private TextView name;
    private RestaurantModel item;
    private OnBusinessClicked onBusinessClicked;

    public BusinessViewHolder(final View itemView) { super(itemView); }

    // A method to bring an itemModel to the layout
    public final void bind(final RestaurantModel item) {
        // assign layout instances to local versions
        this.item = item;
        thumbnail = (ImageView)itemView.findViewById(R.id.restaurantThumbnail);
        name = (TextView)itemView.findViewById(R.id.restaurantName);

        // Use the Glide library to preload an image for the thumbnail
        Glide.with(itemView.getContext())
                .load(item.getImg_url())
                .into(thumbnail);

        // Set the value of the name
        name.setText(item.getName());

        // Adding click listeners on the image and text of the RecyclerView items for touch events
        name.setOnClickListener(this);
        thumbnail.setOnClickListener(this);

    }

    public final void unbind() {
        // for later with Butterknife
    }

    @Override
    public void onClick(View v) {
        if(onBusinessClicked != null) {
            onBusinessClicked.onClick(item);
        }
    }

    // The setter that allows other classes to create a reference to the listener
    public void setOnBusinessClicked(OnBusinessClicked onBusinessClicked) {
        this.onBusinessClicked = onBusinessClicked;
    }

    // An interface is added as an internal impolementation in our ViewHolder. This will allow
    // classes that instantiate a new instance of this ViewHolder to subscribe to this interface
    // and listen for events.
    public interface OnBusinessClicked {
        void onClick(RestaurantModel item);
    }
}
