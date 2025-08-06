package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.Util;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Context f69387a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static g f69388a = new g();
    }

    public static g a(Context context) {
        if (f69387a == null) {
            f69387a = context.getApplicationContext();
        }
        return a.f69388a;
    }

    private void b(j jVar) {
        Intent intent = new Intent();
        intent.putExtra("group_id", jVar.f69758r);
        intent.putExtra("msgId", jVar.f69741a);
        intent.putExtra("type", jVar.f69746f);
        intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, 100);
        intent.putExtra("server_time", jVar.f69751k);
        intent.putExtra(MessageKey.MSG_TARGET_TYPE, jVar.f69760t);
        intent.putExtra("source", jVar.f69761u);
        intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, jVar.f69748h);
        ServiceStat.appReportServiceReceived(b.e(), intent);
    }

    public void a(j jVar) {
        try {
            String str = jVar.f69765y;
            if (Util.isNullOrEmptyString(str)) {
                return;
            }
            if (f69387a != null) {
                b(jVar);
                Intent intent = new Intent();
                intent.setClass(f69387a, InAppMessageActivity.class);
                intent.putExtra("inAppMsg", str);
                intent.putExtra("group_id", jVar.f69758r);
                intent.putExtra("msgId", jVar.f69741a);
                intent.putExtra("type", jVar.f69746f);
                intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, jVar.f69753m);
                intent.putExtra("server_time", jVar.f69751k);
                intent.putExtra(MessageKey.MSG_TARGET_TYPE, jVar.f69760t);
                intent.putExtra("source", jVar.f69761u);
                intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, jVar.f69748h);
                intent.putExtra(MessageKey.MSG_INAPP_PORTECT_TAG, Rijndael.encrypt("" + (System.currentTimeMillis() - 1000)));
                intent.addFlags(268435456);
                f69387a.startActivity(intent);
            }
        } catch (Throwable th2) {
            TLogger.e("InAppMessageManager", "InAppMsg parseInAppMsgConfig :" + th2.toString());
        }
    }
}
