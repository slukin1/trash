package com.alibaba.verificationsdk.utils;

import java.io.File;

public interface DownloadListener {
    void downloadFinished(File file);

    void downloadStart();
}
