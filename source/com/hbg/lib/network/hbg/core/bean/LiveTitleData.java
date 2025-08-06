package com.hbg.lib.network.hbg.core.bean;

public class LiveTitleData extends LiveSquareBaseData {
    private boolean isShowLine;
    private boolean isShowMore;
    private String titleName;

    public String getTitleName() {
        return this.titleName;
    }

    public boolean isShowLine() {
        return this.isShowLine;
    }

    public boolean isShowMore() {
        return this.isShowMore;
    }

    public void setShowLine(boolean z11) {
        this.isShowLine = z11;
    }

    public void setShowMore(boolean z11) {
        this.isShowMore = z11;
    }

    public void setTitleName(String str) {
        this.titleName = str;
    }
}
