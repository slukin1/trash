package com.huobi.view.wraplayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hbg.lib.widgets.R$dimen;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.LinkedList;
import java.util.List;

public class AutoWrapLayout extends LinearLayout {
    private List<View> allViews = new LinkedList();
    private int closeViewResource;
    private OnClickListener mListener;
    private boolean openState;
    private int openViewResource;
    private int rightMargin = 20;
    private final List<List<View>> rows = new LinkedList();

    public interface OnClickListener {
        void callback(boolean z11);
    }

    public AutoWrapLayout(Context context) {
        super(context);
        setOrientation(1);
    }

    private void addOperationView(LinearLayout linearLayout, int i11, int i12) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(i12);
        imageView.measure(0, 0);
        imageView.setOnClickListener(new a(this));
        if (i11 + imageView.getMeasuredWidth() > getWidth()) {
            linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
            linearLayout.addView(imageView);
            return;
        }
        linearLayout.addView(imageView);
    }

    private void initView(Context context) {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            ((ViewGroup) getChildAt(i11)).removeAllViews();
        }
        removeAllViews();
        int size = this.allViews.size();
        this.rows.clear();
        this.rows.add(new LinkedList());
        if (size > 0) {
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                View view = this.allViews.get(i14);
                view.measure(0, 0);
                int measuredWidth = view.getMeasuredWidth() + this.rightMargin;
                i12 += measuredWidth;
                if (i12 > getMeasuredWidth()) {
                    i13++;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(view);
                    this.rows.add(linkedList);
                    i12 = measuredWidth + this.rightMargin;
                } else {
                    this.rows.get(i13).add(view);
                }
            }
        }
        int size2 = this.rows.size();
        if (this.openState) {
            if (size2 > 4) {
                size2 = 4;
            }
        } else if (size2 > 2) {
            size2 = 2;
        }
        for (int i15 = 0; i15 < size2; i15++) {
            List list = this.rows.get(i15);
            LinearLayout linearLayout = new LinearLayout(context);
            int i16 = 0;
            for (int i17 = 0; i17 < list.size(); i17++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                View view2 = (View) list.get(i17);
                int measuredWidth2 = view2.getMeasuredWidth();
                layoutParams.rightMargin = this.rightMargin;
                layoutParams.height = getResources().getDimensionPixelSize(R$dimen.dimen_28);
                layoutParams.width = measuredWidth2;
                linearLayout.addView(view2, layoutParams);
                i16 = i16 + measuredWidth2 + this.rightMargin;
            }
            if (this.rows.size() > 2 && i15 == size2 - 1) {
                if (this.openState) {
                    addOperationView(linearLayout, i16, this.openViewResource);
                } else {
                    addOperationView(linearLayout, i16, this.closeViewResource);
                }
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R$dimen.dimen_10);
            addView(linearLayout, layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addChildView$2() {
        initView(getContext());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addOperationView$0() {
        initView(getContext());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addOperationView$1(View view) {
        this.openState = !this.openState;
        post(new c(this));
        OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            onClickListener.callback(this.openState);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addChildView(List<View> list) {
        synchronized (this.rows) {
            this.allViews.clear();
            this.allViews.addAll(list);
            post(new b(this));
        }
    }

    public void setListener(OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void setStateImage(int i11, int i12) {
        this.openViewResource = i11;
        this.closeViewResource = i12;
    }

    public AutoWrapLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.rightMargin = getResources().getDimensionPixelSize(R$dimen.dimen_10);
    }
}
