package com.example.mvvm.ui.custom_views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class FocusRelativeLayout extends RelativeLayout {

    private AnimatorSet zoomIn;
    private AnimatorSet zoomOut;

    public FocusRelativeLayout(Context context) {
        super(context);
    }

    public FocusRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FocusRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus) {
            zoomIn();
        } else {
            zoomOut();
        }
    }

    private void zoomIn() {
        if (zoomIn == null) {
            zoomIn = new AnimatorSet();
            zoomIn.playTogether(
                    ObjectAnimator.ofFloat(this, View.SCALE_X, 1.3f),
                    ObjectAnimator.ofFloat(this, View.SCALE_Y, 1.3f)
            );
            zoomIn.setDuration(150);
        }
        zoomIn.start();
    }

    private void zoomOut() {
        if (zoomOut == null) {
            zoomOut = new AnimatorSet();
            zoomOut.playTogether(
                    ObjectAnimator.ofFloat(this, View.SCALE_X, 1.0f),
                    ObjectAnimator.ofFloat(this, View.SCALE_Y, 1.0f)
            );
            zoomOut.setDuration(150);
        }
        zoomOut.start();
    }
}
