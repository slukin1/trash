package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.hardware.input.InputManager;
import android.view.InputDevice;
import com.sumsub.sns.internal.fingerprint.tools.threading.safe.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class x implements w {

    /* renamed from: a  reason: collision with root package name */
    public final InputManager f34652a;

    public static final class a extends Lambda implements d10.a<List<? extends v>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f34653a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(x xVar) {
            super(0);
            this.f34653a = xVar;
        }

        /* renamed from: a */
        public final List<v> invoke() {
            int[] inputDeviceIds;
            InputManager a11 = this.f34653a.f34652a;
            if (a11 == null || (inputDeviceIds = a11.getInputDeviceIds()) == null) {
                return CollectionsKt__CollectionsKt.k();
            }
            x xVar = this.f34653a;
            ArrayList arrayList = new ArrayList(inputDeviceIds.length);
            for (int inputDevice : inputDeviceIds) {
                InputDevice inputDevice2 = xVar.f34652a.getInputDevice(inputDevice);
                String str = null;
                String valueOf = String.valueOf(inputDevice2 != null ? Integer.valueOf(inputDevice2.getVendorId()) : null);
                if (inputDevice2 != null) {
                    str = inputDevice2.getName();
                }
                if (str == null) {
                    str = "";
                }
                arrayList.add(new v(str, valueOf));
            }
            return arrayList;
        }
    }

    public x(InputManager inputManager) {
        this.f34652a = inputManager;
    }

    public List<v> a() {
        Object a11 = c.a(0, new a(this), 1, (Object) null);
        List k11 = CollectionsKt__CollectionsKt.k();
        if (Result.m3078isFailureimpl(a11)) {
            a11 = k11;
        }
        return (List) a11;
    }
}
