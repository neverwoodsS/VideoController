package com.zy.open.videocontroller.controller;

import android.view.View;
import android.widget.LinearLayout;

import com.zy.open.videocontroller.base.ValueAnimatorController;
import com.zy.open.videocontroller.interfaces.Controller;

/**
 * Created by zhangll on 16/8/19.
 */
public class TopController extends ValueAnimatorController {

    public TopController(View view) {
        super(view);
    }

    @Override
    protected int getShowTarget() {
        return 0;
    }

    @Override
    protected int getHideTarget() {
        return view.getHeight();
    }

    @Override
    protected void onShiftChanged(int shift) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        params.setMargins(params.leftMargin, -shift, params.rightMargin, params.bottomMargin);
        view.setLayoutParams(params);
    }
}