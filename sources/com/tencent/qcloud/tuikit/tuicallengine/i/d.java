package com.tencent.qcloud.tuikit.tuicallengine.i;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.f.j;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import java.util.List;

public class d implements TUICommonDefine.ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f48502a;

    public d(c cVar) {
        this.f48502a = cVar;
    }

    public void onError(int i11, String str) {
    }

    public void onSuccess(Object obj) {
        j jVar;
        if (!(obj instanceof List)) {
            TUILog.w("V4MultiCalling", "checkAddUserIDsStatus failed, data is not List, value is: " + obj);
            return;
        }
        for (V2TIMUserStatus v2TIMUserStatus : (List) obj) {
            String customStatus = v2TIMUserStatus.getCustomStatus();
            if (!TextUtils.isEmpty(v2TIMUserStatus.getUserID()) && !"call_accept".equals(customStatus) && !"call_wait".equals(customStatus) && (jVar = this.f48502a.f48470b) != null) {
                jVar.c(v2TIMUserStatus.getUserID());
            }
        }
    }
}
