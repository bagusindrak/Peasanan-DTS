package com.thinking.pesanan.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.thinking.pesanan.db.entity.MenuEntity;
import com.thinking.pesanan.db.repository.PesananRepository;

import java.util.List;

public class PesananViewModel extends AndroidViewModel {

    private PesananRepository repository;
    public PesananViewModel(Application application) {
        super(application);
        repository = new PesananRepository(application);
    }

    public LiveData<List<MenuEntity>> getAllMenu() {
        return repository.getAllMenu();
    }

    public void insertMenu(MenuEntity MenuEntity){
        repository.insertMenu(MenuEntity);
    }
}