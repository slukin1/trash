package com.huochat.community.widget.expandable;

import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.r;

public final class FixLinkMovementTouchListener implements View.OnTouchListener {
    private static final long CLICK_DELAY = 500;
    public static final Companion Companion = new Companion((r) null);
    private long lastClickTime;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        TextView textView = (TextView) view;
        Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
        int action = motionEvent.getAction();
        if (action == 0 || action == 1) {
            int x11 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y11 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x11 + textView.getScrollX();
            int scrollY = y11 + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (!(clickableSpanArr.length == 0)) {
                if (action == 0) {
                    this.lastClickTime = System.currentTimeMillis();
                } else if (action == 1 && System.currentTimeMillis() - this.lastClickTime < 500) {
                    clickableSpanArr[0].onClick(textView);
                    return true;
                }
            }
        }
        return false;
    }
}
