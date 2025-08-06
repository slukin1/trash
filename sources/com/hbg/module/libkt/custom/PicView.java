package com.hbg.module.libkt.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hbg.lib.core.util.SaveImageUtils;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.libkt.utils.m;
import com.huobi.view.roundimg.RoundedImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import ke.c;
import ke.d;

public final class PicView extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public final float f24720b = ((float) m.a(8));

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<CommunityFeedInfo.imgListBean> f24721c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final int f24722d = m.a(5);

    /* renamed from: e  reason: collision with root package name */
    public a f24723e;

    /* renamed from: f  reason: collision with root package name */
    public int f24724f;

    public interface a {

        /* renamed from: com.hbg.module.libkt.custom.PicView$a$a  reason: collision with other inner class name */
        public static final class C0216a {
            public static void a(a aVar, int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
            }
        }

        void a(int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList);

        void b(int i11, ArrayList<CommunityFeedInfo.imgListBean> arrayList);
    }

    public PicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @SensorsDataInstrumented
    public static final void c(PicView picView, int i11, View view) {
        a aVar = picView.f24723e;
        if (aVar != null) {
            aVar.b(i11, picView.f24721c);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final boolean d(int i11, PicView picView, View view) {
        if (i11 < picView.f24721c.size()) {
            SaveImageUtils.h(picView.getContext(), picView.f24721c.get(i11).getImage());
        }
        a aVar = picView.f24723e;
        if (aVar == null) {
            return true;
        }
        aVar.a(i11, picView.f24721c);
        return true;
    }

    private final float getRadiusWithType() {
        if (this.f24724f == 0) {
            return this.f24720b;
        }
        return 0.0f;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v13, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v25, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r8 = this;
            int r0 = r8.getChildCount()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L_0x00d3
            r4 = 2
            r5 = 0
            if (r0 == r4) goto L_0x00a5
            r6 = 3
            if (r0 == r6) goto L_0x0066
            r7 = 4
            if (r0 == r7) goto L_0x0015
            goto L_0x00ed
        L_0x0015:
            android.view.View r0 = r8.getChildAt(r1)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x0020
            com.huobi.view.roundimg.RoundedImageView r0 = (com.huobi.view.roundimg.RoundedImageView) r0
            goto L_0x0021
        L_0x0020:
            r0 = r3
        L_0x0021:
            if (r0 == 0) goto L_0x002a
            float r1 = r8.getRadiusWithType()
            r0.setCornerRadius(r1, r5, r5, r5)
        L_0x002a:
            android.view.View r0 = r8.getChildAt(r2)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x0035
            com.huobi.view.roundimg.RoundedImageView r0 = (com.huobi.view.roundimg.RoundedImageView) r0
            goto L_0x0036
        L_0x0035:
            r0 = r3
        L_0x0036:
            if (r0 == 0) goto L_0x003f
            float r1 = r8.getRadiusWithType()
            r0.setCornerRadius(r5, r1, r5, r5)
        L_0x003f:
            android.view.View r0 = r8.getChildAt(r4)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x004a
            com.huobi.view.roundimg.RoundedImageView r0 = (com.huobi.view.roundimg.RoundedImageView) r0
            goto L_0x004b
        L_0x004a:
            r0 = r3
        L_0x004b:
            if (r0 == 0) goto L_0x0052
            float r1 = r8.f24720b
            r0.setCornerRadius(r5, r5, r1, r5)
        L_0x0052:
            android.view.View r0 = r8.getChildAt(r6)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x005d
            r3 = r0
            com.huobi.view.roundimg.RoundedImageView r3 = (com.huobi.view.roundimg.RoundedImageView) r3
        L_0x005d:
            if (r3 == 0) goto L_0x00ed
            float r0 = r8.f24720b
            r3.setCornerRadius(r5, r5, r5, r0)
            goto L_0x00ed
        L_0x0066:
            android.view.View r0 = r8.getChildAt(r1)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x0071
            com.huobi.view.roundimg.RoundedImageView r0 = (com.huobi.view.roundimg.RoundedImageView) r0
            goto L_0x0072
        L_0x0071:
            r0 = r3
        L_0x0072:
            if (r0 == 0) goto L_0x007d
            float r1 = r8.getRadiusWithType()
            float r6 = r8.f24720b
            r0.setCornerRadius(r1, r5, r6, r5)
        L_0x007d:
            android.view.View r0 = r8.getChildAt(r2)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x0088
            com.huobi.view.roundimg.RoundedImageView r0 = (com.huobi.view.roundimg.RoundedImageView) r0
            goto L_0x0089
        L_0x0088:
            r0 = r3
        L_0x0089:
            if (r0 == 0) goto L_0x0092
            float r1 = r8.getRadiusWithType()
            r0.setCornerRadius(r5, r1, r5, r5)
        L_0x0092:
            android.view.View r0 = r8.getChildAt(r4)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x009d
            r3 = r0
            com.huobi.view.roundimg.RoundedImageView r3 = (com.huobi.view.roundimg.RoundedImageView) r3
        L_0x009d:
            if (r3 == 0) goto L_0x00ed
            float r0 = r8.f24720b
            r3.setCornerRadius(r5, r5, r5, r0)
            goto L_0x00ed
        L_0x00a5:
            android.view.View r0 = r8.getChildAt(r1)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x00b0
            com.huobi.view.roundimg.RoundedImageView r0 = (com.huobi.view.roundimg.RoundedImageView) r0
            goto L_0x00b1
        L_0x00b0:
            r0 = r3
        L_0x00b1:
            if (r0 == 0) goto L_0x00bc
            float r1 = r8.getRadiusWithType()
            float r4 = r8.f24720b
            r0.setCornerRadius(r1, r5, r4, r5)
        L_0x00bc:
            android.view.View r0 = r8.getChildAt(r2)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x00c7
            r3 = r0
            com.huobi.view.roundimg.RoundedImageView r3 = (com.huobi.view.roundimg.RoundedImageView) r3
        L_0x00c7:
            if (r3 == 0) goto L_0x00ed
            float r0 = r8.getRadiusWithType()
            float r1 = r8.f24720b
            r3.setCornerRadius(r5, r0, r5, r1)
            goto L_0x00ed
        L_0x00d3:
            android.view.View r0 = r8.getChildAt(r1)
            boolean r1 = r0 instanceof com.huobi.view.roundimg.RoundedImageView
            if (r1 == 0) goto L_0x00de
            r3 = r0
            com.huobi.view.roundimg.RoundedImageView r3 = (com.huobi.view.roundimg.RoundedImageView) r3
        L_0x00de:
            if (r3 == 0) goto L_0x00ed
            float r0 = r8.getRadiusWithType()
            float r1 = r8.getRadiusWithType()
            float r2 = r8.f24720b
            r3.setCornerRadius(r0, r1, r2, r2)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.custom.PicView.e():void");
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        if (childCount == 1) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            View childAt = getChildAt(0);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = measuredWidth;
            layoutParams.height = measuredHeight;
            childAt.setLayoutParams(layoutParams);
            childAt.layout(0, 0, measuredWidth, measuredHeight);
        } else if (childCount == 2) {
            int measuredWidth2 = (getMeasuredWidth() - this.f24722d) / 2;
            int measuredHeight2 = getMeasuredHeight();
            int i15 = measuredWidth2;
            int i16 = 0;
            for (int i17 = 0; i17 < 2; i17++) {
                View childAt2 = getChildAt(i17);
                ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                layoutParams2.width = measuredWidth2;
                layoutParams2.height = measuredHeight2;
                childAt2.setLayoutParams(layoutParams2);
                childAt2.layout(i16, 0, i15, measuredHeight2);
                i16 = this.f24722d + i15;
                i15 = getMeasuredWidth();
            }
        } else if (childCount != 3) {
            int measuredWidth3 = (getMeasuredWidth() - this.f24722d) / 2;
            int measuredHeight3 = (getMeasuredHeight() - this.f24722d) / 2;
            for (int i18 = 0; i18 < 4; i18++) {
                View childAt3 = getChildAt(i18);
                ViewGroup.LayoutParams layoutParams3 = childAt3.getLayoutParams();
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = measuredHeight3;
                childAt3.setLayoutParams(layoutParams3);
                if (i18 == 0) {
                    childAt3.layout(0, 0, measuredWidth3, measuredHeight3);
                } else if (i18 == 1) {
                    childAt3.layout(this.f24722d + measuredWidth3, 0, getMeasuredWidth(), measuredHeight3);
                } else if (i18 == 2) {
                    childAt3.layout(0, this.f24722d + measuredHeight3, measuredWidth3, getMeasuredHeight());
                } else if (i18 == 3) {
                    int i19 = this.f24722d;
                    childAt3.layout(measuredWidth3 + i19, i19 + measuredHeight3, getMeasuredWidth(), getMeasuredHeight());
                }
            }
        } else {
            int measuredWidth4 = (getMeasuredWidth() - this.f24722d) / 2;
            int measuredHeight4 = getMeasuredHeight();
            int measuredHeight5 = (getMeasuredHeight() - this.f24722d) / 2;
            for (int i21 = 0; i21 < 3; i21++) {
                View childAt4 = getChildAt(i21);
                ViewGroup.LayoutParams layoutParams4 = childAt4.getLayoutParams();
                layoutParams4.width = measuredWidth4;
                if (i21 == 0) {
                    layoutParams4.height = measuredHeight4;
                    childAt4.setLayoutParams(layoutParams4);
                    childAt4.layout(0, 0, measuredWidth4, measuredHeight4);
                } else if (i21 == 1) {
                    layoutParams4.height = measuredHeight5;
                    childAt4.setLayoutParams(layoutParams4);
                    childAt4.layout(this.f24722d + measuredWidth4, 0, getMeasuredWidth(), measuredHeight5);
                } else if (i21 == 2) {
                    layoutParams4.height = measuredHeight5;
                    childAt4.setLayoutParams(layoutParams4);
                    int i22 = this.f24722d;
                    childAt4.layout(measuredWidth4 + i22, i22 + measuredHeight5, getMeasuredWidth(), getMeasuredHeight());
                }
            }
        }
    }

    public final void setImageClickListener(a aVar) {
        this.f24723e = aVar;
    }

    public final void setImageResList(ArrayList<CommunityFeedInfo.imgListBean> arrayList) {
        this.f24721c.clear();
        this.f24721c.addAll(arrayList);
        int i11 = 4;
        int size = this.f24721c.size() >= 4 ? 4 : this.f24721c.size();
        int childCount = getChildCount();
        int i12 = childCount - size;
        if (i12 > 0) {
            if (size <= 0) {
                size = 0;
            }
            removeViews(size, i12);
        } else if (i12 < 0 && childCount < 4) {
            int abs = Math.abs(i12);
            if (abs < 4) {
                i11 = abs;
            }
            for (int i13 = 0; i13 < i11; i13++) {
                RoundedImageView roundedImageView = new RoundedImageView(getContext());
                roundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(roundedImageView, new ViewGroup.LayoutParams(-1, -2));
            }
        }
        e();
        int childCount2 = getChildCount();
        for (int i14 = 0; i14 < childCount2; i14++) {
            View childAt = getChildAt(i14);
            RoundedImageView roundedImageView2 = childAt instanceof RoundedImageView ? (RoundedImageView) childAt : null;
            if (roundedImageView2 != null) {
                com.bumptech.glide.a.v(getContext()).q(this.f24721c.get(i14).getImage()).D0(roundedImageView2);
            }
            childAt.setOnClickListener(new c(this, i14));
            childAt.setOnLongClickListener(new d(i14, this));
        }
        invalidate();
    }

    public final void setShowType(int i11) {
        this.f24724f = i11;
    }

    public PicView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
