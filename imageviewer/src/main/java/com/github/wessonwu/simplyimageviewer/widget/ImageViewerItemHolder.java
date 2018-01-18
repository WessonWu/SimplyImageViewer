package com.github.wessonwu.simplyimageviewer.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.wessonwu.simplyimageviewer.entity.ImageItem;

import java.util.ArrayList;

/**
 * Created by Wesson on 2018/1/18.
 */

public class ImageViewerItemHolder extends RelativeLayout implements IImageViewer {

    private IImageViewer mImageViewer;

    public ImageViewerItemHolder(Context context) {
        super(context);
        init(context);
    }

    public ImageViewerItemHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageViewerItemHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ImageViewerItemHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {

    }

    @Override
    public void bind(ImageItem imageItem) {

    }

    @Override
    public View getImageView() {
        return mImageViewer.getImageView();
    }

    protected void onDestroy() {

    }

    public static class Recycler {
        private final static int DEFAULT_CAPACITY = 5;
        private ArrayList<ImageViewerItemHolder> mHolders = new ArrayList<>(DEFAULT_CAPACITY);

        public ImageViewerItemHolder obtain(Context context) {
            ImageViewerItemHolder holder;
            synchronized (mHolders) {
                if (mHolders.size() > 0) {
                    holder = mHolders.remove(0);
                } else {
                    holder = new ImageViewerItemHolder(context);
                }
            }
            return holder;
        }

        public void recycle(ImageViewerItemHolder holder) {
            if (holder == null) {
                return;
            }
            holder.onDestroy();
            synchronized (mHolders) {
                if (mHolders.size() < DEFAULT_CAPACITY) {
                    mHolders.add(holder);
                }
            }
        }
    }
}
