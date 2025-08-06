package com.huobi.feature.ui;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractPositionLimit;
import com.huobi.utils.d1;
import com.huobi.webview2.ui.ContractWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import pk.h;
import pk.i;
import pro.huobi.R;

public class ContractUpPositionLimitActivity extends EmptyMVPActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f44692b;

    /* renamed from: c  reason: collision with root package name */
    public CommonTextListIndicator f44693c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f44694d;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager2 f44695e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44696f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44697g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44698h;

    /* renamed from: i  reason: collision with root package name */
    public i f44699i;

    public class a implements CommonTextListIndicator.b {
        public a() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            ContractUpPositionLimitActivity.this.f44695e.setCurrentItem(i11);
        }
    }

    public class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        public void onPageScrollStateChanged(int i11) {
            ContractUpPositionLimitActivity.this.f44693c.a(i11);
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            ContractUpPositionLimitActivity.this.f44693c.b(i11, f11, i12);
        }

        public void onPageSelected(int i11) {
            ContractUpPositionLimitActivity.this.f44693c.c(i11);
        }
    }

    public class c extends EasySubscriber<ContractPositionLimit> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(ContractPositionLimit contractPositionLimit) {
            super.onNext(contractPositionLimit);
            ContractUpPositionLimitActivity.this.f44694d.setEnabled(contractPositionLimit.getAdjustStatus() == 1);
            TextView Og = ContractUpPositionLimitActivity.this.f44697g;
            String string = ContractUpPositionLimitActivity.this.getString(R.string.n_contract_position_limit_rule_4);
            Object[] objArr = new Object[1];
            objArr[0] = contractPositionLimit.getAssetDeposit() != null ? contractPositionLimit.getAssetDeposit() : "";
            Og.setText(String.format(string, objArr));
            ContractUpPositionLimitActivity.this.f44699i.f(contractPositionLimit.getAdjustableList(), contractPositionLimit.getAdjustedList());
            ContractUpPositionLimitActivity.this.f44692b.g();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ContractUpPositionLimitActivity.this.f44692b.k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ContractUpPositionLimitActivity.this.f44692b.k();
        }
    }

    public class d extends EasySubscriber<Void> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(Void voidR) {
            super.onNext(voidR);
            HuobiToastUtil.m(ContractUpPositionLimitActivity.this.getResources().getString(R.string.n_contract_position_limit_improved));
            ContractUpPositionLimitActivity.this.finish();
        }

        public void onAfter() {
            super.onAfter();
            ContractUpPositionLimitActivity.this.dismissProgressDialog();
        }

        public void onStart() {
            super.onStart();
            ContractUpPositionLimitActivity.this.showProgressDialog((String) null);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        oh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Qg() {
        h8.a.a().adjustPositionLimit().b().compose(RxJavaHelper.t(getUI())).subscribe(new d());
    }

    public void addEvent() {
        this.f44698h.setOnClickListener(this);
        this.f44696f.setOnClickListener(this);
        this.f44694d.setOnClickListener(this);
        i iVar = new i(this);
        this.f44699i = iVar;
        this.f44695e.setAdapter(iVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R.string.n_contract_position_limit_tab_adjustable));
        arrayList.add(getResources().getString(R.string.n_contract_position_limit_tab_adjusted));
        this.f44693c.setCapitalTitle(false);
        this.f44693c.setDataList(arrayList);
        this.f44693c.setCallback(new a());
        this.f44695e.registerOnPageChangeCallback(new b());
        this.f44692b.setOnRetryClickListener(new h(this));
        oh();
    }

    public int getContentView() {
        return R.layout.activity_contract_up_position_limit;
    }

    public void initView() {
        this.f44692b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f44696f = (TextView) this.viewFinder.b(R.id.tv_browse_position_amount);
        this.f44697g = (TextView) this.viewFinder.b(R.id.tv_asset_deposit);
        this.f44698h = (TextView) this.viewFinder.b(R.id.tv_support_amount_list);
        this.f44695e = (ViewPager2) this.viewFinder.b(R.id.vpRoot);
        this.f44693c = (CommonTextListIndicator) this.viewFinder.b(R.id.common_text_list_indicator);
        this.f44694d = (TextView) this.viewFinder.b(R.id.tv_up);
    }

    public final void oh() {
        this.f44692b.p();
        h8.a.a().getUserPositionLimitList().b().compose(RxJavaHelper.t(getUI())).subscribe(new c());
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view == this.f44696f) {
            ContractWebActivity.bi(this);
        } else if (view == this.f44698h) {
            HBBaseWebActivity.showWebView(this, d1.q(), "", "", false);
        } else if (view == this.f44694d) {
            Qg();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
