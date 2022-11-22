package com.example.movienative;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapterCast extends BaseAdapter {

    Context context;
    String[] nameActor;
    int[] imageUrl;
    LayoutInflater inflater;

    public CustomBaseAdapterCast(Context context, String[] nameActor, int[] imageUrl){
        this.context = context;
        this.imageUrl = imageUrl;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return nameActor.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_cast_list_view, null);
        TextView name = (TextView) view.findViewById(R.id.tvNameActor);
        ImageView moviePoster = (ImageView) view.findViewById(R.id.imageMoviePoster);

        name.setText(nameActor[i]);
        moviePoster.setImageResource(imageUrl[i]);
        return view;
    }
}

