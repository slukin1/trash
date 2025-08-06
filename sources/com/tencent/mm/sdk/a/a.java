package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.e;
import com.tencent.mm.sdk.constants.ConstantsAPI;

public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    public static class C0179a {
        public int flags = -1;

        /* renamed from: k  reason: collision with root package name */
        public String f22723k;

        /* renamed from: l  reason: collision with root package name */
        public String f22724l;

        /* renamed from: m  reason: collision with root package name */
        public String f22725m;

        /* renamed from: n  reason: collision with root package name */
        public Bundle f22726n;
    }

    public static boolean a(Context context, C0179a aVar) {
        if (context == null || aVar == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (e.j(aVar.f22723k)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + aVar.f22723k);
            return false;
        } else {
            if (e.j(aVar.f22724l)) {
                aVar.f22724l = aVar.f22723k + ".wxapi.WXEntryActivity";
            }
            com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + aVar.f22723k + ", targetClassName = " + aVar.f22724l);
            Intent intent = new Intent();
            intent.setClassName(aVar.f22723k, aVar.f22724l);
            Bundle bundle = aVar.f22726n;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 570490883);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.f22725m);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(aVar.f22725m, 570490883, packageName));
            int i11 = aVar.flags;
            if (i11 == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(i11);
            }
            try {
                context.startActivity(intent);
                com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
                return true;
            } catch (Exception e11) {
                com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e11.getMessage());
                return false;
            }
        }
    }
}
