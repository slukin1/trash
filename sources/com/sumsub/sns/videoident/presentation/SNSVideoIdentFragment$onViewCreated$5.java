package com.sumsub.sns.videoident.presentation;

import com.sumsub.sns.internal.core.android.a;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$onViewCreated$5 extends Lambda implements l<String, Unit> {
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$onViewCreated$5(SNSVideoIdentFragment sNSVideoIdentFragment) {
        super(1);
        this.this$0 = sNSVideoIdentFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.f56620a;
    }

    public final void invoke(String str) {
        a access$getPickerLifecycleObserver$p = this.this$0.pickerLifecycleObserver;
        if (access$getPickerLifecycleObserver$p == null) {
            access$getPickerLifecycleObserver$p = null;
        }
        access$getPickerLifecycleObserver$p.a(str);
    }
}
