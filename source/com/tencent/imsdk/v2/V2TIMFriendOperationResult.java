package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendOperationResult;
import java.io.Serializable;

public class V2TIMFriendOperationResult implements Serializable {
    private FriendOperationResult friendOperationResult;

    public int getResultCode() {
        return this.friendOperationResult.getResultCode();
    }

    public String getResultInfo() {
        return this.friendOperationResult.getResultInfo();
    }

    public String getUserID() {
        return this.friendOperationResult.getUserID();
    }

    public void setFriendOperationResult(FriendOperationResult friendOperationResult2) {
        this.friendOperationResult = friendOperationResult2;
    }
}
