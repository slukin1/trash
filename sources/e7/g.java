package e7;

import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import i6.d;
import java.util.HashMap;

public final class g {
    public static void a(HbgDialogConfigInfo hbgDialogConfigInfo) {
        HashMap hashMap = new HashMap();
        if (hbgDialogConfigInfo != null) {
            hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
            hashMap.put("popup_name", hbgDialogConfigInfo.remark);
            hashMap.put("element_type", Integer.valueOf(hbgDialogConfigInfo.positionType));
            hashMap.put("business_category", hbgDialogConfigInfo.businessCategory);
            hashMap.put("updateStrategy", Integer.valueOf(hbgDialogConfigInfo.updateStrategy));
            hashMap.put("recomBaseInfo", hbgDialogConfigInfo.recomBaseInfo);
        }
        BaseModuleConfig.a().w("Ads_feature_close", hashMap);
    }

    public static void b(HbgDialogConfigInfo hbgDialogConfigInfo) {
        HashMap hashMap = new HashMap();
        if (hbgDialogConfigInfo != null) {
            hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
            hashMap.put("popup_name", hbgDialogConfigInfo.remark);
            hashMap.put("element_type", Integer.valueOf(hbgDialogConfigInfo.positionType));
            hashMap.put("business_category", hbgDialogConfigInfo.businessCategory);
        }
        BaseModuleConfig.a().w("Ads_feature_click", hashMap);
    }

    public static void c(HbgDialogConfigInfo hbgDialogConfigInfo) {
        HashMap hashMap = new HashMap();
        if (hbgDialogConfigInfo != null) {
            hashMap.put("popup_id", Long.valueOf(hbgDialogConfigInfo.dialogId));
            hashMap.put("popup_name", hbgDialogConfigInfo.remark);
            hashMap.put("element_type", Integer.valueOf(hbgDialogConfigInfo.positionType));
            hashMap.put("business_category", hbgDialogConfigInfo.businessCategory);
            hashMap.put("updateStrategy", Integer.valueOf(hbgDialogConfigInfo.updateStrategy));
            hashMap.put("recomBaseInfo", hbgDialogConfigInfo.recomBaseInfo);
        }
        d.c("HbgDialogAnalysisUtil", "showTopDialog:" + hashMap);
        BaseModuleConfig.a().w("Ads_feature_show", hashMap);
    }
}
