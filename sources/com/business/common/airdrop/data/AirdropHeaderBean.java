package com.business.common.airdrop.data;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropHeaderBean {
    private final String groupId;
    private final Integer hasAirdrop;
    private final String topicId;
    private final String topicType;

    public AirdropHeaderBean(String str, String str2, String str3, Integer num) {
        this.groupId = str;
        this.topicType = str2;
        this.topicId = str3;
        this.hasAirdrop = num;
    }

    public static /* synthetic */ AirdropHeaderBean copy$default(AirdropHeaderBean airdropHeaderBean, String str, String str2, String str3, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = airdropHeaderBean.groupId;
        }
        if ((i11 & 2) != 0) {
            str2 = airdropHeaderBean.topicType;
        }
        if ((i11 & 4) != 0) {
            str3 = airdropHeaderBean.topicId;
        }
        if ((i11 & 8) != 0) {
            num = airdropHeaderBean.hasAirdrop;
        }
        return airdropHeaderBean.copy(str, str2, str3, num);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.topicType;
    }

    public final String component3() {
        return this.topicId;
    }

    public final Integer component4() {
        return this.hasAirdrop;
    }

    public final AirdropHeaderBean copy(String str, String str2, String str3, Integer num) {
        return new AirdropHeaderBean(str, str2, str3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropHeaderBean)) {
            return false;
        }
        AirdropHeaderBean airdropHeaderBean = (AirdropHeaderBean) obj;
        return x.b(this.groupId, airdropHeaderBean.groupId) && x.b(this.topicType, airdropHeaderBean.topicType) && x.b(this.topicId, airdropHeaderBean.topicId) && x.b(this.hasAirdrop, airdropHeaderBean.hasAirdrop);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final Integer getHasAirdrop() {
        return this.hasAirdrop;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final String getTopicType() {
        return this.topicType;
    }

    public int hashCode() {
        String str = this.groupId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.topicType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.topicId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.hasAirdrop;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "AirdropHeaderBean(groupId=" + this.groupId + ", topicType=" + this.topicType + ", topicId=" + this.topicId + ", hasAirdrop=" + this.hasAirdrop + ')';
    }
}
