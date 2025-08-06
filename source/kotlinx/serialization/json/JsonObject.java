package kotlinx.serialization.json;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.b;
import kotlinx.serialization.f;

@f(with = s.class)
public final class JsonObject extends g implements Map<String, g>, e10.a {
    public static final a Companion = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, g> f57825b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final b<JsonObject> serializer() {
            return s.f57950a;
        }
    }

    public JsonObject(Map<String, ? extends g> map) {
        super((r) null);
        this.f57825b = map;
    }

    public boolean a(String str) {
        return this.f57825b.containsKey(str);
    }

    public boolean c(g gVar) {
        return this.f57825b.containsValue(gVar);
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return a((String) obj);
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return c((g) obj);
    }

    public g d(String str) {
        return this.f57825b.get(str);
    }

    public final /* bridge */ Set<Map.Entry<String, g>> entrySet() {
        return h();
    }

    public boolean equals(Object obj) {
        return x.b(this.f57825b, obj);
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return d((String) obj);
    }

    public Set<Map.Entry<String, g>> h() {
        return this.f57825b.entrySet();
    }

    public int hashCode() {
        return this.f57825b.hashCode();
    }

    public Set<String> i() {
        return this.f57825b.keySet();
    }

    public boolean isEmpty() {
        return this.f57825b.isEmpty();
    }

    public int j() {
        return this.f57825b.size();
    }

    public Collection<g> k() {
        return this.f57825b.values();
    }

    public final /* bridge */ Set<String> keySet() {
        return i();
    }

    /* renamed from: l */
    public g remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map<? extends String, ? extends g> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(BiFunction<? super String, ? super g, ? extends g> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return j();
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.k0(this.f57825b.entrySet(), Constants.ACCEPT_TIME_SEPARATOR_SP, "{", "}", 0, (CharSequence) null, JsonObject$toString$1.INSTANCE, 24, (Object) null);
    }

    public final /* bridge */ Collection<g> values() {
        return k();
    }
}
