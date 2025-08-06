package jumio.liveness;

import com.jumio.core.models.LivenessSettingsModel;
import com.jumio.liveness.dto.Pitch;
import com.jumio.liveness.dto.Yaw;
import com.jumio.liveness.image.LivenessImageData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;

public final class p {
    public static final void a(LivenessImageData livenessImageData, r rVar, LivenessSettingsModel livenessSettingsModel) {
        Pitch pitch;
        Integer num = rVar.f56513f;
        Yaw yaw = null;
        if (num != null) {
            int intValue = num.intValue();
            pitch = new Pitch(intValue, Math.abs(((livenessSettingsModel.getMaximumPitch() + livenessSettingsModel.getMinimumPitch()) / 2) - intValue));
        } else {
            pitch = null;
        }
        livenessImageData.setPseudoPitch(pitch);
        Integer num2 = rVar.f56514g;
        if (num2 != null) {
            int intValue2 = num2.intValue();
            yaw = new Yaw(intValue2, Math.abs(((livenessSettingsModel.getMaximumYaw() + livenessSettingsModel.getMinimumYaw()) / 2) - intValue2));
        }
        livenessImageData.setPseudoYaw(yaw);
        livenessImageData.setIod(rVar.f56510c);
        livenessImageData.setRoi(rVar.f56509b);
        livenessImageData.setBestSelfie(false);
    }

    public static final void a(ArrayList arrayList, int i11, long j11) {
        boolean z11;
        if (arrayList.size() >= i11) {
            List P0 = CollectionsKt___CollectionsKt.P0(arrayList, i11, 1, false, 4, (Object) null);
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = P0.iterator();
            while (true) {
                boolean z12 = true;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                List R0 = CollectionsKt___CollectionsKt.R0((List) next);
                if (!(R0 instanceof Collection) || !R0.isEmpty()) {
                    Iterator it3 = R0.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Pair pair = (Pair) it3.next();
                        if (((k) pair.getSecond()).f56486a.f56481a - ((k) pair.getFirst()).f56486a.f56481a <= j11) {
                            z11 = true;
                            continue;
                        } else {
                            z11 = false;
                            continue;
                        }
                        if (!z11) {
                            z12 = false;
                            break;
                        }
                    }
                }
                if (z12) {
                    arrayList2.add(next);
                }
            }
            if (!arrayList2.isEmpty()) {
                Iterator it4 = arrayList2.iterator();
                if (it4.hasNext()) {
                    Object next2 = it4.next();
                    if (!it4.hasNext()) {
                        List list = (List) next2;
                        Iterator it5 = arrayList.iterator();
                    } else {
                        Iterator it6 = ((List) next2).iterator();
                        int i12 = 0;
                        while (true) {
                            int i13 = Integer.MAX_VALUE;
                            if (!it6.hasNext()) {
                                break;
                            }
                            Integer num = ((k) it6.next()).f56487b.f56511d;
                            if (num != null) {
                                i13 = num.intValue();
                            }
                            i12 += i13;
                        }
                        do {
                            Object next3 = it4.next();
                            int i14 = 0;
                            for (k kVar : (List) next3) {
                                Integer num2 = kVar.f56487b.f56511d;
                                i14 += num2 != null ? num2.intValue() : Integer.MAX_VALUE;
                            }
                            if (i12 > i14) {
                                next2 = next3;
                                i12 = i14;
                            }
                        } while (it4.hasNext());
                    }
                    List list2 = (List) next2;
                    Iterator it52 = arrayList.iterator();
                    while (it52.hasNext()) {
                        k kVar2 = (k) it52.next();
                        if (!list2.contains(kVar2)) {
                            kVar2.a();
                        }
                    }
                    arrayList.clear();
                    arrayList.addAll(list2);
                    return;
                }
                throw new NoSuchElementException();
            }
            Iterator it7 = arrayList.iterator();
            while (it7.hasNext()) {
                ((k) it7.next()).a();
            }
            arrayList.clear();
        }
    }
}
