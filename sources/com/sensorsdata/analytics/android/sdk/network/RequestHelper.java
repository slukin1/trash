package com.sensorsdata.analytics.android.sdk.network;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class RequestHelper {
    /* access modifiers changed from: private */
    public boolean isRedirected;

    /* renamed from: com.sensorsdata.analytics.android.sdk.network.RequestHelper$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.sensorsdata.analytics.android.sdk.network.HttpMethod[] r0 = com.sensorsdata.analytics.android.sdk.network.HttpMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod = r0
                com.sensorsdata.analytics.android.sdk.network.HttpMethod r1 = com.sensorsdata.analytics.android.sdk.network.HttpMethod.GET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sensorsdata.analytics.android.sdk.network.HttpMethod r1 = com.sensorsdata.analytics.android.sdk.network.HttpMethod.POST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.network.RequestHelper.AnonymousClass3.<clinit>():void");
        }
    }

    public static class Builder {
        private HttpCallback callBack;
        private Map<String, String> headerMap;
        private HttpConfig httpConfig;
        private HttpMethod httpMethod;
        private String httpUrl;
        private String jsonData;
        private Map<String, String> paramsMap;
        private int retryCount = 1;

        public Builder(HttpMethod httpMethod2, String str) {
            this.httpMethod = httpMethod2;
            this.httpUrl = str;
        }

        public Builder callback(HttpCallback httpCallback) {
            this.callBack = httpCallback;
            return this;
        }

        public Builder connectionTimeout(int i11) {
            if (this.httpConfig == null) {
                this.httpConfig = new HttpConfig();
            }
            this.httpConfig.setConnectionTimeout(i11);
            return this;
        }

        public void execute() {
            HttpMethod httpMethod2 = this.httpMethod;
            if (httpMethod2 == HttpMethod.POST && this.paramsMap == null) {
                new RequestHelper(this.httpUrl, this.httpConfig, this.jsonData, (Map) this.headerMap, this.retryCount, this.callBack);
            } else {
                new RequestHelper(httpMethod2, this.httpUrl, this.httpConfig, this.paramsMap, this.headerMap, this.retryCount, this.callBack);
            }
        }

        public Builder header(Map<String, String> map) {
            this.headerMap = map;
            return this;
        }

        public Builder jsonData(String str) {
            this.jsonData = str;
            return this;
        }

        public Builder params(Map<String, String> map) {
            this.paramsMap = map;
            return this;
        }

        public Builder readTimeout(int i11) {
            if (this.httpConfig == null) {
                this.httpConfig = new HttpConfig();
            }
            this.httpConfig.setReadTimeout(i11);
            return this;
        }

        public Builder retryCount(int i11) {
            this.retryCount = i11;
            return this;
        }
    }

    /* access modifiers changed from: private */
    public String getPostBody(Map<String, String> map, String str) {
        if (map != null) {
            return getPostBodyFormParamsMap(map);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return null;
    }

    private String getPostBodyFormParamsMap(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb2 = new StringBuilder();
            boolean z11 = true;
            try {
                for (Map.Entry next : map.entrySet()) {
                    if (z11) {
                        z11 = false;
                    } else {
                        sb2.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb2.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                    sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb2.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                }
                return sb2.toString();
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String getPostBodyType(Map<String, String> map, String str) {
        if (map == null && !TextUtils.isEmpty(str)) {
            return "application/json;charset=utf-8";
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String getUrl(String str, Map<String, String> map) {
        String str2;
        if (str == null || map == null) {
            return str;
        }
        if (!str.contains("?")) {
            str2 = str + "?";
        } else {
            str2 = str + ContainerUtils.FIELD_DELIMITER;
        }
        for (String next : map.keySet()) {
            str2 = str2 + next + ContainerUtils.KEY_VALUE_DELIMITER + map.get(next) + ContainerUtils.FIELD_DELIMITER;
        }
        return str2.substring(0, str2.length() - 1);
    }

    /* access modifiers changed from: private */
    public void urlHttpGet(String str, HttpConfig httpConfig, Map<String, String> map, Map<String, String> map2, int i11, HttpCallback httpCallback) {
        final int i12 = i11 - 1;
        final HttpConfig httpConfig2 = httpConfig;
        final String str2 = str;
        final Map<String, String> map3 = map;
        final Map<String, String> map4 = map2;
        final HttpCallback httpCallback2 = httpCallback;
        final int i13 = i11;
        HttpTaskManager.execute(new Runnable() {
            public void run() {
                RealResponse data = new RealRequest().setHttpConfig(httpConfig2).getData(RequestHelper.this.getUrl(str2, map3), map4);
                int i11 = data.code;
                if (i11 == 200 || i11 == 204) {
                    HttpCallback httpCallback = httpCallback2;
                    if (httpCallback != null) {
                        httpCallback.onSuccess(data);
                    }
                } else if (RequestHelper.this.isRedirected || !HttpUtils.needRedirects(data.code)) {
                    int i12 = i12;
                    if (i12 != 0) {
                        RequestHelper.this.urlHttpGet(str2, httpConfig2, map3, map4, i12, httpCallback2);
                        return;
                    }
                    HttpCallback httpCallback2 = httpCallback2;
                    if (httpCallback2 != null) {
                        httpCallback2.onError(data);
                    }
                } else {
                    boolean unused = RequestHelper.this.isRedirected = true;
                    RequestHelper.this.urlHttpGet(data.location, httpConfig2, map3, map4, i13, httpCallback2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void urlHttpPost(String str, HttpConfig httpConfig, Map<String, String> map, String str2, Map<String, String> map2, int i11, HttpCallback httpCallback) {
        final int i12 = i11 - 1;
        final HttpConfig httpConfig2 = httpConfig;
        final String str3 = str;
        final Map<String, String> map3 = map;
        final String str4 = str2;
        final Map<String, String> map4 = map2;
        final HttpCallback httpCallback2 = httpCallback;
        final int i13 = i11;
        HttpTaskManager.execute(new Runnable() {
            public void run() {
                RealResponse postData = new RealRequest().setHttpConfig(httpConfig2).postData(str3, RequestHelper.this.getPostBody(map3, str4), RequestHelper.this.getPostBodyType(map3, str4), map4);
                int i11 = postData.code;
                if (i11 == 200 || i11 == 204) {
                    HttpCallback httpCallback = httpCallback2;
                    if (httpCallback != null) {
                        httpCallback.onSuccess(postData);
                    }
                } else if (RequestHelper.this.isRedirected || !HttpUtils.needRedirects(postData.code)) {
                    int i12 = i12;
                    if (i12 != 0) {
                        RequestHelper.this.urlHttpPost(str3, httpConfig2, map3, str4, map4, i12, httpCallback2);
                        return;
                    }
                    HttpCallback httpCallback2 = httpCallback2;
                    if (httpCallback2 != null) {
                        httpCallback2.onError(postData);
                    }
                } else {
                    boolean unused = RequestHelper.this.isRedirected = true;
                    RequestHelper.this.urlHttpPost(postData.location, httpConfig2, map3, str4, map4, i13, httpCallback2);
                }
            }
        });
    }

    private RequestHelper(HttpMethod httpMethod, String str, HttpConfig httpConfig, Map<String, String> map, Map<String, String> map2, int i11, HttpCallback httpCallback) {
        this.isRedirected = false;
        int i12 = AnonymousClass3.$SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod[httpMethod.ordinal()];
        if (i12 == 1) {
            urlHttpGet(str, httpConfig, map, map2, i11, httpCallback);
        } else if (i12 == 2) {
            urlHttpPost(str, httpConfig, map, "", map2, i11, httpCallback);
        }
    }

    private RequestHelper(String str, HttpConfig httpConfig, String str2, Map<String, String> map, int i11, HttpCallback httpCallback) {
        this.isRedirected = false;
        urlHttpPost(str, httpConfig, (Map<String, String>) null, str2, map, i11, httpCallback);
    }
}
