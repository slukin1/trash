package com.facebook.internal;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.facebook.FacebookSdk;

public class InstallReferrerUtil {
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    private InstallReferrerUtil() {
    }

    private static boolean isUpdated() {
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }

    private static void tryConnectReferrerInfo(final Callback callback) {
        final InstallReferrerClient build = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
        build.startConnection(new InstallReferrerStateListener() {
            public void onInstallReferrerServiceDisconnected() {
            }

            public void onInstallReferrerSetupFinished(int i11) {
                if (i11 == 0) {
                    try {
                        String installReferrer = build.getInstallReferrer().getInstallReferrer();
                        if (installReferrer != null && (installReferrer.contains("fb") || installReferrer.contains("facebook"))) {
                            callback.onReceiveReferrerUrl(installReferrer);
                        }
                        InstallReferrerUtil.updateReferrer();
                    } catch (Exception unused) {
                    }
                } else if (i11 == 2) {
                    InstallReferrerUtil.updateReferrer();
                }
            }
        });
    }

    public static void tryUpdateReferrerInfo(Callback callback) {
        if (!isUpdated()) {
            tryConnectReferrerInfo(callback);
        }
    }

    /* access modifiers changed from: private */
    public static void updateReferrer() {
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }
}
