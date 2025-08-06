package pv;

import com.huochat.community.activity.TopicSearchTemplateActivity;
import com.huochat.community.widget.expandable.OnExpandableContractChangedListener;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class t implements OnExpandableContractChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TopicSearchTemplateActivity f53271a;

    public /* synthetic */ t(TopicSearchTemplateActivity topicSearchTemplateActivity) {
        this.f53271a = topicSearchTemplateActivity;
    }

    public final void onContractChanged(boolean z11, StatusType statusType) {
        TopicSearchTemplateActivity.mContractChangedListener$lambda$9(this.f53271a, z11, statusType);
    }
}
