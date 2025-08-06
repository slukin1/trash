package io.noties.markwon.html;

import io.noties.markwon.html.b;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f55319a;

    /* renamed from: b  reason: collision with root package name */
    public final int f55320b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f55321c;

    /* renamed from: d  reason: collision with root package name */
    public int f55322d = -1;

    public static class a extends c implements b.a {

        /* renamed from: e  reason: collision with root package name */
        public final a f55323e;

        /* renamed from: f  reason: collision with root package name */
        public List<a> f55324f;

        public a(String str, int i11, Map<String, String> map, a aVar) {
            super(str, i11, map);
            this.f55323e = aVar;
        }

        public static a i(String str, int i11, Map<String, String> map, a aVar) {
            return new a(str, i11, map, aVar);
        }

        public static a j() {
            return new a("", 0, Collections.emptyMap(), (a) null);
        }

        public b.a a() {
            return this;
        }

        public Map<String, String> b() {
            return this.f55321c;
        }

        public b.a d() {
            return this.f55323e;
        }

        public boolean e() {
            return true;
        }

        public List<b.a> f() {
            List<a> list = this.f55324f;
            if (list == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(list);
        }

        public void h(int i11) {
            if (!isClosed()) {
                this.f55322d = i11;
                List<a> list = this.f55324f;
                if (list != null) {
                    for (a h11 : list) {
                        h11.h(i11);
                    }
                }
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BlockImpl{name='");
            sb2.append(this.f55319a);
            sb2.append('\'');
            sb2.append(", start=");
            sb2.append(this.f55320b);
            sb2.append(", end=");
            sb2.append(this.f55322d);
            sb2.append(", attributes=");
            sb2.append(this.f55321c);
            sb2.append(", parent=");
            a aVar = this.f55323e;
            sb2.append(aVar != null ? aVar.f55319a : null);
            sb2.append(", children=");
            sb2.append(this.f55324f);
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static class b extends c implements b.C0653b {
        public b(String str, int i11, Map<String, String> map) {
            super(str, i11, map);
        }

        public b.a a() {
            throw new ClassCastException("Cannot cast Inline instance to Block");
        }

        public boolean e() {
            return false;
        }

        public void h(int i11) {
            if (!isClosed()) {
                this.f55322d = i11;
            }
        }

        public String toString() {
            return "InlineImpl{name='" + this.f55319a + '\'' + ", start=" + this.f55320b + ", end=" + this.f55322d + ", attributes=" + this.f55321c + '}';
        }
    }

    public c(String str, int i11, Map<String, String> map) {
        this.f55319a = str;
        this.f55320b = i11;
        this.f55321c = map;
    }

    public Map<String, String> b() {
        return this.f55321c;
    }

    public int c() {
        return this.f55322d;
    }

    public boolean g() {
        return this.f55320b == this.f55322d;
    }

    public boolean isClosed() {
        return this.f55322d > -1;
    }

    public String name() {
        return this.f55319a;
    }

    public int start() {
        return this.f55320b;
    }
}
