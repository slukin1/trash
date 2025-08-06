package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

public final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    public final LocaleList f8412a;

    public k(Object obj) {
        this.f8412a = (LocaleList) obj;
    }

    public String a() {
        return this.f8412a.toLanguageTags();
    }

    public Object b() {
        return this.f8412a;
    }

    public boolean equals(Object obj) {
        return this.f8412a.equals(((j) obj).b());
    }

    public Locale get(int i11) {
        return this.f8412a.get(i11);
    }

    public int hashCode() {
        return this.f8412a.hashCode();
    }

    public boolean isEmpty() {
        return this.f8412a.isEmpty();
    }

    public int size() {
        return this.f8412a.size();
    }

    public String toString() {
        return this.f8412a.toString();
    }
}
