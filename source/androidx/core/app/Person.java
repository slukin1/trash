package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.share.internal.ShareConstants;

public class Person {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f8290a;

    /* renamed from: b  reason: collision with root package name */
    public IconCompat f8291b;

    /* renamed from: c  reason: collision with root package name */
    public String f8292c;

    /* renamed from: d  reason: collision with root package name */
    public String f8293d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8294e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8295f;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f8296a;

        /* renamed from: b  reason: collision with root package name */
        public IconCompat f8297b;

        /* renamed from: c  reason: collision with root package name */
        public String f8298c;

        /* renamed from: d  reason: collision with root package name */
        public String f8299d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8300e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8301f;

        public Person a() {
            return new Person(this);
        }

        public Builder b(boolean z11) {
            this.f8300e = z11;
            return this;
        }

        public Builder c(IconCompat iconCompat) {
            this.f8297b = iconCompat;
            return this;
        }

        public Builder d(boolean z11) {
            this.f8301f = z11;
            return this;
        }

        public Builder e(String str) {
            this.f8299d = str;
            return this;
        }

        public Builder f(CharSequence charSequence) {
            this.f8296a = charSequence;
            return this;
        }

        public Builder g(String str) {
            this.f8298c = str;
            return this;
        }
    }

    public static class a {
        public static Person a(android.app.Person person) {
            return new Builder().f(person.getName()).c(person.getIcon() != null ? IconCompat.c(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        public static android.app.Person b(Person person) {
            return new Person.Builder().setName(person.e()).setIcon(person.c() != null ? person.c().y() : null).setUri(person.f()).setKey(person.d()).setBot(person.g()).setImportant(person.h()).build();
        }
    }

    public Person(Builder builder) {
        this.f8290a = builder.f8296a;
        this.f8291b = builder.f8297b;
        this.f8292c = builder.f8298c;
        this.f8293d = builder.f8299d;
        this.f8294e = builder.f8300e;
        this.f8295f = builder.f8301f;
    }

    public static Person a(android.app.Person person) {
        return a.a(person);
    }

    public static Person b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new Builder().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.b(bundle2) : null).g(bundle.getString(ShareConstants.MEDIA_URI)).e(bundle.getString("key")).b(bundle.getBoolean("isBot")).d(bundle.getBoolean("isImportant")).a();
    }

    public IconCompat c() {
        return this.f8291b;
    }

    public String d() {
        return this.f8293d;
    }

    public CharSequence e() {
        return this.f8290a;
    }

    public String f() {
        return this.f8292c;
    }

    public boolean g() {
        return this.f8294e;
    }

    public boolean h() {
        return this.f8295f;
    }

    public String i() {
        String str = this.f8292c;
        if (str != null) {
            return str;
        }
        if (this.f8290a == null) {
            return "";
        }
        return "name:" + this.f8290a;
    }

    public android.app.Person j() {
        return a.b(this);
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f8290a);
        IconCompat iconCompat = this.f8291b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.x() : null);
        bundle.putString(ShareConstants.MEDIA_URI, this.f8292c);
        bundle.putString("key", this.f8293d);
        bundle.putBoolean("isBot", this.f8294e);
        bundle.putBoolean("isImportant", this.f8295f);
        return bundle;
    }
}
