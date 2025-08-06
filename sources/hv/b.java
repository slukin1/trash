package hv;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import android.os.Build;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kv.e;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f22801b = {"8.8.8.8", "8.8.4.4"};

    /* renamed from: a  reason: collision with root package name */
    public Context f22802a;

    public b(Context context) {
        this.f22802a = context;
    }

    public String[] a() {
        String[] d11 = d();
        e.c("DnsServersDetector", "getServers.dns0 = " + Arrays.toString(d11));
        if (d11 != null && d11.length > 0) {
            return d11;
        }
        String[] b11 = b();
        e.c("DnsServersDetector", "getServers.dns1 = " + Arrays.toString(b11));
        if (b11 != null && b11.length > 0) {
            return b11;
        }
        String[] c11 = c();
        e.c("DnsServersDetector", "getServers.dns2 = " + Arrays.toString(c11));
        if (c11 == null || c11.length <= 0) {
            return f22801b;
        }
        return c11;
    }

    public final String[] b() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f22802a.getSystemService("connectivity");
            if (connectivityManager != null) {
                for (Network network : connectivityManager.getAllNetworks()) {
                    if (connectivityManager.getNetworkInfo(network).isConnected()) {
                        LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                        List<InetAddress> dnsServers = linkProperties.getDnsServers();
                        e.c("DnsServersDetector", "iface = " + linkProperties.getInterfaceName());
                        e.c("DnsServersDetector", "dns = " + linkProperties.getDnsServers());
                        if (e(linkProperties)) {
                            for (InetAddress hostAddress : dnsServers) {
                                arrayList.add(hostAddress.getHostAddress());
                            }
                        } else {
                            for (InetAddress hostAddress2 : dnsServers) {
                                arrayList2.add(hostAddress2.getHostAddress());
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
            if (arrayList.size() > 0) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            return null;
        } catch (Exception e11) {
            e.d("DnsServersDetector", "Exception detecting DNS servers using ConnectivityManager method", e11);
            return null;
        }
    }

    public final String[] c() {
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        try {
            Set<String> f11 = f(new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream())));
            if (f11 == null || f11.size() <= 0) {
                return null;
            }
            return (String[]) f11.toArray(new String[0]);
        } catch (Exception e11) {
            e.d("DnsServersDetector", "Exception in getServersMethodExec", e11);
            return null;
        }
    }

    public final String[] d() {
        if (Build.VERSION.SDK_INT < 26) {
            ArrayList arrayList = new ArrayList();
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
                String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
                for (int i11 = 0; i11 < 4; i11++) {
                    String str = (String) method.invoke((Object) null, new Object[]{strArr[i11]});
                    if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    return (String[]) arrayList.toArray(new String[0]);
                }
            } catch (Exception e11) {
                e.d("DnsServersDetector", "Exception detecting DNS servers using SystemProperties method", e11);
            }
        }
        return null;
    }

    @TargetApi(21)
    public final boolean e(LinkProperties linkProperties) {
        for (RouteInfo isDefaultRoute : linkProperties.getRoutes()) {
            if (isDefaultRoute.isDefaultRoute()) {
                return true;
            }
        }
        return false;
    }

    public final Set<String> f(BufferedReader bufferedReader) throws Exception {
        InetAddress byName;
        String hostAddress;
        HashSet hashSet = new HashSet(10);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return hashSet;
            }
            int indexOf = readLine.indexOf("]: [");
            if (indexOf != -1) {
                String substring = readLine.substring(1, indexOf);
                int i11 = indexOf + 4;
                int length = readLine.length() - 1;
                if (length < i11) {
                    e.c("DnsServersDetector", "Malformed property detected: \"" + readLine + '\"');
                } else {
                    String substring2 = readLine.substring(i11, length);
                    if (!substring2.isEmpty() && !((!substring.endsWith(".dns") && !substring.endsWith(".dns1") && !substring.endsWith(".dns2") && !substring.endsWith(".dns3") && !substring.endsWith(".dns4")) || (byName = InetAddress.getByName(substring2)) == null || (hostAddress = byName.getHostAddress()) == null || hostAddress.length() == 0)) {
                        hashSet.add(hostAddress);
                    }
                }
            }
        }
    }
}
