package com.huobi.copytrading.engine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.eclipsesource.v8.V8Object;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.client.android.CaptureActivity;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.ability.AbstractAbility;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.ui.RankingActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.message.ui.MessageActivity;
import com.huobi.search.ui.SearchFlutterActivity;
import com.huobi.utils.k0;
import com.huochat.community.util.JsonTool;
import com.luck.picture.lib.permissions.PermissionConfig;
import i6.d;
import i6.m;
import i8.k;
import java.util.Arrays;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import pro.huobi.R;
import sn.f;
import tg.r;
import yl.o;
import yl.t;

public class CopytradingNativeAbility extends AbstractAbility {

    /* renamed from: a  reason: collision with root package name */
    public String f43588a = "EDGE_ENGINE_LINEARSWAP_TAG";

    /* renamed from: b  reason: collision with root package name */
    public LastKlineListener f43589b;

    public static final class a extends TypeToken<IndexFeatureItem> {
    }

    public static final class b implements k.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ rj.b f43590a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CopytradingNativeAbility f43591b;

        public b(rj.b bVar, CopytradingNativeAbility copytradingNativeAbility) {
            this.f43590a = bVar;
            this.f43591b = copytradingNativeAbility;
        }

        public void e(List<? extends SymbolPrice> list) {
            JSONObject jSONObject = new JSONObject();
            for (SymbolPrice symbolPrice : list) {
                if (symbolPrice != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("close", symbolPrice.getClose());
                    jSONObject2.put("open", symbolPrice.getOpen());
                    jSONObject2.put("amount", symbolPrice.getAmount());
                    jSONObject2.put("vol", symbolPrice.getVol());
                    jSONObject2.put("rise", symbolPrice.getRise());
                    jSONObject2.put("symbol", symbolPrice.getSymbol());
                    jSONObject2.put("strShowClose", m.m(String.valueOf(symbolPrice.getClose()), FuturePrecisionUtil.y(symbolPrice.getSymbol(), symbolPrice.getSymbol(), "")));
                    jSONObject2.put(FirebaseAnalytics.Param.PRICE, m.m(String.valueOf(symbolPrice.getClose()), FuturePrecisionUtil.y(symbolPrice.getSymbol(), symbolPrice.getSymbol(), "")));
                    jSONObject.put(symbolPrice.getSymbol(), jSONObject2);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", "linearSwapWs");
            jSONObject3.put("data", jSONObject.toString());
            rj.b bVar = this.f43590a;
            if (bVar != null) {
                bVar.I("sendSocketData(" + jSONObject3 + ')');
            }
            d.c(this.f43591b.h(), jSONObject.toString());
        }

        public void onSuccess(List<? extends SymbolPrice> list) {
        }
    }

    public static final class c extends LastKlineListener {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ rj.b f43592d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CopytradingNativeAbility f43593e;

        public c(rj.b bVar, CopytradingNativeAbility copytradingNativeAbility) {
            this.f43592d = bVar;
            this.f43593e = copytradingNativeAbility;
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            KlineInfo tick = lastKlineResponse.getTick();
            if (tick != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("close", Double.valueOf(tick.getClose()));
                jSONObject.put("open", Double.valueOf(tick.getOpen()));
                jSONObject.put("symbol", lastKlineResponse.getSymbol());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", "linearSwapPeriodKlineWs");
                jSONObject2.put("data", jSONObject.toString());
                rj.b bVar = this.f43592d;
                if (bVar != null) {
                    bVar.I("sendSocketData(" + jSONObject2 + ')');
                }
                d.c(this.f43593e.h(), tick.toString());
            }
        }

        public void onFailed(Throwable th2) {
            super.onFailed(th2);
            th2.printStackTrace();
            i6.k.g(this.f70671a, "lastKlineListener has error ", th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r6 = r6.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void l(android.app.Activity r4, java.lang.String r5, android.content.Context r6) {
        /*
            androidx.fragment.app.FragmentActivity r4 = (androidx.fragment.app.FragmentActivity) r4
            android.content.res.Resources r0 = r4.getResources()
            android.content.res.Resources r1 = r4.getResources()
            java.lang.String r2 = r4.getPackageName()
            java.lang.String r3 = "string"
            int r5 = r1.getIdentifier(r5, r3, r2)
            java.lang.String r5 = r0.getString(r5)
            r0 = 0
            if (r6 == 0) goto L_0x0029
            android.content.res.Resources r6 = r6.getResources()
            if (r6 == 0) goto L_0x0029
            r1 = 2132026264(0x7f142398, float:1.9691056E38)
            java.lang.String r6 = r6.getString(r1)
            goto L_0x002a
        L_0x0029:
            r6 = r0
        L_0x002a:
            com.huobi.copytrading.engine.b r1 = com.huobi.copytrading.engine.b.f43596a
            com.hbg.lib.widgets.dialog.DialogUtils.Y(r4, r5, r0, r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.copytrading.engine.CopytradingNativeAbility.l(android.app.Activity, java.lang.String, android.content.Context):void");
    }

    public static final void m(HBDialogFragment hBDialogFragment) {
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public static final void x(Activity activity, String[] strArr, int i11) {
        if (i11 == 0) {
            d.i("HasPermissions, start CaptureActivity.");
            Intent intent = new Intent(activity, CaptureActivity.class);
            intent.putExtra(CaptureActivity.PARAM_HINT_TEXT, activity.getString(R.string.n_scan_automation_tips));
            activity.startActivityForResult(intent, 1001);
        } else if (i11 == 2) {
            d.i("Has not Permissions, start request permissions.");
            EasyPermissions.requestPermissions(activity, 123, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    public final void A() {
        d.c(this.f43588a, "LinearSwap unSubOverView");
        k.g().m();
        k.g().j(this.f43588a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[SYNTHETIC, Splitter:B:10:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[Catch:{ all -> 0x0012 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B(com.eclipsesource.v8.V8Object r6, rj.b r7, com.huobi.edgeengine.ability.AbilityFunction.a r8) {
        /*
            r5 = this;
            r0 = 0
            r5.D(r6, r7, r0)
            java.lang.String r0 = "params"
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0014
            boolean r3 = r6.contains(r0)     // Catch:{ all -> 0x0012 }
            if (r3 != r2) goto L_0x0014
            r3 = r2
            goto L_0x0015
        L_0x0012:
            r6 = move-exception
            goto L_0x004b
        L_0x0014:
            r3 = r1
        L_0x0015:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001e
            java.lang.String r6 = r6.getString(r0)     // Catch:{ all -> 0x0012 }
            goto L_0x001f
        L_0x001e:
            r6 = r4
        L_0x001f:
            com.alibaba.fastjson.JSONObject r6 = com.huochat.community.util.JsonTool.parseObject(r6)     // Catch:{ all -> 0x0012 }
            java.lang.String r0 = "symbol"
            java.lang.String r0 = r6.getString(r0)     // Catch:{ all -> 0x0012 }
            java.lang.String r3 = "period"
            java.lang.String r6 = r6.getString(r3)     // Catch:{ all -> 0x0012 }
            com.hbg.lib.network.pro.socket.listener.LastKlineListener r3 = r5.f43589b     // Catch:{ all -> 0x0012 }
            if (r3 != 0) goto L_0x003a
            com.huobi.copytrading.engine.CopytradingNativeAbility$c r3 = new com.huobi.copytrading.engine.CopytradingNativeAbility$c     // Catch:{ all -> 0x0012 }
            r3.<init>(r7, r5)     // Catch:{ all -> 0x0012 }
            r5.f43589b = r3     // Catch:{ all -> 0x0012 }
        L_0x003a:
            h8.b r7 = h8.a.a()     // Catch:{ all -> 0x0012 }
            com.hbg.lib.network.pro.core.util.Period r6 = com.hbg.lib.network.pro.core.util.Period.parsePeriod(r6)     // Catch:{ all -> 0x0012 }
            com.hbg.lib.network.pro.socket.listener.LastKlineListener r3 = r5.f43589b     // Catch:{ all -> 0x0012 }
            r7.g(r2, r0, r6, r3)     // Catch:{ all -> 0x0012 }
            r8.a(r2, r4)     // Catch:{ all -> 0x0012 }
            goto L_0x005c
        L_0x004b:
            java.lang.String r7 = "Console"
            java.lang.String r0 = "call CopytradingNativeAbility subscribeLastKline error "
            android.util.Log.d(r7, r0)
            r6.printStackTrace()
            java.lang.String r6 = r6.getMessage()
            r8.a(r1, r6)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.copytrading.engine.CopytradingNativeAbility.B(com.eclipsesource.v8.V8Object, rj.b, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015 A[SYNTHETIC, Splitter:B:10:0x0015] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027 A[Catch:{ Exception -> 0x000e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C(com.eclipsesource.v8.V8Object r6, rj.b r7, com.huobi.edgeengine.ability.AbilityFunction.a r8) {
        /*
            r5 = this;
            java.lang.String r0 = "type"
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L_0x0010
            boolean r3 = r6.contains(r0)     // Catch:{ Exception -> 0x000e }
            if (r3 != r1) goto L_0x0010
            r3 = r1
            goto L_0x0011
        L_0x000e:
            r6 = move-exception
            goto L_0x0036
        L_0x0010:
            r3 = r2
        L_0x0011:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001a
            java.lang.String r0 = r6.getString(r0)     // Catch:{ Exception -> 0x000e }
            goto L_0x001b
        L_0x001a:
            r0 = r4
        L_0x001b:
            java.lang.String r3 = "linearSwapWs"
            boolean r3 = kotlin.jvm.internal.x.b(r0, r3)     // Catch:{ Exception -> 0x000e }
            if (r3 == 0) goto L_0x0027
            r5.s(r7)     // Catch:{ Exception -> 0x000e }
            goto L_0x0032
        L_0x0027:
            java.lang.String r3 = "linearSwapPeriodKlineWs"
            boolean r0 = kotlin.jvm.internal.x.b(r0, r3)     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x0032
            r5.B(r6, r7, r8)     // Catch:{ Exception -> 0x000e }
        L_0x0032:
            r8.a(r1, r4)     // Catch:{ Exception -> 0x000e }
            goto L_0x0047
        L_0x0036:
            java.lang.String r7 = "Console"
            java.lang.String r0 = "call CopytradingNativeAbility subPriceWebSocket error "
            android.util.Log.d(r7, r0)
            r6.printStackTrace()
            java.lang.String r6 = r6.getMessage()
            r8.a(r2, r6)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.copytrading.engine.CopytradingNativeAbility.C(com.eclipsesource.v8.V8Object, rj.b, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[SYNTHETIC, Splitter:B:10:0x0016] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[Catch:{ all -> 0x000f, all -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b A[Catch:{ all -> 0x000f, all -> 0x0055 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(com.eclipsesource.v8.V8Object r7, rj.b r8, com.huobi.edgeengine.ability.AbilityFunction.a r9) {
        /*
            r6 = this;
            java.lang.String r8 = "params"
            r0 = 0
            r1 = 1
            r2 = 0
            if (r7 == 0) goto L_0x0011
            boolean r3 = r7.contains(r8)     // Catch:{ all -> 0x000f }
            if (r3 != r1) goto L_0x0011
            r3 = r1
            goto L_0x0012
        L_0x000f:
            r7 = move-exception
            goto L_0x003f
        L_0x0011:
            r3 = r2
        L_0x0012:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001b
            java.lang.String r7 = r7.getString(r8)     // Catch:{ all -> 0x000f }
            goto L_0x001c
        L_0x001b:
            r7 = r4
        L_0x001c:
            com.alibaba.fastjson.JSONObject r7 = com.huochat.community.util.JsonTool.parseObject(r7)     // Catch:{ all -> 0x000f }
            java.lang.String r8 = "symbol"
            java.lang.String r8 = r7.getString(r8)     // Catch:{ all -> 0x000f }
            java.lang.String r3 = "period"
            java.lang.String r7 = r7.getString(r3)     // Catch:{ all -> 0x000f }
            h8.b r3 = h8.a.a()     // Catch:{ all -> 0x000f }
            com.hbg.lib.network.pro.core.util.Period r7 = com.hbg.lib.network.pro.core.util.Period.parsePeriod(r7)     // Catch:{ all -> 0x000f }
            com.hbg.lib.network.pro.socket.listener.LastKlineListener r5 = r6.f43589b     // Catch:{ all -> 0x000f }
            r3.g(r2, r8, r7, r5)     // Catch:{ all -> 0x000f }
            if (r9 == 0) goto L_0x0052
            r9.a(r1, r4)     // Catch:{ all -> 0x000f }
            goto L_0x0052
        L_0x003f:
            java.lang.String r8 = "Console"
            java.lang.String r1 = "call CopytradingNativeAbility unsubLinearSwapPeriodKline error "
            android.util.Log.d(r8, r1)     // Catch:{ all -> 0x0055 }
            r7.printStackTrace()     // Catch:{ all -> 0x0055 }
            if (r9 == 0) goto L_0x0052
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0055 }
            r9.a(r2, r7)     // Catch:{ all -> 0x0055 }
        L_0x0052:
            r6.f43589b = r0
            return
        L_0x0055:
            r7 = move-exception
            r6.f43589b = r0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.copytrading.engine.CopytradingNativeAbility.D(com.eclipsesource.v8.V8Object, rj.b, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015 A[SYNTHETIC, Splitter:B:10:0x0015] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A[Catch:{ Exception -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027 A[Catch:{ Exception -> 0x000e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(com.eclipsesource.v8.V8Object r6, rj.b r7, com.huobi.edgeengine.ability.AbilityFunction.a r8) {
        /*
            r5 = this;
            java.lang.String r0 = "type"
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L_0x0010
            boolean r3 = r6.contains(r0)     // Catch:{ Exception -> 0x000e }
            if (r3 != r1) goto L_0x0010
            r3 = r1
            goto L_0x0011
        L_0x000e:
            r6 = move-exception
            goto L_0x0036
        L_0x0010:
            r3 = r2
        L_0x0011:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001a
            java.lang.String r0 = r6.getString(r0)     // Catch:{ Exception -> 0x000e }
            goto L_0x001b
        L_0x001a:
            r0 = r4
        L_0x001b:
            java.lang.String r3 = "linearSwapWs"
            boolean r3 = kotlin.jvm.internal.x.b(r0, r3)     // Catch:{ Exception -> 0x000e }
            if (r3 == 0) goto L_0x0027
            r5.A()     // Catch:{ Exception -> 0x000e }
            goto L_0x0032
        L_0x0027:
            java.lang.String r3 = "linearSwapPeriodKlineWs"
            boolean r0 = kotlin.jvm.internal.x.b(r0, r3)     // Catch:{ Exception -> 0x000e }
            if (r0 == 0) goto L_0x0032
            r5.D(r6, r7, r8)     // Catch:{ Exception -> 0x000e }
        L_0x0032:
            r8.a(r1, r4)     // Catch:{ Exception -> 0x000e }
            goto L_0x0047
        L_0x0036:
            java.lang.String r7 = "Console"
            java.lang.String r0 = "call CopytradingNativeAbility unsubPriceWebSocket error "
            android.util.Log.d(r7, r0)
            r6.printStackTrace()
            java.lang.String r6 = r6.getMessage()
            r8.a(r2, r6)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.copytrading.engine.CopytradingNativeAbility.E(com.eclipsesource.v8.V8Object, rj.b, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public void a(rj.b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar == null || obj == null || bVar == null) {
            Log.d("Console", "call CopytradingNativeAbility error");
            return;
        }
        try {
            V8Object v8Object = (V8Object) obj;
            String string = v8Object.contains("action") ? v8Object.getString("action") : "";
            if (string != null) {
                switch (string.hashCode()) {
                    case -2137898495:
                        if (!string.equals("getVolumeStr")) {
                            break;
                        } else {
                            i(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case -2080571989:
                        if (!string.equals("getPNGIconURLByCurrency")) {
                            break;
                        } else {
                            g(v8Object, aVar);
                            return;
                        }
                    case -1913642710:
                        if (!string.equals("showToast")) {
                            break;
                        } else {
                            n(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case -1706829390:
                        if (!string.equals("showTextAlert")) {
                            break;
                        } else {
                            k(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case -703630594:
                        if (!string.equals("subPriceWebSocket")) {
                            break;
                        } else {
                            C(v8Object, bVar, aVar);
                            return;
                        }
                    case -504772615:
                        if (!string.equals("openPage")) {
                            break;
                        } else {
                            j(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case 343910997:
                        if (!string.equals("confirmCopy")) {
                            break;
                        } else {
                            f(v8Object, bVar.d(), aVar);
                            return;
                        }
                    case 351325774:
                        if (!string.equals("showDrawer")) {
                            break;
                        } else {
                            String string2 = v8Object.contains("symbolList") ? v8Object.getString("symbolList") : null;
                            if (string2 != null) {
                                n1 unused = i.d(i0.a(v0.c()), (CoroutineContext) null, (CoroutineStart) null, new CopytradingNativeAbility$call$1$1(string2, bVar, (kotlin.coroutines.c<? super CopytradingNativeAbility$call$1$1>) null), 3, (Object) null);
                            }
                            aVar.a(true, "");
                            return;
                        }
                    case 1268599173:
                        if (!string.equals("unsubPriceWebSocket")) {
                            break;
                        } else {
                            E(v8Object, bVar, aVar);
                            return;
                        }
                }
            }
            aVar.a(true, "");
        } catch (Throwable th2) {
            Log.d("Console", "call CopytradingNativeAbility error ");
            th2.printStackTrace();
            aVar.a(false, th2.getMessage());
        }
    }

    public boolean b() {
        return false;
    }

    public final void f(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        boolean z11 = false;
        if (v8Object != null && v8Object.contains("data")) {
            z11 = true;
        }
        if (z11) {
            v8Object.getString("data");
        }
        aVar.a(true, "");
    }

    public final void g(V8Object v8Object, AbilityFunction.a aVar) {
        boolean z11 = false;
        if (v8Object != null && v8Object.contains(FirebaseAnalytics.Param.CURRENCY)) {
            z11 = true;
        }
        aVar.a(true, kc.a.f19139a.e(z11 ? v8Object.getString(FirebaseAnalytics.Param.CURRENCY) : ""));
    }

    public final String h() {
        return this.f43588a;
    }

    public final void i(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        aVar.a(true, t.j(v8Object.contains("data") ? v8Object.getString("data") : ""));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x003f A[Catch:{ all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006c A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(com.eclipsesource.v8.V8Object r8, android.content.Context r9, com.huobi.edgeengine.ability.AbilityFunction.a r10) {
        /*
            r7 = this;
            java.lang.String r0 = "type"
            r1 = 0
            r2 = 1
            if (r8 == 0) goto L_0x000e
            boolean r3 = r8.contains(r0)
            if (r3 != r2) goto L_0x000e
            r3 = r2
            goto L_0x000f
        L_0x000e:
            r3 = r1
        L_0x000f:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0018
            java.lang.String r0 = r8.getString(r0)
            goto L_0x0019
        L_0x0018:
            r0 = r4
        L_0x0019:
            java.lang.String r3 = "page"
            if (r8 == 0) goto L_0x0025
            boolean r5 = r8.contains(r3)
            if (r5 != r2) goto L_0x0025
            r5 = r2
            goto L_0x0026
        L_0x0025:
            r5 = r1
        L_0x0026:
            if (r5 == 0) goto L_0x002d
            java.lang.String r3 = r8.getString(r3)
            goto L_0x002e
        L_0x002d:
            r3 = r4
        L_0x002e:
            java.lang.String r5 = "params"
            if (r8 == 0) goto L_0x003c
            boolean r6 = r8.contains(r5)     // Catch:{ all -> 0x003a }
            if (r6 != r2) goto L_0x003c
            r6 = r2
            goto L_0x003d
        L_0x003a:
            r8 = move-exception
            goto L_0x0044
        L_0x003c:
            r6 = r1
        L_0x003d:
            if (r6 == 0) goto L_0x0047
            java.lang.String r8 = r8.getString(r5)     // Catch:{ all -> 0x003a }
            goto L_0x0048
        L_0x0044:
            r8.printStackTrace()
        L_0x0047:
            r8 = r4
        L_0x0048:
            if (r0 == 0) goto L_0x0054
            java.lang.String r5 = "url"
            boolean r5 = r0.equals(r5)
            if (r5 != r2) goto L_0x0054
            r5 = r2
            goto L_0x0055
        L_0x0054:
            r5 = r1
        L_0x0055:
            if (r5 == 0) goto L_0x006c
            zn.a r8 = zn.a.d()
            android.net.Uri r9 = android.net.Uri.parse(r3)
            zn.a r8 = r8.v(r9)
            zn.a r8 = r8.a()
            r8.c()
            goto L_0x012e
        L_0x006c:
            if (r0 == 0) goto L_0x0077
            java.lang.String r5 = "contractWeb"
            boolean r0 = r0.equals(r5)
            if (r0 != r2) goto L_0x0077
            r1 = r2
        L_0x0077:
            if (r1 == 0) goto L_0x0087
            oa.a r8 = oa.a.g()
            android.app.Activity r8 = r8.b()
            r9 = 0
            com.huobi.webview2.ui.ContractWebActivity.Mh(r8, r3, r9)
            goto L_0x012e
        L_0x0087:
            if (r3 == 0) goto L_0x012e
            int r0 = r3.hashCode()
            switch(r0) {
                case -1948770067: goto L_0x0120;
                case -1925774507: goto L_0x0111;
                case -1061197229: goto L_0x0102;
                case -933809467: goto L_0x00f3;
                case -906336856: goto L_0x00e4;
                case 3364: goto L_0x00d5;
                case 110366: goto L_0x00c5;
                case 3524221: goto L_0x00b4;
                case 102138591: goto L_0x00a3;
                case 103149417: goto L_0x0092;
                default: goto L_0x0090;
            }
        L_0x0090:
            goto L_0x012e
        L_0x0092:
            java.lang.String r8 = "login"
            boolean r8 = r3.equals(r8)
            if (r8 != 0) goto L_0x009c
            goto L_0x012e
        L_0x009c:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.t(r9)
            goto L_0x012e
        L_0x00a3:
            java.lang.String r0 = "kline"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00ad
            goto L_0x012e
        L_0x00ad:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.r(r9, r8)
            goto L_0x012e
        L_0x00b4:
            java.lang.String r8 = "scan"
            boolean r8 = r3.equals(r8)
            if (r8 != 0) goto L_0x00be
            goto L_0x012e
        L_0x00be:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.w(r9)
            goto L_0x012e
        L_0x00c5:
            java.lang.String r8 = "otc"
            boolean r8 = r3.equals(r8)
            if (r8 != 0) goto L_0x00cf
            goto L_0x012e
        L_0x00cf:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.v(r9)
            goto L_0x012e
        L_0x00d5:
            java.lang.String r8 = "im"
            boolean r8 = r3.equals(r8)
            if (r8 != 0) goto L_0x00de
            goto L_0x012e
        L_0x00de:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.q(r9)
            goto L_0x012e
        L_0x00e4:
            java.lang.String r0 = "search"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00ed
            goto L_0x012e
        L_0x00ed:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.z(r9, r8)
            goto L_0x012e
        L_0x00f3:
            java.lang.String r0 = "marketAdd"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00fc
            goto L_0x012e
        L_0x00fc:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.u(r9, r8)
            goto L_0x012e
        L_0x0102:
            java.lang.String r0 = "cubeClick"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x010b
            goto L_0x012e
        L_0x010b:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.p(r9, r8)
            goto L_0x012e
        L_0x0111:
            java.lang.String r0 = "allRanking"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x011a
            goto L_0x012e
        L_0x011a:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.o(r9, r8)
            goto L_0x012e
        L_0x0120:
            java.lang.String r0 = "rankingToMarket"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0129
            goto L_0x012e
        L_0x0129:
            android.app.Activity r9 = (android.app.Activity) r9
            r7.y(r9, r8)
        L_0x012e:
            r10.a(r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.copytrading.engine.CopytradingNativeAbility.j(com.eclipsesource.v8.V8Object, android.content.Context, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public final void k(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        Activity l11;
        boolean z11 = false;
        if (v8Object != null && v8Object.contains("content")) {
            z11 = true;
        }
        String string = z11 ? v8Object.getString("content") : "";
        if (!com.hbg.module.libkt.base.ext.b.x(string) && (l11 = rd.a.m().l()) != null) {
            l11.runOnUiThread(new d(l11, string, context));
        }
        aVar.a(true, "");
    }

    public final void n(V8Object v8Object, Context context, AbilityFunction.a aVar) {
        HuobiToastUtil.m(v8Object.contains("message") ? v8Object.getString("message") : "");
        aVar.a(true, "");
    }

    public final void o(Activity activity, String str) {
        RankingActivity.uh(activity, Integer.parseInt(JsonTool.parseObject(str).getString("type")));
    }

    public final void p(Activity activity, String str) {
        try {
            o.q((FragmentActivity) activity, (IndexFeatureItem) new Gson().fromJson(str, new a().getType()), false);
        } catch (Throwable th2) {
            Log.d("Console", "call CopytradingNativeAbility startCube error ");
            th2.printStackTrace();
        }
    }

    public final void q(Activity activity) {
        Intent intent = new Intent(activity, MessageActivity.class);
        if (!r.x().F0()) {
            rn.c.i().d(activity, new JumpTarget(intent, (Intent) null));
        } else if (!NetworkStatus.c(activity)) {
            HuobiToastUtil.j(R.string.server_error);
        } else {
            activity.startActivity(intent);
        }
    }

    public final void r(Activity activity, String str) {
        String string = JsonTool.parseObject(str).getString("symbol");
        f.C(activity, string, false, TradeType.getTradeTypeBySymbol(string));
    }

    public final void s(rj.b bVar) {
        k.g().e(this.f43588a, new b(bVar, this));
        k.g().i();
        k.g().k(this.f43588a);
        d.c(this.f43588a, "LinearSwap subOverview");
    }

    public final void t(Activity activity) {
        rn.c.i().o(activity, new JumpTarget((Intent) null, (Intent) null));
    }

    public final void u(Activity activity, String str) {
        z(activity, "");
    }

    public final void v(Activity activity) {
        zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/index")).a().c();
    }

    @AfterPermissionGranted(123)
    public final void w(Activity activity) {
        String[] strArr;
        d.i("startQrScan");
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        PermissionUtils.g(activity, new c(activity, strArr));
    }

    public final void y(Activity activity, String str) {
        JSONObject parseObject = JsonTool.parseObject(str);
        int parseInt = Integer.parseInt(parseObject.getString("primaryTitle"));
        String string = parseObject.getString("secondaryTitle");
        int parseInt2 = Integer.parseInt(parseObject.getString("filter"));
        Intent l11 = k0.l(activity);
        Bundle bundle = new Bundle();
        bundle.putInt("primaryTitle", parseInt);
        bundle.putString("secondaryTitle", string);
        bundle.putInt("filter", parseInt2);
        if (parseObject.getJSONObject("title") != null) {
            String string2 = parseObject.getJSONObject("title").getString("sortType");
            String string3 = parseObject.getJSONObject("title").getString("sort");
            if (string2 != null) {
                bundle.putInt("sortType", Integer.parseInt(string2));
            }
            if (string3 != null) {
                bundle.putInt("sort", Integer.parseInt(string3));
            }
        }
        l11.putExtras(bundle);
        activity.startActivity(l11);
    }

    public final void z(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("hotWord", str);
        SearchFlutterActivity.Gi(activity, bundle);
    }
}
