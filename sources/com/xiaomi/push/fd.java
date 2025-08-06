package com.xiaomi.push;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class fd {
    public static int a(Throwable th2) {
        boolean z11 = th2 instanceof fj;
        if (z11) {
            fj fjVar = (fj) th2;
            if (fjVar.a() != null) {
                th2 = fjVar.a();
            }
        }
        String message = th2.getMessage();
        if (th2.getCause() != null) {
            message = th2.getCause().getMessage();
        }
        if (th2 instanceof SocketTimeoutException) {
            return 105;
        }
        if (th2 instanceof SocketException) {
            if (message.indexOf("Network is unreachable") != -1) {
                return 102;
            }
            if (message.indexOf("Connection refused") != -1) {
                return 103;
            }
            if (message.indexOf("Connection timed out") != -1) {
                return 105;
            }
            if (message.endsWith("EACCES (Permission denied)")) {
                return 101;
            }
            if (message.indexOf("Connection reset by peer") != -1) {
                return 109;
            }
            if (message.indexOf("Broken pipe") != -1) {
                return 110;
            }
            if (message.indexOf("No route to host") != -1) {
                return 104;
            }
            return message.endsWith("EINVAL (Invalid argument)") ? 106 : 199;
        } else if (th2 instanceof UnknownHostException) {
            return 107;
        } else {
            return z11 ? 399 : 0;
        }
    }
}
