package com.huochat.community;

import android.content.Context;
import android.view.View;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huochat.community.enums.CommunityAnalyticsPageEnum;
import com.huochat.community.listener.ICommunityShareUI;
import java.util.HashMap;
import java.util.Map;

public interface CommunityModuleCallback {
    void hbgAnalyticsClickData(String str, String str2);

    void hbgAnalyticsUtilReportClickData(String str, Map<String, ? extends Object> map, CommunityAnalyticsPageEnum communityAnalyticsPageEnum);

    void newTrack(String str, HashMap<Object, Object> hashMap);

    BaseDialogFragment shareCommunityDynamic(ICommunityShareUI iCommunityShareUI, BaseDialogFragment baseDialogFragment, View view);

    void showDisclaimer(Context context);

    void track(String str, HashMap<String, Object> hashMap);
}
