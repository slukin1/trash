package com.jumio.core.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.adjust.sdk.Constants;
import com.jumio.commons.log.Log;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.persistence.DataManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import jumio.core.b;
import jumio.core.m2;
import kotlin.Pair;
import kotlin.jvm.internal.x;

public final class DataPointsUtil {
    public static final DataPointsUtil INSTANCE = new DataPointsUtil();
    public static final String NUMBER_OF_CANCELS = "Jumio05";
    public static final String NUMBER_OF_RETAKES = "Jumio03";
    public static final String NUMBER_OF_VERIFICATIONS = "Jumio04";

    public static List a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            String[] strArr = packageInfo.requestedPermissions;
            ArrayList arrayList = new ArrayList();
            int length = strArr.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                String str = strArr[i11];
                int i13 = i12 + 1;
                if ((packageInfo.requestedPermissionsFlags[i12] & 2) != 0) {
                    arrayList.add(str);
                }
                i11++;
                i12 = i13;
            }
            return arrayList;
        } catch (Exception e11) {
            Log.w("DataPointsUtil", (Throwable) e11);
            return CollectionsKt__CollectionsKt.k();
        }
    }

    public static Pair b(Context context) {
        int i11;
        int i12 = 0;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i11 = displayMetrics.widthPixels;
            try {
                i12 = displayMetrics.heightPixels;
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Exception e12) {
            e = e12;
            i11 = 0;
            Log.printStackTrace(e);
            return new Pair(Integer.valueOf(i11), Integer.valueOf(i12));
        }
        return new Pair(Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public final void collect(Context context, DataManager dataManager) {
        String str;
        String str2;
        SettingsModel settingsModel = (SettingsModel) dataManager.get(SettingsModel.class);
        if (settingsModel.isAdditionalDataPointsEnabled()) {
            b bVar = (b) dataManager.get(b.class);
            try {
                Pair b11 = b(context);
                boolean a11 = m2.a(context);
                int offset = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / Constants.ONE_HOUR;
                Locale locale = LocaleUtil.INSTANCE.getLocale(context);
                if (locale != null) {
                    String locale2 = locale.toString();
                    str = LocaleUtilKt.getAlpha3Country(locale);
                    str2 = locale2;
                } else {
                    str2 = "";
                    str = str2;
                }
                bVar.a(str2, ((Number) b11.getFirst()).intValue(), ((Number) b11.getSecond()).intValue(), offset, a11, str, settingsModel.getCountryForIp(), settingsModel.getStateForIp(), a(context));
            } catch (Exception e11) {
                Log.e("Failed to build analytics data points model", (Throwable) e11);
            }
        }
    }

    public final int get(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("Jumio01", 0)) == null) {
            return 0;
        }
        return sharedPreferences.getInt(str, 0);
    }

    public final String getDeviceId(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("Jumio01", 0);
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("Jumio02", (String) null);
        }
        if (str == null || x.b(str, "")) {
            str = UUID.randomUUID().toString();
        }
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("Jumio02", str);
            edit.apply();
        }
        return str;
    }

    public final long getSecondsInSdk(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("Jumio01", 0)) == null) {
            return -1;
        }
        return sharedPreferences.getLong("Jumio06", -1);
    }

    public final void increment(Context context, String str) {
        DataPointsUtil dataPointsUtil = INSTANCE;
        dataPointsUtil.set(context, str, dataPointsUtil.get(context, str) + 1);
    }

    public final void set(Context context, String str, int i11) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences("Jumio01", 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i11);
            edit.apply();
        }
    }

    public final void setSecondsInSdk(Context context, long j11) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences("Jumio01", 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("Jumio06", j11);
            edit.apply();
        }
    }
}
