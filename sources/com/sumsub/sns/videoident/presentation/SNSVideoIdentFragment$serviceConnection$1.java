package com.sumsub.sns.videoident.presentation;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.sumsub.sns.internal.videoident.presentation.SNSViewState;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.a;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController;
import com.sumsub.sns.videoident.service.SNSServiceBinder;
import com.sumsub.sns.videoident.service.SNSVideoChatService;
import com.twilio.video.VideoView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.x;
import tvi.webrtc.VideoSink;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"com/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$serviceConnection$1", "Landroid/content/ServiceConnection;", "connected", "", "getConnected", "()Z", "setConnected", "(Z)V", "<set-?>", "Lcom/sumsub/sns/videoident/service/SNSVideoChatService;", "service", "getService", "()Lcom/sumsub/sns/videoident/service/SNSVideoChatService;", "serviceReference", "Ljava/lang/ref/WeakReference;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$serviceConnection$1 implements ServiceConnection {
    private boolean connected;
    private SNSVideoChatService service;
    private WeakReference<SNSVideoChatService> serviceReference;
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    public SNSVideoIdentFragment$serviceConnection$1(SNSVideoIdentFragment sNSVideoIdentFragment) {
        this.this$0 = sNSVideoIdentFragment;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final SNSVideoChatService getService() {
        WeakReference<SNSVideoChatService> weakReference;
        if (this.connected && (weakReference = this.serviceReference) != null) {
            return weakReference.get();
        }
        return null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        SNSVideoChatController videoChatController;
        a.a(SNSVideoIdent.logTag, "onServiceConnected", (Throwable) null, 4, (Object) null);
        if (iBinder instanceof SNSServiceBinder) {
            SNSServiceBinder sNSServiceBinder = (SNSServiceBinder) iBinder;
            this.serviceReference = sNSServiceBinder.getService();
            SNSVideoChatService sNSVideoChatService = sNSServiceBinder.getService().get();
            if (sNSVideoChatService != null && (videoChatController = sNSVideoChatService.getVideoChatController()) != null) {
                SNSVideoIdentFragment sNSVideoIdentFragment = this.this$0;
                this.connected = true;
                a.a(SNSVideoIdent.logTag, "onServiceConnected: connected", (Throwable) null, 4, (Object) null);
                sNSVideoIdentFragment.attachChatControllerListeners(videoChatController);
                VideoView access$getLocalVideoView = sNSVideoIdentFragment.getLocalVideoView();
                if (access$getLocalVideoView != null) {
                    videoChatController.a(access$getLocalVideoView);
                    VideoView access$getLocalVideoView2 = sNSVideoIdentFragment.getLocalVideoView();
                    if (access$getLocalVideoView2 != null) {
                        videoChatController.a((VideoSink) access$getLocalVideoView2);
                        String access$getCurrentCameraId$p = sNSVideoIdentFragment.currentCameraId;
                        if (access$getCurrentCameraId$p != null) {
                            SNSVideoChatController.CameraId c11 = videoChatController.c();
                            if (!x.b(c11 != null ? c11.getValue() : null, access$getCurrentCameraId$p)) {
                                sNSVideoIdentFragment.switchCameraAndUpdateMirroring();
                            }
                            sNSVideoIdentFragment.currentCameraId = null;
                        }
                        sNSVideoIdentFragment.handleState((SNSViewState) sNSVideoIdentFragment.getViewModel().c(), (Bundle) null);
                        d10.a access$getStartServiceAndConnectToRoom$p = sNSVideoIdentFragment.startServiceAndConnectToRoom;
                        if (access$getStartServiceAndConnectToRoom$p != null) {
                            access$getStartServiceAndConnectToRoom$p.invoke();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        SNSVideoChatService sNSVideoChatService;
        a.a(SNSVideoIdent.logTag, "onServiceDisconnected", (Throwable) null, 4, (Object) null);
        this.connected = false;
        WeakReference<SNSVideoChatService> weakReference = this.serviceReference;
        if (!(weakReference == null || (sNSVideoChatService = weakReference.get()) == null)) {
            this.this$0.detachChatControllerListeners(sNSVideoChatService.getVideoChatController());
        }
        this.serviceReference = null;
    }

    public final void setConnected(boolean z11) {
        this.connected = z11;
    }
}
