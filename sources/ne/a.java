package ne;

import com.hbg.module.libkt.custom.indicator.navigator.model.PositionData;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25318a = new a();

    public final int a(float f11, int i11, int i12) {
        int i13 = (i11 >> 24) & 255;
        int i14 = (i11 >> 16) & 255;
        int i15 = (i11 >> 8) & 255;
        int i16 = i11 & 255;
        return ((i13 + ((int) (((float) (((i12 >> 24) & 255) - i13)) * f11))) << 24) | ((i14 + ((int) (((float) (((i12 >> 16) & 255) - i14)) * f11))) << 16) | ((i15 + ((int) (((float) (((i12 >> 8) & 255) - i15)) * f11))) << 8) | (i16 + ((int) (f11 * ((float) ((i12 & 255) - i16)))));
    }

    public final PositionData b(List<? extends PositionData> list, int i11) {
        PositionData positionData;
        if (i11 >= 0 && i11 <= list.size() - 1) {
            return (PositionData) list.get(i11);
        }
        PositionData positionData2 = new PositionData();
        if (i11 < 0) {
            positionData = (PositionData) list.get(0);
        } else {
            i11 = (i11 - list.size()) + 1;
            positionData = (PositionData) list.get(list.size() - 1);
        }
        positionData2.o(positionData.f() + (positionData.r() * i11));
        positionData2.q(positionData.h());
        positionData2.p(positionData.g() + (positionData.r() * i11));
        positionData2.j(positionData.a());
        positionData2.l(positionData.c() + (positionData.r() * i11));
        positionData2.n(positionData.e());
        positionData2.m(positionData.d() + (i11 * positionData.r()));
        positionData2.k(positionData.b());
        return positionData2;
    }
}
