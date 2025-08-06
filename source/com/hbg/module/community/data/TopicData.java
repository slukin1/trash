package com.hbg.module.community.data;

import com.fluttercandies.photo_manager.core.entity.a;
import kotlin.jvm.internal.x;

public final class TopicData {
    private final long createdTime;
    private final int identification;
    private final int joinNums;
    private final int refined;
    private final String title;
    private final int topicId;

    public TopicData(long j11, int i11, int i12, int i13, String str, int i14) {
        this.createdTime = j11;
        this.identification = i11;
        this.joinNums = i12;
        this.refined = i13;
        this.title = str;
        this.topicId = i14;
    }

    public static /* synthetic */ TopicData copy$default(TopicData topicData, long j11, int i11, int i12, int i13, String str, int i14, int i15, Object obj) {
        TopicData topicData2 = topicData;
        return topicData.copy((i15 & 1) != 0 ? topicData2.createdTime : j11, (i15 & 2) != 0 ? topicData2.identification : i11, (i15 & 4) != 0 ? topicData2.joinNums : i12, (i15 & 8) != 0 ? topicData2.refined : i13, (i15 & 16) != 0 ? topicData2.title : str, (i15 & 32) != 0 ? topicData2.topicId : i14);
    }

    public final long component1() {
        return this.createdTime;
    }

    public final int component2() {
        return this.identification;
    }

    public final int component3() {
        return this.joinNums;
    }

    public final int component4() {
        return this.refined;
    }

    public final String component5() {
        return this.title;
    }

    public final int component6() {
        return this.topicId;
    }

    public final TopicData copy(long j11, int i11, int i12, int i13, String str, int i14) {
        return new TopicData(j11, i11, i12, i13, str, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopicData)) {
            return false;
        }
        TopicData topicData = (TopicData) obj;
        return this.createdTime == topicData.createdTime && this.identification == topicData.identification && this.joinNums == topicData.joinNums && this.refined == topicData.refined && x.b(this.title, topicData.title) && this.topicId == topicData.topicId;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final int getIdentification() {
        return this.identification;
    }

    public final int getJoinNums() {
        return this.joinNums;
    }

    public final int getRefined() {
        return this.refined;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        return (((((((((a.a(this.createdTime) * 31) + this.identification) * 31) + this.joinNums) * 31) + this.refined) * 31) + this.title.hashCode()) * 31) + this.topicId;
    }

    public String toString() {
        return "TopicData(createdTime=" + this.createdTime + ", identification=" + this.identification + ", joinNums=" + this.joinNums + ", refined=" + this.refined + ", title=" + this.title + ", topicId=" + this.topicId + ')';
    }
}
