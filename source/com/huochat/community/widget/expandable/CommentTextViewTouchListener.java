package com.huochat.community.widget.expandable;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class CommentTextViewTouchListener implements View.OnTouchListener {
    private long mLastActionDownTime = -1;
    private View.OnClickListener mOnClickListener;
    private View.OnLongClickListener mOnLongClickListener;

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        int action = motionEvent.getAction();
        TextView textView = (TextView) view;
        CharSequence text = textView.getText();
        if (action == 0) {
            this.mLastActionDownTime = System.currentTimeMillis();
        } else if (action == 1) {
            if (System.currentTimeMillis() - this.mLastActionDownTime >= ((long) ViewConfiguration.getLongPressTimeout()) && (onLongClickListener = this.mOnLongClickListener) != null) {
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
                    View.OnClickListener onClickListener = this.mOnClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            } else {
                View.OnClickListener onClickListener2 = this.mOnClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        }
        return true;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }
}
