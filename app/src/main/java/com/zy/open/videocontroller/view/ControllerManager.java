package com.zy.open.videocontroller.view;

import android.os.CountDownTimer;
import com.zy.open.videocontroller.interfaces.Controller;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangll on 16/8/19.
 */
public class ControllerManager {

    private boolean showing = true;
    private List<Controller> controllerList = new ArrayList<>();
    private CountDownTimer countDownTimer;

    public ControllerManager addController(Controller controller) {
        controllerList.add(controller);
        return this;
    }

    public ControllerManager init() {
        startCount();
        return this;
    }

    public boolean isShowing() {
        return showing;
    }

    public void switchState() {
        stopCount();
        showing = !showing;
        if (showing) {
            show();
        } else {
            hide();
        }
    }

    private void show() {
        for (Controller controller : controllerList) {
            controller.show();
        }
        startCount();
    }

    private void hide() {
        for (Controller controller : controllerList) {
            controller.hide();
        }
    }

    private void startCount() {
        countDownTimer = new CountDownTimer(2500, 2500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                switchState();
            }
        }.start();
    }

    private void stopCount() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}