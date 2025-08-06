package kotlin.io;

import d10.l;
import d10.p;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.sequences.g;

public final class e implements g<File> {

    /* renamed from: a  reason: collision with root package name */
    public final File f56704a;

    /* renamed from: b  reason: collision with root package name */
    public final FileWalkDirection f56705b;

    /* renamed from: c  reason: collision with root package name */
    public final l<File, Boolean> f56706c;

    /* renamed from: d  reason: collision with root package name */
    public final l<File, Unit> f56707d;

    /* renamed from: e  reason: collision with root package name */
    public final p<File, IOException, Unit> f56708e;

    /* renamed from: f  reason: collision with root package name */
    public final int f56709f;

    public static abstract class a extends c {
        public a(File file) {
            super(file);
        }
    }

    public final class b extends AbstractIterator<File> {

        /* renamed from: d  reason: collision with root package name */
        public final ArrayDeque<c> f56710d;

        public final class a extends a {

            /* renamed from: b  reason: collision with root package name */
            public boolean f56712b;

            /* renamed from: c  reason: collision with root package name */
            public File[] f56713c;

            /* renamed from: d  reason: collision with root package name */
            public int f56714d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f56715e;

            public a(File file) {
                super(file);
            }

            public File b() {
                if (!this.f56715e && this.f56713c == null) {
                    l d11 = e.this.f56706c;
                    boolean z11 = false;
                    if (d11 != null && !((Boolean) d11.invoke(a())).booleanValue()) {
                        z11 = true;
                    }
                    if (z11) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f56713c = listFiles;
                    if (listFiles == null) {
                        p e11 = e.this.f56708e;
                        if (e11 != null) {
                            e11.invoke(a(), new AccessDeniedException(a(), (File) null, "Cannot list files in a directory", 2, (r) null));
                        }
                        this.f56715e = true;
                    }
                }
                File[] fileArr = this.f56713c;
                if (fileArr != null && this.f56714d < fileArr.length) {
                    File[] fileArr2 = this.f56713c;
                    int i11 = this.f56714d;
                    this.f56714d = i11 + 1;
                    return fileArr2[i11];
                } else if (!this.f56712b) {
                    this.f56712b = true;
                    return a();
                } else {
                    l f11 = e.this.f56707d;
                    if (f11 != null) {
                        f11.invoke(a());
                    }
                    return null;
                }
            }
        }

        /* renamed from: kotlin.io.e$b$b  reason: collision with other inner class name */
        public final class C0664b extends c {

            /* renamed from: b  reason: collision with root package name */
            public boolean f56717b;

            public C0664b(File file) {
                super(file);
            }

            public File b() {
                if (this.f56717b) {
                    return null;
                }
                this.f56717b = true;
                return a();
            }
        }

        public final class c extends a {

            /* renamed from: b  reason: collision with root package name */
            public boolean f56719b;

            /* renamed from: c  reason: collision with root package name */
            public File[] f56720c;

            /* renamed from: d  reason: collision with root package name */
            public int f56721d;

            public c(File file) {
                super(file);
            }

            public File b() {
                p e11;
                if (!this.f56719b) {
                    l d11 = e.this.f56706c;
                    boolean z11 = false;
                    if (d11 != null && !((Boolean) d11.invoke(a())).booleanValue()) {
                        z11 = true;
                    }
                    if (z11) {
                        return null;
                    }
                    this.f56719b = true;
                    return a();
                }
                File[] fileArr = this.f56720c;
                if (fileArr == null || this.f56721d < fileArr.length) {
                    if (this.f56720c == null) {
                        File[] listFiles = a().listFiles();
                        this.f56720c = listFiles;
                        if (listFiles == null && (e11 = e.this.f56708e) != null) {
                            e11.invoke(a(), new AccessDeniedException(a(), (File) null, "Cannot list files in a directory", 2, (r) null));
                        }
                        File[] fileArr2 = this.f56720c;
                        if (fileArr2 == null || fileArr2.length == 0) {
                            l f11 = e.this.f56707d;
                            if (f11 != null) {
                                f11.invoke(a());
                            }
                            return null;
                        }
                    }
                    File[] fileArr3 = this.f56720c;
                    int i11 = this.f56721d;
                    this.f56721d = i11 + 1;
                    return fileArr3[i11];
                }
                l f12 = e.this.f56707d;
                if (f12 != null) {
                    f12.invoke(a());
                }
                return null;
            }
        }

        public /* synthetic */ class d {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f56723a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    kotlin.io.FileWalkDirection[] r0 = kotlin.io.FileWalkDirection.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.TOP_DOWN     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.BOTTOM_UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f56723a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.e.b.d.<clinit>():void");
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f56710d = arrayDeque;
            if (e.this.f56704a.isDirectory()) {
                arrayDeque.push(f(e.this.f56704a));
            } else if (e.this.f56704a.isFile()) {
                arrayDeque.push(new C0664b(e.this.f56704a));
            } else {
                b();
            }
        }

        public void a() {
            File g11 = g();
            if (g11 != null) {
                c(g11);
            } else {
                b();
            }
        }

        public final a f(File file) {
            int i11 = d.f56723a[e.this.f56705b.ordinal()];
            if (i11 == 1) {
                return new c(file);
            }
            if (i11 == 2) {
                return new a(file);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final File g() {
            File b11;
            while (true) {
                c peek = this.f56710d.peek();
                if (peek == null) {
                    return null;
                }
                b11 = peek.b();
                if (b11 == null) {
                    this.f56710d.pop();
                } else if (x.b(b11, peek.a()) || !b11.isDirectory() || this.f56710d.size() >= e.this.f56709f) {
                    return b11;
                } else {
                    this.f56710d.push(f(b11));
                }
            }
            return b11;
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final File f56724a;

        public c(File file) {
            this.f56724a = file;
        }

        public final File a() {
            return this.f56724a;
        }

        public abstract File b();
    }

    public e(File file, FileWalkDirection fileWalkDirection, l<? super File, Boolean> lVar, l<? super File, Unit> lVar2, p<? super File, ? super IOException, Unit> pVar, int i11) {
        this.f56704a = file;
        this.f56705b = fileWalkDirection;
        this.f56706c = lVar;
        this.f56707d = lVar2;
        this.f56708e = pVar;
        this.f56709f = i11;
    }

    public Iterator<File> iterator() {
        return new b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(File file, FileWalkDirection fileWalkDirection, l lVar, l lVar2, p pVar, int i11, int i12, r rVar) {
        this(file, (i12 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, lVar, lVar2, pVar, (i12 & 32) != 0 ? Integer.MAX_VALUE : i11);
    }

    public e(File file, FileWalkDirection fileWalkDirection) {
        this(file, fileWalkDirection, (l) null, (l) null, (p) null, 0, 32, (r) null);
    }
}
