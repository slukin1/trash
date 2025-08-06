package com.hbg.module.libkt.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.hbg.core.bean.CommonPkChoiceData;
import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.R$drawable;
import com.hbg.module.libkt.R$id;
import com.hbg.module.libkt.R$layout;
import com.hbg.module.libkt.R$string;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.hbg.module.libkt.utils.CommonWidgetHelper;
import com.hbg.module.libkt.utils.r;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.l;

public final class LiveRecommendPkCommonView extends FrameLayout {
    public Drawable A;
    public Drawable B;
    public int C;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24558b;

    /* renamed from: c  reason: collision with root package name */
    public LiveRecommendPkProgressView f24559c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f24560d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f24561e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f24562f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24563g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f24564h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f24565i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f24566j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f24567k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f24568l;

    /* renamed from: m  reason: collision with root package name */
    public HexagonImageView f24569m;

    /* renamed from: n  reason: collision with root package name */
    public HexagonImageView f24570n;

    /* renamed from: o  reason: collision with root package name */
    public HexagonImageView f24571o;

    /* renamed from: p  reason: collision with root package name */
    public RelativeLayout f24572p;

    /* renamed from: q  reason: collision with root package name */
    public RelativeLayout f24573q;

    /* renamed from: r  reason: collision with root package name */
    public RelativeLayout f24574r;

    /* renamed from: s  reason: collision with root package name */
    public ImageView f24575s;

    /* renamed from: t  reason: collision with root package name */
    public ImageView f24576t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f24577u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f24578v;

    /* renamed from: w  reason: collision with root package name */
    public CommonPkData f24579w;

    /* renamed from: x  reason: collision with root package name */
    public a f24580x;

    /* renamed from: y  reason: collision with root package name */
    public Drawable f24581y;

    /* renamed from: z  reason: collision with root package name */
    public Drawable f24582z;

    public interface a {
        void a(View view);

        void b(View view);
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f24583b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f24584c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendPkCommonView f24585d;

