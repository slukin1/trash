package com.huawei.face.antispoofing.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelFileUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f37609a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    private static Pattern f37610b = Pattern.compile("(.*)_v.*\\.mnn");

    public static class a implements FilenameFilter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f37611b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f37612c;

        public a(String str, String str2) {
            this.f37611b = str;
            this.f37612c = str2;
        }

        public boolean accept(File file, String str) {
            return str.matches(this.f37611b) && !Objects.equals(this.f37612c, str);
        }
    }

    private ModelFileUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r5 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0068, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r4, android.content.res.AssetManager r5, java.io.File r6) {
        /*
            java.lang.String r0 = "ModelFileUtils"
            boolean r1 = r6.exists()
            if (r1 != 0) goto L_0x008c
            java.io.File r1 = r6.getParentFile()
            r1.mkdirs()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r1.<init>()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = "models/"
            r1.append(r2)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = r6.getName()     // Catch:{ Exception -> 0x0069 }
            r1.append(r2)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0069 }
            java.io.InputStream r5 = r5.open(r1)     // Catch:{ Exception -> 0x0069 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x005b }
            r1.<init>(r6)     // Catch:{ all -> 0x005b }
            com.huawei.face.antispoofing.utils.IoUtils.copy(r5, r1)     // Catch:{ all -> 0x004f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r2.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "[syncOneModel] copy model successful, ModelName="
            r2.append(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = r6.getName()     // Catch:{ all -> 0x004f }
            r2.append(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004f }
            android.util.Log.i(r0, r2)     // Catch:{ all -> 0x004f }
            r1.close()     // Catch:{ all -> 0x005b }
            r5.close()     // Catch:{ Exception -> 0x0069 }
            goto L_0x008c
        L_0x004f:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r3 = move-exception
            r1.close()     // Catch:{ all -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ all -> 0x005b }
        L_0x005a:
            throw r3     // Catch:{ all -> 0x005b }
        L_0x005b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x005d }
        L_0x005d:
            r2 = move-exception
            if (r5 == 0) goto L_0x0068
            r5.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r5 = move-exception
            r1.addSuppressed(r5)     // Catch:{ Exception -> 0x0069 }
        L_0x0068:
            throw r2     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            r5 = move-exception
            r1 = 1
            java.lang.String r2 = "Fail to copy algorithm model"
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r2, r1)
            r4.show()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "[syncOneModel] copy file error, ModelFileName="
            r4.append(r1)
            java.lang.String r6 = r6.getName()
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r0, r4, r5)
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.face.antispoofing.utils.ModelFileUtils.a(android.content.Context, android.content.res.AssetManager, java.io.File):void");
    }

    public static void syncModels(Context context, String str, String str2, String str3, String str4) {
        AssetManager assets = context.getAssets();
        File file = new File(str2);
        File file2 = new File(str3);
        File file3 = new File(str4);
        a(context, assets, file);
        a(context, assets, file2);
        a(context, assets, file3);
        try {
            a(str, file);
            a(str, file2);
            a(str, file3);
        } catch (Exception e11) {
            Toast.makeText(context, "Fail to delete the old version of the model", 1).show();
            LogFace.e("ModelFileUtils", "[syncModels] delete old model error", e11);
        }
    }

    private static void a(String str, File file) {
        String name = file.getName();
        Matcher matcher = f37610b.matcher(name);
        if (matcher.matches()) {
            String[] list = new File(str).list(new a(matcher.group(1) + "_v.*\\.mnn", name));
            if (list == null) {
                list = f37609a;
            }
            for (String str2 : list) {
                Log.i("ModelFileUtils", "[deleteOldModel] delete model success ModelName=" + str2);
                IoUtils.deleteQuietly(new File(str + str2));
            }
        }
    }
}
