package tv;

import com.huochat.community.viewholder.CommunityHolder;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.LinkType;
import kotlin.jvm.internal.Ref$BooleanRef;

public final /* synthetic */ class i implements ExpandableTextView.OnLinkClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f60494a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60495b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60496c;

    public /* synthetic */ i(Ref$BooleanRef ref$BooleanRef, CommunityHolder communityHolder, String str) {
        this.f60494a = ref$BooleanRef;
        this.f60495b = communityHolder;
        this.f60496c = str;
    }

    public final void onLinkClickListener(LinkType linkType, String str, String str2) {
        CommunityHolder.bindData$lambda$8$lambda$6(this.f60494a, this.f60495b, this.f60496c, linkType, str, str2);
    }
}
