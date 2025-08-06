package androidx.window.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u0012\u0003\u000bR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/j;", "Landroidx/window/layout/e;", "", "b", "()Z", "isSeparating", "Landroidx/window/layout/j$a;", "d", "()Landroidx/window/layout/j$a;", "occlusionType", "Landroidx/window/layout/j$b;", "c", "()Landroidx/window/layout/j$b;", "orientation", "Landroidx/window/layout/j$c;", "getState", "()Landroidx/window/layout/j$c;", "state", "a", "window_release"}, k = 1, mv = {1, 6, 0})
public interface j extends e {

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\u0004B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Landroidx/window/layout/j$a;", "", "", "toString", "a", "Ljava/lang/String;", "description", "<init>", "(Ljava/lang/String;)V", "b", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0061a f12119b = new C0061a((r) null);

        /* renamed from: c  reason: collision with root package name */
        public static final a f12120c = new a("NONE");

        /* renamed from: d  reason: collision with root package name */
        public static final a f12121d = new a("FULL");

        /* renamed from: a  reason: collision with root package name */
        public final String f12122a;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/window/layout/j$a$a;", "", "Landroidx/window/layout/j$a;", "FULL", "Landroidx/window/layout/j$a;", "NONE", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
        /* renamed from: androidx.window.layout.j$a$a  reason: collision with other inner class name */
        public static final class C0061a {
            public C0061a() {
            }

            public /* synthetic */ C0061a(r rVar) {
                this();
            }
        }

        public a(String str) {
            this.f12122a = str;
        }

        public String toString() {
            return this.f12122a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\u0004B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Landroidx/window/layout/j$b;", "", "", "toString", "a", "Ljava/lang/String;", "description", "<init>", "(Ljava/lang/String;)V", "b", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        /* renamed from: b  reason: collision with root package name */
        public static final a f12123b = new a((r) null);

        /* renamed from: c  reason: collision with root package name */
        public static final b f12124c = new b("VERTICAL");

        /* renamed from: d  reason: collision with root package name */
        public static final b f12125d = new b("HORIZONTAL");

        /* renamed from: a  reason: collision with root package name */
        public final String f12126a;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/window/layout/j$b$a;", "", "Landroidx/window/layout/j$b;", "HORIZONTAL", "Landroidx/window/layout/j$b;", "VERTICAL", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }
        }

        public b(String str) {
            this.f12126a = str;
        }

        public String toString() {
            return this.f12126a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\u0004B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Landroidx/window/layout/j$c;", "", "", "toString", "a", "Ljava/lang/String;", "description", "<init>", "(Ljava/lang/String;)V", "b", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class c {

        /* renamed from: b  reason: collision with root package name */
        public static final a f12127b = new a((r) null);

        /* renamed from: c  reason: collision with root package name */
        public static final c f12128c = new c("FLAT");

        /* renamed from: d  reason: collision with root package name */
        public static final c f12129d = new c("HALF_OPENED");

        /* renamed from: a  reason: collision with root package name */
        public final String f12130a;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/window/layout/j$c$a;", "", "Landroidx/window/layout/j$c;", "FLAT", "Landroidx/window/layout/j$c;", "HALF_OPENED", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }
        }

        public c(String str) {
            this.f12130a = str;
        }

        public String toString() {
            return this.f12130a;
        }
    }

    boolean b();

    b c();

    a d();

    c getState();
}
