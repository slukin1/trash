package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

public class AgHmsUpdateState {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f38558c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static volatile AgHmsUpdateState f38559d;

    /* renamed from: a  reason: collision with root package name */
    private HmsCheckedState f38560a = HmsCheckedState.UNCHECKED;

    /* renamed from: b  reason: collision with root package name */
    private int f38561b = 0;

    private AgHmsUpdateState() {
    }

    public static AgHmsUpdateState getInstance() {
        if (f38559d == null) {
            synchronized (f38558c) {
                if (f38559d == null) {
                    f38559d = new AgHmsUpdateState();
                }
            }
        }
        return f38559d;
    }

    public HmsCheckedState getCheckedState() {
        return this.f38560a;
    }

    public int getTargetVersionCode() {
        return this.f38561b;
    }

    public boolean isUpdateHms() {
        return getCheckedState() == HmsCheckedState.NEED_UPDATE && this.f38561b != 0;
    }

    public void resetUpdateState() {
        if (getCheckedState() == HmsCheckedState.NEED_UPDATE) {
            setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
            setTargetVersionCode(0);
        }
    }

    public void setCheckedState(HmsCheckedState hmsCheckedState) {
        if (hmsCheckedState == null) {
            HMSLog.e("AgHmsUpdateState", "para invalid: checkedState is null");
        } else {
            this.f38560a = hmsCheckedState;
        }
    }

    public void setTargetVersionCode(int i11) {
        this.f38561b = i11;
    }
}
