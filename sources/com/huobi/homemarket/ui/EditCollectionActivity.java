package com.huobi.homemarket.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.homemarket.presenter.EditCollectionPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import ul.b;
import ul.c;
import ul.d;
import ul.e;

public class EditCollectionActivity extends BaseActivity<EditCollectionPresenter, EditCollectionPresenter.f> implements EditCollectionPresenter.f {

    /* renamed from: b  reason: collision with root package name */
    public TextView f72857b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f72858c;

    /* renamed from: d  reason: collision with root package name */
    public CommonCheckBox f72859d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f72860e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f72861f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72862g;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((EditCollectionPresenter) EditCollectionActivity.this.getPresenter()).p0();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((EditCollectionPresenter) getPresenter()).q0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        CommonCheckBox commonCheckBox = this.f72859d;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        if (!this.f72862g) {
            ((EditCollectionPresenter) getPresenter()).Z(this.f72859d.isChecked());
        } else {
            this.f72862g = false;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void oh(View view) {
        rh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((EditCollectionPresenter) getPresenter()).c0();
    }

    public void H4(boolean z11) {
        this.f72862g = true;
        if (z11 == this.f72859d.isChecked()) {
            this.f72862g = false;
        }
        this.f72859d.setChecked(z11);
    }

    /* renamed from: Pg */
    public EditCollectionPresenter createPresenter() {
        return new EditCollectionPresenter();
    }

    /* renamed from: Qg */
    public EditCollectionPresenter.f getUI() {
        return this;
    }

    public RecyclerView Y0() {
        return this.f72860e;
    }

    public void Y5(boolean z11) {
        if (z11) {
            this.f72861f.setEnabled(true);
        } else {
            this.f72861f.setEnabled(false);
        }
    }

    public void addEvent() {
        this.viewFinder.b(R$id.market_coll_add_tv).setOnClickListener(new a());
        this.f72857b.setOnClickListener(new b(this));
        this.f72861f.setOnClickListener(new c(this));
        ul.a aVar = new ul.a(this);
        this.f72859d.setOnClickListener(aVar);
        this.f72858c.setOnClickListener(aVar);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public int getContentView() {
        return R$layout.activity_edit_collecation;
    }

    public void initView() {
        EventBus.d().p(this);
        this.f72857b = (TextView) this.viewFinder.b(R$id.market_coll_finish_tv);
        this.f72858c = (LinearLayout) this.viewFinder.b(R$id.market_all_select);
        this.f72859d = (CommonCheckBox) this.viewFinder.b(R$id.market_check_cb);
        this.f72860e = (RecyclerView) this.viewFinder.b(R$id.market_coll_edit_rv);
        TextView textView = (TextView) this.viewFinder.b(R$id.market_edit_coll_delete_tv);
        this.f72861f = textView;
        textView.setEnabled(false);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onEvent(pl.a aVar) {
        ((EditCollectionPresenter) getPresenter()).h0();
    }

    public void rh() {
        DialogUtils.c0(this, getResources().getString(R$string.market_coll_edit_dialog_conent_text), (String) null, getResources().getString(R$string.market_coll_edit_cancle_text), getResources().getString(R$string.market_coll_edit_ok_text), e.f60775a, new d(this));
    }

    public boolean va() {
        return this.f72859d.isChecked();
    }
}
