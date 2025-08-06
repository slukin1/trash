package com.huochat.community.network.domain;

import com.huochat.community.CommunityManager;
import com.huochat.community.network.domain.CommunityDomainSelector;

public final class CommunityDomainSelector$setWebUrlDomains$1 implements CommunityDomainSelector.OnDomainResolutionCallback {
    public void callback(String str) {
        if (!(str == null || str.length() == 0)) {
            CommunityManager.Companion.getInstance().setBaseWebSiteUrl(str);
            CommunityDomainSPTool.Companion.saveCommunityWebUrlDomain(str);
        }
    }
}
