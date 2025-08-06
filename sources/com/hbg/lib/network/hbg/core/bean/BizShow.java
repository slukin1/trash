package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class BizShow implements Serializable {
    public static final int BIZ_TYPE_HUOBI_EARN = 12;
    public static final int BIZ_TYPE_MARGIN = 2;
    public static final int BIZ_TYPE_MORTGAGE = 1;
    public static final int BIZ_TYPE_OTC = 10;
    public static final int BIZ_TYPE_POOL = 11;
    public static final int BIZ_TYPE_QUANT = 13;
    public static final int BIZ_TYPE_WARRANT = 14;
    private Action action;
    private int bizType;

    public static class Action implements Serializable {
        private boolean showAssetPage;

        public boolean canEqual(Object obj) {
            return obj instanceof Action;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return action.canEqual(this) && isShowAssetPage() == action.isShowAssetPage();
        }

        public int hashCode() {
            return 59 + (isShowAssetPage() ? 79 : 97);
        }

        public boolean isShowAssetPage() {
            return this.showAssetPage;
        }

        public void setShowAssetPage(boolean z11) {
            this.showAssetPage = z11;
        }

        public String toString() {
            return "BizShow.Action(showAssetPage=" + isShowAssetPage() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof BizShow;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BizShow)) {
            return false;
        }
        BizShow bizShow = (BizShow) obj;
        if (!bizShow.canEqual(this) || getBizType() != bizShow.getBizType()) {
            return false;
        }
        Action action2 = getAction();
        Action action3 = bizShow.getAction();
        return action2 != null ? action2.equals(action3) : action3 == null;
    }

    public Action getAction() {
        return this.action;
    }

    public int getBizType() {
        return this.bizType;
    }

    public int hashCode() {
        Action action2 = getAction();
        return ((getBizType() + 59) * 59) + (action2 == null ? 43 : action2.hashCode());
    }

    public void setAction(Action action2) {
        this.action = action2;
    }

    public void setBizType(int i11) {
        this.bizType = i11;
    }

    public String toString() {
        return "BizShow(bizType=" + getBizType() + ", action=" + getAction() + ")";
    }
}
