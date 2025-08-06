package com.sumsub.sns.videoident.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.a;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/sumsub/sns/videoident/service/SNSVideoChatService$registerDismissReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoChatService$registerDismissReceiver$1 extends BroadcastReceiver {
    public final /* synthetic */ SNSVideoChatService this$0;

    public SNSVideoChatService$registerDismissReceiver$1(SNSVideoChatService sNSVideoChatService) {
        this.this$0 = sNSVideoChatService;
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        StringBuilder sb2 = new StringBuilder();
        String str = null;
        sb2.append(intent != null ? intent.getAction() : null);
        sb2.append(" received. Finishing...");
        a.a(SNSVideoIdent.logTag, sb2.toString(), (Throwable) null, 4, (Object) null);
        if (!x.b(intent != null ? intent.getAction() : null, n0.f.f32173d)) {
            if (intent != null) {
                str = intent.getAction();
            }
            if (!x.b(str, SNSVideoChatService.ACTION_INTERNAL_CLOSE)) {
                return;
            }
        }
        this.this$0.stopCallAndService();
    }
}
