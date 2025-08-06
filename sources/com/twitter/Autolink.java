package com.twitter;

public class Autolink {

    /* renamed from: a  reason: collision with root package name */
    public String f51133a;

    /* renamed from: b  reason: collision with root package name */
    public String f51134b;

    /* renamed from: c  reason: collision with root package name */
    public String f51135c;

    /* renamed from: d  reason: collision with root package name */
    public String f51136d;

    /* renamed from: e  reason: collision with root package name */
    public String f51137e;

    /* renamed from: f  reason: collision with root package name */
    public String f51138f;

    /* renamed from: g  reason: collision with root package name */
    public String f51139g;

    /* renamed from: h  reason: collision with root package name */
    public String f51140h;

    /* renamed from: i  reason: collision with root package name */
    public String f51141i;

    /* renamed from: j  reason: collision with root package name */
    public String f51142j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f51143k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f51144l;

    /* renamed from: m  reason: collision with root package name */
    public String f51145m;

    /* renamed from: n  reason: collision with root package name */
    public String f51146n;

    /* renamed from: o  reason: collision with root package name */
    public String f51147o;

    /* renamed from: p  reason: collision with root package name */
    public a f51148p;

    /* renamed from: q  reason: collision with root package name */
    public b f51149q;

    /* renamed from: r  reason: collision with root package name */
    public Extractor f51150r;

    public interface a {
    }

    public interface b {
    }

    public Autolink() {
        this(true);
    }

    public Autolink(boolean z11) {
        this.f51133a = null;
        this.f51143k = true;
        this.f51144l = false;
        this.f51145m = null;
        this.f51146n = null;
        this.f51147o = null;
        this.f51148p = null;
        this.f51149q = null;
        Extractor extractor = new Extractor();
        this.f51150r = extractor;
        this.f51133a = null;
        this.f51134b = "tweet-url list-slug";
        this.f51135c = "tweet-url username";
        this.f51136d = "tweet-url hashtag";
        this.f51137e = "tweet-url cashtag";
        this.f51138f = "https://twitter.com/";
        this.f51139g = "https://twitter.com/";
        this.f51140h = "https://twitter.com/#!/search?q=%23";
        this.f51141i = "https://twitter.com/#!/search?q=%24";
        this.f51142j = "style='position:absolute;left:-9999px;'";
        extractor.b(false);
        this.f51143k = z11;
    }
}
