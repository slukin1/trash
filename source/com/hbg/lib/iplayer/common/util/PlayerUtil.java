package com.hbg.lib.iplayer.common.util;

import android.text.TextUtils;
import com.hbg.lib.iplayer.common.model.PlayItem;

public class PlayerUtil {
    public static PlayItem.PlayType a(String str) {
        PlayItem.PlayType playType = PlayItem.PlayType.LOCAL;
        if (!TextUtils.isEmpty(str)) {
            return (str.startsWith("http") || str.startsWith("rtsp")) ? PlayItem.PlayType.ONLINE : playType;
        }
        return playType;
    }
}
