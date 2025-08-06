package com.hbg.ability;

import android.text.TextUtils;
import android.util.Log;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import org.json.JSONObject;
import rj.b;

public class CurrencyNoticeAbility implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null && obj != null) {
            if (obj instanceof String) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    Log.e("Console", jSONObject.toString());
                    if (jSONObject.getInt("type") == 1) {
                        String string = jSONObject.getString("url");
                        if (!TextUtils.isEmpty(string)) {
                            try {
                                HBBaseWebActivity.showWebView(bVar.d(), string, "", "", false);
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        }
                        aVar.a(true, (Object) null);
                        return;
                    }
                    aVar.a(false, (Object) null);
                } catch (Exception e12) {
                    e12.printStackTrace();
                    aVar.a(false, e12.getMessage());
                }
            } else {
                aVar.a(false, (Object) null);
            }
        }
    }
}
