package com.huobi.login.v3.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.r;
import pro.huobi.R;
import vn.e;
import vn.f;
import vn.g;
import vn.h;

public class PasskeyFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public a f76069b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f76070c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f76071d;

    public interface a {
        void a();

        void login();
    }

    public PasskeyFragment(a aVar) {
        this.f76069b = aVar;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f76069b.login();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.f76069b.a();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        this.f76069b.login();
    }

    public void addEvent(r rVar) {
        this.f76070c.setOnClickListener(new g(this));
        this.f76071d.setOnClickListener(new e(this));
        rVar.b(R.id.iv_close).setOnClickListener(new f(this));
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.activity_login_passkey;
    }

    public int getGravity() {
        return 48;
    }

    public void initView(r rVar) {
        this.f76070c = (ImageView) rVar.b(R.id.iv_passkey_verify);
        this.f76071d = (TextView) rVar.b(R.id.tv_switch_auth);
        i.b().g(new h(this), 200);
    }

    public boolean isTransparent() {
        return false;
    }
}
