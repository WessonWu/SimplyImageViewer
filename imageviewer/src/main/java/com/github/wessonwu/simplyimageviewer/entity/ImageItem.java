package com.github.wessonwu.simplyimageviewer.entity;

import android.graphics.Point;

import java.io.File;

/**
 * Created by Wesson on 2018/1/18.
 */

public class ImageItem {
    public final static int FLAG_DECODED = 1;
    public final static int FLAG_GIF = 1 << 1;
    public final static int FLAG_HUGE = 1 << 2;

    private final String mUrl;

    File mLocalFile;

    float mMinScale;
    float mMaxScale;
    float mFitScale;

    Point mFitSize;

    private int mFlags = 0;

    public ImageItem(String url) {
        mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public File getLocalFile() {
        return mLocalFile;
    }

    public float getMinScale() {
        return mMinScale;
    }

    public float getMaxScale() {
        return mMaxScale;
    }

    public float getFitScale() {
        return mFitScale;
    }

    public Point getFitSize() {
        return mFitSize;
    }

    boolean containFlags(int flags) {
        return (mFlags & flags) != 0;
    }

    void addFlags(int flags) {
        mFlags |= flags;
    }

    void removeFlags(int flags) {
        mFlags &= ~flags;
    }
}
