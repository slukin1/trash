package jumio.core;

import com.adjust.sdk.Constants;
import com.jumio.commons.log.Log;
import com.jumio.core.ServiceLocator;
import com.jumio.core.ServiceLocatorInterface;
import com.jumio.core.models.DataDogModel;
import com.jumio.core.network.TrustManagerInterface;
import com.jumio.core.plugins.AnalyticsPlugin;
import d10.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    public HttpsURLConnection f56138a;

    public final a1 a(String str, int i11, AnalyticsPlugin<DataDogModel> analyticsPlugin, String str2) throws IllegalArgumentException {
        URL url = new URL(str);
        if (url.getProtocol().equals(Constants.SCHEME)) {
            this.f56138a = (HttpsURLConnection) url.openConnection();
            HttpsURLConnection httpsURLConnection = null;
            TrustManagerInterface trustManagerInterface = (TrustManagerInterface) ServiceLocatorInterface.DefaultImpls.getServiceImplementation$default(ServiceLocator.INSTANCE, TrustManagerInterface.class, (a) null, 2, (Object) null);
            trustManagerInterface.setHostname(url.getHost());
            HttpsURLConnection httpsURLConnection2 = this.f56138a;
            if (httpsURLConnection2 == null) {
                httpsURLConnection2 = null;
            }
            httpsURLConnection2.setSSLSocketFactory(new s2(new TrustManagerInterface[]{trustManagerInterface}));
            HttpsURLConnection httpsURLConnection3 = this.f56138a;
            if (httpsURLConnection3 == null) {
                httpsURLConnection3 = null;
            }
            httpsURLConnection3.setDoInput(true);
            HttpsURLConnection httpsURLConnection4 = this.f56138a;
            if (httpsURLConnection4 == null) {
                httpsURLConnection4 = null;
            }
            httpsURLConnection4.setConnectTimeout(i11);
            HttpsURLConnection httpsURLConnection5 = this.f56138a;
            if (httpsURLConnection5 == null) {
                httpsURLConnection5 = null;
            }
            httpsURLConnection5.setReadTimeout(i11);
            if (analyticsPlugin != null) {
                HttpsURLConnection httpsURLConnection6 = this.f56138a;
                if (httpsURLConnection6 == null) {
                    httpsURLConnection6 = null;
                }
                analyticsPlugin.reportRequest(str2, str, 0, httpsURLConnection6.getRequestMethod());
            }
            HttpsURLConnection httpsURLConnection7 = this.f56138a;
            if (httpsURLConnection7 == null) {
                httpsURLConnection7 = null;
            }
            httpsURLConnection7.connect();
            HttpsURLConnection httpsURLConnection8 = this.f56138a;
            if (httpsURLConnection8 == null) {
                httpsURLConnection8 = null;
            }
            int responseCode = httpsURLConnection8.getResponseCode();
            if (analyticsPlugin != null) {
                HttpsURLConnection httpsURLConnection9 = this.f56138a;
                if (httpsURLConnection9 == null) {
                    httpsURLConnection9 = null;
                }
                AnalyticsPlugin.DefaultImpls.reportResponse$default(analyticsPlugin, str2, str, Integer.valueOf(httpsURLConnection9.getContentLength()), responseCode, (Exception) null, 16, (Object) null);
            }
            HttpsURLConnection httpsURLConnection10 = this.f56138a;
            if (httpsURLConnection10 == null) {
                httpsURLConnection10 = null;
            }
            int contentLength = httpsURLConnection10.getContentLength();
            HttpsURLConnection httpsURLConnection11 = this.f56138a;
            if (httpsURLConnection11 != null) {
                httpsURLConnection = httpsURLConnection11;
            }
            return new a1(responseCode, contentLength, httpsURLConnection.getInputStream());
        }
        throw new IllegalArgumentException("Only https DownloadTasks are supported!");
    }

    public final void a() {
        HttpsURLConnection httpsURLConnection = this.f56138a;
        if (httpsURLConnection != null) {
            try {
                InputStream inputStream = httpsURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e11) {
                Log.printStackTrace(e11);
            }
            HttpsURLConnection httpsURLConnection2 = null;
            try {
                HttpsURLConnection httpsURLConnection3 = this.f56138a;
                if (httpsURLConnection3 == null) {
                    httpsURLConnection3 = null;
                }
                if (httpsURLConnection3.getDoOutput()) {
                    HttpsURLConnection httpsURLConnection4 = this.f56138a;
                    if (httpsURLConnection4 == null) {
                        httpsURLConnection4 = null;
                    }
                    OutputStream outputStream = httpsURLConnection4.getOutputStream();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            } catch (Exception e12) {
                Log.printStackTrace(e12);
            }
            try {
                HttpsURLConnection httpsURLConnection5 = this.f56138a;
                if (httpsURLConnection5 == null) {
                    httpsURLConnection5 = null;
                }
                InputStream errorStream = httpsURLConnection5.getErrorStream();
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (Exception e13) {
                Log.printStackTrace(e13);
            }
            HttpsURLConnection httpsURLConnection6 = this.f56138a;
            if (httpsURLConnection6 != null) {
                httpsURLConnection2 = httpsURLConnection6;
            }
            httpsURLConnection2.disconnect();
        }
    }
}
