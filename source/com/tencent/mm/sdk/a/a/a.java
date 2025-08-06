package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.e;
import com.tencent.mm.sdk.constants.ConstantsAPI;

public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a.a$a  reason: collision with other inner class name */
    public static class C0180a {

        /* renamed from: m  reason: collision with root package name */
        public String f22727m;

        /* renamed from: n  reason: collision with root package name */
        public Bundle f22728n;

        /* renamed from: o  reason: collision with root package name */
        public String f22729o;

        /* renamed from: p  reason: collision with root package name */
        public String f22730p;
    }

    public static boolean a(Context context, C0180a aVar) {
        String str;
        if (context == null || aVar == null) {
            str = "send fail, invalid argument";
        } else if (e.j(aVar.f22730p)) {
            str = "send fail, action is null";
        } else {
            String str2 = null;
            if (!e.j(aVar.f22729o)) {
                str2 = aVar.f22729o + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(aVar.f22730p);
            Bundle bundle = aVar.f22728n;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 570490883);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.f22727m);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(aVar.f22727m, 570490883, packageName));
            context.sendBroadcast(intent, str2);
            com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
            return true;
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
