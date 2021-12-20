package com.example.shopp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Product> {

    ArrayList<Product> products;
    Context context;
    int resource;


    public CustomListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null, true);
        }
        Product product = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);
        Picasso.get().load(product.getImage()).into(imageView);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(product.getName());

        TextView txtPrice = (TextView) convertView.findViewById(R.id.txtPrice);
        txtPrice.setText(product.getPrice());

        return convertView;
    }
}
