package com.tencent.android.tpush.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.hbg.lib.network.pro.core.util.Period;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.e.b.a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20160810", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
public class b {
    public static void a(final Context context) {
        if (context == null) {
            TLogger.ee("OtherPushClient", "updateToken Error: context is null");
            return;
        }
        try {
            if (XGPushConfig.isUsedOtherPush(context) && d.a(context).m()) {
                CommonWorkingThread.getInstance().execute(new TTask() {
                    public void TRun() {
                        b.c(context);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        final String token = XGPushConfig.getToken(context);
        if (token == null) {
            TLogger.i("OtherPushClient", "updateToken: TPNS Token has not registered");
            return;
        }
        d.a(context).q();
        String k11 = d.a(context).k();
        final String f11 = d.a(context).f();
        String g11 = d.a(context).g();
        TLogger.ii("OtherPushClient", "handleUpdateToken other push token is : " + f11 + " other push type: " + k11 + " other push region: " + g11);
        if (j.b(k11) || j.b(f11)) {
            TLogger.ww("OtherPushClient", "updateToken Error: get otherPushType or otherPushToken is null");
            return;
        }
        try {
            final long accessId = XGPushConfig.getAccessId(context);
            String accessKey = XGPushConfig.getAccessKey(context);
            String str = (String) CacheHelper.get(context, a.a(accessId + ""));
            if (!j.b(str)) {
                long longValue = ((Long) CacheHelper.get(context, a.b(accessId + ""))).longValue();
                if (!str.equals(token + ":" + f11) || Math.abs(System.currentTimeMillis() - longValue) >= Period.DAY_MILLS) {
                    TLogger.ii("OtherPushClient", "OtherToken or Mid changed , go on bind");
                } else {
                    TLogger.ii("OtherPushClient", "Already bind OtherPush succeed token with accessId = " + accessId + "  token = " + token + " otherPushType = " + k11 + " otherPushToken = " + f11);
                    return;
                }
            }
            BroadcastAgent.registerReceiver(context, new BroadcastReceiver() {
                public void onReceive(final Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    final Context applicationContext = context.getApplicationContext();
                    CommonWorkingThread.getInstance().execute(new TTask() {
                        public void TRun() {
                            TLogger.ii("OtherPushClient", "handleUpdateOtherPushToken call back to " + context.getPackageName());
                            Context context = applicationContext;
                            CacheHelper.Key<String> a11 = a.a(accessId + "");
                            CacheHelper.set(context, a11.set(token + ":" + f11), a.b(accessId + "").set(Long.valueOf(System.currentTimeMillis())));
                        }
                    });
                    j.a(context, (BroadcastReceiver) this);
                }
            }, new IntentFilter("com.tencent.android.xg.vip.action.UPDATE.OTHER.TOKEN.RESULT.V4"), 4);
            Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4");
            intent.putExtra("accId", Rijndael.encrypt("" + accessId));
            intent.putExtra(Constants.FLAG_ACC_KEY, Rijndael.encrypt("" + accessKey));
            intent.putExtra("token", Rijndael.encrypt(token));
            intent.putExtra("other_push_type", Rijndael.encrypt(k11));
            intent.putExtra(Constants.OTHER_PUSH_TOKEN, Rijndael.encrypt(f11));
            intent.putExtra("other_push_region", Rijndael.encrypt(g11));
            BroadcastAgent.sendBroadcast(context, intent);
        } catch (Throwable th2) {
            TLogger.e("OtherPushClient", "sendBroadcast action ACTION_UPDATE_OTHER_PUSH_TOKEN error", th2);
        }
    }
}
