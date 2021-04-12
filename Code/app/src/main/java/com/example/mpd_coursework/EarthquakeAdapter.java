package com.example.mpd_coursework;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>
{
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes)
    {
        super(context,0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Earthquake earthquake = getItem(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            convertView.setTag(earthquake);


            TextView eqLocation = convertView.findViewById(R.id.eqLocation);
            TextView eqMagnitude = convertView.findViewById(R.id.eqMagnitude);

            eqLocation.setText(earthquake.getLocation());
            eqMagnitude.setText(earthquake.getMagnitude());

            if (getItem(position).getMagnitude().contains("0."))
            {
                convertView.setBackgroundColor(Color.GREEN);
            }
            else if (getItem(position).getMagnitude().contains("1."))
            {
                convertView.setBackgroundColor(Color.YELLOW);
            }
            else if (getItem(position).getMagnitude().contains("2."))
            {
                convertView.setBackgroundColor(Color.parseColor("#ff9933"));
            }
            else if (getItem(position).getMagnitude().contains("3."))
            {
                convertView.setBackgroundColor(Color.parseColor("#ff6600"));
            }
            else if (getItem(position).getMagnitude().contains("4."))
            {
                convertView.setBackgroundColor(Color.RED);
            }
            else if (getItem(position).getMagnitude().contains("5."))
            {
                convertView.setBackgroundColor(Color.RED);
            }


        }




        return convertView;
    }
}
