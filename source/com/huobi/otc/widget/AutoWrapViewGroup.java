package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcCancelReasonDataType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public class AutoWrapViewGroup extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public int f79645b;

    /* renamed from: c  reason: collision with root package name */
    public int f79646c;

    /* renamed from: d  reason: collision with root package name */
    public int f79647d;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcCancelReasonDataType.OnReasonClickListener f79648b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OtcCancelReasonDataType f79649c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OtcCancelReasonBean f79650d;

        public a(OtcCancelReasonDataType.OnReasonClickListener onReasonClickListener, OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean) {
            this.f79648b = onReasonClickListener;
            this.f79649c = otcCancelReasonDataType;
            this.f79650d = otcCancelReasonBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f79648b.onClick(this.f79649c, this.f79650d);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public AutoWrapViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int a(int i11, int i12, View view) {
        if (view instanceof TextView) {
            ((TextView) view).setMaxWidth(i11);
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        return view.getMeasuredWidth();
    }

    public void b(List<OtcCancelReasonBean> list) {
        int childCount = getChildCount();
        if (childCount > 0 && childCount == list.size()) {
            for (int i11 = 0; i11 < childCount; i11++) {
                TextView textView = (TextView) getChildAt(i11);
                Boolean valueOf = Boolean.valueOf(list.get(i11).isChecked());
                if (!valueOf.equals(Boolean.valueOf(textView.isSelected()))) {
                    textView.setSelected(valueOf.booleanValue());
                }
            }
        }
    }

    public void c(OtcCancelReasonDataType otcCancelReasonDataType, List<OtcCancelReasonBean> list, OtcCancelReasonDataType.OnReasonClickListener onReasonClickListener, int i11) {
        this.f79647d = i11;
        if (getChildCount() < list.size()) {
            while (getChildCount() < list.size()) {
                addView((TextView) View.inflate(getContext(), R$layout.item_cancel_subset_second_reason, (ViewGroup) null));
            }
        } else {
            while (getChildCount() > list.size()) {
                removeViewAt(getChildCount() - 1);
            }
        }
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            TextView textView = (TextView) getChildAt(i12);
            OtcCancelReasonBean otcCancelReasonBean = list.get(i12);
            textView.setText(otcCancelReasonBean.getTitle());
            textView.setSelected(otcCancelReasonBean.isChecked());
            textView.setOnClickListener(new a(onReasonClickListener, otcCancelReasonDataType, otcCancelReasonBean));
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int paddingRight = (i13 - i11) - getPaddingRight();
        int i15 = paddingRight - this.f79647d;
        int paddingLeft = getPaddingLeft();
        int i16 = 1;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i18 = paddingLeft + measuredWidth;
            if (i16 > 1) {
                i15 = paddingRight;
            }
            if (i18 > i15) {
                i18 = getPaddingLeft() + measuredWidth;
                i16++;
            }
            int paddingTop = (i16 * measuredHeight) + ((i16 - 1) * this.f79646c) + getPaddingTop();
            childAt.layout(i18 - measuredWidth, paddingTop - measuredHeight, i18, paddingTop);
            paddingLeft = i18 + this.f79645b;
        }
    }

    public void onMeasure(int i11, int i12) {
        int size = View.MeasureSpec.getSize(i11);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i13 = paddingLeft - this.f79647d;
        int childCount = getChildCount();
        int a11 = UIUtil.a(getContext(), 28.0d);
        int i14 = 0;
        int i15 = 1;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            int a12 = i14 + a(i13, a11, childAt);
            if (a12 > i13) {
                a12 = a(paddingLeft, a11, childAt) + getPaddingLeft();
                i15++;
                i13 = paddingLeft;
            }
            i14 = a12 + this.f79645b;
            i16 = (i15 * a11) + ((i15 - 1) * this.f79646c) + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, i16);
    }

    public void setSpacingHorizontal(int i11) {
        this.f79645b = i11;
    }

    public void setSpacingVertical(int i11) {
        this.f79646c = i11;
    }
}
