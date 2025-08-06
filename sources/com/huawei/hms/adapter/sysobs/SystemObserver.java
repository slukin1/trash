package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public interface SystemObserver {
    boolean onNoticeResult(int i11);

    boolean onSolutionResult(Intent intent, String str);

    boolean onUpdateResult(int i11);
}
