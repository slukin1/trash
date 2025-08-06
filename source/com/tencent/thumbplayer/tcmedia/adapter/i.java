package com.tencent.thumbplayer.tcmedia.adapter;

import com.tencent.thumbplayer.tcmedia.api.TPPlayerState;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private TPPlayerState f48961a;

    public i(TPPlayerState tPPlayerState) {
        this.f48961a = tPPlayerState;
    }

    private static boolean a(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(2) || tPPlayerState.is(8) || tPPlayerState.is(9);
    }

    private static boolean b(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1);
    }

    private static boolean c(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7) || tPPlayerState.is(8) || tPPlayerState.is(9);
    }

    private static boolean d(TPPlayerState tPPlayerState) {
        return true;
    }

    private static boolean e(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    private static boolean f(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean g(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    private static boolean h(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7) || tPPlayerState.is(10);
    }

    private static boolean i(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    private static boolean j(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean k(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean l(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean m(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean n(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean o(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7);
    }

    private static boolean p(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7) || tPPlayerState.is(10);
    }

    private static boolean q(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3);
    }

    private static boolean r(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean s(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean t(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean u(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean v(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6);
    }

    private static boolean w(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7) || tPPlayerState.is(8);
    }

    private static boolean x(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    private static boolean y(TPPlayerState tPPlayerState) {
        return tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(6) || tPPlayerState.is(7);
    }

    public final boolean a(int i11) {
        if (i11 == 1) {
            return a(this.f48961a);
        }
        if (i11 == 2) {
            return b(this.f48961a);
        }
        if (i11 == 3) {
            return c(this.f48961a);
        }
        if (i11 == 4) {
            return d(this.f48961a);
        }
        if (i11 == 5) {
            return e(this.f48961a);
        }
        if (i11 == 6) {
            return f(this.f48961a);
        }
        if (i11 == 7) {
            return g(this.f48961a);
        }
        if (i11 == 8) {
            return h(this.f48961a);
        }
        if (i11 == 9) {
            return i(this.f48961a);
        }
        if (i11 == 11) {
            return j(this.f48961a);
        }
        if (i11 == 12) {
            return k(this.f48961a);
        }
        if (i11 == 13) {
            return m(this.f48961a);
        }
        if (i11 == 14) {
            return n(this.f48961a);
        }
        if (i11 == 15) {
            return o(this.f48961a);
        }
        if (i11 == 16) {
            return p(this.f48961a);
        }
        if (i11 == 17) {
            return x(this.f48961a);
        }
        if (i11 == 18) {
            return y(this.f48961a);
        }
        if (i11 == 19) {
            return l(this.f48961a);
        }
        return false;
    }

    public final boolean b(int i11) {
        if (i11 == 1) {
            return q(this.f48961a);
        }
        if (i11 == 2) {
            return r(this.f48961a);
        }
        if (i11 == 3) {
            return s(this.f48961a);
        }
        if (i11 == 4) {
            return t(this.f48961a);
        }
        if (i11 == 5) {
            return u(this.f48961a);
        }
        if (i11 == 6) {
            return v(this.f48961a);
        }
        if (i11 == 7) {
            return w(this.f48961a);
        }
        return false;
    }
}
