package com.adjust.sdk.sig;

import android.content.Context;
import android.util.Log;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.security.InvalidKeyException;
import java.security.UnrecoverableKeyException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13979a = false;

    public static void a(Set set, Map map, Map map2) {
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (map.containsKey(str)) {
                map2.put(str, (String) map.get(str));
            }
        }
    }

    public static void a(Context context, c cVar, a aVar, Map map, String str, String str2) {
        if (f13979a) {
            Log.e("SignerInstance", "sign: library received error. It has locked down");
        } else if (map == null || map.size() == 0 || str == null || str2 == null) {
            Log.e("SignerInstance", "sign: One or more parameters are null");
        } else {
            map.put("activity_kind", str);
            map.put("client_sdk", str2);
            byte[] bArr = null;
            int i11 = 2;
            while (true) {
                if (i11 <= 0) {
                    break;
                }
                try {
                    cVar.b(context);
                    bArr = cVar.a(context, map.toString().getBytes("UTF-8"));
                    break;
                } catch (b e11) {
                    Log.e("SignerInstance", "sign: Api is less than JellyBean-4-18");
                    f13979a = true;
                    map.remove("activity_kind");
                    map.remove("client_sdk");
                    throw e11;
                } catch (InvalidKeyException | UnrecoverableKeyException e12) {
                    Log.e("SignerInstance", "sign: Received a retriable exception: " + e12.getMessage(), e12);
                    Log.e("SignerInstance", "sign: Attempting retry #" + i11);
                    i11 += -1;
                    cVar.a(context);
                } catch (Exception e13) {
                    Log.e("SignerInstance", "sign: Received an Exception: " + e13.getMessage(), e13);
                    map.remove("activity_kind");
                    map.remove("client_sdk");
                    throw e13;
                }
            }
            if (i11 == 0) {
                f13979a = true;
                map.remove("activity_kind");
                map.remove("client_sdk");
                return;
            }
            byte[] a11 = ((NativeLibHelper) aVar).a(context, map, bArr, cVar.f13978a);
            if (a11 == null) {
                Log.e("SignerInstance", "sign: Returned an null signature. Exiting...");
                map.remove("activity_kind");
                map.remove("client_sdk");
                return;
            }
            int length = a11.length;
            char[] cArr = e.f13980a;
            char[] cArr2 = new char[(length * 2)];
            for (int i12 = 0; i12 < length; i12++) {
                byte b11 = a11[i12];
                int i13 = i12 * 2;
                char[] cArr3 = e.f13980a;
                cArr2[i13] = cArr3[(b11 & 255) >>> 4];
                cArr2[i13 + 1] = cArr3[b11 & 15];
            }
            map.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, new String(cArr2));
            map.remove("activity_kind");
            map.remove("client_sdk");
        }
    }
}
