package com.google.android.recaptcha;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class RecaptchaAction {
    public static final Companion Companion = new Companion((r) null);
    public static final RecaptchaAction LOGIN = new RecaptchaAction(FirebaseAnalytics.Event.LOGIN);
    public static final RecaptchaAction SIGNUP = new RecaptchaAction("signup");
    private final String action;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final RecaptchaAction custom(String str) {
            return new RecaptchaAction(str, (r) null);
        }
    }

    private RecaptchaAction(String str) {
        this.action = str;
    }

    public /* synthetic */ RecaptchaAction(String str, r rVar) {
        this(str);
    }

    public static /* synthetic */ RecaptchaAction copy$default(RecaptchaAction recaptchaAction, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = recaptchaAction.action;
        }
        return recaptchaAction.copy(str);
    }

    public static final RecaptchaAction custom(String str) {
        return Companion.custom(str);
    }

    public final String component1() {
        return this.action;
    }

    public final RecaptchaAction copy(String str) {
        return new RecaptchaAction(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecaptchaAction) && x.b(this.action, ((RecaptchaAction) obj).action);
    }

    public final String getAction() {
        return this.action;
    }

    public int hashCode() {
        return this.action.hashCode();
    }

    public String toString() {
        return "RecaptchaAction(action=" + this.action + ")";
    }
}
