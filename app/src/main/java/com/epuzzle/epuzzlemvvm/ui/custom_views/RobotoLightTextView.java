package com.epuzzle.epuzzlemvvm.ui.custom_views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RobotoLightTextView extends android.support.v7.widget.AppCompatTextView {

    public RobotoLightTextView(Context context) {
        super(context);
        init();
    }

    public RobotoLightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoLightTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto_light.ttf");
        setTypeface(face);
    }
}

