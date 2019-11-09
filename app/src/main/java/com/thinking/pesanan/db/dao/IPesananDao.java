package com.thinking.pesanan.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.thinking.pesanan.db.entity.MenuEntity;

import java.util.List;

@Dao
public interface IPesananDao {

@Query("SELECT * FROM menu_table")
    LiveData<List<MenuEntity>> getAllMenu();

@Insert
void insert(MenuEntity menuEntity);
}
