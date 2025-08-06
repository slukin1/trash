package com.huobi.trade.ui.coupon;

import android.util.Log;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import rj.b;

public class CouponEvent implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj instanceof String) {
            try {
                WeakReference weakReference = (WeakReference) bVar.h(TUIConstants.TUIChat.FRAGMENT);
                if (weakReference != null) {
                    if (weakReference.get() != null) {
                        CouponEngineFragment couponEngineFragment = (CouponEngineFragment) weakReference.get();
                        JSONObject jSONObject = new JSONObject((String) obj);
                        Log.e("Console", jSONObject.toString());
                        String string = jSONObject.getString("action");
                        if ("onSelected".equals(string)) {
                            couponEngineFragment.vh(jSONObject.getLong("couponId"), jSONObject.getBoolean("isSelected"));
                            aVar.a(true, (Object) null);
                            return;
                        } else if ("onExpanded".equals(string)) {
                            couponEngineFragment.uh(jSONObject.getLong("couponId"), jSONObject.getBoolean("isExpanded"));
                            aVar.a(true, (Object) null);
                            return;
                        } else if ("onClose".equals(string)) {
                            couponEngineFragment.sh();
                            aVar.a(true, (Object) null);
                            return;
                        } else if ("onConfirm".equals(string)) {
                            couponEngineFragment.th();
                            aVar.a(true, (Object) null);
                            return;
                        } else {
                            aVar.a(false, "action not found!");
                            return;
                        }
                    }
                }
                aVar.a(false, "fragment not found");
            } catch (Throwable th2) {
                if (aVar != null) {
                    aVar.a(false, th2.getMessage());
                }
            }
        }
    }
}
