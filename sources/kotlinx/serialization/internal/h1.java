package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.f;

public final class h1 {
    public static final void a(int i11, int i12, f fVar) {
        ArrayList arrayList = new ArrayList();
        int i13 = (~i11) & i12;
        for (int i14 = 0; i14 < 32; i14++) {
            if ((i13 & 1) != 0) {
                arrayList.add(fVar.f(i14));
            }
            i13 >>>= 1;
        }
        throw new MissingFieldException((List<String>) arrayList, fVar.h());
    }
}
