package com.huawei.hms.push.task;

public class ProfileTask extends BaseVoidTask {
    public ProfileTask(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public int getApiLevel() {
        return 2;
    }

    public int getMinApkVersion() {
        return 50004300;
    }
}
