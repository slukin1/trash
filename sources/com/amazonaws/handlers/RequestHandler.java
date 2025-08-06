package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
public interface RequestHandler {
    void a(Request<?> request, Exception exc);

    void b(Request<?> request);

    void c(Request<?> request, Object obj, TimingInfo timingInfo);
}
