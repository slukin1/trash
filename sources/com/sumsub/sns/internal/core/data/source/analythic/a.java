package com.sumsub.sns.internal.core.data.source.analythic;

import com.sumsub.sns.core.data.model.SNSTrackEvents;
import com.sumsub.sns.internal.log.cacher.e;
import java.util.List;
import kotlin.coroutines.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final e<List<SNSTrackEvents>> f32964a;

    public a(e<List<SNSTrackEvents>> eVar) {
        this.f32964a = eVar;
    }

    public final Object a(List<SNSTrackEvents> list, c<? super Boolean> cVar) {
        return this.f32964a.send(list, cVar);
    }
}
