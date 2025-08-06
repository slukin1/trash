package v;

import androidx.camera.core.impl.Quirk;
import androidx.camera.extensions.internal.compat.quirk.CrashWhenOnDisableTooSoon;
import androidx.camera.extensions.internal.compat.quirk.ExtensionDisabledQuirk;
import androidx.camera.extensions.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.extensions.internal.compat.quirk.GetAvailableKeysNeedsOnInit;
import java.util.ArrayList;
import java.util.List;

public class b {
    public static List<Quirk> a() {
        ArrayList arrayList = new ArrayList();
        if (ExtensionDisabledQuirk.e()) {
            arrayList.add(new ExtensionDisabledQuirk());
        }
        if (CrashWhenOnDisableTooSoon.c()) {
            arrayList.add(new CrashWhenOnDisableTooSoon());
        }
        if (GetAvailableKeysNeedsOnInit.c()) {
            arrayList.add(new GetAvailableKeysNeedsOnInit());
        }
        if (c.c()) {
            arrayList.add(new c());
        }
        if (ExtraSupportedSurfaceCombinationsQuirk.c()) {
            arrayList.add(new ExtraSupportedSurfaceCombinationsQuirk());
        }
        return arrayList;
    }
}
