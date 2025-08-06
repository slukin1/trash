package qv;

import com.huochat.community.adapter.CommunityAdapter;
import com.huochat.community.model.CommunityTopBean;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityAdapter f70492b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityTopBean f70493c;

    public /* synthetic */ a(CommunityAdapter communityAdapter, CommunityTopBean communityTopBean) {
        this.f70492b = communityAdapter;
        this.f70493c = communityTopBean;
    }

    public final void run() {
        CommunityAdapter.refreshTopHotTopicList$lambda$7$lambda$6(this.f70492b, this.f70493c);
    }
}
