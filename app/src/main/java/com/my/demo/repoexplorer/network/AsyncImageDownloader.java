package com.my.demo.repoexplorer.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AsyncImageDownloader {

    public static void load(String url, final ImageView targetImageView, final Context context, final boolean isCircle) {
        if (url == null || targetImageView == null || context == null) {
            return;
        }

        Picasso.with(context).load(url).fit().into(targetImageView, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
                try {
                    if (isCircle) {
                        Bitmap imageBitmap = ((BitmapDrawable) targetImageView.getDrawable()).getBitmap();
                        RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), imageBitmap);
                        imageDrawable.setCircular(true);
                        imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
                        targetImageView.setImageDrawable(imageDrawable);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError() {
            }
        });
    }
}
