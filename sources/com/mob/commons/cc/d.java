package com.mob.commons.cc;

import com.mob.commons.a.l;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import java.io.OutputStream;
import java.util.HashMap;

public class d implements t<d> {

    /* renamed from: a  reason: collision with root package name */
    private static final NetworkHelper f27133a = new NetworkHelper();

    public static String a(String str, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) throws Throwable {
        return f27133a.httpGet(str, hashMap, hashMap2);
    }

    public static String a(String str, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        return f27133a.httpPostNew(str, hashMap, hashMap2, networkTimeOut);
    }

    public static void a(String str, OutputStream outputStream, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        f27133a.download(str, outputStream, networkTimeOut);
    }

    public static <T> T a(NetCommunicator netCommunicator, HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z11) throws Throwable {
        return netCommunicator.requestSynchronized(false, hashMap, hashMap2, str, z11);
    }

    public boolean a(d dVar, Class<d> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if ("hGet".equals(str)) {
            try {
                objArr2[0] = a(objArr[0], (HashMap<String, Object>) objArr[1], (HashMap<String, String>) objArr[2]);
            } catch (Throwable th2) {
                thArr[0] = th2;
                objArr2[0] = null;
            }
            return true;
        } else if ("pst".equals(str)) {
            try {
                objArr2[0] = a(objArr[0], objArr[1], objArr[2], objArr[3]);
            } catch (Throwable th3) {
                thArr[0] = th3;
                objArr2[0] = null;
            }
            return true;
        } else if (l.a("0087edelghXfh+el0e8ed").equals(str)) {
            try {
                a(objArr[0], objArr[1], objArr[2]);
            } catch (Throwable th4) {
                thArr[0] = th4;
                objArr2[0] = null;
            }
            return true;
        } else if (!l.a("007*ek:gUeffmfd!fd").equals(str)) {
            return false;
        } else {
            try {
                objArr2[0] = a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4].booleanValue());
            } catch (Throwable th5) {
                thArr[0] = th5;
                objArr2[0] = null;
            }
            return true;
        }
    }
}
