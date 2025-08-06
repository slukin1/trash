package androidx.test.espresso.action;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.test.espresso.IdlingResource$ResourceCallback;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

public final class CloseKeyboardAction {

    public static class CloseKeyboardIdlingResult extends ResultReceiver {
        private final Handler handler;
        /* access modifiers changed from: private */
        public boolean idle;
        /* access modifiers changed from: private */
        public boolean receivedResult;
        /* access modifiers changed from: private */
        public IdlingResource$ResourceCallback resourceCallback;
        /* access modifiers changed from: private */
        public int result;
        /* access modifiers changed from: private */
        public boolean timedOut;

        private void notifyEspresso(long j11) {
            Preconditions.o(this.receivedResult);
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = CloseKeyboardIdlingResult.this.idle = true;
                    if (CloseKeyboardIdlingResult.this.resourceCallback != null) {
                        CloseKeyboardIdlingResult.this.resourceCallback.a();
                    }
                }
            }, j11);
        }

        /* access modifiers changed from: private */
        public void scheduleTimeout(long j11) {
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    if (!CloseKeyboardIdlingResult.this.receivedResult) {
                        boolean unused = CloseKeyboardIdlingResult.this.timedOut = true;
                        if (CloseKeyboardIdlingResult.this.resourceCallback != null) {
                            CloseKeyboardIdlingResult.this.resourceCallback.a();
                        }
                    }
                }
            }, j11);
        }

        public String getName() {
            return "CloseKeyboardIdlingResource";
        }

        public boolean isIdleNow() {
            return this.idle || this.timedOut;
        }

        public void onReceiveResult(int i11, Bundle bundle) {
            this.result = i11;
            this.receivedResult = true;
            notifyEspresso(300);
        }

        public void registerIdleTransitionCallback(IdlingResource$ResourceCallback idlingResource$ResourceCallback) {
            this.resourceCallback = idlingResource$ResourceCallback;
        }

        private CloseKeyboardIdlingResult(Handler handler2) {
            super(handler2);
            this.receivedResult = false;
            this.result = -1;
            this.timedOut = false;
            this.idle = false;
            this.handler = handler2;
        }
    }
}
