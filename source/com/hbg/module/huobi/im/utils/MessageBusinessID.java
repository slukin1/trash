package com.hbg.module.huobi.im.utils;

public enum MessageBusinessID {
    MSG_BUSINESS_ID_LIVE_LIKE("huobi_live_like"),
    MSG_BUSINESS_ID_LIVE_MSG_DEL("huobi_msg_recall"),
    MSG_BUSINESS_ID_LIVE_KICK("huobi_group_member_remove"),
    MSG_BUSINESS_ID_NOTIFICATION("huobi_group_notification"),
    MSG_BUSINESS_ID_GIFT("huobi_live_gift"),
    MSG_BUSINESS_ID_GIFT_END("huobi_live_gift_end"),
    MSG_BUSINESS_ID_GIFT_VERIFY("huobi_live_gift_verify"),
    MSG_BUSINESS_ID_GIFT_DRAW("huobi_live_gift_draw"),
    MSG_BUSINESS_ID_DELETE_USER_MESSAGE("huobi_im_recall_msg"),
    MSG_BUSINESS_ID_HUOBI_LIVE_IN("huobi_live_in"),
    MSG_BUSINESS_ID_HUOBI_LIVE_FINISH("huobi_live_finish"),
    MSG_BUSINESS_ID_HUOBI_GROUP_BUSINESS_SHARE("huobi_group_business_share"),
    MSG_BUSINESS_ID_HUOBI_GROUP_BUSINESS_SHARE_TEXT("huobi_group_business_share_text"),
    MSG_BUSINESS_ID_HUOBI_LIVE_NOTICE("huobi_live_notification"),
    MSG_BUSINESS_ID_HUOBI_LIVE_NOTICE_RECALL("huobi_live_notification_recall"),
    MSG_BUSINESS_ID_HUOBI_ACCOUNT_MANAGER_UNREAD("huobi_live_timeout_unread"),
    MSG_BUSINESS_ID_HUOBI_PRIME_BOX("huobi_live_prime_box"),
    MSG_BUSINESS_ID_HUOBI_PRIME_BOX_NEW("huobi_live_prime_box_new"),
    MSG_BUSINESS_ID_HUOBI_ACTIVITY_GIFT_LAB("huobi_activity_gift_lab"),
    MSG_BUSINESS_ID_HUOBI_LIVE_INTEGRAL_CHANGE("huobi_live_integral_change"),
    MSG_BUSINESS_ID_HUOBI_LIVE_GIFT_REWARD_CHANGE("huobi_live_gift_reward_change"),
    MSG_BUSINESS_ID_HUOBI_LIVE_ACTIVITY_CHANGE("huobi_live_activity_change"),
    MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_SEND("huobi_live_red_packet_send"),
    MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_SNATCH("huobi_live_red_packet_snatch"),
    MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_THANK("huobi_live_red_packet_thank"),
    MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_CLOSE("huobi_live_red_packet_close"),
    MSG_BUSINESS_ID_HUOBI_LIVE_TRADER_RECOMMEND("huobi_live_trader_recommend"),
    MSG_BUSINESS_ID_HUOBI_LIVE_TRADER_RECOMMEND_CANCEL("huobi_live_trader_recommend_cancel");
    
    private final String value;

    private MessageBusinessID(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
