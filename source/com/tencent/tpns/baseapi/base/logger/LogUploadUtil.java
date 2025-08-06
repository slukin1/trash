package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.jumio.commons.log.LogUtils;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.core.a;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

public class LogUploadUtil {

    /* renamed from: a  reason: collision with root package name */
    private static int f49766a;

    /* access modifiers changed from: private */
    public static void b(Context context, String str, String str2, String str3, HttpRequestCallback httpRequestCallback) {
        if (context == null) {
            TBaseLogger.w("LogUploadUtil - TPush", "unexpected for uploadFile, context is null");
            a(httpRequestCallback, -1, "context is null");
        } else if (TextUtils.isEmpty(str)) {
            TBaseLogger.w("LogUploadUtil - TPush", "unexpected for uploadFile, log cannot be found");
            a(httpRequestCallback, -1, "unexpected for uploadFile, log cannot be found");
        } else {
            try {
                long accessId = XGApiConfig.getAccessId(context);
                if (accessId == -1) {
                    a(httpRequestCallback, -1, "unexpected for uploadFile, log cannot be found");
                    return;
                }
                String token = GuidInfoManager.getToken(context);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                String str4 = File.separator;
                sb2.append(str4);
                sb2.append(str2);
                String sb3 = sb2.toString();
                String str5 = str + str4 + str3;
                String str6 = str5 + str4 + accessId + "_" + token + "_" + LogUtil.getTodayDateTimeForFilename() + ".zip";
                File file = new File(str6);
                file.getParentFile().mkdirs();
                if (!file.exists() && !file.createNewFile()) {
                    TBaseLogger.w("LogUploadUtil - TPush", "unexpected createNewFile return false");
                }
                a(sb3, str6);
                if (file.length() > 104857600) {
                    a(httpRequestCallback, -1, "log upload error, please try again.");
                    a(str5);
                    int i11 = f49766a + 1;
                    f49766a = i11;
                    TBaseLogger.removeOldDebugLogFiles(i11);
                    return;
                }
                a(context, file, a.h(context), httpRequestCallback);
                a(str5);
                a(sb3);
            } catch (Throwable th2) {
                TBaseLogger.w("LogUploadUtil - TPush", "unexpected exception for uploadFile:" + th2.getMessage());
                a(httpRequestCallback, -1, "unexpected exception for uploadFile:" + th2.getMessage());
            }
        }
    }

