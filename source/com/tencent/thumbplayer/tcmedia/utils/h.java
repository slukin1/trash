package com.tencent.thumbplayer.tcmedia.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.facebook.places.model.PlaceFields;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static int f49702a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f49703b = false;

    /* renamed from: c  reason: collision with root package name */
    private static int f49704c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f49705d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f49705d = sparseIntArray;
        sparseIntArray.put(1, 1);
        sparseIntArray.put(2, 1);
        sparseIntArray.put(4, 1);
        sparseIntArray.put(7, 1);
        sparseIntArray.put(11, 1);
        sparseIntArray.put(3, 2);
        sparseIntArray.put(5, 2);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(8, 2);
        sparseIntArray.put(9, 2);
        sparseIntArray.put(10, 2);
        sparseIntArray.put(12, 2);
        sparseIntArray.put(14, 2);
        sparseIntArray.put(15, 2);
        sparseIntArray.put(13, 3);
    }

    public static int a(Context context) {
        int i11 = f49702a;
        if (i11 > 0 && !f49703b) {
            return i11;
        }
        if (context == null) {
            return -1;
        }
        int g11 = g(context);
        f49702a = g11;
        return g11;
    }

    private static int a(Context context, int i11) {
        return Build.VERSION.SDK_INT >= 29 ? h(context) : b(context, i11);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean a(Context context, String str) {
        boolean z11 = true;
        if (!a()) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("android.permission.WRITE_SETTINGS".equals(str)) {
            return Settings.System.canWrite(context);
        }
        try {
            if (context.checkSelfPermission(str) != 0) {
                z11 = false;
            }
            return z11;
        } catch (Exception e11) {
            TPLogUtil.e("TPNetWorkUtils", e11.getMessage());
            return false;
        }
    }

    private static int b(Context context, int i11) {
        if (d(context) == 20) {
            TPLogUtil.i("TPNetWorkUtils", "get5GNetworkTypeIfNeed netWorkType==4");
            return 4;
        }
        Integer valueOf = Integer.valueOf(f49705d.get(i11));
        if (valueOf == null) {
            return -1;
        }
        return valueOf.intValue();
    }

    public static void b(Context context) {
        f49703b = true;
        c(context);
        a(context);
        f49703b = false;
    }

    public static boolean c(Context context) {
        int i11 = f49704c;
        if (i11 != -1 && !f49703b) {
            return i11 == 1;
        }
        if (context != null) {
            try {
                NetworkInfo f11 = f(context);
                f49704c = 0;
                if (f11 != null && f11.getState() == NetworkInfo.State.CONNECTED) {
                    f49704c = 1;
                }
            } catch (Exception e11) {
                TPLogUtil.e("TPNetWorkUtils", e11.getMessage());
            }
        }
        return f49704c == 1;
    }

    private static int d(Context context) {
        int i11 = 0;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (telephonyManager == null) {
                TPLogUtil.e("TPNetWorkUtils", "get5GNetworkTypeIfNeed TelephonyManager is null");
                return 0;
            } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                TPLogUtil.e("TPNetWorkUtils", "get5GNetworkTypeIfNeed no permission");
                return 0;
            } else if (Build.VERSION.SDK_INT < 29) {
                TPLogUtil.e("TPNetWorkUtils", "get5GNetworkTypeIfNeed less api 29");
                return 0;
            } else {
                int networkType = telephonyManager.getNetworkType();
                if (networkType != 13) {
                    try {
                        TPLogUtil.i("TPNetWorkUtils", "get5GNetworkTypeIfNeed not NETWORK_TYPE_LTE");
                        return networkType;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        i11 = networkType;
                        th = th3;
                        TPLogUtil.e("TPNetWorkUtils", th.getMessage());
                        return i11;
                    }
                } else {
                    ServiceState serviceState = telephonyManager.getServiceState();
                    if (serviceState == null) {
                        TPLogUtil.e("TPNetWorkUtils", "get5GNetworkTypeIfNeed serviceState is null");
                        return networkType;
                    }
                    int intValue = ((Integer) k.a(serviceState, "android.telephony.ServiceState", "getNrState", new Class[0], new Object[0])).intValue();
                    if (intValue != 2 && intValue != 3) {
                        return networkType;
                    }
                    i11 = 20;
                    TPLogUtil.i("TPNetWorkUtils", "get5GNetworkTypeIfNeed networkType is 20, 5G");
                    return i11;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static ConnectivityManager e(Context context) {
        if (context == null) {
            return null;
        }
        return (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
    }

    private static NetworkInfo f(Context context) {
        ConnectivityManager e11 = e(context);
        if (e11 == null) {
            return null;
        }
        return e11.getActiveNetworkInfo();
    }

    private static int g(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return -1;
            }
            int type = activeNetworkInfo.getType();
            return type != 0 ? type != 1 ? -1 : 0 : a(context, activeNetworkInfo.getSubtype());
        } catch (Throwable th2) {
            TPLogUtil.e("TPNetWorkUtils", th2.getMessage());
            return -1;
        }
    }

    private static int h(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                return b(context, telephonyManager.getDataNetworkType());
            }
            TPLogUtil.e("TPNetWorkUtils", "getNetWorkClassAPI29 fail: no phone permission");
            return -1;
        } catch (Throwable th2) {
            TPLogUtil.e("TPNetWorkUtils", th2.getMessage());
            return -1;
        }
    }
}
