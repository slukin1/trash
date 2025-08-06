package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.TopicInfo;
import java.io.Serializable;

public class V2TIMTopicInfoResult implements Serializable {
    private TopicInfo topicInfo = new TopicInfo();

    public int getErrorCode() {
        TopicInfo topicInfo2 = this.topicInfo;
        if (topicInfo2 == null) {
            return 0;
        }
        return topicInfo2.getErrorCode();
    }

    public String getErrorMessage() {
        TopicInfo topicInfo2 = this.topicInfo;
        if (topicInfo2 == null) {
            return "";
        }
        return topicInfo2.getErrorMessage();
    }

    public V2TIMTopicInfo getTopicInfo() {
        V2TIMTopicInfo v2TIMTopicInfo = new V2TIMTopicInfo();
        v2TIMTopicInfo.setTopicInfo(this.topicInfo);
        return v2TIMTopicInfo;
    }

    public void setTopicInfo(TopicInfo topicInfo2) {
        this.topicInfo = topicInfo2;
    }
}
