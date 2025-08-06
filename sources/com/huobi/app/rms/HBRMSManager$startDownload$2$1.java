package com.huobi.app.rms;

import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HBRMSManager$startDownload$2$1 extends Lambda implements p<Exception, String, Unit> {
    public final /* synthetic */ HBRMSResourceInfoModel $obj;
    public final /* synthetic */ List<HBRMSResourceInfoModel> $originArray;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$startDownload$2$1(List<HBRMSResourceInfoModel> list, HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        super(2);
        this.$originArray = list;
        this.$obj = hBRMSResourceInfoModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Exception) obj, (String) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Exception exc, String str) {
        this.$originArray.remove(this.$obj);
    }
}
