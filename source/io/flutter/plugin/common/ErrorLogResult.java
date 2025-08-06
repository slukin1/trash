package io.flutter.plugin.common;

import io.flutter.Log;
import io.flutter.plugin.common.MethodChannel;

public class ErrorLogResult implements MethodChannel.Result {
    private int level;
    private String tag;

    public ErrorLogResult(String str) {
        this(str, Log.WARN);
    }

    public void error(String str, String str2, Object obj) {
        String str3;
        if (obj != null) {
            str3 = " details: " + obj;
        } else {
            str3 = "";
        }
        int i11 = this.level;
        if (i11 >= Log.WARN) {
            Log.println(i11, this.tag, str2 + str3);
        }
    }

    public void notImplemented() {
        int i11 = this.level;
        if (i11 >= Log.WARN) {
            Log.println(i11, this.tag, "method not implemented");
        }
    }

    public void success(Object obj) {
    }

    public ErrorLogResult(String str, int i11) {
        this.tag = str;
        this.level = i11;
    }
}
