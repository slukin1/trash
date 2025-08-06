package com.huobi.login.presenter;

import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.utils.GestureUtil;
import gj.e;
import i6.i;
import nn.e1;
import pro.huobi.R;
import rn.c;
import sn.f;
import tg.r;
import u6.g;

public class NinePointSetPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public kn.a f75493a;

    /* renamed from: b  reason: collision with root package name */
    public String f75494b = null;

    public interface a extends g {
        void P2();

        void z2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U() {
        if (gj.a.b().c() && !e.b().f()) {
            e.b().e(getActivity());
        } else if (r.x().X()) {
            c.i().A(getActivity(), this.f75493a);
        } else if (this.f75493a != null) {
            f.e(getActivity(), this.f75493a);
        }
        getActivity().finish();
    }

    public void R() {
        S();
        getActivity().finish();
    }

    public void S() {
        if (gj.a.b().c() && !e.b().f()) {
            e.b().e(getActivity());
        } else if (r.x().X()) {
            c.i().A(getActivity(), this.f75493a);
        } else if (this.f75493a != null) {
            f.e(getActivity(), this.f75493a);
        }
    }

    public final void T(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (!str2.equals(this.f75494b)) {
                ((a) getUI()).z2();
                return;
            }
            HuobiToastUtil.t(getActivity(), R.string.set_complete);
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
            ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 1);
            GestureUtil.e(this.f75494b);
            r.x().i0(r.x().M());
            i.b().g(new e1(this), 1000);
        }
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null && intent.getExtras().containsKey("target")) {
            this.f75493a = (kn.a) intent.getExtras().get("target");
        }
    }

    public void W(String str) {
        if (!TextUtils.isEmpty(this.f75494b)) {
            T(this.f75494b, str);
            return;
        }
        this.f75494b = str;
        ((a) getUI()).P2();
    }
}
