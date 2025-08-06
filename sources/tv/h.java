package tv;

import com.huochat.community.viewholder.CommunityHolder;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class h implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60493a;

    public /* synthetic */ h(CommunityHolder communityHolder) {
        this.f60493a = communityHolder;
    }

    public final void onClick(StatusType statusType) {
        CommunityHolder.bindData$lambda$8$lambda$3(this.f60493a, statusType);
    }
}
