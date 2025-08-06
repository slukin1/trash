package com.hbg.lib.network.option.core.util;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionOrderUtil {
    public static List<String> a(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.addAll(Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        }
        return arrayList;
    }
}
