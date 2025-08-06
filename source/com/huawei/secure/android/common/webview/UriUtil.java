package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huawei.secure.android.common.util.LogsUtil;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.net.MalformedURLException;
import java.net.URL;

public class UriUtil {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.f("UriUtil", "whiteListUrl is null");
            return null;
        } else if (!URLUtil.isNetworkUrl(str)) {
            return str;
        } else {
            return b(str);
        }
    }

    @TargetApi(9)
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.f("UriUtil", "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            }
            LogsUtil.d("UriUtil", "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e11) {
            LogsUtil.d("UriUtil", "getHostByURI error  MalformedURLException : " + e11.getMessage());
            return "";
        }
    }

    public static boolean c(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.d("UriUtil", "whitelist is null");
            return false;
        }
        for (String d11 : strArr) {
            if (d(str, d11)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains("..") || str.contains(TIMMentionEditText.TIM_MENTION_TAG)) {
                Log.e("UriUtil", "url contains unsafe char");
            } else {
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + "?")) {
                        if (!str.startsWith(str2 + "#")) {
                            if (!str2.endsWith("/")) {
                                return false;
                            }
                            if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                return false;
                            }
                            return str.startsWith(str2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean e(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.d("UriUtil", "whitelist is null");
            return false;
        }
        for (String f11 : strArr) {
            if (f(str, f11)) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(String str, String str2) {
        String b11 = b(str);
        if (TextUtils.isEmpty(b11) || TextUtils.isEmpty(str2)) {
            LogsUtil.d("UriUtil", "url or whitelist is null");
            return false;
        }
        String a11 = a(str2);
        if (TextUtils.isEmpty(a11)) {
            Log.e("UriUtil", "whitelist host is null");
            return false;
        } else if (a11.equals(b11)) {
            return true;
        } else {
            if (b11.endsWith(a11)) {
                try {
                    String substring = b11.substring(0, b11.length() - a11.length());
                    if (!substring.endsWith(InstructionFileId.DOT)) {
                        return false;
                    }
                    return substring.matches("^[A-Za-z0-9.-]+$");
                } catch (IndexOutOfBoundsException e11) {
                    LogsUtil.d("UriUtil", "IndexOutOfBoundsException" + e11.getMessage());
                } catch (Exception e12) {
                    LogsUtil.d("UriUtil", "Exception : " + e12.getMessage());
                    return false;
                }
            }
            return false;
        }
    }

    public static boolean g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(b(str), a(str2));
        }
        Log.e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean h(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.d("UriUtil", "whitelist is null");
            return false;
        }
        for (String g11 : strArr) {
            if (g(str, g11)) {
                return true;
            }
        }
        return false;
    }
}
