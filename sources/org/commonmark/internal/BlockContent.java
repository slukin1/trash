package org.commonmark.internal;

class BlockContent {

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f59639a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    public int f59640b = 0;

    public void a(CharSequence charSequence) {
        if (this.f59640b != 0) {
            this.f59639a.append(10);
        }
        this.f59639a.append(charSequence);
        this.f59640b++;
    }

    public String b() {
        return this.f59639a.toString();
    }
}
