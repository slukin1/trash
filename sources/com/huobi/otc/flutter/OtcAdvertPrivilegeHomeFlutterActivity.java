package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class OtcAdvertPrivilegeHomeFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78441k;

    public static void Gi(Context context, int i11) {
        Intent intent = new Intent();
        intent.putExtra("entranceType", i11);
        intent.setClass(context, OtcAdvertPrivilegeHomeFlutterActivity.class);
        context.startActivity(intent);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: Fi */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ei(io.flutter.plugin.common.MethodCall r21, io.flutter.plugin.common.MethodChannel.Result r22) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = "isPrivilegeOn"
            java.lang.String r3 = "tradeType"
            java.lang.String r4 = "side"
            java.lang.String r5 = "advertId"
            java.lang.String r6 = "entranceType"
            java.lang.String r7 = r0.method     // Catch:{ Exception -> 0x0104 }
            java.lang.String r8 = "getInitData"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x0104 }
            r9 = 0
            if (r8 == 0) goto L_0x0032
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0104 }
            r0.<init>()     // Catch:{ Exception -> 0x0104 }
            android.content.Intent r2 = r20.getIntent()     // Catch:{ Exception -> 0x0104 }
            int r2 = r2.getIntExtra(r6, r9)     // Catch:{ Exception -> 0x0104 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0104 }
            r0.put(r6, r2)     // Catch:{ Exception -> 0x0104 }
            r1.success(r0)     // Catch:{ Exception -> 0x0104 }
            goto L_0x010b
        L_0x0032:
            java.lang.String r6 = "goPublish"
            boolean r6 = r7.equals(r6)     // Catch:{ Exception -> 0x0104 }
            r8 = 0
            java.lang.String r10 = "currencyName"
            java.lang.String r11 = "coinName"
            java.lang.String r12 = ""
            if (r6 == 0) goto L_0x00b4
            java.lang.Object r4 = r0.arguments     // Catch:{ Exception -> 0x0104 }
            boolean r4 = r4 instanceof java.util.Map     // Catch:{ Exception -> 0x0104 }
            if (r4 != 0) goto L_0x004b
            r22.notImplemented()     // Catch:{ Exception -> 0x0104 }
            return
        L_0x004b:
            boolean r4 = r0.hasArgument(r5)     // Catch:{ Exception -> 0x0104 }
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r0.argument(r5)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0104 }
            goto L_0x0059
        L_0x0058:
            r4 = r12
        L_0x0059:
            boolean r5 = r0.hasArgument(r11)     // Catch:{ Exception -> 0x0104 }
            if (r5 == 0) goto L_0x0068
            java.lang.Object r5 = r0.argument(r11)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0104 }
            r18 = r5
            goto L_0x006a
        L_0x0068:
            r18 = r12
        L_0x006a:
            boolean r5 = r0.hasArgument(r10)     // Catch:{ Exception -> 0x0104 }
            if (r5 == 0) goto L_0x0079
            java.lang.Object r5 = r0.argument(r10)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0104 }
            r19 = r5
            goto L_0x007b
        L_0x0079:
            r19 = r12
        L_0x007b:
            boolean r5 = r0.hasArgument(r3)     // Catch:{ Exception -> 0x0104 }
            if (r5 == 0) goto L_0x008e
            java.lang.Object r3 = r0.argument(r3)     // Catch:{ Exception -> 0x0104 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0104 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0104 }
            r16 = r3
            goto L_0x0090
        L_0x008e:
            r16 = r9
        L_0x0090:
            boolean r3 = r0.hasArgument(r2)     // Catch:{ Exception -> 0x0104 }
            if (r3 == 0) goto L_0x00a0
            java.lang.Object r0 = r0.argument(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0104 }
            boolean r9 = r0.booleanValue()     // Catch:{ Exception -> 0x0104 }
        L_0x00a0:
            r17 = r9
            uf.b r13 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x0104 }
            if (r4 != 0) goto L_0x00aa
            r15 = r12
            goto L_0x00ab
        L_0x00aa:
            r15 = r4
        L_0x00ab:
            r14 = r20
            r13.r(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x0104 }
            r1.success(r8)     // Catch:{ Exception -> 0x0104 }
            goto L_0x010b
        L_0x00b4:
            java.lang.String r2 = "privilegeFilter"
            boolean r2 = r7.equals(r2)     // Catch:{ Exception -> 0x0104 }
            if (r2 == 0) goto L_0x0100
            java.lang.Object r2 = r0.arguments     // Catch:{ Exception -> 0x0104 }
            boolean r2 = r2 instanceof java.util.Map     // Catch:{ Exception -> 0x0104 }
            if (r2 != 0) goto L_0x00c6
            r22.notImplemented()     // Catch:{ Exception -> 0x0104 }
            return
        L_0x00c6:
            boolean r2 = r0.hasArgument(r4)     // Catch:{ Exception -> 0x0104 }
            if (r2 == 0) goto L_0x00d3
            java.lang.Object r2 = r0.argument(r4)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0104 }
            goto L_0x00d5
        L_0x00d3:
            java.lang.String r2 = "buy"
        L_0x00d5:
            boolean r3 = r0.hasArgument(r10)     // Catch:{ Exception -> 0x0104 }
            if (r3 == 0) goto L_0x00e2
            java.lang.Object r3 = r0.argument(r10)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0104 }
            goto L_0x00e3
        L_0x00e2:
            r3 = r12
        L_0x00e3:
            boolean r4 = r0.hasArgument(r11)     // Catch:{ Exception -> 0x0104 }
            if (r4 == 0) goto L_0x00f0
            java.lang.Object r0 = r0.argument(r11)     // Catch:{ Exception -> 0x0104 }
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0104 }
        L_0x00f0:
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.d()     // Catch:{ Exception -> 0x0104 }
            com.huobi.otc.flutter.OtcAdvertPrivilegeFilterEvent r4 = new com.huobi.otc.flutter.OtcAdvertPrivilegeFilterEvent     // Catch:{ Exception -> 0x0104 }
            r4.<init>(r2, r3, r12)     // Catch:{ Exception -> 0x0104 }
            r0.k(r4)     // Catch:{ Exception -> 0x0104 }
            r1.success(r8)     // Catch:{ Exception -> 0x0104 }
            goto L_0x010b
        L_0x0100:
            r1.success(r8)     // Catch:{ Exception -> 0x0104 }
            goto L_0x010b
        L_0x0104:
            r0 = move-exception
            r0.printStackTrace()
            r22.notImplemented()
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.flutter.OtcAdvertPrivilegeHomeFlutterActivity.Ei(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public String Nh() {
        return "otc_advert_privilege_home";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_privilege_home_channel");
        this.f78441k = methodChannel;
        methodChannel.setMethodCallHandler(new m(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        getWindow().addFlags(67108864);
    }

    public void onStop() {
        super.onStop();
        getWindow().clearFlags(67108864);
    }
}
