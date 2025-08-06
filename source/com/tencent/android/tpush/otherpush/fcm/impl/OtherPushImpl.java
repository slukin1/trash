package com.tencent.android.tpush.otherpush.fcm.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.tencent.android.fcm.Constants;
import com.tencent.android.fcm.Util;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;

public class OtherPushImpl {
    private static final int FCM_API_VERSION_22 = 22;
    private static final int FCM_API_VERSION_ERROR = -1;
    private static final int FCM_API_VERSION_LOWER_22 = 17;
    private static final String SP_FILE = "xg.otherpush.xml";
    public static final String TPUSH_FCM_TOKEN = "XG_V2_FCM_APP_TOKEN";
    private static int fcmApiVersion = 0;
    public static String fcmToken = "";
    private static int isAvailable = -1;

    public static boolean checkDevice(Context context) {
        int i11;
        if (isAvailable == -1) {
            try {
                i11 = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            } catch (Throwable unused) {
                i11 = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context);
            }
            TLogger.d(Constants.OTHER_PUSH_TAG, " GooglePlayServices service resultCode = " + i11);
            if (i11 == 0 || i11 == 2 || i11 == 21) {
                TLogger.d(Constants.OTHER_PUSH_TAG, "This device is supported, GooglePlayServices service is running");
                isAvailable = 1;
            } else {
                TLogger.d(Constants.OTHER_PUSH_TAG, " GooglePlayServices is not supported");
                isAvailable = 0;
            }
        }
        if (isAvailable == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static int getFCMVersion() {
        if (fcmApiVersion == 0) {
            Class<FirebaseMessaging> cls = FirebaseMessaging.class;
            try {
                String str = FirebaseMessaging.TAG;
                cls.getDeclaredMethod("getToken", new Class[0]);
                TLogger.i(Constants.OTHER_PUSH_TAG, "get FCM version over 22");
                fcmApiVersion = 22;
            } catch (NoSuchMethodException unused) {
                TLogger.i(Constants.OTHER_PUSH_TAG, "get FCM version lower 22");
                fcmApiVersion = 17;
            } catch (Throwable unused2) {
                TLogger.w(Constants.OTHER_PUSH_TAG, "Missing FCM SDK");
                fcmApiVersion = -1;
            }
        }
        return fcmApiVersion;
    }

    /* access modifiers changed from: private */
    public static SharedPreferences getOtherPushSharedPreferences(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return context.getSharedPreferences(SP_FILE, 4);
        }
        return context.getSharedPreferences(SP_FILE, 0);
    }

    public static String getPushInfo() {
        return "fcm";
    }

