package com.epuzzle.epuzzlemvvm.ui.custom_views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RobotoRegularTextview extends android.support.v7.widget.AppCompatTextView {

    public RobotoRegularTextview(Context context) {
        super(context);
        init();
    }

    public RobotoRegularTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoRegularTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto_regular.ttf");
        setTypeface(face);
    }
}
