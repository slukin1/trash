package com.huobi.tradenew.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.tradenew.ui.TradeTopTabItemView;
import gj.d;
import pro.huobi.R;
import qt.b0;
import tg.r;

public class TradeTopTabLayout extends ConstraintLayout implements TradeTopTabItemView.a {

    /* renamed from: b  reason: collision with root package name */
    public TradeType f83234b;

    /* renamed from: c  reason: collision with root package name */
    public TradeTopTabItemView.a f83235c;

    /* renamed from: d  reason: collision with root package name */
    public TradeTopTabItemView f83236d;

    /* renamed from: e  reason: collision with root package name */
    public TradeTopTabItemView f83237e;

    /* renamed from: f  reason: collision with root package name */
    public TradeTopTabItemView f83238f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f83239g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f83240h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f83241i;

    /* renamed from: j  reason: collision with root package name */
    public ObjectAnimator f83242j;

    /* renamed from: k  reason: collision with root package name */
    public ObjectAnimator f83243k;

    /* renamed from: l  reason: collision with root package name */
    public ObjectAnimator f83244l;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b0.d().i(false);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b0.d().k(false);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b0.d().j(false);
        }
    }

    public TradeTopTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(TradeType tradeType) {
        TradeTopTabItemView.a aVar = this.f83235c;
        if (aVar != null && this.f83234b != tradeType) {
            aVar.a(tradeType);
        }
    }

    public final ObjectAnimator h(View view) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f})});
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(200);
        return ofPropertyValuesHolder;
    }

    public final void i(TradeTopTabItemView tradeTopTabItemView, TradeType tradeType, String str) {
        tradeTopTabItemView.setText(str);
        tradeTopTabItemView.setTradeType(tradeType);
        tradeTopTabItemView.setCallback(this);
        tradeTopTabItemView.setChecked(tradeType == this.f83234b);
    }

    public final void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_trade_top_tab, this, true);
        this.f83236d = (TradeTopTabItemView) inflate.findViewById(R.id.exchange_view);
        this.f83237e = (TradeTopTabItemView) inflate.findViewById(R.id.margin_view);
        this.f83238f = (TradeTopTabItemView) inflate.findViewById(R.id.fiat_view);
        this.f83239g = (TextView) inflate.findViewById(R.id.exchange_view_hot_tv);
        this.f83240h = (TextView) inflate.findViewById(R.id.margin_view_hot_tv);
        this.f83241i = (TextView) inflate.findViewById(R.id.fiat_view_hot_tv);
        Resources resources = getResources();
        i(this.f83236d, TradeType.PRO, resources.getString(R.string.n_spot));
        if (!r.x().T() && (com.hbg.lib.core.util.b.c().a() == 2 || com.hbg.lib.core.util.b.c().a() == 3)) {
            com.hbg.lib.core.util.b.c().g(1);
        }
        int a11 = com.hbg.lib.core.util.b.c().a();
        if (a11 == 0) {
            i(this.f83237e, TradeType.MARGIN, resources.getString(R.string.trade_margin_title));
        } else if (a11 == 1) {
            i(this.f83237e, TradeType.SUPERMARGIN, resources.getString(R.string.super_margin_title));
        } else if (a11 == 2) {
            i(this.f83237e, TradeType.C2C, resources.getString(R.string.string_c2c_margin));
        } else if (a11 != 3) {
            i(this.f83237e, TradeType.SUPERMARGIN, resources.getString(R.string.super_margin_title));
        } else {
            i(this.f83237e, TradeType.C2C_LEND, resources.getString(R.string.c_to_c_balance_borrow));
        }
        i(this.f83238f, TradeType.OTC, resources.getString(R.string.legal_toolbar_header_title));
        ObjectAnimator h11 = h(this.f83239g);
        this.f83242j = h11;
        h11.addListener(new a());
        ObjectAnimator h12 = h(this.f83240h);
        this.f83243k = h12;
        h12.addListener(new b());
        ObjectAnimator h13 = h(this.f83241i);
        this.f83244l = h13;
        h13.addListener(new c());
        if (!d.n().G()) {
            this.f83237e.setVisibility(8);
        }
    }

    public final void j() {
        TradeTopTabItemView tradeTopTabItemView = this.f83236d;
        boolean z11 = false;
        tradeTopTabItemView.setChecked(tradeTopTabItemView.getTradeType() == this.f83234b);
        TradeType tradeType = this.f83234b;
        if (tradeType == TradeType.MARGIN) {
            this.f83237e.setTradeType(tradeType);
            this.f83237e.setText(R.string.trade_margin_title);
            this.f83237e.setChecked(true);
        } else if (tradeType == TradeType.SUPERMARGIN) {
            this.f83237e.setTradeType(tradeType);
            this.f83237e.setText(R.string.super_margin_title);
            this.f83237e.setChecked(true);
        } else if (tradeType == TradeType.C2C) {
            this.f83237e.setTradeType(tradeType);
            this.f83237e.setText(R.string.string_c2c_margin);
            this.f83237e.setChecked(true);
        } else if (tradeType == TradeType.C2C_LEND) {
            this.f83237e.setTradeType(tradeType);
            this.f83237e.setText(R.string.c_to_c_balance_borrow);
            this.f83237e.setChecked(true);
        }
        TradeTopTabItemView tradeTopTabItemView2 = this.f83238f;
        if (tradeTopTabItemView2.getTradeType() == this.f83234b) {
            z11 = true;
        }
        tradeTopTabItemView2.setChecked(z11);
    }

    public void setCallback(TradeTopTabItemView.a aVar) {
        this.f83235c = aVar;
    }

    public void setSelectedType(TradeType tradeType) {
        this.f83234b = tradeType;
        j();
    }

    public TradeTopTabLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f83234b = TradeType.PRO;
        init();
    }
}