    public static String getToken(final Context context) {
        try {
            if (!Util.isNullOrEmptyString(fcmToken)) {
                return fcmToken;
            }
            SharedPreferences otherPushSharedPreferences = getOtherPushSharedPreferences(context);
            if (otherPushSharedPreferences != null) {
                String string = otherPushSharedPreferences.getString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), (String) null);
                if (!Util.isNullOrEmptyString(string)) {
                    String decrypt = Rijndael.decrypt(string);
                    fcmToken = decrypt;
                    if (!Util.isNullOrEmptyString(decrypt)) {
                        return fcmToken;
                    }
                }
            }
            if (getFCMVersion() == -1) {
                return fcmToken;
            }
            if (getFCMVersion() == 22) {
                FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                    public void onComplete(Task<String> task) {
                        if (!task.isSuccessful()) {
                            TLogger.w(Constants.OTHER_PUSH_TAG, "getToken failed", task.getException());
                            return;
                        }
                        OtherPushImpl.fcmToken = task.getResult();
                        SharedPreferences access$000 = OtherPushImpl.getOtherPushSharedPreferences(context);
                        if (access$000 != null) {
                            SharedPreferences.Editor edit = access$000.edit();
                            edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(OtherPushImpl.fcmToken));
                            edit.commit();
                        }
                    }
                });
            } else {
                FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    public void onComplete(Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            TLogger.w("OTHER_PUSH_TAG", "getInstanceId failed", task.getException());
                            return;
                        }
                        OtherPushImpl.fcmToken = task.getResult().getToken();
                        SharedPreferences access$000 = OtherPushImpl.getOtherPushSharedPreferences(context);
                        if (access$000 != null) {
                            SharedPreferences.Editor edit = access$000.edit();
                            edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(OtherPushImpl.fcmToken));
                            edit.commit();
                        }
                    }
                });
            }
            return fcmToken;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static void registerPush(final Context context) {
        try {
            if (getFCMVersion() != -1) {
                if (getFCMVersion() == 22) {
                    FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                        public void onComplete(Task<String> task) {
                            if (!task.isSuccessful()) {
                                TLogger.w(Constants.OTHER_PUSH_TAG, "getToken failed", task.getException());
                                return;
                            }
                            OtherPushImpl.fcmToken = task.getResult();
                            TLogger.d(Constants.OTHER_PUSH_TAG, " OtherPushImpl registerFcmPush getToken= " + OtherPushImpl.fcmToken);
                            SharedPreferences access$000 = OtherPushImpl.getOtherPushSharedPreferences(context);
                            if (access$000 != null) {
                                SharedPreferences.Editor edit = access$000.edit();
                                edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(OtherPushImpl.fcmToken));
                                edit.apply();
                            }
                        }
                    });
                } else {
                    FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                        public void onComplete(Task<InstanceIdResult> task) {
                            if (!task.isSuccessful()) {
                                TLogger.w(Constants.OTHER_PUSH_TAG, "getInstanceId failed", task.getException());
                                return;
                            }
                            OtherPushImpl.fcmToken = task.getResult().getToken();
                            TLogger.d(Constants.OTHER_PUSH_TAG, " OtherPushImpl registerFcmPush getToken= " + OtherPushImpl.fcmToken);
                            SharedPreferences access$000 = OtherPushImpl.getOtherPushSharedPreferences(context);
                            if (access$000 != null) {
                                SharedPreferences.Editor edit = access$000.edit();
                                edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(OtherPushImpl.fcmToken));
                                edit.commit();
                            }
                        }
                    });
                }
            }
        } catch (Throwable th2) {
            TLogger.e(Constants.OTHER_PUSH_TAG, "FCM Register error! " + th2);
            fcmToken = null;
        }
    }

    public static void setToken(Context context, String str) {
        fcmToken = str;
        if (str == null) {
            fcmToken = "";
        }
        SharedPreferences otherPushSharedPreferences = getOtherPushSharedPreferences(context);
        if (otherPushSharedPreferences != null) {
            SharedPreferences.Editor edit = otherPushSharedPreferences.edit();
            edit.putString("XG_V2_FCM_APP_TOKEN," + context.getPackageName(), Rijndael.encrypt(fcmToken));
            edit.commit();
        }
    }

    public static void unregisterPush(Context context) {
        try {
            if (getFCMVersion() != -1) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            if (FirebaseApp.getInstance() == null) {
                                TLogger.i(Constants.OTHER_PUSH_TAG, "FCM unregisterPush fail !");
                            } else if (FirebaseApp.getInstance().getOptions() == null) {
                                TLogger.i(Constants.OTHER_PUSH_TAG, "FCM unregisterPush fail !");
                            } else if (OtherPushImpl.getFCMVersion() == 22) {
                                FirebaseMessaging.getInstance().deleteToken();
                            } else {
                                FirebaseInstanceId.getInstance().deleteToken(FirebaseApp.getInstance().getOptions().getGcmSenderId(), FirebaseMessaging.INSTANCE_ID_SCOPE);
                                TLogger.i(Constants.OTHER_PUSH_TAG, "FCM unregisterPush success !");
                            }
                        } catch (IllegalStateException unused) {
                        } catch (Throwable th2) {
                            TLogger.e(Constants.OTHER_PUSH_TAG, "FCM deleteInstanceId error! " + th2);
                        }
                    }
                }).start();
            }
        } catch (Throwable th2) {
            TLogger.e(Constants.OTHER_PUSH_TAG, "FCM unregister error! " + th2);
        }
    }
}
