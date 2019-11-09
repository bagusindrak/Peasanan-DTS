package com.thinking.pesanan.db.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.thinking.pesanan.db.BuilderPesananRoomDatabase;
import com.thinking.pesanan.db.dao.IPesananDao;
import com.thinking.pesanan.db.entity.MenuEntity;
import com.thinking.pesanan.db.entity.PesananEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class PesananRepository {
    private IPesananDao dao;
    private LiveData<List<MenuEntity>> listMenu;
    private LiveData<List<PesananEntity>> listPesanan;

    public PesananRepository(Application application) {
        BuilderPesananRoomDatabase db = BuilderPesananRoomDatabase.getDatabase(application);
        dao = db.iPesananDao();
        listMenu = dao.getAllMenu();
    }

    public LiveData<List<MenuEntity>> getAllMenu(){
        return listMenu;
    }

    public void insertMenu(MenuEntity menu){
        new AsyncInsertMenu(dao).execute(menu);
    }

    private static class AsyncInsertMenu extends AsyncTask<MenuEntity , Void, Void> {
        IPesananDao asyncMakananDao;

        public AsyncInsertMenu(IPesananDao asyncMakananDao) {
            this.asyncMakananDao = asyncMakananDao;
        }

        @Override
        protected Void doInBackground(MenuEntity... MenuEntity ) {
            asyncMakananDao.insert(MenuEntity[0]);
            return null;
        }
    }

}
