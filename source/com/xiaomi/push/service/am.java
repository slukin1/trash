package com.xiaomi.push.service;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class am {

    /* renamed from: a  reason: collision with root package name */
    private static am f52463a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f3333a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f3334a = new ConcurrentHashMap<>();

    public interface a {
        void a();
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private am() {
    }

    public static synchronized am a() {
        am amVar;
        synchronized (am.class) {
            if (f52463a == null) {
                f52463a = new am();
            }
            amVar = f52463a;
        }
        return amVar;
    }

    public synchronized void b() {
        this.f3333a.clear();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f52464a = 0;

        /* renamed from: a  reason: collision with other field name */
        public Context f3335a;

        /* renamed from: a  reason: collision with other field name */
        public IBinder.DeathRecipient f3336a = null;

        /* renamed from: a  reason: collision with other field name */
        public Messenger f3337a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.c f3338a = new XMPushService.c(this);

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f3339a;

        /* renamed from: a  reason: collision with other field name */
        public final C0642b f3340a = new C0642b();

        /* renamed from: a  reason: collision with other field name */
        public c f3341a = c.unbind;

        /* renamed from: a  reason: collision with other field name */
        public h f3342a;

        /* renamed from: a  reason: collision with other field name */
        public String f3343a;

        /* renamed from: a  reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f3344a = new CopyOnWriteArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        public boolean f3345a;

        /* renamed from: b  reason: collision with root package name */
        public c f52465b = null;

        /* renamed from: b  reason: collision with other field name */
        public String f3346b;

        /* renamed from: b  reason: collision with other field name */
        private boolean f3347b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f52466c;

        /* renamed from: d  reason: collision with root package name */
        public String f52467d;

        /* renamed from: e  reason: collision with root package name */
        public String f52468e;

        /* renamed from: f  reason: collision with root package name */
        public String f52469f;

        /* renamed from: g  reason: collision with root package name */
        public String f52470g;

        /* renamed from: h  reason: collision with root package name */
        public String f52471h;

        /* renamed from: i  reason: collision with root package name */
        public String f52472i;

        public interface a {
            void a(c cVar, c cVar2, int i11);
        }

        public class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            public final Messenger f52477a;

            /* renamed from: a  reason: collision with other field name */
            public final b f3350a;

            public c(b bVar, Messenger messenger) {
                this.f3350a = bVar;
                this.f52477a = messenger;
            }

            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f3350a.f52470g);
                b.a(b.this).a((XMPushService.j) new XMPushService.j(0) {
                    public String a() {
                        return "clear peer job";
                    }

                    /* renamed from: a  reason: collision with other method in class */
                    public void m2996a() {
                        c cVar = c.this;
                        if (cVar.f52477a == cVar.f3350a.f3337a) {
                            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + c.this.f3350a.f52470g);
                            c.this.f3350a.f3337a = null;
                        }
                    }
                }, 0);
                if ("9".equals(this.f3350a.f52470g) && "com.xiaomi.xmsf".equals(b.a(b.this).getPackageName())) {
                    b.a(b.this).a((XMPushService.j) new XMPushService.j(0) {
                        public String a() {
                            return "check peer job";
                        }

                        /* renamed from: a  reason: collision with other method in class */
                        public void m2997a() {
                            am a11 = am.a();
                            b bVar = c.this.f3350a;
                            if (a11.a(bVar.f52470g, bVar.f3346b).f3337a == null) {
                                XMPushService a12 = b.a(b.this);
                                b bVar2 = c.this.f3350a;
                                a12.a(bVar2.f52470g, bVar2.f3346b, 2, (String) null, (String) null);
                            }
                        }
                    }, 60000);
                }
            }
        }

        public b() {
        }

        private boolean b(int i11, int i12, String str) {
            if (i11 == 1) {
                return this.f3341a != c.binded && this.f3339a.c() && i12 != 21 && (i12 != 7 || !"wait".equals(str));
            }
            if (i11 == 2) {
                return this.f3339a.c();
            }
            if (i11 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public String a(int i11) {
            return i11 != 1 ? i11 != 2 ? i11 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: com.xiaomi.push.service.am$b$b  reason: collision with other inner class name */
        public class C0642b extends XMPushService.j {

            /* renamed from: a  reason: collision with other field name */
            public String f3348a;

            /* renamed from: b  reason: collision with root package name */
            public int f52475b;

            /* renamed from: b  reason: collision with other field name */
            public String f3349b;

            /* renamed from: c  reason: collision with root package name */
            public int f52476c;

            public C0642b() {
                super(0);
            }

            public String a() {
                return "notify job";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m2995a() {
                if (b.this.a(this.f52475b, this.f52476c, this.f3349b)) {
                    b.this.a(this.f52475b, this.f52476c, this.f3348a, this.f3349b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.f52470g);
            }

            public XMPushService.j a(int i11, int i12, String str, String str2) {
                this.f52475b = i11;
                this.f52476c = i12;
                this.f3349b = str2;
                this.f3348a = str;
                return this;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2994a() {
            try {
                Messenger messenger = this.f3337a;
                if (!(messenger == null || this.f3336a == null)) {
                    messenger.getBinder().unlinkToDeath(this.f3336a, 0);
                }
            } catch (Exception unused) {
            }
            this.f52465b = null;
        }

        public void b(a aVar) {
            this.f3344a.remove(aVar);
        }

        public void a(Messenger messenger) {
            a();
            if (messenger != null) {
                try {
                    this.f3337a = messenger;
                    this.f3347b = true;
                    this.f3336a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f3336a, 0);
                } catch (Exception e11) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e11.getMessage());
                    this.f3337a = null;
                    this.f3347b = false;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.f52470g);
            }
        }

        public b(XMPushService xMPushService) {
            this.f3339a = xMPushService;
            a((a) new a() {
                public void a(c cVar, c cVar2, int i11) {
                    if (cVar2 == c.binding) {
                        b.a(b.this).a((XMPushService.j) b.a(b.this), 60000);
                    } else {
                        b.a(b.this).b((XMPushService.j) b.a(b.this));
                    }
                }
            });
        }

        public void a(c cVar, int i11, int i12, String str, String str2) {
            boolean z11;
            Iterator<a> it2 = this.f3344a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(this.f3341a, cVar, i12);
                }
            }
            c cVar2 = this.f3341a;
            int i13 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", new Object[]{cVar2, cVar, a(i11), an.a(i12), str, str2, this.f52470g}));
                this.f3341a = cVar;
            }
            if (this.f3342a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar != c.binding) {
                if (this.f52465b != null && (z11 = this.f3347b)) {
                    i13 = (this.f3337a == null || !z11) ? 10100 : 1000;
                }
                this.f3339a.b((XMPushService.j) this.f3340a);
                if (b(i11, i12, str2)) {
                    a(i11, i12, str, str2);
                } else {
                    this.f3339a.a(this.f3340a.a(i11, i12, str, str2), (long) i13);
                }
            }
        }

        /* access modifiers changed from: private */
        public void a(int i11, int i12, String str, String str2) {
            c cVar = this.f3341a;
            this.f52465b = cVar;
            if (i11 == 2) {
                this.f3342a.a(this.f3335a, this, i12);
            } else if (i11 == 3) {
                this.f3342a.a(this.f3335a, this, str2, str);
            } else if (i11 == 1) {
                boolean z11 = cVar == c.binded;
                if (!z11 && "wait".equals(str2)) {
                    this.f52464a++;
                } else if (z11) {
                    this.f52464a = 0;
                    if (this.f3337a != null) {
                        try {
                            this.f3337a.send(Message.obtain((Handler) null, 16, this.f3339a.f3279a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f3342a.a(this.f3339a, this, z11, i12, str);
            }
        }

        /* access modifiers changed from: private */
        public boolean a(int i11, int i12, String str) {
            boolean z11;
            c cVar = this.f52465b;
            if (cVar == null || !(z11 = this.f3347b)) {
                return true;
            }
            if (cVar == this.f3341a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.f52470g);
                return false;
            } else if (this.f3337a == null || !z11) {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.f52470g);
                return false;
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.f52470g);
                return true;
            }
        }

        public void a(a aVar) {
            this.f3344a.add(aVar);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f52464a + 1) * 15))) * 1000;
        }

        public static String a(String str) {
            int lastIndexOf;
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf("/")) != -1) {
                return str.substring(lastIndexOf + 1);
            }
            return "";
        }
    }

    public synchronized void a(b bVar) {
        HashMap hashMap = this.f3334a.get(bVar.f52470g);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f3334a.put(bVar.f52470g, hashMap);
        }
        hashMap.put(a(bVar.f3346b), bVar);
        com.xiaomi.channel.commonutils.logger.b.a("add active client. " + bVar.f3343a);
        for (a a11 : this.f3333a) {
            a11.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m2993a(String str, String str2) {
        HashMap hashMap = this.f3334a.get(str);
        if (hashMap != null) {
            b bVar = (b) hashMap.get(a(str2));
            if (bVar != null) {
                bVar.a();
            }
            hashMap.remove(a(str2));
            if (hashMap.isEmpty()) {
                this.f3334a.remove(str);
            }
        }
        for (a a11 : this.f3333a) {
            a11.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m2992a(String str) {
        HashMap hashMap = this.f3334a.get(str);
        if (hashMap != null) {
            for (b a11 : hashMap.values()) {
                a11.a();
            }
            hashMap.clear();
            this.f3334a.remove(str);
        }
        for (a a12 : this.f3333a) {
            a12.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<String> m2990a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, b> values : this.f3334a.values()) {
            for (b bVar : values.values()) {
                if (str.equals(bVar.f3343a)) {
                    arrayList.add(bVar.f52470g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<b> m2988a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, b> values : this.f3334a.values()) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<b> m2989a(String str) {
        if (!this.f3334a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f3334a.get(str).clone()).values();
    }

    public synchronized b a(String str, String str2) {
        HashMap hashMap = this.f3334a.get(str);
        if (hashMap == null) {
            return null;
        }
        return (b) hashMap.get(a(str2));
    }

    public synchronized void a(Context context, int i11) {
        for (HashMap<String, b> values : this.f3334a.values()) {
            for (b a11 : values.values()) {
                a11.a(c.unbind, 2, i11, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m2987a() {
        return this.f3334a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m2991a() {
        Iterator it2 = a().iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).a();
        }
        this.f3334a.clear();
    }

    public synchronized void a(Context context) {
        for (HashMap<String, b> values : this.f3334a.values()) {
            for (b a11 : values.values()) {
                a11.a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(TIMMentionEditText.TIM_MENTION_TAG);
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public synchronized void a(a aVar) {
        this.f3333a.add(aVar);
    }
}
