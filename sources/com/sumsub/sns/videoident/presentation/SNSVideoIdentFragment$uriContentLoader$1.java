package com.sumsub.sns.videoident.presentation;

import android.net.Uri;
import com.sumsub.sns.internal.core.common.c1;
import com.sumsub.sns.internal.core.common.i;
import kotlin.Metadata;
import kotlin.coroutines.c;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"com/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$uriContentLoader$1", "Lcom/sumsub/sns/internal/core/common/c1;", "Landroid/net/Uri;", "uri", "", "copyContentsToCacheFile", "(Landroid/net/Uri;Lkotlin/coroutines/c;)Ljava/lang/Object;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSVideoIdentFragment$uriContentLoader$1 implements c1 {
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    public SNSVideoIdentFragment$uriContentLoader$1(SNSVideoIdentFragment sNSVideoIdentFragment) {
        this.this$0 = sNSVideoIdentFragment;
    }

    public Object copyContentsToCacheFile(Uri uri, c<? super String> cVar) {
        return i.b(uri, this.this$0.getContext(), cVar);
    }
}
