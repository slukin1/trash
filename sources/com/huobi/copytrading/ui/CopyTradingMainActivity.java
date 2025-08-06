package com.huobi.copytrading.ui;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.n0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.m;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.CoinStringUtil;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.content.custom.widget.TagLayoutWidget;
import com.hbg.module.content.ui.fragment.H5Fragment;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.trade.engine.TradeDataParser;
import com.huobi.view.radiogroup.RadioContainer;
import java.util.ArrayList;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import lj.k;
import lj.s0;
import org.json.JSONObject;
import pro.huobi.R;

@Route(path = "/Contract/CopyTrading")
public final class CopyTradingMainActivity extends BaseActivity<k> {

    /* renamed from: i  reason: collision with root package name */
    public final i f43619i = new n0(Reflection.b(CopyTradingViewModel.class), new CopyTradingMainActivity$special$$inlined$viewModels$default$2(this), new CopyTradingMainActivity$special$$inlined$viewModels$default$1(this), new CopyTradingMainActivity$special$$inlined$viewModels$default$3((d10.a) null, this));

    /* renamed from: j  reason: collision with root package name */
    public String f43620j = "0";

    /* renamed from: k  reason: collision with root package name */
    public String f43621k = "";

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList<Fragment> f43622l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    public boolean f43623m;

    /* renamed from: n  reason: collision with root package name */
    public String f43624n = "";

    /* renamed from: o  reason: collision with root package name */
    public int f43625o;

