package e6;

import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.k;
import com.blankj.utilcode.util.l;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.DyanmicConfig;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class h extends HBDynamicBaseManager {

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, String> f68133i;

    public class a implements FileFilter {
        public a() {
        }

        public boolean accept(File file) {
            return file.getName().toLowerCase().endsWith(".json");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final h f68135a = new h((a) null);
    }

    public /* synthetic */ h(a aVar) {
        this();
    }

    public static h r() {
        return b.f68135a;
    }

    public File e(String str) {
        return new File(BaseApplication.b().getFilesDir().getPath() + File.separator + "dynamic/jsonconfig/" + str);
    }

    public String g() {
        return "JsonConfigManager";
    }

    public String h() {
        return DyanmicConfig.JsonConfig.class.getName();
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        File q11 = q();
        if (Util.a()) {
            Log.d("JsonConfigManager", "initData() called= " + q11.getPath());
        }
        if (Util.a()) {
            Log.d("JsonConfigManager", "initData() called= isDirectory=" + q11.isDirectory());
        }
        if (Util.a()) {
            Log.d("JsonConfigManager", "initData() called=exists=" + q11.exists());
        }
        if (q11.isDirectory() && q11.exists()) {
            List<File> l11 = l.l(q11, new a());
            if (Util.a()) {
                Log.d("JsonConfigManager", "initData() called  jsons=" + l11);
            }
            for (File next : l11) {
                if (Util.a()) {
                    Log.d("JsonConfigManager", String.format("initData() called file=%s", new Object[]{next.getPath()}));
                }
                if (next.isFile() && next.exists() && next.getName().toLowerCase().endsWith(".json")) {
                    this.f68133i.put(next.getName().substring(0, next.getName().indexOf(InstructionFileId.DOT)), k.c(next));
                }
            }
        }
        if (Util.a()) {
            Log.d("JsonConfigManager", "initData() called  cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public File q() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(BaseApplication.b().getFilesDir().getPath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("dynamic/jsonconfig/");
        sb2.append(f());
        sb2.append(str);
        sb2.append(i());
        sb2.append(str);
        return new File(sb2.toString());
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x009b */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb A[SYNTHETIC, Splitter:B:41:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0 A[SYNTHETIC, Splitter:B:45:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dd A[SYNTHETIC, Splitter:B:53:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e2 A[SYNTHETIC, Splitter:B:57:0x00e2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String s(java.lang.String r11) {
        /*
            r10 = this;
            boolean r0 = com.hbg.lib.common.dynamic.downloader.Util.a()
            java.lang.String r1 = "getJsonContent() called with: configFileName = ["
            java.lang.String r2 = "JsonConfigManager"
            if (r0 == 0) goto L_0x0036
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r11)
            java.lang.String r3 = "]isAvailable()="
            r0.append(r3)
            boolean r3 = r10.l()
            r0.append(r3)
            java.lang.String r3 = ",jsonConfigIndexMap.containsKey(configFileName)="
            r0.append(r3)
            java.util.Map<java.lang.String, java.lang.String> r3 = r10.f68133i
            boolean r3 = r3.containsKey(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
        L_0x0036:
            boolean r0 = r10.l()
            if (r0 == 0) goto L_0x0053
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x0053
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f68133i
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x0053
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f68133i
            java.lang.Object r11 = r0.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            return r11
        L_0x0053:
            r0 = 8192(0x2000, float:1.14794E-41)
            r3 = 0
            android.app.Application r4 = com.hbg.lib.common.BaseApplication.b()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r5.<init>()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r6 = "dydefault/jsonconfig/"
            r5.append(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r5.append(r11)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r6 = ".json"
            r5.append(r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            r6 = 3
            java.io.InputStream r4 = r4.open(r5, r6)     // Catch:{ Exception -> 0x00af, all -> 0x00ac }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00a9, all -> 0x00a6 }
            r5.<init>()     // Catch:{ Exception -> 0x00a9, all -> 0x00a6 }
            byte[] r6 = new byte[r0]     // Catch:{ Exception -> 0x00a4 }
        L_0x0080:
            r7 = 0
            int r8 = r4.read(r6, r7, r0)     // Catch:{ Exception -> 0x00a4 }
            r9 = -1
            if (r8 == r9) goto L_0x008c
            r5.write(r6, r7, r8)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x0080
        L_0x008c:
            r5.close()     // Catch:{ Exception -> 0x00a4 }
            r4.close()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = "utf-8"
            java.lang.String r11 = r5.toString(r0)     // Catch:{ Exception -> 0x00a4 }
            r4.close()     // Catch:{ IOException -> 0x009b }
        L_0x009b:
            r5.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a3:
            return r11
        L_0x00a4:
            r0 = move-exception
            goto L_0x00b2
        L_0x00a6:
            r11 = move-exception
            r5 = r3
            goto L_0x00da
        L_0x00a9:
            r0 = move-exception
            r5 = r3
            goto L_0x00b2
        L_0x00ac:
            r11 = move-exception
            r5 = r3
            goto L_0x00db
        L_0x00af:
            r0 = move-exception
            r4 = r3
            r5 = r4
        L_0x00b2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d9 }
            r6.<init>()     // Catch:{ all -> 0x00d9 }
            r6.append(r1)     // Catch:{ all -> 0x00d9 }
            r6.append(r11)     // Catch:{ all -> 0x00d9 }
            java.lang.String r11 = "] ,Exception:"
            r6.append(r11)     // Catch:{ all -> 0x00d9 }
            java.lang.String r11 = r6.toString()     // Catch:{ all -> 0x00d9 }
            android.util.Log.e(r2, r11, r0)     // Catch:{ all -> 0x00d9 }
            if (r4 == 0) goto L_0x00ce
            r4.close()     // Catch:{ IOException -> 0x00ce }
        L_0x00ce:
            if (r5 == 0) goto L_0x00d8
            r5.close()     // Catch:{ IOException -> 0x00d4 }
            goto L_0x00d8
        L_0x00d4:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00d8:
            return r3
        L_0x00d9:
            r11 = move-exception
        L_0x00da:
            r3 = r4
        L_0x00db:
            if (r3 == 0) goto L_0x00e0
            r3.close()     // Catch:{ IOException -> 0x00e0 }
        L_0x00e0:
            if (r5 == 0) goto L_0x00ea
            r5.close()     // Catch:{ IOException -> 0x00e6 }
            goto L_0x00ea
        L_0x00e6:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ea:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.h.s(java.lang.String):java.lang.String");
    }

    public h() {
        this.f68133i = new ConcurrentHashMap();
    }
}
