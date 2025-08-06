package com.huobi.account.ability;

import android.content.Context;
import android.content.res.Resources;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import rj.b;

public class KycGetColorAbility implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null && obj != null) {
            try {
                Context d11 = bVar.d();
                Resources resources = d11.getResources();
                aVar.a(true, resources.getString(resources.getIdentifier((String) obj, "color", d11.getPackageName())));
            } catch (Exception e11) {
                e11.printStackTrace();
                aVar.a(false, e11.getMessage());
            }
        }
    }
}
