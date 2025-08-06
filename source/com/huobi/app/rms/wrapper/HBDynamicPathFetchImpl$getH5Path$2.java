package com.huobi.app.rms.wrapper;

import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import d10.p;
import i6.k;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;

public final class HBDynamicPathFetchImpl$getH5Path$2 extends Lambda implements p<Map<?, ?>, HBRMSResourceInfoModel, Boolean> {
    public final /* synthetic */ Ref$ObjectRef<String> $h5Path;
    public final /* synthetic */ Ref$ObjectRef<String> $h5ResPath;
    public final /* synthetic */ Ref$ObjectRef<HBRMSResourceInfoModel> $hbrmsResourceInfoModel;
    public final /* synthetic */ Ref$BooleanRef $isUrlPath;
    public final /* synthetic */ String $pathMd5;
    public final /* synthetic */ Ref$ObjectRef<String> $resourcePath;
    public final /* synthetic */ HBDynamicPathFetchImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBDynamicPathFetchImpl$getH5Path$2(HBDynamicPathFetchImpl hBDynamicPathFetchImpl, String str, Ref$ObjectRef<String> ref$ObjectRef, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<HBRMSResourceInfoModel> ref$ObjectRef2, Ref$ObjectRef<String> ref$ObjectRef3, Ref$ObjectRef<String> ref$ObjectRef4) {
        super(2);
        this.this$0 = hBDynamicPathFetchImpl;
        this.$pathMd5 = str;
        this.$h5Path = ref$ObjectRef;
        this.$isUrlPath = ref$BooleanRef;
        this.$hbrmsResourceInfoModel = ref$ObjectRef2;
        this.$resourcePath = ref$ObjectRef3;
        this.$h5ResPath = ref$ObjectRef4;
    }

    public final Boolean invoke(Map<?, ?> map, HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        T t11;
        Object obj = map.get("grayId");
        k.d("pathFetch", "grayId " + obj);
        if (!(obj instanceof Integer) || this.this$0.g(((Number) obj).intValue())) {
            Object obj2 = map.get("urlPath");
            if (obj2 instanceof List) {
                String str = this.$pathMd5;
                Ref$ObjectRef<String> ref$ObjectRef = this.$h5Path;
                Ref$BooleanRef ref$BooleanRef = this.$isUrlPath;
                Ref$ObjectRef<HBRMSResourceInfoModel> ref$ObjectRef2 = this.$hbrmsResourceInfoModel;
                for (Object b11 : (Iterable) obj2) {
                    if (x.b(b11, str)) {
                        ref$ObjectRef.element = hBRMSResourceInfoModel.getResourcePath();
                        ref$BooleanRef.element = true;
                        ref$ObjectRef2.element = hBRMSResourceInfoModel;
                        return Boolean.TRUE;
                    }
                }
            }
            Object obj3 = map.get("proxyConf");
            if (obj3 instanceof List) {
                Ref$ObjectRef<String> ref$ObjectRef3 = this.$resourcePath;
                Ref$ObjectRef<String> ref$ObjectRef4 = this.$h5ResPath;
                Ref$ObjectRef<HBRMSResourceInfoModel> ref$ObjectRef5 = this.$hbrmsResourceInfoModel;
                for (Object next : (Iterable) obj3) {
                    if (next instanceof Map) {
                        Map map2 = (Map) next;
                        if (map2.get("locationReg") != null) {
                            Regex regex = new Regex((String) map2.get("locationReg"));
                            k.d("HBRMSOffline", "matchPath:" + ((String) ref$ObjectRef3.element));
                            if (Regex.find$default(regex, (CharSequence) ref$ObjectRef3.element, 0, 2, (Object) null) != null) {
                                if (!(map2.get("proxyPassReg") instanceof String) || !(map2.get("proxyPassReplaceMent") instanceof String)) {
                                    t11 = hBRMSResourceInfoModel.getResourcePath() + ((String) ref$ObjectRef3.element);
                                } else {
                                    t11 = hBRMSResourceInfoModel.getResourcePath() + new Regex((String) map2.get("proxyPassReg")).replace((CharSequence) ref$ObjectRef3.element, (String) map2.get("proxyPassReplaceMent"));
                                }
                                ref$ObjectRef4.element = t11;
                                ref$ObjectRef5.element = hBRMSResourceInfoModel;
                                k.d("HBRMSOffline", "regex match:" + ((String) ref$ObjectRef4.element));
                                return Boolean.TRUE;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return Boolean.FALSE;
        }
        k.d("pathFetch", "not match gray!");
        return Boolean.FALSE;
    }
}
