package com.tencent.thumbplayer.tcmedia.api.proxy;

import java.util.ArrayList;
import java.util.Map;

public interface ITPPreloadProxy {

    public interface IPreloadListener {
        void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12);

        void onPrepareError();

        void onPrepareSuccess();
    }

    String getPlayErrorCodeStr(int i11);

    boolean isAvailable();

    void pushEvent(int i11);

    void setPreloadListener(IPreloadListener iPreloadListener);

    int startClipPreload(String str, ArrayList<TPDownloadParamData> arrayList);

    int startPreload(String str, TPDownloadParamData tPDownloadParamData);

    int startPreload(String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map);

    void stopPreload(int i11);
}
