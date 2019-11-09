package com.thinking.pesanan.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.thinking.pesanan.db.dao.IPesananDao;
import com.thinking.pesanan.db.entity.MenuEntity;
import com.thinking.pesanan.db.entity.PesananEntity;

@Database(entities = {MenuEntity.class, PesananEntity.class}, version = 1)
public abstract class BuilderPesananRoomDatabase extends RoomDatabase {

    private static BuilderPesananRoomDatabase Instance;
    private static String Database_Name = "pesanan_menu";

    public abstract IPesananDao iPesananDao();

    public static BuilderPesananRoomDatabase getDatabase(final Context context) {
        if (Instance == null) {
            synchronized (BuilderPesananRoomDatabase.class) {
                Instance = Room.databaseBuilder(context.getApplicationContext(),
                        BuilderPesananRoomDatabase.class, Database_Name)
                        .build();
            }
        }
        return Instance;
    }

}

