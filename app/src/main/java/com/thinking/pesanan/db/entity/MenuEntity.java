package com.thinking.pesanan.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menu_table")
public class MenuEntity {
    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "kode_menu")
    private String kodeMenu;
    @ColumnInfo(name = "penjelasan")
    private String penjelasan;
    @ColumnInfo(name = "nama_makanan")
    private String namaMakanan;

    public MenuEntity(String kodeMenu, String penjelasan, String namaMakanan) {
        this.kodeMenu = kodeMenu;
        this.penjelasan = penjelasan;
        this.namaMakanan = namaMakanan;
    }

    public String getKodeMenu() {
        return kodeMenu;
    }

    public void setKodeMenu(String  kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }
}
