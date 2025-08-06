package com.sumsub.sns.videoident.service;

import android.os.Binder;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/videoident/service/SNSServiceBinder;", "Landroid/os/Binder;", "instance", "Lcom/sumsub/sns/videoident/service/SNSVideoChatService;", "(Lcom/sumsub/sns/videoident/service/SNSVideoChatService;)V", "service", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getService", "()Ljava/lang/ref/WeakReference;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSServiceBinder extends Binder {
    private final WeakReference<SNSVideoChatService> service;

    public SNSServiceBinder(SNSVideoChatService sNSVideoChatService) {
        this.service = new WeakReference<>(sNSVideoChatService);
    }

    public final WeakReference<SNSVideoChatService> getService() {
        return this.service;
    }
}
