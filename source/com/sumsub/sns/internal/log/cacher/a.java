package com.sumsub.sns.internal.log.cacher;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.coroutines.c;

public interface a<Payload> extends c<Payload> {
    Object a(InputStream inputStream, c<? super Boolean> cVar);

    Object a(Payload payload, OutputStream outputStream, c<? super Unit> cVar);
}
