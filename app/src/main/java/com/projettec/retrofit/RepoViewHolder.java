package com.projettec.retrofit;

import android.widget.TextView;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;


import androidx.annotation.NonNull;

public class RepoViewHolder extends RecyclerView.ViewHolder{

    private TextView nameRepo;

    public RepoViewHolder(@NonNull View itemView) {
        super(itemView);
        nameRepo = itemView.findViewById(R.id.name);
    }


    void display(RepoList repoList){
        nameRepo.setText(repoList.getRepoName());
    }
}
