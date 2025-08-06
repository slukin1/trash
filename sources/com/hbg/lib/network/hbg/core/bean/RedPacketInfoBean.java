package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class RedPacketInfoBean {
    private final String codeWord;
    private final String redCollectDetailUrl;
    private final String userNick;
    private final String wholeUrl;
    private final String wishWord;

    public RedPacketInfoBean(String str, String str2, String str3, String str4, String str5) {
        this.wishWord = str;
        this.userNick = str2;
        this.wholeUrl = str3;
        this.codeWord = str4;
        this.redCollectDetailUrl = str5;
    }

    public static /* synthetic */ RedPacketInfoBean copy$default(RedPacketInfoBean redPacketInfoBean, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = redPacketInfoBean.wishWord;
        }
        if ((i11 & 2) != 0) {
            str2 = redPacketInfoBean.userNick;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = redPacketInfoBean.wholeUrl;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = redPacketInfoBean.codeWord;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = redPacketInfoBean.redCollectDetailUrl;
        }
        return redPacketInfoBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.wishWord;
    }

    public final String component2() {
        return this.userNick;
    }

    public final String component3() {
        return this.wholeUrl;
    }

    public final String component4() {
        return this.codeWord;
    }

    public final String component5() {
        return this.redCollectDetailUrl;
    }

    public final RedPacketInfoBean copy(String str, String str2, String str3, String str4, String str5) {
        return new RedPacketInfoBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedPacketInfoBean)) {
            return false;
        }
        RedPacketInfoBean redPacketInfoBean = (RedPacketInfoBean) obj;
        return x.b(this.wishWord, redPacketInfoBean.wishWord) && x.b(this.userNick, redPacketInfoBean.userNick) && x.b(this.wholeUrl, redPacketInfoBean.wholeUrl) && x.b(this.codeWord, redPacketInfoBean.codeWord) && x.b(this.redCollectDetailUrl, redPacketInfoBean.redCollectDetailUrl);
    }

    public final String getCodeWord() {
        return this.codeWord;
    }

    public final String getRedCollectDetailUrl() {
        return this.redCollectDetailUrl;
    }

    public final String getUserNick() {
        return this.userNick;
    }

    public final String getWholeUrl() {
        return this.wholeUrl;
    }

    public final String getWishWord() {
        return this.wishWord;
    }

    public int hashCode() {
        String str = this.wishWord;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userNick;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.wholeUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.codeWord;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.redCollectDetailUrl;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        return "RedPacketInfoBean(wishWord=" + this.wishWord + ", userNick=" + this.userNick + ", wholeUrl=" + this.wholeUrl + ", codeWord=" + this.codeWord + ", redCollectDetailUrl=" + this.redCollectDetailUrl + ')';
    }
}
