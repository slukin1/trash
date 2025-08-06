package com.huobi.account.ability;

import android.util.Log;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import rj.b;
import sn.w;

public class KycGetFlagUrlAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40924a = "KycGetFlagUrlAbility";

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null) {
            String str = "-1";
            if (obj != null) {
                try {
                    str = String.valueOf(obj);
                } catch (Exception e11) {
                    e11.printStackTrace();
                    aVar.a(false, e11.getMessage());
                    return;
                }
            }
            String e12 = w.e(str);
            String str2 = f40924a;
            Log.e(str2, "call: flagUrl = " + e12);
            aVar.a(true, e12);
        }
    }
}
