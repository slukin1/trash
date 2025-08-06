package com.hbg.module.content.ui.activity.live.edgeengine;

import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import rj.b;

public class LiveToastError implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj instanceof String) {
            HuobiToastUtil.m((String) obj);
            aVar.a(true, (Object) null);
            return;
        }
        aVar.a(false, (Object) null);
    }
}
