package com.coolapps.yo.tuto4u;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.ViewHolder> {

    private List<TutorData> tutorData;

    public TutorAdapter(List<TutorData> data) {
        tutorData = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tutor_item_layout,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder TutorViewHolder, int i) {
        TutorData tutor = tutorData.get(i);
        TutorViewHolder.text1.setText(tutor.getText1());
        TutorViewHolder.text2.setText(tutor.getText2());
        TutorViewHolder.image.setImageResource(tutor.getImage());
    }

    @Override
    public int getItemCount() {
        return tutorData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView text1;
        TextView text2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.image_name1);
            text2 = itemView.findViewById(R.id.image_name2);
            image = itemView.findViewById(R.id.image);
        }
    }
}