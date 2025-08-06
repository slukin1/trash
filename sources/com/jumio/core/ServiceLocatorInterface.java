package com.jumio.core;

import android.content.Context;
import com.jumio.commons.camera.CameraManagerInterface;
import com.jumio.core.extraction.DefaultExtractionUpdate;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.image.ImageStoreInterface;
import com.jumio.core.interfaces.DeviceUtilInterface;
import com.jumio.core.interfaces.QAInterface;
import com.jumio.core.network.TrustManagerInterface;
import java.util.Map;
import jumio.core.a;
import jumio.core.d2;
import jumio.core.e2;
import jumio.core.j;
import jumio.core.s0;
import jumio.core.t0;
import jumio.core.u0;
import jumio.core.v0;
import jumio.core.x0;
import kotlin.Pair;
import kotlin.l;

public interface ServiceLocatorInterface {

    public static final class DefaultImpls {
        public static /* synthetic */ void bindReflectionClass$default(ServiceLocatorInterface serviceLocatorInterface, String str, String str2, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 4) != 0) {
                    i11 = serviceLocatorInterface.getPRIORITY_DEFAULT();
                }
                serviceLocatorInterface.bindReflectionClass(str, str2, i11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindReflectionClass");
        }

        public static /* synthetic */ void bindServiceClass$default(ServiceLocatorInterface serviceLocatorInterface, Class cls, Class cls2, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 4) != 0) {
                    i11 = serviceLocatorInterface.getPRIORITY_DEFAULT();
                }
                serviceLocatorInterface.bindServiceClass(cls, cls2, i11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindServiceClass");
        }

        public static /* synthetic */ void bindServiceInstance$default(ServiceLocatorInterface serviceLocatorInterface, Class cls, Object obj, int i11, int i12, Object obj2) {
            if (obj2 == null) {
                if ((i12 & 4) != 0) {
                    i11 = serviceLocatorInterface.getPRIORITY_DEFAULT();
                }
                serviceLocatorInterface.bindServiceInstance(cls, obj, i11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindServiceInstance");
        }

        public static Map<String, Pair<Integer, Class<?>>> getDefaultClassMappings(ServiceLocatorInterface serviceLocatorInterface, ServiceLocatorInterface serviceLocatorInterface2) {
            return MapsKt__MapsKt.l(l.a(ExtractionUpdateInterface.class.getName(), new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), DefaultExtractionUpdate.class)), l.a(TrustManagerInterface.class.getName(), new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), a.class)), l.a(ImageStoreInterface.class.getName(), new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), x0.class)));
        }

        public static Map<String, Pair<Integer, Object>> getDefaultInstanceMappings(ServiceLocatorInterface serviceLocatorInterface, ServiceLocatorInterface serviceLocatorInterface2) {
            return MapsKt__MapsKt.l(l.a(e2.class.getName(), new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), new u0())), l.a(j.class.getName(), new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), new s0())), l.a(DeviceUtilInterface.class.getName(), new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), new t0())), l.a(QAInterface.class.getName(), new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), new v0())));
        }

        public static Map<String, Pair<Integer, d2>> getDefaultPluginMappings(ServiceLocatorInterface serviceLocatorInterface, ServiceLocatorInterface serviceLocatorInterface2) {
            return MapsKt__MapsJVMKt.e(l.a(CameraManagerInterface.class.getName(), new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), d2.CAMERA_X)));
        }

        public static Map<String, Pair<Integer, String>> getDefaultReflectionMappings(ServiceLocatorInterface serviceLocatorInterface, ServiceLocatorInterface serviceLocatorInterface2) {
            return MapsKt__MapsJVMKt.e(l.a("com.jumio.core.extraction.nfc.core.NfcControllerInterface", new Pair(Integer.valueOf(serviceLocatorInterface2.getPRIORITY_DEFAULT()), "com.jumio.core.extraction.nfc.core.DefaultNfcController")));
        }

        public static int getPRIORITY_DEFAULT(ServiceLocatorInterface serviceLocatorInterface) {
            return 0;
        }

        public static int getPRIORITY_MAX(ServiceLocatorInterface serviceLocatorInterface) {
            return 99;
        }

        public static int getPRIORITY_MIDDLE(ServiceLocatorInterface serviceLocatorInterface) {
            return 49;
        }

        public static /* synthetic */ Object getServiceImplementation$default(ServiceLocatorInterface serviceLocatorInterface, Class cls, d10.a aVar, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    aVar = null;
                }
                return serviceLocatorInterface.getServiceImplementation(cls, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getServiceImplementation");
        }

        public static /* synthetic */ boolean unbind$default(ServiceLocatorInterface serviceLocatorInterface, Class cls, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = serviceLocatorInterface.getPRIORITY_DEFAULT();
                }
                return serviceLocatorInterface.unbind(cls, i11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unbind");
        }
    }

    void bindReflectionClass(String str, String str2, int i11);

    <T> void bindServiceClass(Class<T> cls, Class<? extends T> cls2, int i11);

    <T> void bindServiceInstance(Class<T> cls, T t11, int i11);

    void destroy();

    Map<String, Pair<Integer, Class<?>>> getDefaultClassMappings(ServiceLocatorInterface serviceLocatorInterface);

    Map<String, Pair<Integer, Object>> getDefaultInstanceMappings(ServiceLocatorInterface serviceLocatorInterface);

    Map<String, Pair<Integer, d2>> getDefaultPluginMappings(ServiceLocatorInterface serviceLocatorInterface);

    Map<String, Pair<Integer, String>> getDefaultReflectionMappings(ServiceLocatorInterface serviceLocatorInterface);

    int getPRIORITY_DEFAULT();

    int getPRIORITY_MAX();

    int getPRIORITY_MIDDLE();

    <T> T getServiceImplementation(Class<T> cls, d10.a<? extends T> aVar);

    void init(Context context);

    boolean unbind(Class<?> cls, int i11);
}
