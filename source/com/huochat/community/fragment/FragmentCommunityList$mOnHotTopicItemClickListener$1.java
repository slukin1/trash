package com.huochat.community.fragment;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.router.HbgRouter;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.base.CommunityRouterConfig;
import com.huochat.community.base.CommunitySensorsEvent;
import com.huochat.community.model.TopicBean;
import com.huochat.community.util.ClickTool;
import com.huochat.community.widget.HotTopicTagFlowView;
import java.util.HashMap;
import kotlin.Unit;

public final class FragmentCommunityList$mOnHotTopicItemClickListener$1 implements HotTopicTagFlowView.OnItemClickListener {
    public final /* synthetic */ FragmentCommunityList this$0;

    public FragmentCommunityList$mOnHotTopicItemClickListener$1(FragmentCommunityList fragmentCommunityList) {
        this.this$0 = fragmentCommunityList;
    }

    public FragmentActivity getParentActivity() {
        return this.this$0.getActivity();
    }

    public void onItemClick(TopicBean topicBean) {
        if (this.this$0.getActivity() != null && !this.this$0.getActivity().isFinishing() && ClickTool.isRealClick() && topicBean != null) {
            FragmentCommunityList fragmentCommunityList = this.this$0;
            Bundle bundle = new Bundle();
            bundle.putString(CommunityConstants.TOPIC_ID, String.valueOf(topicBean.getId()));
            bundle.putString(CommunityConstants.TOPIC_NAME, topicBean.getTopicName());
            HbgRouter.i(fragmentCommunityList.getActivity(), CommunityRouterConfig.ACTIVITY_COMMUNITY_TOPIC_SEARCH_TEMPLATE, bundle);
            CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
            if (moduleCallback != null) {
                String communityClickTopicList = CommunitySensorsEvent.Companion.getCommunityClickTopicList();
                HashMap hashMap = new HashMap();
                hashMap.put("symbol", fragmentCommunityList.mSymbolId);
                Unit unit = Unit.f56620a;
                moduleCallback.track(communityClickTopicList, hashMap);
            }
        }
    }
}
