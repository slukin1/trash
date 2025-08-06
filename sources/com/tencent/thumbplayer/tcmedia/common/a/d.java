package com.tencent.thumbplayer.tcmedia.common.a;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private b f49111a = new b();

    /* renamed from: b  reason: collision with root package name */
    private a f49112b = new a();

    /* renamed from: c  reason: collision with root package name */
    private e f49113c = new e();

    /* renamed from: d  reason: collision with root package name */
    private c f49114d = new c();

    /* renamed from: e  reason: collision with root package name */
    private C0618d f49115e = new C0618d();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f49116a;

        /* renamed from: b  reason: collision with root package name */
        public int f49117b;

        public a() {
            a();
        }

        public void a() {
            this.f49116a = -1;
            this.f49117b = -1;
        }

        public void a(a aVar) {
            aVar.a("av1hwdecoderprofile", this.f49116a);
            aVar.a("av1hwdecoderlevel", this.f49117b);
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f49119a;

        /* renamed from: b  reason: collision with root package name */
        public int f49120b;

        /* renamed from: c  reason: collision with root package name */
        public int f49121c;

        /* renamed from: d  reason: collision with root package name */
        public String f49122d;

        /* renamed from: e  reason: collision with root package name */
        public String f49123e;

        /* renamed from: f  reason: collision with root package name */
        public String f49124f;

        /* renamed from: g  reason: collision with root package name */
        public String f49125g;

        public b() {
            a();
        }

        public void a() {
            this.f49119a = "";
            this.f49120b = -1;
            this.f49121c = -1;
            this.f49122d = "";
            this.f49123e = "";
            this.f49124f = "";
            this.f49125g = "";
        }

        public void a(a aVar) {
            aVar.a("flowid", this.f49119a);
            aVar.a("appplatform", this.f49120b);
            aVar.a("apilevel", this.f49121c);
            aVar.a("osver", this.f49122d);
            aVar.a(DeviceRequestsHelper.DEVICE_INFO_MODEL, this.f49123e);
            aVar.a("serialno", this.f49124f);
            aVar.a("cpuname", this.f49125g);
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f49127a;

        /* renamed from: b  reason: collision with root package name */
        public int f49128b;

        public c() {
            a();
        }

        public void a() {
            this.f49127a = -1;
            this.f49128b = -1;
        }

        public void a(a aVar) {
            aVar.a("hevchwdecoderprofile", this.f49127a);
            aVar.a("hevchwdecoderlevel", this.f49128b);
        }
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.common.a.d$d  reason: collision with other inner class name */
    public class C0618d {

        /* renamed from: a  reason: collision with root package name */
        public int f49130a;

        /* renamed from: b  reason: collision with root package name */
        public int f49131b;

        public C0618d() {
            a();
        }

        public void a() {
            this.f49130a = -1;
            this.f49131b = -1;
        }

        public void a(a aVar) {
            aVar.a("vp8hwdecoderprofile", this.f49130a);
            aVar.a("vp8hwdecoderlevel", this.f49131b);
        }
    }

    public class e {

        /* renamed from: a  reason: collision with root package name */
        public int f49133a;

        /* renamed from: b  reason: collision with root package name */
        public int f49134b;

        public e() {
            a();
        }

        public void a() {
            this.f49133a = -1;
            this.f49134b = -1;
        }

        public void a(a aVar) {
            aVar.a("vp9hwdecoderprofile", this.f49133a);
            aVar.a("vp9hwdecoderlevel", this.f49134b);
        }
    }

    public b a() {
        return this.f49111a;
    }

    public a b() {
        return this.f49112b;
    }

    public e c() {
        return this.f49113c;
    }

    public C0618d d() {
        return this.f49115e;
    }

    public c e() {
        return this.f49114d;
    }
}
