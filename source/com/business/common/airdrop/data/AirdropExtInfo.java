package com.business.common.airdrop.data;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.jvm.internal.x;

@Keep
public final class AirdropExtInfo {
    private final String groupId;
    private final List<String> topicIdList;
    private final String topicType;

    /* renamed from: ts  reason: collision with root package name */
    private final Long f64278ts;

    public AirdropExtInfo(String str, String str2, List<String> list, Long l11) {
        this.groupId = str;
        this.topicType = str2;
        this.topicIdList = list;
        this.f64278ts = l11;
    }

    public static /* synthetic */ AirdropExtInfo copy$default(AirdropExtInfo airdropExtInfo, String str, String str2, List<String> list, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = airdropExtInfo.groupId;
        }
        if ((i11 & 2) != 0) {
            str2 = airdropExtInfo.topicType;
        }
        if ((i11 & 4) != 0) {
            list = airdropExtInfo.topicIdList;
        }
        if ((i11 & 8) != 0) {
            l11 = airdropExtInfo.f64278ts;
        }
        return airdropExtInfo.copy(str, str2, list, l11);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.topicType;
    }

    public final List<String> component3() {
        return this.topicIdList;
    }

    public final Long component4() {
        return this.f64278ts;
    }

    public final AirdropExtInfo copy(String str, String str2, List<String> list, Long l11) {
        return new AirdropExtInfo(str, str2, list, l11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirdropExtInfo)) {
            return false;
        }
        AirdropExtInfo airdropExtInfo = (AirdropExtInfo) obj;
        return x.b(this.groupId, airdropExtInfo.groupId) && x.b(this.topicType, airdropExtInfo.topicType) && x.b(this.topicIdList, airdropExtInfo.topicIdList) && x.b(this.f64278ts, airdropExtInfo.f64278ts);
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
        return this.f64278ts;
    }

    public int hashCode() {
        String str = this.groupId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.topicType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.topicIdList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Long l11 = this.f64278ts;
        if (l11 != null) {
            i11 = l11.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "AirdropExtInfo(groupId=" + this.groupId + ", topicType=" + this.topicType + ", topicIdList=" + this.topicIdList + ", ts=" + this.f64278ts + ')';
    }
}
