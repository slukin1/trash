package com.hbg.module.content.ui.activity.live.edgeengine;

import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import rj.b;

public class LiveLoading implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (bVar.d() instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) bVar.d();
                if (1 == intValue) {
                    baseActivity.sh();
                } else {
                    baseActivity.Df();
                }
                aVar.a(true, (Object) null);
                return;
            }
            aVar.a(false, (Object) null);
        }
    }
}
