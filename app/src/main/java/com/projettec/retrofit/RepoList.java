package com.projettec.retrofit;

public class RepoList {

    private String name;

    public RepoList(String name) {
        this.name = name;
    }

    public RepoList() {
        super();
    }

    public String getRepoName(){
        return name;
    }

}
