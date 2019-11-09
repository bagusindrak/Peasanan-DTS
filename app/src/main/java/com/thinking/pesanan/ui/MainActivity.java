package com.thinking.pesanan.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.thinking.pesanan.R;
import com.thinking.pesanan.db.dao.IPesananDao;
import com.thinking.pesanan.db.entity.MenuEntity;
import com.thinking.pesanan.viewModel.PesananViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PesananViewModel pesananViewModel;
    EditText kodeMenu, namaMenu;
    RecyclerView recyclerView;
    MenuAdapter menuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuAdapter = new MenuAdapter();

        pesananViewModel = new PesananViewModel(getApplication());
        kodeMenu = findViewById(R.id.kode_menu);
        namaMenu = findViewById(R.id.nama_menu);
        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(menuAdapter);


    }

    public void TambahMenu(View view) {
        MenuEntity menu  = new MenuEntity(kodeMenu.getText().toString(),
              "", namaMenu.getText().toString());

        pesananViewModel.insertMenu(menu);
        new GetMenu(pesananViewModel, menuAdapter).execute();
    }

    private static class GetMenu extends AsyncTask<Void, Void, LiveData<List<MenuEntity>>> {
        PesananViewModel pesananViewModel;
        MenuAdapter menuAdapter;

        public GetMenu(PesananViewModel pesananViewModel, MenuAdapter menuAdapter) {
            this.pesananViewModel = pesananViewModel;
            this.menuAdapter = menuAdapter;
        }

        @Override
        protected LiveData<List<MenuEntity>> doInBackground(Void... voids) {
            return pesananViewModel.getAllMenu();
        }

        @Override
        protected void onPostExecute(LiveData<List<MenuEntity>> listLiveData) {
            menuAdapter.setItemMenu(listLiveData.getValue());
        }
    }

}
