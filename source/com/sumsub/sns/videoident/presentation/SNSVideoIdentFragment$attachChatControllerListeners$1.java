package com.sumsub.sns.videoident.presentation;

import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.a;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h0;

@d(c = "com.sumsub.sns.videoident.presentation.SNSVideoIdentFragment$attachChatControllerListeners$1", f = "SNSVideoIdentFragment.kt", l = {687}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SNSVideoIdentFragment$attachChatControllerListeners$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ SNSVideoChatController $videoChatController;
    public int label;
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$attachChatControllerListeners$1(SNSVideoChatController sNSVideoChatController, SNSVideoIdentFragment sNSVideoIdentFragment, c<? super SNSVideoIdentFragment$attachChatControllerListeners$1> cVar) {
        super(2, cVar);
        this.$videoChatController = sNSVideoChatController;
        this.this$0 = sNSVideoIdentFragment;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SNSVideoIdentFragment$attachChatControllerListeners$1(this.$videoChatController, this.this$0, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            kotlinx.coroutines.flow.d<String> d12 = this.$videoChatController.d();
            final SNSVideoIdentFragment sNSVideoIdentFragment = this.this$0;
            AnonymousClass1 r12 = new e() {
                public final Object emit(String str, c<? super Unit> cVar) {
                    a.a(SNSVideoIdent.logTag, "message: " + str, (Throwable) null, 4, (Object) null);
                    Object b11 = sNSVideoIdentFragment.getViewModel().b(str, cVar);
                    return b11 == IntrinsicsKt__IntrinsicsKt.d() ? b11 : Unit.f56620a;
                }
            };
            this.label = 1;
            if (d12.collect(r12, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((SNSVideoIdentFragment$attachChatControllerListeners$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }
}
