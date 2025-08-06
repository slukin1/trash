package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

public class IntentCallable implements Callable<Void> {

    /* renamed from: a  reason: collision with root package name */
    private Context f38439a;

    /* renamed from: b  reason: collision with root package name */
    private Intent f38440b;

    /* renamed from: c  reason: collision with root package name */
    private String f38441c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f38439a = context;
        this.f38440b = intent;
        this.f38441c = str;
    }

    public Void call() throws Exception {
        this.f38439a.sendBroadcast(this.f38440b);
        PushBiUtil.reportExit(this.f38439a, PushNaming.SET_NOTIFY_FLAG, this.f38441c, ErrorEnum.SUCCESS);
        return null;
    }
}
