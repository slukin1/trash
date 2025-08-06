package com.sumsub.sns.videoident.presentation;

import androidx.lifecycle.ViewModelProvider;
import com.sumsub.sns.internal.videoident.presentation.i;
import d10.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$viewModel$2 extends Lambda implements a<ViewModelProvider.Factory> {
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$viewModel$2(SNSVideoIdentFragment sNSVideoIdentFragment) {
        super(0);
        this.this$0 = sNSVideoIdentFragment;
    }

    public final ViewModelProvider.Factory invoke() {
        List access$getDocuments = this.this$0.getDocuments();
        SNSVideoIdentFragment sNSVideoIdentFragment = this.this$0;
        return new i(access$getDocuments, sNSVideoIdentFragment, sNSVideoIdentFragment.getServiceLocator(), this.this$0.getArguments(), this.this$0.videoChatAdapter, this.this$0.uriContentLoader);
    }
}