        public b(View view, long j11, LiveRecommendPkCommonView liveRecommendPkCommonView) {
            this.f24583b = view;
            this.f24584c = j11;
            this.f24585d = liveRecommendPkCommonView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f24583b) > this.f24584c || (this.f24583b instanceof Checkable)) {
                rVar.e(this.f24583b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f24583b;
                this.f24585d.d(true);
                a onPkCommonViewListener = this.f24585d.getOnPkCommonViewListener();
                if (onPkCommonViewListener != null) {
                    onPkCommonViewListener.b(linearLayout);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f24586b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f24587c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendPkCommonView f24588d;

        public c(View view, long j11, LiveRecommendPkCommonView liveRecommendPkCommonView) {
            this.f24586b = view;
            this.f24587c = j11;
            this.f24588d = liveRecommendPkCommonView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f24586b) > this.f24587c || (this.f24586b instanceof Checkable)) {
                rVar.e(this.f24586b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f24586b;
                this.f24588d.d(false);
                a onPkCommonViewListener = this.f24588d.getOnPkCommonViewListener();
                if (onPkCommonViewListener != null) {
                    onPkCommonViewListener.a(linearLayout);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements ue.b<CommonPkData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendPkCommonView f24589a;

        public d(LiveRecommendPkCommonView liveRecommendPkCommonView) {
            this.f24589a = liveRecommendPkCommonView;
        }

        public void a(String str, String str2) {
            this.f24589a.l(str2);
        }

        /* renamed from: b */
        public void onSuccess(CommonPkData commonPkData) {
            if (commonPkData != null) {
                LiveRecommendPkCommonView liveRecommendPkCommonView = this.f24589a;
                commonPkData.content = liveRecommendPkCommonView.getResources().getString(R$string.n_live_recommend_today_voting_decision);
                liveRecommendPkCommonView.e(commonPkData);
                liveRecommendPkCommonView.setView(commonPkData);
                liveRecommendPkCommonView.m();
            }
        }
    }

    public LiveRecommendPkCommonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (kotlin.jvm.internal.r) null);
    }

    public LiveRecommendPkCommonView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (kotlin.jvm.internal.r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveRecommendPkCommonView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, kotlin.jvm.internal.r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    @SensorsDataInstrumented
    public static final void i(LiveRecommendPkCommonView liveRecommendPkCommonView, View view) {
        HuobiToastUtil.m(liveRecommendPkCommonView.getContext().getResources().getString(R$string.n_content_voted));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c() {
        r rVar = r.f24939a;
        LinearLayout linearLayout = this.f24564h;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new b(linearLayout, 800, this));
        LinearLayout linearLayout3 = this.f24565i;
        if (linearLayout3 != null) {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setOnClickListener(new c(linearLayout2, 800, this));
    }

    public final void d(boolean z11) {
        List<CommonPkChoiceData> list;
        CommonPkData commonPkData = this.f24579w;
        if (commonPkData != null && (list = commonPkData.choiceList) != null && list.size() >= 2) {
            CommonPkChoiceData commonPkChoiceData = list.get(0);
            int i11 = -1;
            long j11 = 0;
            String str = "";
            if (commonPkChoiceData != null) {
                if (z11) {
                    j11 = commonPkChoiceData.choiceId;
                    str = commonPkChoiceData.choice;
                }
                i11 = commonPkChoiceData.isJoin;
            }
            if (i11 == 1) {
                k();
                return;
            }
            CommonPkChoiceData commonPkChoiceData2 = list.get(1);
            if (commonPkChoiceData2 != null) {
                if (!z11) {
                    j11 = commonPkChoiceData2.choiceId;
                    str = commonPkChoiceData2.choice;
                }
                i11 = commonPkChoiceData2.isJoin;
            }
            if (i11 == 1) {
                k();
            } else if (i11 == 0) {
                g((int) this.f24579w.voteId, String.valueOf(j11), this.f24579w.topicId, this.f24579w.topicType, MapsKt__MapsKt.j(l.a("pkId", Long.valueOf(commonPkData.voteId)), l.a("pktitle", commonPkData.content), l.a("buttonName", str)));
            }
        }
    }

    public final void e(CommonPkData commonPkData) {
        CommonPkData commonPkData2 = this.f24579w;
        if (commonPkData2 != null) {
            commonPkData2.duration = commonPkData.duration;
            commonPkData2.content = commonPkData.content;
            commonPkData2.topicId = commonPkData.topicId;
            commonPkData2.topicType = commonPkData.topicType;
            commonPkData2.voteId = commonPkData.voteId;
            commonPkData2.voteNums = commonPkData.voteNums;
            commonPkData2.voteType = commonPkData.voteType;
            commonPkData2.expireTime = commonPkData.expireTime;
            commonPkData2.choiceList = commonPkData.choiceList;
            commonPkData2.userInfo = commonPkData.userInfo;
        }
    }

    public final void f(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_live_recommend_pk_common_widget, (ViewGroup) null);
        addView(inflate);
        this.f24558b = (TextView) inflate.findViewById(R$id.tv_title);
        this.f24559c = (LiveRecommendPkProgressView) inflate.findViewById(R$id.ppv_progress);
        this.f24560d = (LinearLayout) inflate.findViewById(R$id.llSelectBefore);
        this.f24561e = (LinearLayout) inflate.findViewById(R$id.ll_pk_progress);
        this.f24562f = (RelativeLayout) inflate.findViewById(R$id.rlTips);
        this.f24563g = (TextView) inflate.findViewById(R$id.tvPk100);
        this.f24564h = (LinearLayout) inflate.findViewById(R$id.ll_agree_btn);
        this.f24565i = (LinearLayout) inflate.findViewById(R$id.ll_disagree_btn);
        this.f24566j = (TextView) inflate.findViewById(R$id.tv_agree_progress);
        this.f24567k = (TextView) inflate.findViewById(R$id.tv_disagree_progress);
        this.f24569m = (HexagonImageView) inflate.findViewById(R$id.iv_icon1);
        this.f24570n = (HexagonImageView) inflate.findViewById(R$id.iv_icon2);
        this.f24571o = (HexagonImageView) inflate.findViewById(R$id.iv_icon3);
        this.f24572p = (RelativeLayout) inflate.findViewById(R$id.fl_icon1);
        this.f24573q = (RelativeLayout) inflate.findViewById(R$id.fl_icon2);
        this.f24574r = (RelativeLayout) inflate.findViewById(R$id.fl_icon3);
        this.f24568l = (TextView) inflate.findViewById(R$id.tv_people_count);
        this.f24575s = (ImageView) inflate.findViewById(R$id.ivAgree);
        this.f24576t = (ImageView) inflate.findViewById(R$id.ivDisagree);
        this.f24577u = (TextView) inflate.findViewById(R$id.tvRiseTips);
        this.f24578v = (TextView) inflate.findViewById(R$id.tvFallTips);
        setVisibility(8);
    }

    public final void g(int i11, String str, String str2, int i12, HashMap<Object, Object> hashMap) {
        if (i11 != 0 && !TextUtils.isEmpty(str)) {
            CommonWidgetHelper commonWidgetHelper = CommonWidgetHelper.f24861a;
            if (commonWidgetHelper.a((Activity) getContext())) {
                SensorsDataHelper.track("app_community_pkclick", hashMap);
                commonWidgetHelper.b(i11, str, str2, i12, new d(this));
            }
        }
    }

    public final a getOnPkCommonViewListener() {
        return this.f24580x;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: android.widget.RelativeLayout} */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r14 = this;
            com.hbg.lib.network.hbg.core.bean.CommonPkData r0 = r14.f24579w
            if (r0 == 0) goto L_0x013c
            java.util.List<com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData> r0 = r0.userInfo
            if (r0 == 0) goto L_0x013c
            int r1 = r0.size()
            r2 = 8
            r3 = 0
            if (r1 != 0) goto L_0x002c
            android.widget.RelativeLayout r0 = r14.f24572p
            if (r0 != 0) goto L_0x0016
            r0 = r3
        L_0x0016:
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r14.f24573q
            if (r0 != 0) goto L_0x001e
            r0 = r3
        L_0x001e:
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r14.f24574r
            if (r0 != 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r3 = r0
        L_0x0027:
            r3.setVisibility(r2)
            goto L_0x013c
        L_0x002c:
            int r1 = r0.size()
            r4 = 1
            r5 = 0
            if (r1 != r4) goto L_0x006a
            android.widget.RelativeLayout r1 = r14.f24572p
            if (r1 != 0) goto L_0x0039
            r1 = r3
        L_0x0039:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24573q
            if (r1 != 0) goto L_0x0041
            r1 = r3
        L_0x0041:
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r14.f24574r
            if (r1 != 0) goto L_0x0049
            r1 = r3
        L_0x0049:
            r1.setVisibility(r2)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24569m
            if (r1 != 0) goto L_0x0052
            r6 = r3
            goto L_0x0053
        L_0x0052:
            r6 = r1
        L_0x0053:
            r7 = 0
            r8 = 16
            java.lang.Object r0 = r0.get(r5)
            com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData r0 = (com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData) r0
            if (r0 == 0) goto L_0x0060
            java.lang.String r3 = r0.avatar
        L_0x0060:
            r9 = r3
            r10 = 0
            r11 = 8
            r12 = 0
            com.hbg.module.libkt.common.HexagonImageView.g(r6, r7, r8, r9, r10, r11, r12)
            goto L_0x013c
        L_0x006a:
            int r1 = r0.size()
            r6 = 2
            if (r1 != r6) goto L_0x00c5
            android.widget.RelativeLayout r1 = r14.f24572p
            if (r1 != 0) goto L_0x0076
            r1 = r3
        L_0x0076:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24573q
            if (r1 != 0) goto L_0x007e
            r1 = r3
        L_0x007e:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24574r
            if (r1 != 0) goto L_0x0086
            r1 = r3
        L_0x0086:
            r1.setVisibility(r2)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24569m
            if (r1 != 0) goto L_0x008f
            r6 = r3
            goto L_0x0090
        L_0x008f:
            r6 = r1
        L_0x0090:
            r7 = 0
            r8 = 16
            java.lang.Object r1 = r0.get(r5)
            com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData r1 = (com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData) r1
            if (r1 == 0) goto L_0x009f
            java.lang.String r1 = r1.avatar
            r9 = r1
            goto L_0x00a0
        L_0x009f:
            r9 = r3
        L_0x00a0:
            r10 = 0
            r11 = 8
            r12 = 0
            com.hbg.module.libkt.common.HexagonImageView.g(r6, r7, r8, r9, r10, r11, r12)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24570n
            if (r1 != 0) goto L_0x00ad
            r5 = r3
            goto L_0x00ae
        L_0x00ad:
            r5 = r1
        L_0x00ae:
            r6 = 0
            r7 = 16
            java.lang.Object r0 = r0.get(r4)
            com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData r0 = (com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData) r0
            if (r0 == 0) goto L_0x00bb
            java.lang.String r3 = r0.avatar
        L_0x00bb:
            r8 = r3
            r9 = 0
            r10 = 8
            r11 = 0
            com.hbg.module.libkt.common.HexagonImageView.g(r5, r6, r7, r8, r9, r10, r11)
            goto L_0x013c
        L_0x00c5:
            int r1 = r0.size()
            r2 = 3
            if (r1 < r2) goto L_0x013c
            android.widget.RelativeLayout r1 = r14.f24572p
            if (r1 != 0) goto L_0x00d1
            r1 = r3
        L_0x00d1:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24573q
            if (r1 != 0) goto L_0x00d9
            r1 = r3
        L_0x00d9:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24574r
            if (r1 != 0) goto L_0x00e1
            r1 = r3
        L_0x00e1:
            r1.setVisibility(r5)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24569m
            if (r1 != 0) goto L_0x00ea
            r7 = r3
            goto L_0x00eb
        L_0x00ea:
            r7 = r1
        L_0x00eb:
            r8 = 0
            r9 = 16
            java.lang.Object r1 = r0.get(r5)
            com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData r1 = (com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData) r1
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = r1.avatar
            r10 = r1
            goto L_0x00fb
        L_0x00fa:
            r10 = r3
        L_0x00fb:
            r11 = 0
            r12 = 8
            r13 = 0
            com.hbg.module.libkt.common.HexagonImageView.g(r7, r8, r9, r10, r11, r12, r13)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24570n
            if (r1 != 0) goto L_0x0108
            r7 = r3
            goto L_0x0109
        L_0x0108:
            r7 = r1
        L_0x0109:
            r8 = 0
            r9 = 16
            java.lang.Object r1 = r0.get(r4)
            com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData r1 = (com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData) r1
            if (r1 == 0) goto L_0x0118
            java.lang.String r1 = r1.avatar
            r10 = r1
            goto L_0x0119
        L_0x0118:
            r10 = r3
        L_0x0119:
            r11 = 0
            r12 = 8
            r13 = 0
            com.hbg.module.libkt.common.HexagonImageView.g(r7, r8, r9, r10, r11, r12, r13)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24571o
            if (r1 != 0) goto L_0x0126
            r7 = r3
            goto L_0x0127
        L_0x0126:
            r7 = r1
        L_0x0127:
            r8 = 0
            r9 = 16
            java.lang.Object r0 = r0.get(r6)
            com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData r0 = (com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData) r0
            if (r0 == 0) goto L_0x0134
            java.lang.String r3 = r0.avatar
        L_0x0134:
            r10 = r3
            r11 = 0
            r12 = 8
            r13 = 0
            com.hbg.module.libkt.common.HexagonImageView.g(r7, r8, r9, r10, r11, r12, r13)
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.common.LiveRecommendPkCommonView.h():void");
    }

    public final void j() {
        setVisibility(8);
    }

    public final void k() {
        HuobiToastUtil.j(R$string.n_content_common_widget_cannot_again_vote);
    }

    public final void l(String str) {
        if (TextUtils.isEmpty(str)) {
            HuobiToastUtil.j(R$string.n_im_operation_fail);
        } else {
            HuobiToastUtil.m(str);
        }
    }

    public final void m() {
        HuobiToastUtil.j(R$string.n_content_common_widget_vote_success);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        CommonPkData commonPkData = this.f24579w;
        if (commonPkData != null) {
            SensorsDataHelper.track("app_community_pkshow", MapsKt__MapsKt.j(l.a("pkId", Long.valueOf(commonPkData.voteId)), l.a("pktitle", commonPkData.content)));
        }
    }

    public final void setOnPkCommonViewListener(a aVar) {
        this.f24580x = aVar;
    }

    public final void setView(CommonPkData commonPkData) {
        int i11;
        int i12;
        setVisibility(0);
        this.f24579w = commonPkData;
        TextView textView = this.f24558b;
        TextView textView2 = null;
        if (textView == null) {
            textView = null;
        }
        textView.setText(commonPkData.content);
        TextView textView3 = this.f24568l;
        if (textView3 == null) {
            textView3 = null;
        }
        d0 d0Var = d0.f56774a;
        textView3.setText(String.format(getContext().getString(R$string.n_content_common_widget_people_count), Arrays.copyOf(new Object[]{String.valueOf(commonPkData.voteNums)}, 1)));
        h();
        List<CommonPkChoiceData> list = commonPkData.choiceList;
        if (list == null) {
            return;
        }
        if (list.size() >= 2) {
            CommonPkChoiceData commonPkChoiceData = list.get(0);
            CommonPkChoiceData commonPkChoiceData2 = list.get(1);
            boolean z11 = commonPkChoiceData.isJoin == 1;
            boolean z12 = commonPkChoiceData2.isJoin == 1;
            if (z11 || z12) {
                setOnClickListener(new je.b(this));
            } else {
                setOnClickListener((View.OnClickListener) null);
                setClickable(false);
            }
            if (z11 || z12) {
                LinearLayout linearLayout = this.f24560d;
                if (linearLayout == null) {
                    linearLayout = null;
                }
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = this.f24561e;
                if (linearLayout2 == null) {
                    linearLayout2 = null;
                }
                linearLayout2.setVisibility(0);
                RelativeLayout relativeLayout = this.f24562f;
                if (relativeLayout == null) {
                    relativeLayout = null;
                }
                relativeLayout.setVisibility(0);
                LiveRecommendPkProgressView liveRecommendPkProgressView = this.f24559c;
                if (liveRecommendPkProgressView == null) {
                    liveRecommendPkProgressView = null;
                }
                liveRecommendPkProgressView.setAgreeCount(commonPkChoiceData.joinNums);
            } else {
                LinearLayout linearLayout3 = this.f24560d;
                if (linearLayout3 == null) {
                    linearLayout3 = null;
                }
                linearLayout3.setVisibility(0);
                LinearLayout linearLayout4 = this.f24561e;
                if (linearLayout4 == null) {
                    linearLayout4 = null;
                }
                linearLayout4.setVisibility(8);
                RelativeLayout relativeLayout2 = this.f24562f;
                if (relativeLayout2 == null) {
                    relativeLayout2 = null;
                }
                relativeLayout2.setVisibility(8);
                LiveRecommendPkProgressView liveRecommendPkProgressView2 = this.f24559c;
                if (liveRecommendPkProgressView2 == null) {
                    liveRecommendPkProgressView2 = null;
                }
                liveRecommendPkProgressView2.setAgreeCount(1);
            }
            if (z11 || z12) {
                LinearLayout linearLayout5 = this.f24560d;
                if (linearLayout5 == null) {
                    linearLayout5 = null;
                }
                linearLayout5.setVisibility(8);
                LinearLayout linearLayout6 = this.f24561e;
                if (linearLayout6 == null) {
                    linearLayout6 = null;
                }
                linearLayout6.setVisibility(0);
                RelativeLayout relativeLayout3 = this.f24562f;
                if (relativeLayout3 == null) {
                    relativeLayout3 = null;
                }
                relativeLayout3.setVisibility(0);
                LiveRecommendPkProgressView liveRecommendPkProgressView3 = this.f24559c;
                if (liveRecommendPkProgressView3 == null) {
                    liveRecommendPkProgressView3 = null;
                }
                liveRecommendPkProgressView3.setDisAgreeCount(commonPkChoiceData2.joinNums);
            } else {
                LinearLayout linearLayout7 = this.f24560d;
                if (linearLayout7 == null) {
                    linearLayout7 = null;
                }
                linearLayout7.setVisibility(0);
                LinearLayout linearLayout8 = this.f24561e;
                if (linearLayout8 == null) {
                    linearLayout8 = null;
                }
                linearLayout8.setVisibility(8);
                RelativeLayout relativeLayout4 = this.f24562f;
                if (relativeLayout4 == null) {
                    relativeLayout4 = null;
                }
                relativeLayout4.setVisibility(8);
                LiveRecommendPkProgressView liveRecommendPkProgressView4 = this.f24559c;
                if (liveRecommendPkProgressView4 == null) {
                    liveRecommendPkProgressView4 = null;
                }
                liveRecommendPkProgressView4.setDisAgreeCount(1);
            }
            LiveRecommendPkProgressView liveRecommendPkProgressView5 = this.f24559c;
            if (liveRecommendPkProgressView5 == null) {
                liveRecommendPkProgressView5 = null;
            }
            liveRecommendPkProgressView5.b();
            TextView textView4 = this.f24577u;
            if (textView4 == null) {
                textView4 = null;
            }
            Resources resources = getResources();
            int i13 = R$color.pk_hint_text;
            textView4.setTextColor(resources.getColor(i13));
            TextView textView5 = this.f24578v;
            if (textView5 == null) {
                textView5 = null;
            }
            textView5.setTextColor(getResources().getColor(i13));
            if (z11 || z12) {
                LiveRecommendPkProgressView liveRecommendPkProgressView6 = this.f24559c;
                if (liveRecommendPkProgressView6 == null) {
                    liveRecommendPkProgressView6 = null;
                }
                int b11 = MathKt__MathJVMKt.b(liveRecommendPkProgressView6.getProgress() * ((float) 100));
                int i14 = 100 - b11;
                TextView textView6 = this.f24566j;
                if (textView6 == null) {
                    textView6 = null;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b11);
                sb2.append('%');
                textView6.setText(sb2.toString());
                TextView textView7 = this.f24567k;
                if (textView7 == null) {
                    textView7 = null;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i14);
                sb3.append('%');
                textView7.setText(sb3.toString());
                ImageView imageView = this.f24575s;
                if (imageView == null) {
                    imageView = null;
                }
                if (z11) {
                    TextView textView8 = this.f24577u;
                    if (textView8 == null) {
                        textView8 = null;
                    }
                    textView8.setTextColor(getResources().getColor(R$color.pk_green));
                    i11 = 0;
                } else {
                    i11 = 8;
                }
                imageView.setVisibility(i11);
                ImageView imageView2 = this.f24576t;
                if (imageView2 == null) {
                    imageView2 = null;
                }
                if (z12) {
                    TextView textView9 = this.f24578v;
                    if (textView9 == null) {
                        textView9 = null;
                    }
                    textView9.setTextColor(getResources().getColor(R$color.color_rise_fall_red));
                    i12 = 0;
                } else {
                    i12 = 8;
                }
                imageView2.setVisibility(i12);
            } else {
                TextView textView10 = this.f24566j;
                if (textView10 == null) {
                    textView10 = null;
                }
                textView10.setText("");
                TextView textView11 = this.f24567k;
                if (textView11 == null) {
                    textView11 = null;
                }
                textView11.setText("");
                ImageView imageView3 = this.f24575s;
                if (imageView3 == null) {
                    imageView3 = null;
                }
                imageView3.setVisibility(8);
                ImageView imageView4 = this.f24576t;
                if (imageView4 == null) {
                    imageView4 = null;
                }
                imageView4.setVisibility(8);
            }
            if (z11 || z12) {
                int i15 = commonPkChoiceData.joinNums;
                if (i15 == 0 && commonPkChoiceData2.joinNums > 0) {
                    LinearLayout linearLayout9 = this.f24561e;
                    if (linearLayout9 == null) {
                        linearLayout9 = null;
                    }
                    linearLayout9.setVisibility(8);
                    RelativeLayout relativeLayout5 = this.f24562f;
                    if (relativeLayout5 == null) {
                        relativeLayout5 = null;
                    }
                    relativeLayout5.setVisibility(8);
                    TextView textView12 = this.f24563g;
                    if (textView12 == null) {
                        textView12 = null;
                    }
                    textView12.setVisibility(0);
                    TextView textView13 = this.f24563g;
                    if (textView13 == null) {
                        textView13 = null;
                    }
                    textView13.setBackgroundResource(R$drawable.bg_pk_all_red);
                    TextView textView14 = this.f24563g;
                    if (textView14 != null) {
                        textView2 = textView14;
                    }
                    textView2.setText("100% " + getResources().getString(R$string.n_live_recommend_vote_fall));
                } else if (i15 <= 0 || commonPkChoiceData2.joinNums != 0) {
                    TextView textView15 = this.f24563g;
                    if (textView15 != null) {
                        textView2 = textView15;
                    }
                    textView2.setVisibility(8);
                } else {
                    LinearLayout linearLayout10 = this.f24561e;
                    if (linearLayout10 == null) {
                        linearLayout10 = null;
                    }
                    linearLayout10.setVisibility(8);
                    RelativeLayout relativeLayout6 = this.f24562f;
                    if (relativeLayout6 == null) {
                        relativeLayout6 = null;
                    }
                    relativeLayout6.setVisibility(8);
                    TextView textView16 = this.f24563g;
                    if (textView16 == null) {
                        textView16 = null;
                    }
                    textView16.setVisibility(0);
                    TextView textView17 = this.f24563g;
                    if (textView17 == null) {
                        textView17 = null;
                    }
                    textView17.setBackgroundResource(R$drawable.bg_pk_all_green);
                    TextView textView18 = this.f24563g;
                    if (textView18 != null) {
                        textView2 = textView18;
                    }
                    textView2.setText("100% " + getResources().getString(R$string.n_live_recommend_vote_rise));
                }
            } else {
                TextView textView19 = this.f24563g;
                if (textView19 != null) {
                    textView2 = textView19;
                }
                textView2.setVisibility(8);
            }
        } else {
            j();
        }
    }

    public LiveRecommendPkCommonView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.C = PixelUtils.a(16.0f);
        this.f24581y = ContextCompat.getDrawable(context, R$drawable.bg_agree_btn);
        this.f24582z = ContextCompat.getDrawable(context, R$drawable.bg_disagree_btn);
        this.A = ContextCompat.getDrawable(context, R$drawable.bg_agree_selected_btn);
        this.B = ContextCompat.getDrawable(context, R$drawable.bg_disagree_selected_btn);
        f(attributeSet);
        c();
    }
}
