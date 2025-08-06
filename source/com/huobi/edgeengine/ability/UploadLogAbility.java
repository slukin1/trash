package com.huobi.edgeengine.ability;

import android.util.Log;
import com.eclipsesource.v8.V8Object;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;

public class UploadLogAbility extends AbstractAbility {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        String str;
        if (aVar == null || obj == null) {
            Log.d("Console", "call UploadLogAbility error");
            return;
        }
        try {
            V8Object v8Object = (V8Object) obj;
            String string = v8Object.contains("tag") ? v8Object.getString("tag") : "";
            if (v8Object.contains("info")) {
                str = v8Object.getString("info");
            } else {
                str = "";
            }
            LogAndWoodRecorder.c(string, str);
            aVar.a(true, "");
        } catch (Throwable th2) {
            Log.d("Console", "call UploadLogAbility Exception ");
            th2.printStackTrace();
            aVar.a(false, th2.getMessage());
        }
    }

    public boolean b() {
        return false;
    }
}
