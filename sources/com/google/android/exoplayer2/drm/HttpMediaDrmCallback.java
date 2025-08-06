package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private static final int MAX_MANUAL_REDIRECTS = 5;
    private final HttpDataSource.Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map<String, String> keyRequestProperties;

    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    private static byte[] executePost(HttpDataSource.Factory factory, String str, byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        DataSourceInputStream dataSourceInputStream;
        StatsDataSource statsDataSource = new StatsDataSource(factory.createDataSource());
        DataSpec build = new DataSpec.Builder().setUri(str).setHttpRequestHeaders(map).setHttpMethod(2).setHttpBody(bArr).setFlags(1).build();
        int i11 = 0;
        DataSpec dataSpec = build;
        while (true) {
            try {
                dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpec);
                byte[] byteArray = Util.toByteArray(dataSourceInputStream);
                Util.closeQuietly((Closeable) dataSourceInputStream);
                return byteArray;
            } catch (HttpDataSource.InvalidResponseCodeException e11) {
                String redirectUrl = getRedirectUrl(e11, i11);
                if (redirectUrl != null) {
                    i11++;
                    dataSpec = dataSpec.buildUpon().setUri(redirectUrl).build();
                    Util.closeQuietly((Closeable) dataSourceInputStream);
                } else {
                    throw e11;
                }
            } catch (Exception e12) {
                throw new MediaDrmCallbackException(build, (Uri) Assertions.checkNotNull(statsDataSource.getLastOpenedUri()), statsDataSource.getResponseHeaders(), statsDataSource.getBytesRead(), e12);
            } catch (Throwable th2) {
                Util.closeQuietly((Closeable) dataSourceInputStream);
                throw th2;
            }
        }
    }

    private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i11) {
        Map<String, List<String>> map;
        List list;
        int i12 = invalidResponseCodeException.responseCode;
        if (((i12 == 307 || i12 == 308) && i11 < 5) && (map = invalidResponseCodeException.headerFields) != null && (list = map.get(HttpHeaders.LOCATION)) != null && !list.isEmpty()) {
            return (String) list.get(0);
        }
        return null;
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.clear();
        }
    }

    public void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.remove(str);
        }
    }

    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String str;
        String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.forceDefaultLicenseUrl || TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.defaultLicenseUrl;
        }
        if (!TextUtils.isEmpty(licenseServerUrl)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = C.PLAYREADY_UUID;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else {
                str = C.CLEARKEY_UUID.equals(uuid) ? "application/json" : "application/octet-stream";
            }
            hashMap.put("Content-Type", str);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.keyRequestProperties) {
                hashMap.putAll(this.keyRequestProperties);
            }
            return executePost(this.dataSourceFactory, licenseServerUrl, keyRequest.getData(), hashMap);
        }
        throw new MediaDrmCallbackException(new DataSpec.Builder().setUri(Uri.EMPTY).build(), Uri.EMPTY, ImmutableMap.of(), 0, new IllegalStateException("No license URL"));
    }

    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException {
        String defaultUrl = provisionRequest.getDefaultUrl();
        String fromUtf8Bytes = Util.fromUtf8Bytes(provisionRequest.getData());
        StringBuilder sb2 = new StringBuilder(String.valueOf(defaultUrl).length() + 15 + String.valueOf(fromUtf8Bytes).length());
        sb2.append(defaultUrl);
        sb2.append("&signedRequest=");
        sb2.append(fromUtf8Bytes);
        return executePost(this.dataSourceFactory, sb2.toString(), (byte[]) null, Collections.emptyMap());
    }

    public void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.put(str, str2);
        }
    }

    public HttpMediaDrmCallback(String str, boolean z11, HttpDataSource.Factory factory) {
        Assertions.checkArgument(!z11 || !TextUtils.isEmpty(str));
        this.dataSourceFactory = factory;
        this.defaultLicenseUrl = str;
        this.forceDefaultLicenseUrl = z11;
        this.keyRequestProperties = new HashMap();
    }
}
