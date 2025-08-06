package com.sumsub.sns.internal.core.data.source.log;

import com.sumsub.sns.internal.core.data.model.LogParams;
import com.sumsub.sns.internal.core.data.model.LogType;
import com.sumsub.sns.internal.core.data.model.r;
import com.sumsub.sns.internal.core.data.source.applicant.remote.g;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final b f33502a;

    public c(b bVar) {
        this.f33502a = bVar;
    }

    public Object a(LogType logType, LogParams logParams, kotlin.coroutines.c<? super g> cVar) {
        return this.f33502a.a(logType.getValue(), r.a(logParams), cVar);
    }
}
