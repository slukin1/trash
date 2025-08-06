package com.huobi.homemarket.helper;

import com.google.android.material.appbar.AppBarLayout;

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public State f72723b = State.IDLE;

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    public abstract void a(AppBarLayout appBarLayout, State state);

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        if (i11 == 0) {
            State state = this.f72723b;
            State state2 = State.EXPANDED;
            if (state != state2) {
                a(appBarLayout, state2);
            }
            this.f72723b = state2;
        } else if (Math.abs(i11) >= appBarLayout.getTotalScrollRange()) {
            State state3 = this.f72723b;
            State state4 = State.COLLAPSED;
            if (state3 != state4) {
                a(appBarLayout, state4);
            }
            this.f72723b = state4;
        } else {
            State state5 = this.f72723b;
            State state6 = State.IDLE;
            if (state5 != state6) {
                a(appBarLayout, state6);
            }
            this.f72723b = state6;
        }
    }
}
