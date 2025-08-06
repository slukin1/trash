package com.sumsub.sns.videoident.presentation;

import android.net.Uri;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "id", "", "uri", "Landroid/net/Uri;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$onCreate$2 extends Lambda implements p<String, Uri, Unit> {
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoIdentFragment$onCreate$2(SNSVideoIdentFragment sNSVideoIdentFragment) {
        super(2);
        this.this$0 = sNSVideoIdentFragment;
    }

    public final void invoke(String str, Uri uri) {
        this.this$0.handleFileSelectedForDocSetType(str, uri);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Uri) obj2);
        return Unit.f56620a;
    }
}
