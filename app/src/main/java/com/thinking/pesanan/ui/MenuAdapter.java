package com.thinking.pesanan.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinking.pesanan.R;
import com.thinking.pesanan.db.entity.MenuEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<MenuEntity> listMenuEntities;

    public MenuAdapter() {
        super();
        listMenuEntities = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_menu, parent, false));
        //gae create tampilan
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaMenu.setText(listMenuEntities.get(position).getNamaMakanan());
        holder.kodeMenu.setText(listMenuEntities.get(position).getKodeMenu());

    }

    void setItemMenu(List<MenuEntity> listMenu){
        listMenuEntities = listMenu;
        notifyDataSetChanged(); //refresh data
    }

    @Override
    public int getItemCount() {
        return listMenuEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView kodeMenu, namaMenu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kodeMenu = itemView.findViewById(R.id.kode_menu);
            namaMenu = itemView.findViewById(R.id.nama_menu);
        }
    }
}
