package com.huobi.login.v3.presenter;

import android.content.Intent;
import android.os.Bundle;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.huobi.login.bean.JumpTarget;
import i6.k;
import u6.g;

public class UserBindTipsPresenter extends ActivityPresenter<a> {

    /* renamed from: c  reason: collision with root package name */
    public static String f76036c = "UserBindTipsPresenter";

    /* renamed from: a  reason: collision with root package name */
    public kn.a f76037a;

    /* renamed from: b  reason: collision with root package name */
    public JumpTarget f76038b;

    public interface a extends g {
    }

    public String Q() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("auth_token")) {
            return null;
        }
        return intent.getExtras().getString("auth_token");
    }

    public String R() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("bindEmail")) {
            return null;
        }
        return intent.getExtras().getString("bindEmail");
    }

    public String S() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("login_name")) {
            return null;
        }
        return intent.getExtras().getString("login_name");
    }

    public String T() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("third_token")) {
            return null;
        }
        return intent.getExtras().getString("third_token");
    }

    public String U() {
        Intent intent = getActivity().getIntent();
        if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("bindType")) {
            return null;
        }
        return intent.getExtras().getString("bindType");
    }

    public JumpTarget V() {
        return this.f76038b;
    }

    /* renamed from: W */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        Bundle extras;
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("target")) {
            kn.a aVar2 = (kn.a) extras.get("target");
            this.f76037a = aVar2;
            if (aVar2 instanceof JumpTarget) {
                this.f76038b = (JumpTarget) aVar2;
            }
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        k.o(f76036c, "onActivityResult");
        super.onActivityResult(i11, i12, intent);
        if (i11 == 50001 && intent != null && intent.getBooleanExtra("PARAM_BIND_RESULT", false)) {
            getActivity().finish();
        }
    }
}
