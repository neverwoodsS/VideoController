package com.zy.open.videocontroller.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.zy.open.videocontroller.R;
import com.zy.open.videocontroller.controller.BottomController;
import com.zy.open.videocontroller.controller.TopController;

/**
 * Created by zhangll on 16/8/19.
 */
public class ControllersView extends RelativeLayout {

    private Context context;

    private View topView;
    private View bottomView;

    private ControllerManager controllerManager;


    public ControllersView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() {
        View rootView = LayoutInflater.from(context).inflate(R.layout.layout_control, null);

        topView = rootView.findViewById(R.id.ll_top);
        bottomView = rootView.findViewById(R.id.rl_bottom);

        controllerManager = new ControllerManager();
        controllerManager.addController(new TopController(topView))
                .addController(new BottomController(bottomView))
                .init();

        rootView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                controllerManager.switchState();
            }
        });

        addView(rootView);
    }
}