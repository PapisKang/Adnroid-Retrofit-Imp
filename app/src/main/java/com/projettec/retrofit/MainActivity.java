package com.projettec.retrofit;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.converter.gson.*;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private List<RepoList> myRepos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         myRepos = new ArrayList<>();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();
        GitHubClient client = retrofit.create(GitHubClient.class);
        Call<List<RepoList>> call = client.UserRepositories("JakeWharton");

        call.enqueue(new Callback<List<RepoList>>() {
            @Override
            public void onResponse(Call<List<RepoList>> call, Response<List<RepoList>> response) {
                List<RepoList> list = response.body();
                myRepos=list;

                RecyclerView myRecyclerView = findViewById(R.id.myRecyclerView);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
                myRecyclerView.setAdapter( new RepoListAdapter(myRepos));

            }
            @Override
            public void onFailure(Call<List<RepoList>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
