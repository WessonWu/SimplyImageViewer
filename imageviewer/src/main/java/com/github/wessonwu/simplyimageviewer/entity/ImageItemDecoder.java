package com.github.wessonwu.simplyimageviewer.entity;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.DisplayMetrics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Wesson on 2018/1/18.
 */

public class ImageItemDecoder {
    public static void decode(Context context, ImageItem item) {
        decode(context, item, new File(item.getUrl()));
    }

    public static void decode(Context context, ImageItem item, File file) {
        if (context == null
                || item == null
                || file == null
                || !file.exists()) {
            return;
        }

        item.addFlags(ImageItem.FLAG_DECODED);
    }


    private final static float DEFAULT_MIN_SCALE = 1f;
    private final static float DEFAULT_MAX_SCALE = 4f;

    private static void computeScaleAndSize(Context context, File file, ImageItem imageItem) {
        //Get the image's size.
        Point size = getBitmapSize(file);
        float width = size.x;
        float height = size.y;

        //Get the screen's width and height.
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float screenWidth = metrics.widthPixels;
        float screenHeight = metrics.heightPixels;

        if (Float.compare(width, 0) <= 0
                || Float.compare(height, 0) <= 0) {
            width = screenWidth / 2;
            height = width;
        }

        float minScale = DEFAULT_MIN_SCALE;
        float maxScale = DEFAULT_MAX_SCALE;
        float fitScale = minScale;

        float tempMinScale = Math.min(screenWidth / width, screenHeight / height);
        if (Float.compare(tempMinScale, DEFAULT_MIN_SCALE) > 0) {

        }
    }

    private static Point getBitmapSize(File file) {
        InputStream is = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;

            is = new FileInputStream(file);
            BitmapFactory.decodeStream(is, null, options);

            return new Point(options.outWidth, options.outHeight);
        } catch (FileNotFoundException e) {
            return new Point(0, 0);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
