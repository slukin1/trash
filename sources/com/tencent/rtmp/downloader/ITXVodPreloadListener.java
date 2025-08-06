package com.tencent.rtmp.downloader;

public interface ITXVodPreloadListener {
    void onComplete(int i11, String str);

    void onError(int i11, String str, int i12, String str2);
}
