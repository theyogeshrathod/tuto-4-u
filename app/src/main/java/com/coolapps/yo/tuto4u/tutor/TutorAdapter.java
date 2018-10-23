package com.coolapps.yo.tuto4u.tutor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coolapps.yo.tuto4u.R;

import java.util.List;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.TutorViewHolder> {

    private OnTutorItemClickListener mListener;
    private List<TutorModel> mTutorModelList;

    public interface OnTutorItemClickListener {
        void onTutorItemClicked(String emailId);
    }

    public TutorAdapter(List<TutorModel> tutorModels, OnTutorItemClickListener listener) {
        mTutorModelList = tutorModels;
        mListener = listener;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tutor_item_layout, viewGroup, false);
        return new TutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TutorViewHolder tutorViewHolder, int position) {
        tutorViewHolder.bindData(mTutorModelList.get(position));
        tutorViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onTutorItemClicked(tutorViewHolder.mEmailId.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTutorModelList.size();
    }

    static class TutorViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mEmailId;
        private TextView mContactNumber;
        private TextView mQualification;

        TutorViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tutor_name);
            mEmailId = itemView.findViewById(R.id.tutor_email);
            mContactNumber = itemView.findViewById(R.id.tutor_contact_number);
            mQualification = itemView.findViewById(R.id.tutor_qualification);
        }

        void bindData(TutorModel tutorModel) {
            mName.setText(tutorModel.getName());
            mEmailId.setText(tutorModel.getEmailId());
            mContactNumber.setText(tutorModel.getContactNumber());
            mQualification.setText(tutorModel.getQualification());
        }
    }
}
