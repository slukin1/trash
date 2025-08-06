package com.hbg.module.content.utls;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.hbg.module.content.R$dimen;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.view.HbgPopupWindow;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.jvm.internal.r;

public final class TipsPopDialog extends HbgPopupWindow {

    /* renamed from: m  reason: collision with root package name */
    public static final e f18819m = new e((r) null);

    /* renamed from: a  reason: collision with root package name */
    public String f18820a;

    /* renamed from: b  reason: collision with root package name */
    public String f18821b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18822c;

    /* renamed from: d  reason: collision with root package name */
    public int f18823d;

    /* renamed from: e  reason: collision with root package name */
    public View f18824e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18825f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18826g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18827h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18828i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f18829j;

    /* renamed from: k  reason: collision with root package name */
    public int f18830k;

    /* renamed from: l  reason: collision with root package name */
    public int f18831l;

    public static final class a extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ oc.a f18832b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TipsPopDialog f18833c;

        public a(oc.a aVar, TipsPopDialog tipsPopDialog) {
            this.f18832b = aVar;
            this.f18833c = tipsPopDialog;
        }

        public void onViewClick(View view) {
            this.f18832b.a();
            this.f18833c.dismiss();
        }
    }

    public static final class b extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TipsPopDialog f18834b;

        public b(TipsPopDialog tipsPopDialog) {
            this.f18834b = tipsPopDialog;
        }

        public void onViewClick(View view) {
            this.f18834b.h(1);
            this.f18834b.dismiss();
        }
    }

    public static final class c extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TipsPopDialog f18835b;

        public c(TipsPopDialog tipsPopDialog) {
            this.f18835b = tipsPopDialog;
        }

        public void onViewClick(View view) {
            this.f18835b.h(0);
            this.f18835b.dismiss();
        }
    }

    public static final class d extends NoDoubleClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TipsPopDialog f18836b;

        public d(TipsPopDialog tipsPopDialog) {
            this.f18836b = tipsPopDialog;
        }

        public void onViewClick(View view) {
            this.f18836b.i();
            this.f18836b.dismiss();
        }
    }

    public static final class e {
        public e() {
        }

        public /* synthetic */ e(r rVar) {
            this();
        }

        public final View a(Context context) {
            return View.inflate(context, R$layout.pop_supper_admin, (ViewGroup) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TipsPopDialog(Context context, oc.a aVar, String str, String str2, boolean z11, int i11, int i12, r rVar) {
        this(context, aVar, (i12 & 4) != 0 ? null : str, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? false : z11, (i12 & 32) != 0 ? 1 : i11);
    }

    @SensorsDataInstrumented
    public static final void d(oc.a aVar, TipsPopDialog tipsPopDialog, View view) {
        aVar.b();
        tipsPopDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final boolean f(TipsPopDialog tipsPopDialog, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        tipsPopDialog.dismiss();
        return false;
    }

    public final void e() {
        this.f18824e.setOnTouchListener(new s(this));
    }

    public final void g(View view) {
        if (this.f18830k == 0) {
            this.f18830k = view.getResources().getDimensionPixelOffset(R$dimen.dimen_55);
        }
        if (this.f18831l == 0) {
            this.f18831l = view.getResources().getDimensionPixelOffset(R$dimen.dimen_3);
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        showAtLocation(view, 49, 0, (iArr[1] - this.f18830k) + this.f18831l);
    }

    public final void h(int i11) {
        RequestExtKt.d(v7.b.a().t(i11, this.f18821b), TipsPopDialog$userMute$1.INSTANCE, TipsPopDialog$userMute$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void i() {
        RequestExtKt.d(v7.b.a().v(this.f18821b), TipsPopDialog$userUnMute$1.INSTANCE, TipsPopDialog$userUnMute$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void setCancelOnTouchOutside(boolean z11) {
        setOutsideTouchable(z11);
        setFocusable(z11);
    }

    public TipsPopDialog(Context context, oc.a aVar, String str, String str2, boolean z11, int i11) {
        super(f18819m.a(context), -2, -2);
        String str3;
        this.f18820a = str;
        this.f18821b = str2;
        this.f18822c = z11;
        this.f18823d = i11;
        this.f18824e = getContentView().findViewById(R$id.popRootView);
        this.f18825f = (TextView) getContentView().findViewById(R$id.tvDel);
        this.f18826g = (TextView) getContentView().findViewById(R$id.tvMute3);
        this.f18827h = (TextView) getContentView().findViewById(R$id.tvMuteForever);
        this.f18828i = (TextView) getContentView().findViewById(R$id.tvUnMute);
        this.f18829j = (TextView) getContentView().findViewById(R$id.tvTranslate);
        setWidth(context.getResources().getDisplayMetrics().widthPixels);
        setBackgroundDrawable(new ColorDrawable(0));
        setCancelOnTouchOutside(true);
        e();
        if (this.f18822c) {
            TextView textView = this.f18829j;
            if (this.f18823d == 1) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R$drawable.icon_translate, 0, 0);
                str3 = context.getResources().getString(R$string.n_content_translate);
            } else {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R$drawable.icon_un_translate, 0, 0);
                str3 = context.getResources().getString(R$string.n_content_translate_originaltext);
            }
            textView.setText(str3);
            this.f18825f.setVisibility(8);
            this.f18826g.setVisibility(8);
            this.f18827h.setVisibility(8);
            this.f18828i.setVisibility(8);
            this.f18829j.setVisibility(0);
            this.f18829j.setOnClickListener(new r(aVar, this));
            return;
        }
        this.f18825f.setOnClickListener(new a(aVar, this));
        this.f18826g.setOnClickListener(new b(this));
        this.f18827h.setOnClickListener(new c(this));
        this.f18828i.setOnClickListener(new d(this));
    }
}
