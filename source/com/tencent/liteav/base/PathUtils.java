package com.tencent.liteav.base;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import java.io.File;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PathUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CACHE_DIRECTORY = 2;
    private static final int DATA_DIRECTORY = 0;
    private static final int LOG_DIRECTORY = 3;
    private static final int NUM_DIRECTORIES = 4;
    private static final String TAG = "PathUtils";
    private static final int THUMBNAIL_DIRECTORY = 1;
    private static final String THUMBNAIL_DIRECTORY_NAME = "textures";
    private static String sCacheSubDirectory;
    private static String sDataDirectorySuffix;
    private static FutureTask<String[]> sDirPathFetchTask;
    private static final AtomicBoolean sInitializationStarted = new AtomicBoolean();

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f21397a = PathUtils.getOrComputeDirectoryPaths();
    }

    private PathUtils() {
    }

    private static void chmod(String str, int i11) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.chmod(str, i11);
            } catch (Exception unused) {
                Log.e(TAG, "Failed to set permissions for path \"" + str + "\"", new Object[0]);
            }
        }
    }

    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    private static String getDirectoryPath(int i11) {
        return a.f21397a[i11];
    }

    public static String getLogDirectory() {
        return getDirectoryPath(3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] getOrComputeDirectoryPaths() {
        /*
            java.util.concurrent.FutureTask<java.lang.String[]> r0 = sDirPathFetchTask     // Catch:{ InterruptedException | ExecutionException -> 0x0025 }
            r1 = 0
            boolean r0 = r0.cancel(r1)     // Catch:{ InterruptedException | ExecutionException -> 0x0025 }
            if (r0 == 0) goto L_0x001c
            com.tencent.liteav.base.b r0 = com.tencent.liteav.base.b.a()     // Catch:{ InterruptedException | ExecutionException -> 0x0025 }
            java.lang.String[] r1 = setPrivateDataDirectorySuffixInternal()     // Catch:{ all -> 0x0015 }
            r0.close()     // Catch:{ InterruptedException | ExecutionException -> 0x0025 }
            return r1
        L_0x0015:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x001b }
        L_0x001b:
            throw r1     // Catch:{ InterruptedException | ExecutionException -> 0x0025 }
        L_0x001c:
            java.util.concurrent.FutureTask<java.lang.String[]> r0 = sDirPathFetchTask     // Catch:{ InterruptedException | ExecutionException -> 0x0025 }
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException | ExecutionException -> 0x0025 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ InterruptedException | ExecutionException -> 0x0025 }
            return r0
        L_0x0025:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.PathUtils.getOrComputeDirectoryPaths():java.lang.String[]");
    }

    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    public static void setPrivateDataDirectorySuffix(String str, String str2) {
        if (!sInitializationStarted.getAndSet(true)) {
            sDataDirectorySuffix = str;
            sCacheSubDirectory = str2;
            sDirPathFetchTask = new FutureTask<>(a.a());
        }
    }

    /* access modifiers changed from: private */
    public static String[] setPrivateDataDirectorySuffixInternal() {
        String[] strArr = new String[4];
        Context applicationContext = ContextUtils.getApplicationContext();
        strArr[0] = applicationContext.getDir(sDataDirectorySuffix, 0).getPath();
        chmod(strArr[0], 448);
        strArr[1] = applicationContext.getDir(THUMBNAIL_DIRECTORY_NAME, 0).getPath();
        if (applicationContext.getCacheDir() != null) {
            if (sCacheSubDirectory == null) {
                strArr[2] = applicationContext.getCacheDir().getPath();
            } else {
                strArr[2] = new File(applicationContext.getCacheDir(), sCacheSubDirectory).getPath();
            }
        }
        File externalFilesDir = applicationContext.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            strArr[3] = externalFilesDir.getAbsolutePath() + "/log/liteav";
        }
        return strArr;
    }

    public static void setPrivateDataDirectorySuffix(String str) {
        setPrivateDataDirectorySuffix(str, (String) null);
    }
}
