package com.tencent.qcloud.tuikit.tuicallengine.h;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f48468a;

    public g(Context context) {
        this.f48468a = context;
    }

    public static TUICallDefine.CallRecords a(g gVar, JSONObject jSONObject) {
        gVar.getClass();
        TUICallDefine.CallRecords callRecords = new TUICallDefine.CallRecords();
        try {
            callRecords.callId = jSONObject.getString(AnalyticsEvents.PARAMETER_CALL_ID);
            callRecords.inviter = jSONObject.getString("inviter");
            callRecords.groupId = jSONObject.getString("group_id");
            List<String> asList = Arrays.asList(jSONObject.getString("remote_user_list").trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP));
            if (callRecords.inviteList == null) {
                callRecords.inviteList = new ArrayList();
            }
            for (String str : asList) {
                if (!TextUtils.isEmpty(str)) {
                    callRecords.inviteList.add(str.trim());
                }
            }
            callRecords.role = TUICallDefine.Role.valueOf(jSONObject.getString("role"));
            callRecords.mediaType = TUICallDefine.MediaType.valueOf(jSONObject.getString(MessengerShareContentUtility.MEDIA_TYPE));
            callRecords.scene = TUICallDefine.Scene.valueOf(jSONObject.getString("call_scene").toUpperCase());
            callRecords.result = TUICallDefine.CallRecords.Result.values()[jSONObject.getInt("status")];
            callRecords.beginTime = Long.parseLong(jSONObject.getString("begin_time"));
            callRecords.totalTime = Long.parseLong(jSONObject.getString("total_time"));
            return callRecords;
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }
}
