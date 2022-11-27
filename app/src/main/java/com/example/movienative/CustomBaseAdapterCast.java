package com.example.movienative;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomBaseAdapterCast extends RecyclerView.Adapter<CustomBaseAdapterCast.MyViewHolder> {
    String[] nameActor;
    int[] imageUrl;

    public CustomBaseAdapterCast(String[] nameActor, int[] imageUrl) {
        this.nameActor = nameActor;
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cast_list_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvActorName.setText(nameActor[position]);
        holder.moviePoster.setImageResource(imageUrl[position]);
    }

    @Override
    public int getItemCount() {
        return nameActor.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvActorName;
        ImageView moviePoster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvActorName = itemView.findViewById(R.id.tvNameActor);
            moviePoster = itemView.findViewById(R.id.ivCastMovie);
        }
    }
}
