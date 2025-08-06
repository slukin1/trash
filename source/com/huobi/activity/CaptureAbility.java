package com.huobi.activity;

import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import rj.b;
import xg.q;

public class CaptureAbility implements s {
    public static /* synthetic */ void c(b bVar, AbilityFunction.a aVar) {
        try {
            if (bVar.d() instanceof NetworkDetectionActivity) {
                ((NetworkDetectionActivity) bVar.d()).gg();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            aVar.a(false, th2.getMessage());
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        aVar.a(true, "");
        new Thread(new q(bVar, aVar)).start();
    }
}
