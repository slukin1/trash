package com.business.common.airdrop.data;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropChannelBean {
    private final AirdropBusinessId businessID;
    private final String groupId;
    private final List<String> topicIdList;
    private final String topicType;

    /* renamed from: ts  reason: collision with root package name */
    private final Long f64276ts;

    public AirdropChannelBean(AirdropBusinessId airdropBusinessId, String str, String str2, List<String> list, Long l11) {
        this.businessID = airdropBusinessId;
        this.groupId = str;
        this.topicType = str2;
        this.topicIdList = list;
        this.f64276ts = l11;
    }

    public static /* synthetic */ AirdropChannelBean copy$default(AirdropChannelBean airdropChannelBean, AirdropBusinessId airdropBusinessId, String str, String str2, List<String> list, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            airdropBusinessId = airdropChannelBean.businessID;
        }
        if ((i11 & 2) != 0) {
            str = airdropChannelBean.groupId;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            str2 = airdropChannelBean.topicType;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            list = airdropChannelBean.topicIdList;
        }
        List<String> list2 = list;
        if ((i11 & 16) != 0) {
            l11 = airdropChannelBean.f64276ts;
        }
        return airdropChannelBean.copy(airdropBusinessId, str3, str4, list2, l11);
    }

    public final AirdropBusinessId component1() {
        return this.businessID;
    }

    public final String component2() {
        return this.groupId;
    }

    public final String component3() {
        return this.topicType;
    }

    public final List<String> component4() {
        return this.topicIdList;
    }

    public final Long component5() {
        return this.f64276ts;
    }

    public final AirdropChannelBean copy(AirdropBusinessId airdropBusinessId, String str, String str2, List<String> list, Long l11) {
        return new AirdropChannelBean(airdropBusinessId, str, str2, list, l11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropChannelBean)) {
            return false;
        }
        AirdropChannelBean airdropChannelBean = (AirdropChannelBean) obj;
        return this.businessID == airdropChannelBean.businessID && x.b(this.groupId, airdropChannelBean.groupId) && x.b(this.topicType, airdropChannelBean.topicType) && x.b(this.topicIdList, airdropChannelBean.topicIdList) && x.b(this.f64276ts, airdropChannelBean.f64276ts);
    }

    public final AirdropBusinessId getBusinessID() {
        return this.businessID;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final List<String> getTopicIdList() {
        return this.topicIdList;
    }

    public final String getTopicType() {
        return this.topicType;
    }

    public final Long getTs() {
        return this.f64276ts;
    }

    public int hashCode() {
        int hashCode = this.businessID.hashCode() * 31;
        String str = this.groupId;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.topicType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.topicIdList;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Long l11 = this.f64276ts;
        if (l11 != null) {
            i11 = l11.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        return "AirdropChannelBean(businessID=" + this.businessID + ", groupId=" + this.groupId + ", topicType=" + this.topicType + ", topicIdList=" + this.topicIdList + ", ts=" + this.f64276ts + ')';
    }
}
