package kotlinx.serialization;

import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;

public interface a<T> {
    T deserialize(c cVar);

    f getDescriptor();
}
