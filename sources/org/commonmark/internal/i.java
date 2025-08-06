package org.commonmark.internal;

import d20.a;
import d20.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.node.Text;

public class i implements a {

    /* renamed from: a  reason: collision with root package name */
    public final char f59743a;

    /* renamed from: b  reason: collision with root package name */
    public int f59744b = 0;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<a> f59745c = new LinkedList<>();

    public i(char c11) {
        this.f59743a = c11;
    }

    public char a() {
        return this.f59743a;
    }

    public int b() {
        return this.f59744b;
    }

    public int c(b bVar, b bVar2) {
        return g(bVar.length()).c(bVar, bVar2);
    }

    public char d() {
        return this.f59743a;
    }

    public void e(Text text, Text text2, int i11) {
        g(i11).e(text, text2, i11);
    }

    public void f(a aVar) {
        boolean z11;
        int b11;
        int b12 = aVar.b();
        ListIterator listIterator = this.f59745c.listIterator();
        do {
            if (listIterator.hasNext()) {
                b11 = ((a) listIterator.next()).b();
                if (b12 > b11) {
                    listIterator.previous();
                    listIterator.add(aVar);
                    z11 = true;
                }
            } else {
                z11 = false;
            }
            if (!z11) {
                this.f59745c.add(aVar);
                this.f59744b = b12;
                return;
            }
            return;
        } while (b12 != b11);
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f59743a + "' and minimum length " + b12);
    }

    public final a g(int i11) {
        Iterator it2 = this.f59745c.iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            if (aVar.b() <= i11) {
                return aVar;
            }
        }
        return this.f59745c.getFirst();
    }
}
