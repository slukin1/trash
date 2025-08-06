package com.hbg.module.huobi.im.group.ui.chat;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.util.Comparator;

public final /* synthetic */ class l implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ l f20449b = new l();

    public final int compare(Object obj, Object obj2) {
        return Long.compare(((TUIMessageBean) obj).getMessageTime(), ((TUIMessageBean) obj2).getMessageTime());
    }
}
