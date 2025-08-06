package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import okio.BufferedSource;
import okio.ByteString;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final StringBuilder f30164a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    public static final ByteString f30165b = ByteString.encodeUtf8("RIFF");

    /* renamed from: c  reason: collision with root package name */
    public static final ByteString f30166c = ByteString.encodeUtf8("WEBP");

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000);
        }
    }

    public static class b extends Thread {
        public b(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public static class c implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            return new b(runnable);
        }
    }

    @TargetApi(18)
    public static long a(File file) {
        long j11;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            int i11 = Build.VERSION.SDK_INT;
            j11 = ((i11 < 18 ? (long) statFs.getBlockCount() : statFs.getBlockCountLong()) * (i11 < 18 ? (long) statFs.getBlockSize() : statFs.getBlockSizeLong())) / 50;
        } catch (IllegalArgumentException unused) {
            j11 = 5242880;
        }
        return Math.max(Math.min(j11, 52428800), CacheDataSink.DEFAULT_FRAGMENT_SIZE);
    }

    public static int b(Context context) {
        ActivityManager activityManager = (ActivityManager) n(context, "activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576) / 7);
    }

    public static void c() {
        if (!q()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static <T> T d(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }

    public static File e(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String f(q qVar) {
        StringBuilder sb2 = f30164a;
        String g11 = g(qVar, sb2);
        sb2.setLength(0);
        return g11;
    }

    public static String g(q qVar, StringBuilder sb2) {
        String str = qVar.f30087f;
        if (str != null) {
            sb2.ensureCapacity(str.length() + 50);
            sb2.append(qVar.f30087f);
        } else {
            Uri uri = qVar.f30085d;
            if (uri != null) {
                String uri2 = uri.toString();
                sb2.ensureCapacity(uri2.length() + 50);
                sb2.append(uri2);
            } else {
                sb2.ensureCapacity(50);
                sb2.append(qVar.f30086e);
            }
        }
        sb2.append(10);
        if (qVar.f30095n != 0.0f) {
            sb2.append("rotation:");
            sb2.append(qVar.f30095n);
            if (qVar.f30098q) {
                sb2.append('@');
                sb2.append(qVar.f30096o);
                sb2.append('x');
                sb2.append(qVar.f30097p);
            }
            sb2.append(10);
        }
        if (qVar.c()) {
            sb2.append("resize:");
            sb2.append(qVar.f30089h);
            sb2.append('x');
            sb2.append(qVar.f30090i);
            sb2.append(10);
        }
        if (qVar.f30091j) {
            sb2.append("centerCrop:");
            sb2.append(qVar.f30092k);
            sb2.append(10);
        } else if (qVar.f30093l) {
            sb2.append("centerInside");
            sb2.append(10);
        }
        List<x> list = qVar.f30088g;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                sb2.append(qVar.f30088g.get(i11).key());
                sb2.append(10);
            }
        }
        return sb2.toString();
    }

    public static void h(Looper looper) {
        a aVar = new a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000);
    }

    public static int i(Bitmap bitmap) {
        int allocationByteCount = Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static String j(c cVar) {
        return k(cVar, "");
    }

    public static String k(c cVar, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        a h11 = cVar.h();
        if (h11 != null) {
            sb2.append(h11.f29987b.d());
        }
        List<a> i11 = cVar.i();
        if (i11 != null) {
            int size = i11.size();
            for (int i12 = 0; i12 < size; i12++) {
                if (i12 > 0 || h11 != null) {
                    sb2.append(", ");
                }
                sb2.append(i11.get(i12).f29987b.d());
            }
        }
        return sb2.toString();
    }

    public static int l(Resources resources, q qVar) throws FileNotFoundException {
        Uri uri;
        int i11 = qVar.f30086e;
        if (i11 != 0 || (uri = qVar.f30085d) == null) {
            return i11;
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            List<String> pathSegments = qVar.f30085d.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                throw new FileNotFoundException("No path segments: " + qVar.f30085d);
            } else if (pathSegments.size() == 1) {
                try {
                    return Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Last path segment is not a resource ID: " + qVar.f30085d);
                }
            } else if (pathSegments.size() == 2) {
                return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + qVar.f30085d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + qVar.f30085d);
        }
    }

    public static Resources m(Context context, q qVar) throws FileNotFoundException {
        Uri uri;
        if (qVar.f30086e != 0 || (uri = qVar.f30085d) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new FileNotFoundException("Unable to obtain resources for package: " + qVar.f30085d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + qVar.f30085d);
        }
    }

    public static <T> T n(Context context, String str) {
        return context.getSystemService(str);
    }

    public static boolean o(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean p(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (Build.VERSION.SDK_INT < 17) {
                if (Settings.System.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                    return true;
                }
                return false;
            } else if (Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException | SecurityException unused) {
            return false;
        }
    }

    public static boolean q() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean r(BufferedSource bufferedSource) throws IOException {
        return bufferedSource.rangeEquals(0, f30165b) && bufferedSource.rangeEquals(8, f30166c);
    }

    public static void s(String str, String str2, String str3) {
        t(str, str2, str3, "");
    }

    public static void t(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }
}
