package com.sumsub.sns.internal.core.presentation.form.model;

import d10.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import kotlin.l;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f33838a = 2;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, p<Boolean, Boolean, Boolean>> f33839b = MapsKt__MapsKt.l(l.a("&&", a.f33840a), l.a("||", b.f33841a));

    public static final class a extends Lambda implements p<Boolean, Boolean, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33840a = new a();

        public a() {
            super(2);
        }

        public final Boolean a(boolean z11, boolean z12) {
            return Boolean.valueOf(z11 && z12);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
        }
    }

    public static final class b extends Lambda implements p<Boolean, Boolean, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f33841a = new b();

        public b() {
            super(2);
        }

        public final Boolean a(boolean z11, boolean z12) {
            return Boolean.valueOf(z12 || z11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
        }
    }

    public final Boolean a(Stack<Boolean> stack, p<? super Boolean, ? super Boolean, Boolean> pVar) {
        return stack.push(pVar.invoke(stack.pop(), stack.pop()));
    }

    public final int b(String str) {
        return x.b(str, "&&") ? 2 : 1;
    }

    public final boolean c(String str) {
        ArrayList<String> a11 = a(StringsKt__StringsKt.i1(str).toString());
        if (a11.isEmpty()) {
            return false;
        }
        Stack stack = new Stack();
        Iterator<String> it2 = a11.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            p pVar = this.f33839b.get(next);
            if (pVar == null) {
                stack.push(Boolean.valueOf(Boolean.parseBoolean(next)));
            } else if (stack.size() < this.f33838a) {
                return true;
            } else {
                a(stack, pVar);
            }
        }
        return ((Boolean) stack.pop()).booleanValue();
    }

    public final ArrayList<String> a(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null || StringsKt__StringsJVMKt.z(str)) {
            return arrayList;
        }
        Stack stack = new Stack();
        for (String str2 : StringsKt__StringsKt.L0(str, new String[]{" "}, false, 0, 6, (Object) null)) {
            if (this.f33839b.containsKey(str2)) {
                while (!stack.isEmpty() && b((String) stack.peek()) >= b(str2)) {
                    arrayList.add(stack.pop());
                }
                stack.push(str2);
            } else if (x.b(str2, "(")) {
                stack.push(str2);
            } else if (x.b(str2, ")")) {
                while (!((String) stack.peek()).equals("(")) {
                    arrayList.add(stack.pop());
                }
                stack.pop();
            } else {
                arrayList.add(str2);
            }
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
