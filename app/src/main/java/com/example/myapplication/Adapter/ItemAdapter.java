package com.example.myapplication.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.ItemList;
import com.example.myapplication.R;
import com.example.myapplication.Second_Activity_edu;

import org.jetbrains.annotations.NotNull;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.myViewHolder>{
    public ItemList[] datalist;

    public ItemAdapter(ItemList[] datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myview = inflater.inflate(R.layout.single_row_item,parent,false);
        return new myViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position) {
        final ItemList data_position = datalist[position];
        holder.foodtitle.setText(datalist[position].getFoodtitle());
        holder.foodImg.setImageResource(datalist[position].getImageId());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "Selected Items : "+data_position.getFoodtitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), Second_Activity_edu.class);
                intent.putExtra("title",data_position.getFoodtitle());
                intent.putExtra("foodimg",data_position.getImageId());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datalist.length;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        private TextView foodtitle;
        private ImageView foodImg;
        private CardView layout;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            foodImg = itemView.findViewById(R.id.imageView);
            foodtitle = itemView.findViewById(R.id.textView);
            layout = itemView.findViewById(R.id.cardview_layout);
        }
    }
}
