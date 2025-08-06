package com.huobi.trade.ui;

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
import com.huobi.trade.helper.c0;
import com.huobi.trade.ui.TradeTopTabItemView;
import gj.d;
import pro.huobi.R;
import tg.r;

public class TradeTopTabLayout extends ConstraintLayout implements TradeTopTabItemView.a {

    /* renamed from: b  reason: collision with root package name */
    public TradeType f82478b;

    /* renamed from: c  reason: collision with root package name */
    public TradeTopTabItemView.a f82479c;

    /* renamed from: d  reason: collision with root package name */
    public TradeTopTabItemView f82480d;

    /* renamed from: e  reason: collision with root package name */
    public TradeTopTabItemView f82481e;

    /* renamed from: f  reason: collision with root package name */
    public TradeTopTabItemView f82482f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82483g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f82484h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f82485i;

    /* renamed from: j  reason: collision with root package name */
    public ObjectAnimator f82486j;

    /* renamed from: k  reason: collision with root package name */
    public ObjectAnimator f82487k;

    /* renamed from: l  reason: collision with root package name */
    public ObjectAnimator f82488l;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c0.d().i(false);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c0.d().k(false);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c0.d().j(false);
        }
    }

    public TradeTopTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(TradeType tradeType) {
        TradeTopTabItemView.a aVar = this.f82479c;
        if (aVar != null && this.f82478b != tradeType) {
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
        tradeTopTabItemView.setChecked(tradeType == this.f82478b);
    }

    public final void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_trade_top_tab, this, true);
        this.f82480d = (TradeTopTabItemView) inflate.findViewById(R.id.exchange_view);
        this.f82481e = (TradeTopTabItemView) inflate.findViewById(R.id.margin_view);
        this.f82482f = (TradeTopTabItemView) inflate.findViewById(R.id.fiat_view);
        this.f82483g = (TextView) inflate.findViewById(R.id.exchange_view_hot_tv);
        this.f82484h = (TextView) inflate.findViewById(R.id.margin_view_hot_tv);
        this.f82485i = (TextView) inflate.findViewById(R.id.fiat_view_hot_tv);
        Resources resources = getResources();
        i(this.f82480d, TradeType.PRO, resources.getString(R.string.n_spot));
        if (!r.x().T() && (com.hbg.lib.core.util.b.c().a() == 2 || com.hbg.lib.core.util.b.c().a() == 3)) {
            com.hbg.lib.core.util.b.c().g(1);
        }
        int a11 = com.hbg.lib.core.util.b.c().a();
        if (a11 == 0) {
            i(this.f82481e, TradeType.MARGIN, resources.getString(R.string.trade_margin_title));
        } else if (a11 == 1) {
            i(this.f82481e, TradeType.SUPERMARGIN, resources.getString(R.string.super_margin_title));
        } else if (a11 == 2) {
            i(this.f82481e, TradeType.C2C, resources.getString(R.string.string_c2c_margin));
        } else if (a11 != 3) {
            i(this.f82481e, TradeType.SUPERMARGIN, resources.getString(R.string.super_margin_title));
        } else {
            i(this.f82481e, TradeType.C2C_LEND, resources.getString(R.string.c_to_c_balance_borrow));
        }
        i(this.f82482f, TradeType.OTC, resources.getString(R.string.legal_toolbar_header_title));
        ObjectAnimator h11 = h(this.f82483g);
        this.f82486j = h11;
        h11.addListener(new a());
        ObjectAnimator h12 = h(this.f82484h);
        this.f82487k = h12;
        h12.addListener(new b());
        ObjectAnimator h13 = h(this.f82485i);
        this.f82488l = h13;
        h13.addListener(new c());
        if (!d.n().G()) {
            this.f82481e.setVisibility(8);
        }
    }

    public final void j() {
        TradeTopTabItemView tradeTopTabItemView = this.f82480d;
        boolean z11 = false;
        tradeTopTabItemView.setChecked(tradeTopTabItemView.getTradeType() == this.f82478b);
        TradeType tradeType = this.f82478b;
        if (tradeType == TradeType.MARGIN) {
            this.f82481e.setTradeType(tradeType);
            this.f82481e.setText(R.string.trade_margin_title);
            this.f82481e.setChecked(true);
        } else if (tradeType == TradeType.SUPERMARGIN) {
            this.f82481e.setTradeType(tradeType);
            this.f82481e.setText(R.string.super_margin_title);
            this.f82481e.setChecked(true);
        } else if (tradeType == TradeType.C2C) {
            this.f82481e.setTradeType(tradeType);
            this.f82481e.setText(R.string.string_c2c_margin);
            this.f82481e.setChecked(true);
        } else if (tradeType == TradeType.C2C_LEND) {
            this.f82481e.setTradeType(tradeType);
            this.f82481e.setText(R.string.c_to_c_balance_borrow);
            this.f82481e.setChecked(true);
        }
        TradeTopTabItemView tradeTopTabItemView2 = this.f82482f;
        if (tradeTopTabItemView2.getTradeType() == this.f82478b) {
            z11 = true;
        }
        tradeTopTabItemView2.setChecked(z11);
    }

    public void setCallback(TradeTopTabItemView.a aVar) {
        this.f82479c = aVar;
    }

    public void setSelectedType(TradeType tradeType) {
        this.f82478b = tradeType;
        j();
    }

    public TradeTopTabLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f82478b = TradeType.PRO;
        init();
    }
}
