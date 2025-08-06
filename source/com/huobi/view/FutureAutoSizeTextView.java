package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$styleable;
import i6.d;

public class FutureAutoSizeTextView extends AppCompatTextView {
    private boolean mInvalidate;
    private String mLastText;
    private float mMinTextSize;
    private float mOriginWidth;
    private float mTextSize;
    private int subTextSize;

    public FutureAutoSizeTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FutureAutoSizeTextView);
        this.mMinTextSize = obtainStyledAttributes.getDimension(R$styleable.FutureAutoSizeTextView_auto_min_text_size, getResources().getDimension(R$dimen.global_text_size_6));
        this.mTextSize = getTextSize();
        this.subTextSize = PixelUtils.a(1.0f);
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mInvalidate) {
            float measureText = getPaint().measureText(getText().toString());
            d.b("==============" + measureText + "===" + getWidth() + "====" + this.mOriginWidth + "=======" + getTextSize());
            if (measureText <= ((float) getWidth()) || getWidth() == 0) {
                if (getTextSize() != this.mTextSize && this.mOriginWidth < ((float) getWidth())) {
                    setTextSize(0, this.mTextSize);
                    invalidate();
                }
                this.mInvalidate = false;
            } else if (getTextSize() > this.mMinTextSize) {
                setTextSize(0, getTextSize() - ((float) this.subTextSize));
                setMaxLines(1);
                invalidate();
            } else if (getMaxLines() == 1) {
                setMaxLines(2);
                invalidate();
            }
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.mOriginWidth = getPaint().measureText(getText().toString());
        if (this.mLastText == null || !charSequence.toString().equals(this.mLastText)) {
            this.mInvalidate = true;
        }
        this.mLastText = charSequence.toString();
    }

    public FutureAutoSizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FutureAutoSizeTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mInvalidate = true;
        init(context, attributeSet);
    }
}
