package com.tencent.qcloud.tuikit.timcommon.minimalistui.widget.message;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huobi.view.roundimg.RoundedDrawable;
import com.tencent.qcloud.tuikit.timcommon.R;

public class TimeInLineTextLayout extends FrameLayout {
    private MessageStatusTimeView statusArea;
    private TextView textView;

    public TimeInLineTextLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TextView textView2 = new TextView(context, (AttributeSet) null, R.style.ChatMinimalistMessageTextStyle);
        this.textView = textView2;
        textView2.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        TextView textView3 = this.textView;
        textView3.setTextSize(0, textView3.getResources().getDimension(R.dimen.chat_minimalist_message_text_size));
        addView(this.textView, new FrameLayout.LayoutParams(-2, -2));
        this.statusArea = new MessageStatusTimeView(context);
        addView(this.statusArea, new FrameLayout.LayoutParams(-2, -2));
    }

    public TextView getTextView() {
        return this.textView;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.textView.layout(0, 0, this.textView.getMeasuredWidth(), this.textView.getMeasuredHeight());
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        this.statusArea.layout(i15 - this.statusArea.getMeasuredWidth(), i16 - this.statusArea.getMeasuredHeight(), i15, i16);
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        measureChildren(i11, i12);
        int measuredWidth = this.textView.getMeasuredWidth();
        int measuredHeight = this.textView.getMeasuredHeight();
        int lineCount = this.textView.getLineCount();
        Layout layout = this.textView.getLayout();
        if (layout != null) {
            int i16 = lineCount - 1;
            int lineStart = layout.getLineStart(i16);
            i13 = (int) (layout.getSecondaryHorizontal(layout.getLineEnd(i16)) - layout.getPrimaryHorizontal(lineStart));
        } else {
            i13 = 0;
        }
        int measuredWidth2 = this.statusArea.getMeasuredWidth();
        int measuredHeight2 = this.statusArea.getMeasuredHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.statusArea.getLayoutParams();
        int i17 = measuredWidth2 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        int i18 = i13 + i17;
        if (i18 > View.MeasureSpec.getSize(i11)) {
            i15 = measuredHeight + measuredHeight2;
            i14 = Math.max(measuredWidth, i17);
        } else {
            i15 = Math.max(measuredHeight, measuredHeight2);
            i14 = Math.max(measuredWidth, i18);
        }
        setMeasuredDimension(i14, i15);
    }

    public void setOnStatusAreaClickListener(View.OnClickListener onClickListener) {
        this.statusArea.setOnClickListener(onClickListener);
    }

    public void setOnStatusAreaLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.statusArea.setOnLongClickListener(onLongClickListener);
    }

    public void setStatusIcon(int i11) {
        this.statusArea.setStatusIcon(i11);
    }

    public void setText(CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public void setTextColor(int i11) {
        this.textView.setTextColor(i11);
    }

    public void setTextSize(int i11) {
        this.textView.setTextSize((float) i11);
    }

    public void setTimeColor(int i11) {
        this.statusArea.setTimeColor(i11);
    }

    public void setTimeText(CharSequence charSequence) {
        this.statusArea.setTimeText(charSequence);
    }

    public void setText(int i11) {
        this.textView.setText(i11);
    }

    public TimeInLineTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public TimeInLineTextLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
