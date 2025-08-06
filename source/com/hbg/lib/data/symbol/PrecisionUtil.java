package com.hbg.lib.data.symbol;

import android.text.TextUtils;
import d7.a1;
import d7.k;

public class PrecisionUtil {
    public static int A(String str) {
        return a1.v().h0(str, TradeType.PRO);
    }

    public static int B(String str, boolean z11) {
        return a1.v().r(str, TradeType.PRO);
    }

    public static int C(String str) {
        return a1.v().b0(str, TradeType.PRO);
    }

    public static int D(String str) {
        return a1.v().h0(str, TradeType.PRO);
    }

    public static int E(String str) {
        return 2;
    }

    public static int a(TradeType tradeType, String str) {
        int q11;
        if (!TextUtils.isEmpty(str) && (q11 = k.C().q(str, tradeType)) != 0) {
            return q11;
        }
        return 4;
    }

    public static int b(String str) {
        return a(TradeType.PRO, str);
    }

    public static int c(String str) {
        return 8;
    }

    public static int d(String str) {
        return a1.v().b0(str, TradeType.PRO);
    }

    public static int e(String str) {
        return a1.v().h0(str, TradeType.PRO);
    }

    public static int f() {
        return 8;
    }

    public static int g() {
        return 8;
    }

    public static int h() {
        return 2;
    }

    public static int i() {
        return 2;
    }

    public static int j() {
        return 8;
    }

    public static int k() {
        return 3;
    }

    public static int l() {
        return 4;
    }

    public static int m() {
        return 10;
    }

    public static int n() {
        return 0;
    }

    public static int o() {
        return 8;
    }

    public static int p() {
        return 4;
    }

    public static int q() {
        return 4;
    }

    public static int r() {
        return 8;
    }

    public static int s(String str) {
        return 8;
    }

    public static int t(String str) {
        return 0;
    }

    public static int u(String str) {
        return 1;
    }

    public static int v(String str) {
        return 2;
    }

    public static int w(String str, TradeType tradeType) {
        return a1.v().h0(str, tradeType);
    }

    public static int x(String str) {
        return a1.v().h0(str, TradeType.PRO);
    }

    public static int y(String str) {
        return a1.v().j0(str, TradeType.PRO);
    }

    public static int z(String str) {
        return a1.v().b0(str, TradeType.PRO);
    }
}
