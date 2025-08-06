package com.hbg.module.content.custom.tag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.content.R$color;
import com.hbg.module.libkt.base.ext.c;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import kotlin.jvm.internal.r;

public final class TagLayout extends ViewGroup {

    /* renamed from: d  reason: collision with root package name */
    public static final a f18152d = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public Context f18153b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<int[]> f18154c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public TagLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TagLayout(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final Context getMContext() {
        return this.f18153b;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            int[] iArr = this.f18154c.get(i15);
            childAt.layout(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        measureChildren(i11, i12);
        this.f18154c.clear();
        int childCount = getChildCount();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (i17 == 0) {
                i13 = marginLayoutParams.topMargin + childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin;
            }
            if (marginLayoutParams.leftMargin + i14 + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin > getMeasuredWidth()) {
                i15 += marginLayoutParams.topMargin + childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin;
                i13 += marginLayoutParams.topMargin + childAt.getMeasuredHeight() + marginLayoutParams.bottomMargin;
                i14 = 0;
            }
            ArrayList<int[]> arrayList = this.f18154c;
            int i18 = marginLayoutParams.leftMargin;
            arrayList.add(new int[]{i14 + i18, marginLayoutParams.topMargin + i15, i18 + i14 + childAt.getMeasuredWidth(), marginLayoutParams.topMargin + i15 + childAt.getMeasuredHeight()});
            i14 += marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
            if (i14 > i16) {
                i16 = i14;
            }
        }
        if (View.MeasureSpec.getMode(i12) == 1073741824) {
            i13 = View.MeasureSpec.getSize(i12);
        }
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            i16 = View.MeasureSpec.getSize(i11);
        }
        setMeasuredDimension(i16, i13);
    }

    public final void setData(String str) {
        removeAllViews();
        if (str != null) {
            for (String text : StringsKt__StringsKt.L0(str, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null)) {
                TextView textView = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, c.d(Float.valueOf(16.0f)));
                layoutParams.rightMargin = c.d(Float.valueOf(4.0f));
                layoutParams.bottomMargin = c.d(Float.valueOf(4.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(text);
                textView.setTextSize(10.0f);
                textView.setPadding(c.d(Float.valueOf(4.0f)), 0, c.d(Float.valueOf(4.0f)), 0);
                textView.setTextColor(getContext().getResources().getColor(R$color.baseColorSecondaryTextNew));
                textView.setGravity(17);
                textView.setBackgroundResource(R$color.baseColorInputBackground);
                addView(textView);
            }
        }
    }

    public final void setMContext(Context context) {
        this.f18153b = context;
    }

    public TagLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f18153b = context;
        this.f18154c = new ArrayList<>();
    }
}
