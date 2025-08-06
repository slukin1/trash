package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.rtmp.TXVodDef;

public interface ITXVodPlayListener {

    public static abstract class ITXVodSubtitleDataListener {
        public void onSubtitleData(TXVodDef.TXVodSubtitleData tXVodSubtitleData) {
        }
    }

    void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle);

    void onPlayEvent(TXVodPlayer tXVodPlayer, int i11, Bundle bundle);
}
