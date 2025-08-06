package com.sumsub.sentry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final j0 f30425a;

    public l0(j0 j0Var) {
        this.f30425a = j0Var;
    }

    public final List<k0> a() {
        HashMap hashMap = new HashMap();
        Thread currentThread = Thread.currentThread();
        hashMap.put(currentThread, currentThread.getStackTrace());
        return a(hashMap, (List<Long>) null);
    }

    public final List<k0> a(List<Long> list) {
        return a(Thread.getAllStackTraces(), list);
    }

    public final List<k0> a(Map<Thread, StackTraceElement[]> map, List<Long> list) {
        Thread currentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(currentThread)) {
            map.put(currentThread, currentThread.getStackTrace());
        }
        for (Map.Entry next : map.entrySet()) {
            Thread thread = (Thread) next.getKey();
            arrayList.add(a(thread == currentThread || (list != null && list.contains(Long.valueOf(thread.getId()))), (StackTraceElement[]) next.getValue(), thread));
        }
        return arrayList;
    }

    public final k0 a(boolean z11, StackTraceElement[] stackTraceElementArr, Thread thread) {
        i0 i0Var;
        List<h0> a11 = this.f30425a.a(stackTraceElementArr);
        String name = thread.getName();
        int priority = thread.getPriority();
        long id2 = thread.getId();
        boolean isDaemon = thread.isDaemon();
        String name2 = thread.getState().name();
        if (a11 != null) {
            List<h0> list = a11.isEmpty() ^ true ? a11 : null;
            if (list != null) {
                i0Var = new i0((List) list, (Map) null, Boolean.TRUE, 2, (r) null);
                return new k0(Long.valueOf(id2), Integer.valueOf(priority), name, name2, Boolean.valueOf(z11), (Boolean) null, Boolean.valueOf(isDaemon), i0Var, 32, (r) null);
            }
        }
        i0Var = null;
        return new k0(Long.valueOf(id2), Integer.valueOf(priority), name, name2, Boolean.valueOf(z11), (Boolean) null, Boolean.valueOf(isDaemon), i0Var, 32, (r) null);
    }
}
