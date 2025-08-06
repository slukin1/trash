package com.huochat.community.fragment;

import d10.a;
import i6.i;
import kotlin.jvm.internal.Lambda;

public final class FragmentCommunityList$finishSkeletonRunnable$2 extends Lambda implements a<AnonymousClass1> {
    public final /* synthetic */ FragmentCommunityList this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentCommunityList$finishSkeletonRunnable$2(FragmentCommunityList fragmentCommunityList) {
        super(0);
        this.this$0 = fragmentCommunityList;
    }

    public final AnonymousClass1 invoke() {
        final FragmentCommunityList fragmentCommunityList = this.this$0;
        return new Runnable() {
            public void run() {
                i.b().h(this);
                fragmentCommunityList.finishSkeleton();
            }
        };
    }
}
