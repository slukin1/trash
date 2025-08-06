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
import nn.v1;
import pro.huobi.R;
import rn.c;
import sn.f;
import tg.r;
import u6.g;

public class UnlockGuidePresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public kn.a f75515a;

    /* renamed from: b  reason: collision with root package name */
    public String f75516b = null;

    public interface a extends g {
        void P2();

        void z2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        if (!gj.a.b().c() || e.b().f()) {
            R();
        } else {
            e.b().e(getActivity());
        }
        getActivity().finish();
    }

    public void R() {
        if (r.x().X()) {
            c.i().A(getActivity(), this.f75515a);
        } else if (this.f75515a != null) {
            f.e(getActivity(), this.f75515a);
        }
    }

    public final void S(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (!str2.equals(this.f75516b)) {
                ((a) getUI()).z2();
                return;
            }
            HuobiToastUtil.t(getActivity(), R.string.otc_trade_setting_success);
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
            ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 1);
            GestureUtil.e(this.f75516b);
            r.x().i0(r.x().M());
            i.b().g(new v1(this), 1000);
        }
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null && intent.getExtras().containsKey("target")) {
            this.f75515a = (kn.a) intent.getExtras().get("target");
        }
    }

    public void V(String str) {
        if (!TextUtils.isEmpty(this.f75516b)) {
            S(this.f75516b, str);
            return;
        }
        this.f75516b = str;
        ((a) getUI()).P2();
    }
}
