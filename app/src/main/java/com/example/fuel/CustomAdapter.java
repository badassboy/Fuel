package com.example.fuel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Station> stationList;
    private Context context;

    public CustomAdapter(List<Station> stationList, Context context) {
        this.stationList = stationList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.card_layout,viewGroup,false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder customViewHolder, int i) {
        customViewHolder.title.setText(stationList.get(i).getTitle());
        customViewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Station selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView title;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.card_title);
        }
    }
}
