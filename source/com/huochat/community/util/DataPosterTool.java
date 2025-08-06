package com.huochat.community.util;

import android.text.TextUtils;
import android.util.LruCache;

public class DataPosterTool {
    private static volatile DataPosterTool instance;
    private LruCache<String, Object> objectLruCache = new LruCache<>(1024);

    private DataPosterTool() {
    }

    public static DataPosterTool getInstance() {
        if (instance == null) {
            synchronized (DataPosterTool.class) {
                if (instance == null) {
                    instance = new DataPosterTool();
                }
            }
        }
        return instance;
    }

    public void clearData(String str) {
        LruCache<String, Object> lruCache;
        if (!TextUtils.isEmpty(str) && (lruCache = this.objectLruCache) != null) {
            lruCache.remove(str);
        }
    }

    public <T> T getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            LruCache<String, Object> lruCache = this.objectLruCache;
            if (lruCache != null) {
                return lruCache.get(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return null;
    }

    public void putData(String str, Object obj) {
        LruCache<String, Object> lruCache;
        if (!TextUtils.isEmpty(str) && obj != null && (lruCache = this.objectLruCache) != null) {
            lruCache.put(str, obj);
        }
    }
}
