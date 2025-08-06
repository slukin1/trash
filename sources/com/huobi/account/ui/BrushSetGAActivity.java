package com.huobi.account.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.presenter.BrushSetGAPresenter;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class BrushSetGAActivity extends BaseActivity<BrushSetGAPresenter, BrushSetGAPresenter.b> implements BrushSetGAPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f41137b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41138c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41139d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41140e;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(this.f41138c.getText(), this.f41138c.getText()));
            HuobiToastUtil.s(R.string.security_ga_key_already_copy);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pg(View view) {
        Intent intent = new Intent(this, SecurityLinkStep2Activity.class);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            intent.putExtras(getIntent().getExtras());
        }
        intent.putExtra("LINK_TYPE_KEY", 4);
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Zf */
    public BrushSetGAPresenter createPresenter() {
        return new BrushSetGAPresenter();
    }

    public void addEvent() {
    }

    /* renamed from: fg */
    public BrushSetGAPresenter.b getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_brush_set_ga;
    }

    public final void gg() {
        this.viewFinder.b(R.id.rl_ga_area).setVisibility(0);
        this.viewFinder.b(R.id.tv_ga_msg);
        this.f41137b = (ImageView) this.viewFinder.b(R.id.iv_security_ga);
        this.f41138c = (TextView) this.viewFinder.b(R.id.tv_ga_key);
        this.f41139d = (TextView) this.viewFinder.b(R.id.tv_save_ga_key);
        TextView textView = (TextView) this.viewFinder.b(R.id.btn_action);
        this.f41140e = textView;
        textView.setEnabled(true);
        this.f41139d.setOnClickListener(new f(this));
        this.f41140e.setOnClickListener(new e(this));
    }

    public void initView() {
        gg();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void w(GaGenerateData gaGenerateData) {
        String gaKey = gaGenerateData.getGaKey();
        String loginName = gaGenerateData.getLoginName();
        this.f41138c.setText(gaKey);
        this.f41137b.setImageBitmap(((BrushSetGAPresenter) getPresenter()).Q(getString(R.string.ga_key_format, new Object[]{loginName, gaKey}), PixelUtils.a(175.0f), PixelUtils.a(175.0f)));
        this.f41139d.setVisibility(0);
    }
}
