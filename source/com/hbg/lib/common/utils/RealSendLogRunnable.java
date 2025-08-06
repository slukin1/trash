package com.hbg.lib.common.utils;

import com.dianping.logan.SendLogRunnable;
import java.io.File;

public class RealSendLogRunnable extends SendLogRunnable {
    public void b(File file) {
        a();
        if (file.getName().contains(".copy")) {
            file.delete();
        }
    }
}
