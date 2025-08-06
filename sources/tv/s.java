package tv;

import android.view.View;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.viewholder.CommunityHolder;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60513b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityItemBean f60514c;

    public /* synthetic */ s(CommunityHolder communityHolder, CommunityItemBean communityItemBean) {
        this.f60513b = communityHolder;
        this.f60514c = communityItemBean;
    }

    public final void onClick(View view) {
        CommunityHolder.bindData$lambda$14(this.f60513b, this.f60514c, view);
    }
}
