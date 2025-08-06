package com.sumsub.sns.videoident.presentation;

import android.content.Intent;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.a;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState;
import com.sumsub.sns.videoident.service.SNSVideoChatService;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment$attachChatControllerListeners$2", f = "SNSVideoIdentFragment.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SNSVideoIdentFragment$attachChatControllerListeners$2 extends SuspendLambda implements p<SNSVideoChatState, c<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$attachChatControllerListeners$2(SNSVideoIdentFragment sNSVideoIdentFragment, c<? super SNSVideoIdentFragment$attachChatControllerListeners$2> cVar) {
        super(2, cVar);
        this.this$0 = sNSVideoIdentFragment;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SNSVideoIdentFragment$attachChatControllerListeners$2 sNSVideoIdentFragment$attachChatControllerListeners$2 = new SNSVideoIdentFragment$attachChatControllerListeners$2(this.this$0, cVar);
        sNSVideoIdentFragment$attachChatControllerListeners$2.L$0 = obj;
        return sNSVideoIdentFragment$attachChatControllerListeners$2;
    }

    public final Object invoke(SNSVideoChatState sNSVideoChatState, c<? super Unit> cVar) {
        return ((SNSVideoIdentFragment$attachChatControllerListeners$2) create(sNSVideoChatState, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        SNSVideoChatService service;
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            SNSVideoChatState sNSVideoChatState = (SNSVideoChatState) this.L$0;
            if (sNSVideoChatState instanceof SNSVideoChatState.c) {
                if (this.this$0.serviceConnection.getConnected()) {
                    a.a(SNSVideoIdent.logTag, "exiting foreground", (Throwable) null, 4, (Object) null);
                    SNSVideoChatService service2 = this.this$0.serviceConnection.getService();
                    if ((service2 != null && service2.isInForeground()) && (service = this.this$0.serviceConnection.getService()) != null) {
                        service.stopForeground(true);
                    }
                    this.this$0.requireActivity().stopService(new Intent(this.this$0.requireContext(), SNSVideoChatService.class));
                } else {
                    com.sumsub.log.logger.a.b(com.sumsub.sns.internal.log.a.f34862a, a.f36980b, "SNSDisconnected but service is NOT connected", (Throwable) null, 4, (Object) null);
                }
            }
            this.this$0.getViewModel().a(sNSVideoChatState);
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
