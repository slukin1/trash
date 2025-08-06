package com.tencent.android.tpush;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.crosssp.ProviderMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68095a = XGPushProvider.AUTH_PRIX;

    /* renamed from: b  reason: collision with root package name */
    private static ReentrantLock f68096b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, String> f68097c = new HashMap();

    public static synchronized Map<String, ProviderInfo> a(Context context) {
        HashMap hashMap;
        synchronized (a.class) {
            hashMap = new HashMap();
            try {
                for (ProviderInfo next : context.getPackageManager().queryContentProviders((String) null, 0, 0)) {
                    if (next.name.equals(XGPushProvider.class.getName()) && next.authority.equals(a(next.packageName))) {
                        hashMap.put(next.packageName, next);
                        TLogger.d("ProviderUtils", "get local XG App list:" + next.authority + Constants.ACCEPT_TIME_SEPARATOR_SP + next.packageName + Constants.ACCEPT_TIME_SEPARATOR_SP + next.name);
                    }
                }
            } catch (Throwable th2) {
                TLogger.e("ProviderUtils", "Package manager has died", th2);
            }
        }
        return hashMap;
    }

    public static void b(Context context, String str, String str2) {
        Uri parse = Uri.parse("content://" + str + XGPushProvider.AUTH_PRIX + "/" + TypeStr.feedback.getStr());
        ContentValues contentValues = new ContentValues();
        contentValues.put("feedback", Rijndael.encrypt(str2));
        try {
            ProviderMessage.update(context, parse, contentValues, (String) null, (String[]) null);
        } catch (Throwable th2) {
            TLogger.e("ProviderUtils", "error : ", th2);
        }
    }

    public static void c(Context context) {
        a(context, TypeStr.hearbeat_cyclecheck.getStr());
    }

    public static Map<Long, RegisterEntity> d(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(context);
        if (currentAppRegisterEntity != null) {
            concurrentHashMap.put(Long.valueOf(currentAppRegisterEntity.accessId), currentAppRegisterEntity);
        }
        return concurrentHashMap;
    }

    public static void b(Context context) {
        a(context, TypeStr.hearbeat.getStr());
    }

    public static String a(String str) {
        return str + f68095a;
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str2);
            ProviderMessage.insert(context, Uri.parse("content://" + str + XGPushProvider.AUTH_PRIX + "/" + TypeStr.msg.getStr()), contentValues);
            return true;
        } catch (Throwable th2) {
            TLogger.e("ProviderUtils", "sendMsgByPkgName", th2);
            ServiceStat.reportErrCode(context, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "sendMsgByPkgName err:" + Util.getThrowableToString(th2), 0, ErrCode.ERROR_INNER_TYPE);
            return false;
        }
    }

    public static boolean a(Context context, String str, Intent intent) {
        return a(context, str, intent.toURI());
    }

    private static void a(Context context, String str) {
        if (str != null) {
            try {
                ProviderMessage.getType(context, Uri.parse("content://" + context.getPackageName() + XGPushProvider.AUTH_PRIX + "/" + str));
            } catch (Throwable th2) {
                TLogger.e("ProviderUtils", "heartbeat Provider error", th2);
            }
        }
    }
}
