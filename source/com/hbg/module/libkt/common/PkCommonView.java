package com.hbg.module.libkt.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
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
import com.hbg.module.libkt.utils.g;
import com.hbg.module.libkt.utils.h;
import com.hbg.module.libkt.utils.r;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.l;

public final class PkCommonView extends FrameLayout {
    public CommonPkData A;
    public CountDownTimer B;
    public a C;
    public Drawable D;
    public Drawable E;
    public Drawable F;
    public Drawable G;
    public int H;
    public String I;
    public String J;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24599b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f24600c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f24601d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24602e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f24603f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f24604g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f24605h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f24606i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f24607j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f24608k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f24609l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f24610m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f24611n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f24612o;

    /* renamed from: p  reason: collision with root package name */
    public HexagonImageView f24613p;

    /* renamed from: q  reason: collision with root package name */
    public HexagonImageView f24614q;

    /* renamed from: r  reason: collision with root package name */
    public HexagonImageView f24615r;

    /* renamed from: s  reason: collision with root package name */
    public RelativeLayout f24616s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f24617t;

    /* renamed from: u  reason: collision with root package name */
    public RelativeLayout f24618u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f24619v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f24620w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f24621x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f24622y;

    /* renamed from: z  reason: collision with root package name */
    public LinearLayout f24623z;

    public interface a {
        void a(View view);

        void b(View view);
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f24624b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f24625c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PkCommonView f24626d;

