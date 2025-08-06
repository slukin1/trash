package com.huobi.finance.presenter;

import com.hbg.lib.network.hbg.core.bean.CopyTradingAccountTransferRecord;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class w3 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ w3 f46159b = new w3();

    public final Object call(Object obj) {
        return Observable.from(((CopyTradingAccountTransferRecord) obj).getRecordList());
    }
}
