package com.mob.tools;

import com.jumio.core.cdn.CDNDownload;
import com.mob.commons.z;
import com.mob.tools.c.a;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.i;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MDP implements PublicMemberKeeper {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Object f27652a = new Object();

    public static Object get(String str, ArrayList<Object> arrayList) {
        return get(str, arrayList, false, 0);
    }

    private static Object a(String str, BlockingQueue blockingQueue) throws InterruptedException {
        return blockingQueue.poll((long) (("gia".equals(str) || "gal".equals(str) || "gsl".equals(str) || "giafce".equals(str)) ? CDNDownload.DEFAULT_TIMEOUT : "glctn".equals(str) ? 60000 : 3000), TimeUnit.MILLISECONDS);
    }

    public static Object get(String str, ArrayList<Object> arrayList, int i11) {
        return get(str, arrayList, false, i11);
    }

    public static Object get(String str, ArrayList<Object> arrayList, boolean z11) {
        return get(str, arrayList, z11, 0);
    }

    public static Object get(final String str, final ArrayList<Object> arrayList, boolean z11, int i11) {
        Object obj;
        if (z11) {
            return a.a(str, arrayList);
        }
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        z.f27386e.execute(new i() {
            public void a() {
                Object a11 = a.a(str, arrayList);
                if (a11 == null) {
                    a11 = MDP.f27652a;
                }
                linkedBlockingQueue.offer(a11);
            }
        });
        if (i11 <= 0) {
            try {
                obj = a(str, linkedBlockingQueue);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
                return null;
            }
        } else {
            obj = linkedBlockingQueue.poll((long) i11, TimeUnit.MILLISECONDS);
        }
        if (obj == f27652a) {
            return null;
        }
        return obj;
    }
}
