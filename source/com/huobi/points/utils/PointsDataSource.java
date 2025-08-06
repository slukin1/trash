package com.huobi.points.utils;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.network.response.AliTokenStringStatusResponse;
import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.service.PointsService;
import com.sumsub.sentry.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import tq.p;

public class PointsDataSource {
    public static Observable<Long> a(long j11, String str) {
        return ((PointsService) p.W(PointsService.class)).acceptPointsTransfer(j11, str).compose(p.a0());
    }

    public static Observable<Long> b(long j11) {
        return ((PointsService) p.W(PointsService.class)).cancelPointsTransfer(j11).compose(p.a0());
    }

    public static Observable<List<PointsAction>> c(Map<String, Object> map) {
        return ((PointsService) p.W(PointsService.class)).getPointsActions(map).compose(p.a0());
    }

    public static Observable<List<Points>> d(Map<String, Object> map) {
        return ((PointsService) p.W(PointsService.class)).getPointsOrders(map).compose(p.a0());
    }

    public static Observable<AliTokenStringStatusResponse<Points>> e(Map<String, Object> map) {
        return ((PointsService) p.W(PointsService.class)).orderCreate(map);
    }

    public static Observable<Points> f(long j11) {
        return ((PointsService) p.W(PointsService.class)).pointsOrderDetail(j11).compose(p.a0());
    }

    public static Observable<Long> g(Map<String, Object> map, long j11) {
        return ((PointsService) p.W(PointsService.class)).pointsOrderPlace(j11, map).compose(p.a0());
    }

    public static Observable<Long> h(long j11) {
        return ((PointsService) p.W(PointsService.class)).rejectPointsTransfer(j11).compose(p.a0());
    }

    public static Observable<Long> i(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, "usdt");
        hashMap.put("face-account", str);
        hashMap.put("face-uid", str2);
        hashMap.put("points", str3);
        hashMap.put(FirebaseAnalytics.Param.PRICE, str4);
        hashMap.put("source", a.f30241h);
        return ((PointsService) p.W(PointsService.class)).requestPointsTransfer(str5, hashMap).compose(p.a0());
    }
}
