package com.example.retrofitwithdagger2.ui;
import android.content.Context;
import android.content.Intent;

import java.util.List;

import javax.inject.Inject;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sgemin.daggertwoex.MyApplication;
import com.sgemin.daggertwoex.R;
import com.sgemin.daggertwoex.adapter.RecyclerViewAdapter;
import com.sgemin.daggertwoex.di.component.ApplicationComponent;
import com.sgemin.daggertwoex.di.component.DaggerMainActivityComponent;
import com.sgemin.daggertwoex.di.component.MainActivityComponent;
import com.sgemin.daggertwoex.di.module.MainActivityContextModule;
import com.sgemin.daggertwoex.di.qualifier.ActivityContext;
import com.sgemin.daggertwoex.di.qualifier.ApplicationContext;
import com.sgemin.daggertwoex.webutils.dto.StarWars;
import com.sgemin.daggertwoex.webutils.retrofit.APIInterface;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ApplicationComponent applicationComponent = MyApplication.Companion.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);

        apiInterface.getPeople("json").enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(@NotNull Call<StarWars> call, @NotNull Response<StarWars> response) {
                assert response.body() != null;
                populateRecyclerView(response.body().getResults());
            }

            @Override
            public void onFailure(@NotNull Call<StarWars> call, @NotNull Throwable t) {

            }
        });
    }

    private void populateRecyclerView(List<StarWars.People> response) {
        recyclerViewAdapter.setData(response);
    }


    @Override
    public void launchIntent(String url) {
        Toast.makeText(mContext, "RecyclerView Row selected", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(activityContext, DetailActivity.class).putExtra("url", url));
    }
}