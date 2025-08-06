package com.huobi.app.rms;

import com.google.gson.Gson;
import com.hbg.lib.network.hbg.core.bean.RMSConfig;
import d10.a;
import d10.l;
import i6.k;
import java.lang.reflect.Type;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HBRMSManager$requestConfig$1 extends Lambda implements l<RMSConfig, Unit> {
    public final /* synthetic */ a<Unit> $action;
    public final /* synthetic */ HBRMSManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$requestConfig$1(HBRMSManager hBRMSManager, a<Unit> aVar) {
        super(1);
        this.this$0 = hBRMSManager;
        this.$action = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RMSConfig) obj);
        return Unit.f56620a;
    }

    public final void invoke(RMSConfig rMSConfig) {
        if (rMSConfig != null) {
            HBRMSManager hBRMSManager = this.this$0;
            a<Unit> aVar = this.$action;
            String json = new Gson().toJson((Object) rMSConfig, (Type) RMSConfig.class);
            k.d("HBRMSManager", "RMS config: " + json);
            hBRMSManager.R("configCache", json);
            hBRMSManager.f42157k = Long.parseLong(rMSConfig.timeStamp) - System.currentTimeMillis();
            hBRMSManager.f42147a = rMSConfig;
            hBRMSManager.R("timeStamp", String.valueOf(hBRMSManager.f42157k));
            aVar.invoke();
        }
    }
}
