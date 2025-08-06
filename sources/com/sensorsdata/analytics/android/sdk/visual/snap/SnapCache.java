package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;

public class SnapCache {
    private static volatile SnapCache mSnapCache;
    @SuppressLint({"NewApi"})
    private final LruCache<String, String> mLruCanonicalName = new LruCache<>(64);
    @SuppressLint({"NewApi"})
    private final LruCache<String, ViewTempInfo> mLruViewInfo = new LruCache<>(64);

    public static class ViewTempInfo {
        public Boolean localVisibleRect;
        public String selectPath;
        public String viewId;
        public String viewText;
        public String viewType;
    }

    private SnapCache() {
    }

    public static SnapCache getInstance() {
        if (mSnapCache == null) {
            synchronized (SnapCache.class) {
                if (mSnapCache == null) {
                    mSnapCache = new SnapCache();
                }
            }
        }
        return mSnapCache;
    }

    @SuppressLint({"NewApi"})
    public String getCanonicalName(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LruCache<String, String> lruCache = this.mLruCanonicalName;
        String str = lruCache.get(cls.hashCode() + "");
        if (str == null) {
            str = cls.getCanonicalName();
            if (TextUtils.isEmpty(str)) {
                str = "Anonymous";
            }
            LruCache<String, String> lruCache2 = this.mLruCanonicalName;
            lruCache2.put(cls.hashCode() + "", str);
        }
        return str;
    }

    @SuppressLint({"NewApi"})
    public Boolean getLocalVisibleRect(View view) {
        if (view == null) {
            return null;
        }
        LruCache<String, ViewTempInfo> lruCache = this.mLruViewInfo;
        ViewTempInfo viewTempInfo = lruCache.get(view.hashCode() + "");
        if (viewTempInfo != null) {
            return viewTempInfo.localVisibleRect;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public String getSelectPath(View view) {
        if (view == null) {
            return null;
        }
        ViewTempInfo viewTempInfo = this.mLruViewInfo.get(view.hashCode() + "");
        if (viewTempInfo != null) {
            return viewTempInfo.selectPath;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public String getViewId(View view) {
        if (view == null) {
            return null;
        }
        LruCache<String, ViewTempInfo> lruCache = this.mLruViewInfo;
        ViewTempInfo viewTempInfo = lruCache.get(view.hashCode() + "");
        if (viewTempInfo != null) {
            return viewTempInfo.viewId;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public String getViewText(View view) {
        if (view == null) {
            return null;
        }
        LruCache<String, ViewTempInfo> lruCache = this.mLruViewInfo;
        ViewTempInfo viewTempInfo = lruCache.get(view.hashCode() + "");
        if (viewTempInfo != null) {
            return viewTempInfo.viewText;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public String getViewType(View view) {
        if (view == null) {
            return null;
        }
        LruCache<String, ViewTempInfo> lruCache = this.mLruViewInfo;
        ViewTempInfo viewTempInfo = lruCache.get(view.hashCode() + "");
        if (viewTempInfo != null) {
            return viewTempInfo.viewType;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public void setLocalVisibleRect(View view, Boolean bool) {
        if (view != null && bool != null) {
            String str = view.hashCode() + "";
            ViewTempInfo viewTempInfo = this.mLruViewInfo.get(str);
            if (viewTempInfo == null) {
                viewTempInfo = new ViewTempInfo();
            }
            viewTempInfo.localVisibleRect = bool;
            this.mLruViewInfo.put(str, viewTempInfo);
        }
    }

    @SuppressLint({"NewApi"})
    public void setSelectPath(View view, String str) {
        if (view != null && str != null && !str.equals("")) {
            String str2 = view.hashCode() + "";
            ViewTempInfo viewTempInfo = this.mLruViewInfo.get(str2);
            if (viewTempInfo == null) {
                viewTempInfo = new ViewTempInfo();
            }
            viewTempInfo.selectPath = str;
            this.mLruViewInfo.put(str2, viewTempInfo);
        }
    }

    @SuppressLint({"NewApi"})
    public void setViewId(View view, String str) {
        if (view != null && str != null) {
            String str2 = view.hashCode() + "";
            ViewTempInfo viewTempInfo = this.mLruViewInfo.get(str2);
            if (viewTempInfo == null) {
                viewTempInfo = new ViewTempInfo();
            }
            viewTempInfo.viewId = str;
            this.mLruViewInfo.put(str2, viewTempInfo);
        }
    }

    @SuppressLint({"NewApi"})
    public void setViewText(View view, String str) {
        if (view != null && str != null) {
            String str2 = view.hashCode() + "";
            ViewTempInfo viewTempInfo = this.mLruViewInfo.get(str2);
            if (viewTempInfo == null) {
                viewTempInfo = new ViewTempInfo();
            }
            viewTempInfo.viewText = str;
            this.mLruViewInfo.put(str2, viewTempInfo);
        }
    }

    @SuppressLint({"NewApi"})
    public void setViewType(View view, String str) {
        if (view != null && str != null) {
            String str2 = view.hashCode() + "";
            ViewTempInfo viewTempInfo = this.mLruViewInfo.get(str2);
            if (viewTempInfo == null) {
                viewTempInfo = new ViewTempInfo();
            }
            viewTempInfo.viewType = str;
            this.mLruViewInfo.put(str2, viewTempInfo);
        }
    }
}
