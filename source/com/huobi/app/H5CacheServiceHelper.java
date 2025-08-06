package com.huobi.app;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;
import androidx.annotation.Keep;
import bh.j;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.ProInterceptor;
import com.huobi.store.AppConfigManager;
import com.huobi.store.BusinessLine;
import com.huobi.webcache.CacheStrategy;
import com.huobi.webcache.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Dns;

@Keep
public class H5CacheServiceHelper {
    private static final String TAG = "H5CacheServiceHelper";
    /* access modifiers changed from: private */
    public static H5CacheConfig configBean = new H5CacheConfig();
    private static boolean isInit = false;
    private static boolean isRegister = false;

    @Keep
    public static class H5CacheConfig {
        public List<String> blackList = new ArrayList();
        public boolean cacheAllGet;
        public boolean cacheAllMainFrame;
        public boolean cacheBannerUrl;
        public boolean cacheBizUrl;
        public boolean cacheFunctionUrl;
        public String cacheMiniProgramConfig;
        public long cacheTaskTimeOut;
        public boolean clearHeaderCacheTag;
        public long delayMPSecond;
        public long delaySecond;
        public boolean downloaderSwitch;
        public boolean dyanmicImageInitSwitch;
        public boolean dynamicColorInitSwitch;
        public boolean enable;
        public boolean enableCacheMiniProgram;
        public boolean handleResource;
        public List<String> huobiHostKeys;
        private final String[] huobiHostKeysArray;
        public boolean i18nManageInitSwitch;
        public boolean isUseLoaclFavicon;
        public boolean jsonConfigInitSwitch;
        public List<String> needCacheMiniProgramList;
        public boolean needStatisticsCacheHitRate;
        public Map<String, Map<String, Object>> offlineConfig;
        public int offlinePackageEnable;
        private final String[] preloadUrlArray;
        public List<String> preloadUrlList;
        private final String[] statisticsArray;
        public List<String> statisticsList;
        public int switchSuffixDomain;
        private final String[] urlPathArray;
        public List<String> urlPaths;
        public boolean useHttpCacheSwitch;
        public List<String> versions;
        private final String[] versionsArray;
        private final String[] whiteFileTypeArray;
        public List<String> whiteFileTypeList;
        public List<String> whiteList = new ArrayList();

        public H5CacheConfig() {
            String[] strArr = {""};
            this.preloadUrlArray = strArr;
            String[] strArr2 = {"wkbrs1.tingyun.com/action", "woodpeckerlog.com/", "amazonaws.com"};
            this.statisticsArray = strArr2;
            String[] strArr3 = {"html", "htm", "js", "css", "ico", "png", "jpg", "gif", "bmp", "ttf", "woff", "woff2", "otf", "eot", "svg", "xml", "swf", "txt", "text", "conf", "webp"};
            this.whiteFileTypeArray = strArr3;
            this.whiteFileTypeList = Arrays.asList(strArr3);
            this.enable = true;
            this.statisticsList = Arrays.asList(strArr2);
            this.isUseLoaclFavicon = true;
            this.cacheAllMainFrame = false;
            this.cacheAllGet = false;
            this.clearHeaderCacheTag = false;
            this.preloadUrlList = Arrays.asList(strArr);
            String[] strArr4 = {"/zh-cn/financial/earn/h5", "/zh-cn/topic/welcome-bonus/h5", "/zh-cn/topic/primelist/h5"};
            this.urlPathArray = strArr4;
            String[] strArr5 = {"1", "2", "3"};
            this.versionsArray = strArr5;
            this.urlPaths = Arrays.asList(strArr4);
            this.versions = Arrays.asList(strArr5);
            String[] strArr6 = {"huobi"};
            this.huobiHostKeysArray = strArr6;
            this.huobiHostKeys = Arrays.asList(strArr6);
            this.delaySecond = 8000;
            this.enableCacheMiniProgram = false;
            this.delayMPSecond = 1000;
            this.needCacheMiniProgramList = new ArrayList();
            this.cacheMiniProgramConfig = "{}";
            this.cacheTaskTimeOut = SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
            this.useHttpCacheSwitch = false;
            this.cacheBizUrl = false;
            this.cacheBannerUrl = false;
            this.cacheFunctionUrl = false;
            this.needStatisticsCacheHitRate = false;
            this.i18nManageInitSwitch = true;
            this.downloaderSwitch = true;
            this.dyanmicImageInitSwitch = true;
            this.jsonConfigInitSwitch = true;
            this.dynamicColorInitSwitch = true;
            this.handleResource = true;
            this.switchSuffixDomain = -1;
            this.offlinePackageEnable = 0;
        }

