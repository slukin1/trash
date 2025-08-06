package com.huobi.trade.prime.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.network.hbg.prime.PrimeResult;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.trade.prime.dialog.PrimeLuckyDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ft.b;
import ft.d;
import ht.o;
import it.j;
import java.util.List;
import pro.huobi.R;
import s9.a;
import tg.r;

public class PrimeLiteLayout extends PrimeLayout implements BaseDialogFragment.c {
    public LoadingView M;
    public final PrimeLuckyDialog N = new PrimeLuckyDialog();
    public boolean O;

    public PrimeLiteLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Z(View view) {
        a0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean G(ViewGroup viewGroup, PrimeInfo primeInfo, String str, String str2, String str3, boolean z11) {
        Y();
        return super.G(viewGroup, primeInfo, str, str2, str3, z11);
    }

    public void L(EasyRecyclerView<a> easyRecyclerView, List<a> list, List<PrimeRounds> list2) {
        ViewUtil.m(findViewById(R.id.id_prime_list_layout), true);
    }

    public void M(String str) {
        this.f82241n.setText(getResources().getString(R.string.prime_my_order_id));
    }

    public void P() {
        ViewUtil.m(findViewById(R.id.id_prime_tips_layout_waiting), false);
        ViewUtil.m(findViewById(R.id.id_prime_tips_layout_order_finish), false);
        ViewUtil.m(findViewById(R.id.id_prime_tips_layout_normal), false);
    }

    public void T(ViewGroup viewGroup, PrimeResult primeResult) {
        String str;
        this.f82230c = viewGroup;
        this.f82253z.clear();
        if (primeResult == null || TextUtils.isEmpty(primeResult.getOrderId())) {
            this.f82253z.add(new b(getResources().getString(R.string.prime_order_id_status_cancel_unorder)));
        } else {
            String orderId = primeResult.getOrderId();
            if (!o.B().a0()) {
                str = getResources().getString(R.string.prime_trade_order_status_trading);
            } else if (TextUtils.isEmpty(primeResult.getQuotaAmount())) {
                str = getResources().getString(R.string.prime_trade_order_status_ordering);
            } else {
                str = primeResult.getQuotaAmount() + " " + getBaseCurrencyUpper();
            }
            this.f82253z.add(new d(orderId, str, primeResult.isFinished()));
        }
        this.f82231d.setData(this.f82253z);
        if (primeResult != null && primeResult.isFinished()) {
            if (primeResult.isLucky()) {
                String str2 = "SP_KEY_LUCKY_SHOWN_" + r.x().J() + "_" + this.F.getSymbolCode();
                if (!SP.l(str2, false)) {
                    SP.y(str2, true);
                    a0();
                    return;
                }
                b0();
                return;
            }
            Y();
        }
    }

    public void Y() {
        this.O = false;
        c0();
    }

    public final void a0() {
        PrimeResult J = o.B().J();
        FragmentManager supportFragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
        PrimeLuckyDialog primeLuckyDialog = this.N;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(J != null ? J.getQuotaAmount() : "--");
        sb2.append(" ");
        sb2.append(getBaseCurrencyUpper());
        primeLuckyDialog.zh(sb2.toString());
        this.N.setDialogFragmentListener(this);
        this.N.show(supportFragmentManager, "mPrimeLuckyDialog");
    }

    public final void b0() {
        this.O = true;
        c0();
    }

    public final void c0() {
        LoadingView loadingView;
        if (this.O) {
            if (this.K) {
                if (this.M == null) {
                    this.M = new LoadingView(getContext());
                    CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.dimen_60), getResources().getDimensionPixelOffset(R.dimen.dimen_60));
                    layoutParams.f8114c = BadgeDrawable.BOTTOM_END;
                    layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.dimen_15);
                    layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.dimen_15);
                    this.M.setLayoutParams(layoutParams);
                    this.M.setLottieAnimationRes(R.raw.flot_koi_button);
                    this.M.setOnClickListener(new j(this));
                }
                ViewGroup viewGroup = this.f82230c;
                if (viewGroup != null) {
                    try {
                        viewGroup.addView(this.M);
                        this.M.c();
                    } catch (Exception unused) {
                    }
                }
            }
        } else if (this.f82230c != null && (loadingView = this.M) != null) {
            loadingView.d();
            this.f82230c.removeView(this.M);
        }
    }

    public int getAmountColorRes() {
        return R.color.baseColorMajorTheme100;
    }

    public int getContentViewId() {
        return R.layout.prime_lite_cover_layout;
    }

    public int getFirstColor() {
        return getResources().getColor(R.color.baseColorPrimaryText);
    }

    public int getLogoImgResId() {
        return R.drawable.primelite;
    }

    public int getRefreshJsonId() {
        return R.raw.prime_lite_refresh_3x;
    }

    public int getRoundDescTvColorResId() {
        return R.color.prime_lite;
    }

    public int getSecondColor() {
        return getResources().getColor(R.color.prime_lite);
    }

    public boolean l() {
        return true;
    }

    public void onDialogFragmentBackPressed() {
    }

    public void onDialogFragmentPause() {
        b0();
    }

    public void onDialogFragmentResume() {
        Y();
    }

    public void p(ViewGroup viewGroup) {
        super.p(viewGroup);
        Y();
    }

    public boolean u() {
        return true;
    }

    public PrimeLiteLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrimeLiteLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
