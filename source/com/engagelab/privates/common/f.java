package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.appsflyer.AppsFlyerProperties;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;
import com.engagelab.privates.common.observer.MTObserver;
import com.engagelab.privates.common.utils.AESUtil;
import com.engagelab.privates.common.utils.GZipUtil;
import com.engagelab.privates.common.utils.SM4Util;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;
import com.huobi.finance.bean.LoanOrderItem;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f64959c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64960a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f64961b;

    public class a implements Comparator<File> {
        public a(f fVar) {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            int i11 = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
            if (i11 < 0) {
                return -1;
            }
            return i11 > 0 ? 1 : 0;
        }
    }

    public static f a() {
        if (f64959c == null) {
            synchronized (f.class) {
                f64959c = new f();
            }
        }
        return f64959c;
    }

    public void a(Context context, Bundle bundle) {
        try {
            bundle.setClassLoader(MTReporter.class.getClassLoader());
            if (!bundle.containsKey(MTCoreConstants.Protocol.KEY_PROTOCOL)) {
                a(context);
                return;
            }
            MTReporter mTReporter = (MTReporter) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            JSONObject jSONObject = new JSONObject(mTReporter.getContent());
            jSONObject.put("type", mTReporter.getType());
            JSONObject a11 = a(context, jSONObject);
            if (a11 != null) {
                if (a(context, mTReporter.getType(), a11, a(context, a11.toString())) == 0) {
                    a(context);
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTReportBusiness", "report failed " + th2.getMessage());
        }
    }

    public final int a(Context context, String str, JSONObject jSONObject, File file) {
        byte[] bArr;
        String str2 = str;
        try {
            if (!SystemUtil.isNetworkConnecting(context)) {
                MTCommonLog.d("MTReportBusiness", "can't report, network is disConnected");
                return -1;
            }
            long m11 = g.m(context);
            if (m11 == 0) {
                MTCommonLog.d("MTReportBusiness", "uid is 0");
                return -1;
            }
            Set<String> httpAddress = MTCoreGlobal.getHttpAddress(context);
            if (httpAddress.isEmpty()) {
                MTCommonLog.d("MTReportBusiness", "there are no report url");
                return -1;
            }
            jSONObject.put("uid", m11);
            byte[] zip = GZipUtil.zip(jSONObject.toString().getBytes("UTF-8"));
            String md5AesKey = AESUtil.getMd5AesKey((long) AESUtil.generateSeed());
            String iv2 = AESUtil.getIv(new String("\u000b\r\u0012PRQRVRWRT\u00032\tC".getBytes(), Charset.forName("UTF-8")), 'b');
            int encryptType = MTGlobal.getEncryptType();
            if (encryptType != 2) {
                bArr = AESUtil.encryptBytes(zip, md5AesKey, iv2);
                encryptType = 1;
            } else {
                bArr = SM4Util.encryptBytes(zip, md5AesKey, iv2);
            }
            String str3 = m11 + ":" + StringUtil.getBytesSHA1(m11 + StringUtil.getMD5Utf8(g.d(context)) + StringUtil.getBytesSHA1(bArr)) + ":" + md5AesKey;
            String str4 = "Basic " + Base64.encodeToString(str3.getBytes(), 10);
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i11 = 0; i11 < 3; i11++) {
                arrayList.addAll(httpAddress);
            }
            for (String str5 : arrayList) {
                if (str2.contains("sgm") && !str5.contains("/v3/sgm/report")) {
                    str5 = str5 + "/v3/sgm/report";
                }
                if (!str2.contains("sgm") && !str5.contains("/v3/report")) {
                    str5 = str5 + "/v3/report";
                }
                int a11 = i.a(context, str5, str4, bArr);
                if (a11 == 200) {
                    MTCommonLog.d("MTReportBusiness", "report success encrypt:" + encryptType + ", url:" + str5 + ", fileName:" + file.getName() + MTCommonLog.toLogString(jSONObject));
                    if (!file.exists()) {
                        return 0;
                    }
                    boolean delete = file.delete();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("delete ");
                    sb2.append(delete ? "success" : LoanOrderItem.FAILED);
                    sb2.append(" file:");
                    sb2.append(file.getAbsolutePath());
                    MTCommonLog.d("MTReportBusiness", sb2.toString());
                    return 0;
                }
                MTCommonLog.d("MTReportBusiness", "report failed code:" + a11 + ", url:" + str5 + ", fileName:" + file.getName() + MTCommonLog.toLogString(jSONObject));
                str2 = str;
            }
            return -1;
        } catch (Throwable th2) {
            MTCommonLog.w("MTReportBusiness", "report failed " + th2.getMessage());
            return -1;
        }
    }

    public File a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(this.f64961b)) {
                File filesDir = context.getFilesDir();
                String appKey = MTGlobal.getAppKey(context);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(filesDir.getAbsolutePath());
                String str2 = File.separator;
                sb2.append(str2);
                sb2.append("com_engagelab_privates_core");
                sb2.append(str2);
                sb2.append(appKey);
                this.f64961b = sb2.toString();
            }
            String str3 = this.f64961b + File.separator + System.currentTimeMillis();
            MTCommonLog.d("MTReportBusiness", "save file:" + str3);
            File file = new File(str3);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return null;
            }
            if (!file.exists() && !file.createNewFile()) {
                return null;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes("UTF-8"));
            fileOutputStream.close();
            return file;
        } catch (Throwable th2) {
            MTCommonLog.w("MTReportBusiness", "saveReportContent failed " + th2.getMessage());
            return null;
        }
    }

    public final JSONObject a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("itime", System.currentTimeMillis() / 1000);
            jSONObject.put("account_id", "");
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject2.put("content", jSONArray);
            jSONObject2.put("platform", "a");
            jSONObject2.put("uid", g.m(context));
            jSONObject2.put(Constants.EXTRA_KEY_APP_VERSION, MTGlobal.getAppVersionName(context));
            jSONObject2.put("app_key", MTGlobal.getAppKey(context));
            jSONObject2.put(AppsFlyerProperties.CHANNEL, MTGlobal.getAppChannel(context));
            Iterator<MTObserver> it2 = MTObservable.getInstance().observeQueue.iterator();
            while (it2.hasNext()) {
                MTObserver next = it2.next();
                if (next.isSdk()) {
                    if (!TextUtils.isEmpty(next.getSdkName())) {
                        if (!TextUtils.isEmpty(next.getSdkVersion())) {
                            jSONObject2.put(next.getSdkName(), next.getSdkVersion());
                        }
                    }
                }
            }
            return jSONObject2;
        } catch (Throwable th2) {
            MTCommonLog.w("MTReportBusiness", "prepareReportJson failed " + th2.getMessage());
            return null;
        }
    }

    public synchronized void a(Context context) {
        if (!this.f64960a) {
            MTCommonLog.d("MTReportBusiness", "report cache begin");
            this.f64960a = true;
            if (TextUtils.isEmpty(this.f64961b)) {
                this.f64960a = false;
                MTCommonLog.d("MTReportBusiness", "there are no report cache");
                return;
            }
            File file = new File(this.f64961b);
            if (!file.exists()) {
                this.f64960a = false;
                MTCommonLog.d("MTReportBusiness", "there are no report cache");
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                if (listFiles.length != 0) {
                    List<File> asList = Arrays.asList(listFiles);
                    Collections.sort(asList, new a(this));
                    for (File file2 : asList) {
                        if (!file2.exists()) {
                            MTCommonLog.d("MTReportBusiness", "cacheFile [" + file2.getAbsolutePath() + "] is no exist");
                        } else {
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file2);
                                byte[] bArr = new byte[fileInputStream.available()];
                                fileInputStream.read(bArr);
                                fileInputStream.close();
                                String str = new String(bArr, "UTF-8");
                                if (!TextUtils.isEmpty(str)) {
                                    JSONObject jSONObject = new JSONObject(str);
                                    String optString = jSONObject.optString("type");
                                    MTCommonLog.d("MTReportBusiness", "reportCache file:" + file2.getAbsolutePath());
                                    a(context, optString, jSONObject, file2);
                                } else {
                                    return;
                                }
                            } catch (Throwable th2) {
                                MTCommonLog.w("MTReportBusiness", "reportCache failed " + th2.getMessage());
                            }
                        }
                    }
                    this.f64960a = false;
                    MTCommonLog.d("MTReportBusiness", "report cache finish");
                    return;
                }
            }
            this.f64960a = false;
            MTCommonLog.d("MTReportBusiness", "there are no report cache");
        }
    }
}
