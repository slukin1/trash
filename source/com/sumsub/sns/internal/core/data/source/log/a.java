package com.sumsub.sns.internal.core.data.source.log;

import com.sumsub.sns.internal.core.data.model.LogParams;
import com.sumsub.sns.internal.core.data.model.LogType;
import com.sumsub.sns.internal.core.data.source.applicant.remote.g;
import kotlin.coroutines.c;

public interface a {
    Object a(LogType logType, LogParams logParams, c<? super g> cVar);
}
