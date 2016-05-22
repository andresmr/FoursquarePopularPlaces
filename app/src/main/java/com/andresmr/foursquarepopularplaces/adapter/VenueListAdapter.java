package com.andresmr.foursquarepopularplaces.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andresmr.foursquarepopularplaces.R;
import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;
import com.andresmr.foursquarepopularplaces.pojo.Tip;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public class VenueListAdapter  extends ArrayAdapter<FourSquareResponse> {

    // Global Variables
    Context context;
    private List<FourSquareResponse> fourSquareResponseList;
    private LayoutInflater inflater;

    // Constructor
    public VenueListAdapter(Context _context, List<FourSquareResponse> fourSquareResponseList) {

        super(_context, R.layout.item_venue, fourSquareResponseList);
        this.fourSquareResponseList = fourSquareResponseList;
        this.context = _context;

        inflater = LayoutInflater.from(_context);
    }

    /**
     * Return view that must be drawed for an item
     * @param position item position list
     * @param convertView View to be inflated
     * @param parent parent
     * @return view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        // If view is empty
        if (convertView == null) {

            //Get file view inflating layout
            convertView = inflater.inflate(R.layout.item_venue, parent, false);

            //Create holder view for the item
            holder = new ViewHolder(convertView);

            //Stores holder in the view
            convertView.setTag(holder);
        }
        // If we can re use the view
        else {
            //Get holder from recycled view
            holder = (ViewHolder) convertView.getTag();
        }

        //Data is written on holder view
        onBindViewHolder(holder, position);

        // Returns view
        return convertView;
    }

    /**
     * Data write on element view
     * @param holder view holder
     * @param position position at the view holder
     */
    private void onBindViewHolder(ViewHolder holder, int position) {

        FourSquareResponse fourSquareResponse = fourSquareResponseList.get(position);

        String venueImage = null;

        if(fourSquareResponse.getTips()!= null && fourSquareResponse.getTips().size() > 0){

            for (Tip tip : fourSquareResponse.getTips()){

                if(tip.getPhotourl() != null){

                    venueImage = tip.getPhotourl();
                }
            }
        }

        Picasso.with(context).
                load(venueImage).
                placeholder(R.drawable.foursquare_placeholder).
                error(R.drawable.foursquare_placeholder)
                .into(holder.ivVenueImage);

        holder.tvVenueName.setText(fourSquareResponse.getVenue().getName());
        holder.tvVenueAddress.setText(fourSquareResponse.getVenue().getLocation().getAddress());
    }

    /**
     * View holder from item view
     */
    public class ViewHolder {

        private ImageView ivVenueImage;
        private TextView tvVenueName;
        private TextView tvVenueAddress;

        //Builder retrieve file view
        public ViewHolder(View itemView) {

            ivVenueImage = (ImageView) itemView.findViewById(R.id.ivVenueImage);
            tvVenueName = (TextView) itemView.findViewById(R.id.tvVenueName);
            tvVenueAddress = (TextView) itemView.findViewById(R.id.tvVenueAddress);
        }
    }
}