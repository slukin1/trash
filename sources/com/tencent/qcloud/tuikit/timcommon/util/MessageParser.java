package com.tencent.qcloud.tuikit.timcommon.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageFeature;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.util.HashMap;
import java.util.Map;

public class MessageParser {
    private static final String TAG = "MessageParser";

    public static MessageFeature isSupportTyping(TUIMessageBean tUIMessageBean) {
        String cloudCustomData = tUIMessageBean.getV2TIMMessage().getCloudCustomData();
        if (TextUtils.isEmpty(cloudCustomData)) {
            return null;
        }
        try {
            Gson gson = new Gson();
            HashMap hashMap = (HashMap) gson.fromJson(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get(TIMCommonConstants.MESSAGE_FEATURE_KEY);
                MessageFeature messageFeature = obj instanceof Map ? (MessageFeature) gson.fromJson(gson.toJson(obj), MessageFeature.class) : null;
                if (messageFeature == null || messageFeature.getVersion() > 1) {
                    return null;
                }
                return messageFeature;
            }
        } catch (JsonSyntaxException e11) {
            String str = TAG;
            TIMCommonLog.e(str, " isSupportTyping exception e = " + e11);
        }
        return null;
    }

    public static MessageReactBean parseMessageReact(TUIMessageBean tUIMessageBean) {
        String cloudCustomData = tUIMessageBean.getV2TIMMessage().getCloudCustomData();
        try {
            Gson gson = new Gson();
            HashMap hashMap = (HashMap) gson.fromJson(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get(TIMCommonConstants.MESSAGE_REACT_KEY);
                MessageReactBean messageReactBean = obj instanceof Map ? (MessageReactBean) gson.fromJson(gson.toJson(obj), MessageReactBean.class) : null;
                if (messageReactBean == null || messageReactBean.getVersion() > 1) {
                    return null;
                }
                return messageReactBean;
            }
        } catch (JsonSyntaxException unused) {
            TIMCommonLog.e(TAG, " getCustomJsonMap error ");
        }
        return null;
    }

    public static MessageRepliesBean parseMessageReplies(TUIMessageBean tUIMessageBean) {
        String cloudCustomData = tUIMessageBean.getV2TIMMessage().getCloudCustomData();
        try {
            Gson gson = new Gson();
            HashMap hashMap = (HashMap) gson.fromJson(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get(TIMCommonConstants.MESSAGE_REPLIES_KEY);
                MessageRepliesBean messageRepliesBean = obj instanceof Map ? (MessageRepliesBean) gson.fromJson(gson.toJson(obj), MessageRepliesBean.class) : null;
                if (messageRepliesBean == null || messageRepliesBean.getVersion() > 1) {
                    return null;
                }
                return messageRepliesBean;
            }
        } catch (JsonSyntaxException unused) {
            TIMCommonLog.e(TAG, " getCustomJsonMap error ");
        }
        return null;
    }
}
