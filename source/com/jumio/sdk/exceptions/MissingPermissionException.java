package com.jumio.sdk.exceptions;

import java.util.Arrays;

public class MissingPermissionException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f24980a;

    public MissingPermissionException(String[] strArr) {
        super(a(strArr));
        this.f24980a = (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public static String a(String[] strArr) {
        StringBuilder sb2 = new StringBuilder("On devices running Android Marshmallow (6.0) you need to acquire the following permissions dynamically before starting the SDK: ");
        for (String append : strArr) {
            sb2.append(append);
            sb2.append("\n");
        }
        sb2.append("On any other API level permissions must be declared in the AndroidManifest. More information about that can be found here: https://developer.android.com/training/permissions/requesting.html");
        return sb2.toString();
    }

    public String[] getPermissions() {
        return this.f24980a;
    }

    public MissingPermissionException(String str) {
        this(new String[]{str});
        this.f24980a = new String[]{str};
    }
}