    public static final class a extends FragmentStateAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CopyTradingMainActivity f43626b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CopyTradingMainActivity copyTradingMainActivity) {
            super((FragmentActivity) copyTradingMainActivity);
            this.f43626b = copyTradingMainActivity;
        }

        public Fragment createFragment(int i11) {
            return (Fragment) this.f43626b.f43622l.get(i11);
        }

        public int getItemCount() {
            return this.f43626b.f43622l.size();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Eh(com.huobi.copytrading.ui.CopyTradingMainActivity r5, com.huobi.view.radiogroup.RadioGroupContainer r6, android.view.View r7, int r8, int r9) {
        /*
            if (r9 != 0) goto L_0x0005
            java.lang.String r6 = "pageview_copytrading"
            goto L_0x0007
        L_0x0005:
            java.lang.String r6 = "pageview_contracts_copytrading"
        L_0x0007:
            r8 = 1
            kotlin.Pair[] r0 = new kotlin.Pair[r8]
            r1 = 0
            if (r9 != 0) goto L_0x0011
            java.lang.String r2 = "copytrading_app_home"
        L_0x000f:
            r3 = r1
            goto L_0x002a
        L_0x0011:
            com.huobi.copytrading.vm.CopyTradingViewModel r2 = r5.Gh()
            boolean r2 = r2.y0()
            if (r2 == 0) goto L_0x0020
            if (r9 != r8) goto L_0x0020
            java.lang.String r2 = "copytrading_app_USDT-M"
            goto L_0x000f
        L_0x0020:
            boolean r2 = r5.f43623m
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = "copytrading_app_trader_me"
            goto L_0x000f
        L_0x0027:
            java.lang.String r2 = "copytrading_app_follower_me"
            r3 = r8
        L_0x002a:
            java.lang.String r4 = "business_category"
            kotlin.Pair r2 = kotlin.l.a(r4, r2)
            r0[r1] = r2
            java.util.HashMap r0 = kotlin.collections.MapsKt__MapsKt.j(r0)
            com.hbg.module.libkt.helper.SensorsDataHelper.track(r6, r0)
            if (r3 == 0) goto L_0x0059
            com.hbg.module.libkt.provider.HbgBaseProvider r6 = r5.fg()
            if (r6 == 0) goto L_0x0048
            boolean r6 = r6.j(r5)
            if (r6 != r8) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r8 = r1
        L_0x0049:
            if (r8 != 0) goto L_0x0059
            x1.a r6 = r5.Yf()
            lj.k r6 = (lj.k) r6
            com.huobi.view.radiogroup.RadioGroupContainer r6 = r6.B
            int r5 = r5.f43625o
            r6.setCheckedPosition(r5)
            return
        L_0x0059:
            boolean r6 = r7 instanceof com.huobi.view.radiogroup.RadioContainer
            if (r6 == 0) goto L_0x007f
            r6 = 2
            float[] r6 = new float[r6]
            r6 = {1065353216, 1063004406} // fill-array
            android.animation.ValueAnimator r6 = android.animation.ValueAnimator.ofFloat(r6)
            com.huobi.copytrading.ui.j r8 = new com.huobi.copytrading.ui.j
            r8.<init>(r7)
            r6.addUpdateListener(r8)
            com.hbg.lib.common.animation.DampingInterpolator r7 = new com.hbg.lib.common.animation.DampingInterpolator
            r7.<init>()
            r6.setInterpolator(r7)
            r7 = 500(0x1f4, double:2.47E-321)
            r6.setDuration(r7)
            r6.start()
        L_0x007f:
            r5.f43625o = r9
            x1.a r6 = r5.Yf()
            lj.k r6 = (lj.k) r6
            androidx.viewpager2.widget.ViewPager2 r6 = r6.F
            r6.setCurrentItem(r9)
            com.huobi.copytrading.vm.CopyTradingViewModel r5 = r5.Gh()
            rj.b r5 = r5.h0()
            java.lang.String r6 = "traderData.start()"
            r5.I(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.copytrading.ui.CopyTradingMainActivity.Eh(com.huobi.copytrading.ui.CopyTradingMainActivity, com.huobi.view.radiogroup.RadioGroupContainer, android.view.View, int, int):void");
    }

    public static final void Fh(View view, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View childAt = ((RadioContainer) view).getChildAt(0);
        childAt.setScaleX(floatValue);
        childAt.setScaleY(floatValue);
        childAt.setPivotX((float) (childAt.getWidth() / 2));
        childAt.setPivotY((float) childAt.getHeight());
        childAt.invalidate();
    }

    public static final void Ih(CopyTradingMainActivity copyTradingMainActivity, Object obj) {
        Object obj2;
        Object obj3;
        if (obj != null) {
            String g11 = m.g(obj);
            if (!x.b(copyTradingMainActivity.f43624n, g11)) {
                copyTradingMainActivity.f43624n = g11;
                JSONObject jSONObject = new JSONObject(g11);
                boolean z11 = false;
                boolean z12 = jSONObject.optInt("isTrader") == 1;
                boolean z13 = jSONObject.optInt("isNative") == 1;
                if (jSONObject.optInt("isNewHome") == 1) {
                    z11 = true;
                }
                boolean optBoolean = jSONObject.optBoolean("resetPage");
                String optString = jSONObject.optString("tabbarIndex");
                if (optBoolean && !b.x(optString)) {
                    copyTradingMainActivity.f43620j = optString;
                }
                if (b.w(copyTradingMainActivity.f43622l) || z12 != copyTradingMainActivity.f43623m) {
                    ek.b.f47515a.i(EdgeEngineScene.COPY_TRADING.getScene());
                    copyTradingMainActivity.f43623m = z12;
                    copyTradingMainActivity.Gh().B0(z12);
                    copyTradingMainActivity.f43622l.clear();
                    ((k) copyTradingMainActivity.Yf()).B.removeAllViews();
                    ArrayList<Fragment> arrayList = copyTradingMainActivity.f43622l;
                    if (z11) {
                        obj2 = CopyTradingNewHomeFragment.f43636h.a();
                    } else {
                        obj2 = CopyTradingHomeFragment.f43606l.a();
                    }
                    arrayList.add(obj2);
                    ((k) copyTradingMainActivity.Yf()).B.addView(copyTradingMainActivity.Ch(1));
                    if (copyTradingMainActivity.Gh().y0()) {
                        copyTradingMainActivity.f43622l.add(CopyTradingTradeFragment.f43647k.a());
                        ((k) copyTradingMainActivity.Yf()).B.addView(copyTradingMainActivity.Ch(2));
                    }
                    ArrayList<Fragment> arrayList2 = copyTradingMainActivity.f43622l;
                    if (z13) {
                        obj3 = CopyTradingMeFragment.f43627j.a();
                    } else {
                        obj3 = H5Fragment.f18742s.a(BaseModuleConfig.a().k(copyTradingMainActivity.Gh().y0() ? "tradingbot/h5/futures/trader/mine" : "tradingbot/h5/futures/orders/mine"), true);
                    }
                    arrayList2.add(obj3);
                    ((k) copyTradingMainActivity.Yf()).B.addView(copyTradingMainActivity.Ch(3));
                    copyTradingMainActivity.Dh();
                }
            }
        }
    }

    public final View Ch(int i11) {
        s0 s0Var = (s0) c.e(getLayoutInflater(), R.layout.temp_copy_trading_tab, (ViewGroup) null, false);
        s0Var.getRoot().setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (i11 == 1) {
            s0Var.B.setButtonDrawable(R.drawable.copytrading_tab_bg_home);
            s0Var.D.setText(R.string.n_copy_trading_new_home);
        } else if (i11 == 2) {
            s0Var.B.setButtonDrawable(R.drawable.copytrading_tab_bg_trade);
            s0Var.D.setText(R.string.n_copy_trading_tape_order);
        } else if (i11 == 3) {
            s0Var.B.setButtonDrawable(R.drawable.copytrading_tab_bg_me);
            s0Var.D.setText(R.string.n_tab_me);
        }
        return s0Var.getRoot();
    }

    public final void Dh() {
        ((k) Yf()).F.setUserInputEnabled(false);
        ((k) Yf()).F.setAdapter(new a(this));
        ((k) Yf()).B.setOnSelelctChangeListner(new k(this));
        Jh();
    }

    public final CopyTradingViewModel Gh() {
        return (CopyTradingViewModel) this.f43619i.getValue();
    }

    /* renamed from: Hh */
    public k Og() {
        return k.K(getLayoutInflater());
    }

    public final void Jh() {
        int i11 = 1;
        if (x.b(this.f43620j, "0")) {
            i11 = 0;
        } else if (x.b(this.f43620j, "2") && this.f43622l.size() == 3) {
            i11 = 2;
        }
        this.f43625o = i11;
        ((k) Yf()).B.setCheckedPosition(this.f43625o);
    }

    public void finish() {
        CoinStringUtil.f68665a = 1;
        super.finish();
    }

    public final void initData() {
        Gh().h0().u("traderData.userInfo", new l(this));
        Gh().h0().I("traderData.start()");
    }

    public void initView() {
        super.initView();
        CoinStringUtil.f68665a = 2;
        Qg(NightHelper.e().g());
        rj.b b11 = ek.b.f47515a.b(this, "copytrading");
        com.huobi.copytrading.engine.a.f43594a.a(b11);
        Gh().q0(b11);
        Gh().t0("copytrading");
        b11.A("TraderListTags", TagLayoutWidget.class);
        b11.z("trade_parser", TradeDataParser.class);
        initData();
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("index");
        if (stringExtra != null) {
            this.f43620j = stringExtra;
        }
        String stringExtra2 = getIntent().getStringExtra("detailId");
        if (stringExtra2 != null) {
            this.f43621k = stringExtra2;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ek.b.f47515a.e(EdgeEngineScene.COPY_TRADING.getScene());
    }

    public void onNewIntent(Intent intent) {
        String stringExtra;
        String stringExtra2;
        super.onNewIntent(intent);
        if (!(intent == null || (stringExtra2 = intent.getStringExtra("index")) == null)) {
            this.f43620j = stringExtra2;
        }
        if (!(intent == null || (stringExtra = intent.getStringExtra("detailId")) == null)) {
            this.f43621k = stringExtra;
        }
        Jh();
    }

    public void onResume() {
        super.onResume();
        CoinStringUtil.f68665a = 2;
        for (Fragment fragment : this.f43622l) {
            if (fragment instanceof CopyBaseFragment) {
                ((CopyBaseFragment) fragment).ph();
            }
        }
    }

    public void onStop() {
        super.onStop();
        for (Fragment fragment : this.f43622l) {
            if (fragment instanceof CopyBaseFragment) {
                ((CopyBaseFragment) fragment).qh();
            }
        }
    }
}
