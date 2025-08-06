package com.alibaba.sdk.android.tbrest.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.ta.utdid2.device.UTDevice;
import d3.a;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Random;

public class DeviceUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f14745a;

    /* renamed from: b  reason: collision with root package name */
    public static String f14746b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f14747c = {AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN};

    /* renamed from: d  reason: collision with root package name */
    public static String f14748d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f14749e = null;

    public static byte[] a(int i11) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i11 % 256);
        int i12 = i11 >> 8;
        bArr[2] = (byte) (i12 % 256);
        int i13 = i12 >> 8;
        bArr[1] = (byte) (i13 % 256);
        bArr[0] = (byte) ((i13 >> 8) % 256);
        return bArr;
    }

    public static String b(Context context) {
        try {
            String str = f14746b;
            if (str != null) {
                return str;
            }
            String networkOperatorName = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkOperatorName();
            f14746b = networkOperatorName;
            return networkOperatorName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Exception e11) {
            LogUtil.c("get country error ", e11);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0058, code lost:
        if (r0 != null) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0048 A[SYNTHETIC, Splitter:B:29:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004d A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0055 A[SYNTHETIC, Splitter:B:39:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d() {
        /*
            java.lang.String r0 = f14745a
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r0 = "/proc/cpuinfo"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ IOException -> 0x0051, all -> 0x0042 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0051, all -> 0x0042 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0040, all -> 0x003b }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0040, all -> 0x003b }
        L_0x0012:
            java.lang.String r3 = r0.readLine()     // Catch:{ IOException -> 0x0053, all -> 0x0039 }
            if (r3 == 0) goto L_0x0032
            java.lang.String r4 = "Hardware"
            boolean r4 = r3.contains(r4)     // Catch:{ IOException -> 0x0053, all -> 0x0039 }
            if (r4 == 0) goto L_0x0012
            java.lang.String r4 = ":"
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ IOException -> 0x0053, all -> 0x0039 }
            r4 = 1
            r3 = r3[r4]     // Catch:{ IOException -> 0x0053, all -> 0x0039 }
            f14745a = r3     // Catch:{ IOException -> 0x0053, all -> 0x0039 }
            r2.close()     // Catch:{ Exception -> 0x0031 }
            r0.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            return r3
        L_0x0032:
            r2.close()     // Catch:{ Exception -> 0x005b }
        L_0x0035:
            r0.close()     // Catch:{ Exception -> 0x005b }
            goto L_0x005b
        L_0x0039:
            r1 = move-exception
            goto L_0x0046
        L_0x003b:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0046
        L_0x0040:
            r0 = r1
            goto L_0x0053
        L_0x0042:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L_0x0046:
            if (r2 == 0) goto L_0x004b
            r2.close()     // Catch:{ Exception -> 0x0050 }
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            throw r1
        L_0x0051:
            r0 = r1
            r2 = r0
        L_0x0053:
            if (r2 == 0) goto L_0x0058
            r2.close()     // Catch:{ Exception -> 0x005b }
        L_0x0058:
            if (r0 == 0) goto L_0x005b
            goto L_0x0035
        L_0x005b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.tbrest.utils.DeviceUtils.d():java.lang.String");
    }

    public static String e(Context context) {
        String str = f14749e;
        if (str != null) {
            return str;
        }
        String k11 = k();
        f14749e = k11;
        return k11;
    }

    public static String f(Context context) {
        String str = f14748d;
        if (str != null) {
            return str;
        }
        StringUtils.d(str);
        String k11 = k();
        f14748d = k11;
        return k11;
    }

    public static String g() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e11) {
            LogUtil.c("get country error ", e11);
            return null;
        }
    }

    public static String h(int i11) {
        if (i11 == 20) {
            return "5G";
        }
        switch (i11) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static String[] i(Context context) {
        if (context == null) {
            return f14747c;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return f14747c;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return f14747c;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return f14747c;
            }
            if (activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    String[] strArr = f14747c;
                    strArr[0] = "Wi-Fi";
                    return strArr;
                } else if (activeNetworkInfo.getType() == 0) {
                    if (m((TelephonyManager) context.getSystemService(PlaceFields.PHONE))) {
                        f14747c[0] = "5G";
                    } else {
                        f14747c[0] = h(activeNetworkInfo.getSubtype());
                    }
                    String[] strArr2 = f14747c;
                    strArr2[1] = activeNetworkInfo.getSubtypeName();
                    return strArr2;
                }
            }
            return f14747c;
        } catch (Throwable unused) {
        }
    }

    public static String j(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i11 = displayMetrics.widthPixels;
            int i12 = displayMetrics.heightPixels;
            if (i11 > i12) {
                int i13 = i11 ^ i12;
                i12 ^= i13;
                i11 = i13 ^ i12;
            }
            return i12 + "*" + i11;
        } catch (Exception e11) {
            LogUtil.c("DeviceUtils getResolution: error", e11);
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static String k() {
        try {
            int nextInt = new Random().nextInt();
            int nextInt2 = new Random().nextInt();
            byte[] a11 = a((int) (System.currentTimeMillis() / 1000));
            byte[] a12 = a((int) System.nanoTime());
            byte[] a13 = a(nextInt);
            byte[] a14 = a(nextInt2);
            byte[] bArr = new byte[16];
            System.arraycopy(a11, 0, bArr, 0, 4);
            System.arraycopy(a12, 0, bArr, 4, 4);
            System.arraycopy(a13, 0, bArr, 8, 4);
            System.arraycopy(a14, 0, bArr, 12, 4);
            return a.g(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String l(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Exception e11) {
            LogUtil.c("get utdid error ", e11);
            return null;
        }
    }

    public static boolean m(TelephonyManager telephonyManager) {
        try {
            Object invoke = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getServiceState", new Class[0]).invoke(telephonyManager, new Object[0]);
            Method[] declaredMethods = Class.forName(invoke.getClass().getName()).getDeclaredMethods();
            int length = declaredMethods.length;
            int i11 = 0;
            while (i11 < length) {
                Method method = declaredMethods[i11];
                if (!method.getName().equals("getNrStatus")) {
                    if (!method.getName().equals("getNrState")) {
                        i11++;
                    }
                }
                method.setAccessible(true);
                if (((Integer) method.invoke(invoke, new Object[0])).intValue() == 3) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
