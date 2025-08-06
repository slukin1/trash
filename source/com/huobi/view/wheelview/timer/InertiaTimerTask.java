package com.huobi.view.wheelview.timer;

import com.huobi.view.wheelview.WheelView;
import java.util.TimerTask;

public final class InertiaTimerTask extends TimerTask {
    private float mCurrentVelocityY = 2.14748365E9f;
    private final float mFirstVelocityY;
    private final WheelView mWheelView;

    public InertiaTimerTask(WheelView wheelView, float f11) {
        this.mWheelView = wheelView;
        this.mFirstVelocityY = f11;
    }

    public final void run() {
        if (this.mCurrentVelocityY == 2.14748365E9f) {
            float f11 = 2000.0f;
            if (Math.abs(this.mFirstVelocityY) > 2000.0f) {
                if (this.mFirstVelocityY <= 0.0f) {
                    f11 = -2000.0f;
                }
                this.mCurrentVelocityY = f11;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (Math.abs(this.mCurrentVelocityY) < 0.0f || Math.abs(this.mCurrentVelocityY) > 20.0f) {
            WheelView wheelView = this.mWheelView;
            float f12 = (float) ((int) (this.mCurrentVelocityY / 100.0f));
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f12);
            if (!this.mWheelView.isLoop()) {
                float itemHeight = this.mWheelView.getItemHeight();
                float f13 = ((float) (-this.mWheelView.getInitPosition())) * itemHeight;
                float itemsCount = ((float) ((this.mWheelView.getItemsCount() - 1) - this.mWheelView.getInitPosition())) * itemHeight;
                double d11 = ((double) itemHeight) * 0.25d;
                if (((double) this.mWheelView.getTotalScrollY()) - d11 < ((double) f13)) {
                    f13 = this.mWheelView.getTotalScrollY() + f12;
                } else if (((double) this.mWheelView.getTotalScrollY()) + d11 > ((double) itemsCount)) {
                    itemsCount = this.mWheelView.getTotalScrollY() + f12;
                }
                if (this.mWheelView.getTotalScrollY() <= f13) {
                    this.mCurrentVelocityY = 40.0f;
                    this.mWheelView.setTotalScrollY((float) ((int) f13));
                } else if (this.mWheelView.getTotalScrollY() >= itemsCount) {
                    this.mWheelView.setTotalScrollY((float) ((int) itemsCount));
                    this.mCurrentVelocityY = -40.0f;
                }
            }
            float f14 = this.mCurrentVelocityY;
            if (f14 < 0.0f) {
                this.mCurrentVelocityY = f14 + 20.0f;
            } else {
                this.mCurrentVelocityY = f14 - 20.0f;
            }
            this.mWheelView.getHandler().sendEmptyMessage(1000);
            return;
        }
        this.mWheelView.cancelFuture();
        this.mWheelView.getHandler().sendEmptyMessage(2000);
    }
}
