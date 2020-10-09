package com.example.reubroretrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reubroretrofit.R;
import com.example.reubroretrofit.model.Notice;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    public List<Notice> dataList;

    public NoticeAdapter(List<Notice> dataList) {
        this.dataList = dataList;
    }

    @Override
    public NoticeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoticeViewHolder holder, int position) {
        holder.id.setText(dataList.get(position).getId());
        holder.name.setText(dataList.get(position).getName());
        holder.email.setText(dataList.get(position).getEmail());
        holder.gender.setText(dataList.get(position).getGender());
        holder.mobile.setText(dataList.get(position).getContact().getMobile());
       holder.home.setText(dataList.get(position).getContact().getHome());
        holder.office.setText(dataList.get(position).getContact().getOffice());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, email, gender, mobile, home, office;

        NoticeViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name =  itemView.findViewById(R.id.name);
            email =  itemView.findViewById(R.id.email);
            gender =  itemView.findViewById(R.id.gender);
            mobile =  itemView.findViewById(R.id.mobile);
            home =  itemView.findViewById(R.id.home);
            office =  itemView.findViewById(R.id.office);

        }
    }
}