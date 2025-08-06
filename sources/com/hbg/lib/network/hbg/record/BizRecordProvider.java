package com.hbg.lib.network.hbg.record;

import com.hbg.lib.network.hbg.core.bean.BizTipRecord;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import v7.b;
import z7.a;

public class BizRecordProvider {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Integer, BizTipRecord> f70286a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, BizTipRecord> f70287b = new HashMap();

    public static void b() {
        f70286a.clear();
    }

    public static BizTipRecord c(int i11) {
        return f70287b.get(Integer.valueOf(i11));
    }

    public static Observable<BizTipRecord> d(int i11) {
        BizTipRecord bizTipRecord = f70286a.get(Integer.valueOf(i11));
        if (bizTipRecord != null && 1 == bizTipRecord.getState()) {
            return Observable.just(bizTipRecord);
        }
        BizTipRecord bizTipRecord2 = f70287b.get(Integer.valueOf(i11));
        if (bizTipRecord2 != null && bizTipRecord2.getState() == 0 && i11 == 4) {
            bizTipRecord2.setState(1);
        }
        return b.a().getTipsRecord(i11).b().map(new a(i11));
    }

    public static boolean e() {
        BizTipRecord c11 = c(4);
        if (c11 == null || 1 == c11.getState() || 2 == c11.getState()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ BizTipRecord f(int i11, BizTipRecord bizTipRecord) {
        f70286a.put(Integer.valueOf(i11), bizTipRecord);
        BizTipRecord bizTipRecord2 = new BizTipRecord();
        bizTipRecord2.setState(bizTipRecord.getState());
        bizTipRecord2.setClosedAt(bizTipRecord.getClosedAt());
        bizTipRecord2.setClosedCount(bizTipRecord.getClosedCount());
        f70287b.put(Integer.valueOf(i11), bizTipRecord2);
        return bizTipRecord;
    }
}
