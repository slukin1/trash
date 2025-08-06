package pv;

import com.google.android.material.appbar.AppBarLayout;
import com.huochat.community.activity.TopicSearchTemplateActivity;

public final /* synthetic */ class s implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TopicSearchTemplateActivity f53270b;

    public /* synthetic */ s(TopicSearchTemplateActivity topicSearchTemplateActivity) {
        this.f53270b = topicSearchTemplateActivity;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        TopicSearchTemplateActivity.mOnOffsetChangedListener$lambda$8(this.f53270b, appBarLayout, i11);
    }
}
