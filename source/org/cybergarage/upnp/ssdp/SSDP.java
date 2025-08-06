package org.cybergarage.upnp.ssdp;

import com.huawei.hms.framework.common.ContainerUtils;
import org.cybergarage.util.Debug;

public class SSDP {

    /* renamed from: a  reason: collision with root package name */
    public static String f59891a;

    static {
        c("FF02::C");
    }

    public static final String a() {
        return f59891a;
    }

    public static final int b(String str) {
        int indexOf = str.indexOf("max-age");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf(44, indexOf);
            if (indexOf2 < 0) {
                indexOf2 = str.length();
            }
            try {
                return Integer.parseInt(str.substring(str.indexOf(ContainerUtils.KEY_VALUE_DELIMITER, indexOf) + 1, indexOf2).trim());
            } catch (Exception e11) {
                Debug.d(e11);
            }
        }
        return 0;
    }

    public static final void c(String str) {
        f59891a = str;
    }
}
