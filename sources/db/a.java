package db;

import ra.c;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f83826c;

    /* renamed from: a  reason: collision with root package name */
    public String f83827a;

    /* renamed from: b  reason: collision with root package name */
    public String f83828b;

    public a() {
        this.f83827a = "";
        this.f83828b = "";
        this.f83827a = c.c().s().getPackageName() + ".liteindex";
        this.f83828b = c.c().s().getPackageName() + ".litewallet";
    }

    public static a b() {
        if (f83826c == null) {
            synchronized (a.class) {
                if (f83826c == null) {
                    f83826c = new a();
                }
            }
        }
        return f83826c;
    }

    public String a() {
        return this.f83827a;
    }

    public String c() {
        return this.f83828b;
    }
}
