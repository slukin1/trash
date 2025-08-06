package com.hbg.module.content.ui.activity.live.edgeengine;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import i6.r;
import rj.b;

public class EngineDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public b f18631b;

    /* renamed from: c  reason: collision with root package name */
    public String f18632c;

    public EngineDialogFragment(b bVar) {
        this.f18631b = bVar;
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.fragment_engine_dialog;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        ((FrameLayout) rVar.b(R$id.fl_engine_dialog_container)).addView(this.f18631b.E(this.f18632c, getContext(), false, (JSONObject) null));
        setCoverViewBgColor(Color.parseColor("#32000000"));
    }

    public boolean isTransparent() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void sh(int i11) {
        if (i11 == 1) {
            this.f18632c = "live_gift_panel_asset_balance_alert.xml";
        } else if (i11 == 2) {
            this.f18632c = "live_gift_panel_deduct_alert.xml";
        } else if (i11 == 3) {
            this.f18632c = "live_gift_panel_introduce_alert.xml";
        }
    }

    public boolean useWindowBg() {
        return false;
    }
}