        public b(View view, long j11, PkCommonView pkCommonView) {
            this.f24624b = view;
            this.f24625c = j11;
            this.f24626d = pkCommonView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f24624b) > this.f24625c || (this.f24624b instanceof Checkable)) {
                rVar.e(this.f24624b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f24624b;
                this.f24626d.g(true);
                a onPkCommonViewListener = this.f24626d.getOnPkCommonViewListener();
                if (onPkCommonViewListener != null) {
                    onPkCommonViewListener.b(linearLayout);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f24627b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f24628c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PkCommonView f24629d;

        public c(View view, long j11, PkCommonView pkCommonView) {
            this.f24627b = view;
            this.f24628c = j11;
            this.f24629d = pkCommonView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f24627b) > this.f24628c || (this.f24627b instanceof Checkable)) {
                rVar.e(this.f24627b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f24627b;
                this.f24629d.g(false);
                a onPkCommonViewListener = this.f24629d.getOnPkCommonViewListener();
                if (onPkCommonViewListener != null) {
                    onPkCommonViewListener.a(linearLayout);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements ue.b<CommonPkData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PkCommonView f24630a;

        public d(PkCommonView pkCommonView) {
            this.f24630a = pkCommonView;
        }

        public void a(String str, String str2) {
            this.f24630a.t(str2);
        }

        /* renamed from: b */
        public void onSuccess(CommonPkData commonPkData) {
            if (commonPkData != null) {
                PkCommonView pkCommonView = this.f24630a;
                pkCommonView.h(commonPkData);
                pkCommonView.setView(commonPkData);
                pkCommonView.u();
            }
        }
    }

    public static final class e implements g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonPkData f24631a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PkCommonView f24632b;

        public e(CommonPkData commonPkData, PkCommonView pkCommonView) {
            this.f24631a = commonPkData;
            this.f24632b = pkCommonView;
        }

        public void a() {
            this.f24632b.j();
        }

        public void b(long j11) {
            if (j11 < 1000) {
                this.f24631a.duration = 0;
                return;
            }
            this.f24631a.duration = (long) Math.floor((double) (((float) j11) / 1000.0f));
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f24633b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f24634c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommonPkData f24635d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PkCommonView f24636e;

        public f(View view, long j11, CommonPkData commonPkData, PkCommonView pkCommonView) {
            this.f24633b = view;
            this.f24634c = j11;
            this.f24635d = commonPkData;
            this.f24636e = pkCommonView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f24633b) > this.f24634c || (this.f24633b instanceof Checkable)) {
                rVar.e(this.f24633b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f24633b;
                SensorsDataHelper.track("app_community_pkshare", MapsKt__MapsKt.j(l.a("pkId", Long.valueOf(this.f24635d.voteId)), l.a("pktitle", this.f24635d.content), l.a("TransPair_current_id", this.f24636e.I), l.a("markets_kline_class", this.f24636e.J)));
                Bundle bundle = new Bundle();
                bundle.putString("extendedParameter", "{\"topicId\":\"" + this.f24635d.voteId + "\",\"shareChannel\":17}");
                b2.a.d().a("/share/shareFeed").with(bundle).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public PkCommonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (kotlin.jvm.internal.r) null);
    }

    public PkCommonView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (kotlin.jvm.internal.r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PkCommonView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, kotlin.jvm.internal.r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    @SensorsDataInstrumented
    public static final void k(PkCommonView pkCommonView, View view) {
        HuobiToastUtil.m(pkCommonView.getContext().getResources().getString(R$string.n_content_voting_has_ended));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void q(PkCommonView pkCommonView, View view) {
        HuobiToastUtil.m(pkCommonView.getContext().getResources().getString(R$string.n_content_voted));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void f() {
        r rVar = r.f24939a;
        LinearLayout linearLayout = this.f24603f;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new b(linearLayout, 800, this));
        LinearLayout linearLayout3 = this.f24604g;
        if (linearLayout3 != null) {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setOnClickListener(new c(linearLayout2, 800, this));
    }

    public final void g(boolean z11) {
        List<CommonPkChoiceData> list;
        CommonPkData commonPkData;
        CommonPkData commonPkData2 = this.A;
        if (commonPkData2 != null) {
            long j11 = 0;
            if (commonPkData2.duration > 0 && (list = commonPkData2.choiceList) != null && list.size() >= 2) {
                CommonPkChoiceData commonPkChoiceData = list.get(0);
                int i11 = -1;
                String str = "";
                if (commonPkChoiceData != null) {
                    if (z11) {
                        j11 = commonPkChoiceData.choiceId;
                        str = commonPkChoiceData.choice;
                    }
                    i11 = commonPkChoiceData.isJoin;
                }
                if (i11 == 1) {
                    s();
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
                    s();
                } else if (i11 == 0 && (commonPkData = this.A) != null && !com.hbg.module.libkt.base.ext.b.x(commonPkData.topicId)) {
                    m((int) commonPkData.voteId, String.valueOf(j11), commonPkData.topicId, commonPkData.topicType, MapsKt__MapsKt.j(l.a("pkId", Long.valueOf(commonPkData2.voteId)), l.a("pktitle", commonPkData2.content), l.a("buttonName", str), l.a("TransPair_current_id", this.I), l.a("markets_kline_class", this.J)));
                }
            }
        }
    }

    public final a getOnPkCommonViewListener() {
        return this.C;
    }

    public final void h(CommonPkData commonPkData) {
        CommonPkData commonPkData2 = this.A;
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

    public final String i(int i11, int i12, int i13) {
        if (i12 == 0 && i13 == 0) {
            return "50%";
        }
        if (i12 == 0) {
            return i11 == 0 ? "0%" : "100%";
        }
        if (i13 == 0) {
            return i11 == 0 ? "100%" : "0%";
        }
        int i14 = (int) ((((float) 100) * ((float) i12)) / ((float) (i12 + i13)));
        if (i11 == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i14);
            sb2.append('%');
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(100 - i14);
        sb3.append('%');
        return sb3.toString();
    }

    public final void j() {
        LinearLayout linearLayout = this.f24605h;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView = this.f24619v;
        if (textView == null) {
            textView = null;
        }
        textView.setVisibility(getVisibility());
        LinearLayout linearLayout3 = this.f24600c;
        if (linearLayout3 == null) {
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = this.f24601d;
        if (linearLayout4 == null) {
            linearLayout4 = null;
        }
        linearLayout4.setVisibility(0);
        LinearLayout linearLayout5 = this.f24623z;
        if (linearLayout5 != null) {
            linearLayout2 = linearLayout5;
        }
        linearLayout2.setVisibility(8);
        setOnClickListener(new je.d(this));
    }

    public final void l(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_pk_common_widget, (ViewGroup) null);
        addView(inflate);
        this.f24599b = (TextView) inflate.findViewById(R$id.tv_title);
        this.f24600c = (LinearLayout) inflate.findViewById(R$id.llSelectBefore);
        this.f24601d = (LinearLayout) inflate.findViewById(R$id.ll_pk_progress);
        this.f24602e = (TextView) inflate.findViewById(R$id.tvPk100);
        this.f24603f = (LinearLayout) inflate.findViewById(R$id.ll_agree_btn);
        this.f24604g = (LinearLayout) inflate.findViewById(R$id.ll_disagree_btn);
        this.f24606i = (TextView) inflate.findViewById(R$id.tv_agree_progress);
        this.f24607j = (TextView) inflate.findViewById(R$id.tv_disagree_progress);
        this.f24608k = (TextView) inflate.findViewById(R$id.tvDay);
        this.f24609l = (TextView) inflate.findViewById(R$id.tvHour);
        this.f24610m = (TextView) inflate.findViewById(R$id.tvMinute);
        this.f24611n = (TextView) inflate.findViewById(R$id.tvSecond);
        this.f24613p = (HexagonImageView) inflate.findViewById(R$id.iv_icon1);
        this.f24614q = (HexagonImageView) inflate.findViewById(R$id.iv_icon2);
        this.f24615r = (HexagonImageView) inflate.findViewById(R$id.iv_icon3);
        this.f24616s = (RelativeLayout) inflate.findViewById(R$id.fl_icon1);
        this.f24617t = (RelativeLayout) inflate.findViewById(R$id.fl_icon2);
        this.f24618u = (RelativeLayout) inflate.findViewById(R$id.fl_icon3);
        this.f24612o = (TextView) inflate.findViewById(R$id.tv_people_count);
        this.f24619v = (TextView) inflate.findViewById(R$id.tv_finish_hint);
        this.f24620w = (TextView) inflate.findViewById(R$id.tv_agree_hint);
        this.f24621x = (TextView) inflate.findViewById(R$id.tv_disagree_hint);
        this.f24605h = (LinearLayout) inflate.findViewById(R$id.ll_count_time);
        this.f24622y = (TextView) inflate.findViewById(R$id.tvChooseType);
        this.f24623z = (LinearLayout) inflate.findViewById(R$id.llShareOption);
        setVisibility(8);
    }

    public final void m(int i11, String str, String str2, int i12, HashMap<Object, Object> hashMap) {
        if (i11 != 0 && !TextUtils.isEmpty(str)) {
            CommonWidgetHelper commonWidgetHelper = CommonWidgetHelper.f24861a;
            if (commonWidgetHelper.a((Activity) getContext())) {
                SensorsDataHelper.track("app_community_pkclick", hashMap);
                commonWidgetHelper.b(i11, str, str2, i12, new d(this));
            }
        }
    }

    public final void n() {
        TextView textView = this.f24619v;
        if (textView == null) {
            textView = null;
        }
        textView.setVisibility(8);
        LinearLayout linearLayout = this.f24605h;
        if (linearLayout == null) {
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        CommonPkData commonPkData = this.A;
        if (commonPkData != null) {
            CountDownTimer countDownTimer = this.B;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            FragmentActivity fragmentActivity = (FragmentActivity) getContext();
            long j11 = commonPkData.duration * ((long) 1000);
            TextView textView2 = this.f24608k;
            TextView textView3 = textView2 == null ? null : textView2;
            TextView textView4 = this.f24609l;
            TextView textView5 = textView4 == null ? null : textView4;
            TextView textView6 = this.f24610m;
            TextView textView7 = textView6 == null ? null : textView6;
            TextView textView8 = this.f24611n;
            this.B = h.a(fragmentActivity, j11, textView3, textView5, textView7, textView8 == null ? null : textView8, new e(commonPkData, this));
        }
    }

    public final void o(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.I = str;
        if (str2 == null) {
            str2 = "";
        }
        this.J = str2;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        CommonPkData commonPkData = this.A;
        if (commonPkData != null) {
            SensorsDataHelper.track("app_community_pkshow", MapsKt__MapsKt.j(l.a("pkId", Long.valueOf(commonPkData.voteId)), l.a("pktitle", commonPkData.content), l.a("TransPair_current_id", this.I), l.a("markets_kline_class", this.J)));
        }
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
    public final void p() {
        /*
            r14 = this;
            com.hbg.lib.network.hbg.core.bean.CommonPkData r0 = r14.A
            if (r0 == 0) goto L_0x013c
            java.util.List<com.hbg.lib.network.hbg.core.bean.CommonPkChoiceUserInfoData> r0 = r0.userInfo
            if (r0 == 0) goto L_0x013c
            int r1 = r0.size()
            r2 = 8
            r3 = 0
            if (r1 != 0) goto L_0x002c
            android.widget.RelativeLayout r0 = r14.f24616s
            if (r0 != 0) goto L_0x0016
            r0 = r3
        L_0x0016:
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r14.f24617t
            if (r0 != 0) goto L_0x001e
            r0 = r3
        L_0x001e:
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r14.f24618u
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
            android.widget.RelativeLayout r1 = r14.f24616s
            if (r1 != 0) goto L_0x0039
            r1 = r3
        L_0x0039:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24617t
            if (r1 != 0) goto L_0x0041
            r1 = r3
        L_0x0041:
            r1.setVisibility(r2)
            android.widget.RelativeLayout r1 = r14.f24618u
            if (r1 != 0) goto L_0x0049
            r1 = r3
        L_0x0049:
            r1.setVisibility(r2)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24613p
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
            android.widget.RelativeLayout r1 = r14.f24616s
            if (r1 != 0) goto L_0x0076
            r1 = r3
        L_0x0076:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24617t
            if (r1 != 0) goto L_0x007e
            r1 = r3
        L_0x007e:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24618u
            if (r1 != 0) goto L_0x0086
            r1 = r3
        L_0x0086:
            r1.setVisibility(r2)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24613p
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
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24614q
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
            android.widget.RelativeLayout r1 = r14.f24616s
            if (r1 != 0) goto L_0x00d1
            r1 = r3
        L_0x00d1:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24617t
            if (r1 != 0) goto L_0x00d9
            r1 = r3
        L_0x00d9:
            r1.setVisibility(r5)
            android.widget.RelativeLayout r1 = r14.f24618u
            if (r1 != 0) goto L_0x00e1
            r1 = r3
        L_0x00e1:
            r1.setVisibility(r5)
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24613p
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
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24614q
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
            com.hbg.module.libkt.common.HexagonImageView r1 = r14.f24615r
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
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.common.PkCommonView.p():void");
    }

    public final void r() {
        setVisibility(8);
    }

    public final void s() {
        HuobiToastUtil.j(R$string.n_content_common_widget_cannot_again_vote);
    }

    public final void setOnPkCommonViewListener(a aVar) {
        this.C = aVar;
    }

    public final void setView(CommonPkData commonPkData) {
        int i11;
        String str;
        CommonPkData commonPkData2 = commonPkData;
        setVisibility(0);
        this.A = commonPkData2;
        TextView textView = this.f24599b;
        if (textView == null) {
            textView = null;
        }
        textView.setText(commonPkData2.content);
        TextView textView2 = this.f24612o;
        if (textView2 == null) {
            textView2 = null;
        }
        d0 d0Var = d0.f56774a;
        textView2.setText(String.format(getContext().getString(R$string.n_content_common_widget_people_count), Arrays.copyOf(new Object[]{String.valueOf(commonPkData2.voteNums)}, 1)));
        p();
        List<CommonPkChoiceData> list = commonPkData2.choiceList;
        if (list == null) {
            return;
        }
        if (list.size() >= 2) {
            CommonPkChoiceData commonPkChoiceData = list.get(0);
            CommonPkChoiceData commonPkChoiceData2 = list.get(1);
            boolean z11 = commonPkChoiceData.isJoin == 1;
            boolean z12 = commonPkChoiceData2.isJoin == 1;
            if (z11 || z12) {
                LinearLayout linearLayout = this.f24605h;
                if (linearLayout == null) {
                    linearLayout = null;
                }
                linearLayout.setVisibility(8);
                setOnClickListener(new je.c(this));
                if (commonPkData2.duration > 0) {
                    TextView textView3 = this.f24622y;
                    if (textView3 == null) {
                        textView3 = null;
                    }
                    String string = getResources().getString(R$string.n_community_voting_result);
                    Object[] objArr = new Object[1];
                    if (z11) {
                        str = commonPkChoiceData.choice;
                    } else {
                        str = commonPkChoiceData2.choice;
                    }
                    objArr[0] = str;
                    textView3.setText(String.format(string, Arrays.copyOf(objArr, 1)));
                    LinearLayout linearLayout2 = this.f24623z;
                    if (linearLayout2 == null) {
                        linearLayout2 = null;
                    }
                    linearLayout2.setVisibility(0);
                    r rVar = r.f24939a;
                    LinearLayout linearLayout3 = this.f24623z;
                    LinearLayout linearLayout4 = linearLayout3 == null ? null : linearLayout3;
                    f fVar = r0;
                    i11 = 8;
                    f fVar2 = new f(linearLayout4, 800, commonPkData, this);
                    linearLayout4.setOnClickListener(fVar);
                } else {
                    i11 = 8;
                    LinearLayout linearLayout5 = this.f24623z;
                    if (linearLayout5 == null) {
                        linearLayout5 = null;
                    }
                    linearLayout5.setVisibility(8);
                }
            } else {
                LinearLayout linearLayout6 = this.f24623z;
                if (linearLayout6 == null) {
                    linearLayout6 = null;
                }
                linearLayout6.setVisibility(8);
                setOnClickListener((View.OnClickListener) null);
                setClickable(false);
                i11 = 8;
            }
            if (!TextUtils.isEmpty(commonPkChoiceData.choice)) {
                TextView textView4 = this.f24620w;
                if (textView4 == null) {
                    textView4 = null;
                }
                textView4.setText(commonPkChoiceData.choice);
            }
            if (z11 || z12) {
                LinearLayout linearLayout7 = this.f24600c;
                if (linearLayout7 == null) {
                    linearLayout7 = null;
                }
                linearLayout7.setVisibility(i11);
                LinearLayout linearLayout8 = this.f24601d;
                if (linearLayout8 == null) {
                    linearLayout8 = null;
                }
                linearLayout8.setVisibility(0);
                TextView textView5 = this.f24606i;
                if (textView5 == null) {
                    textView5 = null;
                }
                ((LinearLayout.LayoutParams) textView5.getLayoutParams()).weight = (float) commonPkChoiceData.joinNums;
            } else {
                LinearLayout linearLayout9 = this.f24600c;
                if (linearLayout9 == null) {
                    linearLayout9 = null;
                }
                linearLayout9.setVisibility(0);
                LinearLayout linearLayout10 = this.f24601d;
                if (linearLayout10 == null) {
                    linearLayout10 = null;
                }
                linearLayout10.setVisibility(i11);
                if (commonPkData2.duration > 0) {
                    TextView textView6 = this.f24606i;
                    if (textView6 == null) {
                        textView6 = null;
                    }
                    ((LinearLayout.LayoutParams) textView6.getLayoutParams()).weight = 1.0f;
                } else {
                    TextView textView7 = this.f24606i;
                    if (textView7 == null) {
                        textView7 = null;
                    }
                    ((LinearLayout.LayoutParams) textView7.getLayoutParams()).weight = (float) commonPkChoiceData.joinNums;
                }
            }
            if (!TextUtils.isEmpty(commonPkChoiceData2.choice)) {
                TextView textView8 = this.f24621x;
                if (textView8 == null) {
                    textView8 = null;
                }
                textView8.setText(commonPkChoiceData2.choice);
            }
            if (z11 || z12) {
                LinearLayout linearLayout11 = this.f24600c;
                if (linearLayout11 == null) {
                    linearLayout11 = null;
                }
                linearLayout11.setVisibility(i11);
                LinearLayout linearLayout12 = this.f24601d;
                if (linearLayout12 == null) {
                    linearLayout12 = null;
                }
                linearLayout12.setVisibility(0);
                if (z11) {
                    r rVar2 = r.f24939a;
                    TextView textView9 = this.f24620w;
                    if (textView9 == null) {
                        textView9 = null;
                    }
                    rVar2.f(textView9, R$color.white);
                } else if (z12) {
                    r rVar3 = r.f24939a;
                    TextView textView10 = this.f24621x;
                    if (textView10 == null) {
                        textView10 = null;
                    }
                    rVar3.f(textView10, R$color.white);
                } else {
                    TextView textView11 = this.f24620w;
                    if (textView11 == null) {
                        textView11 = null;
                    }
                    textView11.setTextColor(getResources().getColor(R$color.baseColorMajorTheme100));
                    TextView textView12 = this.f24621x;
                    if (textView12 == null) {
                        textView12 = null;
                    }
                    textView12.setTextColor(getResources().getColor(R$color.color_rise_fall_red));
                }
                TextView textView13 = this.f24607j;
                if (textView13 == null) {
                    textView13 = null;
                }
                ((LinearLayout.LayoutParams) textView13.getLayoutParams()).weight = (float) commonPkChoiceData2.joinNums;
            } else {
                LinearLayout linearLayout13 = this.f24600c;
                if (linearLayout13 == null) {
                    linearLayout13 = null;
                }
                linearLayout13.setVisibility(0);
                LinearLayout linearLayout14 = this.f24601d;
                if (linearLayout14 == null) {
                    linearLayout14 = null;
                }
                linearLayout14.setVisibility(i11);
                if (commonPkData2.duration > 0) {
                    TextView textView14 = this.f24607j;
                    if (textView14 == null) {
                        textView14 = null;
                    }
                    ((LinearLayout.LayoutParams) textView14.getLayoutParams()).weight = 1.0f;
                } else {
                    TextView textView15 = this.f24607j;
                    if (textView15 == null) {
                        textView15 = null;
                    }
                    ((LinearLayout.LayoutParams) textView15.getLayoutParams()).weight = (float) commonPkChoiceData2.joinNums;
                }
            }
            if (z11 || z12 || commonPkData2.duration <= 0) {
                TextView textView16 = this.f24606i;
                if (textView16 == null) {
                    textView16 = null;
                }
                textView16.setText(i(0, commonPkChoiceData.joinNums, commonPkChoiceData2.joinNums));
                TextView textView17 = this.f24607j;
                if (textView17 == null) {
                    textView17 = null;
                }
                textView17.setText(i(1, commonPkChoiceData.joinNums, commonPkChoiceData2.joinNums));
            } else {
                TextView textView18 = this.f24606i;
                if (textView18 == null) {
                    textView18 = null;
                }
                textView18.setText("50%");
                TextView textView19 = this.f24607j;
                if (textView19 == null) {
                    textView19 = null;
                }
                textView19.setText("50%");
            }
            if (commonPkData2.duration > 0) {
                n();
            } else {
                j();
            }
            if (z11 || z12) {
                LinearLayout linearLayout15 = this.f24605h;
                if (linearLayout15 == null) {
                    linearLayout15 = null;
                }
                linearLayout15.setVisibility(i11);
            }
            if (z11 || z12 || commonPkData2.duration <= 0) {
                int i12 = commonPkChoiceData.joinNums;
                if (i12 == 0 && commonPkChoiceData2.joinNums > 0) {
                    LinearLayout linearLayout16 = this.f24601d;
                    if (linearLayout16 == null) {
                        linearLayout16 = null;
                    }
                    linearLayout16.setVisibility(i11);
                    TextView textView20 = this.f24602e;
                    if (textView20 == null) {
                        textView20 = null;
                    }
                    textView20.setVisibility(0);
                    TextView textView21 = this.f24602e;
                    if (textView21 == null) {
                        textView21 = null;
                    }
                    textView21.setBackgroundResource(R$drawable.bg_pk_all_red);
                    TextView textView22 = this.f24602e;
                    (textView22 == null ? null : textView22).setText("100% " + commonPkChoiceData2.choice);
                } else if (i12 <= 0 || commonPkChoiceData2.joinNums != 0) {
                    TextView textView23 = this.f24602e;
                    (textView23 == null ? null : textView23).setVisibility(i11);
                } else {
                    LinearLayout linearLayout17 = this.f24601d;
                    if (linearLayout17 == null) {
                        linearLayout17 = null;
                    }
                    linearLayout17.setVisibility(i11);
                    TextView textView24 = this.f24602e;
                    if (textView24 == null) {
                        textView24 = null;
                    }
                    textView24.setVisibility(0);
                    TextView textView25 = this.f24602e;
                    if (textView25 == null) {
                        textView25 = null;
                    }
                    textView25.setBackgroundResource(R$drawable.bg_pk_all_blue);
                    TextView textView26 = this.f24602e;
                    (textView26 == null ? null : textView26).setText("100% " + commonPkChoiceData.choice);
                }
            } else {
                TextView textView27 = this.f24602e;
                (textView27 == null ? null : textView27).setVisibility(i11);
            }
        } else {
            r();
        }
    }

    public final void t(String str) {
        if (TextUtils.isEmpty(str)) {
            HuobiToastUtil.j(R$string.n_im_operation_fail);
        } else {
            HuobiToastUtil.m(str);
        }
    }

    public final void u() {
        HuobiToastUtil.j(R$string.n_content_common_widget_vote_success);
    }

    public PkCommonView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.I = "";
        this.J = "";
        this.H = PixelUtils.a(16.0f);
        this.D = ContextCompat.getDrawable(context, R$drawable.bg_agree_btn);
        this.E = ContextCompat.getDrawable(context, R$drawable.bg_disagree_btn);
        this.F = ContextCompat.getDrawable(context, R$drawable.bg_agree_selected_btn);
        this.G = ContextCompat.getDrawable(context, R$drawable.bg_disagree_selected_btn);
        l(attributeSet);
        f();
    }
}
