package com.amazonaws.metrics;

import com.amazonaws.Request;
import com.amazonaws.Response;

public abstract class RequestMetricCollector {

    /* renamed from: a  reason: collision with root package name */
    public static final RequestMetricCollector f14948a = new RequestMetricCollector() {
        public void a(Request<?> request, Response<?> response) {
        }

        public boolean b() {
            return false;
        }
    };

    public abstract void a(Request<?> request, Response<?> response);

    public boolean b() {
        return true;
    }
}
