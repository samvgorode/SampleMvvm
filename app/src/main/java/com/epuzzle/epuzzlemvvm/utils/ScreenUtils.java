package com.epuzzle.epuzzlemvvm.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ScreenUtils {

    @Inject
    public ScreenUtils() {}

    public float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

}
