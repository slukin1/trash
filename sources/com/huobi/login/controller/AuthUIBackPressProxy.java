package com.huobi.login.controller;

import android.app.Activity;
import com.huobi.account.helper.UserLoginHelper;

public class AuthUIBackPressProxy {
    public boolean a(Activity activity) {
        if (!UserLoginHelper.e().i()) {
            return false;
        }
        KillProcessProxy.c(activity);
        return true;
    }

    public boolean b() {
        return !UserLoginHelper.e().i();
    }
}
