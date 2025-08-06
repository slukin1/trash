package com.huobi.login.utils;

import androidx.biometric.BiometricPrompt;
import androidx.biometric.c;
import androidx.core.content.ContextCompat;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import pro.huobi.R;
import tg.r;

public class FingerprintHelper {

    /* renamed from: a  reason: collision with root package name */
    public BiometricPrompt f75711a;

    /* renamed from: b  reason: collision with root package name */
    public String f75712b = ConfigPreferences.e("user_config", "config_current_uid", "");

    public void a() {
    }

    public int b() {
        return c.g(j.c()).a(255);
    }

    public int c() {
        if (b() != 0) {
            return 0;
        }
        String e11 = ConfigPreferences.e("user_config", this.f75712b + "_" + "finger_state", "finger_state_close");
        if (e11.equals("finger_state_open")) {
            return 1;
        }
        if (e11.equals("finger_state_close")) {
            return 2;
        }
        return 0;
    }

    public boolean d() {
        return c() == 1;
    }

    public boolean e() {
        String e11 = ConfigPreferences.e("user_config", this.f75712b + "_" + "finger_state", "finger_state_close");
        if (e11.equals("finger_state_open")) {
            ConfigPreferences.m("user_config", this.f75712b + "_" + "finger_state", "finger_state_close");
            HuobiToastUtil.v(j.c().getString(R.string.fingerprint_disabled));
            return true;
        }
        if (e11.equals("finger_state_close")) {
            int b11 = b();
            if (b11 == 0) {
                ConfigPreferences.m("user_config", this.f75712b + "_" + "finger_state", "finger_state_open");
                r.x().i0(r.x().M());
                HuobiToastUtil.v(j.c().getString(R.string.fingerprint_enabled));
                return true;
            } else if (b11 != 11) {
                HuobiToastUtil.l(j.c(), j.c().getResources().getString(R.string.fingerprint_error_message1));
            } else {
                HuobiToastUtil.l(j.c(), j.c().getResources().getString(R.string.fingerprint_error_message2));
            }
        }
        return false;
    }

    public boolean f() {
        String e11 = ConfigPreferences.e("user_config", this.f75712b + "_" + "finger_state", "finger_state_close");
        if (e11.equals("finger_state_open")) {
            ConfigPreferences.m("user_config", this.f75712b + "_" + "finger_state", "finger_state_close");
            return true;
        } else if (!e11.equals("finger_state_close") || b() != 0) {
            return false;
        } else {
            ConfigPreferences.m("user_config", this.f75712b + "_" + "finger_state", "finger_state_open");
            r.x().i0(r.x().M());
            return true;
        }
    }

    public void g(CancellationSignal.b bVar) {
    }

    public void h(FragmentActivity fragmentActivity, BiometricPrompt.AuthenticationCallback authenticationCallback) {
        BiometricPrompt biometricPrompt = new BiometricPrompt(fragmentActivity, ContextCompat.getMainExecutor(fragmentActivity), authenticationCallback);
        this.f75711a = biometricPrompt;
        biometricPrompt.a(new BiometricPrompt.PromptInfo.Builder().c(fragmentActivity.getString(R.string.fingerprint_dialog_message)).b(fragmentActivity.getString(R.string.n_cancel)).a());
    }

    public void i(FragmentActivity fragmentActivity, String str, BiometricPrompt.AuthenticationCallback authenticationCallback) {
        h(fragmentActivity, authenticationCallback);
    }

    public void j() {
        BiometricPrompt biometricPrompt = this.f75711a;
        if (biometricPrompt != null) {
            biometricPrompt.c();
            this.f75711a = null;
        }
    }
}
