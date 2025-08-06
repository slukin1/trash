package com.huochat.community.network.domain;

import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import kotlin.jvm.internal.r;

public final class CommunityDomainSPTool {
    private static final String COMMUNITY_API_URL_KEY = "community_api_domain_config_key";
    private static final String COMMUNITY_WEB_URL_KEY = "community_weburl_domain_config_key";
    public static final Companion Companion = new Companion((r) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private final String getCommunityDomainSPKey(String str) {
            String str2 = !SystemUtils.c() ? "DEBUG_" : "RELEASE_";
            return str2 + str;
        }

        public final String getCommunityApiDomain() {
            return ConfigPreferences.e("user_config", getCommunityDomainSPKey(CommunityDomainSPTool.COMMUNITY_API_URL_KEY), "");
        }

        public final String getCommunityWebUrlDomain() {
            return ConfigPreferences.e("user_config", getCommunityDomainSPKey(CommunityDomainSPTool.COMMUNITY_WEB_URL_KEY), "");
        }

        public final void saveCommunityApiDomain(String str) {
            ConfigPreferences.m("user_config", getCommunityDomainSPKey(CommunityDomainSPTool.COMMUNITY_API_URL_KEY), str);
        }

        public final void saveCommunityWebUrlDomain(String str) {
            ConfigPreferences.m("user_config", getCommunityDomainSPKey(CommunityDomainSPTool.COMMUNITY_WEB_URL_KEY), str);
        }
    }
}
