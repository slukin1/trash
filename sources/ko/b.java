package ko;

import com.huobi.message.ui.GroupChatListFragment;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroupChatListFragment f56596b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f56597c;

    public /* synthetic */ b(GroupChatListFragment groupChatListFragment, boolean z11) {
        this.f56596b = groupChatListFragment;
        this.f56597c = z11;
    }

    public final void run() {
        GroupChatListFragment.Jh(this.f56596b, this.f56597c);
    }
}
