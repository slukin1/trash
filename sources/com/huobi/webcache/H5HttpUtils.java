package com.huobi.webcache;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.huochat.community.util.FileTool;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class H5HttpUtils {
    public static boolean a(HashSet<String> hashSet, String str) {
        if (!TextUtils.isEmpty(str) && hashSet.contains(str.toLowerCase().trim())) {
            return true;
        }
        return false;
    }

    public static WebResourceResponse b() {
        return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream(BaseHbgResponse.STATUS_OK.getBytes()));
    }

    public static WebResourceResponse c(Context context) {
        try {
            return new WebResourceResponse(PictureMimeType.PNG_Q, (String) null, new BufferedInputStream(context.getAssets().open("favicon.ico")));
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        boolean z11 = true;
        for (int i11 = 0; i11 < listFiles.length; i11++) {
            if (listFiles[i11].isFile()) {
                z11 = e(listFiles[i11].getAbsolutePath());
                if (!z11) {
                    break;
                }
            } else {
                z11 = d(listFiles[i11].getAbsolutePath());
                if (!z11) {
                    break;
                }
            }
        }
        if (!z11) {
            return false;
        }
        return file.delete();
    }

    public static boolean e(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return e(str);
        }
        return d(str);
    }

    public static String g(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            URL url = new URL(str);
            int port = url.getPort();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(url.getProtocol());
            sb2.append("://");
            sb2.append(url.getHost());
            if (port != -1) {
                str2 = ":" + port;
            }
            sb2.append(str2);
            return sb2.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean h(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean i(HashSet<String> hashSet, String str) {
        if (hashSet != null && !hashSet.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<String> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                if (str.contains(it2.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j(HashSet<String> hashSet, String str) {
        if (hashSet != null && !hashSet.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<String> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                if (str.contains(it2.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean k(CacheExtensionConfig cacheExtensionConfig, String str) {
        return cacheExtensionConfig.b(str);
    }

    public static String l(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest(str.getBytes());
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static Map<String, String> m(Map<String, List<String>> map) {
        StringBuilder sb2 = new StringBuilder();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            List<String> list = (List) next.getValue();
            sb2.delete(0, sb2.length());
            if (list != null && list.size() > 0) {
                for (String append : list) {
                    sb2.append(append);
                    sb2.append(";");
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            hashMap.put((String) next.getKey(), sb2.toString());
        }
        return hashMap;
    }

    public static String n(long j11) {
        if (j11 <= 0) {
            return "0";
        }
        double d11 = (double) j11;
        int log10 = (int) (Math.log10(d11) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d11 / Math.pow(1024.0d, (double) log10)) + " " + new String[]{"B", "kB", "MB", "GB", "TB"}[log10];
    }
}
