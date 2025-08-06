package com.huobi.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import yr.b;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b.p(getApplicationContext()).handleIntent(getIntent(), this);
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onReq(BaseReq baseReq) {
        finish();
    }

    public void onResp(BaseResp baseResp) {
        if (!(baseResp instanceof SendAuth.Resp) && (baseResp instanceof SendMessageToWX.Resp)) {
            b.q((SendMessageToWX.Resp) baseResp);
        }
        finish();
    }
}
