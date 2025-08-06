package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
public abstract class AbstractRequestHandler implements RequestHandler {
    public void a(Request<?> request, Exception exc) {
    }

    public void b(Request<?> request) {
    }

    public void c(Request<?> request, Object obj, TimingInfo timingInfo) {
    }
}
