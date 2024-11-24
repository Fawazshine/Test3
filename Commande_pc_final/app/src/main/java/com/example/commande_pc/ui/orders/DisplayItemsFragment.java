package com.example.commande_pc.ui.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.commande_pc.MainActivity;
import com.example.commande_pc.adapters.DisplayItemAdapter;
import com.example.commande_pc.databinding.DisplayItemsBinding;
import com.example.commande_pc.entity.Order;
import com.example.commande_pc.entity.Requester;
import com.example.commande_pc.entity.Role;

import java.util.ArrayList;

public class DisplayItemsFragment extends Fragment {
    private DisplayItemsBinding binding;
    private RecyclerView itemRecycleView;
    private int position = 0;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding= DisplayItemsBinding.inflate(inflater,container,false);
        itemRecycleView=binding.itemsRecycleView;
        itemRecycleView.setLayoutManager(new GridLayoutManager(getContext(),1));
        if(MainActivity.getUser().getRoleId()== Role.findRoleByRoleName("requester").getId()){
            ArrayList<Order> orders = ((Requester)MainActivity.getUser()).getOrders();
            itemRecycleView.setAdapter(new DisplayItemAdapter(this,orders,getPosition()));
            this.toogleVisibility(!orders.get(getPosition()).getOrderItems().isEmpty());
        }
        return binding.getRoot();

    }

    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition(){
        return position;
    }
    public void toogleVisibility(boolean recycleViewVisible){
        if(recycleViewVisible){
            itemRecycleView.setVisibility(View.VISIBLE);

        }else{
            itemRecycleView.setVisibility(View.GONE);

        }
    }
}
