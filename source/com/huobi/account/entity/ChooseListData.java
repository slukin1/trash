package com.huobi.account.entity;

import java.io.Serializable;
import java.util.List;

public class ChooseListData implements Serializable {
    private long defaultId;
    private String leftTitle;
    private List<ChooseCityEntity> list;
    private String rightTitle;
    private boolean supportIndex;

    public boolean canEqual(Object obj) {
        return obj instanceof ChooseListData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChooseListData)) {
            return false;
        }
        ChooseListData chooseListData = (ChooseListData) obj;
        if (!chooseListData.canEqual(this)) {
            return false;
        }
        String leftTitle2 = getLeftTitle();
        String leftTitle3 = chooseListData.getLeftTitle();
        if (leftTitle2 != null ? !leftTitle2.equals(leftTitle3) : leftTitle3 != null) {
            return false;
        }
        String rightTitle2 = getRightTitle();
        String rightTitle3 = chooseListData.getRightTitle();
        if (rightTitle2 != null ? !rightTitle2.equals(rightTitle3) : rightTitle3 != null) {
            return false;
        }
        if (isSupportIndex() != chooseListData.isSupportIndex() || getDefaultId() != chooseListData.getDefaultId()) {
            return false;
        }
        List<ChooseCityEntity> list2 = getList();
        List<ChooseCityEntity> list3 = chooseListData.getList();
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public long getDefaultId() {
        return this.defaultId;
    }

    public String getLeftTitle() {
        return this.leftTitle;
    }

    public List<ChooseCityEntity> getList() {
        return this.list;
    }

    public String getRightTitle() {
        return this.rightTitle;
    }

    public int hashCode() {
        String leftTitle2 = getLeftTitle();
        int i11 = 43;
        int hashCode = leftTitle2 == null ? 43 : leftTitle2.hashCode();
        String rightTitle2 = getRightTitle();
        int hashCode2 = ((((hashCode + 59) * 59) + (rightTitle2 == null ? 43 : rightTitle2.hashCode())) * 59) + (isSupportIndex() ? 79 : 97);
        long defaultId2 = getDefaultId();
        int i12 = (hashCode2 * 59) + ((int) (defaultId2 ^ (defaultId2 >>> 32)));
        List<ChooseCityEntity> list2 = getList();
        int i13 = i12 * 59;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isSupportIndex() {
        return this.supportIndex;
    }

    public void setDefaultId(long j11) {
        this.defaultId = j11;
    }

    public void setLeftTitle(String str) {
        this.leftTitle = str;
    }

    public void setList(List<ChooseCityEntity> list2) {
        this.list = list2;
    }

    public void setRightTitle(String str) {
        this.rightTitle = str;
    }

    public void setSupportIndex(boolean z11) {
        this.supportIndex = z11;
    }

    public String toString() {
        return "ChooseListData(leftTitle=" + getLeftTitle() + ", rightTitle=" + getRightTitle() + ", supportIndex=" + isSupportIndex() + ", defaultId=" + getDefaultId() + ", list=" + getList() + ")";
    }
}
