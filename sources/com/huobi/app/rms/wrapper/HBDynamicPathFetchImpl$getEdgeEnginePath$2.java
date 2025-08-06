package com.huobi.app.rms.wrapper;

import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import d10.p;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.x;

public final class HBDynamicPathFetchImpl$getEdgeEnginePath$2 extends Lambda implements p<Map<?, ?>, HBRMSResourceInfoModel, Boolean> {
    public final /* synthetic */ String $module;
    public final /* synthetic */ Ref$ObjectRef<String> $path;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBDynamicPathFetchImpl$getEdgeEnginePath$2(String str, Ref$ObjectRef<String> ref$ObjectRef) {
        super(2);
        this.$module = str;
        this.$path = ref$ObjectRef;
    }

    public final Boolean invoke(Map<?, ?> map, HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        Object obj = map.get("moduleName");
        if (!(obj instanceof String) || !x.b(((String) obj).toLowerCase(Locale.ROOT), this.$module)) {
            return Boolean.FALSE;
        }
        this.$path.element = hBRMSResourceInfoModel.getResourcePath();
        return Boolean.TRUE;
    }
}
