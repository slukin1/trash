package com.huobi.trade.utils;

import com.huobi.apm.TimeMonitorManager;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.HashSet;
import tg.r;

public class TradeTimeMonitorUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet<Integer> f82798a = new HashSet<>();

    public static void a() {
        HashSet<Integer> hashSet = f82798a;
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
    }

    public static void b() {
        HashSet<Integer> hashSet = f82798a;
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);
    }

    public static void c(int i11) {
        HashSet<Integer> hashSet = f82798a;
        if (!hashSet.contains(Integer.valueOf(i11))) {
            if (!r.x().F0()) {
                hashSet.add(2);
                hashSet.add(3);
                return;
            }
            if (i11 == 2) {
                hashSet.add(2);
                if (!hashSet.contains(3)) {
                    return;
                }
            } else {
                hashSet.add(3);
                if (!hashSet.contains(2)) {
                    return;
                }
            }
            TimeMonitorManager.a().b("huobiapp_trade_exchange_end").a("huobiapp_trade_exchange_end", OptionsBridge.NETWORK_KEY, true);
        }
    }

    public static void d(int i11) {
        HashSet<Integer> hashSet = f82798a;
        if (!hashSet.contains(Integer.valueOf(i11))) {
            if (!r.x().F0()) {
                hashSet.add(5);
                hashSet.add(6);
                return;
            }
            if (i11 == 5) {
                hashSet.add(5);
                if (!hashSet.contains(6)) {
                    return;
                }
            } else {
                hashSet.add(6);
                if (!hashSet.contains(5)) {
                    return;
                }
            }
            TimeMonitorManager.a().b("huobiapp_trade_margin_end").a("huobiapp_trade_margin_end", OptionsBridge.NETWORK_KEY, true);
        }
    }

    public static void e() {
        if (!r.x().F0()) {
            HashSet<Integer> hashSet = f82798a;
            hashSet.add(1);
            hashSet.add(2);
            hashSet.add(3);
        } else if (!f82798a.contains(1)) {
            TimeMonitorManager.a().b("huobiapp_trade_exchange_end").c();
        }
    }

    public static void f() {
        if (!r.x().F0()) {
            HashSet<Integer> hashSet = f82798a;
            hashSet.add(4);
            hashSet.add(5);
            hashSet.add(6);
        } else if (!f82798a.contains(4)) {
            TimeMonitorManager.a().b("huobiapp_trade_margin_end").c();
        }
    }
}
