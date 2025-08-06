package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import com.jumio.core.cdn.CDNDownload;
import com.jumio.sdk.reject.JumioRejectReason;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.b.c;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class ac {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27008a = s.a("002Sfcgc");

    /* renamed from: b  reason: collision with root package name */
    private static final String f27009b = s.a("0056dldkOjie");

    /* renamed from: c  reason: collision with root package name */
    private static final String f27010c = s.a("005'dldkUjZdc!e");

    /* renamed from: d  reason: collision with root package name */
    private static final String f27011d = s.a("016Bhfhejfhlhihhikhdhjfh8d5ffXcKdcefdi");

    /* renamed from: e  reason: collision with root package name */
    private static ac f27012e;

    /* renamed from: f  reason: collision with root package name */
    private String f27013f;

    /* renamed from: g  reason: collision with root package name */
    private Context f27014g = MobSDK.getContext();

    /* renamed from: h  reason: collision with root package name */
    private TreeMap<String, Object> f27015h;

    private ac() {
    }

    public static ac a() {
        if (f27012e == null) {
            synchronized (ac.class) {
                if (f27012e == null) {
                    f27012e = new ac();
                }
            }
        }
        return f27012e;
    }

    private String d() {
        this.f27015h = new TreeMap<>();
        String str = null;
        try {
            String e11 = e();
            boolean a11 = a(f());
            if (TextUtils.isEmpty(e11)) {
                str = a(this.f27015h);
            } else {
                NLog instance = MobLog.getInstance();
                instance.d("[%s] %s", f27008a, "tk status: " + a11);
                if (!a11) {
                    str = e11;
                } else {
                    str = a(this.f27015h);
                }
            }
            f27012e.f27013f = str;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        return str;
    }

    private String e() {
        InputStream inputStream;
        DataInputStream dataInputStream;
        String str;
        DataInputStream dataInputStream2 = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.f27014g, f27009b);
            if (!dataCacheFile.exists() || dataCacheFile.length() <= 0) {
                str = null;
                inputStream = null;
            } else {
                inputStream = new FileInputStream(dataCacheFile);
                try {
                    dataInputStream = new DataInputStream(inputStream);
                    try {
                        DataInputStream dataInputStream3 = dataInputStream;
                        str = dataInputStream.readUTF();
                        dataInputStream2 = dataInputStream3;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            MobLog.getInstance().d(th);
                            return null;
                        } finally {
                            v.a(dataInputStream, inputStream);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                    MobLog.getInstance().d(th);
                    return null;
                }
            }
            v.a(dataInputStream2, inputStream);
            return str;
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            inputStream = dataInputStream;
            MobLog.getInstance().d(th);
            return null;
        }
    }

    private HashMap<String, Object> f() {
        return a(f27011d, ResHelper.readFromFileNoCompress(ResHelper.getDataCacheFile(this.f27014g, f27010c)));
    }

    public String b() {
        if (TextUtils.isEmpty(this.f27013f)) {
            synchronized (ac.class) {
                if (TextUtils.isEmpty(this.f27013f)) {
                    String d11 = d();
                    return d11;
                }
            }
        }
        return this.f27013f;
    }

    public String c() {
        String str = this.f27013f;
        return TextUtils.isEmpty(str) ? e() : str;
    }

    private boolean a(HashMap<String, Object> hashMap) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] strArr = new String[1];
        DH.requester(MobSDK.getContext()).getDeviceKey().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                strArr[0] = dHResponse.getDeviceKey();
                countDownLatch.countDown();
            }
        });
        try {
            this.f27015h.put(s.a("007CefZdciOdkdjec"), DH.SyncMtd.getManufacturer());
            this.f27015h.put(s.a("005$dfdkdcNfg"), DH.SyncMtd.getModel());
            this.f27015h.put(s.a("006MfiecfiddMf,dj"), Integer.valueOf(DH.SyncMtd.getOSVersionInt()));
            countDownLatch.await(100, TimeUnit.MILLISECONDS);
            String str = strArr[0];
            if (!TextUtils.isEmpty(str)) {
                this.f27015h.put(s.a("0086dc5fCdddiFcfFeedc"), str);
            }
            this.f27015h.put(s.a("004Gdcdgdidc"), e.a((MobProduct) null));
            String MD5 = Data.MD5(new JSONObject(this.f27015h).toString());
            TreeMap treeMap = new TreeMap();
            treeMap.put(s.a("010Vej!fefHdjYdg1hcdchi"), MD5);
            b((TreeMap<String, Object>) treeMap);
            if (hashMap == null || hashMap.isEmpty() || !MD5.equals((String) hashMap.get(s.a("010JejRfef djLdg)hcdchi")))) {
                return true;
            }
            MobLog.getInstance().d("[%s] %s", f27008a, "No changes");
            return false;
        } catch (Throwable th2) {
            MobLog.getInstance().e(th2);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            r3 = 2
            android.content.Context r4 = r6.f27014g     // Catch:{ all -> 0x0030 }
            java.lang.String r5 = f27009b     // Catch:{ all -> 0x0030 }
            java.io.File r4 = com.mob.tools.utils.ResHelper.getDataCacheFile(r4, r5)     // Catch:{ all -> 0x0030 }
            if (r4 == 0) goto L_0x0025
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0030 }
            r5.<init>(r4)     // Catch:{ all -> 0x0030 }
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ all -> 0x0023 }
            r4.<init>(r5)     // Catch:{ all -> 0x0023 }
            r4.writeUTF(r7)     // Catch:{ all -> 0x0020 }
            r4.flush()     // Catch:{ all -> 0x0020 }
            r0 = r4
            goto L_0x0026
        L_0x0020:
            r7 = move-exception
            r0 = r4
            goto L_0x0032
        L_0x0023:
            r7 = move-exception
            goto L_0x0032
        L_0x0025:
            r5 = r0
        L_0x0026:
            java.io.Closeable[] r7 = new java.io.Closeable[r3]
            r7[r2] = r0
            r7[r1] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r7)
            goto L_0x0042
        L_0x0030:
            r7 = move-exception
            r5 = r0
        L_0x0032:
            com.mob.tools.log.NLog r4 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0043 }
            r4.d(r7)     // Catch:{ all -> 0x0043 }
            java.io.Closeable[] r7 = new java.io.Closeable[r3]
            r7[r2] = r0
            r7[r1] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r7)
        L_0x0042:
            return
        L_0x0043:
            r7 = move-exception
            java.io.Closeable[] r3 = new java.io.Closeable[r3]
            r3[r2] = r0
            r3[r1] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.ac.b(java.lang.String):void");
    }

    private void b(TreeMap<String, Object> treeMap) {
        ResHelper.writeToFileNoCompress(ResHelper.getDataCacheFile(this.f27014g, f27010c), a(f27011d, treeMap));
    }

    private String a(TreeMap<String, Object> treeMap) {
        HashMap hashMap;
        String str = null;
        if (!b.c() || treeMap == null || treeMap.isEmpty()) {
            return null;
        }
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(s.a("007+ef%dciPdkdjec"), treeMap.get(s.a("007+ef%dciPdkdjec")));
            hashMap2.put(s.a("005!dfdkdcAfg"), treeMap.get(s.a("005!dfdkdcAfg")));
            hashMap2.put(s.a("006:fiecfidd=f?dj"), treeMap.get(s.a("006:fiecfidd=f?dj")));
            hashMap2.put(s.a("008;dc1f7dddiPcf-eedc"), treeMap.get(s.a("008;dc1f7dddiPcf-eedc")));
            hashMap2.put(s.a("0040dcdgdidc"), treeMap.get(s.a("0040dcdgdidc")));
            HashMap hashMap3 = new HashMap();
            hashMap3.put(s.a("006djj;ehBfFec"), u.a());
            hashMap3.put("m", a(HashonHelper.fromHashMap(hashMap2)));
            HashMap hashMap4 = new HashMap();
            hashMap4.put(s.a("013=ekfi?f djhkeedc:feiLdi9i0ec"), aa.c());
            hashMap4.put(s.a("004=dfdkdidc"), c.a(MobSDK.getContext()).d().ai());
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = CDNDownload.DEFAULT_TIMEOUT;
            networkTimeOut.connectionTimeout = CDNDownload.DEFAULT_TIMEOUT;
            NetworkHelper networkHelper = new NetworkHelper();
            HashMap fromJson = HashonHelper.fromJson(networkHelper.httpPostNew(i.a().a("gclg") + s.a("007lKdk(jfeGdidc"), hashMap3, hashMap4, networkTimeOut));
            if (!JumioRejectReason.NOT_READABLE.equals(String.valueOf(fromJson.get(s.a("004cHdkdcLf")))) || (hashMap = (HashMap) fromJson.get(s.a("004,dcQdid"))) == null) {
                return null;
            }
            String str2 = (String) hashMap.get(s.a("005i>dkeh3fe"));
            try {
                f27012e.f27013f = str2;
                b(str2);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                str = str2;
                MobLog.getInstance().e(th);
                return str;
            }
        } catch (Throwable th3) {
            th = th3;
            MobLog.getInstance().e(th);
            return str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r11) throws java.lang.Throwable {
        /*
            r10 = this;
            byte[] r0 = com.mob.commons.v.c()
            r1 = 3
            r2 = 1
            r3 = 0
            r4 = 2
            r5 = 0
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0098 }
            r6.<init>()     // Catch:{ all -> 0x0098 }
            java.util.zip.GZIPOutputStream r7 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0095 }
            r7.<init>(r6)     // Catch:{ all -> 0x0095 }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0093 }
            r8.<init>(r7)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = "utf-8"
            byte[] r11 = r11.getBytes(r9)     // Catch:{ all -> 0x0090 }
            r8.write(r11)     // Catch:{ all -> 0x0090 }
            r8.flush()     // Catch:{ all -> 0x0090 }
            java.io.Closeable[] r11 = new java.io.Closeable[r1]
            r11[r3] = r8
            r11[r2] = r7
            r11[r4] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r11)
            byte[] r11 = r6.toByteArray()
            byte[] r11 = com.mob.tools.utils.Data.AES128Encode((byte[]) r0, (byte[]) r11)
            com.mob.tools.utils.MobRSA r1 = new com.mob.tools.utils.MobRSA
            r6 = 1024(0x400, float:1.435E-42)
            r1.<init>(r6)
            java.math.BigInteger r6 = new java.math.BigInteger
            java.lang.String r7 = "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07"
            r8 = 16
            r6.<init>(r7, r8)
            java.math.BigInteger r7 = new java.math.BigInteger
            java.lang.String r9 = "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd"
            r7.<init>(r9, r8)
            byte[] r0 = r1.encode(r0, r6, r7)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0084 }
            r1.<init>()     // Catch:{ all -> 0x0084 }
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ all -> 0x0082 }
            r6.<init>(r1)     // Catch:{ all -> 0x0082 }
            int r5 = r0.length     // Catch:{ all -> 0x007f }
            r6.writeInt(r5)     // Catch:{ all -> 0x007f }
            r6.write(r0)     // Catch:{ all -> 0x007f }
            int r0 = r11.length     // Catch:{ all -> 0x007f }
            r6.writeInt(r0)     // Catch:{ all -> 0x007f }
            r6.write(r11)     // Catch:{ all -> 0x007f }
            r6.flush()     // Catch:{ all -> 0x007f }
            java.io.Closeable[] r11 = new java.io.Closeable[r4]
            r11[r3] = r6
            r11[r2] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r11)
            byte[] r11 = r1.toByteArray()
            java.lang.String r11 = android.util.Base64.encodeToString(r11, r4)
            return r11
        L_0x007f:
            r11 = move-exception
            r5 = r6
            goto L_0x0086
        L_0x0082:
            r11 = move-exception
            goto L_0x0086
        L_0x0084:
            r11 = move-exception
            r1 = r5
        L_0x0086:
            java.io.Closeable[] r0 = new java.io.Closeable[r4]
            r0[r3] = r5
            r0[r2] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            throw r11
        L_0x0090:
            r11 = move-exception
            r5 = r8
            goto L_0x009b
        L_0x0093:
            r11 = move-exception
            goto L_0x009b
        L_0x0095:
            r11 = move-exception
            r7 = r5
            goto L_0x009b
        L_0x0098:
            r11 = move-exception
            r6 = r5
            r7 = r6
        L_0x009b:
            java.io.Closeable[] r0 = new java.io.Closeable[r1]
            r0[r3] = r5
            r0[r2] = r7
            r0[r4] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.ac.a(java.lang.String):java.lang.String");
    }

    private byte[] a(String str, TreeMap<String, Object> treeMap) {
        try {
            return Data.EncodeNoPadding(str, new JSONObject(treeMap).toString());
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    private HashMap<String, Object> a(String str, byte[] bArr) {
        try {
            return HashonHelper.fromJson(Data.AES128Decode(str, bArr));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return new HashMap<>();
        }
    }
}
