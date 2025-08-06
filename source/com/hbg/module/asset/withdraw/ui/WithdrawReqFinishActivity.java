package com.hbg.module.asset.withdraw.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cc.a;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.IntegrationQuestionInfo;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.withdraw.presenter.WithdrawReqFinishPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dc.b;
import i6.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WithdrawReqFinishActivity extends BaseActivity<WithdrawReqFinishPresenter, WithdrawReqFinishPresenter.b> implements WithdrawReqFinishPresenter.b, a.C0120a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f16941b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16942c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16943d;

    /* renamed from: e  reason: collision with root package name */
    public View f16944e;

    /* renamed from: f  reason: collision with root package name */
    public EasyRecyclerView<a> f16945f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16946g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16947h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16948i;

    /* renamed from: j  reason: collision with root package name */
    public final List<a> f16949j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final Set<Integer> f16950k = new HashSet();

    public static void Og(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (context != null) {
            Intent intent = new Intent(context, WithdrawReqFinishActivity.class);
            intent.putExtra("EXTRA_CURRENCY", str);
            intent.putExtra("EXTRA_AMOUNT", str2);
            intent.putExtra("EXTRA_ADDRESS", str3);
            intent.putExtra("EXTRA_TAG", str6);
            intent.putExtra("EXTRA_RECEIVE_AMOUNT", str4);
            intent.putExtra("EXTRA_CHAIN_DISPLAY_NAME", str5);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gg(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((WithdrawReqFinishPresenter) getPresenter()).S(new ArrayList(this.f16950k));
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void G6(List<IntegrationQuestionInfo> list) {
        d.b("WithdrawInfoConfirmActivity-->updateData-->" + list);
        this.f16949j.clear();
        for (IntegrationQuestionInfo aVar : list) {
            this.f16949j.add(new a(aVar, this));
        }
        this.f16945f.setData(this.f16949j);
        ViewUtil.m(this.viewFinder.b(R$id.id_withdraw_info_confirm_risk_title), !list.isEmpty());
        if (list.isEmpty()) {
            this.f16944e.setEnabled(true);
        }
    }

    public void H7(IntegrationQuestionInfo integrationQuestionInfo, CommonCheckBox commonCheckBox) {
        if (commonCheckBox.isChecked()) {
            this.f16950k.remove(Integer.valueOf(integrationQuestionInfo.getId()));
        } else {
            this.f16950k.add(Integer.valueOf(integrationQuestionInfo.getId()));
        }
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        this.f16944e.setEnabled(!this.f16950k.isEmpty());
    }

    /* renamed from: Zf */
    public WithdrawReqFinishPresenter createPresenter() {
        return new WithdrawReqFinishPresenter();
    }

    public void addEvent() {
        this.f16944e.setOnClickListener(new dc.a(this));
        this.viewFinder.b(R$id.id_withdraw_info_close_btn).setOnClickListener(new b(this));
    }

    public void afterInit() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("EXTRA_CURRENCY");
            intent.getStringExtra("EXTRA_AMOUNT");
            String stringExtra2 = intent.getStringExtra("EXTRA_ADDRESS");
            String stringExtra3 = intent.getStringExtra("EXTRA_TAG");
            String stringExtra4 = intent.getStringExtra("EXTRA_RECEIVE_AMOUNT");
            String stringExtra5 = intent.getStringExtra("EXTRA_CHAIN_DISPLAY_NAME");
            this.f16941b.setText(StringUtils.i(stringExtra));
            this.f16942c.setText(stringExtra4);
            this.f16943d.setText(stringExtra2);
            if (!TextUtils.isEmpty(stringExtra5)) {
                ViewUtil.m(this.f16946g, true);
                this.f16946g.setText(stringExtra5);
            }
            boolean z11 = !TextUtils.isEmpty(stringExtra3);
            ViewUtil.m(this.f16947h, z11);
            ViewUtil.m(this.f16948i, z11);
            this.f16948i.setText(stringExtra3);
        }
    }

    public boolean ce(IntegrationQuestionInfo integrationQuestionInfo) {
        return this.f16950k.contains(Integer.valueOf(integrationQuestionInfo.getId()));
    }

    /* renamed from: fg */
    public WithdrawReqFinishPresenter.b getUI() {
        return this;
    }

    public int getContentView() {
        return R$layout.activity_withdraw_request_finish;
    }

    public void initView() {
        this.f16941b = (TextView) this.viewFinder.b(R$id.id_withdraw_info_confirm_symbol_tv);
        this.f16942c = (TextView) this.viewFinder.b(R$id.id_withdraw_info_confirm_amount_tv);
        this.f16943d = (TextView) this.viewFinder.b(R$id.id_withdraw_info_confirm_address_tv);
        this.f16944e = this.viewFinder.b(R$id.dialog_confirm_btn);
        this.f16945f = (EasyRecyclerView) this.viewFinder.b(R$id.id_withdraw_info_req_list);
        this.f16946g = (TextView) this.viewFinder.b(R$id.tv_chain_tag);
        this.f16947h = (TextView) this.viewFinder.b(R$id.tv_tag_label);
        this.f16948i = (TextView) this.viewFinder.b(R$id.tv_tag_value);
    }

    public void onDestroy() {
        AssetModuleConfig.a().U0(this);
        super.onDestroy();
    }
}
