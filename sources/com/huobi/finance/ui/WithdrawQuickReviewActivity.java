package com.huobi.finance.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.presenter.WithdrawQuickReviewPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.regex.Pattern;
import pro.huobi.R;

public class WithdrawQuickReviewActivity extends BaseActivity<WithdrawQuickReviewPresenter, WithdrawQuickReviewPresenter.b> implements WithdrawQuickReviewPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f47030b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f47031c;

    /* renamed from: d  reason: collision with root package name */
    public Button f47032d;

    /* renamed from: e  reason: collision with root package name */
    public Button f47033e;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gg(View view) {
        String trim = this.f47031c.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            HuobiToastUtil.m(getString(R.string.withdraw_quick_hint));
        }
        if (Pattern.compile("^[0-9a-zA-Z]{5,20}$").matcher(trim).matches()) {
            ((WithdrawQuickReviewPresenter) getPresenter()).R(trim);
        } else {
            HuobiToastUtil.j(R.string.withdraw_id_invalid);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ud() {
        HuobiToastUtil.j(R.string.withdraw_rejected_human_review);
        finish();
    }

    /* renamed from: Zf */
    public WithdrawQuickReviewPresenter createPresenter() {
        return new WithdrawQuickReviewPresenter();
    }

    public void addEvent() {
        this.f47032d.setOnClickListener(new mc(this));
        this.f47033e.setOnClickListener(new nc(this));
    }

    /* renamed from: fg */
    public WithdrawQuickReviewPresenter.b getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_currency_quick_withdraw;
    }

    public void initView() {
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f47030b = toolbar;
        setToolBar(toolbar, getString(R.string.withdraw_quick_title), true);
        this.f47032d = (Button) this.viewFinder.b(R.id.btn_skip);
        this.f47033e = (Button) this.viewFinder.b(R.id.btn_action);
        this.f47031c = (ClearEditText) this.viewFinder.b(R.id.et_quick_id);
    }

    public void w9() {
        HuobiToastUtil.s(R.string.withdraw_submitted);
        finish();
    }
}
