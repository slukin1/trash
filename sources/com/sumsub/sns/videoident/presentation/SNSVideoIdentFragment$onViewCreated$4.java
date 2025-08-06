package com.sumsub.sns.videoident.presentation;

import android.content.Intent;
import com.sumsub.sns.core.presentation.b;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.videoident.service.SNSVideoChatService;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isCompleted", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$onViewCreated$4 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$onViewCreated$4(SNSVideoIdentFragment sNSVideoIdentFragment) {
        super(1);
        this.this$0 = sNSVideoIdentFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.f56620a;
    }

    public final void invoke(boolean z11) {
        Intent intent = new Intent(SNSVideoChatService.ACTION_INTERNAL_CLOSE);
        SNSVideoIdentFragment sNSVideoIdentFragment = this.this$0;
        intent.setPackage(sNSVideoIdentFragment.requireContext().getPackageName());
        sNSVideoIdentFragment.requireContext().sendBroadcast(intent);
        if (z11) {
            b.finish$default(this.this$0, new q.b(false), (Object) null, (Long) null, 6, (Object) null);
        } else {
            b.finish$default(this.this$0, q.a.f32249b, (Object) null, (Long) null, 6, (Object) null);
        }
    }
}
