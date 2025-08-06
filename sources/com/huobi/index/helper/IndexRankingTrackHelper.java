package com.huobi.index.helper;

import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import gs.g;
import io.flutter.Log;
import java.util.HashMap;

public class IndexRankingTrackHelper {
    public static void a(int i11, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("list_type", Integer.valueOf(i11));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        hashMap.put("select_type", str);
        Log.d("yaoge", "tab----:" + hashMap);
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        g.i("toplist_show", hashMap);
    }
}
