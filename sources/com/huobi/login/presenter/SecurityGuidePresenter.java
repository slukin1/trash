package com.huobi.login.presenter;

import android.content.Intent;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.login.ui.NinePointSetActivity;
import gj.e;
import java.util.Map;
import nn.f1;
import nn.g1;
import nn.h1;
import pro.huobi.R;
import rn.c;
import sn.f;
import tg.r;
import u6.g;

public class SecurityGuidePresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f75495a;

    /* renamed from: b  reason: collision with root package name */
    public kn.a f75496b;

    public interface a extends g {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(boolean z11) {
        this.f75495a = z11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(HBDialogFragment hBDialogFragment) {
        if (this.f75495a) {
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
            ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 3);
        }
        hBDialogFragment.dismiss();
        if (gj.a.b().c()) {
            if (!e.b().f()) {
                e.b().e(getActivity());
                is.a.i("4822", (Map<String, Object>) null);
            }
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(HBDialogFragment hBDialogFragment) {
        if (this.f75495a) {
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
            ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 3);
        }
        if (gj.a.b().c()) {
            hBDialogFragment.dismiss();
            U();
            getActivity().finish();
            is.a.i("4825", (Map<String, Object>) null);
            return;
        }
        hBDialogFragment.dismiss();
        if (r.x().X()) {
            c.i().A(getActivity(), this.f75496b);
        } else if (this.f75496b != null) {
            f.e(getActivity(), this.f75496b);
        }
        getActivity().finish();
    }

    public void T() {
        String string = getResources().getString(R.string.security_gesture_password);
        String format = String.format(getString(R.string.login_set_gesture_not_use), new Object[]{string});
        String string2 = getString(R.string.otc_order_dialog_cancle_btn_text);
        String string3 = getString(R.string.gesture_guide_create_later);
        if (gj.a.b().c()) {
            format = getString(R.string.n_login_donot_prompt);
            string2 = getString(R.string.gesture_guide_create_later);
            string3 = getString(R.string.n_open_now);
        }
        new DialogUtils.b.d(getActivity()).c1(getString(R.string.login_set_gesture_title)).C0(String.format(getString(R.string.login_set_gesture_hint_content), new Object[]{string})).P0(string3).s0(string2).x0(true).y0(format).v0(new f1(this)).N0(new h1(this)).Q0(new g1(this)).j0().show(getActivity().getSupportFragmentManager(), "");
    }

    public void U() {
        Intent intent = new Intent(getActivity(), NinePointSetActivity.class);
        f.c(intent, this.f75496b);
        getActivity().startActivity(intent);
        getActivity().finish();
    }

    /* renamed from: Y */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null && intent.getExtras().containsKey("target")) {
            this.f75496b = (kn.a) intent.getExtras().get("target");
        }
    }
}
