package com.huobi.view.wheelview.timer;

import com.huobi.view.wheelview.WheelView;
import java.util.TimerTask;

public final class SmoothScrollTimerTask extends TimerTask {
    private int offset;
    private int realOffset = 0;
    private int realTotalOffset = Integer.MAX_VALUE;
    private final WheelView wheelView;

    public SmoothScrollTimerTask(WheelView wheelView2, int i11) {
        this.wheelView = wheelView2;
        this.offset = i11;
    }

    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        int i11 = this.realTotalOffset;
        int i12 = (int) (((float) i11) * 0.1f);
        this.realOffset = i12;
        if (i12 == 0) {
            if (i11 < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(i11) <= 1) {
            this.wheelView.cancelFuture();
            this.wheelView.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView2 = this.wheelView;
        wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() + ((float) this.realOffset));
        if (!this.wheelView.isLoop()) {
            float itemHeight = this.wheelView.getItemHeight();
            float f11 = ((float) (-this.wheelView.getInitPosition())) * itemHeight;
            float itemsCount = ((float) ((this.wheelView.getItemsCount() - 1) - this.wheelView.getInitPosition())) * itemHeight;
            if (this.wheelView.getTotalScrollY() <= f11 || this.wheelView.getTotalScrollY() >= itemsCount) {
                WheelView wheelView3 = this.wheelView;
                wheelView3.setTotalScrollY(wheelView3.getTotalScrollY() - ((float) this.realOffset));
                this.wheelView.cancelFuture();
                this.wheelView.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.wheelView.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
