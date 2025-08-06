package com.tencent.ugc.videoprocessor;

import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import java.util.Collection;
import java.util.List;

public class SpeedProcessor {
    private List<TXVideoEditConstants.TXSpeed> mSpeedList;

    public void clear() {
        List<TXVideoEditConstants.TXSpeed> list = this.mSpeedList;
        if (list != null) {
            list.clear();
        }
        this.mSpeedList = null;
    }

    public float findSpeedByLevel(int i11) {
        if (i11 == 0) {
            return 0.25f;
        }
        if (i11 == 1) {
            return 0.5f;
        }
        if (i11 != 3) {
            return i11 != 4 ? 1.0f : 2.0f;
        }
        return 1.5f;
    }

    public float getSpeedLevel(long j11) {
        List<TXVideoEditConstants.TXSpeed> list = this.mSpeedList;
        if (list == null || list.size() == 0) {
            return 1.0f;
        }
        for (TXVideoEditConstants.TXSpeed next : this.mSpeedList) {
            if (j11 > next.startTime * 1000 && j11 < next.endTime * 1000) {
                return findSpeedByLevel(next.speedLevel);
            }
        }
        return 1.0f;
    }

    public List<TXVideoEditConstants.TXSpeed> getSpeedList() {
        return this.mSpeedList;
    }

    public boolean isSpeedListExist() {
        if (CollectionUtils.isEmpty((Collection<?>) this.mSpeedList)) {
            return false;
        }
        for (TXVideoEditConstants.TXSpeed tXSpeed : this.mSpeedList) {
            if (tXSpeed.speedLevel != 2) {
                return true;
            }
        }
        return false;
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        this.mSpeedList = list;
    }
}
