package com.tencent.android.tpush.service.cache;

import android.content.Context;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.MobileType;
import com.tencent.android.tpush.common.e;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.channel.exception.NullReturnException;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CacheManager {
    private CacheManager() {
    }

    public static void UninstallInfoByPkgName(String str) {
        a(str, (byte) 2);
    }

    public static void UninstallInfoSuccessByPkgName(String str) {
        a(str, (byte) 4);
    }

    public static void UnregisterInfoByPkgName(String str) {
        a(str, (byte) 1);
    }

    public static void UnregisterInfoSuccessByPkgName(String str) {
        a(str, (byte) 3);
    }

    private static void a(String str) {
    }

    private static void a(String str, byte b11) {
        if (!j.b(str)) {
            for (Map.Entry<Long, RegisterEntity> value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && !j.b(registerEntity.packageName) && str.equals(registerEntity.packageName)) {
                    registerEntity.state = b11;
                }
            }
        }
    }

    public static void addRegisterInfo(RegisterEntity registerEntity) {
        if (registerEntity != null && registerEntity.accessId > 0) {
            getRegisterEntityMap().put(Long.valueOf(registerEntity.accessId), registerEntity);
        }
    }

    public static void clearDomainServerItem(Context context) {
        ArrayList<String> arrayList;
        try {
            arrayList = getDomainKeyList(context);
        } catch (NullReturnException unused) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(String.valueOf(MobileType.CHINAMOBILE.getType()));
        arrayList.add(String.valueOf(MobileType.TELCOM.getType()));
        arrayList.add(String.valueOf(MobileType.UNICOM.getType()));
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                PushPreferences.putString(context, it2.next() + ".com.tencent.tpush.cache.server", "");
            } catch (Throwable th2) {
                TLogger.e("CacheManager", "", th2);
            }
        }
    }

    public static void clearTokenCache() {
        GuidInfoManager.clearTokenCache();
    }

    public static String findValidPackageByAccessid(long j11) {
        RegisterEntity registerEntity = getRegisterEntityMap().get(Long.valueOf(j11));
        if (registerEntity == null || !registerEntity.isRegistered()) {
            return null;
        }
        return registerEntity.packageName;
    }

    public static RegisterEntity findValidRegisterEntityByPkg(String str) {
        if (j.b(str)) {
            return null;
        }
        for (Map.Entry<Long, RegisterEntity> value : getRegisterEntityMap().entrySet()) {
            RegisterEntity registerEntity = (RegisterEntity) value.getValue();
            if (registerEntity != null && str.equals(registerEntity.packageName)) {
                return registerEntity;
            }
        }
        return null;
    }

    public static Context getContext() {
        if (b.e() != null) {
            return b.e();
        }
        return XGPushManager.getContext();
    }

    public static RegisterEntity getCurrentAppRegisterEntity(Context context) {
        String string = PushPreferences.getString(context, a("cur.register", ".reg"), "");
        if (!j.b(string)) {
            return RegisterEntity.decode(string);
        }
        return null;
    }

    public static String getDomain(Context context) {
        if (context != null) {
            PushPreferences.getString(context, ".com.tencent.tpush.cache.domain", "");
        }
        return "";
    }

    public static ArrayList<String> getDomainKeyList(Context context) {
        if (context != null) {
            try {
                Object a11 = e.a(Rijndael.decrypt(PushPreferences.getString(context, ".com.tencent.tpush.cache.domain.key", "")));
                if (a11 instanceof ArrayList) {
                    return (ArrayList) a11;
                }
                throw new NullReturnException("getDomainKeyList return null,because object not instance of ArrayList<?>");
            } catch (Exception e11) {
                throw new NullReturnException("getDomainKeyList return null，deseriallize err", e11);
            }
        } else {
            throw new NullReturnException("getDomainKeyList return null,because ctx is null");
        }
    }

    public static long getGuid(Context context) {
        return GuidInfoManager.getGuid(context);
    }

    public static String getQua(Context context, long j11) {
        if (context == null) {
            return "";
        }
        return Rijndael.decrypt(PushPreferences.getString(context, ".com.tencent.tpush.cache.qua." + j11, ""));
    }

    public static Map<Long, RegisterEntity> getRegInfoByApps(Context context) {
        a aVar = new a(context);
        try {
            Thread thread = new Thread(aVar);
            thread.start();
            thread.join(3500);
        } catch (Throwable th2) {
            TLogger.e("CacheManager", th2.toString());
        }
        return aVar.a();
    }

    public static synchronized Map<Long, RegisterEntity> getRegisterEntityMap() {
        Map<Long, RegisterEntity> regInfoByApps;
        synchronized (CacheManager.class) {
            regInfoByApps = getRegInfoByApps(getContext());
        }
        return regInfoByApps;
    }

    public static List<RegisterEntity> getRegisterInfo(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context != null) {
            for (Map.Entry<Long, RegisterEntity> value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && registerEntity.isRegistered()) {
                    arrayList.add(registerEntity);
                }
            }
        }
        return arrayList;
    }

    public static RegisterEntity getRegisterInfoByPkgName(String str) {
        return findValidRegisterEntityByPkg(str);
    }

    public static List<String> getRegisterInfos(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<Long, RegisterEntity> value : getRegisterEntityMap().entrySet()) {
                RegisterEntity registerEntity = (RegisterEntity) value.getValue();
                if (registerEntity != null && !j.b(registerEntity.packageName) && registerEntity.isRegistered()) {
                    arrayList.add(registerEntity.packageName);
                }
            }
        } catch (Throwable th2) {
            TLogger.e("CacheManager", "", th2);
            arrayList = new ArrayList();
        }
        if (!arrayList.contains(context.getPackageName())) {
            arrayList.add(context.getPackageName());
        }
        return arrayList;
    }

    public static String getToken(Context context) {
        return GuidInfoManager.getToken(context);
    }

    public static void removeRegisterInfoByPkgName(String str) {
        a(str);
    }

    public static void removeRegisterInfos(String str) {
        a(str, (byte) 1);
    }

    public static void saveDomain(Context context, String str) {
        if (context != null && str != null) {
            PushPreferences.putString(context, ".com.tencent.tpush.cache.domain", str);
        }
    }

    public static void saveDomainKey(Context context, String str) {
        ArrayList<String> arrayList;
        if (context != null) {
            try {
                arrayList = getDomainKeyList(context);
            } catch (Throwable unused) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(str);
            saveDomainKeyList(context, arrayList);
        }
    }

    public static void saveDomainKeyList(Context context, ArrayList<String> arrayList) {
        String str;
        if (context != null) {
            if (arrayList != null) {
                try {
                    str = e.a((Serializable) arrayList);
                } catch (Throwable th2) {
                    TLogger.e("CacheManager", "", th2);
                    return;
                }
            } else {
                str = "";
            }
            PushPreferences.putString(context, ".com.tencent.tpush.cache.domain.key", Rijndael.encrypt(str));
        }
    }

    public static void setCurrentAppRegisterEntity(Context context, RegisterEntity registerEntity) {
        PushPreferences.putString(context, a("cur.register", ".reg"), RegisterEntity.encode(registerEntity));
    }

    public static void setQua(Context context, long j11, String str) {
        if (context != null && !j.b(str) && j11 > 0) {
            PushPreferences.putString(context, ".com.tencent.tpush.cache.qua." + j11, str);
        }
    }

    public static class a extends TTask {

        /* renamed from: a  reason: collision with root package name */
        private Context f69646a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Long, RegisterEntity> f69647b = new HashMap();

        public a(Context context) {
            this.f69646a = context;
        }

        public void TRun() {
            try {
                a(com.tencent.android.tpush.a.d(CacheManager.getContext()));
            } catch (Throwable unused) {
            }
        }

        public synchronized void a(Map<Long, RegisterEntity> map) {
            this.f69647b = map;
        }

        public synchronized Map<Long, RegisterEntity> a() {
            return this.f69647b;
        }
    }

    private static String a(String str, String str2) {
        return str + ".com.tencent.tpush.cache" + str2;
    }
}
