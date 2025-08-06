package com.huobi.homemarket.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ll.j;
import ul.a1;

public class MarketSortLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: i  reason: collision with root package name */
    public static String f72960i = "";

    /* renamed from: j  reason: collision with root package name */
    public static String f72961j = "sort_normal";

    /* renamed from: b  reason: collision with root package name */
    public a f72962b;

    /* renamed from: c  reason: collision with root package name */
    public View f72963c;

    /* renamed from: d  reason: collision with root package name */
    public int f72964d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f72965e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f72966f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f72967g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f72968h;

    public interface a {
        void w8(String str, String str2);
    }

    public MarketSortLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f72964d = this.f72963c.getHeight();
    }

    public final void b(TextView textView) {
        if ("sort_normal".equals(f72961j)) {
            f72961j = "sort_asc";
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_up_light), (Drawable) null);
        } else if ("sort_asc".equals(f72961j)) {
            f72961j = "sort_desc";
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_down_light), (Drawable) null);
        } else if ("sort_desc".equals(f72961j)) {
            f72961j = "sort_normal";
            if ("type_name".equals(f72960i)) {
                h();
            } else if ("type_price".equals(f72960i)) {
                i();
            } else if ("type_amount".equals(f72960i)) {
                f();
            } else {
                g();
            }
            f72960i = "";
        }
        j.n().w(f72961j);
        j.n().x(f72960i);
    }

    public final void c() {
        this.f72963c = LayoutInflater.from(getContext()).inflate(R$layout.layout_market_sort_indicator, this, true);
        this.f72965e = (TextView) findViewById(R$id.market_sort_name_tv);
        this.f72966f = (TextView) findViewById(R$id.market_sort_price_tv);
        this.f72967g = (TextView) findViewById(R$id.market_sort_height_low_tv);
        this.f72968h = (TextView) findViewById(R$id.market_sort_amount);
        this.f72963c.post(new a1(this));
        d();
    }

    public final void d() {
        this.f72965e.setOnClickListener(this);
        this.f72966f.setOnClickListener(this);
        this.f72967g.setOnClickListener(this);
        this.f72968h.setOnClickListener(this);
    }

    public final void f() {
        this.f72968h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_default), (Drawable) null);
    }

    public final void g() {
        this.f72967g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_default), (Drawable) null);
    }

    public String getCurrentSort() {
        return f72961j;
    }

    public String getCurrentType() {
        return f72960i;
    }

    public final void h() {
        this.f72965e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_default), (Drawable) null);
    }

    public final void i() {
        this.f72966f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_default), (Drawable) null);
    }

    public final void j() {
        j.n().w(f72961j);
        j.n().x(f72960i);
        a aVar = this.f72962b;
        if (aVar != null) {
            aVar.w8(f72960i, f72961j);
        }
    }

    public void k(String str, String str2) {
        if ("type_name".equals(str)) {
            f72960i = str;
            l(this.f72965e, str2);
        } else if ("type_price".equals(str)) {
            f72960i = str;
            l(this.f72966f, str2);
        } else if ("type_heigh_low".equals(str)) {
            f72960i = str;
            l(this.f72967g, str2);
        } else if ("type_amount".equals(str)) {
            f72960i = str;
            l(this.f72968h, str2);
        } else {
            h();
            i();
            g();
            f72960i = "";
            f72961j = "sort_normal";
        }
        j.n().w(f72961j);
        j.n().x(f72960i);
    }

    public final void l(TextView textView, String str) {
        f72961j = str;
        if ("sort_asc".equals(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_up_light), (Drawable) null);
        } else if ("sort_desc".equals(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_down_light), (Drawable) null);
        } else if ("sort_normal".equals(str)) {
            if ("type_name".equals(f72960i)) {
                h();
            } else if ("type_price".equals(f72960i)) {
                i();
            } else {
                g();
            }
            f72960i = "";
        }
        j.n().w(f72961j);
        j.n().x(f72960i);
    }

    public void m() {
        TextView textView;
        h();
        i();
        g();
        f();
        if ("type_name".equals(f72960i)) {
            textView = this.f72965e;
        } else if ("type_price".equals(f72960i)) {
            textView = this.f72966f;
        } else if ("type_heigh_low".equals(f72960i)) {
            textView = this.f72967g;
        } else {
            textView = "type_amount".equals(f72960i) ? this.f72968h : null;
        }
        if (textView == null) {
            return;
        }
        if ("sort_asc".equals(f72961j)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_up_light), (Drawable) null);
        } else if ("sort_desc".equals(f72961j)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_down_light), (Drawable) null);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.market_sort_name_tv) {
            if ("type_name".equals(f72960i)) {
                b(this.f72965e);
            } else {
                f72960i = "type_name";
                f72961j = "sort_asc";
                this.f72965e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_up_light), (Drawable) null);
            }
            i();
            g();
            f();
            j();
        } else if (id2 == R$id.market_sort_price_tv) {
            if ("type_price".equals(f72960i)) {
                b(this.f72966f);
            } else {
                f72960i = "type_price";
                f72961j = "sort_asc";
                this.f72966f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_up_light), (Drawable) null);
            }
            h();
            g();
            f();
            j();
        } else if (id2 == R$id.market_sort_height_low_tv) {
            if ("type_heigh_low".equals(f72960i)) {
                b(this.f72967g);
            } else {
                f72960i = "type_heigh_low";
                f72961j = "sort_asc";
                this.f72967g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_up_light), (Drawable) null);
            }
            h();
            i();
            f();
            j();
        } else if (id2 == R$id.market_sort_amount) {
            if ("type_amount".equals(f72960i)) {
                b(this.f72968h);
            } else {
                f72960i = "type_amount";
                f72961j = "sort_asc";
                this.f72968h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getContext(), R$drawable.market_selected_up_light), (Drawable) null);
            }
            h();
            i();
            g();
            j();
        } else {
            h();
            i();
            g();
            f();
            f72960i = "";
            f72961j = "sort_normal";
            j.n().w(f72961j);
            j.n().x(f72960i);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setHeiLowMargin(int i11) {
        ((ConstraintLayout.LayoutParams) this.f72967g.getLayoutParams()).setMarginEnd(i11);
    }

    public void setPriceMargin(int i11) {
        ((ConstraintLayout.LayoutParams) this.f72966f.getLayoutParams()).setMarginEnd(i11);
    }

    public void setSrotTypeListener(a aVar) {
        this.f72962b = aVar;
    }

    public MarketSortLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c();
    }
}
