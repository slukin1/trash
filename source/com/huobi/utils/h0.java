package com.huobi.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.FileUtil;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class h0 {
    public static void b(File file, File file2) {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            for (File file3 : file.listFiles()) {
                FileUtil.d(file3, new File(file2.getAbsolutePath() + File.separator + file3.getName() + ".log"));
            }
        }
    }

    public static void c(File file, File file2) {
        if (file.isDirectory()) {
            for (File file3 : file.listFiles()) {
                if (file3.exists() && file3.isFile()) {
                    if (file3.getName().endsWith(".copy")) {
                        file3.delete();
                    } else if (!file3.getName().contains(InstructionFileId.DOT)) {
                        FileUtil.d(file3, new File(file2.getAbsolutePath() + File.separator + file3.getName() + ".log"));
                    }
                }
            }
        }
    }

    public static void e(File file) {
        if (file.isDirectory()) {
            List asList = Arrays.asList(file.listFiles());
            Collections.sort(asList, g0.f83744b);
            long j11 = 0;
            for (int i11 = 0; i11 < asList.size(); i11++) {
                File file2 = (File) asList.get(i11);
                j11 += file2.length();
                if (j11 > 31457280) {
                    file2.delete();
                }
            }
        }
    }
}
