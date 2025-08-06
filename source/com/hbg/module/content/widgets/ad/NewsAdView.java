package com.hbg.module.content.widgets.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.widgets.ad.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.Unit;
import rd.s;

public final class NewsAdView implements a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f18960a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f18961b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f18962c;

    /* renamed from: d  reason: collision with root package name */
    public int f18963d = 4;

    /* renamed from: e  reason: collision with root package name */
    public String f18964e = "";

    /* renamed from: f  reason: collision with root package name */
    public d10.a<Unit> f18965f;

    /* renamed from: g  reason: collision with root package name */
    public String f18966g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f18967h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f18968i = "";

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18969b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18970c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsAdView f18971d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f18972e;

        public a(View view, long j11, NewsAdView newsAdView, Context context) {
            this.f18969b = view;
            this.f18970c = j11;
            this.f18971d = newsAdView;
            this.f18972e = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18969b) > this.f18970c || (this.f18969b instanceof Checkable)) {
                sVar.e(this.f18969b, currentTimeMillis);
                AdItemView adItemView = (AdItemView) this.f18969b;
                this.f18971d.n(this.f18972e);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18973b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18974c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewsAdView f18975d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f18976e;

        public b(View view, long j11, NewsAdView newsAdView, Context context) {
            this.f18973b = view;
            this.f18974c = j11;
            this.f18975d = newsAdView;
            this.f18976e = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18973b) > this.f18974c || (this.f18973b instanceof Checkable)) {
                sVar.e(this.f18973b, currentTimeMillis);
                TextView textView = (TextView) this.f18973b;
                d10.a<Unit> k11 = this.f18975d.k();
                if (k11 != null) {
                    k11.invoke();
                }
                this.f18975d.n(this.f18976e);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public void a(String str) {
        this.f18966g = str;
        TextView textView = this.f18961b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(Context context, AdItemView adItemView) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        boolean z11 = true;
        LayoutInflater.from(adItemView.getContext()).inflate(R$layout.item_ad_layout, adItemView, true);
        this.f18960a = (ImageView) adItemView.findViewById(R$id.adIconView);
        this.f18961b = (TextView) adItemView.findViewById(R$id.adTitleView);
        this.f18962c = (TextView) adItemView.findViewById(R$id.adActionView);
        if ((j().length() > 0) && (imageView = this.f18960a) != null) {
            sd.a.d(imageView, j(), R$drawable.bg_img_placeholder);
        }
        if ((m().length() > 0) && (textView2 = this.f18961b) != null) {
            textView2.setText(m());
        }
        if (i().length() <= 0) {
            z11 = false;
        }
        if (z11 && (textView = this.f18962c) != null) {
            textView.setText(i());
        }
        s sVar = s.f23381a;
        adItemView.setOnClickListener(new a(adItemView, 800, this, context));
        TextView textView3 = this.f18962c;
        if (textView3 != null) {
            textView3.setOnClickListener(new b(textView3, 800, this, context));
        }
    }

    public String c() {
        return this.f18964e;
    }

    public void d() {
        this.f18960a = null;
        this.f18961b = null;
        this.f18962c = null;
    }

    public void e(String str) {
        this.f18968i = str;
        TextView textView = this.f18962c;
        if (textView != null) {
            textView.setText(l(str, this.f18963d));
        }
    }

    public void f(String str) {
        this.f18964e = str;
    }

    public void g(String str) {
        this.f18967h = str;
        ImageView imageView = this.f18960a;
        if (imageView != null) {
            sd.a.d(imageView, str, R$drawable.bg_img_placeholder);
        }
    }

    public void h(d10.a<Unit> aVar) {
        this.f18965f = aVar;
    }

    public String i() {
        return this.f18968i;
    }

    public String j() {
        return this.f18967h;
    }

    public d10.a<Unit> k() {
        return this.f18965f;
    }

    public String l(String str, int i11) {
        return a.C0129a.a(this, str, i11);
    }

    public String m() {
        return this.f18966g;
    }

    public void n(Context context) {
        a.C0129a.b(this, context);
    }
}
