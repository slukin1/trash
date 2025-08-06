package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.SASpUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractStoreManager {
    private static final String TAG = "SA.AbstractStoreManager";
    public boolean mDefaultState = true;
    private final Lock mLock = new ReentrantLock(true);
    private final LruCacheData mLruCacheSPData = new LruCacheData(10);
    /* access modifiers changed from: private */
    public String mMaxPluginType;
    private StorePlugin mMaxPriorityPlugin;
    private final List<StorePlugin> mStorePluginList = new ArrayList();
    private final Set<String> mStoreTypes = new HashSet();

    public class LruCacheData {
        private LruCache<String, Object> mCacheSPData;

        public LruCacheData(int i11) {
            if (Build.VERSION.SDK_INT >= 12) {
                this.mCacheSPData = new LruCache<>(i11);
            }
        }

        public Object get(String str) {
            if (Build.VERSION.SDK_INT < 12) {
                return null;
            }
            LruCache<String, Object> lruCache = this.mCacheSPData;
            return lruCache.get(AbstractStoreManager.this.mMaxPluginType + str);
        }

        public void put(String str, Object obj) {
            if (Build.VERSION.SDK_INT >= 12) {
                LruCache<String, Object> lruCache = this.mCacheSPData;
                lruCache.put(AbstractStoreManager.this.mMaxPluginType + str, obj);
            }
        }

        public void remove(String str) {
            if (Build.VERSION.SDK_INT >= 12) {
                LruCache<String, Object> lruCache = this.mCacheSPData;
                lruCache.remove(AbstractStoreManager.this.mMaxPluginType + str);
            }
        }
    }

    private <T> T getValue(String str, String str2, T t11) {
        StorePlugin storePlugin = this.mMaxPriorityPlugin;
        Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            StorePlugin next = it2.next();
            if (next instanceof DefaultStorePlugin) {
                DefaultStorePlugin defaultStorePlugin = (DefaultStorePlugin) next;
                if (defaultStorePlugin.storeKeys() != null && defaultStorePlugin.storeKeys().contains(str)) {
                    storePlugin = next;
                    break;
                }
            }
        }
        T t12 = null;
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case -1808118735:
                if (str2.equals("String")) {
                    c11 = 0;
                    break;
                }
                break;
            case -672261858:
                if (str2.equals("Integer")) {
                    c11 = 1;
                    break;
                }
                break;
            case 2076426:
                if (str2.equals("Bool")) {
                    c11 = 2;
                    break;
                }
                break;
            case 2374300:
                if (str2.equals("Long")) {
                    c11 = 3;
                    break;
                }
                break;
            case 67973692:
                if (str2.equals("Float")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                t12 = storePlugin.getString(storePlugin.type() + str);
                break;
            case 1:
                t12 = storePlugin.getInteger(storePlugin.type() + str);
                break;
            case 2:
                t12 = storePlugin.getBool(storePlugin.type() + str);
                break;
            case 3:
                t12 = storePlugin.getLong(storePlugin.type() + str);
                break;
            case 4:
                t12 = storePlugin.getFloat(storePlugin.type() + str);
                break;
        }
        return t12 == null ? t11 : t12;
    }

    private void removeUselessValue(String str) {
        for (StorePlugin next : this.mStorePluginList) {
            if (next != this.mMaxPriorityPlugin) {
                next.remove(next.type() + str);
            }
        }
    }

    private void storeKeys(String str, Object obj, String str2) {
        StorePlugin storePlugin = this.mMaxPriorityPlugin;
        Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            StorePlugin next = it2.next();
            if (next instanceof DefaultStorePlugin) {
                DefaultStorePlugin defaultStorePlugin = (DefaultStorePlugin) next;
                if (defaultStorePlugin.storeKeys() != null && defaultStorePlugin.storeKeys().contains(str)) {
                    storePlugin = next;
                    break;
                }
            }
        }
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case -1808118735:
                if (str2.equals("String")) {
                    c11 = 0;
                    break;
                }
                break;
            case -672261858:
                if (str2.equals("Integer")) {
                    c11 = 1;
                    break;
                }
                break;
            case 2076426:
                if (str2.equals("Bool")) {
                    c11 = 2;
                    break;
                }
                break;
            case 2374300:
                if (str2.equals("Long")) {
                    c11 = 3;
                    break;
                }
                break;
            case 67973692:
                if (str2.equals("Float")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                storePlugin.setString(storePlugin.type() + str, (String) obj);
                return;
            case 1:
                storePlugin.setInteger(storePlugin.type() + str, ((Integer) obj).intValue());
                return;
            case 2:
                storePlugin.setBool(storePlugin.type() + str, ((Boolean) obj).booleanValue());
                return;
            case 3:
                storePlugin.setLong(storePlugin.type() + str, ((Long) obj).longValue());
                return;
            case 4:
                storePlugin.setFloat(storePlugin.type() + str, ((Float) obj).floatValue());
                return;
            default:
                return;
        }
    }

    public boolean getBool(String str, boolean z11) {
        boolean booleanValue;
        this.mLock.lock();
        try {
            Boolean bool = (Boolean) this.mLruCacheSPData.get(str);
            if (bool != null) {
                booleanValue = bool.booleanValue();
            } else if (this.mDefaultState) {
                booleanValue = ((Boolean) getValue(str, "Bool", Boolean.valueOf(z11))).booleanValue();
            } else {
                Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    StorePlugin next = it2.next();
                    Boolean bool2 = next.getBool(next.type() + str);
                    if (bool2 != null) {
                        if (next != this.mMaxPriorityPlugin) {
                            next.remove(next.type() + str);
                            StorePlugin storePlugin = this.mMaxPriorityPlugin;
                            storePlugin.setBool(this.mMaxPluginType + str, bool2.booleanValue());
                        }
                        this.mLruCacheSPData.put(str, bool2);
                        bool = bool2;
                    } else {
                        bool = bool2;
                    }
                }
                if (bool != null) {
                    z11 = bool.booleanValue();
                }
                this.mLock.unlock();
                return z11;
            }
            return booleanValue;
        } catch (Exception e11) {
            SALog.i(TAG, "get data failed,key = " + str, e11);
            return z11;
        } finally {
            this.mLock.unlock();
        }
    }

    public float getFloat(String str, float f11) {
        float floatValue;
        this.mLock.lock();
        try {
            Float f12 = (Float) this.mLruCacheSPData.get(str);
            if (f12 != null) {
                floatValue = f12.floatValue();
            } else if (this.mDefaultState) {
                floatValue = ((Float) getValue(str, "Float", Float.valueOf(f11))).floatValue();
            } else {
                Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    StorePlugin next = it2.next();
                    Float f13 = next.getFloat(next.type() + str);
                    if (f13 != null) {
                        if (next != this.mMaxPriorityPlugin) {
                            next.remove(next.type() + str);
                            StorePlugin storePlugin = this.mMaxPriorityPlugin;
                            storePlugin.setFloat(this.mMaxPluginType + str, f13.floatValue());
                        }
                        this.mLruCacheSPData.put(str, f13);
                        f12 = f13;
                    } else {
                        f12 = f13;
                    }
                }
                if (f12 != null) {
                    f11 = f12.floatValue();
                }
                this.mLock.unlock();
                return f11;
            }
            return floatValue;
        } catch (Exception e11) {
            SALog.i(TAG, "get data failed,key = " + str, e11);
            return f11;
        } finally {
            this.mLock.unlock();
        }
    }

    public int getInteger(String str, int i11) {
        int intValue;
        this.mLock.lock();
        try {
            Integer num = (Integer) this.mLruCacheSPData.get(str);
            if (num != null) {
                intValue = num.intValue();
            } else if (this.mDefaultState) {
                intValue = ((Integer) getValue(str, "Integer", Integer.valueOf(i11))).intValue();
            } else {
                Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    StorePlugin next = it2.next();
                    Integer integer = next.getInteger(next.type() + str);
                    if (integer != null) {
                        if (next != this.mMaxPriorityPlugin) {
                            next.remove(next.type() + str);
                            StorePlugin storePlugin = this.mMaxPriorityPlugin;
                            storePlugin.setInteger(this.mMaxPluginType + str, integer.intValue());
                        }
                        this.mLruCacheSPData.put(str, integer);
                        num = integer;
                    } else {
                        num = integer;
                    }
                }
                if (num != null) {
                    i11 = num.intValue();
                }
                this.mLock.unlock();
                return i11;
            }
            return intValue;
        } catch (Exception e11) {
            SALog.i(TAG, "get data failed,key = " + str, e11);
            return i11;
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public Long getLong(String str, long j11) {
        long j12;
        this.mLock.lock();
        try {
            Long l11 = (Long) this.mLruCacheSPData.get(str);
            if (l11 == null) {
                if (this.mDefaultState) {
                    l11 = (Long) getValue(str, "Long", Long.valueOf(j11));
                } else {
                    Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        StorePlugin next = it2.next();
                        Long l12 = next.getLong(next.type() + str);
                        if (l12 != null) {
                            if (next != this.mMaxPriorityPlugin) {
                                next.remove(next.type() + str);
                                StorePlugin storePlugin = this.mMaxPriorityPlugin;
                                storePlugin.setLong(this.mMaxPluginType + str, l12.longValue());
                            }
                            this.mLruCacheSPData.put(str, l12);
                            l11 = l12;
                        } else {
                            l11 = l12;
                        }
                    }
                    if (l11 == null) {
                        j12 = j11;
                    } else {
                        j12 = l11.longValue();
                    }
                    Long valueOf = Long.valueOf(j12);
                    this.mLock.unlock();
                    return valueOf;
                }
            }
            this.mLock.unlock();
            return l11;
        } catch (Exception e11) {
            SALog.i(TAG, "get data failed,key = " + str, e11);
            this.mLock.unlock();
            return Long.valueOf(j11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public String getString(String str, String str2) {
        this.mLock.lock();
        try {
            String str3 = (String) this.mLruCacheSPData.get(str);
            if (str3 == null) {
                if (this.mDefaultState) {
                    str3 = (String) getValue(str, "String", str2);
                } else {
                    Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        StorePlugin next = it2.next();
                        String string = next.getString(next.type() + str);
                        if (!TextUtils.isEmpty(string)) {
                            if (next != this.mMaxPriorityPlugin) {
                                next.remove(next.type() + str);
                                StorePlugin storePlugin = this.mMaxPriorityPlugin;
                                storePlugin.setString(this.mMaxPluginType + str, string);
                            }
                            this.mLruCacheSPData.put(str, string);
                            str3 = string;
                        } else {
                            str3 = string;
                        }
                    }
                    if (str3 != null) {
                        str2 = str3;
                    }
                    this.mLock.unlock();
                    return str2;
                }
            }
            return str3;
        } catch (Exception e11) {
            SALog.i(TAG, "get data failed,key = " + str, e11);
            return str2;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean isExists(String str) {
        this.mLock.lock();
        try {
            if (TextUtils.isEmpty(str)) {
                this.mLock.unlock();
                return false;
            }
            for (StorePlugin next : this.mStorePluginList) {
                if (next.isExists(next.type() + str)) {
                    this.mLock.unlock();
                    return true;
                }
            }
            this.mLock.unlock();
            return false;
        } catch (Exception e11) {
            SALog.i(TAG, "isExists failed,key = " + str, e11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public boolean isRegisterPlugin(Context context, String str) {
        try {
            File file = new File("data/data/" + context.getPackageName() + "/shared_prefs", str + ".xml");
            if (!file.exists()) {
                return false;
            }
            if (SASpUtils.getSharedPreferences(context, str, 0).getAll().size() == 0) {
                SALog.i(TAG, "delete sp: " + str);
                return !file.delete();
            }
            return true;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void registerPlugin(StorePlugin storePlugin) {
        if (storePlugin != null) {
            String type = storePlugin.type();
            if (TextUtils.isEmpty(type)) {
                SALog.i(TAG, "PluginType is null");
                return;
            }
            if (this.mStoreTypes.contains(type)) {
                Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    StorePlugin next = it2.next();
                    if (TextUtils.equals(type, next.type())) {
                        this.mStorePluginList.remove(next);
                        break;
                    }
                }
            } else {
                this.mStoreTypes.add(type);
            }
            this.mStorePluginList.add(0, storePlugin);
            this.mMaxPriorityPlugin = storePlugin;
            this.mMaxPluginType = storePlugin.type();
        }
    }

    public void remove(String str) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                StorePlugin storePlugin = this.mMaxPriorityPlugin;
                Iterator<StorePlugin> it2 = this.mStorePluginList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    StorePlugin next = it2.next();
                    if ((next instanceof DefaultStorePlugin) && ((DefaultStorePlugin) next).storeKeys() != null && ((DefaultStorePlugin) next).storeKeys().contains(str)) {
                        storePlugin = next;
                        break;
                    }
                }
                storePlugin.remove(storePlugin.type() + str);
            } else {
                for (StorePlugin next2 : this.mStorePluginList) {
                    next2.remove(next2.type() + str);
                }
            }
            this.mLruCacheSPData.remove(str);
        } catch (Exception e11) {
            SALog.i(TAG, "remove failed,key = " + str, e11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
        this.mLock.unlock();
    }

    public void setBool(String str, boolean z11) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, Boolean.valueOf(z11), "Bool");
                this.mLock.unlock();
                return;
            }
            removeUselessValue(str);
            StorePlugin storePlugin = this.mMaxPriorityPlugin;
            storePlugin.setBool(this.mMaxPluginType + str, z11);
            this.mLruCacheSPData.put(str, Boolean.valueOf(z11));
            this.mLock.unlock();
        } catch (Exception e11) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + z11, e11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public void setFloat(String str, float f11) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, Float.valueOf(f11), "Float");
                this.mLock.unlock();
                return;
            }
            removeUselessValue(str);
            StorePlugin storePlugin = this.mMaxPriorityPlugin;
            storePlugin.setFloat(this.mMaxPluginType + str, f11);
            this.mLruCacheSPData.put(str, Float.valueOf(f11));
            this.mLock.unlock();
        } catch (Exception e11) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + f11, e11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public void setInteger(String str, int i11) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, Integer.valueOf(i11), "Integer");
                this.mLock.unlock();
                return;
            }
            removeUselessValue(str);
            StorePlugin storePlugin = this.mMaxPriorityPlugin;
            storePlugin.setInteger(this.mMaxPluginType + str, i11);
            this.mLruCacheSPData.put(str, Integer.valueOf(i11));
            this.mLock.unlock();
        } catch (Exception e11) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + i11, e11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public void setLong(String str, long j11) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, Long.valueOf(j11), "Long");
                this.mLock.unlock();
                return;
            }
            removeUselessValue(str);
            StorePlugin storePlugin = this.mMaxPriorityPlugin;
            storePlugin.setLong(this.mMaxPluginType + str, j11);
            this.mLruCacheSPData.put(str, Long.valueOf(j11));
            this.mLock.unlock();
        } catch (Exception e11) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + j11, e11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public void setString(String str, String str2) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, str2, "String");
                this.mLock.unlock();
                return;
            }
            if (str2 == null) {
                for (StorePlugin next : this.mStorePluginList) {
                    next.remove(next.type() + str);
                }
                this.mLruCacheSPData.remove(str);
            } else {
                removeUselessValue(str);
                StorePlugin storePlugin = this.mMaxPriorityPlugin;
                storePlugin.setString(this.mMaxPluginType + str, str2);
                this.mLruCacheSPData.put(str, str2);
            }
            this.mLock.unlock();
        } catch (Exception e11) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + str2, e11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public void upgrade() {
        this.mLock.lock();
        try {
            for (int size = this.mStorePluginList.size() - 1; size >= 0; size--) {
                StorePlugin storePlugin = this.mStorePluginList.get(size);
                StorePlugin storePlugin2 = null;
                int i11 = size - 1;
                if (i11 >= 0) {
                    storePlugin2 = this.mStorePluginList.get(i11);
                }
                if (storePlugin2 != null) {
                    storePlugin2.upgrade(storePlugin);
                }
            }
        } catch (Exception e11) {
            SALog.i(TAG, "upgrade failed", e11);
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
        this.mLock.unlock();
    }
}
