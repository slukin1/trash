package com.mob;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huochat.community.base.CommunityConstants;
import com.mob.commons.C0891r;
import com.mob.commons.CSCenter;
import com.mob.commons.InternationalDomain;
import com.mob.commons.MobProduct;
import com.mob.commons.s;
import com.mob.commons.u;
import com.mob.commons.v;
import com.mob.commons.x;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import com.xiaomi.mipush.sdk.Constants;

public class MobSDK implements PublicMemberKeeper {
    public static final int CHANNEL_APICLOUD = 5;
    public static final int CHANNEL_COCOS = 1;
    public static final int CHANNEL_FLUTTER = 4;
    public static final int CHANNEL_JS = 3;
    public static final int CHANNEL_NATIVE = 0;
    public static final int CHANNEL_QUICKSDK = 6;
    public static final int CHANNEL_REACT_NATIVE = 8;
    public static final int CHANNEL_UNIAPP = 7;
    public static final int CHANNEL_UNITY = 2;
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME;

    /* renamed from: a  reason: collision with root package name */
    private static volatile Context f26832a;

    static {
        int i11;
        String str = CommunityConstants.COMMUNITY_SDK_VERSION;
        try {
            str = "2024-10-16".replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, InstructionFileId.DOT);
            i11 = Integer.parseInt("2024-10-16".replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        } catch (Throwable unused) {
            i11 = 1;
        }
        SDK_VERSION_CODE = i11;
        SDK_VERSION_NAME = str;
    }

    @Deprecated
    public static void canIContinueBusiness(final MobProduct mobProduct, Object obj, final Object obj2) {
        if (obj2 != null) {
            new Thread(new Runnable() {
                public void run() {
                    if (MobProduct.this == null) {
                        ReflectHelper.invokeInstanceMethodNoThrow(obj2, "onFailure", null, new Throwable("Product can not be null"));
                        return;
                    }
                    ReflectHelper.invokeInstanceMethodNoThrow(obj2, "onComplete", null, Boolean.TRUE);
                }
            }).start();
            return;
        }
        throw new IllegalArgumentException("callback can not be null");
    }

    public static boolean checkForceHttps() {
        return C0891r.f27326f;
    }

    @Deprecated
    public static String checkRequestUrl(String str) {
        return v.a(str);
    }

    public static boolean checkV6() {
        return C0891r.f27327g;
    }

    @Deprecated
    public static String dynamicModifyUrl(String str) {
        return v.a(str);
    }

    public static String getAppSecret() {
        if (TextUtils.isEmpty(C0891r.f27322b)) {
            return C0891r.f27324d;
        }
        return C0891r.f27322b;
    }

    public static String getAppkey() {
        if (x.h()) {
            return u.a();
        }
        return null;
    }

    public static Context getContext() {
        if (f26832a == null) {
            try {
                Context a11 = v.a();
                if (a11 != null) {
                    init(a11);
                }
            } catch (Throwable unused) {
            }
        }
        return f26832a;
    }

    public static Context getContextSafely() {
        return f26832a;
    }

    public static boolean getDefaultPrivacy() {
        return true;
    }

    public static InternationalDomain getDomain() {
        return C0891r.f27325e == null ? InternationalDomain.DEFAULT : C0891r.f27325e;
    }

    public static int getPrivacyGrantedStatus() {
        return x.c();
    }

    public static synchronized void init(Context context) {
        synchronized (MobSDK.class) {
            init(context, (String) null, (String) null);
        }
    }

    public static final int isAuth() {
        return u.b();
    }

    public static final boolean isForb() {
        return u.d();
    }

    public static final boolean isGppVer() {
        return C0891r.f27329i;
    }

    public static final boolean isMob() {
        return u.c();
    }

    public static void setChannel(MobProduct mobProduct, int i11) {
        if (isForb()) {
            MobLog.getInstance().d("isForb: true", new Object[0]);
        } else {
            s.a().a(mobProduct, i11);
        }
    }

    public static void submitPolicyGrantResult(boolean z11) {
        x.b(z11);
    }

    public static String syncGetBSDM(String str, String str2, String str3, boolean z11) {
        return u.a(str, str2, str3, z11);
    }

    public static void updateMobCustomController(MobCustomController mobCustomController) {
        CSCenter.getInstance().updateCustomController(mobCustomController);
    }

    public static void submitPolicyGrantResult(MobCustomController mobCustomController, boolean z11) {
        submitPolicyGrantResult(z11);
        updateMobCustomController(mobCustomController);
    }

    public static synchronized void init(Context context, String str) {
        synchronized (MobSDK.class) {
            init(context, str, (String) null);
        }
    }

    @Deprecated
    public static void submitPolicyGrantResult(boolean z11, final OperationCallback<Void> operationCallback) {
        x.b(z11);
        if (operationCallback != null) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    OperationCallback operationCallback = OperationCallback.this;
                    if (operationCallback == null) {
                        return false;
                    }
                    operationCallback.onComplete(null);
                    return false;
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mob.MobSDK> r0 = com.mob.MobSDK.class
            monitor-enter(r0)
            if (r2 != 0) goto L_0x000e
            java.lang.String r2 = "SDK"
            java.lang.String r3 = "Init error, context is null"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)
            return
        L_0x000e:
            android.content.Context r1 = f26832a     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x0021
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0039 }
            f26832a = r2     // Catch:{ all -> 0x0039 }
            com.mob.commons.C0891r.f27321a = r3     // Catch:{ all -> 0x0039 }
            com.mob.commons.C0891r.f27322b = r4     // Catch:{ all -> 0x0039 }
            r2 = 0
            com.mob.commons.u.a((boolean) r2)     // Catch:{ all -> 0x0039 }
            goto L_0x0037
        L_0x0021:
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0039 }
            if (r2 != 0) goto L_0x0037
            java.lang.String r2 = com.mob.commons.C0891r.f27321a     // Catch:{ all -> 0x0039 }
            boolean r2 = r3.equals(r2)     // Catch:{ all -> 0x0039 }
            if (r2 != 0) goto L_0x0037
            com.mob.commons.C0891r.f27321a = r3     // Catch:{ all -> 0x0039 }
            com.mob.commons.C0891r.f27322b = r4     // Catch:{ all -> 0x0039 }
            r2 = 1
            com.mob.commons.u.a((boolean) r2)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r0)
            return
        L_0x0039:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.MobSDK.init(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
