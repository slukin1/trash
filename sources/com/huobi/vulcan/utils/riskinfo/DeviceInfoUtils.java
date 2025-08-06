package com.huobi.vulcan.utils.riskinfo;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huobi.vulcan.core.SecurityKey;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfoUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f20633a = "DeviceInfoUtils";

    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("gsm.version.baseband", Build.getRadioVersion());
        hashMap.put(TPSystemInfo.KEY_PROPERTY_BOARD, Build.BOARD);
        hashMap.put("ro.bootloader", Build.BOOTLOADER);
        hashMap.put(SystemUtils.PRODUCT_BRAND, Build.BRAND);
        hashMap.put(TPSystemInfo.KEY_PROPERTY_DEVICE, Build.DEVICE);
        hashMap.put("ro.build.display.id", Build.DISPLAY);
        hashMap.put("ro.build.fingerprint", Build.FINGERPRINT);
        hashMap.put("ro.hardware", Build.HARDWARE);
        hashMap.put("ro.build.host", Build.HOST);
        hashMap.put("ro.build.id", Build.ID);
        hashMap.put(TPSystemInfo.KEY_PROPERTY_MANUFACTURER, Build.MANUFACTURER);
        hashMap.put(TPSystemInfo.KEY_PROPERTY_MODEL, Build.MODEL);
        hashMap.put("ro.product.name", Build.PRODUCT);
        hashMap.put("ro.build.tags", Build.TAGS);
        hashMap.put("ro.build.type", Build.TYPE);
        hashMap.put("ro.build.user", Build.USER);
        return hashMap;
    }

    public static String b(String str) {
        String h11 = h(str);
        if (!TextUtils.isEmpty(h11)) {
            return h11;
        }
        String j11 = j(str);
        if (!TextUtils.isEmpty(j11)) {
            return j11;
        }
        String i11 = i(str);
        return TextUtils.isEmpty(i11) ? "" : i11;
    }

    public static String c(String str, String str2) {
        String b11 = b(str);
        if (TextUtils.isEmpty(b11)) {
            return TextUtils.isEmpty(str2) ? "" : str2;
        }
        return b11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        r0 = "unknow";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        r2.release();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 18
            if (r0 >= r2) goto L_0x0009
            return r1
        L_0x0009:
            java.util.UUID r0 = new java.util.UUID
            r2 = -1301668207276963122(0xedef8ba979d64ace, double:-3.563403477674908E221)
            r4 = -6645017420763422227(0xa3c827dcd51d21ed, double:-2.5964014370906125E-136)
            r0.<init>(r2, r4)
            java.lang.String r2 = f20633a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "uuid_0 = "
            r3.append(r4)
            java.lang.String r4 = r0.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r2, r3)
            r2 = 0
            r3 = 28
            android.media.MediaDrm r4 = new android.media.MediaDrm     // Catch:{ Exception -> 0x0087, all -> 0x0078 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0087, all -> 0x0078 }
            java.lang.String r0 = "deviceUniqueId"
            byte[] r0 = r4.getPropertyByteArray(r0)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            java.lang.String r1 = com.huobi.vulcan.utils.riskinfo.Utils.a(r0)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            java.lang.String r0 = "securityLevel"
            java.lang.String r0 = r4.getPropertyString(r0)     // Catch:{ Exception -> 0x004b, all -> 0x0073 }
            goto L_0x004d
        L_0x004b:
            java.lang.String r0 = "unknow"
        L_0x004d:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            if (r2 != 0) goto L_0x0067
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            r2.<init>()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            r2.append(r0)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            java.lang.String r0 = ","
            r2.append(r0)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            r2.append(r1)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
        L_0x0067:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x006f
            r4.close()
            goto L_0x0094
        L_0x006f:
            r4.release()
            goto L_0x0094
        L_0x0073:
            r0 = move-exception
            r2 = r4
            goto L_0x0079
        L_0x0076:
            r2 = r4
            goto L_0x0087
        L_0x0078:
            r0 = move-exception
        L_0x0079:
            if (r2 == 0) goto L_0x0086
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r3) goto L_0x0083
            r2.close()
            goto L_0x0086
        L_0x0083:
            r2.release()
        L_0x0086:
            throw r0
        L_0x0087:
            if (r2 == 0) goto L_0x0094
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x0091
            r2.close()
            goto L_0x0094
        L_0x0091:
            r2.release()
        L_0x0094:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.riskinfo.DeviceInfoUtils.d():java.lang.String");
    }

    public static String e() {
        return new UUID((long) ("35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10)).hashCode(), (long) Build.getRadioVersion().hashCode()).toString();
    }

    public static Map<String, String> f() {
        HashMap<String, String> a11 = a();
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        for (Map.Entry next : a11.entrySet()) {
            hashSet.clear();
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            String h11 = h(str);
            String i11 = i(str);
            if (!TextUtils.isEmpty(str2)) {
                hashSet.add(str2);
            }
            if (!TextUtils.isEmpty(h11)) {
                hashSet.add(h11);
            }
            if (!TextUtils.isEmpty(i11)) {
                hashSet.add(i11);
            }
            if (!hashSet.isEmpty() && hashSet.size() != 1) {
                String str3 = "";
                if (hashSet.contains(h11)) {
                    str3 = str3 + "native=" + h11 + ", ";
                }
                if (hashSet.contains(i11)) {
                    str3 = str3 + "reflect=" + i11 + ", ";
                }
                if (hashSet.contains(str2)) {
                    str3 = str3 + "build=" + str2 + ", ";
                }
                if (str3.length() > 2) {
                    hashMap.put(str, str3.substring(0, str3.length() - 2));
                }
            }
        }
        return hashMap;
    }

    public static String g(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (String next : hashMap.keySet()) {
            try {
                jSONObject.put(next, hashMap.get(next));
            } catch (JSONException e11) {
                e11.printStackTrace();
                return "";
            }
        }
        return jSONObject.toString();
    }

    public static String h(String str) {
        String jspg = SecurityKey.jspg(str);
        return TextUtils.isEmpty(jspg) ? "" : jspg;
    }

    public static String i(String str) {
        try {
            return Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str}).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String j(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod("native_get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, new Object[]{str});
        } catch (Exception unused) {
            return "";
        }
    }
}
