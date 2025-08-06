package com.huobi.edgeengine.ability;

import android.text.TextUtils;
import android.util.Log;
import com.eclipsesource.v8.V8Object;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;

public class EngineStorageAbility extends AbstractAbility {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        String str;
        String str2;
        String str3;
        if (aVar == null || obj == null) {
            Log.d("Console", "call EngineStorageAbility error");
            return;
        }
        try {
            V8Object v8Object = (V8Object) obj;
            String string = v8Object.contains("action") ? v8Object.getString("action") : "";
            if (v8Object.contains("data")) {
                str = v8Object.getString("data");
            } else {
                str = "";
            }
            if (v8Object.contains("name")) {
                str2 = v8Object.getString("name");
            } else {
                str2 = "";
            }
            if (v8Object.contains("key")) {
                str3 = v8Object.getString("key");
            } else {
                str3 = "";
            }
            char c11 = 65535;
            int hashCode = string.hashCode();
            if (hashCode != 3496342) {
                if (hashCode != 3522941) {
                    if (hashCode == 94746189) {
                        if (string.equals("clear")) {
                            c11 = 2;
                        }
                    }
                } else if (string.equals("save")) {
                    c11 = 1;
                }
            } else if (string.equals("read")) {
                c11 = 0;
            }
            if (c11 == 0) {
                aVar.a(true, SP.j(str2, MD5Utils.a(str3), ""));
            } else if (c11 == 1) {
                SP.w(str2, MD5Utils.a(str3), str);
                aVar.a(true, "");
            } else if (c11 != 2) {
                aVar.a(true, "default");
            } else {
                if (TextUtils.isEmpty(str3)) {
                    SP.a(str2);
                } else {
                    SP.o(str2, MD5Utils.a(str3));
                }
                aVar.a(true, "");
            }
        } catch (Exception e11) {
            Log.d("Console", "call EngineStorageAbility Exception ");
            e11.printStackTrace();
            aVar.a(false, e11.getMessage());
        }
    }

    public boolean b() {
        return false;
    }
}
