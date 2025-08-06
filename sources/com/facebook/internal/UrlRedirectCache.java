package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG;
    public static final String TAG = "UrlRedirectCache";
    private static FileLruCache urlRedirectCache;

    static {
        String simpleName = UrlRedirectCache.class.getSimpleName();
        REDIRECT_CONTENT_TAG = simpleName + "_Redirect";
    }

    public static void cacheUriRedirect(Uri uri, Uri uri2) {
        if (uri != null && uri2 != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getCache().openPutStream(uri.toString(), REDIRECT_CONTENT_TAG);
                outputStream.write(uri2.toString().getBytes());
            } catch (IOException unused) {
            } catch (Throwable th2) {
                Utility.closeQuietly(outputStream);
                throw th2;
            }
            Utility.closeQuietly(outputStream);
        }
    }

    public static void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e11) {
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String str = TAG;
            Logger.log(loggingBehavior, 5, str, "clearCache failed " + e11.getMessage());
        }
    }

    public static synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(TAG, new FileLruCache.Limits());
            }
            fileLruCache = urlRedirectCache;
        }
        return fileLruCache;
    }

    public static Uri getRedirectedUri(Uri uri) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        Throwable th2;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        try {
            FileLruCache cache = getCache();
            inputStreamReader = null;
            boolean z11 = false;
            while (true) {
                try {
                    InputStream inputStream = cache.get(uri2, REDIRECT_CONTENT_TAG);
                    if (inputStream == null) {
                        break;
                    }
                    z11 = true;
                    inputStreamReader2 = new InputStreamReader(inputStream);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            int read = inputStreamReader2.read(cArr, 0, 128);
                            if (read <= 0) {
                                break;
                            }
                            sb2.append(cArr, 0, read);
                        }
                        Utility.closeQuietly(inputStreamReader2);
                        inputStreamReader = inputStreamReader2;
                        uri2 = sb2.toString();
                    } catch (IOException unused) {
                        inputStreamReader = inputStreamReader2;
                    } catch (Throwable th3) {
                        th2 = th3;
                        Utility.closeQuietly(inputStreamReader2);
                        throw th2;
                    }
                } catch (IOException unused2) {
                } catch (Throwable th4) {
                    th2 = th4;
                    inputStreamReader2 = inputStreamReader;
                    Utility.closeQuietly(inputStreamReader2);
                    throw th2;
                }
            }
            if (z11) {
                Uri parse = Uri.parse(uri2);
                Utility.closeQuietly(inputStreamReader);
                return parse;
            }
        } catch (IOException unused3) {
            inputStreamReader = null;
        } catch (Throwable th5) {
            th2 = th5;
            inputStreamReader2 = null;
            Utility.closeQuietly(inputStreamReader2);
            throw th2;
        }
        Utility.closeQuietly(inputStreamReader);
        return null;
    }
}