        public String toString() {
            return "H5CacheConfig{  enable=" + this.enable + "  delaySecond=" + this.delaySecond + "  cacheTaskTimeOut=" + this.cacheTaskTimeOut + "  useHttpCacheSwitch=" + this.useHttpCacheSwitch + "  cacheBizUrl=" + this.cacheBizUrl + "  cacheBannerUrl=" + this.cacheBannerUrl + "  cacheFunctionUrl=" + this.cacheFunctionUrl + "  enableCacheMiniProgram=" + this.enableCacheMiniProgram + "  delayMPSecond=" + this.delayMPSecond + "  cacheMiniProgramConfig=" + this.cacheMiniProgramConfig + "  needCacheMiniProgramList=" + this.needCacheMiniProgramList + ", huobiHostKey=" + this.huobiHostKeys + ", blackList=" + this.blackList + ", whiteList=" + this.whiteList + ", whiteFileTypeList=" + this.whiteFileTypeList + ", statisticsList=" + this.statisticsList + ", isUseLoaclFavicon=" + this.isUseLoaclFavicon + ", cacheAllMainFrame=" + this.cacheAllMainFrame + ", cacheAllGet=" + this.cacheAllGet + ", clearHeaderCacheTag=" + this.clearHeaderCacheTag + ", downloaderSwitch=" + this.downloaderSwitch + ", i18nManageInitSwitch=" + this.i18nManageInitSwitch + ", dyanmicImageInitSwitch=" + this.dyanmicImageInitSwitch + ", handleResource=" + this.handleResource + ", jsonConfigInitSwitch=" + this.jsonConfigInitSwitch + ", preloadUrlList=" + this.preloadUrlList + ", urlPaths=" + this.urlPaths + ", versions=" + this.versions + ", switchSuffixDomain=" + this.switchSuffixDomain + ", offlinePackageEnable=" + this.offlinePackageEnable + '}';
        }
    }

    public class a implements com.huobi.webcache.b {
        public Map<String, String> a() {
            new HashMap().put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
            return null;
        }

        public void b(WebView webView, String str) {
        }
    }

    public class b implements js.a {
        public void a(BusinessLine businessLine) {
            H5CacheConfig h5CacheConfig = (H5CacheConfig) AppConfigManager.c(MgtConfigNumber.H5_CACHE_CONFIG.number, H5CacheConfig.class);
            H5CacheServiceHelper.initWebCacheServie(H5CacheServiceHelper.configBean, (c) null);
        }

        public int getId() {
            return MgtConfigNumber.H5_CACHE_CONFIG.number;
        }
    }

    public interface c {
        void call();
    }

