package com.github.wessonwu.simplyimageviewer.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.github.wessonwu.simplyimageviewer.entity.ImageItem;
import com.github.wessonwu.simplyimageviewer.widget.ImageViewerItemHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wesson on 2018/1/18.
 */

public class ImageViewerPagerAdapter extends PagerAdapter {

    private final Context mContext;
    private final List<ImageItem> mImageItems;
    private final ImageViewerItemHolder.Recycler mHolderRecycler;

    public ImageViewerPagerAdapter(Context context) {
        mContext = context;
        mImageItems = new ArrayList<>();
        mHolderRecycler = new ImageViewerItemHolder.Recycler();
    }

    public void setImageUrls(List<String> urls) {
        mImageItems.clear();
        if (urls != null && urls.size() != 0) {
            for (String url : urls) {
                mImageItems.add(new ImageItem(url));
            }
        }
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mImageItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageItem item = mImageItems.get(position);

        ImageViewerItemHolder holder = mHolderRecycler.obtain(mContext);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        container.addView(holder, lp);

        holder.bind(item);

        return holder;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageViewerItemHolder holder = (ImageViewerItemHolder) object;
        container.removeView(holder);
        mHolderRecycler.recycle(holder);
    }
}
