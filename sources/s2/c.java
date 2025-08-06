package s2;

import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.i.b;
import java.net.SocketTimeoutException;

public class c {
    public static int a(Throwable th2) {
        return th2 instanceof b ? ((b) th2).getCode() : th2 instanceof SocketTimeoutException ? 10001 : 10000;
    }

    public static String b(Throwable th2) {
        return (th2 == null || TextUtils.isEmpty(th2.getMessage())) ? th2 instanceof SocketTimeoutException ? "time out exception" : "default error" : th2.getMessage();
    }
}
