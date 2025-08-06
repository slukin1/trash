package com.mob.commons.cc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private String f27192a;

    /* renamed from: b  reason: collision with root package name */
    private int f27193b;

    /* renamed from: c  reason: collision with root package name */
    private s f27194c;

    /* renamed from: d  reason: collision with root package name */
    private int f27195d;

    /* renamed from: e  reason: collision with root package name */
    private int f27196e;

    /* renamed from: f  reason: collision with root package name */
    private w f27197f;

    public static class a implements t<a> {

        /* renamed from: a  reason: collision with root package name */
        public Throwable f27198a;

        /* renamed from: b  reason: collision with root package name */
        public Object f27199b;

        public boolean a() {
            return this.f27198a != null;
        }

        public boolean a(a aVar, Class<a> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
            if ("isError".equals(str) && objArr.length == 0) {
                objArr2[0] = Boolean.valueOf(aVar.a());
                return true;
            } else if ("getError".equals(str) && objArr.length == 0) {
                objArr2[0] = aVar.f27198a;
                return true;
            } else if (!"getResult".equals(str) || objArr.length != 0) {
                return false;
            } else {
                objArr2[0] = aVar.f27199b;
                return true;
            }
        }
    }

    public z(String str, int i11, ArrayList<y> arrayList, ArrayList<Object> arrayList2, int i12, int i13, s sVar) {
        this.f27192a = str;
        this.f27193b = i11;
        this.f27197f = new w(arrayList, arrayList2);
        this.f27195d = i12;
        this.f27196e = i13;
        this.f27194c = sVar;
    }

    public z a(s sVar, String str, int i11) {
        if (this.f27193b <= 1) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        a(str, i11, arrayList, 0);
        return new z((String) null, 1, arrayList, new ArrayList(), 0, arrayList.size(), sVar);
    }

    public LinkedList<Object> b(Object... objArr) throws Throwable {
        s b11 = this.f27194c.b();
        int i11 = this.f27193b;
        if (i11 != 0) {
            if (objArr.length == i11) {
                for (int length = objArr.length - 1; length >= 0; length--) {
                    b11.a(objArr[length]);
                }
            } else if (objArr.length < i11) {
                for (int length2 = objArr.length; length2 < this.f27193b; length2++) {
                    b11.a((Object) null);
                }
                for (int length3 = objArr.length - 1; length3 >= 0; length3--) {
                    b11.a(objArr[length3]);
                }
            } else {
                ArrayList arrayList = new ArrayList(0);
                for (int i12 = this.f27193b - 1; i12 < objArr.length; i12++) {
                    arrayList.add(objArr[i12]);
                }
                b11.a((Object) arrayList);
                for (int i13 = this.f27193b - 2; i13 >= 0; i13--) {
                    b11.a(objArr[i13]);
                }
            }
        }
        LinkedList<Object> linkedList = new LinkedList<>();
        this.f27197f.a(this.f27195d, this.f27196e, b11, linkedList);
        return linkedList;
    }

    private void a(String str, int i11, ArrayList<y> arrayList, int i12) {
        if (i12 != 0) {
            y yVar = new y(29);
            yVar.f27167b = str;
            yVar.f27168c = i11;
            yVar.f27174i = 1;
            arrayList.add(yVar);
        }
        y yVar2 = new y(1);
        yVar2.f27167b = str;
        yVar2.f27168c = i11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("arg");
        int i13 = i12 + 1;
        sb2.append(i13);
        yVar2.f27173h = sb2.toString();
        arrayList.add(yVar2);
        int i14 = this.f27193b;
        if (i12 >= i14 - 1) {
            for (int i15 = i14 - 1; i15 >= 0; i15 += -1) {
                y yVar3 = new y(3);
                yVar3.f27167b = str;
                yVar3.f27168c = i11;
                yVar3.f27173h = "arg" + (i15 + 1);
                arrayList.add(yVar3);
            }
            if (this.f27192a == null) {
                y yVar4 = new y(2);
                yVar4.f27167b = str;
                yVar4.f27168c = i11;
                yVar4.f27182q = this;
                arrayList.add(yVar4);
                y yVar5 = new y(32);
                yVar5.f27167b = str;
                yVar5.f27168c = i11;
                yVar5.f27174i = this.f27193b;
                arrayList.add(yVar5);
            } else {
                y yVar6 = new y(31);
                yVar6.f27167b = str;
                yVar6.f27168c = i11;
                yVar6.f27173h = this.f27192a;
                yVar6.f27174i = this.f27193b;
                arrayList.add(yVar6);
            }
            Iterator<y> it2 = this.f27197f.a().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().f27166a == 28) {
                        y yVar7 = new y(28);
                        yVar7.f27167b = str;
                        yVar7.f27168c = i11;
                        arrayList.add(yVar7);
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            a(str, i11, arrayList, i13);
            y yVar8 = new y(28);
            yVar8.f27167b = str;
            yVar8.f27168c = i11;
            arrayList.add(yVar8);
        }
        if (i12 != 0) {
            y yVar9 = new y(30);
            yVar9.f27167b = str;
            yVar9.f27168c = i11;
            arrayList.add(yVar9);
        }
    }

    public a a(Object... objArr) {
        a aVar = new a();
        try {
            LinkedList<Object> b11 = b(objArr);
            if (!b11.isEmpty()) {
                aVar.f27199b = b11.get(0);
            }
        } catch (Throwable th2) {
            aVar.f27198a = th2;
        }
        return aVar;
    }

    public static z a(String str, int i11, ArrayList<y> arrayList, ArrayList<Object> arrayList2, int i12, int i13, s sVar) {
        return new z(str, i11, arrayList, arrayList2, i12, i13, sVar) {
            public LinkedList<Object> b(Object... objArr) throws Throwable {
                return new LinkedList<>();
            }
        };
    }
}
