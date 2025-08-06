package com.tencent.qcloud.tuikit.tuicallengine;

import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class d implements TUICommonDefine.ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.ValueCallback f48319a;

    public d(a aVar, TUICommonDefine.ValueCallback valueCallback) {
        this.f48319a = valueCallback;
    }

    public void onError(int i11, String str) {
        TUICommonDefine.ValueCallback valueCallback = this.f48319a;
        if (valueCallback != null) {
            valueCallback.onError(i11, str);
        }
    }

    public void onSuccess(Object obj) {
        TUICallDefine.Status status;
        TUICommonDefine.ValueCallback valueCallback = this.f48319a;
        if (valueCallback != null) {
            if (!(obj instanceof List)) {
                int i11 = TUICallDefine.ERROR_PARAM_INVALID;
                valueCallback.onError(i11, "checkInviterUserStatus failed, data is not List, value is: " + obj);
                return;
            }
            List list = (List) obj;
            if (list == null || list.isEmpty()) {
                this.f48319a.onError(TUICallDefine.ERROR_PARAM_INVALID, "checkInviterUserStatus failed, userIdList is empty");
                return;
            }
            String str = null;
            Iterator it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    V2TIMUserStatus v2TIMUserStatus = (V2TIMUserStatus) it2.next();
                    if (v2TIMUserStatus != null && Objects.equals(V2TIMManager.getInstance().getLoginUser(), v2TIMUserStatus.getUserID())) {
                        str = v2TIMUserStatus.getCustomStatus();
                        break;
                    }
                } else {
                    break;
                }
            }
            if ("call_accept".equals(str)) {
                status = TUICallDefine.Status.Accept;
            } else if ("call_wait".equals(str)) {
                status = TUICallDefine.Status.Waiting;
            } else {
                status = TUICallDefine.Status.None;
            }
            this.f48319a.onSuccess(status);
        }
    }
}
