package com.projettec.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RepoListAdapter extends RecyclerView.Adapter<RepoViewHolder> {

    private List<RepoList> myRepos;

    public RepoListAdapter(List<RepoList> myRepos) {
        this.myRepos = myRepos;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new RepoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.display(myRepos.get(position));

    }

    @Override
    public int getItemCount() {
        return myRepos.size();
    }


    public List<RepoList> getMyRepos() {
        return myRepos;
    }

    public void setMyRepos(List<RepoList> myRepos) {
        this.myRepos = myRepos;
    }
}
