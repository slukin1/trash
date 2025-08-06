package org.tensorflow.lite;

import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import org.tensorflow.lite.InterpreterApi;

public final class TensorFlowLite {
    private static final Throwable LOAD_LIBRARY_EXCEPTION;
    private static final String[][] TFLITE_RUNTIME_LIBNAMES;
    private static final AtomicBoolean[] haveLogged = new AtomicBoolean[InterpreterApi.Options.TfLiteRuntime.values().length];
    private static volatile boolean isInit = false;
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(InterpreterApi.class.getName());

    /* renamed from: org.tensorflow.lite.TensorFlowLite$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$tensorflow$lite$InterpreterApi$Options$TfLiteRuntime;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.tensorflow.lite.InterpreterApi$Options$TfLiteRuntime[] r0 = org.tensorflow.lite.InterpreterApi.Options.TfLiteRuntime.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$tensorflow$lite$InterpreterApi$Options$TfLiteRuntime = r0
                org.tensorflow.lite.InterpreterApi$Options$TfLiteRuntime r1 = org.tensorflow.lite.InterpreterApi.Options.TfLiteRuntime.FROM_APPLICATION_ONLY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$tensorflow$lite$InterpreterApi$Options$TfLiteRuntime     // Catch:{ NoSuchFieldError -> 0x001d }
                org.tensorflow.lite.InterpreterApi$Options$TfLiteRuntime r1 = org.tensorflow.lite.InterpreterApi.Options.TfLiteRuntime.FROM_SYSTEM_ONLY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.tensorflow.lite.TensorFlowLite.AnonymousClass1.<clinit>():void");
        }
    }

    public static class PossiblyAvailableRuntime {
        private final Exception exception;
        private final InterpreterFactoryApi factory;

        public PossiblyAvailableRuntime(String str, String str2) {
            InterpreterFactoryApi interpreterFactoryApi;
            Exception e11 = null;
            try {
                Constructor<?> declaredConstructor = Class.forName(str + ".InterpreterFactoryImpl").getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                interpreterFactoryApi = (InterpreterFactoryApi) declaredConstructor.newInstance(new Object[0]);
                if (interpreterFactoryApi != null) {
                    try {
                        TensorFlowLite.logger.info(String.format("Found %s TF Lite runtime client in %s", new Object[]{str2, str}));
                    } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e12) {
                        e11 = e12;
                        TensorFlowLite.logger.info(String.format("Didn't find %s TF Lite runtime client in %s", new Object[]{str2, str}));
                        this.exception = e11;
                        this.factory = interpreterFactoryApi;
                    }
                } else {
                    TensorFlowLite.logger.warning(String.format("Failed to construct TF Lite runtime client from %s", new Object[]{str}));
                }
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e13) {
                Exception exc = e13;
                interpreterFactoryApi = null;
                e11 = exc;
                TensorFlowLite.logger.info(String.format("Didn't find %s TF Lite runtime client in %s", new Object[]{str2, str}));
                this.exception = e11;
                this.factory = interpreterFactoryApi;
            }
            this.exception = e11;
            this.factory = interpreterFactoryApi;
        }

        public Exception getException() {
            return this.exception;
        }

        public InterpreterFactoryApi getFactory() {
            return this.factory;
        }
    }

    public static class RuntimeFromApplication {
        public static final PossiblyAvailableRuntime TFLITE = new PossiblyAvailableRuntime("org.tensorflow.lite", MimeTypes.BASE_TYPE_APPLICATION);

        private RuntimeFromApplication() {
        }
    }

    public static class RuntimeFromSystem {
        public static final PossiblyAvailableRuntime TFLITE = new PossiblyAvailableRuntime("com.google.android.gms.tflite", "system");

        private RuntimeFromSystem() {
        }
    }

    static {
        String[][] strArr = {new String[]{"tensorflowlite_jni", "tensorflowlite_jni_stable"}, new String[]{"tensorflowlite_jni_gms_client"}};
        TFLITE_RUNTIME_LIBNAMES = strArr;
        UnsatisfiedLinkError unsatisfiedLinkError = null;
        for (String[] strArr2 : strArr) {
            int length = strArr2.length;
            int i11 = 0;
            while (i11 < length) {
                String str = strArr2[i11];
                try {
                    System.loadLibrary(str);
                    logger.info("Loaded native library: " + str);
                    break;
                } catch (UnsatisfiedLinkError e11) {
                    logger.info("Didn't load native library: " + str);
                    if (unsatisfiedLinkError == null) {
                        unsatisfiedLinkError = e11;
                    } else {
                        unsatisfiedLinkError.addSuppressed(e11);
                    }
                    i11++;
                }
            }
        }
        LOAD_LIBRARY_EXCEPTION = unsatisfiedLinkError;
        for (int i12 = 0; i12 < InterpreterApi.Options.TfLiteRuntime.values().length; i12++) {
            haveLogged[i12] = new AtomicBoolean();
        }
    }

    private TensorFlowLite() {
    }

    public static InterpreterFactoryApi getFactory(InterpreterApi.Options.TfLiteRuntime tfLiteRuntime) {
        return getFactory(tfLiteRuntime, "org.tensorflow.lite.InterpreterApi.Options", "setRuntime");
    }

    public static void init() {
        if (!isInit) {
            try {
                nativeDoNothing();
                isInit = true;
            } catch (UnsatisfiedLinkError e11) {
                Throwable th2 = LOAD_LIBRARY_EXCEPTION;
                if (th2 == null) {
                    th2 = e11;
                }
                UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError("Failed to load native TensorFlow Lite methods. Check that the correct native libraries are present, and, if using a custom native library, have been properly loaded via System.loadLibrary():\n  " + th2);
                unsatisfiedLinkError.initCause(e11);
                throw unsatisfiedLinkError;
            }
        }
    }

    private static native void nativeDoNothing();

    public static String runtimeVersion(InterpreterApi.Options.TfLiteRuntime tfLiteRuntime) {
        return getFactory(tfLiteRuntime, "org.tensorflow.lite.TensorFlowLite", "runtimeVersion").runtimeVersion();
    }

    public static String schemaVersion(InterpreterApi.Options.TfLiteRuntime tfLiteRuntime) {
        return getFactory(tfLiteRuntime, "org.tensorflow.lite.TensorFlowLite", "schemaVersion").schemaVersion();
    }

    @Deprecated
    public static String version() {
        return schemaVersion();
    }

    private static InterpreterFactoryApi getFactory(InterpreterApi.Options.TfLiteRuntime tfLiteRuntime, String str, String str2) {
        Exception exc;
        String str3;
        if (tfLiteRuntime == null) {
            tfLiteRuntime = InterpreterApi.Options.TfLiteRuntime.FROM_APPLICATION_ONLY;
        }
        InterpreterApi.Options.TfLiteRuntime tfLiteRuntime2 = InterpreterApi.Options.TfLiteRuntime.PREFER_SYSTEM_OVER_APPLICATION;
        if (tfLiteRuntime == tfLiteRuntime2 || tfLiteRuntime == InterpreterApi.Options.TfLiteRuntime.FROM_SYSTEM_ONLY) {
            PossiblyAvailableRuntime possiblyAvailableRuntime = RuntimeFromSystem.TFLITE;
            if (possiblyAvailableRuntime.getFactory() != null) {
                if (!haveLogged[tfLiteRuntime.ordinal()].getAndSet(true)) {
                    logger.info(String.format("TfLiteRuntime.%s: Using system TF Lite runtime client from com.google.android.gms", new Object[]{tfLiteRuntime.name()}));
                }
                return possiblyAvailableRuntime.getFactory();
            }
            exc = possiblyAvailableRuntime.getException();
        } else {
            exc = null;
        }
        if (tfLiteRuntime == tfLiteRuntime2 || tfLiteRuntime == InterpreterApi.Options.TfLiteRuntime.FROM_APPLICATION_ONLY) {
            PossiblyAvailableRuntime possiblyAvailableRuntime2 = RuntimeFromApplication.TFLITE;
            if (possiblyAvailableRuntime2.getFactory() != null) {
                if (!haveLogged[tfLiteRuntime.ordinal()].getAndSet(true)) {
                    logger.info(String.format("TfLiteRuntime.%s: Using application TF Lite runtime client from org.tensorflow.lite", new Object[]{tfLiteRuntime.name()}));
                }
                return possiblyAvailableRuntime2.getFactory();
            } else if (exc == null) {
                exc = possiblyAvailableRuntime2.getException();
            } else if (exc.getSuppressed().length == 0) {
                exc.addSuppressed(possiblyAvailableRuntime2.getException());
            }
        }
        int i11 = AnonymousClass1.$SwitchMap$org$tensorflow$lite$InterpreterApi$Options$TfLiteRuntime[tfLiteRuntime.ordinal()];
        if (i11 == 1) {
            str3 = String.format("You should declare a build dependency on org.tensorflow.lite:tensorflow-lite, or call .%s with a value other than TfLiteRuntime.FROM_APPLICATION_ONLY (see docs for %s#%s(TfLiteRuntime)).", new Object[]{str2, str, str2});
        } else if (i11 != 2) {
            str3 = "You should declare a build dependency on org.tensorflow.lite:tensorflow-lite or com.google.android.gms:play-services-tflite-java";
        } else {
            str3 = String.format("You should declare a build dependency on com.google.android.gms:play-services-tflite-java, or call .%s with a value other than TfLiteRuntime.FROM_SYSTEM_ONLY  (see docs for %s#%s).", new Object[]{str2, str, str2});
        }
        throw new IllegalStateException("Couldn't find TensorFlow Lite runtime's InterpreterFactoryImpl class -- make sure your app links in the right TensorFlow Lite runtime. " + str3, exc);
    }

    public static String runtimeVersion() {
        return runtimeVersion((InterpreterApi.Options.TfLiteRuntime) null);
    }

    public static String schemaVersion() {
        return schemaVersion((InterpreterApi.Options.TfLiteRuntime) null);
    }
}
