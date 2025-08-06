package androidx.datastore.preferences.core;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\b\u0005B\t\b\u0000¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0007H&J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0000¨\u0006\u000e"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "", "T", "Landroidx/datastore/preferences/core/Preferences$a;", "key", "b", "(Landroidx/datastore/preferences/core/Preferences$a;)Ljava/lang/Object;", "", "a", "Landroidx/datastore/preferences/core/MutablePreferences;", "c", "d", "<init>", "()V", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public abstract class Preferences {

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0000\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/datastore/preferences/core/Preferences$a;", "T", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f8967a;

        public a(String str) {
            this.f8967a = str;
        }

        public final String a() {
            return this.f8967a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return x.b(this.f8967a, ((a) obj).f8967a);
            }
            return false;
        }

        public int hashCode() {
            return this.f8967a.hashCode();
        }

        public String toString() {
            return this.f8967a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001a\u0010\u000b\u001a\u00028\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\f"}, d2 = {"Landroidx/datastore/preferences/core/Preferences$b;", "T", "", "Landroidx/datastore/preferences/core/Preferences$a;", "a", "Landroidx/datastore/preferences/core/Preferences$a;", "()Landroidx/datastore/preferences/core/Preferences$a;", "key", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "value", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
    public static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final a<T> f8968a;

        /* renamed from: b  reason: collision with root package name */
        public final T f8969b;

        public final a<T> a() {
            return this.f8968a;
        }

        public final T b() {
            return this.f8969b;
        }
    }

    public abstract Map<a<?>, Object> a();

    public abstract <T> T b(a<T> aVar);

    public final MutablePreferences c() {
        return new MutablePreferences(MapsKt__MapsKt.y(a()), false);
    }

    public final Preferences d() {
        return new MutablePreferences(MapsKt__MapsKt.y(a()), true);
    }
}
