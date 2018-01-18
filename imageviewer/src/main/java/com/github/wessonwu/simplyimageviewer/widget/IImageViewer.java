package com.github.wessonwu.simplyimageviewer.widget;

import android.view.View;

import com.github.wessonwu.simplyimageviewer.entity.ImageItem;

/**
 * Created by Wesson on 2018/1/18.
 */

public interface IImageViewer {
    void bind(ImageItem imageItem);
    View getImageView();
}
