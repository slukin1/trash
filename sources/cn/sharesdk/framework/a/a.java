package cn.sharesdk.framework.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.a.e;
import cn.sharesdk.framework.a.b.b;
import cn.sharesdk.framework.a.b.c;
import cn.sharesdk.framework.a.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.vulcan.model.VulcanInfo;
import com.huochat.community.network.domain.DomainTool;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import com.tencent.android.tpush.XGServerInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f13301a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c f13302b = new c();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public e f13303c = e.a();

    /* renamed from: d  reason: collision with root package name */
    private boolean f13304d = true;

    private a() {
    }

    private String c(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(c cVar) {
        try {
            long b11 = this.f13303c.b();
            if (b11 == 0) {
                b11 = this.f13302b.b();
            }
            cVar.f13338e = System.currentTimeMillis() - b11;
            this.f13302b.a(cVar);
        } catch (Throwable th2) {
            SSDKLog b12 = SSDKLog.b();
            b12.a("s l" + th2, new Object[0]);
        }
    }

    public static a a() {
        if (f13301a == null) {
            f13301a = new a();
        }
        return f13301a;
    }

    public void a(String str) {
        if (this.f13302b != null && !TextUtils.isEmpty(str)) {
            this.f13302b.a(str);
        }
    }

    public void b() {
        boolean z11;
        try {
            if (this.f13303c.i()) {
                ArrayList<cn.sharesdk.framework.a.a.c> c11 = this.f13302b.c();
                for (int i11 = 0; i11 < c11.size(); i11++) {
                    cn.sharesdk.framework.a.a.c cVar = c11.get(i11);
                    if (cVar.f13322b.size() == 1) {
                        z11 = a(cVar.f13321a, false);
                    } else {
                        z11 = a(c(cVar.f13321a), true);
                    }
                    if (z11) {
                        this.f13302b.a(cVar.f13322b);
                    }
                }
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    public void a(final ShareSDKCallback<Boolean> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getNetworkType().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkType = dHResponse.getNetworkType();
                    if ("none".equals(networkType)) {
                        return;
                    }
                    if (!TextUtils.isEmpty(networkType)) {
                        long longValue = a.this.f13303c.j().longValue();
                        long currentTimeMillis = System.currentTimeMillis();
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(longValue);
                        int i11 = instance.get(5);
                        instance.setTimeInMillis(currentTimeMillis);
                        int i12 = instance.get(5);
                        if (currentTimeMillis - longValue >= Period.DAY_MILLS && i11 != i12) {
                            HashMap<String, Object> a11 = a.this.f13302b.a();
                            a.this.f13303c.c(a11.containsKey("res") ? "true".equals(String.valueOf(a11.get("res"))) : true);
                            if (a11.size() > 0) {
                                a.this.f13303c.b(System.currentTimeMillis());
                            }
                        }
                        shareSDKCallback.onCallback(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                    SSDKLog.b().a(th2);
                }
            }
        });
    }

    public void a(final Handler handler) {
        try {
            if (this.f13303c.i()) {
                this.f13303c.a(System.currentTimeMillis());
                this.f13302b.a((ShareSDKCallback<HashMap<String, Object>>) new ShareSDKCallback<HashMap<String, Object>>() {
                    /* renamed from: a */
                    public void onCallback(HashMap<String, Object> hashMap) {
                        HashMap hashMap2;
                        HashMap hashMap3;
                        HashMap hashMap4;
                        if (hashMap != null && !hashMap.isEmpty()) {
                            try {
                                if (hashMap.containsKey("status") && ResHelper.parseInt(String.valueOf(hashMap.get("status"))) == -200) {
                                    SSDKLog.b().a((String) hashMap.get("error"), new Object[0]);
                                    return;
                                }
                            } catch (Throwable th2) {
                                SSDKLog b11 = SSDKLog.b();
                                b11.a("get status" + th2, new Object[0]);
                            }
                            try {
                                if (hashMap.containsKey("timestamp")) {
                                    a.this.f13303c.a("service_time", Long.valueOf(System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(hashMap.get("timestamp")))));
                                }
                            } catch (Throwable th3) {
                                SSDKLog b12 = SSDKLog.b();
                                b12.a("timestamp" + th3, new Object[0]);
                            }
                            try {
                                if (hashMap.containsKey("specurls") && (hashMap4 = (HashMap) hashMap.get("specurls")) != null && !hashMap4.isEmpty()) {
                                    e.a().a("twitter_auth_url", String.valueOf(hashMap4.get("twitterAuthUrl")));
                                }
                            } catch (Throwable th4) {
                                SSDKLog b13 = SSDKLog.b();
                                b13.a("specurls" + th4, new Object[0]);
                            }
                            if (hashMap.containsKey("switchs") && (hashMap3 = (HashMap) hashMap.get("switchs")) != null) {
                                String valueOf = String.valueOf(hashMap3.get("device"));
                                String valueOf2 = String.valueOf(hashMap3.get("share"));
                                String valueOf3 = String.valueOf(hashMap3.get("auth"));
                                String valueOf4 = String.valueOf(hashMap3.get("backflow"));
                                String valueOf5 = String.valueOf(hashMap3.get("loginplus"));
                                String valueOf6 = String.valueOf(hashMap3.get("linkcard"));
                                a.this.f13303c.b(valueOf);
                                a.this.f13303c.d(valueOf2);
                                a.this.f13303c.c(valueOf3);
                                a.this.f13303c.a(valueOf4);
                                a.this.f13303c.e(valueOf5);
                                a.this.f13303c.f(valueOf6);
                            }
                            if (hashMap.containsKey("serpaths") && (hashMap2 = (HashMap) hashMap.get("serpaths")) != null) {
                                String valueOf7 = String.valueOf(hashMap2.get("defhost"));
                                String valueOf8 = String.valueOf(hashMap2.get("defport"));
                                if (!TextUtils.isEmpty(valueOf7) && !TextUtils.isEmpty(valueOf8)) {
                                    if ("443".equals(valueOf8) || "80".equals(valueOf8)) {
                                        a.this.f13302b.b(MobSDK.checkRequestUrl(valueOf7));
                                    } else {
                                        c b14 = a.this.f13302b;
                                        b14.b(MobSDK.checkRequestUrl(valueOf7) + ":" + valueOf8);
                                    }
                                }
                                HashMap hashMap5 = new HashMap();
                                if (hashMap2.containsKey("assigns")) {
                                    HashMap hashMap6 = (HashMap) hashMap2.get("assigns");
                                    if (hashMap6 == null || hashMap6.size() == 0) {
                                        a.this.f13302b.a((HashMap<String, String>) null);
                                        return;
                                    }
                                    for (String str : hashMap6.keySet()) {
                                        HashMap hashMap7 = (HashMap) hashMap6.get(str);
                                        String valueOf9 = String.valueOf(hashMap7.get(VulcanInfo.HOST));
                                        String valueOf10 = String.valueOf(hashMap7.get(XGServerInfo.TAG_PORT));
                                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf9) && !TextUtils.isEmpty(valueOf10)) {
                                            hashMap5.put(str, DomainTool.DOMAIN_PREFIX_HTTP + valueOf9 + ":" + valueOf10);
                                        }
                                    }
                                    a.this.f13302b.a((HashMap<String, String>) hashMap5);
                                    handler.sendEmptyMessageDelayed(4, 600000);
                                }
                            }
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    public HashMap<String, Object> c() {
        try {
            return this.f13302b.d();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return new HashMap<>();
        }
    }

    public void a(c cVar) {
        try {
            if (this.f13303c.i()) {
                if (!this.f13303c.c()) {
                    cVar.f13345l = null;
                }
                if (cVar instanceof b) {
                    a((b) cVar);
                    b(cVar);
                } else if (cVar instanceof f) {
                    a((f) cVar);
                } else {
                    b(cVar);
                }
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    public HashMap<String, Object> b(String str) {
        if (!this.f13303c.i() && this.f13303c.k()) {
            return new HashMap<>();
        }
        try {
            HashMap<String, Object> d11 = this.f13302b.d(str);
            this.f13303c.d(true);
            return d11;
        } catch (Throwable th2) {
            this.f13303c.d(false);
            SSDKLog.b().a(th2);
            return new HashMap<>();
        }
    }

    private void a(b bVar) throws Throwable {
        boolean d11 = this.f13303c.d();
        String str = bVar.f13336c;
        if (!d11 || TextUtils.isEmpty(str)) {
            bVar.f13337d = null;
            bVar.f13336c = null;
            return;
        }
        bVar.f13336c = Data.Base64AES(str, bVar.f13339f.substring(0, 16));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r3 = r2.f13367f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final cn.sharesdk.framework.a.b.f r11) throws java.lang.Throwable {
        /*
            r10 = this;
            cn.sharesdk.framework.a.a.e r0 = r10.f13303c
            int r0 = r0.f()
            cn.sharesdk.framework.a.a.e r1 = r10.f13303c
            boolean r1 = r1.d()
            cn.sharesdk.framework.a.b.f$a r2 = r11.f13359d
            r3 = 0
            if (r1 != 0) goto L_0x0013
            r11.f13360m = r3
        L_0x0013:
            r1 = 1
            if (r0 != r1) goto L_0x00a8
            if (r2 == 0) goto L_0x0023
            java.util.ArrayList<java.lang.String> r0 = r2.f13366e
            if (r0 != 0) goto L_0x001d
            goto L_0x0023
        L_0x001d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            goto L_0x002a
        L_0x0023:
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.ArrayList<java.lang.String> r1 = r2.f13366e
            r0.<init>(r1)
        L_0x002a:
            r1 = 0
            if (r2 == 0) goto L_0x0037
            java.util.ArrayList<android.graphics.Bitmap> r3 = r2.f13367f
            if (r3 != 0) goto L_0x0032
            goto L_0x0037
        L_0x0032:
            int r3 = r3.size()
            goto L_0x0038
        L_0x0037:
            r3 = r1
        L_0x0038:
            r4 = r1
        L_0x0039:
            if (r4 >= r3) goto L_0x0083
            java.util.ArrayList<android.graphics.Bitmap> r5 = r2.f13367f
            java.lang.Object r5 = r5.get(r4)
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            java.lang.String r6 = "bm_tmp"
            java.lang.String r7 = ".png"
            java.io.File r6 = java.io.File.createTempFile(r6, r7)     // Catch:{ all -> 0x0065 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x0065 }
            r7.<init>(r6)     // Catch:{ all -> 0x0065 }
            android.graphics.Bitmap$CompressFormat r8 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x0065 }
            r9 = 100
            r5.compress(r8, r9, r7)     // Catch:{ all -> 0x0065 }
            r7.flush()     // Catch:{ all -> 0x0065 }
            r7.close()     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = r6.getAbsolutePath()     // Catch:{ all -> 0x0065 }
            r0.add(r5)     // Catch:{ all -> 0x0065 }
            goto L_0x0080
        L_0x0065:
            r5 = move-exception
            cn.sharesdk.framework.utils.SSDKLog r6 = cn.sharesdk.framework.utils.SSDKLog.b()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "bit"
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r6.a(r5, r7)
        L_0x0080:
            int r4 = r4 + 1
            goto L_0x0039
        L_0x0083:
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x00a4
            java.util.Iterator r0 = r0.iterator()
        L_0x008d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00ad
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            cn.sharesdk.framework.a.b r3 = cn.sharesdk.framework.a.b.FINISH_SHARE
            cn.sharesdk.framework.a.a$3 r4 = new cn.sharesdk.framework.a.a$3
            r4.<init>(r2, r11)
            r10.a(r1, r3, r4)
            goto L_0x008d
        L_0x00a4:
            r10.b((cn.sharesdk.framework.a.b.c) r11)
            goto L_0x00ad
        L_0x00a8:
            r11.f13359d = r3
            r10.b((cn.sharesdk.framework.a.b.c) r11)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.a.a.a(cn.sharesdk.framework.a.b.f):void");
    }

    private void a(String str, b bVar, ShareSDKCallback<String> shareSDKCallback) throws Throwable {
        double ceil;
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            Bitmap.CompressFormat bmpFormat = BitmapHelper.getBmpFormat(str);
            float f11 = 200.0f;
            if (bVar == b.BEFORE_SHARE) {
                f11 = 600.0f;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            int i11 = options.outWidth;
            int i12 = options.outHeight;
            if (i11 >= i12 && ((float) i12) > f11) {
                ceil = Math.ceil((double) (((float) i12) / f11));
            } else if (i11 >= i12 || ((float) i11) <= f11) {
                a(str, shareSDKCallback);
                return;
            } else {
                ceil = Math.ceil((double) (((float) i11) / f11));
            }
            int i13 = (int) ceil;
            if (i13 <= 0) {
                i13 = 1;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i13;
            options2.inPurgeable = true;
            options2.inInputShareable = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
            decodeFile.getHeight();
            decodeFile.getWidth();
            File createTempFile = File.createTempFile("bm_tmp2", InstructionFileId.DOT + bmpFormat.name().toLowerCase());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            decodeFile.compress(bmpFormat, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            a(createTempFile.getAbsolutePath(), shareSDKCallback);
        } else if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(null);
        }
    }

    private void a(final String str, final ShareSDKCallback<String> shareSDKCallback) throws Throwable {
        DH.requester(MobSDK.getContext()).getNetworkType().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String networkType = dHResponse.getNetworkType();
                    if (!"none".equals(networkType)) {
                        if (!TextUtils.isEmpty(networkType)) {
                            HashMap<String, Object> c11 = a.this.f13302b.c(str);
                            if (c11 != null) {
                                if (c11.size() > 0) {
                                    if (!c11.containsKey("status")) {
                                        ShareSDKCallback shareSDKCallback = shareSDKCallback;
                                        if (shareSDKCallback != null) {
                                            shareSDKCallback.onCallback(null);
                                            return;
                                        }
                                        return;
                                    } else if (ResHelper.parseInt(String.valueOf(c11.get("status"))) != 200) {
                                        ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                                        if (shareSDKCallback2 != null) {
                                            shareSDKCallback2.onCallback(null);
                                            return;
                                        }
                                        return;
                                    } else {
                                        String str = c11.containsKey("url") ? (String) c11.get("url") : null;
                                        ShareSDKCallback shareSDKCallback3 = shareSDKCallback;
                                        if (shareSDKCallback3 != null) {
                                            shareSDKCallback3.onCallback(str);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            ShareSDKCallback shareSDKCallback4 = shareSDKCallback;
                            if (shareSDKCallback4 != null) {
                                shareSDKCallback4.onCallback(null);
                                return;
                            }
                            return;
                        }
                    }
                    ShareSDKCallback shareSDKCallback5 = shareSDKCallback;
                    if (shareSDKCallback5 != null) {
                        shareSDKCallback5.onCallback(null);
                    }
                } catch (Throwable unused) {
                    SSDKLog.b().a("up fi", new Object[0]);
                    ShareSDKCallback shareSDKCallback6 = shareSDKCallback;
                    if (shareSDKCallback6 != null) {
                        shareSDKCallback6.onCallback(null);
                    }
                }
            }
        });
    }

    private boolean a(String str, boolean z11) throws Throwable {
        return this.f13302b.a(str, z11);
    }

    public void a(String str, int i11, boolean z11, String str2, ShareSDKCallback<String> shareSDKCallback) {
        try {
            if ((!this.f13303c.i() || !this.f13303c.e()) && shareSDKCallback != null) {
                shareSDKCallback.onCallback(str);
                return;
            }
            SSDKLog.b().c("> SERVER_SHORT_LINK_URL content before replace link ===  %s", str);
            if (z11) {
                a(str, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", i11, str2, shareSDKCallback);
            } else {
                a(str, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", i11, str2, shareSDKCallback);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            if (shareSDKCallback != null) {
                shareSDKCallback.onCallback("error:" + th2.getMessage());
            }
        }
    }

    private void a(final String str, String str2, int i11, String str3, final ShareSDKCallback<String> shareSDKCallback) throws Throwable {
        ArrayList arrayList = new ArrayList();
        final Pattern compile = Pattern.compile(str2);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null && group.length() > 0) {
                arrayList.add(group);
            }
        }
        if (arrayList.size() != 0) {
            this.f13302b.a(str, (ArrayList<String>) arrayList, i11, str3, (ShareSDKCallback<HashMap<String, Object>>) new ShareSDKCallback<HashMap<String, Object>>() {
                /* renamed from: a */
                public void onCallback(HashMap<String, Object> hashMap) {
                    if (hashMap == null || hashMap.size() <= 0) {
                        shareSDKCallback.onCallback(str);
                    } else if (!hashMap.containsKey("data")) {
                        shareSDKCallback.onCallback(str);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        Iterator it2 = ((ArrayList) hashMap.get("data")).iterator();
                        while (it2.hasNext()) {
                            HashMap hashMap3 = (HashMap) it2.next();
                            hashMap2.put(String.valueOf(hashMap3.get("source")), String.valueOf(hashMap3.get("surl")));
                        }
                        Matcher matcher = compile.matcher(str);
                        StringBuilder sb2 = new StringBuilder();
                        int i11 = 0;
                        while (matcher.find()) {
                            sb2.append(str.substring(i11, matcher.start()));
                            sb2.append((String) hashMap2.get(matcher.group()));
                            i11 = matcher.end();
                        }
                        sb2.append(str.substring(i11));
                        String sb3 = sb2.toString();
                        SSDKLog.b().c("> SERVER_SHORT_LINK_URL content after replace link ===  %s", sb3);
                        ShareSDKCallback shareSDKCallback = shareSDKCallback;
                        if (shareSDKCallback != null) {
                            shareSDKCallback.onCallback(sb3);
                        }
                    }
                }
            });
        } else if (shareSDKCallback != null) {
            shareSDKCallback.onCallback(str);
        }
    }

    public void a(HashMap<String, Object> hashMap) {
        try {
            this.f13302b.b(hashMap);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    public HashMap<String, Object> a(String str, String str2) {
        try {
            return this.f13302b.a(str, str2);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return null;
        }
    }

    public String a(String str, int i11, boolean z11, String str2, HashMap<String, String> hashMap) {
        String a11;
        try {
            if (this.f13303c.i()) {
                if (this.f13303c.e()) {
                    String str3 = hashMap.get("nt");
                    if (!"none".equals(str3)) {
                        if (!TextUtils.isEmpty(str3)) {
                            if (z11 && (a11 = a(str, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", i11, str2, hashMap)) != null && !a11.equals(str)) {
                                return a11;
                            }
                            String a12 = a(str, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", i11, str2, hashMap);
                            return (a12 == null || a12.equals(str)) ? str : a12;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return str;
        }
    }

    private String a(String str, String str2, int i11, String str3, HashMap<String, String> hashMap) throws Throwable {
        HashMap<String, Object> a11;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        Pattern compile = Pattern.compile(str2);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null && group.length() > 0) {
                arrayList.add(group);
            }
        }
        if (arrayList.size() == 0 || (a11 = this.f13302b.a(str, (ArrayList<String>) arrayList, i11, str3, hashMap)) == null || a11.size() <= 0 || !a11.containsKey("data")) {
            return str;
        }
        HashMap hashMap2 = new HashMap();
        Iterator it2 = ((ArrayList) a11.get("data")).iterator();
        while (it2.hasNext()) {
            HashMap hashMap3 = (HashMap) it2.next();
            hashMap2.put(String.valueOf(hashMap3.get("source")), String.valueOf(hashMap3.get("surl")));
        }
        Matcher matcher2 = compile.matcher(str);
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        while (matcher2.find()) {
            sb2.append(str.substring(i12, matcher2.start()));
            sb2.append((String) hashMap2.get(matcher2.group()));
            i12 = matcher2.end();
        }
        sb2.append(str.substring(i12, str.length()));
        String sb3 = sb2.toString();
        SSDKLog.b().c("> SERVER_SHORT_LINK_URL content after replace link ===  %s", sb3);
        return sb3;
    }
}
