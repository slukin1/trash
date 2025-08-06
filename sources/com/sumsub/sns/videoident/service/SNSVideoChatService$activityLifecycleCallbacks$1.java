package com.sumsub.sns.videoident.service;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState;
import kotlin.Metadata;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.p;
import kotlinx.serialization.h;
import kotlinx.serialization.modules.d;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/sumsub/sns/videoident/service/SNSVideoChatService$activityLifecycleCallbacks$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoChatService$activityLifecycleCallbacks$1 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ SNSVideoChatService this$0;

    public SNSVideoChatService$activityLifecycleCallbacks$1(SNSVideoChatService sNSVideoChatService) {
        this.this$0 = sNSVideoChatService;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (activity instanceof k0) {
            a access$getServiceLocator = this.this$0.getServiceLocator();
            if (access$getServiceLocator != null) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onActivityStarted: chatState=" + this.this$0.getVideoChatController().l().getValue(), (Throwable) null, 4, (Object) null);
                if (this.this$0.getVideoChatController().l().getValue() instanceof SNSVideoChatState.d) {
                    SNSVideoChatController videoChatController = this.this$0.getVideoChatController();
                    kotlinx.serialization.json.a t11 = access$getServiceLocator.t();
                    SNSMessage.ClientMessage.UserVisibilityState b11 = SNSMessage.ClientMessage.UserVisibilityState.Companion.b();
                    d a11 = t11.a();
                    p n11 = Reflection.n(SNSMessage.ClientMessage.UserVisibilityState.class);
                    MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                    videoChatController.a(t11.b(h.d(a11, n11), b11));
                }
            } else if (this.this$0.isInForeground()) {
                com.sumsub.log.logger.a.b(com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA), SNSVideoIdent.logTag, "can't get service locator instance", (Throwable) null, 4, (Object) null);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        if (activity instanceof k0) {
            a access$getServiceLocator = this.this$0.getServiceLocator();
            if (access$getServiceLocator != null) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onActivityStopped: chatState=" + this.this$0.getVideoChatController().l().getValue(), (Throwable) null, 4, (Object) null);
                if (this.this$0.getVideoChatController().l().getValue() instanceof SNSVideoChatState.d) {
                    SNSVideoChatController videoChatController = this.this$0.getVideoChatController();
                    kotlinx.serialization.json.a t11 = access$getServiceLocator.t();
                    SNSMessage.ClientMessage.UserVisibilityState a11 = SNSMessage.ClientMessage.UserVisibilityState.Companion.a();
                    d a12 = t11.a();
                    p n11 = Reflection.n(SNSMessage.ClientMessage.UserVisibilityState.class);
                    MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                    videoChatController.a(t11.b(h.d(a12, n11), a11));
                }
            } else if (this.this$0.isInForeground()) {
                com.sumsub.log.logger.a.b(com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA), SNSVideoIdent.logTag, "can't get service locator instance", (Throwable) null, 4, (Object) null);
            }
        }
    }
}
