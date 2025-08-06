package com.tencent.qcloud.tuikit.timcommon.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.util.HashMap;

public class MessageBuilder {
    private static final String TAG = "MessageBuilder";

    public static void mergeCloudCustomData(TUIMessageBean tUIMessageBean, String str, Object obj) {
        HashMap hashMap;
        String cloudCustomData = tUIMessageBean.getV2TIMMessage().getCloudCustomData();
        Gson gson = new Gson();
        if (TextUtils.isEmpty(cloudCustomData)) {
            hashMap = new HashMap();
        } else {
            try {
                hashMap = (HashMap) gson.fromJson(cloudCustomData, HashMap.class);
            } catch (JsonSyntaxException e11) {
                String str2 = TAG;
                TIMCommonLog.e(str2, " mergeCloudCustomData error " + e11.getMessage());
                hashMap = null;
            }
        }
        if (hashMap != null) {
            hashMap.put(str, obj);
            cloudCustomData = gson.toJson((Object) hashMap);
        }
        tUIMessageBean.getV2TIMMessage().setCloudCustomData(cloudCustomData);
    }
}
