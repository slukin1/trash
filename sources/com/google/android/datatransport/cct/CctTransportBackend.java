package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.facebook.places.model.PlaceFields;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.common.net.HttpHeaders;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

final class CctTransportBackend implements TransportBackend {
    private static final String ACCEPT_ENCODING_HEADER_KEY = "Accept-Encoding";
    public static final String API_KEY_HEADER_KEY = "X-Goog-Api-Key";
    private static final int CONNECTION_TIME_OUT = 30000;
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final int INVALID_VERSION_CODE = -1;
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final String KEY_APPLICATION_BUILD = "application_build";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_DEVICE = "device";
    private static final String KEY_FINGERPRINT = "fingerprint";
    private static final String KEY_HARDWARE = "hardware";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_MANUFACTURER = "manufacturer";
    private static final String KEY_MCC_MNC = "mcc_mnc";
    public static final String KEY_MOBILE_SUBTYPE = "mobile-subtype";
    private static final String KEY_MODEL = "model";
    public static final String KEY_NETWORK_TYPE = "net-type";
    private static final String KEY_OS_BUILD = "os-uild";
    private static final String KEY_PRODUCT = "product";
    private static final String KEY_SDK_VERSION = "sdk-version";
    private static final String KEY_TIMEZONE_OFFSET = "tz-offset";
    private static final String LOG_TAG = "CctTransportBackend";
    private static final int READ_TIME_OUT = 130000;
    private final Context applicationContext;
    private final ConnectivityManager connectivityManager;
    private final DataEncoder dataEncoder;
    public final URL endPoint;
    private final int readTimeout;
    private final Clock uptimeClock;
    private final Clock wallTimeClock;

    public static final class HttpRequest {
        public final String apiKey;
        public final BatchedLogRequest requestBody;
        public final URL url;

        public HttpRequest(URL url2, BatchedLogRequest batchedLogRequest, String str) {
            this.url = url2;
            this.requestBody = batchedLogRequest;
            this.apiKey = str;
        }

        public HttpRequest withUrl(URL url2) {
            return new HttpRequest(url2, this.requestBody, this.apiKey);
        }
    }

    public static final class HttpResponse {
        public final int code;
        public final long nextRequestMillis;
        public final URL redirectUrl;

        public HttpResponse(int i11, URL url, long j11) {
            this.code = i11;
            this.redirectUrl = url;
            this.nextRequestMillis = j11;
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2, int i11) {
        this.dataEncoder = BatchedLogRequest.createDataEncoder();
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = i11;
    }

    /* access modifiers changed from: private */
    public HttpResponse doSend(HttpRequest httpRequest) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        InputStream maybeUnGzip;
        Logging.i(LOG_TAG, "Making request to: %s", httpRequest.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", new Object[]{"3.1.9"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = httpRequest.apiKey;
        if (str != null) {
            httpURLConnection.setRequestProperty(API_KEY_HEADER_KEY, str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                this.dataEncoder.encode(httpRequest.requestBody, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                Logging.i(LOG_TAG, "Status Code: %d", Integer.valueOf(responseCode));
                Logging.d(LOG_TAG, "Content-Type: %s", (Object) httpURLConnection.getHeaderField("Content-Type"));
                Logging.d(LOG_TAG, "Content-Encoding: %s", (Object) httpURLConnection.getHeaderField("Content-Encoding"));
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)), 0);
                }
                if (responseCode != 200) {
                    return new HttpResponse(responseCode, (URL) null, 0);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    maybeUnGzip = maybeUnGzip(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                    HttpResponse httpResponse = new HttpResponse(responseCode, (URL) null, LogResponse.fromJson(new BufferedReader(new InputStreamReader(maybeUnGzip))).getNextRequestWaitMillis());
                    if (maybeUnGzip != null) {
                        maybeUnGzip.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return httpResponse;
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
                throw th;
                throw th;
            } catch (Throwable th4) {
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th4;
            }
        } catch (ConnectException | UnknownHostException e11) {
            Logging.e(LOG_TAG, "Couldn't open connection, returning with 500", e11);
            return new HttpResponse(500, (URL) null, 0);
        } catch (EncodingException | IOException e12) {
            Logging.e(LOG_TAG, "Couldn't encode request, returning with 400", e12);
            return new HttpResponse(400, (URL) null, 0);
        } catch (Throwable th5) {
            th4.addSuppressed(th5);
        }
    }

    private static int getNetSubtypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int getNetTypeValue(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }

