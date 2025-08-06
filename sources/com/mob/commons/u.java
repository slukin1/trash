package com.mob.commons;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import java.util.HashMap;

public class u {
    public static void a(boolean z11) {
        try {
            x.a(z11);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    public static int b() {
        int d11 = x.d();
        if (d11 == 1) {
            return 1;
        }
        return d11 == 0 ? -1 : 0;
    }

    public static boolean c() {
        int b11 = b();
        if (b11 == 2 || b11 == 1) {
            return b.b();
        }
        return false;
    }

    public static boolean d() {
        int b11 = b();
        if (b11 != 2 && b11 != 1) {
            return true;
        }
        x.g();
        return true ^ b.a();
    }

    public static HashMap<String, Object> e() {
        final HashMap<String, Object>[] hashMapArr = {new HashMap<>()};
        DH.requester(MobSDK.getContext()).getCarrier().getDetailNetworkTypeForStatic().getMIUIVersion().getSignMD5().getODH().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                hashMapArr[0] = u.a(dHResponse.getDetailNetworkTypeForStatic());
                hashMapArr[0].put(s.a("006%fidcehdd%fXdj"), Integer.valueOf(MobSDK.SDK_VERSION_CODE));
                hashMapArr[0].put(s.a("004Wdcdgdidc"), e.a((MobProduct) null));
                hashMapArr[0].put(s.a("006djjFdd_fNdj"), Integer.valueOf(DH.SyncMtd.getAppVersion()));
                hashMapArr[0].put(s.a("007cd9djdjdiPf]dj"), dHResponse.getCarrier());
                hashMapArr[0].put(s.a("005>dfdkdcEfg"), DH.SyncMtd.getModel());
                hashMapArr[0].put(s.a("0073ef8dci dkdjec"), DH.SyncMtd.getManufacturer());
                hashMapArr[0].put(s.a("006'fiecfidd f5dj"), DH.SyncMtd.getOSVersionName());
                hashMapArr[0].put(s.a("005Wdgdidd+fXdj"), dHResponse.getMIUIVersion());
                hashMapArr[0].put(s.a("009SfiecfiddOf;djdi'ei"), Integer.valueOf(DH.SyncMtd.getOSVersionInt()));
                hashMapArr[0].put(s.a("010cg+di=fei@fcdidfYf"), Long.valueOf(System.currentTimeMillis()));
                hashMapArr[0].put(s.a("006djj-dfdchi"), dHResponse.getSignMD5());
                hashMapArr[0].put(s.a("005:ffdj-deBdc"), DH.SyncMtd.getBrand());
                hashMapArr[0].put("usridt", aa.c());
                hashMapArr[0].put(s.a("004<dfdkdidc"), dHResponse.getODH());
            }
        });
        return hashMapArr[0];
    }

    public static String a() {
        if (TextUtils.isEmpty(C0891r.f27321a) && MobSDK.getContext() != null) {
            C0891r.a(MobSDK.getContext());
        }
        if (TextUtils.isEmpty(C0891r.f27321a)) {
            return C0891r.f27323c;
        }
        return C0891r.f27321a;
    }

    public static HashMap<String, Object> a(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(s.a("006djj-eh)fHec"), a());
        hashMap.put(s.a("006djjjQehej"), DH.SyncMtd.getPackageName());
        hashMap.put(s.a("006djjGdd;fXdj"), DH.SyncMtd.getAppVersionName());
        hashMap.put(s.a("004jgdi"), String.valueOf(DH.SyncMtd.getPlatformCode()));
        hashMap.put(s.a("011efi[fgdkdjehVi$ec_jf"), str);
        String b11 = e.b();
        if (!TextUtils.isEmpty(b11)) {
            hashMap.put(s.a("004Mdcdgdidc"), b11);
        }
        return hashMap;
    }

    public static String a(String str, String str2, String str3, boolean z11) {
        if (!d()) {
            return i.a().a(str, str2, str3, z11);
        }
        MobLog.getInstance().d("isForb: true", new Object[0]);
        return null;
    }
}
