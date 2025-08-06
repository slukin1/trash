package com.huobi.account.ui;

import android.view.View;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.r;
import pro.huobi.R;

public class SecurityStrategyPasskeyFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public a f41541b;

    public interface a {
        void a();

        void b();

        void onCancel();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        a aVar = this.f41541b;
        if (aVar != null) {
            aVar.onCancel();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        a aVar = this.f41541b;
        if (aVar != null) {
            aVar.b();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        a aVar = this.f41541b;
        if (aVar != null) {
            aVar.b();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        a aVar = this.f41541b;
        if (aVar != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$afterInit$4() {
        a aVar = this.f41541b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.tv_cancel).setOnClickListener(new l5(this));
        rVar.b(R.id.id_passkey_face_btn).setOnClickListener(new m5(this));
        rVar.b(R.id.tv_passkey_verify).setOnClickListener(new k5(this));
        rVar.b(R.id.tv_passkey_switch).setOnClickListener(new j5(this));
    }

    public void afterInit() {
        i.b().g(new n5(this), 200);
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.fragment_security_passkey;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        setCanceledOnTouchOutside(false);
    }

    public boolean isTransparent() {
        return false;
    }

    public void xh(a aVar) {
        this.f41541b = aVar;
    }
}
