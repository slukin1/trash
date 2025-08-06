package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

public class a implements Callable<AAIDResult> {

    /* renamed from: a  reason: collision with root package name */
    private Context f38305a;

    public a(Context context) {
        this.f38305a = context;
    }

    /* renamed from: a */
    public AAIDResult call() throws Exception {
        Context context = this.f38305a;
        if (context != null) {
            String b11 = b.b(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(b11);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
