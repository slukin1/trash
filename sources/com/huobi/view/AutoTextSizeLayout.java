package com.huobi.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;

public class AutoTextSizeLayout extends LinearLayout implements TextWatcher {
    public List<TextView> list = new LinkedList();

    public AutoTextSizeLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public void calcTextSize() {
        int childCount;
        if (this.list != null && (childCount = getChildCount()) > 0) {
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (!this.list.contains(textView)) {
                        this.list.add(textView);
                    }
                    textView.addTextChangedListener(this);
                }
                if (childAt.getVisibility() == 0) {
                    i11 += childAt.getMeasuredWidth();
                }
            }
            if (i11 >= getMeasuredWidth()) {
                for (int i13 = 0; i13 < this.list.size(); i13++) {
                    TextView textView2 = this.list.get(i13);
                    textView2.setTextSize(0, textView2.getTextSize() - 1.0f);
                    requestLayout();
                }
            }
        }
    }

    public void afterTextChanged(Editable editable) {
        invalidate();
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        List<TextView> list2 = this.list;
        if (list2 != null) {
            list2.clear();
            this.list = null;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        post(new n(this));
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public AutoTextSizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoTextSizeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
