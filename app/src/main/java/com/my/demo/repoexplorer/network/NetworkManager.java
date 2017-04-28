package com.my.demo.repoexplorer.network;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private static NetworkManager mInstance = null;

    private String mBaseUrl = null;
    private Context mContext = null;

    private NetworkManager() {
    }

    public static NetworkManager getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkManager();
        }

        return mInstance;
    }

    public void init(String baseUrl, Context context) {
        this.mBaseUrl = baseUrl;
        this.mContext = context;
    }

    public GitHubRestAPI getGitHubRestAPI() {
        if (mBaseUrl == null) {
            return null;
        }

        return buildRetrofit().create(GitHubRestAPI.class);
    }

    private Retrofit buildRetrofit() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void showWeb(String url) {
        if (mContext == null) {
            return;
        }

        if (url == null || url.length() < 10 || !url.startsWith("http")) {
            Toast.makeText(mContext, "The hompage url is null or wrong.", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(mContext, "error url = " + url, Toast.LENGTH_LONG).show();
        }
    }
}
