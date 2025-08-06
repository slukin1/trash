package kotlinx.serialization;

import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.d;

public interface g<T> {
    f getDescriptor();

    void serialize(d dVar, T t11);
}
