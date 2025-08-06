package com.huobi.edgeengine.ability;

import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;

public class HBToastAbility implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj == null || !(obj instanceof String)) {
            aVar.a(false, "text null!");
            return;
        }
        HuobiToastUtil.m((String) obj);
        aVar.a(true, (Object) null);
    }
}
