package com.huobi.home.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.huobi.home.engine.GuideBridgeAbility;
import pro.huobi.R;
import rj.b;

@Route(path = "/home/transferAmountGuide")
public class TransferAmountGuideActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public b f72547b;

    public static void Yf(Activity activity) {
        activity.startActivity(new Intent(activity, TransferAmountGuideActivity.class));
    }

    public final void Xf() {
        b bVar = new b(this, "buystepguide");
        this.f72547b = bVar;
        bVar.t("guideBridge", GuideBridgeAbility.class);
    }

    public void addEvent() {
    }

    public int getContentView() {
        return R.layout.activity_transfer_amount_guide;
    }

    public void initExtra() {
        super.initExtra();
    }

    public void initView() {
        hideStatusBar();
        removeWinBg();
        canFullScreen();
        Xf();
        this.f72547b.H();
        ((FrameLayout) findViewById(R.id.institutionAuthRoot)).addView(this.f72547b.E("guide.xml", this, false, (JSONObject) null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f72547b;
        if (bVar != null) {
            bVar.B();
            this.f72547b = null;
        }
    }
}
