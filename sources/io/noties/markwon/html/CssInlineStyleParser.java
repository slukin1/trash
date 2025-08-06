package io.noties.markwon.html;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class CssInlineStyleParser {

    public static class b extends CssInlineStyleParser {

        public static class a implements Iterable<uz.b> {

            /* renamed from: b  reason: collision with root package name */
            public final String f55305b;

            /* renamed from: io.noties.markwon.html.CssInlineStyleParser$b$a$a  reason: collision with other inner class name */
            public class C0651a implements Iterator<uz.b> {

                /* renamed from: b  reason: collision with root package name */
                public final uz.b f55306b;

                /* renamed from: c  reason: collision with root package name */
                public final StringBuilder f55307c;

                /* renamed from: d  reason: collision with root package name */
                public final int f55308d;

                /* renamed from: e  reason: collision with root package name */
                public int f55309e;

                public C0651a() {
                    this.f55306b = new uz.b();
                    this.f55307c = new StringBuilder();
                    this.f55308d = a.this.f55305b.length();
                }

                public final boolean a() {
                    return b(this.f55306b.a(), this.f55306b.c());
                }

                public final boolean b(String str, String str2) {
                    return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2);
                }

                /* renamed from: c */
                public uz.b next() {
                    if (a()) {
                        return this.f55306b;
                    }
                    throw new NoSuchElementException();
                }

                public final void d() {
                    this.f55306b.b("", "");
                    this.f55307c.setLength(0);
                    String str = null;
                    boolean z11 = false;
                    String str2 = null;
                    for (int i11 = this.f55309e; i11 < this.f55308d; i11++) {
                        char charAt = a.this.f55305b.charAt(i11);
                        if (str == null) {
                            if (':' == charAt) {
                                if (this.f55307c.length() > 0) {
                                    str = this.f55307c.toString().trim();
                                }
                                this.f55307c.setLength(0);
                            } else if (';' == charAt) {
                                this.f55307c.setLength(0);
                            } else if (Character.isWhitespace(charAt)) {
                                if (this.f55307c.length() > 0) {
                                    z11 = true;
                                }
                            } else if (z11) {
                                this.f55307c.setLength(0);
                                this.f55307c.append(charAt);
                                z11 = false;
                            } else {
                                this.f55307c.append(charAt);
                            }
                        } else if (str2 != null) {
                            continue;
                        } else if (Character.isWhitespace(charAt)) {
                            if (this.f55307c.length() > 0) {
                                this.f55307c.append(charAt);
                            }
                        } else if (';' == charAt) {
                            str2 = this.f55307c.toString().trim();
                            this.f55307c.setLength(0);
                            if (b(str, str2)) {
                                this.f55309e = i11 + 1;
                                this.f55306b.b(str, str2);
                                return;
                            }
                        } else {
                            this.f55307c.append(charAt);
                        }
                    }
                    if (str != null && this.f55307c.length() > 0) {
                        this.f55306b.b(str, this.f55307c.toString().trim());
                        this.f55309e = this.f55308d;
                    }
                }

                public boolean hasNext() {
                    d();
                    return a();
                }
            }

            public a(String str) {
                this.f55305b = str;
            }

            public Iterator<uz.b> iterator() {
                return new C0651a();
            }
        }

        public Iterable<uz.b> b(String str) {
            return new a(str);
        }
    }

    public static CssInlineStyleParser a() {
        return new b();
    }

    public abstract Iterable<uz.b> b(String str);
}
