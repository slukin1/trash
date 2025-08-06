package com.huobi.otc.floating;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.network.otc.core.bean.OtcTokenUpdate;
import com.huobi.account.event.LogOutEvent;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import com.huobi.otc.bean.ReminderData;
import gp.a;
import gp.c;
import gp.d;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class OtcReminderPresenterImp implements c {

    /* renamed from: a  reason: collision with root package name */
    public final a f78400a;

    /* renamed from: b  reason: collision with root package name */
    public d f78401b;

    public OtcReminderPresenterImp(d dVar, a aVar) {
        this.f78401b = dVar;
        this.f78400a = aVar;
        EventBus.d().p(this);
    }

    public void a(ReminderData reminderData) {
        if (reminderData != null) {
            if (reminderData.getOrderId() == 0) {
                this.f78401b.dismiss();
            } else if (this.f78401b.g() == null) {
                this.f78401b.e(reminderData);
            } else if (!reminderData.equals(this.f78401b.g())) {
                this.f78401b.a(reminderData);
            }
        }
    }

    public void b() {
        this.f78401b.dismiss();
        this.f78400a.disconnect();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAuthError(mo.a aVar) {
        i6.d.b("Web socket disconnected due to login time out.");
        b();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onBackgroundStatusChanged(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        if (onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.FOREGROUND) {
            start();
            i6.d.b("Web socket connected due to start running in foreground.");
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onLogout(LogOutEvent logOutEvent) {
        i6.d.b("Web socket disconnected due to logout.");
        b();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onOtcTokenUpdate(OtcTokenUpdate otcTokenUpdate) {
        if (!TextUtils.isEmpty(otcTokenUpdate.getOtcToken())) {
            i6.d.b("Web socket connect due to login.");
            start();
            return;
        }
        onLogout((LogOutEvent) null);
    }

    public void start() {
        i6.d.b("#connnect#新建连接");
        this.f78400a.connect();
    }
}
