package com.huochat.community.base;

import kotlin.jvm.internal.r;

public final class CommunitySensorsEvent {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final String communittTab = "k_line_community_tab";
    /* access modifiers changed from: private */
    public static final String communityClickTopicContent = "k_community_click_TopicContent";
    /* access modifiers changed from: private */
    public static final String communityClickTopicList = "k_community_click_TopicList";
    /* access modifiers changed from: private */
    public static final String communityDetail = "k_line_community_detail";
    /* access modifiers changed from: private */
    public static final String contractPageName = "1005015";
    /* access modifiers changed from: private */
    public static final String kLinePageName = "1005005";
    /* access modifiers changed from: private */
    public static final String openHuoxinAlert = "k_line_click_openHuoxinAlert";
    /* access modifiers changed from: private */
    public static final String openHuoxinButton = "k_line_click_openHuoxinButton";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final String getCommunittTab() {
            return CommunitySensorsEvent.communittTab;
        }

        public final String getCommunityClickTopicContent() {
            return CommunitySensorsEvent.communityClickTopicContent;
        }

        public final String getCommunityClickTopicList() {
            return CommunitySensorsEvent.communityClickTopicList;
        }

        public final String getCommunityDetail() {
            return CommunitySensorsEvent.communityDetail;
        }

        public final String getContractPageName() {
            return CommunitySensorsEvent.contractPageName;
        }

        public final String getKLinePageName() {
            return CommunitySensorsEvent.kLinePageName;
        }

        public final String getOpenHuoxinAlert() {
            return CommunitySensorsEvent.openHuoxinAlert;
        }

        public final String getOpenHuoxinButton() {
            return CommunitySensorsEvent.openHuoxinButton;
        }
    }
}
