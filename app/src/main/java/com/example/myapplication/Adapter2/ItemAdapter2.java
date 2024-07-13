package com.example.myapplication.Adapter2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model2.ItemList2;
import com.example.myapplication.R;
import com.example.myapplication.Second_Activity2;

public class ItemAdapter2 extends RecyclerView.Adapter<ItemAdapter2.myViewHolder>{

    public ItemList2[] datalist;

    public ItemAdapter2(ItemList2[] datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myView = inflater.inflate(R.layout.single_item_row,parent,false);
        return new myViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        final ItemList2 data_position2 = datalist[position];
        holder.hostitle2.setText(datalist[position].getFoodtitle2());
        holder.hosImg2.setImageResource(datalist[position].getImageId2());
        holder.layou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), Second_Activity2.class);
                intent2.putExtra("title",data_position2.getFoodtitle2());
                intent2.putExtra("fooding",data_position2.getImageId2());
                v.getContext().startActivity(intent2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datalist.length;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        private TextView hostitle2;
        private ImageView hosImg2;
        private CardView layou;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            hosImg2 = itemView.findViewById(R.id.imageViewHos);
            hostitle2 = itemView.findViewById(R.id.textViewHos);
            layou = itemView.findViewById(R.id.cardview_layout_Hospital);
        }
    }}
