package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendGroup;
import java.io.Serializable;
import java.util.List;

public class V2TIMFriendGroup implements Serializable {
    private FriendGroup friendGroup = new FriendGroup();

    public long getFriendCount() {
        return (long) this.friendGroup.getUserCount();
    }

    public List<String> getFriendIDList() {
        return this.friendGroup.getUserIDList();
    }

    public String getName() {
        return this.friendGroup.getGroupName();
    }

    public void setFriendGroup(FriendGroup friendGroup2) {
        this.friendGroup = friendGroup2;
    }
}
