package com.huobi.homemarket.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.homemarket.bean.OneKeyCollectItem;
import com.huobi.view.roundview.RoundRelativeLayout;
import ea.a;
import i6.d;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import tl.h0;
import vl.o;
import vl.p;

public class OneKeyCollectView extends LinearLayout implements h0.b {

    /* renamed from: b  reason: collision with root package name */
    public final h0 f73100b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<OneKeyCollectItem> f73101c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f73102d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f73103e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f73104f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f73105g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f73106h;

    public OneKeyCollectView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Void voidR) {
        this.f73100b.l();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(View view, Void voidR) {
        d.c("OneKeyCollectView", "add Other !");
        View.OnClickListener onClickListener = this.f73102d;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void G(List<OneKeyCollectItem> list) {
        if (list != null && !list.isEmpty()) {
            d.c("OneKeyCollectView", "updateList " + list.toString());
            this.f73101c.setData(list);
        }
    }

    public void a(boolean z11) {
        if (!z11) {
            this.f73104f.setClickable(false);
            this.f73104f.setFillBackgroundColor(getResources().getColor(R$color.home_rank_add_to_favorite_bg_gray_color));
            return;
        }
        this.f73104f.setClickable(true);
        this.f73104f.setFillBackgroundColor(getResources().getColor(R$color.community_label_background));
    }

    public void b() {
        HuobiToastUtil.s(R$string.market_add_collection_success);
        View.OnClickListener onClickListener = this.f73103e;
        if (onClickListener != null) {
            onClickListener.onClick((View) null);
        }
    }

    public void e(boolean z11) {
        this.f73100b.m(z11);
    }

    public final void f() {
        EasyRecyclerView<OneKeyCollectItem> easyRecyclerView = (EasyRecyclerView) findViewById(R$id.rcv);
        this.f73101c = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.f73101c.addItemDecoration(new a(getContext(), PixelUtils.a(15.0f)));
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R$id.btn_add);
        this.f73104f = roundRelativeLayout;
        Observable<Void> a11 = dw.a.a(roundRelativeLayout);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new o(this));
        View findViewById = findViewById(R$id.tv_add_later);
        dw.a.a(findViewById).throttleFirst(300, timeUnit).subscribe(new p(this, findViewById));
    }

    public void finish() {
        this.f73100b.B();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public BaseActivity<?, ?> getBaseActivity() {
        return (BaseActivity) getContext();
    }

    public void i() {
        this.f73100b.v();
    }

    public void j(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f73103e = onClickListener;
        this.f73102d = onClickListener2;
    }

    public void setHasData(boolean z11) {
        this.f73105g = z11;
        if (z11 && this.f73106h) {
            setVisibility(0);
        }
    }

    public void setVisibility(int i11) {
        boolean z11 = true;
        if (i11 == 0) {
            this.f73106h = true;
            if (!this.f73105g) {
                i11 = 8;
            }
        } else {
            this.f73106h = false;
        }
        super.setVisibility(i11);
        if (i11 != 0) {
            z11 = false;
        }
        e(z11);
    }

    public OneKeyCollectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OneKeyCollectView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f73105g = false;
        this.f73106h = true;
        h0 h0Var = new h0(this);
        this.f73100b = h0Var;
        LayoutInflater.from(context).inflate(R$layout.layout_market_onkey_collect, this);
        setVisibility(8);
        this.f73106h = true;
        f();
        h0Var.x();
    }
}
