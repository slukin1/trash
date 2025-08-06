package org.cybergarage.util;

public final class FileUtil {
    public static final boolean a(String str) {
        if (!StringUtil.a(str)) {
            return false;
        }
        return str.toLowerCase().endsWith("xml");
    }
}
