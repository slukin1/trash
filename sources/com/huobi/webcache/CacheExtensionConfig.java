package com.huobi.webcache;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.HashSet;

public class CacheExtensionConfig {

    /* renamed from: d  reason: collision with root package name */
    public static final HashSet f20637d = new HashSet() {
        {
            add("html");
            add("htm");
            add("js");
            add("ico");
            add("css");
            add("png");
            add("jpg");
            add("jpeg");
            add("gif");
            add("bmp");
            add("ttf");
            add("woff");
            add("woff2");
            add("otf");
            add("eot");
            add("svg");
            add("xml");
            add("swf");
            add("txt");
            add("text");
            add("conf");
            add("webp");
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final HashSet f20638e = new HashSet() {
        {
            add("html");
            add("htm");
            add("js");
            add("ico");
            add("css");
            add("png");
            add("jpg");
            add("jpeg");
            add("gif");
            add("bmp");
            add("ttf");
            add("woff");
            add("woff2");
            add("otf");
            add("eot");
            add("svg");
            add("xml");
            add("swf");
            add("txt");
            add("text");
            add("conf");
            add("webp");
            add("mp3");
            add("wav");
            add(MTPushConstants.Analysis.KEY_JSON);
            add("mp4");
            add("ogg");
            add("avi");
            add("wmv");
            add("flv");
            add("rmvb");
            add("3gp");
            add("atlas");
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static HashSet f20639f = new HashSet() {
        {
            add("mp4");
            add("mp3");
            add("ogg");
            add("avi");
            add("wmv");
            add("flv");
            add("rmvb");
            add("3gp");
            add("apk");
            add("aab");
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final HashSet f20640g = new HashSet() {
        {
            add("js");
            add("ico");
            add("css");
            add("png");
            add("jpg");
            add("jpeg");
            add("gif");
            add("bmp");
            add("ttf");
            add("woff");
            add("woff2");
            add("otf");
            add("eot");
            add("svg");
            add("xml");
            add("swf");
            add("txt");
            add("text");
            add("conf");
            add("webp");
            add("mp3");
            add("ogg");
            add("avi");
            add("wmv");
            add("flv");
            add("rmvb");
            add("3gp");
            add("wav");
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static HashSet f20641h = new HashSet() {
        {
            add("js");
            add("css");
            add("html");
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static HashSet f20642i = new HashSet() {
        {
            add("png");
            add("jpg");
            add("woff");
            add("woff2");
            add("svg");
            add("mp4");
            add("mp3");
            add("js");
            add("wav");
            add(MTPushConstants.Analysis.KEY_JSON);
            add("atlas");
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public static HashSet f20643j = new HashSet() {
        {
            add("html");
            add("js");
            add("css");
            add("mp3");
            add("mp4");
            add("png");
            add("jpg");
            add("jpeg");
            add("svg");
            add("gif");
            add("eot");
            add("woff2");
            add("woff");
            add("ttf");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public HashSet f20644a = new HashSet(f20638e);

    /* renamed from: b  reason: collision with root package name */
    public HashSet f20645b = new HashSet(f20639f);

    /* renamed from: c  reason: collision with root package name */
    public HashSet f20646c = new HashSet(f20640g);

    public static String c(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String lowerCase = str.toLowerCase();
        if (!TextUtils.isEmpty(lowerCase)) {
            int lastIndexOf2 = lowerCase.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                lowerCase = lowerCase.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = lowerCase.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                lowerCase = lowerCase.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = lowerCase.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                lowerCase = lowerCase.substring(lastIndexOf4 + 1);
            }
            if (!lowerCase.isEmpty() && (lastIndexOf = lowerCase.lastIndexOf(46)) >= 0) {
                return lowerCase.substring(lastIndexOf + 1);
            }
        }
        return "";
    }

    public static String d(String str) {
        String str2 = "application/octet-stream";
        if (str.equals("png")) {
            str2 = PictureMimeType.PNG_Q;
        } else if (str.equals("jpg") || str.equals("jpeg")) {
            str2 = "image/jpeg";
        } else if (str.equals("gif")) {
            str2 = "image/gif";
        } else if (str.equals("webp")) {
            str2 = "image/webp";
        } else if (str.equals("css")) {
            str2 = "text/css";
        } else if (str.equals("js")) {
            str2 = "application/javascript,application/x-javascript";
        } else if (str.equals("woff2")) {
            str2 = "application/font-woff2";
        } else if (str.equals("woff")) {
            str2 = "application/font-woff";
        } else if (str.equals("ttf")) {
            str2 = "application/font-ttf";
        } else if (str.equals("eot")) {
            str2 = "application/vnd.ms-fontobject";
        } else if (!str.equals("otf")) {
            if (str.equals(MTPushConstants.Analysis.KEY_JSON)) {
                str2 = "application/json";
            } else if (!str.equals("atlas")) {
                str2 = "";
            }
        }
        if (str2.isEmpty()) {
            try {
                Log.d("", "getMimeTypeFromExtension() called with: extension = [" + str + "].rs=[" + str2 + "] return=" + MimeTypeMap.getSingleton().getMimeTypeFromExtension(str));
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
            } catch (Exception unused) {
                Log.d("", "getMimeTypeFromExtension() called with: extension = [" + str + "].rs=[" + str2 + "] return=" + MimeTypeMap.getSingleton().getMimeTypeFromExtension(str));
            }
        }
        return str2;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.toLowerCase().trim();
        if (f20638e.contains(trim)) {
            return true;
        }
        return this.f20644a.contains(trim);
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && f20642i.contains(str)) {
            return true;
        }
        return false;
    }

    public String e(String str) {
        String c11 = c(str);
        return a(c11) ? d(c11) : "";
    }

    public boolean f(String str) {
        return false;
    }

    public boolean g(String str) {
        if (!TextUtils.isEmpty(str) && f20641h.contains(str)) {
            return true;
        }
        return false;
    }

    public boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.toLowerCase().equals("html") || str.toLowerCase().equals("htm")) {
            return true;
        }
        return false;
    }

    public boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f20639f.contains(str)) {
            return true;
        }
        return this.f20645b.contains(str.toLowerCase().trim());
    }
}
