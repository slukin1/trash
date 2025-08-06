package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.datereport.UGCDataReportDef;

public class UGCBeautyManager implements TXBeautyManager {
    private static final long MIN_REPORT_TIME_INTERVAL = 3000;
    private TXBeautyManagerImpl mBeautyManagerImpl;
    private long mLastBeautyStyleReportTs;
    private long mLastSetFilterReportTs;
    private long mLastSetRuddyLevelReportTs;
    private long mLastWhitenessLevelReportTs;

    public UGCBeautyManager(long j11) {
        this.mBeautyManagerImpl = new TXBeautyManagerImpl(j11);
    }

    public void enableSharpnessEnhancement(boolean z11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.enableSharpnessEnhancement(z11);
        }
    }

    public void setBeautyLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.setBeautyLevel(f11);
        }
    }

    public void setBeautyStyle(int i11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.setBeautyStyle(i11);
        }
        if (this.mLastBeautyStyleReportTs <= 0 || System.currentTimeMillis() - this.mLastBeautyStyleReportTs >= 3000) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_BEAUTY_SMOOTH, i11, (String) null);
            this.mLastBeautyStyleReportTs = System.currentTimeMillis();
        }
    }

    public int setChinLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setChinLevel(f11);
        }
        return 0;
    }

    public int setEyeAngleLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setEyeAngleLevel(f11);
        }
        return 0;
    }

    public int setEyeDistanceLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setEyeDistanceLevel(f11);
        }
        return 0;
    }

    public int setEyeLightenLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setEyeLightenLevel(f11);
        }
        return 0;
    }

    public int setEyeScaleLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setEyeScaleLevel(f11);
        }
        return 0;
    }

    public int setFaceBeautyLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setFaceBeautyLevel(f11);
        }
        return 0;
    }

    public int setFaceNarrowLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setFaceNarrowLevel(f11);
        }
        return 0;
    }

    public int setFaceShortLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setFaceShortLevel(f11);
        }
        return 0;
    }

    public int setFaceSlimLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setFaceSlimLevel(f11);
        }
        return 0;
    }

    public int setFaceVLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setFaceVLevel(f11);
        }
        return 0;
    }

    public void setFilter(Bitmap bitmap) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.setFilter(bitmap);
        }
        if (this.mLastSetFilterReportTs <= 0 || System.currentTimeMillis() - this.mLastSetFilterReportTs >= 3000) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_FILTER);
            this.mLastSetFilterReportTs = System.currentTimeMillis();
        }
    }

    public void setFilterStrength(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.setFilterStrength(f11);
        }
    }

    public int setForeheadLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setForeheadLevel(f11);
        }
        return 0;
    }

    public int setGreenScreenFile(String str) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setGreenScreenFile(str);
        }
        return 0;
    }

    public int setLipsThicknessLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setLipsThicknessLevel(f11);
        }
        return 0;
    }

    public void setMotionMute(boolean z11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.setMotionMute(z11);
        }
    }

    public void setMotionTmpl(String str) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.setMotionTmpl(str);
        }
    }

    public int setMouthShapeLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setMouthShapeLevel(f11);
        }
        return 0;
    }

    public int setNosePositionLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setNosePositionLevel(f11);
        }
        return 0;
    }

    public int setNoseSlimLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setNoseSlimLevel(f11);
        }
        return 0;
    }

    public int setNoseWingLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setNoseWingLevel(f11);
        }
        return 0;
    }

    public int setPounchRemoveLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setPounchRemoveLevel(f11);
        }
        return 0;
    }

    public void setRuddyLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.setRuddyLevel(f11);
        }
        if (this.mLastSetRuddyLevelReportTs <= 0 || System.currentTimeMillis() - this.mLastSetRuddyLevelReportTs >= 3000) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_BEAUTY_RUDDY);
            this.mLastSetRuddyLevelReportTs = System.currentTimeMillis();
        }
    }

    public int setSmileLinesRemoveLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setSmileLinesRemoveLevel(f11);
        }
        return 0;
    }

    public int setToothWhitenLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setToothWhitenLevel(f11);
        }
        return 0;
    }

    public void setWhitenessLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.setWhitenessLevel(f11);
        }
        if (this.mLastWhitenessLevelReportTs <= 0 || System.currentTimeMillis() - this.mLastWhitenessLevelReportTs >= 3000) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_BEAUTY_WHITE);
            this.mLastWhitenessLevelReportTs = System.currentTimeMillis();
        }
    }

    public int setWrinkleRemoveLevel(float f11) {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManagerImpl;
        if (tXBeautyManagerImpl != null) {
            return tXBeautyManagerImpl.setToothWhitenLevel(f11);
        }
        return 0;
    }
}
