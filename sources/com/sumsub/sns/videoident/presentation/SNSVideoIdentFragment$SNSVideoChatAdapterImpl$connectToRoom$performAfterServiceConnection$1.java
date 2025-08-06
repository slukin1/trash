package com.sumsub.sns.videoident.presentation;

import d10.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$SNSVideoChatAdapterImpl$connectToRoom$performAfterServiceConnection$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ String $accessToken;
    public final /* synthetic */ String $roomName;
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$SNSVideoChatAdapterImpl$connectToRoom$performAfterServiceConnection$1(SNSVideoIdentFragment sNSVideoIdentFragment, String str, String str2) {
        super(0);
        this.this$0 = sNSVideoIdentFragment;
        this.$accessToken = str;
        this.$roomName = str2;
    }

    public final void invoke() {
        this.this$0.startServiceAndConnectToRoom = null;
        this.this$0.doStartServiceAndConnectToRoom(this.$accessToken, this.$roomName);
    }
}
