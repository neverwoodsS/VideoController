package com.zy.open.videocontroller.base;

import android.animation.ValueAnimator;
import android.view.View;

import com.zy.open.videocontroller.interfaces.Controller;

/**
 * Created by zhangll on 16/8/19.
 */
public abstract class ValueAnimatorController implements Controller {

    protected abstract int getShowTarget();
    protected abstract int getHideTarget();
    protected abstract void onShiftChanged(int shift);

    protected View view;
    protected ValueAnimator va;
    protected int shift;

    public ValueAnimatorController(View view) {
        this.view = view;
    }

    @Override
    public void show() {
        stop();
        makeAnimation(getShowTarget());
    }

    @Override
    public void hide() {
        stop();
        makeAnimation(getHideTarget());
    }

    private void stop() {
        if (va != null) {
            va.cancel();
        }
    }

    protected void makeAnimation(int target) {
        va = ValueAnimator.ofInt(shift, target);
        va.setDuration(DURATION);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                shift = (int) animation.getAnimatedValue();
                onShiftChanged(shift);
            }
        });
        va.start();
    }
}