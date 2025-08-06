package qk;

import com.huobi.apm.TimeMonitorManager;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.HashSet;
import tg.r;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet<Integer> f47761a = new HashSet<>();

    public static void a() {
        HashSet<Integer> hashSet = f47761a;
        hashSet.add(2);
        hashSet.add(10);
        hashSet.add(11);
    }

    public static void b() {
        HashSet<Integer> hashSet = f47761a;
        hashSet.add(1);
        hashSet.add(10);
        hashSet.add(11);
    }

    public static void c(int i11) {
        HashSet<Integer> hashSet = f47761a;
        if (!hashSet.contains(Integer.valueOf(i11))) {
            if (!r.x().F0()) {
                hashSet.add(10);
                hashSet.add(11);
                return;
            }
            if (i11 == 10) {
                hashSet.add(10);
                if (!hashSet.contains(11)) {
                    return;
                }
            } else {
                hashSet.add(11);
                if (!hashSet.contains(10)) {
                    return;
                }
            }
            TimeMonitorManager.a().b("huobiapp_contract_coin_end").a("huobiapp_contract_coin_end", OptionsBridge.NETWORK_KEY, true);
        }
    }

    public static void d() {
        if (!r.x().F0()) {
            HashSet<Integer> hashSet = f47761a;
            hashSet.add(2);
            hashSet.add(10);
            hashSet.add(11);
        } else if (!f47761a.contains(2)) {
            TimeMonitorManager.a().b("huobiapp_contract_coin_end").c();
        }
    }

    public static void e(int i11) {
        HashSet<Integer> hashSet = f47761a;
        if (!hashSet.contains(Integer.valueOf(i11))) {
            if (!r.x().F0()) {
                hashSet.add(10);
                hashSet.add(11);
                return;
            }
            if (i11 == 10) {
                hashSet.add(10);
                if (!hashSet.contains(11)) {
                    return;
                }
            } else {
                hashSet.add(11);
                if (!hashSet.contains(10)) {
                    return;
                }
            }
            TimeMonitorManager.a().b("huobiapp_contract_u_end").a("huobiapp_contract_u_end", OptionsBridge.NETWORK_KEY, true);
        }
    }

    public static void f() {
        if (!r.x().F0()) {
            HashSet<Integer> hashSet = f47761a;
            hashSet.add(1);
            hashSet.add(10);
            hashSet.add(11);
        } else if (!f47761a.contains(1)) {
            TimeMonitorManager.a().b("huobiapp_contract_u_end").c();
        }
    }
}
