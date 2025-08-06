package com.tencent.qcloud.tuikit.tuichat.model;

import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.HashMap;

public class AIDenoiseSignatureManager {
    /* access modifiers changed from: private */
    public static final String TAG = "AIDenoiseSignatureManager";
    /* access modifiers changed from: private */
    public String aiDenoiseSignature = "";
    /* access modifiers changed from: private */
    public int expiredTime;

    public static class AIDenoiseSignatureManagerHolder {
        /* access modifiers changed from: private */
        public static final AIDenoiseSignatureManager aiDenoiseSignatureManager = new AIDenoiseSignatureManager();

        private AIDenoiseSignatureManagerHolder() {
        }
    }

    public static AIDenoiseSignatureManager getInstance() {
        return AIDenoiseSignatureManagerHolder.aiDenoiseSignatureManager;
    }

    public String getSignature() {
        updateSignature();
        return this.aiDenoiseSignature;
    }

    public void updateSignature() {
        if (System.currentTimeMillis() / 1000 >= ((long) this.expiredTime)) {
            V2TIMManager.getInstance().callExperimentalAPI("getAIDenoiseSignature", (Object) null, new V2TIMValueCallback<Object>() {
                public void onError(int i11, String str) {
                    String access$300 = AIDenoiseSignatureManager.TAG;
                    TUIChatLog.e(access$300, "getAIDenoiseSignature error, code:" + i11 + ", desc:" + str);
                }

                public void onSuccess(Object obj) {
                    if (obj != null && (obj instanceof HashMap)) {
                        HashMap hashMap = (HashMap) obj;
                        Object obj2 = hashMap.get(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE);
                        Object obj3 = hashMap.get("expired_time");
                        if (obj2 != null) {
                            String unused = AIDenoiseSignatureManager.this.aiDenoiseSignature = (String) obj2;
                        }
                        if (obj3 != null) {
                            int unused2 = AIDenoiseSignatureManager.this.expiredTime = Integer.parseInt((String) obj3);
                        }
                    }
                }
            });
        }
    }
}
