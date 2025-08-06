package com.hbg.module.content.ui.activity.live.edgeengine;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.m;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pc.c;
import pc.d;
import rj.b;

public class TabDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public b f18633b;

    /* renamed from: c  reason: collision with root package name */
    public int f18634c;

    public TabDialogFragment(b bVar, int i11) {
        this.f18633b = bVar;
        this.f18634c = i11;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.f18633b.I("nav.getSelectedItem()");
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(Object obj) {
        this.f18633b.I(String.format("nav.initSelectionItem('%s')", new Object[]{m.g(obj)}));
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.iv_back).setOnClickListener(new c(this));
        rVar.b(R$id.tv_action).setOnClickListener(new pc.b(this));
    }

    public void afterInit() {
        b bVar = this.f18633b;
        int i11 = this.f18634c;
        bVar.u(i11 == 8 ? "nav.allNavList" : i11 == 1 ? "nav.newsNavList" : "nav.deepNavList", new d(this));
    }

    public int getContentViewResId() {
        return R$layout.fragment_tab_engine_dialog;
    }

    public int getGravity() {
        return 48;
    }

    public void initView(r rVar) {
        ((FrameLayout) rVar.b(R$id.fl_engine_dialog_container)).addView(this.f18633b.E("content_nav_selection.xml", getContext(), false, (JSONObject) null));
        setCoverViewBgColor(Color.parseColor("#32000000"));
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getDialog().getWindow().setLayout(-1, -2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
