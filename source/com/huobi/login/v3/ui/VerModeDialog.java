package com.huobi.login.v3.ui;

import android.view.View;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import vn.b0;
import vn.c0;
import vn.d0;
import vn.e0;

public class VerModeDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public final a f76137b;

    public interface a {
        void a();

        boolean b();

        void c();

        boolean d();

        boolean e();

        void f();
    }

    public VerModeDialog(a aVar) {
        this.f76137b = aVar;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        this.f76137b.a();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void wh(View view) {
        this.f76137b.c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        this.f76137b.f();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public int getContentViewResId() {
        return R.layout.fragment_ver_mode;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.b(R.id.tv_ver_code).setOnClickListener(new e0(this));
        int i11 = 8;
        rVar.b(R.id.tv_ver_code).setVisibility(this.f76137b.b() ? 8 : 0);
        rVar.b(R.id.tv_ver_passkey).setVisibility(this.f76137b.e() ? 0 : 8);
        View b11 = rVar.b(R.id.tv_ver_pwd);
        if (this.f76137b.d()) {
            i11 = 0;
        }
        b11.setVisibility(i11);
        rVar.b(R.id.tv_ver_passkey).setOnClickListener(new b0(this));
        rVar.b(R.id.tv_ver_pwd).setOnClickListener(new c0(this));
        rVar.b(R.id.root_view).setOnClickListener(new d0(this));
    }

    public boolean isTransparent() {
        return false;
    }
}
