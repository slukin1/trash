package com.huobi.trade.engine;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.w;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import com.huobi.trade.ui.TradeTimeOrderConfirmFragment;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import qk.u0;
import rj.b;

public class TradeNativeAbility implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar != null) {
            Log.d("lylTradeAbility", obj.toString());
            if (obj instanceof String) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    String string = jSONObject.getString("action");
                    JSONArray jSONArray = null;
                    if ("onCloseAlert".equals(string)) {
                        WeakReference weakReference = (WeakReference) bVar.h(TUIConstants.TUIChat.FRAGMENT);
                        if (weakReference != null) {
                            if (weakReference.get() != null) {
                                if (weakReference.get() != null) {
                                    ((BaseDialogFragment) weakReference.get()).doDismiss();
                                }
                                aVar.a(true, (Object) null);
                                return;
                            }
                        }
                        aVar.a(false, "fragment not found");
                    } else if ("getDrawable".equals(string)) {
                        String string2 = jSONObject.getString("drawableKey");
                        Context d11 = bVar.d();
                        int identifier = d11.getResources().getIdentifier(string2, "drawable", d11.getPackageName());
                        Log.d("lylTradeAbility", "getDrawable " + ContextCompat.getDrawable(d11, identifier) + " ,id:" + identifier);
                        aVar.a(true, ContextCompat.getDrawable(d11, identifier));
                    } else if ("getColor".equals(string)) {
                        String string3 = jSONObject.getString("colorKey");
                        Context d12 = bVar.d();
                        int identifier2 = d12.getResources().getIdentifier(string3, "color", d12.getPackageName());
                        aVar.a(true, "#" + Integer.toHexString(ContextCompat.getColor(d12, identifier2)));
                    } else if ("isRedRise".equals(string)) {
                        aVar.a(true, w.l() ? "0" : "1");
                    } else if ("getWord".equals(string)) {
                        String string4 = jSONObject.getString("wordKey");
                        try {
                            jSONArray = jSONObject.getJSONArray("values");
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                        Context d13 = bVar.d();
                        Resources resources = d13.getResources();
                        String string5 = resources.getString(resources.getIdentifier(string4, "string", d13.getPackageName()));
                        if (jSONArray != null && jSONArray.length() > 1) {
                            aVar.a(true, String.format(string5, new Object[]{jSONArray.get(0), jSONArray.get(1)}));
                        } else if (jSONArray == null || jSONArray.length() <= 0) {
                            aVar.a(true, string5);
                        } else {
                            aVar.a(true, String.format(string5, new Object[]{jSONArray.get(0)}));
                        }
                    } else if ("showToast".equals(string)) {
                        HuobiToastUtil.m(jSONObject.getString("toastKey"));
                        aVar.a(true, (Object) null);
                    } else if ("orderConfirmDialog".equals(string)) {
                        TradeTimeOrderConfirmFragment.th(jSONObject.getJSONObject("params").toString()).show(((FragmentActivity) bVar.d()).getSupportFragmentManager(), "");
                        aVar.a(true, (Object) null);
                    } else if ("orderConfirmNotReminder".equals(string)) {
                        u0.f("config_app_spot_time_confirm_key", jSONObject.getBoolean("isCheck"));
                        aVar.a(true, (Object) null);
                    } else {
                        aVar.a(false, (Object) null);
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
    }
}
