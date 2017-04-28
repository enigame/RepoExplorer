package com.my.demo.repoexplorer;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.my.demo.repoexplorer.adapter.MainListAdapter;
import com.my.demo.repoexplorer.model.Repo;
import com.my.demo.repoexplorer.model.User;
import com.my.demo.repoexplorer.network.AsyncImageDownloader;
import com.my.demo.repoexplorer.network.GitHubRestAPI;
import com.my.demo.repoexplorer.network.NetworkManager;
import com.my.demo.repoexplorer.utils.NetworkUtil;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GitHubRestAPI mGitHubRestAPI = null;
    private ProgressDialog mProgressDialog = null;

    private ImageView mImageViewUser = null;
    private TextView mTextViewUserName = null;
    private TextView mTextViewUserEmail = null;
    private TextView mTextViewUserCompany = null;
    private TextView mTextViewUserLocation = null;
    private TextView mTextViewUserBlog = null;
    private TextView mTextViewUserFollowers = null;
    private TextView mTextViewUserFollowing = null;
    private TextView mTextViewUserRepositories = null;

    private RecyclerView mRecyclerViewMainList = null;
    private RecyclerView.LayoutManager mLayoutManager = null;
    private MainListAdapter mMainListAdapter = null;
    private List<Repo> mRepoList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initProgressDialog();
        initNavView();
        initNetwork();
    }

    private void initProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait..");
        mProgressDialog.show();
    }

    private void initNavView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        if (headerView == null) {
            return;
        }

        mImageViewUser = (ImageView) headerView.findViewById(R.id.image_user);
        mTextViewUserName = (TextView) headerView.findViewById(R.id.text_username);
        mTextViewUserEmail = (TextView) headerView.findViewById(R.id.text_useremail);
        mTextViewUserCompany = (TextView) headerView.findViewById(R.id.text_usercompany);
        mTextViewUserLocation = (TextView) headerView.findViewById(R.id.text_userlocation);
        mTextViewUserBlog = (TextView) headerView.findViewById(R.id.text_userblog);
        mTextViewUserFollowers = (TextView) headerView.findViewById(R.id.text_userfollowers);
        mTextViewUserFollowing = (TextView) headerView.findViewById(R.id.text_userfollowing);
        mTextViewUserRepositories = (TextView) headerView.findViewById(R.id.text_userrepositories);
    }

    private void initMainList(List<Repo> repoList) {
        mRecyclerViewMainList = (RecyclerView) findViewById(R.id.recyclerview_mainlist);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerViewMainList.setLayoutManager(mLayoutManager);
        mMainListAdapter = new MainListAdapter(repoList);
        mRecyclerViewMainList.setAdapter(mMainListAdapter);
    }

    private void initNetwork() {
        if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {
            Toast.makeText(getApplicationContext(), "Network fails...", Toast.LENGTH_SHORT).show();

            return;
        }

        String userName = "jakewharton";
        String baseUrl = "https://api.github.com/";

        NetworkManager.getInstance().init(baseUrl, getApplicationContext());

        loadUserData(userName);
        loadUserRepoData(userName);
    }

    private void loadUserData(String userName) {
        try {
            mGitHubRestAPI = NetworkManager.getInstance().getGitHubRestAPI();
            Call<User> call = mGitHubRestAPI.getUser(userName);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response != null && response.isSuccessful()) {
                        User user = response.body();
                        setUserData(user);
                    }

                    mProgressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    mProgressDialog.dismiss();

                    Toast.makeText(getApplicationContext(), "onFailure : " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadUserRepoData(String userName) {
        try {
            mGitHubRestAPI = NetworkManager.getInstance().getGitHubRestAPI();
            Call<List<Repo>> call = mGitHubRestAPI.getUserRepos(userName);

            call.enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    if (response != null && response.isSuccessful()) {
                        mRepoList = response.body();

                        Collections.sort(mRepoList);

                        initMainList(mRepoList);
                    }

                    mProgressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {
                    mProgressDialog.dismiss();

                    Toast.makeText(getApplicationContext(), "onFailure : " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setUserData(User user) {
        if (user != null) {
            try {
                AsyncImageDownloader.load(user.avatarUrl, mImageViewUser, getApplicationContext(), true);

                mTextViewUserName.setText(user.name);
                mTextViewUserEmail.setText(user.email);
                mTextViewUserCompany.setText(user.company);
                mTextViewUserLocation.setText(user.location);
                mTextViewUserBlog.setText(user.blog);
                mTextViewUserFollowers.setText(String.valueOf(user.followers));
                mTextViewUserFollowing.setText(String.valueOf(user.following));
                mTextViewUserRepositories.setText(String.valueOf(user.publicRepos));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}