package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupSearchParam;
import java.io.Serializable;
import java.util.List;

public class V2TIMGroupSearchParam implements Serializable {
    private static final int SEARCH_FIELD_GROUP_ID = 1;
    private static final int SEARCH_FIELD_GROUP_NAME = 2;
    private GroupSearchParam groupSearchParam = new GroupSearchParam();

    public GroupSearchParam getGroupSearchParam() {
        return this.groupSearchParam;
    }

    public List<String> getKeywordList() {
        return this.groupSearchParam.getKeywordList();
    }

    public void setKeywordList(List<String> list) {
        this.groupSearchParam.setKeywordList(list);
    }

    public void setSearchGroupID(boolean z11) {
        if (z11) {
            this.groupSearchParam.addSearchField(1);
        } else {
            this.groupSearchParam.removeSearchField(1);
        }
    }

    public void setSearchGroupName(boolean z11) {
        if (z11) {
            this.groupSearchParam.addSearchField(2);
        } else {
            this.groupSearchParam.removeSearchField(2);
        }
    }
}
