package com.hbg.module.content.ui.activity.live.edgeengine;

import al.p;
import android.content.Context;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.s;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.d0;
import org.json.JSONObject;
import rj.b;

public final class GiftPanelAbility implements s {
    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj instanceof String) {
            try {
                WeakReference weakReference = (WeakReference) bVar.h("activity");
                if (((LiveDetailActivity) weakReference.get()) == null) {
                    aVar.a(false, "fragment not found");
                    return;
                }
                LiveDetailActivity liveDetailActivity = (LiveDetailActivity) weakReference.get();
                JSONObject jSONObject = new JSONObject((String) obj);
                Log.e("Console", jSONObject.toString());
                String string = jSONObject.getString("action");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -2092216410:
                            if (string.equals("onContinue")) {
                                if (liveDetailActivity != null) {
                                    liveDetailActivity.hl();
                                }
                                aVar.a(true, (Object) null);
                                return;
                            }
                            return;
                        case -1404233793:
                            if (string.equals("onDeposit")) {
                                if (liveDetailActivity != null) {
                                    liveDetailActivity.il();
                                }
                                aVar.a(true, (Object) null);
                                return;
                            }
                            return;
                        case -1167877181:
                            if (string.equals("onGetIntegral")) {
                                if (liveDetailActivity != null) {
                                    liveDetailActivity.jl();
                                }
                                aVar.a(true, (Object) null);
                                return;
                            }
                            return;
                        case -566813360:
                            if (string.equals("onGetIntroduceTitle")) {
                                Context d11 = bVar.d();
                                int identifier = d11.getResources().getIdentifier(jSONObject.getString("key"), "string", d11.getPackageName());
                                d0 d0Var = d0.f56774a;
                                aVar.a(true, String.format(bVar.d().getString(identifier), Arrays.copyOf(new Object[]{jSONObject.getString("number"), jSONObject.getString("drawNumber")}, 2)));
                                return;
                            }
                            return;
                        case -269702353:
                            if (string.equals("onSelectedNeverShow")) {
                                if (liveDetailActivity != null) {
                                    liveDetailActivity.kl(jSONObject.getBoolean("selected"));
                                }
                                aVar.a(true, (Object) null);
                                return;
                            }
                            return;
                        case -256712209:
                            if (string.equals("onGetBalacne")) {
                                aVar.a(true, p.j(jSONObject.has("balance") ? jSONObject.getString("balance") : "0", jSONObject.getString(FirebaseAnalytics.Param.CURRENCY)));
                                return;
                            }
                            return;
                        case -244131094:
                            if (string.equals("onTransfer")) {
                                if (liveDetailActivity != null) {
                                    liveDetailActivity.ll();
                                }
                                aVar.a(true, (Object) null);
                                return;
                            }
                            return;
                        case 1251087747:
                            if (string.equals("onCloseAlert")) {
                                if (liveDetailActivity != null) {
                                    liveDetailActivity.gl();
                                }
                                aVar.a(true, (Object) null);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th2) {
                if (aVar != null) {
                    aVar.a(false, th2.getMessage());
                }
            }
        }
    }
}
