package com.huobi.woodpecker.aop;

import com.huobi.woodpecker.HBOkHttpDNS;
import com.huobi.woodpecker.a;
import com.huobi.woodpecker.utils.NumberUtil;
import com.huobi.woodpecker.utils.ReflectUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import kv.e;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Route;
import okhttp3.internal.connection.RealConnection;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.c;

public class WoodPeckerHttpDNSFailRetryAspect {

    /* renamed from: a  reason: collision with root package name */
    public static /* synthetic */ Throwable f20978a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ WoodPeckerHttpDNSFailRetryAspect f20979b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f20980c = null;

    static {
        c();
        try {
            f20979b = new WoodPeckerHttpDNSFailRetryAspect();
        } catch (Throwable th2) {
            f20978a = th2;
        }
    }

    public static /* synthetic */ void c() {
        c cVar = new c("WoodPeckerHttpDNSFailRetryAspect.java", WoodPeckerHttpDNSFailRetryAspect.class);
        f20980c = cVar.h("method-call", cVar.g("401", "lookup", "okhttp3.Dns", "java.lang.String", "arg0", "java.net.UnknownHostException", "java.util.List"), TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK);
    }

    public static WoodPeckerHttpDNSFailRetryAspect d() {
        WoodPeckerHttpDNSFailRetryAspect woodPeckerHttpDNSFailRetryAspect = f20979b;
        if (woodPeckerHttpDNSFailRetryAspect != null) {
            return woodPeckerHttpDNSFailRetryAspect;
        }
        throw new NoAspectBoundException("com.huobi.woodpecker.aop.WoodPeckerHttpDNSFailRetryAspect", f20978a);
    }

    public List<InetAddress> e(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Call call;
        Object target = proceedingJoinPoint.getTarget();
        Object b11 = proceedingJoinPoint.b();
        Object[] c11 = proceedingJoinPoint.c();
        if (e.l()) {
            e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupByHostPathIfHttpDns target=" + target);
            e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupByHostPathIfHttpDns thiz=" + b11);
            e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupByHostPathIfHttpDns args[0]=" + c11[0]);
        }
        if (!(target instanceof HBOkHttpDNS) || (call = (Call) ReflectUtils.a(Call.class, b11.getClass(), TUIConstants.TUICalling.METHOD_NAME_CALL, b11, true)) == null || call.request() == null || call.request().url() == null) {
            e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupFromHostPathIfHttpDns -> joinPoint.proceed() thiz=" + b11);
            return (List) proceedingJoinPoint.a();
        }
        String host = call.request().url().host();
        String encodedPath = call.request().url().encodedPath();
        e.c("WoodPeckerHttpDNSFailRetryAspect", "lookupByHostPathIfHttpDns -> HBOkHttpDNS.lookupByHostPath()");
        return ((HBOkHttpDNS) target).j((String) c11[0], host, encodedPath);
    }

    public final List<InetSocketAddress> f(String str, int i11, Call call, a aVar) throws UnknownHostException {
        List<InetAddress> list;
        Dns dns = Dns.SYSTEM;
        JoinPoint c11 = c.c(f20980c, this, dns, str);
        if (dns instanceof HBOkHttpDNS) {
            list = d().e(new uu.a(new Object[]{this, dns, str, c11}).linkClosureAndJoinPoint(4112));
        } else {
            list = dns.lookup(str);
        }
        if (!list.isEmpty()) {
            aVar.dnsEnd(call, str, list);
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                arrayList.add(new InetSocketAddress(list.get(i12), i11));
            }
            return arrayList;
        }
        throw new UnknownHostException("Dns.SYSTEM returned no addresses for " + i11);
    }

    public void h(ProceedingJoinPoint proceedingJoinPoint) throws IOException {
        try {
            Object[] c11 = proceedingJoinPoint.c();
            if (c11 == null || c11.length < 4 || !(c11[3] instanceof a) || !((a) c11[3]).g()) {
                proceedingJoinPoint.a();
                return;
            }
            int intValue = NumberUtil.d(c11[0], 0).intValue();
            int max = Math.max(intValue / 2, HBOkHttpDNS.e().d());
            if (e.l()) {
                e.c("WoodPeckerHttpDNSFailRetryAspect", "retrySysDnsIfHttpDnsFailed Because HttpDNS is used, the timeout time is halved. => from:" + intValue + " to " + max);
            }
            c11[0] = Integer.valueOf(max);
            proceedingJoinPoint.e(c11);
        } catch (SocketTimeoutException e11) {
            e.o("WoodPeckerHttpDNSFailRetryAspect", "retrySysDnsIfHttpDnsFailed SocketTimeoutException");
            if (!i(proceedingJoinPoint)) {
                throw e11;
            }
        } catch (ConnectException e12) {
            e.o("WoodPeckerHttpDNSFailRetryAspect", "retrySysDnsIfHttpDnsFailed ConnectException");
            if (!i(proceedingJoinPoint)) {
                throw e12;
            }
        } catch (IOException e13) {
            throw e13;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final boolean i(ProceedingJoinPoint proceedingJoinPoint) throws IOException {
        Route route;
        Object[] c11 = proceedingJoinPoint.c();
        if (c11 != null && c11.length >= 4 && (c11[3] instanceof a)) {
            if (e.l()) {
                e.c("WoodPeckerHttpDNSFailRetryAspect", "retryWithSysDns connectTimeout->args[0]=" + c11[0]);
            }
            a aVar = (a) c11[3];
            if (aVar.g()) {
                Object target = proceedingJoinPoint.getTarget();
                Call call = null;
                if (c11[2] instanceof Call) {
                    call = (Call) c11[2];
                }
                if ((target instanceof RealConnection) && (route = ((RealConnection) target).route()) != null) {
                    String host = route.address().url().host();
                    int port = route.address().url().port();
                    aVar.dnsStart(call, host);
                    ReflectUtils.b(InetSocketAddress.class, Route.class, "inetSocketAddress", route, f(host, port, call, aVar).get(0), true, true);
                    e.c("WoodPeckerHttpDNSFailRetryAspect", "retryWithSysDns update originHostName:" + host + ", originPort:" + port + " => newRoute=" + route);
                    HBOkHttpDNS.e().b(host);
                    try {
                        proceedingJoinPoint.e(c11);
                        return true;
                    } catch (IOException e11) {
                        throw e11;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
