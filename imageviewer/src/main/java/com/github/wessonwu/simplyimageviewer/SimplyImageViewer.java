package com.github.wessonwu.simplyimageviewer;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wesson on 2018/1/18.
 */

public class SimplyImageViewer {
    private Activity mActivity;
    private ArrayList<String> mUrls = new ArrayList<>();
    private int mIndex = 0;

    private SimplyImageViewer(Activity activity) {
        mActivity = activity;
    }

    public static SimplyImageViewer from(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity can not be null.");
        }
        return new SimplyImageViewer(activity);
    }

    public SimplyImageViewer with(List<String> urls) {
        if (urls != null && urls.size() != 0) {
            mUrls.addAll(urls);
        }
        return this;
    }

    public SimplyImageViewer index(int index) {
        mIndex = Math.max(index, 0);
        return this;
    }

    public void show() {
        Intent intent = new Intent(mActivity, null);
        mActivity.startActivity(intent);
    }
}
