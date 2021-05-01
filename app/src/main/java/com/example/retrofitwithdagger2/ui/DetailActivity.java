package com.example.retrofitwithdagger2.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.sgemin.daggertwoex.MyApplication;
import com.sgemin.daggertwoex.R;
import com.sgemin.daggertwoex.di.component.ApplicationComponent;
import com.sgemin.daggertwoex.di.component.DaggerDetailActivityComponent;
import com.sgemin.daggertwoex.di.component.DetailActivityComponent;
import com.sgemin.daggertwoex.di.qualifier.ApplicationContext;
import com.sgemin.daggertwoex.webutils.dto.Film;
import com.sgemin.daggertwoex.webutils.retrofit.APIInterface;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;

/**
 * Created by Stephen Gemin on 9/1/2019
 */
public class DetailActivity extends AppCompatActivity {

    DetailActivityComponent detailActivityComponent;
    @Inject public APIInterface apiInterface;
    @Inject @ApplicationContext public Context mcontext;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = findViewById(R.id.textView);
        String url = getIntent().getStringExtra("url");

        ApplicationComponent applicationComponent = MyApplication.Companion.get(this).getApplicationComponent();
        detailActivityComponent = DaggerDetailActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .build();
        detailActivityComponent.inject(this);
        assert url != null;
        apiInterface.getFilmData(url, "json").enqueue(new Callback<Film>() {
            @Override
            public void onResponse(@NotNull Call<Film> call, @NotNull Response<Film> response) {
                Film films = response.body();
                String text = "Film name: " + films.getTitle() + "\nDirector: " + films.getDirector();
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }


}
