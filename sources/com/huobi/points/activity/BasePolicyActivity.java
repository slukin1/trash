package com.huobi.points.activity;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.points.presenter.BasePolicyPresenter;
import com.huobi.view.CommonTipsLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import pro.huobi.R;
import s9.a;

public abstract class BasePolicyActivity extends BaseActivity<BasePolicyPresenter, BasePolicyPresenter.a> implements BasePolicyPresenter.a, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public CommonTipsLayout f80337b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80338c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80339d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80340e;

    /* renamed from: f  reason: collision with root package name */
    public CommonCheckBox f80341f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f80342g;

    /* renamed from: h  reason: collision with root package name */
    public EasyRecyclerView f80343h;

    public abstract void Og();

    public abstract void Pg();

    /* renamed from: Xf */
    public BasePolicyPresenter createPresenter() {
        return new BasePolicyPresenter();
    }

    public abstract List<a> Yf();

    public abstract String Zf();

    public void addEvent() {
        this.f80339d.setOnClickListener(this);
        this.f80340e.setOnClickListener(this);
        this.viewFinder.b(R.id.id_transfer_to_me_bottom_checkbox_layout).setOnClickListener(this);
    }

    public abstract String fg();

    public int getContentView() {
        return R.layout.activity_points_transfer_policy;
    }

    /* renamed from: gg */
    public BasePolicyPresenter.a getUI() {
        return this;
    }

    public void initView() {
        this.f80342g = (TextView) this.viewFinder.b(R.id.id_transfer_policy_bottom_btn_right);
        this.f80341f = (CommonCheckBox) this.viewFinder.b(R.id.id_transfer_to_me_bottom_checkbox);
        this.f80343h = (EasyRecyclerView) this.viewFinder.b(R.id.id_transfer_policy_recyclerView);
        this.f80338c = (TextView) this.viewFinder.b(R.id.id_transfer_policy_rule_tv);
        this.f80339d = (TextView) this.viewFinder.b(R.id.id_transfer_policy_bottom_btn_left);
        this.f80340e = (TextView) this.viewFinder.b(R.id.id_transfer_policy_bottom_btn_right);
        this.f80337b = (CommonTipsLayout) this.viewFinder.b(R.id.id_common_tips_layout);
        this.f80338c.setText(Zf());
        this.f80343h.setData(Yf());
        this.f80337b.setTitle((CharSequence) fg());
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_transfer_policy_bottom_btn_left:
                Og();
                break;
            case R.id.id_transfer_policy_bottom_btn_right:
                Pg();
                break;
            case R.id.id_transfer_to_me_bottom_checkbox_layout:
                CommonCheckBox commonCheckBox = this.f80341f;
                commonCheckBox.setChecked(!commonCheckBox.isChecked());
                this.f80342g.setEnabled(this.f80341f.isChecked());
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void q5() {
    }
}
