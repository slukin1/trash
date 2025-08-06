package com.huobi.view.wheelview.timer;

import android.os.Handler;
import android.os.Message;
import com.huobi.view.wheelview.WheelView;

public final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    private final WheelView wheelView;

    public MessageHandler(WheelView wheelView2) {
        this.wheelView = wheelView2;
    }

    public final void handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 1000) {
            this.wheelView.invalidate();
        } else if (i11 == 2000) {
            this.wheelView.smoothScroll(WheelView.ACTION.FLING);
        } else if (i11 == 3000) {
            this.wheelView.onItemSelected();
        }
    }
}