    public static String buildStackTraceToString() {
        try {
            StringBuilder sb2 = new StringBuilder();
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i11 = 0; i11 < stackTrace.length; i11++) {
                String fileName = stackTrace[i11].getFileName();
                String methodName = stackTrace[i11].getMethodName();
                int lineNumber = stackTrace[i11].getLineNumber();
                sb2.append("[ (");
                sb2.append(fileName);
                sb2.append(":");
                sb2.append(lineNumber);
                sb2.append(")#");
                sb2.append(methodName.substring(0, 1).toUpperCase() + methodName.substring(1));
                sb2.append(" ] \n");
            }
            return sb2.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return Log.getStackTraceString(e11);
        }
    }

    public static H5CacheConfig getConfigBean() {
        return configBean;
    }

    public static void init() {
        init((c) null);
    }

    /* access modifiers changed from: private */
    public static void initWebCacheServie(H5CacheConfig h5CacheConfig, c cVar) {
        h hVar = new h(j.c());
        hVar.l(false);
        hVar.n(j.c().getFilesDir().getPath());
        hVar.o(524288000);
        hVar.p(1);
        hVar.r(32);
        hVar.k(5);
        hVar.s(5);
        hVar.u(false);
        hVar.y((X509TrustManager) null);
        hVar.m((Dns) null);
        hVar.t((SSLSocketFactory) null);
        hVar.x(h5CacheConfig.useHttpCacheSwitch);
        hVar.q(new a());
        hVar.d(new ProInterceptor());
        hVar.d(new HeaderInterceptor());
        hVar.i(!h5CacheConfig.enable ? CacheStrategy.NO_CACHE : CacheStrategy.FORCE);
        hVar.j(h5CacheConfig.clearHeaderCacheTag);
        hVar.g(h5CacheConfig.cacheAllGet);
        hVar.h(h5CacheConfig.cacheAllMainFrame);
        hVar.w(h5CacheConfig.isUseLoaclFavicon);
        List<String> list = h5CacheConfig.statisticsList;
        if (list != null) {
            for (String e11 : list) {
                hVar.e(e11);
            }
        }
        List<String> list2 = h5CacheConfig.whiteList;
        if (list2 != null) {
            for (String c11 : list2) {
                hVar.c(c11);
            }
        }
        List<String> list3 = h5CacheConfig.whiteFileTypeList;
        if (list3 != null) {
            for (String b11 : list3) {
                hVar.b(b11);
            }
        }
        List<String> list4 = h5CacheConfig.blackList;
        if (list4 != null) {
            for (String a11 : list4) {
                hVar.a(a11);
            }
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<String> list5 = h5CacheConfig.urlPaths;
        if (!(list5 == null || h5CacheConfig.versions == null || list5.size() > h5CacheConfig.versions.size())) {
            for (int i11 = 0; i11 < h5CacheConfig.urlPaths.size(); i11++) {
                String str = h5CacheConfig.urlPaths.get(i11);
                String str2 = h5CacheConfig.versions.get(i11);
                if (!concurrentHashMap.contains(str)) {
                    concurrentHashMap.put(str, str2);
                }
            }
            hVar.v(concurrentHashMap);
        }
        hVar.f();
        setConfigBean(h5CacheConfig);
        isInit = true;
        if (cVar != null) {
            cVar.call();
        }
    }

    public static boolean isIsInit() {
        return isInit;
    }

    public static void registerOnChangeListener() {
        if (!isRegister) {
            AppConfigManager.o(new b());
            isRegister = true;
        }
    }

    public static void setConfigBean(H5CacheConfig h5CacheConfig) {
        configBean = h5CacheConfig;
    }

    public static void startPreloadService(Activity activity, HashSet<String> hashSet, Map<String, String> map) {
        startPreloadService(activity, hashSet, map, true);
    }

    public static void init(c cVar) {
        if (!isInit) {
            try {
                H5CacheConfig h5CacheConfig = (H5CacheConfig) AppConfigManager.c(MgtConfigNumber.H5_CACHE_CONFIG.number, H5CacheConfig.class);
                Log.d(TAG, "init(用本地数据) called with: callBack = [" + cVar + "],config = [" + h5CacheConfig + "]");
                if (h5CacheConfig != null) {
                    setConfigBean(h5CacheConfig);
                }
                initWebCacheServie(configBean, cVar);
            } catch (Exception e11) {
                H5CacheConfig h5CacheConfig2 = new H5CacheConfig();
                Log.e(TAG, "onRequestFailure() called with: configBean = [" + h5CacheConfig2 + "]", e11);
                if (!isIsInit()) {
                    initWebCacheServie(h5CacheConfig2, cVar);
                }
            }
        } else if (cVar != null) {
            cVar.call();
        }
    }

    public static void startPreloadService(Activity activity, HashSet<String> hashSet, Map<String, String> map, boolean z11) {
        if (configBean.enable) {
            com.huobi.webcache.c.j().t(configBean.cacheTaskTimeOut);
            if (!com.huobi.webcache.c.j().n()) {
                com.huobi.webcache.c.j().x(activity, 0, hashSet, map);
            } else if (z11) {
                com.huobi.webcache.c.j().p(activity, 0, hashSet, map);
            }
        }
    }
}
