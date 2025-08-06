package com.twitter.sdk.android.tweetui.internal;

import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SpanClickHandler {
    private HighlightedClickableSpan highlightedClickableSpan;
    private Layout layout;
    private float left;
    private float top;
    private final View view;

    public SpanClickHandler(View view2, Layout layout2) {
        this.view = view2;
        this.layout = layout2;
    }

    private void deselectSpan() {
        HighlightedClickableSpan highlightedClickableSpan2 = this.highlightedClickableSpan;
        if (highlightedClickableSpan2 != null && highlightedClickableSpan2.isSelected()) {
            highlightedClickableSpan2.select(false);
            this.highlightedClickableSpan = null;
            invalidate();
        }
    }

    public static void enableClicksOnSpans(TextView textView) {
        textView.setOnTouchListener(new b(new SpanClickHandler(textView, (Layout) null)));
    }

    private void invalidate() {
        View view2 = this.view;
        float f11 = this.left;
        view2.invalidate((int) f11, (int) this.top, ((int) f11) + this.layout.getWidth(), ((int) this.top) + this.layout.getHeight());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$enableClicksOnSpans$0(SpanClickHandler spanClickHandler, View view2, MotionEvent motionEvent) {
        TextView textView = (TextView) view2;
        Layout layout2 = textView.getLayout();
        if (layout2 == null) {
            return false;
        }
        spanClickHandler.layout = layout2;
        spanClickHandler.left = (float) (textView.getTotalPaddingLeft() + textView.getScrollX());
        spanClickHandler.top = (float) (textView.getTotalPaddingTop() + textView.getScrollY());
        return spanClickHandler.handleTouchEvent(motionEvent);
    }

    private void selectSpan(HighlightedClickableSpan highlightedClickableSpan2) {
        highlightedClickableSpan2.select(true);
        this.highlightedClickableSpan = highlightedClickableSpan2;
        invalidate();
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        HighlightedClickableSpan highlightedClickableSpan2;
        CharSequence text = this.layout.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x11 = (int) (motionEvent.getX() - this.left);
        int y11 = (int) (motionEvent.getY() - this.top);
        if (x11 < 0 || x11 >= this.layout.getWidth() || y11 < 0 || y11 >= this.layout.getHeight()) {
            deselectSpan();
            return false;
        }
        int lineForVertical = this.layout.getLineForVertical(y11);
        float f11 = (float) x11;
        if (f11 < this.layout.getLineLeft(lineForVertical) || f11 > this.layout.getLineRight(lineForVertical)) {
            deselectSpan();
            return false;
        }
        if (action == 0) {
            int offsetForHorizontal = this.layout.getOffsetForHorizontal(lineForVertical, f11);
            HighlightedClickableSpan[] highlightedClickableSpanArr = (HighlightedClickableSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, HighlightedClickableSpan.class);
            if (highlightedClickableSpanArr.length > 0) {
                selectSpan(highlightedClickableSpanArr[0]);
                return true;
            }
        } else if (action == 1 && (highlightedClickableSpan2 = this.highlightedClickableSpan) != null) {
            highlightedClickableSpan2.onClick(this.view);
            deselectSpan();
            return true;
        }
        return false;
    }
}
