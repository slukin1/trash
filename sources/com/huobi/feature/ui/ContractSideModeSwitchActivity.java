package com.huobi.feature.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.feature.ui.ContractSideModeSwitchActivityPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.HashMap;
import pk.e;
import pro.huobi.R;

public class ContractSideModeSwitchActivity extends BaseActivity<ContractSideModeSwitchActivityPresenter, ContractSideModeSwitchActivityPresenter.d> implements ContractSideModeSwitchActivityPresenter.d, View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public static String f44676h = "key_isquan";

    /* renamed from: i  reason: collision with root package name */
    public static String f44677i = "key_margin_account";

    /* renamed from: b  reason: collision with root package name */
    public ImageView f44678b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f44679c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44680d;

    /* renamed from: e  reason: collision with root package name */
    public String f44681e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44682f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44683g;

    public static void fg(Activity activity, boolean z11, String str) {
        Intent intent = new Intent(activity, ContractSideModeSwitchActivity.class);
        intent.putExtra(f44676h, z11);
        intent.putExtra(f44677i, str);
        activity.startActivity(intent);
    }

    public void E9(Throwable th2) {
        dismissProgressDialog();
        String errMsg = th2 instanceof APIStatusErrorException ? ((APIStatusErrorException) th2).getErrMsg() : null;
        if (!TextUtils.isEmpty(errMsg)) {
            HuobiToastUtil.m(errMsg);
        }
    }

    public final void Xf(boolean z11) {
        if (z11) {
            this.f44678b.setImageResource(R.drawable.icon_contract_side_mode_switch_select);
            this.f44679c.setImageResource(R.drawable.icon_contract_side_mode_switch_unselect);
        } else {
            this.f44678b.setImageResource(R.drawable.icon_contract_side_mode_switch_unselect);
            this.f44679c.setImageResource(R.drawable.icon_contract_side_mode_switch_select);
        }
        this.viewFinder.b(R.id.rl_single_pattern_container).setSelected(z11);
        this.viewFinder.b(R.id.rl_both_pattern_container).setSelected(!z11);
    }

    /* renamed from: Yf */
    public ContractSideModeSwitchActivityPresenter createPresenter() {
        return new ContractSideModeSwitchActivityPresenter();
    }

    /* renamed from: Zf */
    public ContractSideModeSwitchActivityPresenter.d getUI() {
        return this;
    }

    public void addEvent() {
    }

    public void dc(boolean z11) {
        this.f44683g = z11;
        dismissProgressDialog();
        Xf(z11);
        HuobiToastUtil.v(getResources().getString(R.string.n_contract_side_mode_switch_side_mode_success));
        if (z11) {
            g.j("usdt_contract", (String) null, "single", (HashMap) null);
        } else {
            g.j("usdt_contract", (String) null, "double", (HashMap) null);
        }
        finish();
    }

    public void dismissLoading() {
        dismissProgressDialog();
    }

    public void finish() {
        if (this.f44683g != this.f44682f) {
            if (SPUtil.j()) {
                e.a().e(this.f44683g);
            } else {
                e.a().d(this.f44680d, this.f44681e, this.f44683g);
            }
        }
        super.finish();
    }

    public int getContentView() {
        return R.layout.activity_contract_side_mode_switch;
    }

    public void initView() {
        this.viewFinder.b(R.id.rl_single_pattern_container).setOnClickListener(this);
        this.viewFinder.b(R.id.rl_both_pattern_container).setOnClickListener(this);
        this.f44678b = (ImageView) this.viewFinder.b(R.id.iv_single_pattern_select);
        this.f44679c = (ImageView) this.viewFinder.b(R.id.iv_both_pattern_select);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 != R.id.rl_both_pattern_container) {
            if (id2 == R.id.rl_single_pattern_container && !this.f44683g) {
                ((ContractSideModeSwitchActivityPresenter) getPresenter()).R(this.f44680d, this.f44681e, true);
            }
        } else if (this.f44683g) {
            ((ContractSideModeSwitchActivityPresenter) getPresenter()).R(this.f44680d, this.f44681e, false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        boolean z11;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f44680d = intent.getBooleanExtra(f44676h, false);
            this.f44681e = intent.getStringExtra(f44677i);
        }
        if (SPUtil.j()) {
            z11 = e.a().c();
        } else {
            z11 = e.a().b(this.f44680d, this.f44681e);
        }
        this.f44682f = z11;
        this.f44683g = z11;
        Xf(z11);
    }

    public void showLoading() {
        showProgressDialog();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
