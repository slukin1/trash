package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    private static final int HTTP_STATUS_PERMANENT_REDIRECT = 308;
    private static final int HTTP_STATUS_TEMPORARY_REDIRECT = 307;
    private static final long MAX_BYTES_TO_DRAIN = 2048;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "DefaultHttpDataSource";
    private final boolean allowCrossProtocolRedirects;
    private long bytesRead;
    private long bytesToRead;
    private final int connectTimeoutMillis;
    private HttpURLConnection connection;
    private Predicate<String> contentTypePredicate;
    private DataSpec dataSpec;
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    private InputStream inputStream;
    private boolean opened;
    private final int readTimeoutMillis;
    private final HttpDataSource.RequestProperties requestProperties;
    private int responseCode;
    private final String userAgent;

    public static final class Factory implements HttpDataSource.Factory {
        private boolean allowCrossProtocolRedirects;
        private int connectTimeoutMs = 8000;
        private Predicate<String> contentTypePredicate;
        private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
        private int readTimeoutMs = 8000;
        private TransferListener transferListener;
        private String userAgent;

        @Deprecated
        public final HttpDataSource.RequestProperties getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        public Factory setAllowCrossProtocolRedirects(boolean z11) {
            this.allowCrossProtocolRedirects = z11;
            return this;
        }

        public Factory setConnectTimeoutMs(int i11) {
            this.connectTimeoutMs = i11;
            return this;
        }

        public Factory setContentTypePredicate(Predicate<String> predicate) {
            this.contentTypePredicate = predicate;
            return this;
        }

        public Factory setReadTimeoutMs(int i11) {
            this.readTimeoutMs = i11;
            return this;
        }

        public Factory setTransferListener(TransferListener transferListener2) {
            this.transferListener = transferListener2;
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public final Factory setDefaultRequestProperties(Map<String, String> map) {
            this.defaultRequestProperties.clearAndSet(map);
            return this;
        }

        public DefaultHttpDataSource createDataSource() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.userAgent, this.connectTimeoutMs, this.readTimeoutMs, this.allowCrossProtocolRedirects, this.defaultRequestProperties, this.contentTypePredicate);
            TransferListener transferListener2 = this.transferListener;
            if (transferListener2 != null) {
                defaultHttpDataSource.addTransferListener(transferListener2);
            }
            return defaultHttpDataSource;
        }
    }

    private void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                Log.e(TAG, "Unexpected error while disconnecting", e11);
            }
            this.connection = null;
        }
    }

    private static URL handleRedirect(URL url, String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (Constants.SCHEME.equals(protocol) || "http".equals(protocol)) {
                return url2;
            }
            String valueOf = String.valueOf(protocol);
            throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
        }
        throw new ProtocolException("Null location redirect");
    }

    private static boolean isCompressed(HttpURLConnection httpURLConnection) {
        return DecompressionHelper.GZIP_ENCODING.equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
    }

    private HttpURLConnection makeConnection(DataSpec dataSpec2) throws IOException {
        HttpURLConnection makeConnection;
        DataSpec dataSpec3 = dataSpec2;
        URL url = new URL(dataSpec3.uri.toString());
        int i11 = dataSpec3.httpMethod;
        byte[] bArr = dataSpec3.httpBody;
        long j11 = dataSpec3.position;
        long j12 = dataSpec3.length;
        int i12 = 1;
        boolean isFlagSet = dataSpec3.isFlagSet(1);
        if (!this.allowCrossProtocolRedirects) {
            return makeConnection(url, i11, bArr, j11, j12, isFlagSet, true, dataSpec3.httpRequestHeaders);
        }
        int i13 = 0;
        while (true) {
            int i14 = i13 + 1;
            if (i13 <= 20) {
                Map<String, String> map = dataSpec3.httpRequestHeaders;
                int i15 = i14;
                byte[] bArr2 = bArr;
                int i16 = i12;
                long j13 = j12;
                long j14 = j11;
                makeConnection = makeConnection(url, i11, bArr, j11, j12, isFlagSet, false, map);
                int responseCode2 = makeConnection.getResponseCode();
                String headerField = makeConnection.getHeaderField(HttpHeaders.LOCATION);
                if ((i11 == i16 || i11 == 3) && (responseCode2 == 300 || responseCode2 == 301 || responseCode2 == 302 || responseCode2 == 303 || responseCode2 == 307 || responseCode2 == 308)) {
                    makeConnection.disconnect();
                    url = handleRedirect(url, headerField);
                } else if (i11 != 2 || (responseCode2 != 300 && responseCode2 != 301 && responseCode2 != 302 && responseCode2 != 303)) {
                    return makeConnection;
                } else {
                    makeConnection.disconnect();
                    url = handleRedirect(url, headerField);
                    bArr2 = null;
                    i11 = i16;
                }
                i13 = i15;
                i12 = i16;
                bArr = bArr2;
                j12 = j13;
                j11 = j14;
                dataSpec3 = dataSpec2;
            } else {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Too many redirects: ");
                sb2.append(i14);
                throw new NoRouteToHostException(sb2.toString());
            }
        }
        return makeConnection;
    }

    private static void maybeTerminateInputStream(HttpURLConnection httpURLConnection, long j11) {
        int i11;
        if (httpURLConnection != null && (i11 = Util.SDK_INT) >= 19 && i11 <= 20) {
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                if (j11 == -1) {
                    if (inputStream2.read() == -1) {
                        return;
                    }
                } else if (j11 <= 2048) {
                    return;
                }
                String name = inputStream2.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = ((Class) Assertions.checkNotNull(inputStream2.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream2, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int readInternal(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.bytesToRead;
        if (j11 != -1) {
            long j12 = j11 - this.bytesRead;
            if (j12 == 0) {
                return -1;
            }
            i12 = (int) Math.min((long) i12, j12);
        }
        int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        this.bytesRead += (long) read;
        bytesTransferred(read);
        return read;
    }

    private boolean skipFully(long j11) throws IOException {
        if (j11 == 0) {
            return true;
        }
        byte[] bArr = new byte[4096];
        while (j11 > 0) {
            int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, 0, (int) Math.min(j11, (long) 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            } else if (read == -1) {
                return false;
            } else {
                j11 -= (long) read;
                bytesTransferred(read);
            }
        }
        return true;
    }

    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream2 = this.inputStream;
            if (inputStream2 != null) {
                long j11 = this.bytesToRead;
                long j12 = -1;
                if (j11 != -1) {
                    j12 = j11 - this.bytesRead;
                }
                maybeTerminateInputStream(this.connection, j12);
                inputStream2.close();
            }
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e11) {
            throw new HttpDataSource.HttpDataSourceException(e11, (DataSpec) Util.castNonNull(this.dataSpec), 3);
        } catch (Throwable th2) {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th2;
        }
    }

    public int getResponseCode() {
        int i11;
        if (this.connection == null || (i11 = this.responseCode) <= 0) {
            return -1;
        }
        return i11;
    }

    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.connection;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public long open(DataSpec dataSpec2) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        DataSpec dataSpec3 = dataSpec2;
        this.dataSpec = dataSpec3;
        long j11 = 0;
        this.bytesRead = 0;
        this.bytesToRead = 0;
        transferInitializing(dataSpec2);
        try {
            HttpURLConnection makeConnection = makeConnection(dataSpec2);
            this.connection = makeConnection;
            try {
                this.responseCode = makeConnection.getResponseCode();
                String responseMessage = makeConnection.getResponseMessage();
                int i11 = this.responseCode;
                long j12 = -1;
                if (i11 < 200 || i11 > 299) {
                    Map headerFields = makeConnection.getHeaderFields();
                    if (this.responseCode == 416) {
                        if (dataSpec3.position == HttpUtil.getDocumentSize(makeConnection.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                            this.opened = true;
                            transferStarted(dataSpec2);
                            long j13 = dataSpec3.length;
                            if (j13 != -1) {
                                return j13;
                            }
                            return 0;
                        }
                    }
                    InputStream errorStream = makeConnection.getErrorStream();
                    if (errorStream != null) {
                        try {
                            bArr = Util.toByteArray(errorStream);
                        } catch (IOException unused) {
                            bArr = Util.EMPTY_BYTE_ARRAY;
                        }
                    } else {
                        bArr = Util.EMPTY_BYTE_ARRAY;
                    }
                    closeConnectionQuietly();
                    HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(this.responseCode, responseMessage, headerFields, dataSpec2, bArr);
                    if (this.responseCode == 416) {
                        invalidResponseCodeException.initCause(new DataSourceException(0));
                    }
                    throw invalidResponseCodeException;
                }
                String contentType = makeConnection.getContentType();
                Predicate<String> predicate = this.contentTypePredicate;
                if (predicate == null || predicate.apply(contentType)) {
                    if (this.responseCode == 200) {
                        long j14 = dataSpec3.position;
                        if (j14 != 0) {
                            j11 = j14;
                        }
                    }
                    boolean isCompressed = isCompressed(makeConnection);
                    if (!isCompressed) {
                        long j15 = dataSpec3.length;
                        if (j15 != -1) {
                            this.bytesToRead = j15;
                        } else {
                            long contentLength = HttpUtil.getContentLength(makeConnection.getHeaderField("Content-Length"), makeConnection.getHeaderField(HttpHeaders.CONTENT_RANGE));
                            if (contentLength != -1) {
                                j12 = contentLength - j11;
                            }
                            this.bytesToRead = j12;
                        }
                    } else {
                        this.bytesToRead = dataSpec3.length;
                    }
                    try {
                        this.inputStream = makeConnection.getInputStream();
                        if (isCompressed) {
                            this.inputStream = new GZIPInputStream(this.inputStream);
                        }
                        this.opened = true;
                        transferStarted(dataSpec2);
                        try {
                            if (skipFully(j11)) {
                                return this.bytesToRead;
                            }
                            throw new DataSourceException(0);
                        } catch (IOException e11) {
                            closeConnectionQuietly();
                            throw new HttpDataSource.HttpDataSourceException(e11, dataSpec3, 1);
                        }
                    } catch (IOException e12) {
                        closeConnectionQuietly();
                        throw new HttpDataSource.HttpDataSourceException(e12, dataSpec3, 1);
                    }
                } else {
                    closeConnectionQuietly();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec3);
                }
            } catch (IOException e13) {
                closeConnectionQuietly();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect", e13, dataSpec3, 1);
            }
        } catch (IOException e14) {
            String message = e14.getMessage();
            if (message == null || !Ascii.toLowerCase(message).matches("cleartext http traffic.*not permitted.*")) {
                throw new HttpDataSource.HttpDataSourceException("Unable to connect", e14, dataSpec3, 1);
            }
            throw new HttpDataSource.CleartextNotPermittedException(e14, dataSpec3);
        }
    }

    public HttpURLConnection openConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public int read(byte[] bArr, int i11, int i12) throws HttpDataSource.HttpDataSourceException {
        try {
            return readInternal(bArr, i11, i12);
        } catch (IOException e11) {
            throw new HttpDataSource.HttpDataSourceException(e11, (DataSpec) Util.castNonNull(this.dataSpec), 2);
        }
    }

    @Deprecated
    public void setContentTypePredicate(Predicate<String> predicate) {
        this.contentTypePredicate = predicate;
    }

    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    @Deprecated
    public DefaultHttpDataSource() {
        this((String) null, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(String str) {
        this(str, 8000, 8000);
    }

    @Deprecated
    public DefaultHttpDataSource(String str, int i11, int i12) {
        this(str, i11, i12, false, (HttpDataSource.RequestProperties) null);
    }

    @Deprecated
    public DefaultHttpDataSource(String str, int i11, int i12, boolean z11, HttpDataSource.RequestProperties requestProperties2) {
        this(str, i11, i12, z11, requestProperties2, (Predicate<String>) null);
    }

    private DefaultHttpDataSource(String str, int i11, int i12, boolean z11, HttpDataSource.RequestProperties requestProperties2, Predicate<String> predicate) {
        super(true);
        this.userAgent = str;
        this.connectTimeoutMillis = i11;
        this.readTimeoutMillis = i12;
        this.allowCrossProtocolRedirects = z11;
        this.defaultRequestProperties = requestProperties2;
        this.contentTypePredicate = predicate;
        this.requestProperties = new HttpDataSource.RequestProperties();
    }

    private HttpURLConnection makeConnection(URL url, int i11, byte[] bArr, long j11, long j12, boolean z11, boolean z12, Map<String, String> map) throws IOException {
        HttpURLConnection openConnection = openConnection(url);
        openConnection.setConnectTimeout(this.connectTimeoutMillis);
        openConnection.setReadTimeout(this.readTimeoutMillis);
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties2 = this.defaultRequestProperties;
        if (requestProperties2 != null) {
            hashMap.putAll(requestProperties2.getSnapshot());
        }
        hashMap.putAll(this.requestProperties.getSnapshot());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            openConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String buildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j11, j12);
        if (buildRangeRequestHeader != null) {
            openConnection.setRequestProperty(HttpHeaders.RANGE, buildRangeRequestHeader);
        }
        String str = this.userAgent;
        if (str != null) {
            openConnection.setRequestProperty("User-Agent", str);
        }
        openConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z11 ? DecompressionHelper.GZIP_ENCODING : "identity");
        openConnection.setInstanceFollowRedirects(z12);
        openConnection.setDoOutput(bArr != null);
        openConnection.setRequestMethod(DataSpec.getStringForHttpMethod(i11));
        if (bArr != null) {
            openConnection.setFixedLengthStreamingMode(bArr.length);
            openConnection.connect();
            OutputStream outputStream = openConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            openConnection.connect();
        }
        return openConnection;
    }
}
