package com.huobi.app.rms;

import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class HBRMSManager$addSuccessModel$2$1 extends Lambda implements l<HBRMSResourceInfoModel, Boolean> {
    public final /* synthetic */ HBRMSResourceInfoModel $model;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$addSuccessModel$2$1(HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        super(1);
        this.$model = hBRMSResourceInfoModel;
    }

    public final Boolean invoke(HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        return Boolean.valueOf(x.b(hBRMSResourceInfoModel.getConfigId(), this.$model.getConfigId()));
    }
}
