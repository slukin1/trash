package com.hbg.module.community.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.content.R$dimen;
import com.hbg.module.content.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import rd.s;

public final class CommunityImageLayout extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public List<CommunityFeedInfo.imgListBean> f17643b;

    /* renamed from: c  reason: collision with root package name */
    public int f17644c;

    /* renamed from: d  reason: collision with root package name */
    public float f17645d;

    /* renamed from: e  reason: collision with root package name */
    public int f17646e;

    /* renamed from: f  reason: collision with root package name */
    public int f17647f;

    /* renamed from: g  reason: collision with root package name */
    public float f17648g;

    /* renamed from: h  reason: collision with root package name */
    public float f17649h;

    /* renamed from: i  reason: collision with root package name */
    public float f17650i;

    /* renamed from: j  reason: collision with root package name */
    public List<ImageLabelLayout> f17651j;

    /* renamed from: k  reason: collision with root package name */
    public List<RelativeLayout.LayoutParams> f17652k;

    /* renamed from: l  reason: collision with root package name */
    public p<? super Integer, ? super List<? extends CommunityFeedInfo.imgListBean>, Unit> f17653l;

    /* renamed from: m  reason: collision with root package name */
    public p<? super Integer, ? super List<? extends CommunityFeedInfo.imgListBean>, Unit> f17654m;

    /* renamed from: n  reason: collision with root package name */
    public int f17655n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f17656o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f17657p;

    /* renamed from: q  reason: collision with root package name */
    public int f17658q;

    /* renamed from: r  reason: collision with root package name */
    public int f17659r;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17660b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17661c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityImageLayout f17662d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17663e;

        public a(View view, long j11, CommunityImageLayout communityImageLayout, int i11) {
            this.f17660b = view;
            this.f17661c = j11;
            this.f17662d = communityImageLayout;
            this.f17663e = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17660b) > this.f17661c || (this.f17660b instanceof Checkable)) {
                sVar.e(this.f17660b, currentTimeMillis);
                ImageLabelLayout imageLabelLayout = (ImageLabelLayout) this.f17660b;
                p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> onImageClick = this.f17662d.getOnImageClick();
                if (onImageClick != null) {
                    onImageClick.invoke(Integer.valueOf(this.f17663e), this.f17662d.getImgList());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17664b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17665c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityImageLayout f17666d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17667e;

        public b(View view, long j11, CommunityImageLayout communityImageLayout, int i11) {
            this.f17664b = view;
            this.f17665c = j11;
            this.f17666d = communityImageLayout;
            this.f17667e = i11;
        }

        public final boolean onLongClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17664b) <= this.f17665c && !(this.f17664b instanceof Checkable)) {
                return true;
            }
            sVar.e(this.f17664b, currentTimeMillis);
            ImageLabelLayout imageLabelLayout = (ImageLabelLayout) this.f17664b;
            p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> onImageLongClick = this.f17666d.getOnImageLongClick();
            if (onImageLongClick == null) {
                return true;
            }
            onImageLongClick.invoke(Integer.valueOf(this.f17667e), this.f17666d.getImgList());
            return true;
        }
    }

    public CommunityImageLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommunityImageLayout(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void a(List<? extends CommunityFeedInfo.imgListBean> list) {
        this.f17643b.clear();
        this.f17643b.addAll(list);
        if (isAttachedToWindow()) {
            b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01ee, code lost:
        r1 = r1.getResources();
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x022f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r15 = this;
            java.util.List<com.hbg.module.community.widgets.ImageLabelLayout> r0 = r15.f17651j
            r0.clear()
            r15.removeAllViews()
            r15.removeAllViewsInLayout()
            java.util.List<com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean> r0 = r15.f17643b
            int r0 = r0.size()
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = -1
            r3 = 1077936128(0x40400000, float:3.0)
            r4 = 1
            r5 = 0
            if (r0 != r4) goto L_0x0149
            java.util.List<com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean> r0 = r15.f17643b
            java.lang.Object r0 = r0.get(r5)
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean r0 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.imgListBean) r0
            int r6 = r0.getWidth()
            int r7 = r0.getHeight()
            float r6 = (float) r6
            float r7 = (float) r7
            float r6 = r6 / r7
            int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x0040
            r1 = 1061997773(0x3f4ccccd, float:0.8)
            int r6 = com.hbg.module.libkt.base.ext.c.c()
            float r6 = (float) r6
            float r6 = r6 * r1
            int r1 = (int) r6
            float r6 = (float) r1
            float r6 = r6 / r3
        L_0x003d:
            int r3 = (int) r6
            goto L_0x00b5
        L_0x0040:
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0054
            r1 = 1061102988(0x3f3f258c, float:0.74666667)
            int r3 = com.hbg.module.libkt.base.ext.c.c()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = (int) r3
            r6 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r8 = (double) r1
            double r8 = r8 * r6
            int r3 = (int) r8
            goto L_0x00b5
        L_0x0054:
            double r7 = (double) r6
            r9 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 < 0) goto L_0x006b
            r1 = 1060208203(0x3f317e4b, float:0.6933333)
            int r3 = com.hbg.module.libkt.base.ext.c.c()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = (int) r3
            r3 = 1060190996(0x3f313b14, float:0.6923077)
        L_0x0068:
            float r6 = (float) r1
            float r6 = r6 * r3
            goto L_0x003d
        L_0x006b:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x007d
            r1 = 1059313418(0x3f23d70a, float:0.64)
            int r3 = com.hbg.module.libkt.base.ext.c.c()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = (int) r3
            r3 = r1
            goto L_0x00b5
        L_0x007d:
            r9 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 < 0) goto L_0x0093
            r1 = 1057523849(0x3f088889, float:0.53333336)
            int r3 = com.hbg.module.libkt.base.ext.c.c()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = (int) r3
            r3 = 1067450368(0x3fa00000, float:1.25)
            goto L_0x0068
        L_0x0093:
            r9 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 < 0) goto L_0x00a7
            r1 = 1049135241(0x3e888889, float:0.26666668)
            int r3 = com.hbg.module.libkt.base.ext.c.c()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = (int) r3
            r3 = 1075419546(0x4019999a, float:2.4)
            goto L_0x0068
        L_0x00a7:
            r1 = 1044325772(0x3e3f258c, float:0.18666667)
            int r3 = com.hbg.module.libkt.base.ext.c.c()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = (int) r3
            r3 = 1079733687(0x405b6db7, float:3.4285715)
            goto L_0x0068
        L_0x00b5:
            r15.f17658q = r3
            r15.f17659r = r1
            boolean r6 = r15.f17656o
            if (r6 == 0) goto L_0x011e
            int r1 = com.hbg.module.libkt.base.ext.c.c()
            r3 = 1107296256(0x42000000, float:32.0)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            int r3 = com.hbg.module.libkt.base.ext.c.d(r3)
            int r1 = r1 - r3
            boolean r3 = r15.f17657p
            if (r3 == 0) goto L_0x00dd
            float r3 = (float) r1
            r6 = 1091567616(0x41100000, float:9.0)
            float r3 = r3 * r6
            r6 = 16
            float r6 = (float) r6
            float r3 = r3 / r6
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x00ef
        L_0x00dd:
            int r3 = r0.getHeight()
            float r3 = (float) r3
            int r6 = r0.getWidth()
            float r6 = (float) r6
            float r3 = r3 / r6
            float r6 = (float) r1
            float r3 = r3 * r6
            int r3 = (int) r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x00ef:
            int r3 = r3.intValue()
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r6.<init>(r1, r3)
            java.util.List<android.widget.RelativeLayout$LayoutParams> r7 = r15.f17652k
            r7.add(r6)
            java.util.List<com.hbg.module.community.widgets.ImageLabelLayout> r6 = r15.f17651j
            com.hbg.module.community.widgets.ImageLabelLayout r13 = new com.hbg.module.community.widgets.ImageLabelLayout
            android.content.Context r8 = r15.getContext()
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            r13.setImageWidth(r1)
            r13.setImageHeight(r3)
            r13.setImgData(r0)
            r13.setImageType(r5)
            r6.add(r13)
            goto L_0x0221
        L_0x011e:
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r6.<init>(r1, r3)
            java.util.List<android.widget.RelativeLayout$LayoutParams> r7 = r15.f17652k
            r7.add(r6)
            java.util.List<com.hbg.module.community.widgets.ImageLabelLayout> r6 = r15.f17651j
            com.hbg.module.community.widgets.ImageLabelLayout r13 = new com.hbg.module.community.widgets.ImageLabelLayout
            android.content.Context r8 = r15.getContext()
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r7 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            r13.setImageWidth(r1)
            r13.setImageHeight(r3)
            r13.setImgData(r0)
            r13.setImageType(r5)
            r6.add(r13)
            goto L_0x0221
        L_0x0149:
            java.util.List<com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean> r0 = r15.f17643b
            int r0 = r0.size()
            if (r0 <= r4) goto L_0x0221
            int r0 = com.hbg.module.libkt.base.ext.c.c()
            float r0 = (float) r0
            float r6 = r15.f17649h
            float r7 = r15.f17648g
            float r6 = r6 + r7
            float r6 = r6 * r1
            float r0 = r0 - r6
            float r0 = r0 / r3
            int r0 = (int) r0
            java.util.List<com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean> r1 = r15.f17643b
            java.util.Iterator r1 = r1.iterator()
            r3 = r5
        L_0x0166:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0222
            java.lang.Object r6 = r1.next()
            int r7 = r3 + 1
            if (r3 >= 0) goto L_0x0177
            kotlin.collections.CollectionsKt__CollectionsKt.t()
        L_0x0177:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean r6 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.imgListBean) r6
            com.hbg.module.community.widgets.ImageLabelLayout r14 = new com.hbg.module.community.widgets.ImageLabelLayout
            android.content.Context r9 = r15.getContext()
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            r8 = r14
            r8.<init>(r9, r10, r11, r12, r13)
            r8 = 1062557013(0x3f555555, float:0.8333333)
            float r9 = (float) r0
            float r9 = r9 * r8
            int r8 = (int) r9
            r14.setImageWidth(r0)
            r14.setImageHeight(r8)
            r14.setImgData(r6)
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r6.<init>(r0, r8)
            int r8 = r3 / 3
            float r9 = r15.f17650i
            int r9 = (int) r9
            int r9 = r9 + r0
            int r8 = r8 * r9
            int r9 = r6.leftMargin
            int r10 = r6.rightMargin
            int r11 = r6.bottomMargin
            r6.setMargins(r9, r8, r10, r11)
            java.util.List<android.widget.RelativeLayout$LayoutParams> r8 = r15.f17652k
            r8.add(r6)
            int r6 = r15.f17655n
            r8 = 2
            if (r6 == r2) goto L_0x0216
            if (r3 != r8) goto L_0x0216
            java.util.List<com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean> r3 = r15.f17643b
            int r3 = r3.size()
            r6 = 3
            if (r3 <= r6) goto L_0x0216
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r14.setLabelBackground(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r3 = 43
            r1.append(r3)
            java.util.List<com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$imgListBean> r3 = r15.f17643b
            int r3 = r3.size()
            int r3 = r3 - r6
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r14.setLabelText(r1)
            r14.setImageType(r6)
            r14.setLabelTextColor(r2)
            android.content.Context r1 = r15.getContext()
            if (r1 == 0) goto L_0x01ff
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x01ff
            int r3 = com.hbg.module.content.R$dimen.dimen_20
            float r1 = r1.getDimension(r3)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x0200
        L_0x01ff:
            r1 = 0
        L_0x0200:
            float r1 = r1.floatValue()
            int r1 = com.hbg.module.libkt.base.ext.c.i(r1)
            float r1 = (float) r1
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r14.setLabelTextSize(r1)
            java.util.List<com.hbg.module.community.widgets.ImageLabelLayout> r1 = r15.f17651j
            r1.add(r14)
            goto L_0x0222
        L_0x0216:
            r14.setImageType(r8)
            java.util.List<com.hbg.module.community.widgets.ImageLabelLayout> r3 = r15.f17651j
            r3.add(r14)
            r3 = r7
            goto L_0x0166
        L_0x0221:
            r0 = r5
        L_0x0222:
            java.util.List<com.hbg.module.community.widgets.ImageLabelLayout> r1 = r15.f17651j
            java.util.Iterator r1 = r1.iterator()
            r3 = r5
        L_0x0229:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0281
            java.lang.Object r6 = r1.next()
            int r12 = r3 + 1
            if (r3 >= 0) goto L_0x023a
            kotlin.collections.CollectionsKt__CollectionsKt.t()
        L_0x023a:
            r13 = r6
            com.hbg.module.community.widgets.ImageLabelLayout r13 = (com.hbg.module.community.widgets.ImageLabelLayout) r13
            int r6 = r15.indexOfChild(r13)
            if (r6 == r2) goto L_0x0245
            r6 = r4
            goto L_0x0246
        L_0x0245:
            r6 = r5
        L_0x0246:
            if (r6 != 0) goto L_0x027f
            if (r3 <= 0) goto L_0x025b
            java.util.List<android.widget.RelativeLayout$LayoutParams> r6 = r15.f17652k
            java.lang.Object r6 = r6.get(r3)
            android.widget.RelativeLayout$LayoutParams r6 = (android.widget.RelativeLayout.LayoutParams) r6
            float r7 = r15.f17649h
            int r7 = (int) r7
            int r7 = r7 + r0
            int r8 = r3 % 3
            int r7 = r7 * r8
            r6.leftMargin = r7
        L_0x025b:
            java.util.List<android.widget.RelativeLayout$LayoutParams> r6 = r15.f17652k
            java.lang.Object r6 = r6.get(r3)
            android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
            r15.addView(r13, r6)
            rd.s r6 = rd.s.f23381a
            r8 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.widgets.CommunityImageLayout$a r14 = new com.hbg.module.community.widgets.CommunityImageLayout$a
            r6 = r14
            r7 = r13
            r10 = r15
            r11 = r3
            r6.<init>(r7, r8, r10, r11)
            r13.setOnClickListener(r14)
            com.hbg.module.community.widgets.CommunityImageLayout$b r14 = new com.hbg.module.community.widgets.CommunityImageLayout$b
            r6 = r14
            r6.<init>(r7, r8, r10, r11)
            r13.setOnLongClickListener(r14)
        L_0x027f:
            r3 = r12
            goto L_0x0229
        L_0x0281:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.widgets.CommunityImageLayout.b():void");
    }

    public final List<CommunityFeedInfo.imgListBean> getImgList() {
        return this.f17643b;
    }

    public final float getImgMargin() {
        return this.f17649h;
    }

    public final float getImgMarginTop() {
        return this.f17650i;
    }

    public final float getImgPadding() {
        return this.f17648g;
    }

    public final int getLargeImgMaxHeight() {
        return this.f17644c;
    }

    public final int getMaxCount() {
        return this.f17655n;
    }

    public final p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> getOnImageClick() {
        return this.f17653l;
    }

    public final p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> getOnImageLongClick() {
        return this.f17654m;
    }

    public final int getPicHeight() {
        return this.f17658q;
    }

    public final int getPicWidth() {
        return this.f17659r;
    }

    public final int getSingleImgWidth() {
        return this.f17647f;
    }

    public final int getSingleMaxImgHeight() {
        return this.f17646e;
    }

    public final float getSingleMinImgHeight() {
        return this.f17645d;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f17643b.size() > 0) {
            b();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17651j.clear();
        this.f17652k.clear();
        removeAllViewsInLayout();
        removeAllViews();
    }

    public final void setDetailPage(boolean z11) {
        this.f17656o = z11;
    }

    public final void setImgList(List<CommunityFeedInfo.imgListBean> list) {
        this.f17643b = list;
    }

    public final void setImgMargin(float f11) {
        this.f17649h = f11;
    }

    public final void setImgMarginTop(float f11) {
        this.f17650i = f11;
    }

    public final void setImgPadding(float f11) {
        this.f17648g = f11;
    }

    public final void setLargeImgMaxHeight(int i11) {
        this.f17644c = i11;
    }

    public final void setLive(boolean z11) {
        this.f17657p = z11;
    }

    public final void setMaxCount(int i11) {
        this.f17655n = i11;
    }

    public final void setOnImageClick(p<? super Integer, ? super List<? extends CommunityFeedInfo.imgListBean>, Unit> pVar) {
        this.f17653l = pVar;
    }

    public final void setOnImageLongClick(p<? super Integer, ? super List<? extends CommunityFeedInfo.imgListBean>, Unit> pVar) {
        this.f17654m = pVar;
    }

    public final void setPicHeight(int i11) {
        this.f17658q = i11;
    }

    public final void setPicWidth(int i11) {
        this.f17659r = i11;
    }

    public final void setSingleImgWidth(int i11) {
        this.f17647f = i11;
    }

    public final void setSingleMaxImgHeight(int i11) {
        this.f17646e = i11;
    }

    public final void setSingleMinImgHeight(float f11) {
        this.f17645d = f11;
    }

    public CommunityImageLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f17643b = new ArrayList();
        this.f17644c = 2000;
        this.f17645d = context.getResources().getDimension(R$dimen.dimen_80);
        this.f17646e = (int) context.getResources().getDimension(R$dimen.dimen_314);
        this.f17647f = (int) context.getResources().getDimension(R$dimen.dimen_240);
        this.f17648g = context.getResources().getDimension(R$dimen.dimen_16);
        this.f17649h = context.getResources().getDimension(R$dimen.dimen_8);
        this.f17650i = context.getResources().getDimension(R$dimen.dimen_10);
        this.f17651j = new ArrayList();
        this.f17652k = new ArrayList();
        this.f17655n = 3;
        this.f17643b.clear();
        this.f17651j.clear();
        this.f17652k.clear();
        if (attributeSet != null) {
            this.f17655n = context.obtainStyledAttributes(attributeSet, R$styleable.CommunityImageLayout).getInteger(R$styleable.CommunityImageLayout_cil_MaxCount, 3);
        }
    }
}
