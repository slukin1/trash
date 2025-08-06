package com.hbg.module.huobi.im.utils;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import rd.p;
import rd.t;

public class LinkMovementMethodInterceptor extends LinkMovementMethod {

    /* renamed from: a  reason: collision with root package name */
    public p f20545a;

    public void a(p pVar) {
        this.f20545a = pVar;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x11 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y11 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x11 + textView.getScrollX();
            int scrollY = y11 + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, t.class);
            if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    if (offsetForHorizontal < textView.getText().length() && (clickableSpanArr[0] instanceof t)) {
                        t tVar = (t) clickableSpanArr[0];
                        if (!TextUtils.isEmpty(tVar.a())) {
                            p pVar = this.f20545a;
                            if (pVar != null) {
                                pVar.onClickUrl(tVar.a());
                            }
                            return true;
                        }
                        clickableSpanArr[0].onClick(textView);
                    }
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                }
                return true;
            }
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
