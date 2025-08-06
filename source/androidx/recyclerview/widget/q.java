package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public final a f10913a;

    public interface a {
        a.b a(int i11, int i12, int i13, Object obj);

        void b(a.b bVar);
    }

    public q(a aVar) {
        this.f10913a = aVar;
    }

    public final int a(List<a.b> list) {
        boolean z11 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f10810a != 8) {
                z11 = true;
            } else if (z11) {
                return size;
            }
        }
        return -1;
    }

    public void b(List<a.b> list) {
        while (true) {
            int a11 = a(list);
            if (a11 != -1) {
                d(list, a11, a11 + 1);
            } else {
                return;
            }
        }
    }

    public final void c(List<a.b> list, int i11, a.b bVar, int i12, a.b bVar2) {
        int i13 = bVar.f10813d;
        int i14 = bVar2.f10811b;
        int i15 = i13 < i14 ? -1 : 0;
        int i16 = bVar.f10811b;
        if (i16 < i14) {
            i15++;
        }
        if (i14 <= i16) {
            bVar.f10811b = i16 + bVar2.f10813d;
        }
        int i17 = bVar2.f10811b;
        if (i17 <= i13) {
            bVar.f10813d = i13 + bVar2.f10813d;
        }
        bVar2.f10811b = i17 + i15;
        list.set(i11, bVar2);
        list.set(i12, bVar);
    }

    public final void d(List<a.b> list, int i11, int i12) {
        a.b bVar = list.get(i11);
        a.b bVar2 = list.get(i12);
        int i13 = bVar2.f10810a;
        if (i13 == 1) {
            c(list, i11, bVar, i12, bVar2);
        } else if (i13 == 2) {
            e(list, i11, bVar, i12, bVar2);
        } else if (i13 == 4) {
            f(list, i11, bVar, i12, bVar2);
        }
    }

    public void e(List<a.b> list, int i11, a.b bVar, int i12, a.b bVar2) {
        boolean z11;
        int i13 = bVar.f10811b;
        int i14 = bVar.f10813d;
        boolean z12 = false;
        if (i13 < i14) {
            if (bVar2.f10811b == i13 && bVar2.f10813d == i14 - i13) {
                z11 = false;
                z12 = true;
            } else {
                z11 = false;
            }
        } else if (bVar2.f10811b == i14 + 1 && bVar2.f10813d == i13 - i14) {
            z11 = true;
            z12 = true;
        } else {
            z11 = true;
        }
        int i15 = bVar2.f10811b;
        if (i14 < i15) {
            bVar2.f10811b = i15 - 1;
        } else {
            int i16 = bVar2.f10813d;
            if (i14 < i15 + i16) {
                bVar2.f10813d = i16 - 1;
                bVar.f10810a = 2;
                bVar.f10813d = 1;
                if (bVar2.f10813d == 0) {
                    list.remove(i12);
                    this.f10913a.b(bVar2);
                    return;
                }
                return;
            }
        }
        int i17 = bVar.f10811b;
        int i18 = bVar2.f10811b;
        a.b bVar3 = null;
        if (i17 <= i18) {
            bVar2.f10811b = i18 + 1;
        } else {
            int i19 = bVar2.f10813d;
            if (i17 < i18 + i19) {
                bVar3 = this.f10913a.a(2, i17 + 1, (i18 + i19) - i17, (Object) null);
                bVar2.f10813d = bVar.f10811b - bVar2.f10811b;
            }
        }
        if (z12) {
            list.set(i11, bVar2);
            list.remove(i12);
            this.f10913a.b(bVar);
            return;
        }
        if (z11) {
            if (bVar3 != null) {
                int i21 = bVar.f10811b;
                if (i21 > bVar3.f10811b) {
                    bVar.f10811b = i21 - bVar3.f10813d;
                }
                int i22 = bVar.f10813d;
                if (i22 > bVar3.f10811b) {
                    bVar.f10813d = i22 - bVar3.f10813d;
                }
            }
            int i23 = bVar.f10811b;
            if (i23 > bVar2.f10811b) {
                bVar.f10811b = i23 - bVar2.f10813d;
            }
            int i24 = bVar.f10813d;
            if (i24 > bVar2.f10811b) {
                bVar.f10813d = i24 - bVar2.f10813d;
            }
        } else {
            if (bVar3 != null) {
                int i25 = bVar.f10811b;
                if (i25 >= bVar3.f10811b) {
                    bVar.f10811b = i25 - bVar3.f10813d;
                }
                int i26 = bVar.f10813d;
                if (i26 >= bVar3.f10811b) {
                    bVar.f10813d = i26 - bVar3.f10813d;
                }
            }
            int i27 = bVar.f10811b;
            if (i27 >= bVar2.f10811b) {
                bVar.f10811b = i27 - bVar2.f10813d;
            }
            int i28 = bVar.f10813d;
            if (i28 >= bVar2.f10811b) {
                bVar.f10813d = i28 - bVar2.f10813d;
            }
        }
        list.set(i11, bVar2);
        if (bVar.f10811b != bVar.f10813d) {
            list.set(i12, bVar);
        } else {
            list.remove(i12);
        }
        if (bVar3 != null) {
            list.add(i11, bVar3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f10813d
            int r1 = r13.f10811b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000d
            int r1 = r1 - r4
            r13.f10811b = r1
            goto L_0x0020
        L_0x000d:
            int r5 = r13.f10813d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0020
            int r5 = r5 - r4
            r13.f10813d = r5
            androidx.recyclerview.widget.q$a r0 = r8.f10913a
            int r1 = r11.f10811b
            java.lang.Object r5 = r13.f10812c
            androidx.recyclerview.widget.a$b r0 = r0.a(r2, r1, r4, r5)
            goto L_0x0021
        L_0x0020:
            r0 = r3
        L_0x0021:
            int r1 = r11.f10811b
            int r5 = r13.f10811b
            if (r1 > r5) goto L_0x002b
            int r5 = r5 + r4
            r13.f10811b = r5
            goto L_0x0041
        L_0x002b:
            int r6 = r13.f10813d
            int r7 = r5 + r6
            if (r1 >= r7) goto L_0x0041
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.q$a r3 = r8.f10913a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f10812c
            androidx.recyclerview.widget.a$b r3 = r3.a(r2, r1, r5, r4)
            int r1 = r13.f10813d
            int r1 = r1 - r5
            r13.f10813d = r1
        L_0x0041:
            r9.set(r12, r11)
            int r11 = r13.f10813d
            if (r11 <= 0) goto L_0x004c
            r9.set(r10, r13)
            goto L_0x0054
        L_0x004c:
            r9.remove(r10)
            androidx.recyclerview.widget.q$a r11 = r8.f10913a
            r11.b(r13)
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r9.add(r10, r0)
        L_0x0059:
            if (r3 == 0) goto L_0x005e
            r9.add(r10, r3)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.q.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
