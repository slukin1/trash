package com.mob.commons.cc;

import com.google.common.net.HttpHeaders;
import com.mob.commons.cc.y;
import com.mob.commons.s;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Class<?>> f27153a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<y> f27154b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Object> f27155c;

    public w(ArrayList<y> arrayList, ArrayList<Object> arrayList2) {
        this.f27154b = arrayList;
        this.f27155c = arrayList2;
    }

    public void a(HashMap<String, Object> hashMap, u uVar) throws Throwable {
        s sVar = new s(hashMap, uVar);
        a(sVar);
        a(0, this.f27154b.size(), sVar, (List<Object>) null);
    }

    public void a(int i11, int i12, s sVar, List<Object> list) throws Throwable {
        String str;
        y.a aVar = new y.a();
        aVar.f27185a = i11;
        aVar.f27186b = sVar;
        aVar.f27187c = list;
        aVar.f27190f = this.f27154b;
        aVar.f27191g = this.f27155c;
        while (true) {
            try {
                if (aVar.f27185a >= i12) {
                    break;
                } else if (sVar.f()) {
                    aVar.f27188d = true;
                    break;
                } else {
                    this.f27154b.get(aVar.f27185a).a(aVar);
                    if (aVar.f27189e) {
                        break;
                    }
                    aVar.f27185a++;
                }
            } catch (Throwable th2) {
                th = th2;
                if (th instanceof v) {
                    str = th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage();
                    th = th.getCause();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Suba Runtime Error: ");
                    sb2.append(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage());
                    str = sb2.toString();
                }
                throw new v(str + "\r\n\tat " + this.f27154b.get(aVar.f27185a).f27167b + " (" + this.f27154b.get(aVar.f27185a).f27168c + ")", th);
            }
        }
        if (!aVar.f27188d && sVar.d() > 0 && list != null) {
            try {
                list.add(sVar.a());
            } catch (Throwable unused) {
            }
        }
    }

    private void a(s sVar) {
        Class<x> cls = x.class;
        Class<z> cls2 = z.class;
        sVar.a("Object", (Class<?>) Object.class);
        sVar.a("Class", (Class<?>) Class.class);
        sVar.a("Method", (Class<?>) Method.class);
        sVar.a("String", (Class<?>) String.class);
        sVar.a("Thread", (Class<?>) Thread.class);
        sVar.a(s.a("008^gjdgPeedHffAgf"), (Class<?>) Runnable.class);
        sVar.a(s.a("006Melecfi%if8df"), (Class<?>) System.class);
        sVar.a("File", (Class<?>) File.class);
        sVar.a("URL", (Class<?>) URL.class);
        sVar.a("Double", (Class<?>) Double.class);
        sVar.a("Float", (Class<?>) Float.class);
        sVar.a("Long", (Class<?>) Long.class);
        sVar.a("Integer", (Class<?>) Integer.class);
        sVar.a(s.a("005Eel2h:dkdj5i"), (Class<?>) Short.class);
        sVar.a("Byte", (Class<?>) Byte.class);
        sVar.a("Number", (Class<?>) Number.class);
        sVar.a(s.a("009TedYhd^djVdcifUdj"), (Class<?>) Character.class);
        sVar.a("Boolean", (Class<?>) Boolean.class);
        sVar.a(s.a("006=dcdkdgffGgf"), (Class<?>) Double.TYPE);
        sVar.a(s.a("005+efHgXdk+di"), (Class<?>) Float.TYPE);
        sVar.a("long", (Class<?>) Long.TYPE);
        sVar.a(s.a("0036diFei"), (Class<?>) Integer.TYPE);
        sVar.a("short", (Class<?>) Short.TYPE);
        sVar.a("byte", (Class<?>) Byte.TYPE);
        sVar.a(s.a("004chdUdj"), (Class<?>) Character.TYPE);
        sVar.a("boolean", (Class<?>) Boolean.TYPE);
        sVar.a("bigInt", (Class<?>) BigInteger.class);
        sVar.a("BigInteger", (Class<?>) BigInteger.class);
        sVar.a("bigDec", (Class<?>) BigDecimal.class);
        sVar.a("BigDecimal", (Class<?>) BigDecimal.class);
        sVar.a("List", (Class<?>) List.class);
        sVar.a("Map", (Class<?>) Map.class);
        sVar.a("Function", (Class<?>) cls2);
        sVar.a("fun", (Class<?>) cls2);
        sVar.a(HttpHeaders.RANGE, (Class<?>) aa.class);
        sVar.a("Array", (Class<?>) Array.class);
        sVar.a("Suba", (Class<?>) cls);
        sVar.a("VM", (Class<?>) cls);
        for (Map.Entry next : f27153a.entrySet()) {
            sVar.a((String) next.getKey(), (Class<?>) (Class) next.getValue());
        }
    }

    public ArrayList<y> a() {
        return this.f27154b;
    }
}
