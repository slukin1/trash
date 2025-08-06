package mz;

import com.iproov.sdk.bridge.OptionsBridge;

public final class e {
    public static String a(Object obj) {
        return b(obj, OptionsBridge.NULL_VALUE);
    }

    public static String b(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }
}
