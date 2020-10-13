package com.example.reubroretrofit.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.reubroretrofit.R;
import com.example.reubroretrofit.adapter.NoticeAdapter;
import com.example.reubroretrofit.model.Notice;
import com.example.reubroretrofit.model.NoticeList;
import com.example.reubroretrofit.my_interface.GetNoticeDataService;
import com.example.reubroretrofit.network.RetrofitInstance;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /** Create handle for the RetrofitInstance interface*/
        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<NoticeList> call = service.getNoticeData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                generateNoticeList(response.body().getUsers());
                /*generateContactList(response.get("contact"));*/


            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }

    /** Method to generate List of notice using RecyclerView with custom adapter*/
    private void generateNoticeList(final List<Notice> noticeList) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_notice_list);
        final NoticeAdapter adapter = new NoticeAdapter(noticeList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noticeList.remove(viewHolder.getAdapterPosition());
                adapter.notifyDataSetChanged();


            }
        }).attachToRecyclerView(recyclerView);
    }

/*
    private void generateContactList(List<Contact> contactList) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_notice_list);
        ContactAdapter adapter = new ContactAdapter(contactList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
*/

}