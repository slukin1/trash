package com.hbg.lib.data.future.util;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.hbg.lib.network.option.controller.OptionCurrencyInfoController;
import com.hbg.lib.network.option.controller.OptionProductInfoController;

public class FuturePrecisionUtil {
    public static int A(String str, String str2, String str3) {
        TradeType a11 = FutureTypeUtil.a(str, str2, str3);
        if (a11 == TradeType.OPTION) {
            return OptionCurrencyInfoController.i().n(str2, 2);
        }
        if (a11 == TradeType.LINEAR_SWAP) {
            return LinearSwapCurrencyInfoController.l().q(str2, 2);
        }
        return 2;
    }

    public static int B() {
        return 0;
    }

    public static int a() {
        return 6;
    }

    public static int b(String str) {
        return IndexCurrencyInfoController.k().l(str, 2);
    }

    public static int c(String str) {
        return LinearSwapProductInfoController.o().q(str, 0);
    }

    public static int d(String str) {
        return LinearSwapProductInfoController.o().k(str, 2);
    }

    public static int e(String str) {
        return LinearSwapProductInfoController.o().m(str, 2);
    }

    public static int f(String str) {
        return LinearSwapProductInfoController.o().n(str, 8);
    }

    public static int g(String str) {
        return LinearSwapProductInfoController.o().p(str, 8);
    }

    public static int h(String str) {
        return LinearSwapProductInfoController.o().r(str, 2);
    }

    public static int i(String str) {
        return 2;
    }

    public static int j(String str) {
        return OptionProductInfoController.h().i(str, 0);
    }

    public static int k(String str) {
        return OptionProductInfoController.h().j(str, 0);
    }

    public static int l(String str) {
        return OptionProductInfoController.h().e(str, 2);
    }

    public static int m(String str) {
        return OptionProductInfoController.h().f(str, 2);
    }

    public static int n(String str) {
        return OptionProductInfoController.h().g(str, 8);
    }

    public static int o(String str) {
        return OptionProductInfoController.h().k(str, 8);
    }

    public static int p(String str) {
        return OptionProductInfoController.h().l(str, 2);
    }

    public static int q(String str) {
        return 2;
    }

    public static int r(String str) {
        return 2;
    }

    public static int s(String str, String str2, String str3) {
        return t("", str, str2, str3);
    }

    public static int t(String str, String str2, String str3, String str4) {
        int i11;
        TradeType a11 = FutureTypeUtil.a(str2, str3, str4);
        if (a11 == TradeType.OPTION) {
            if (OptionCurrencyInfoController.i().j(str4) == null) {
                i11 = OptionCurrencyInfoController.i().d(str, 2);
            } else {
                i11 = OptionCurrencyInfoController.i().c(str4, 2);
            }
            return i11;
        } else if (a11 == TradeType.LINEAR_SWAP) {
            return LinearSwapCurrencyInfoController.l().e(str2, 2);
        } else {
            return 2;
        }
    }

    public static int u(String str, String str2, String str3) {
        return v("", str, str2, str3);
    }

    public static int v(String str, String str2, String str3, String str4) {
        int i11;
        TradeType a11 = FutureTypeUtil.a(str2, str3, str4);
        if (a11 == TradeType.OPTION) {
            if (OptionCurrencyInfoController.i().j(str4) == null) {
                i11 = OptionCurrencyInfoController.i().g(str, 2);
            } else {
                i11 = OptionCurrencyInfoController.i().f(str4, 2);
            }
            return i11;
        } else if (a11 == TradeType.LINEAR_SWAP) {
            return LinearSwapCurrencyInfoController.l().i(str2, 2);
        } else {
            return 2;
        }
    }

    public static int w(String str, String str2, String str3) {
        return x("", str, str2, str3);
    }

    public static int x(String str, String str2, String str3, String str4) {
        int i11;
        TradeType a11 = FutureTypeUtil.a(str2, str3, str4);
        if (a11 == TradeType.OPTION) {
            if (OptionCurrencyInfoController.i().j(str4) == null) {
                i11 = OptionCurrencyInfoController.i().l(str, 2);
            } else {
                i11 = OptionCurrencyInfoController.i().k(str4, 2);
            }
            return i11;
        } else if (a11 == TradeType.LINEAR_SWAP) {
            return LinearSwapCurrencyInfoController.l().o(str2, 2);
        } else {
            return 2;
        }
    }

    public static int y(String str, String str2, String str3) {
        return z("", str, str2, str3);
    }

    public static int z(String str, String str2, String str3, String str4) {
        int i11;
        TradeType a11 = FutureTypeUtil.a(str2, str3, str4);
        if (a11 == TradeType.OPTION) {
            if (OptionCurrencyInfoController.i().j(str4) == null) {
                i11 = OptionCurrencyInfoController.i().o(str, 2);
            } else {
                i11 = OptionCurrencyInfoController.i().m(str4, 2);
            }
            return i11;
        } else if (a11 == TradeType.LINEAR_SWAP) {
            return LinearSwapCurrencyInfoController.l().p(str2, 2);
        } else {
            return 2;
        }
    }
}
