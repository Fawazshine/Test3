package com.example.commande_pc.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.commande_pc.R;
import com.example.commande_pc.Utils;
import com.example.commande_pc.entity.Item;
import com.example.commande_pc.entity.Order;
import com.example.commande_pc.ui.orders.DisplayItemsFragment;

import java.util.ArrayList;

public class DisplayItemAdapter extends RecyclerView.Adapter<DisplayItemAdapter.ViewHolder> {
    private ArrayList<Item> items;
    private int position;
    private final DisplayItemsFragment displayItemsFragment;
    public DisplayItemAdapter(DisplayItemsFragment displayItemsFragment,ArrayList<Order>orders,int position){
        this.displayItemsFragment = displayItemsFragment;
        this.position=position;
        Order order = orders.get(position);
        this.items= order.getOrderItems();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.preview_item_store_keeper,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayItemAdapter.ViewHolder holder, int position) {
        holder.type.setText(items.get(position).getType());
        holder.description.setText(items.get(position).getDescription());
        holder.createdAt.setText(Utils.dateToString(items.get(position).getCreatedAt()));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView type, description ,createdAt;
        Button deleteButton;
        public ViewHolder(View itemView){
            super(itemView);
            type= itemView.findViewById(R.id.typeTextView);
            description=itemView.findViewById(R.id.descriptionTextView);
            createdAt= itemView.findViewById(R.id.created_at_text_view);
            deleteButton= itemView.findViewById(R.id.deleteItemButton);
        }

    }
}
