package com.hbg.lib.widgets.expandable;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class CommentTextViewTouchListener implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f71957b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnLongClickListener f71958c;

    /* renamed from: d  reason: collision with root package name */
    public long f71959d = -1;

    public void a(View.OnClickListener onClickListener) {
        this.f71957b = onClickListener;
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.f71958c = onLongClickListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        int action = motionEvent.getAction();
        TextView textView = (TextView) view;
        CharSequence text = textView.getText();
        if (action == 0) {
            this.f71959d = System.currentTimeMillis();
        } else if (action == 1) {
            if (System.currentTimeMillis() - this.f71959d >= ((long) ViewConfiguration.getLongPressTimeout()) && (onLongClickListener = this.f71958c) != null) {
                onLongClickListener.onLongClick(view);
                return false;
            } else if (text instanceof Spanned) {
                int x11 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y11 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x11 + textView.getScrollX();
                int scrollY = y11 + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    clickableSpanArr[0].onClick(textView);
                } else {
                    View.OnClickListener onClickListener = this.f71957b;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            } else {
                View.OnClickListener onClickListener2 = this.f71957b;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        }
        return true;
    }
}
