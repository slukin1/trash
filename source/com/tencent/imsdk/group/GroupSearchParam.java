package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupSearchParam implements Serializable {
    private List<String> keywordList;
    private List<Integer> searchFieldList = new ArrayList();

    public void addSearchField(int i11) {
        this.searchFieldList.add(Integer.valueOf(i11));
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public List<Integer> getSearchFieldList() {
        return this.searchFieldList;
    }

    public void removeSearchField(int i11) {
        this.searchFieldList.remove(Integer.valueOf(i11));
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }

    public void setSearchFieldList(List<Integer> list) {
        this.searchFieldList = list;
    }
}
