package com.my.demo.repoexplorer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.demo.repoexplorer.R;
import com.my.demo.repoexplorer.model.Repo;
import com.my.demo.repoexplorer.network.AsyncImageDownloader;
import com.my.demo.repoexplorer.network.NetworkManager;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private List<Repo> mDataList = null;
    private ViewGroup mViewGroup = null;

    public MainListAdapter(List<Repo> dataList) {
        mDataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        this.mViewGroup = viewGroup;

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mainlist_repoinfo, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (mDataList == null) {
            return;
        }

        try {
            final Repo repo = mDataList.get(position);
            AsyncImageDownloader.load(repo.owner.avatarUrl, viewHolder.getImageViewThumb(), mViewGroup.getContext(), false);
            viewHolder.getTextViewTitle().setText(repo.name);
            viewHolder.getTextViewContent().setText(repo.description);
            viewHolder.getTextViewStarCount().setText(String.valueOf(repo.stargazersCount));

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String url = repo.homepage;

                    NetworkManager.getInstance().showWeb(url);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if (mDataList == null) {
            return 0;
        }

        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageViewThumb = null;
        private TextView mtextViewTitle = null;
        private TextView mtextViewContent = null;
        private TextView mtextViewStarCount = null;

        public ViewHolder(View v) {
            super(v);

            mImageViewThumb = (ImageView) itemView.findViewById(R.id.image_mainlist_thumb);
            mtextViewTitle = (TextView) itemView.findViewById(R.id.text_mainlist_title);
            mtextViewContent = (TextView) itemView.findViewById(R.id.text_mainlist_content);
            mtextViewStarCount = (TextView) itemView.findViewById(R.id.text_mainlist_starcount);
        }

        public ImageView getImageViewThumb() {
            return mImageViewThumb;
        }

        public TextView getTextViewTitle() {
            return mtextViewTitle;
        }

        public TextView getTextViewContent() {
            return mtextViewContent;
        }

        public TextView getTextViewStarCount() {
            return mtextViewStarCount;
        }
    }
}