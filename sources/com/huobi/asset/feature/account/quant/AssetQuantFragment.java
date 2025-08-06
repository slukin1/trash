package com.huobi.asset.feature.account.quant;

import al.i;
import al.p;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.base.BaseAssetFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.account.GridAssetAccount;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.GridDataTotal;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hh.f;
import java.util.ArrayList;
import java.util.Locale;
import nh.b;
import nh.c;
import nh.d;
import nh.e;
import uh.a;

public class AssetQuantFragment extends BaseAssetFragment {

    /* renamed from: n  reason: collision with root package name */
    public final GridAssetAccount f42288n = new GridAssetAccount();

    /* renamed from: o  reason: collision with root package name */
    public final HeadViewData f42289o = new HeadViewData();

    /* renamed from: p  reason: collision with root package name */
    public GridDataTotal f42290p;

    /* renamed from: q  reason: collision with root package name */
    public AssetHeadView<HeadViewData> f42291q;

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return "";
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Sh(View view) {
        this.f42288n.m();
        Jh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Th() {
        zh().showProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(BaseAssetTotal baseAssetTotal) {
        this.f42290p = (GridDataTotal) baseAssetTotal;
        this.f42289o.f(true);
        bi(this.f42290p);
        this.f42288n.b(this.f42290p);
        Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(APIStatusErrorException aPIStatusErrorException) {
        Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(Throwable th2) {
        Kh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xh() {
        zh().dismissProgressDialog();
    }

    public int Fh() {
        return 0;
    }

    public String Gh() {
        return "app_assets_quant_account_view";
    }

    public void Ih(boolean z11) {
        this.f42289o.f(false);
        bi(this.f42290p);
        this.f42288n.a();
    }

    public void Jh() {
        f.a<?> g11 = f.h().g(AssetAccountType.QUANT);
        if (g11 != null) {
            g11.b().compose(RxJavaHelper.t(zh())).subscribe(EasySubscriber.create(new c(this), new e(this), new d(this), new nh.f(this), new b(this)));
        }
    }

    public final AssetHeadView<HeadViewData> Rh() {
        if (this.f42291q == null) {
            this.f42291q = new AssetHeadView<>(getContext());
        }
        return this.f42291q;
    }

    public final String Yh(String str) {
        return str.replaceAll("BTC", LegalCurrencyConfigUtil.y().toUpperCase(Locale.US));
    }

    public final void Zh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.h(getActivity(), (String) null));
        Rh().i(arrayList);
    }

    public final void ai(GridDataTotal gridDataTotal) {
        if (gridDataTotal == null) {
            Rh().f42426k.setText(Rh().f42417b);
            Rh().f42427l.setText(Rh().f42417b);
        } else if (!p.u()) {
            Rh().f42426k.setText(Rh().f42418c);
            Rh().f42427l.setText(Rh().f42418c);
        } else {
            a.a(Rh().f42426k, LegalCurrencyConfigUtil.D(p.j(gridDataTotal.getTotalEstimateBtc(), "btc"), "btcusdt", TradeType.PRO));
        }
    }

    public final void bi(GridDataTotal gridDataTotal) {
        this.f42289o.e(gridDataTotal);
        Rh().k(this.f42289o);
        Rh().f42421f.setText(Yh(getString(R$string.n_balance_quant_amount)));
        ai(gridDataTotal);
    }

    public View getContentView() {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        Rh().setDistributionType("15");
        Rh().k(this.f42289o);
        Rh().f42421f.setText(Yh(getString(R$string.n_balance_quant_amount)));
        Zh();
        linearLayout.addView(Rh());
        linearLayout.addView(this.f42288n.d(getActivity(), (ViewGroup) null, new nh.a(this)), new LinearLayout.LayoutParams(-1, -1));
        return linearLayout;
    }

    public void initViews() {
        super.initViews();
        Jh();
    }
}
