package com.hbg.module.content.ui.activity.live;

import android.util.Log;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class LiveDetailActivity$initData$1$12$2$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$initData$1$12$2$2(LiveDetailActivity liveDetailActivity) {
        super(2);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        String str;
        String str2;
        String str3;
        String aPIStatusErrorException2;
        String str4 = "";
        if (th2 == null || (str = th2.toString()) == null) {
            str = str4;
        }
        Log.d("直播", str);
        if (aPIStatusErrorException == null || (str2 = aPIStatusErrorException.toString()) == null) {
            str2 = str4;
        }
        Log.d("直播", str2);
        HuobiToastUtil.j(R$string.n_service_error);
        String simpleName = this.this$0.getClass().getSimpleName();
        if (th2 == null || (str3 = th2.toString()) == null) {
            str3 = str4;
        }
        LogAndWoodRecorder.a(simpleName, str3);
        String simpleName2 = this.this$0.getClass().getSimpleName();
        if (!(aPIStatusErrorException == null || (aPIStatusErrorException2 = aPIStatusErrorException.toString()) == null)) {
            str4 = aPIStatusErrorException2;
        }
        LogAndWoodRecorder.a(simpleName2, str4);
    }
}
