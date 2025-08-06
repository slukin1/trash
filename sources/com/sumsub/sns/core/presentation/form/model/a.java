package com.sumsub.sns.core.presentation.form.model;

import com.sumsub.sns.core.presentation.form.e;
import com.sumsub.sns.internal.core.data.model.FieldType;
import com.sumsub.sns.internal.core.data.model.p;
import com.sumsub.sns.internal.core.data.model.remote.c;
import com.sumsub.sns.internal.core.data.source.applicant.remote.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FieldError;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.core.presentation.form.model.g;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: com.sumsub.sns.core.presentation.form.model.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0292a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30963a;

        static {
            int[] iArr = new int[FieldError.values().length];
            iArr[FieldError.REQUIRED.ordinal()] = 1;
            iArr[FieldError.NOT_VALID.ordinal()] = 2;
            f30963a = iArr;
        }
    }

    public static final String a(FormItem formItem, b.c cVar, e eVar) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24 = true;
        if (formItem instanceof FormItem.p) {
            z11 = true;
        } else {
            z11 = formItem instanceof FormItem.q;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = formItem instanceof FormItem.a;
        }
        if (z12) {
            z13 = true;
        } else {
            z13 = formItem instanceof FormItem.d;
        }
        if (z13) {
            z14 = true;
        } else {
            z14 = formItem instanceof FormItem.e;
        }
        if (z14) {
            z15 = true;
        } else {
            z15 = formItem instanceof FormItem.c;
        }
        if (z15) {
            z16 = true;
        } else {
            z16 = formItem instanceof FormItem.n;
        }
        if (z16) {
            FieldError a11 = g.a(formItem.d(), eVar.a(formItem));
            if (a11 != null) {
                return a(a11, cVar);
            }
        } else if (formItem instanceof FormItem.k) {
            String a12 = eVar.a(a((FormItem.k) formItem));
            String a13 = eVar.a(formItem);
            if (a13 == null) {
                a13 = "";
            }
            FieldError a14 = g.a(formItem.d(), c.Companion.a(a12, a13));
            if (a14 == null && !com.sumsub.sns.internal.core.widget.autocompletePhone.util.a.a(a13)) {
                return a(FieldError.NOT_VALID, cVar);
            }
            if (a14 != null) {
                return a(a14, cVar);
            }
        } else {
            if (formItem instanceof FormItem.j) {
                z17 = true;
            } else {
                z17 = formItem instanceof FormItem.m;
            }
            if (z17) {
                z18 = true;
            } else {
                z18 = formItem instanceof FormItem.g;
            }
            if (z18) {
                z19 = true;
            } else {
                z19 = formItem instanceof FormItem.i;
            }
            if (z19) {
                String a15 = a(FieldError.REQUIRED, cVar);
                if (!a(formItem, eVar)) {
                    return a15;
                }
            } else {
                if (formItem instanceof FormItem.f) {
                    z21 = true;
                } else {
                    z21 = formItem instanceof FormItem.h;
                }
                if (z21) {
                    z22 = true;
                } else {
                    z22 = formItem instanceof FormItem.l;
                }
                if (z22) {
                    z23 = true;
                } else {
                    z23 = formItem instanceof FormItem.o;
                }
                if (!z23) {
                    z24 = formItem instanceof FormItem.r;
                }
                if (!z24) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        return null;
    }

    public static final p b(FormItem.i iVar) {
        p a11;
        if (iVar == null || (a11 = g.a(iVar.d())) == null) {
            return null;
        }
        return (!(a11 instanceof p.h) || !iVar.j()) ? a11 : new p.d(new h(1.0d, ((p.h) a11).a()));
    }

    public static final FormItem b(FormItem.k kVar) {
        return new FormItem.h("internal." + kVar.e(), new k(kVar.d().p() + ".countryPhoneCode", (String) null, (String) null, FieldType.text.name(), Boolean.FALSE, (String) null, (String) null, (String) null, (List) null, (int) TXVodDownloadDataSource.QUALITY_480P, (r) null));
    }

    public static final boolean a(FormItem formItem, e eVar) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (formItem instanceof FormItem.p) {
            z11 = true;
        } else {
            z11 = formItem instanceof FormItem.q;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = formItem instanceof FormItem.a;
        }
        if (z12) {
            z13 = true;
        } else {
            z13 = formItem instanceof FormItem.d;
        }
        if (z13) {
            z14 = true;
        } else {
            z14 = formItem instanceof FormItem.e;
        }
        if (z14) {
            z15 = true;
        } else {
            z15 = formItem instanceof FormItem.c;
        }
        boolean z21 = false;
        if (z15) {
            if (g.a(formItem.d(), eVar.a(formItem)) == null) {
                return true;
            }
            return false;
        } else if (formItem instanceof FormItem.n) {
            k d11 = formItem.d();
            String a11 = eVar.a(formItem);
            List<com.sumsub.sns.internal.core.data.source.applicant.remote.r> r11 = formItem.d().r();
            if (r11 == null) {
                r11 = CollectionsKt__CollectionsKt.k();
            }
            if (g.a(d11, a11, r11) == null) {
                return true;
            }
            return false;
        } else if (formItem instanceof FormItem.k) {
            String a12 = eVar.a(a((FormItem.k) formItem));
            String a13 = eVar.a(formItem);
            if (a13 == null) {
                a13 = "";
            }
            String a14 = c.Companion.a(a12, a13);
            Object a15 = g.a(formItem.d(), a14);
            if (a15 == null) {
                FormItem.k kVar = (FormItem.k) formItem;
                a15 = !com.sumsub.sns.internal.core.widget.autocompletePhone.util.a.a(a13) && (StringsKt__StringsJVMKt.z(a14) ^ true) ? formItem : null;
            }
            if ((x.b(formItem.d().v(), Boolean.TRUE) && StringsKt__StringsJVMKt.z(a14)) || a15 != null) {
                z21 = true;
            }
            return !z21;
        } else {
            if (formItem instanceof FormItem.m) {
                String a16 = eVar.a(formItem);
                boolean z22 = a16 == null || a16.length() == 0;
                if (!x.b(formItem.d().v(), Boolean.TRUE) || !z22) {
                    return true;
                }
            } else if (formItem instanceof FormItem.j) {
                List<String> b11 = eVar.b(formItem);
                boolean z23 = b11 == null || b11.isEmpty();
                if (!x.b(formItem.d().v(), Boolean.TRUE) || !z23) {
                    return true;
                }
            } else if (formItem instanceof FormItem.g) {
                String a17 = eVar.a(formItem);
                if (!x.b(formItem.d().v(), Boolean.TRUE) || a17 != null) {
                    return true;
                }
            } else if (formItem instanceof FormItem.i) {
                List<String> b12 = eVar.b(formItem);
                if (b12 == null) {
                    b12 = CollectionsKt__CollectionsKt.k();
                }
                boolean z24 = formItem.j() || ((b12.isEmpty() ^ true) && a((FormItem.i) formItem));
                String valueOf = String.valueOf(b12.size());
                p b13 = b((FormItem.i) formItem);
                if (!z24 || com.sumsub.sns.internal.core.presentation.util.a.a(b13, valueOf)) {
                    return true;
                }
            } else {
                if (formItem instanceof FormItem.f) {
                    z16 = true;
                } else {
                    z16 = formItem instanceof FormItem.h;
                }
                if (z16) {
                    z17 = true;
                } else {
                    z17 = formItem instanceof FormItem.l;
                }
                if (z17) {
                    z18 = true;
                } else {
                    z18 = formItem instanceof FormItem.o;
                }
                if (z18) {
                    z19 = true;
                } else {
                    z19 = formItem instanceof FormItem.r;
                }
                if (z19) {
                    return true;
                }
                throw new NoWhenBranchMatchedException();
            }
            return false;
        }
    }

    public static final boolean a(FormItem.i iVar) {
        p a11 = g.a(iVar.d());
        if (a11 != null) {
            boolean z11 = (a11 instanceof p.d) && ((int) ((p.d) a11).a().d()) > 0;
            boolean z12 = (a11 instanceof p.j) && ((p.j) a11).a() > 0.0d;
            if (z11 || z12) {
                return true;
            }
        }
        return false;
    }

    public static final String a(FieldError fieldError, b.c cVar) {
        int i11 = C0292a.f30963a[fieldError.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            } else if (cVar != null) {
                return cVar.c();
            }
        } else if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public static final FormItem a(FormItem.k kVar) {
        return new FormItem.h("internal." + kVar.e(), new k(kVar.d().p() + ".countryCode", (String) null, (String) null, FieldType.text.name(), Boolean.FALSE, (String) null, (String) null, (String) null, (List) null, (int) TXVodDownloadDataSource.QUALITY_480P, (r) null));
    }

    public static final FieldId a(FormItem formItem) {
        String e11 = formItem.e();
        String str = "";
        if (e11 == null) {
            e11 = str;
        }
        String p11 = formItem.d().p();
        if (p11 != null) {
            str = p11;
        }
        return new FieldId(e11, str);
    }
}
