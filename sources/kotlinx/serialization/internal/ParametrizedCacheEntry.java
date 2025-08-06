package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlinx.serialization.b;

final class ParametrizedCacheEntry<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<List<o0>, Result<b<T>>> f57668a = new ConcurrentHashMap<>();
}
