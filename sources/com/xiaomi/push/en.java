package com.xiaomi.push;

import java.net.UnknownHostException;
import java.util.Objects;

final class en {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ej f51736a;

        /* renamed from: a  reason: collision with other field name */
        public String f2794a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m2641a(Exception exc) {
        Objects.requireNonNull(exc);
    }

    public static a b(Exception exc) {
        Throwable cause;
        a(exc);
        boolean z11 = exc instanceof fj;
        Throwable th2 = exc;
        if (z11) {
            fj fjVar = (fj) exc;
            th2 = exc;
            if (fjVar.a() != null) {
                th2 = fjVar.a();
            }
        }
        a aVar = new a();
        String message = th2.getMessage();
        if (th2.getCause() != null) {
            message = th2.getCause().getMessage();
        }
        int a11 = fd.a(th2);
        String str = th2.getClass().getSimpleName() + ":" + message;
        if (a11 != 0) {
            ej a12 = ej.a(ej.CONN_SUCCESS.a() + a11);
            aVar.f51736a = a12;
            if (a12 == ej.CONN_BOSH_ERR && (cause = th2.getCause()) != null && (cause instanceof UnknownHostException)) {
                aVar.f51736a = ej.CONN_BOSH_UNKNOWNHOST;
            }
        } else {
            aVar.f51736a = ej.CONN_XMPP_ERR;
        }
        ej ejVar = aVar.f51736a;
        if (ejVar == ej.CONN_TCP_ERR_OTHER || ejVar == ej.CONN_XMPP_ERR || ejVar == ej.CONN_BOSH_ERR) {
            aVar.f2794a = str;
        }
        return aVar;
    }

    public static a c(Exception exc) {
        a(exc);
        boolean z11 = exc instanceof fj;
        Throwable th2 = exc;
        if (z11) {
            fj fjVar = (fj) exc;
            th2 = exc;
            if (fjVar.a() != null) {
                th2 = fjVar.a();
            }
        }
        a aVar = new a();
        String message = th2.getMessage();
        if (th2.getCause() != null) {
            message = th2.getCause().getMessage();
        }
        int a11 = fd.a(th2);
        String str = th2.getClass().getSimpleName() + ":" + message;
        if (a11 == 105) {
            aVar.f51736a = ej.BIND_TCP_READ_TIMEOUT;
        } else if (a11 == 199) {
            aVar.f51736a = ej.BIND_TCP_ERR;
        } else if (a11 == 499) {
            aVar.f51736a = ej.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f51736a = ej.BIND_BOSH_ITEM_NOT_FOUND;
            }
        } else if (a11 == 109) {
            aVar.f51736a = ej.BIND_TCP_CONNRESET;
        } else if (a11 != 110) {
            aVar.f51736a = ej.BIND_XMPP_ERR;
        } else {
            aVar.f51736a = ej.BIND_TCP_BROKEN_PIPE;
        }
        ej ejVar = aVar.f51736a;
        if (ejVar == ej.BIND_TCP_ERR || ejVar == ej.BIND_XMPP_ERR || ejVar == ej.BIND_BOSH_ERR) {
            aVar.f2794a = str;
        }
        return aVar;
    }

    public static a d(Exception exc) {
        a(exc);
        boolean z11 = exc instanceof fj;
        Throwable th2 = exc;
        if (z11) {
            fj fjVar = (fj) exc;
            th2 = exc;
            if (fjVar.a() != null) {
                th2 = fjVar.a();
            }
        }
        a aVar = new a();
        String message = th2.getMessage();
        int a11 = fd.a(th2);
        String str = th2.getClass().getSimpleName() + ":" + message;
        if (a11 == 105) {
            aVar.f51736a = ej.CHANNEL_TCP_READTIMEOUT;
        } else if (a11 == 199) {
            aVar.f51736a = ej.CHANNEL_TCP_ERR;
        } else if (a11 == 499) {
            aVar.f51736a = ej.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                aVar.f51736a = ej.CHANNEL_BOSH_ITEMNOTFIND;
            }
        } else if (a11 == 109) {
            aVar.f51736a = ej.CHANNEL_TCP_CONNRESET;
        } else if (a11 != 110) {
            aVar.f51736a = ej.CHANNEL_XMPPEXCEPTION;
        } else {
            aVar.f51736a = ej.CHANNEL_TCP_BROKEN_PIPE;
        }
        ej ejVar = aVar.f51736a;
        if (ejVar == ej.CHANNEL_TCP_ERR || ejVar == ej.CHANNEL_XMPPEXCEPTION || ejVar == ej.CHANNEL_BOSH_EXCEPTION) {
            aVar.f2794a = str;
        }
        return aVar;
    }

    public static a a(Exception exc) {
        a(exc);
        boolean z11 = exc instanceof fj;
        Throwable th2 = exc;
        if (z11) {
            fj fjVar = (fj) exc;
            th2 = exc;
            if (fjVar.a() != null) {
                th2 = fjVar.a();
            }
        }
        a aVar = new a();
        String message = th2.getMessage();
        if (th2.getCause() != null) {
            message = th2.getCause().getMessage();
        }
        String str = th2.getClass().getSimpleName() + ":" + message;
        int a11 = fd.a(th2);
        if (a11 != 0) {
            aVar.f51736a = ej.a(ej.GSLB_REQUEST_SUCCESS.a() + a11);
        }
        if (aVar.f51736a == null) {
            aVar.f51736a = ej.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.f51736a == ej.GSLB_TCP_ERR_OTHER) {
            aVar.f2794a = str;
        }
        return aVar;
    }
}
