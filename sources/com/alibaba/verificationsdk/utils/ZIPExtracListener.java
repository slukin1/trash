package com.alibaba.verificationsdk.utils;

import java.io.File;

public interface ZIPExtracListener {
    void unzipFinished(File file, File file2);

    void unzipStart();
}
