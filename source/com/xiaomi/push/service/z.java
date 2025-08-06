package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cf;
import com.xiaomi.push.dp;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.x;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private static long f52612a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f3443a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f3444a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    private static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(cf.a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            b.a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th2) {
            b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th2.getClass().getSimpleName() + " description: " + th2.getMessage());
            return false;
        }
    }

    public static void a() {
        dp.a a11;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f3443a.getActiveCount() <= 0 || currentTimeMillis - f52612a >= Period.MIN30_MILLS) && ep.a().a() && (a11 = ax.a().a()) != null && a11.e() > 0) {
            f52612a = currentTimeMillis;
            a(a11.a(), true);
        }
    }

    public static void a(final List<String> list, final boolean z11) {
        f3443a.execute(new Runnable() {
            public void run() {
                int i11;
                boolean a11 = z.a("www.baidu.com:80");
                Iterator it2 = list.iterator();
                while (true) {
                    i11 = 1;
                    if (!it2.hasNext()) {
                        break;
                    }
                    a11 = a11 || z.a((String) it2.next());
                    if (a11 && !z11) {
                        break;
                    }
                }
                if (!a11) {
                    i11 = 2;
                }
                eq.a(i11);
            }
        });
    }

    private static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th2;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb2.append("\n");
                        sb2.append(readLine);
                    } else {
                        String sb3 = sb2.toString();
                        x.a((Closeable) bufferedReader);
                        return sb3;
                    }
                }
            } catch (Exception unused) {
                x.a((Closeable) bufferedReader);
                return null;
            } catch (Throwable th3) {
                th2 = th3;
                x.a((Closeable) bufferedReader);
                throw th2;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
            x.a((Closeable) bufferedReader);
            return null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th2 = th4;
            x.a((Closeable) bufferedReader);
            throw th2;
        }
    }

    public static void b() {
        String a11 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a11)) {
            b.a("dump tcp for uid = " + Process.myUid());
            b.a(a11);
        }
        String a12 = a("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(a12)) {
            b.a("dump tcp6 for uid = " + Process.myUid());
            b.a(a12);
        }
    }
}