    public static void uploadFile(Context context, String str, String str2, String str3, HttpRequestCallback httpRequestCallback) {
        final Context context2 = context;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final HttpRequestCallback httpRequestCallback2 = httpRequestCallback;
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                LogUploadUtil.b(context2, str4, str5, str6, httpRequestCallback2);
            }
        });
    }

    private static void a(Context context, File file, String str, HttpRequestCallback httpRequestCallback) {
        File file2 = file;
        String str2 = str;
        HttpRequestCallback httpRequestCallback2 = httpRequestCallback;
        String str3 = "TPNS" + System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty("connection", "keep-alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + str3);
            long accessId = XGApiConfig.getAccessId(context);
            String accessKey = XGApiConfig.getAccessKey(context);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Basic ");
            sb2.append(Base64.encodeToString((accessId + ":" + accessKey).getBytes("UTF-8"), 0));
            String sb3 = sb2.toString();
            httpURLConnection.addRequestProperty("Authorization", sb3);
            TBaseLogger.d("LogUploadUtil - TPush", "Authorization Basic: " + accessId + ":" + accessKey + ", auth:" + sb3);
            if (file2 != null) {
                TBaseLogger.v("LogUploadUtil - TPush", "action - uploadFile, filename:" + file.getName() + ", url:" + str2);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("--");
                stringBuffer.append(str3);
                stringBuffer.append(LogUtils.NEW_LINE);
                stringBuffer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"" + LogUtils.NEW_LINE);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Content-Type: application/octet-stream; charset=utf-8");
                sb4.append(LogUtils.NEW_LINE);
                stringBuffer.append(sb4.toString());
                stringBuffer.append(LogUtils.NEW_LINE);
                dataOutputStream.write(stringBuffer.toString().getBytes());
                FileInputStream fileInputStream = new FileInputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.write(LogUtils.NEW_LINE.getBytes());
                dataOutputStream.write(("--" + str3 + "--" + LogUtils.NEW_LINE).getBytes());
                dataOutputStream.flush();
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                TBaseLogger.v("LogUploadUtil - TPush", "response code:" + responseCode + ", msg:" + responseMessage);
                if (responseCode == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuffer stringBuffer2 = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer2.append(readLine);
                        } else {
                            TBaseLogger.i("LogUploadUtil - TPush", "HttpPost response data:" + stringBuffer2.toString());
                            a(httpRequestCallback2, responseCode, responseMessage, stringBuffer2.toString());
                            bufferedReader.close();
                            return;
                        }
                    }
                } else {
                    TBaseLogger.e("LogUploadUtil - TPush", "HttpPost Server response error");
                    a(httpRequestCallback2, responseCode, responseMessage);
                }
            }
        } catch (Throwable th2) {
            TBaseLogger.e("LogUploadUtil - TPush", "unexpected for doUploadFile:", th2);
            a(httpRequestCallback2, -1, "unexpected exception for uploadFile:" + th2.getMessage());
        }
    }

    private static void a(String str, String str2) {
        TBaseLogger.v("LogUploadUtil - TPush", "zipFolder, srcFile:" + str + ", zipFile:" + str2);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            throw new NoSuchFieldException("no log files");
        }
        a(file.getParent() + File.separator, file.getName(), zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r5, java.lang.String r6, java.util.zip.ZipOutputStream r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "zipFiles, folder:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = ", fileName:"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "LogUploadUtil - TPush"
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.v(r1, r0)
            if (r7 != 0) goto L_0x0021
            return
        L_0x0021:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.isFile()
            r2 = 0
            if (r1 == 0) goto L_0x0067
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry
            r5.<init>(r6)
            r6 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0061 }
            r1.<init>(r0)     // Catch:{ all -> 0x0061 }
            r7.putNextEntry(r5)     // Catch:{ all -> 0x0060 }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x0060 }
        L_0x004e:
            int r6 = r1.read(r5)     // Catch:{ all -> 0x0060 }
            r0 = -1
            if (r6 == r0) goto L_0x0059
            r7.write(r5, r2, r6)     // Catch:{ all -> 0x0060 }
            goto L_0x004e
        L_0x0059:
            r7.closeEntry()     // Catch:{ all -> 0x0060 }
            r1.close()     // Catch:{ all -> 0x0060 }
            goto L_0x00ac
        L_0x0060:
            r6 = r1
        L_0x0061:
            if (r6 == 0) goto L_0x00ac
            r6.close()
            goto L_0x00ac
        L_0x0067:
            java.lang.String[] r0 = r0.list()
            if (r0 != 0) goto L_0x006e
            return
        L_0x006e:
            int r1 = r0.length
            if (r1 > 0) goto L_0x008d
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            java.lang.String r4 = java.io.File.separator
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r3)
            r7.putNextEntry(r1)
            r7.closeEntry()
        L_0x008d:
            int r1 = r0.length
            if (r2 >= r1) goto L_0x00ac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r3 = java.io.File.separator
            r1.append(r3)
            r3 = r0[r2]
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            a((java.lang.String) r5, (java.lang.String) r1, (java.util.zip.ZipOutputStream) r7)
            int r2 = r2 + 1
            goto L_0x008d
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.base.logger.LogUploadUtil.a(java.lang.String, java.lang.String, java.util.zip.ZipOutputStream):void");
    }

    private static void a(HttpRequestCallback httpRequestCallback, int i11, String str) {
        if (httpRequestCallback != null) {
            httpRequestCallback.onFailure(i11, str);
        }
    }

    private static void a(HttpRequestCallback httpRequestCallback, int i11, String str, String str2) {
        if (httpRequestCallback != null) {
            try {
                String optString = new JSONObject(str2).optString("url", "");
                TBaseLogger.v("LogUploadUtil - TPush", "fileUrl:" + optString);
                httpRequestCallback.onSuccess(optString);
            } catch (Throwable unused) {
                httpRequestCallback.onFailure(i11, str + "\n" + str2);
            }
        }
    }

    private static void a(String str) {
        a(new File(str));
    }

    private static void a(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2 != null) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (file2.isDirectory()) {
                        a(file2);
                    }
                }
            }
        }
    }
}
