package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LiveSquareBaseData implements Serializable {
    public static final int BANNER_MODULE_TYPE = 1;
    public static final int BANNER_VIEW_TYPE = 1;
    public static final int HOT_TALK_MODULE_TYPE = 3;
    public static final int HOT_TALK_VIEW_TYPE = 5;
    public static final int ITEM_ONE_VIEW_TYPE = 3;
    public static final int ITEM_PLAYBACK_ONE_TYPE = 8;
    public static final int ITEM_TWO_VIEW_TYPE = 4;
    public static final int LIVE_CATEGORY_TYPE = 6;
    public static final int LIVE_CATEGORY_VIEW_TYPE = 6;
    public static final int LIVE_RECOMMEND_SPEAKER_TYPE = 7;
    public static final int LIVE_RECOMMEND_SPEAKER_VIEW_TYPE = 7;
    public static final int PLAYBACK_MODULE_TYPE = 5;
    public static final int PLAYING_MODULE_TYPE = 2;
    public static final int PREPARE_MODULE_TYPE = 4;
    public static final int TITLE_VIEW_TYPE = 2;
    private static final long serialVersionUID = 2128860494416982257L;
    private String equId;
    private int index = -1;
    private int moduleType;
    private int realPos;
    private int viewType;

    public boolean equals(Object obj) {
        if (!(obj instanceof LiveSquareBaseData) || !this.equId.equals(((LiveSquareBaseData) obj).getEquId())) {
            return super.equals(obj);
        }
        return true;
    }

    public String getEquId() {
        return this.equId;
    }

    public int getIndex() {
        return this.index;
    }

    public int getModuleType() {
        return this.moduleType;
    }

    public int getRealPos() {
        return this.realPos;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setEquId(String str) {
        this.equId = str;
    }

    public void setIndex(int i11) {
        this.index = i11;
    }

    public void setModuleType(int i11) {
        this.moduleType = i11;
    }

    public void setRealPos(int i11) {
        this.realPos = i11;
    }

    public void setViewType(int i11) {
        this.viewType = i11;
    }
}
