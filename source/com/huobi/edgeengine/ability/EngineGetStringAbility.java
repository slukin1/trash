package com.huobi.edgeengine.ability;

import android.content.Context;
import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;

public class EngineGetStringAbility implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        String str;
        if (aVar != null && (obj instanceof String)) {
            try {
                Context d11 = bVar.d();
                try {
                    str = d11.getString(d11.getResources().getIdentifier((String) obj, "string", d11.getPackageName()));
                } catch (Exception unused) {
                    str = "";
                }
                aVar.a(true, str);
            } catch (Throwable unused2) {
                aVar.a(false, "");
            }
        }
    }
}
