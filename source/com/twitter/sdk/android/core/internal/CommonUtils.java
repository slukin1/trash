package com.twitter.sdk.android.core.internal;

import android.content.Context;
import android.content.res.Resources;
import com.twitter.sdk.android.core.Twitter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class CommonUtils {
    public static final boolean TRACE_ENABLED_DEFAULT = false;
    public static final String TRACE_ENABLED_RESOURCE_NAME = "com.twitter.sdk.android.TRACE_ENABLED";
    private static Boolean clsTrace;

    public static void closeOrLog(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e11) {
                Twitter.getLogger().e("Twitter", str, e11);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static boolean getBooleanResourceValue(Context context, String str, boolean z11) {
        Resources resources;
        if (!(context == null || (resources = context.getResources()) == null)) {
            int resourcesIdentifier = getResourcesIdentifier(context, str, "bool");
            if (resourcesIdentifier > 0) {
                return resources.getBoolean(resourcesIdentifier);
            }
            int resourcesIdentifier2 = getResourcesIdentifier(context, str, "string");
            if (resourcesIdentifier2 > 0) {
                return Boolean.parseBoolean(context.getString(resourcesIdentifier2));
            }
        }
        return z11;
    }

    public static String getResourcePackageName(Context context) {
        int i11 = context.getApplicationContext().getApplicationInfo().icon;
        if (i11 > 0) {
            return context.getResources().getResourcePackageName(i11);
        }
        return context.getPackageName();
    }

    public static int getResourcesIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getResourcePackageName(context));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r2 = getResourcesIdentifier(r2, r3, "string");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStringResourceValue(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
            if (r2 == 0) goto L_0x0015
            android.content.res.Resources r0 = r2.getResources()
            if (r0 == 0) goto L_0x0015
            java.lang.String r1 = "string"
            int r2 = getResourcesIdentifier(r2, r3, r1)
            if (r2 <= 0) goto L_0x0015
            java.lang.String r2 = r0.getString(r2)
            return r2
        L_0x0015:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.CommonUtils.getStringResourceValue(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean isClsTrace(Context context) {
        if (clsTrace == null) {
            clsTrace = Boolean.valueOf(getBooleanResourceValue(context, TRACE_ENABLED_RESOURCE_NAME, false));
        }
        return clsTrace.booleanValue();
    }

    public static void logControlled(Context context, String str) {
        if (isClsTrace(context)) {
            Twitter.getLogger().d("Twitter", str);
        }
    }

    public static void logControlledError(Context context, String str, Throwable th2) {
        if (isClsTrace(context)) {
            Twitter.getLogger().e("Twitter", str);
        }
    }

    public static void logOrThrowIllegalStateException(String str, String str2) {
        if (!Twitter.isDebug()) {
            Twitter.getLogger().w(str, str2);
            return;
        }
        throw new IllegalStateException(str2);
    }

    public static String streamToString(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static void logControlled(Context context, int i11, String str, String str2) {
        if (isClsTrace(context)) {
            Twitter.getLogger().log(i11, "Twitter", str2);
        }
    }
}
