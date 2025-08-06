package com.huochat.community.network.domain;

import com.hbg.lib.network.hbg.core.bean.AppUrlInfo;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import i6.k;
import java.util.HashMap;
import java.util.List;

public final class CommunityDomainHelper$Companion$getGlobalCommunityWebUrls$1 extends RequestCallback1<AppUrlInfo> {
    public void onRequestSuccess(AppUrlInfo appUrlInfo) {
        HashMap<String, List<String>> huobichatWeb = appUrlInfo.getHuobichatWeb();
        CommunityDomainSelector.Companion.getInstance().setWebUrlDomains(huobichatWeb);
        k.o("community", "setWebUrlDomains_huobichatWeb - " + huobichatWeb);
    }
}
