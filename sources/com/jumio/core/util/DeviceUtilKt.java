package com.jumio.core.util;

import com.jumio.core.ServiceLocator;
import com.jumio.core.interfaces.DeviceUtilInterface;
import jumio.core.t0;
import kotlin.jvm.internal.Lambda;

public final class DeviceUtilKt {

    public static final class a extends Lambda implements d10.a<DeviceUtilInterface> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f39504a = new a();

        public a() {
            super(0);
        }

        public final Object invoke() {
            return new t0();
        }
    }

    public static final DeviceUtilInterface getDeviceUtil() {
        return (DeviceUtilInterface) ServiceLocator.INSTANCE.getServiceImplementation(DeviceUtilInterface.class, a.f39504a);
    }
}
