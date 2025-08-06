package com.xiaomi.push.service;

import com.xiaomi.push.hf;
import com.xiaomi.push.j;
import com.xiaomi.push.s;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static a f52555a;

    /* renamed from: a  reason: collision with other field name */
    private static b f3388a;

    public interface a {
        boolean a(hf hfVar);
    }

    public interface b {
    }

    public static void a(b bVar) {
        f3388a = bVar;
    }

    public static boolean a(hf hfVar) {
        if (f52555a == null || hfVar == null) {
            com.xiaomi.channel.commonutils.logger.b.a("rc params is null, not cpra");
            return false;
        } else if (j.a(s.a())) {
            return f52555a.a(hfVar);
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("rc app not permission to cpra");
            return false;
        }
    }
}