    private static int getPackageVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            Logging.e(LOG_TAG, "Unable to find version code for package", e11);
            return -1;
        }
    }

    private BatchedLogRequest getRequestBody(BackendRequest backendRequest) {
        LogEvent.Builder builder;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.getEvents()) {
            String transportName = next.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder clientInfo = LogRequest.builder().setQosTier(QosTier.DEFAULT).setRequestTimeMs(this.wallTimeClock.getTime()).setRequestUptimeMs(this.uptimeClock.getTime()).setClientInfo(ClientInfo.builder().setClientType(ClientInfo.ClientType.ANDROID_FIREBASE).setAndroidClientInfo(AndroidClientInfo.builder().setSdkVersion(Integer.valueOf(eventInternal.getInteger(KEY_SDK_VERSION))).setModel(eventInternal.get("model")).setHardware(eventInternal.get("hardware")).setDevice(eventInternal.get("device")).setProduct(eventInternal.get(KEY_PRODUCT)).setOsBuild(eventInternal.get(KEY_OS_BUILD)).setManufacturer(eventInternal.get(KEY_MANUFACTURER)).setFingerprint(eventInternal.get("fingerprint")).setCountry(eventInternal.get("country")).setLocale(eventInternal.get(KEY_LOCALE)).setMccMnc(eventInternal.get(KEY_MCC_MNC)).setApplicationBuild(eventInternal.get(KEY_APPLICATION_BUILD)).build()).build());
            try {
                clientInfo.setSource(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                clientInfo.setSource((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal2.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.of("proto"))) {
                    builder = LogEvent.protoBuilder(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.of(MTPushConstants.Analysis.KEY_JSON))) {
                    builder = LogEvent.jsonBuilder(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.w(LOG_TAG, "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                builder.setEventTimeMs(eventInternal2.getEventMillis()).setEventUptimeMs(eventInternal2.getUptimeMillis()).setTimezoneOffsetSeconds(eventInternal2.getLong(KEY_TIMEZONE_OFFSET)).setNetworkConnectionInfo(NetworkConnectionInfo.builder().setNetworkType(NetworkConnectionInfo.NetworkType.forNumber(eventInternal2.getInteger(KEY_NETWORK_TYPE))).setMobileSubtype(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal2.getInteger(KEY_MOBILE_SUBTYPE))).build());
                if (eventInternal2.getCode() != null) {
                    builder.setEventCode(eventInternal2.getCode());
                }
                arrayList3.add(builder.build());
            }
            clientInfo.setLogEvents(arrayList3);
            arrayList2.add(clientInfo.build());
        }
        return BatchedLogRequest.create(arrayList2);
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
    }

    public static long getTzOffset() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ HttpRequest lambda$send$0(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.redirectUrl;
        if (url == null) {
            return null;
        }
        Logging.d(LOG_TAG, "Following redirect to: %s", (Object) url);
        return httpRequest.withUrl(httpResponse.redirectUrl);
    }

    private static InputStream maybeUnGzip(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e11) {
            throw new IllegalArgumentException("Invalid url: " + str, e11);
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return eventInternal.toBuilder().addMetadata(KEY_SDK_VERSION, Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata(KEY_PRODUCT, Build.PRODUCT).addMetadata(KEY_OS_BUILD, Build.ID).addMetadata(KEY_MANUFACTURER, Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT).addMetadata(KEY_TIMEZONE_OFFSET, getTzOffset()).addMetadata(KEY_NETWORK_TYPE, getNetTypeValue(activeNetworkInfo)).addMetadata(KEY_MOBILE_SUBTYPE, getNetSubtypeValue(activeNetworkInfo)).addMetadata("country", Locale.getDefault().getCountry()).addMetadata(KEY_LOCALE, Locale.getDefault().getLanguage()).addMetadata(KEY_MCC_MNC, getTelephonyManager(this.applicationContext).getSimOperator()).addMetadata(KEY_APPLICATION_BUILD, Integer.toString(getPackageVersionCode(this.applicationContext))).build();
    }

    public BackendResponse send(BackendRequest backendRequest) {
        BatchedLogRequest requestBody = getRequestBody(backendRequest);
        URL url = this.endPoint;
        String str = null;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    str = fromByteArray.getAPIKey();
                }
                if (fromByteArray.getEndPoint() != null) {
                    url = parseUrlOrThrow(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.fatalError();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.retry(5, new HttpRequest(url, requestBody, str), new a(this), b.f65593a);
            int i11 = httpResponse.code;
            if (i11 == 200) {
                return BackendResponse.ok(httpResponse.nextRequestMillis);
            }
            if (i11 < 500) {
                if (i11 != 404) {
                    if (i11 == 400) {
                        return BackendResponse.invalidPayload();
                    }
                    return BackendResponse.fatalError();
                }
            }
            return BackendResponse.transientError();
        } catch (IOException e11) {
            Logging.e(LOG_TAG, "Could not make request to the backend", e11);
            return BackendResponse.transientError();
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, READ_TIME_OUT);
    }
}
