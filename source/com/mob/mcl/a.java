package com.mob.mcl;

import com.mob.mcl.b.b;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.utils.ActivityTracker;

public class a {

    /* renamed from: com.mob.mcl.a$a  reason: collision with other inner class name */
    public static class C0239a {
        public void a() {
        }

        public void b() {
        }
    }

    public static HttpConnection a(b bVar) {
        return new Tmpc$1(bVar);
    }

    public static HttpResponseCallback a(String str, com.mob.apc.a aVar) {
        return new Tmpc$2(aVar);
    }

    public static ActivityTracker.Tracker a(C0239a aVar) {
        return new Tmpc$3(aVar);
    }
}
