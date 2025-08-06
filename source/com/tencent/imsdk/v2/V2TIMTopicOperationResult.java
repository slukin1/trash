package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.TopicOperationResult;

public class V2TIMTopicOperationResult {
    private TopicOperationResult topicOperationResult = new TopicOperationResult();

    public int getErrorCode() {
        TopicOperationResult topicOperationResult2 = this.topicOperationResult;
        if (topicOperationResult2 == null) {
            return 0;
        }
        return topicOperationResult2.getErrorCode();
    }

    public String getErrorMessage() {
        TopicOperationResult topicOperationResult2 = this.topicOperationResult;
        if (topicOperationResult2 == null) {
            return "";
        }
        return topicOperationResult2.getErrorMessage();
    }

    public String getTopicID() {
        TopicOperationResult topicOperationResult2 = this.topicOperationResult;
        if (topicOperationResult2 == null) {
            return "";
        }
        return topicOperationResult2.getTopicID();
    }

    public void setTopicOperationResult(TopicOperationResult topicOperationResult2) {
        this.topicOperationResult = topicOperationResult2;
    }
}
