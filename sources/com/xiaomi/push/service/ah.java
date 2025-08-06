package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.aa;
import com.xiaomi.push.az;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ah {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ah f52456a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f3330a;

    /* renamed from: a  reason: collision with other field name */
    private HashSet<a> f3331a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f52457b;

    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i11, String str) {
            this.mId = i11;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a) || this.mId != ((a) obj).mId) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.mId;
        }

        public abstract void onCallback();

        public final void run() {
            onCallback();
        }
    }

    private ah(Context context) {
        this.f3330a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.f52457b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public synchronized void a(a aVar) {
        if (!this.f3331a.contains(aVar)) {
            this.f3331a.add(aVar);
        }
    }

    public void b() {
        b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f3331a);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public synchronized void a() {
        this.f3331a.clear();
    }

    public static ah a(Context context) {
        if (f52456a == null) {
            synchronized (ah.class) {
                if (f52456a == null) {
                    f52456a = new ah(context);
                }
            }
        }
        return f52456a;
    }

    public void a(List<Pair<gm, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (aa.a(list) || aa.a(list2)) {
            b.a("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.f3330a.edit();
        edit.clear();
        for (Pair next : list) {
            Object obj = next.first;
            if (!(obj == null || next.second == null)) {
                edit.putInt(a((gm) obj), ((Integer) next.second).intValue());
            }
        }
        for (Pair next2 : list2) {
            Object obj2 = next2.first;
            if (!(obj2 == null || next2.second == null)) {
                a(edit, next2, a(((Integer) obj2).intValue()));
            }
        }
        edit.apply();
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (!aa.a(list)) {
            SharedPreferences.Editor edit = this.f52457b.edit();
            for (Pair next : list) {
                Object obj = next.first;
                if (obj != null) {
                    String a11 = a(((Integer) obj).intValue());
                    if (next.second == null) {
                        edit.remove(a11);
                    } else {
                        a(edit, next, a11);
                    }
                }
            }
            edit.apply();
        }
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            String str2 = (String) obj;
            if (str.equals(a(gl.AppIsInstalledList.a()))) {
                editor.putString(str, az.a(str2));
            } else {
                editor.putString(str, str2);
            }
        } else if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    public int a(int i11, int i12) {
        try {
            String a11 = a(i11);
            if (this.f52457b.contains(a11)) {
                return this.f52457b.getInt(a11, 0);
            }
            return this.f3330a.contains(a11) ? this.f3330a.getInt(a11, 0) : i12;
        } catch (Exception e11) {
            b.a(i11 + " oc int error " + e11);
            return i12;
        }
    }

    public long a(int i11, long j11) {
        try {
            String a11 = a(i11);
            if (this.f52457b.contains(a11)) {
                return this.f52457b.getLong(a11, 0);
            }
            return this.f3330a.contains(a11) ? this.f3330a.getLong(a11, 0) : j11;
        } catch (Exception e11) {
            b.a(i11 + " oc long error " + e11);
            return j11;
        }
    }

    public String a(int i11, String str) {
        try {
            String a11 = a(i11);
            if (this.f52457b.contains(a11)) {
                return this.f52457b.getString(a11, (String) null);
            }
            return this.f3330a.contains(a11) ? this.f3330a.getString(a11, (String) null) : str;
        } catch (Exception e11) {
            b.a(i11 + " oc string error " + e11);
            return str;
        }
    }

    public boolean a(int i11, boolean z11) {
        try {
            String a11 = a(i11);
            if (this.f52457b.contains(a11)) {
                return this.f52457b.getBoolean(a11, false);
            }
            return this.f3330a.contains(a11) ? this.f3330a.getBoolean(a11, false) : z11;
        } catch (Exception e11) {
            b.a(i11 + " oc boolean error " + e11);
            return z11;
        }
    }

    public int a(gm gmVar, int i11) {
        try {
            return this.f3330a.getInt(a(gmVar), i11);
        } catch (Exception e11) {
            b.a(gmVar + " version error " + e11);
            return i11;
        }
    }

    private String a(int i11) {
        return "oc_" + i11;
    }

    private String a(gm gmVar) {
        return "oc_version_" + gmVar.a();
    }
}
