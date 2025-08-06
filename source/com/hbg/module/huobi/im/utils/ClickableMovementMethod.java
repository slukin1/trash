package com.hbg.module.huobi.im.utils;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import rd.b;

public class ClickableMovementMethod extends LinkMovementMethod {
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x11 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y11 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x11 + textView.getScrollX();
            int scrollY = y11 + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            b[] bVarArr = (b[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, b.class);
            ClickableForegroundColorSpan[] clickableForegroundColorSpanArr = (ClickableForegroundColorSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableForegroundColorSpan.class);
            if (action == 0 && !((bVarArr == null || bVarArr.length == 0) && (clickableForegroundColorSpanArr == null || clickableForegroundColorSpanArr.length == 0))) {
                textView.setTag(Boolean.TRUE);
            }
            if (clickableSpanArr != null && clickableSpanArr.length != 0) {
                if (action == 1 && clickableSpanArr[0] != null) {
                    clickableSpanArr[0].onClick(textView);
                }
                return true;
            } else if (clickableForegroundColorSpanArr.length != 0) {
                if (action == 1) {
                    textView.setTag(Boolean.FALSE);
                    clickableForegroundColorSpanArr[0].onClick(textView);
                }
                return true;
            } else if (bVarArr == null || bVarArr.length == 0) {
                Selection.removeSelection(spannable);
            } else {
                if (action == 1) {
                    textView.setTag(Boolean.FALSE);
                    if (bVarArr[0] != null) {
                        bVarArr[0].a(textView);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
