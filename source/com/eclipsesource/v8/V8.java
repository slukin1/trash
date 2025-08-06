package com.eclipsesource.v8;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.inspector.V8InspectorDelegate;
import com.eclipsesource.v8.utils.V8Executor;
import com.eclipsesource.v8.utils.V8Map;
import com.eclipsesource.v8.utils.V8Runnable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class V8 extends V8Object {
    private static boolean initialized = false;
    private static Object invalid = new Object();
    private static Object lock = new Object();
    private static boolean nativeLibraryLoaded = false;
    private static Error nativeLoadError;
    private static Exception nativeLoadException;
    private static volatile int runtimeCounter;
    private static V8Value undefined = new V8Object.Undefined();
    private static String v8Flags;
    private Map<String, Object> data;
    private V8Map<V8Executor> executors;
    private boolean forceTerminateExecutors;
    private Map<Long, MethodDescriptor> functionRegistry;
    private final V8Locker locker;
    private long objectReferences;
    private LinkedList<ReferenceHandler> referenceHandlers;
    private LinkedList<V8Runnable> releaseHandlers;
    private List<Releasable> resources;
    private SignatureProvider signatureProvider;
    private long v8RuntimePtr;
    public Map<Long, V8Value> v8WeakReferences;

    public class MethodDescriptor {
        public JavaCallback callback;
        public boolean includeReceiver;
        public Method method;
        public Object object;
        public JavaVoidCallback voidCallback;

        private MethodDescriptor() {
        }
    }

    public V8() {
        this((String) null);
    }

    private native void _acquireLock(long j11);

    private native void _add(long j11, long j12, String str, double d11);

    private native void _add(long j11, long j12, String str, int i11);

    private native void _add(long j11, long j12, String str, String str2);

    private native void _add(long j11, long j12, String str, boolean z11);

    private native void _addArrayBooleanItem(long j11, long j12, boolean z11);

    private native void _addArrayDoubleItem(long j11, long j12, double d11);

    private native void _addArrayIntItem(long j11, long j12, int i11);

    private native void _addArrayNullItem(long j11, long j12);

    private native void _addArrayObjectItem(long j11, long j12, long j13);

    private native void _addArrayStringItem(long j11, long j12, String str);

    private native void _addArrayUndefinedItem(long j11, long j12);

    private native void _addNull(long j11, long j12, String str);

    private native void _addObject(long j11, long j12, String str, long j13);

    private native void _addUndefined(long j11, long j12, String str);

    private native Object _arrayGet(long j11, int i11, long j12, int i12);

    private native boolean _arrayGetBoolean(long j11, long j12, int i11);

    private native int _arrayGetBooleans(long j11, long j12, int i11, int i12, boolean[] zArr);

    private native boolean[] _arrayGetBooleans(long j11, long j12, int i11, int i12);

    private native byte _arrayGetByte(long j11, long j12, int i11);

    private native int _arrayGetBytes(long j11, long j12, int i11, int i12, byte[] bArr);

    private native byte[] _arrayGetBytes(long j11, long j12, int i11, int i12);

    private native double _arrayGetDouble(long j11, long j12, int i11);

    private native int _arrayGetDoubles(long j11, long j12, int i11, int i12, double[] dArr);

    private native double[] _arrayGetDoubles(long j11, long j12, int i11, int i12);

    private native int _arrayGetInteger(long j11, long j12, int i11);

    private native int _arrayGetIntegers(long j11, long j12, int i11, int i12, int[] iArr);

    private native int[] _arrayGetIntegers(long j11, long j12, int i11, int i12);

    private native int _arrayGetSize(long j11, long j12);

    private native String _arrayGetString(long j11, long j12, int i11);

    private native int _arrayGetStrings(long j11, long j12, int i11, int i12, String[] strArr);

    private native String[] _arrayGetStrings(long j11, long j12, int i11, int i12);

    private native void _clearWeak(long j11, long j12);

    private native boolean _contains(long j11, long j12, String str);

    private native long _createInspector(long j11, V8InspectorDelegate v8InspectorDelegate, String str);

    private native long _createIsolate(String str);

    private native void _createTwin(long j11, long j12, long j13);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j11, long j12, int i11);

    private native void _dispatchProtocolMessage(long j11, long j12, String str);

    private native boolean _equals(long j11, long j12, long j13);

    private native boolean _executeBooleanFunction(long j11, long j12, String str, long j13);

    private native boolean _executeBooleanScript(long j11, String str, String str2, int i11);

    private native double _executeDoubleFunction(long j11, long j12, String str, long j13);

    private native double _executeDoubleScript(long j11, String str, String str2, int i11);

    private native Object _executeFunction(long j11, int i11, long j12, String str, long j13);

    private native Object _executeFunction(long j11, long j12, long j13, long j14);

    private native int _executeIntegerFunction(long j11, long j12, String str, long j13);

    private native int _executeIntegerScript(long j11, String str, String str2, int i11);

    private native Object _executeScript(long j11, int i11, String str, String str2, int i12);

    private native String _executeStringFunction(long j11, long j12, String str, long j13);

    private native String _executeStringScript(long j11, String str, String str2, int i11);

    private native void _executeVoidFunction(long j11, long j12, String str, long j13);

    private native void _executeVoidScript(long j11, String str, String str2, int i11);

    private native Object _get(long j11, int i11, long j12, String str);

    private native int _getArrayType(long j11, long j12);

    private native boolean _getBoolean(long j11, long j12, String str);

    private static native long _getBuildID();

    private native String _getConstructorName(long j11, long j12);

    private native double _getDouble(long j11, long j12, String str);

    private native long _getGlobalObject(long j11);

    private native int _getInteger(long j11, long j12, String str);

    private native String[] _getKeys(long j11, long j12);

    private native String _getString(long j11, long j12, String str);

    private native int _getType(long j11, long j12);

    private native int _getType(long j11, long j12, int i11);

    private native int _getType(long j11, long j12, int i11, int i12);

    private native int _getType(long j11, long j12, String str);

    private static native String _getVersion();

    private native int _identityHash(long j11, long j12);

    private native long _initEmptyContainer(long j11);

    private native long _initNewV8Array(long j11);

    private native long _initNewV8ArrayBuffer(long j11, int i11);

    private native long _initNewV8ArrayBuffer(long j11, ByteBuffer byteBuffer, int i11);

    private native long _initNewV8Float32Array(long j11, long j12, int i11, int i12);

    private native long _initNewV8Float64Array(long j11, long j12, int i11, int i12);

    private native long[] _initNewV8Function(long j11);

    private native long _initNewV8Int16Array(long j11, long j12, int i11, int i12);

    private native long _initNewV8Int32Array(long j11, long j12, int i11, int i12);

    private native long _initNewV8Int8Array(long j11, long j12, int i11, int i12);

    private native long _initNewV8Object(long j11);

    private native long _initNewV8UInt16Array(long j11, long j12, int i11, int i12);

    private native long _initNewV8UInt32Array(long j11, long j12, int i11, int i12);

    private native long _initNewV8UInt8Array(long j11, long j12, int i11, int i12);

    private native long _initNewV8UInt8ClampedArray(long j11, long j12, int i11, int i12);

    private static native boolean _isNodeCompatible();

    private static native boolean _isRunning(long j11);

    private native boolean _isWeak(long j11, long j12);

    private native void _lowMemoryNotification(long j11);

    private static native boolean _pumpMessageLoop(long j11);

    private native long _registerJavaMethod(long j11, long j12, String str, boolean z11);

    private native void _release(long j11, long j12);

    private native void _releaseLock(long j11);

    private native void _releaseMethodDescriptor(long j11, long j12);

    private native void _releaseRuntime(long j11);

    private native boolean _sameValue(long j11, long j12, long j13);

    private native void _schedulePauseOnNextStatement(long j11, long j12, String str);

    private static native void _setFlags(String str);

    private native void _setPrototype(long j11, long j12, long j13);

    private native void _setWeak(long j11, long j12);

    private static native void _startNodeJS(long j11, String str);

    private native boolean _strictEquals(long j11, long j12, long j13);

    private native void _terminateExecution(long j11);

    private native String _toString(long j11, long j12);

    private void checkArgs(Object[] objArr) {
        int length = objArr.length;
        int i11 = 0;
        while (i11 < length) {
            if (objArr[i11] != invalid) {
                i11++;
            } else {
                throw new IllegalArgumentException("argument type mismatch");
            }
        }
    }

    private static void checkNativeLibraryLoaded() {
        if (!nativeLibraryLoaded) {
            String computeLibraryShortName = LibraryLoader.computeLibraryShortName(true);
            String str = "J2V8 native library not loaded (" + LibraryLoader.computeLibraryShortName(false) + "/" + computeLibraryShortName + ")";
            if (nativeLoadError != null) {
                throw new IllegalStateException(str, nativeLoadError);
            } else if (nativeLoadException != null) {
                throw new IllegalStateException(str, nativeLoadException);
            } else {
                throw new IllegalStateException(str);
            }
        }
    }

    private Object checkResult(Object obj) {
        if (obj == null) {
            return obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Boolean) || (obj instanceof String)) {
            return obj;
        }
        if (!(obj instanceof V8Value)) {
            throw new V8RuntimeException("Unknown return type: " + obj.getClass());
        } else if (!((V8Value) obj).isReleased()) {
            return obj;
        } else {
            throw new V8RuntimeException("V8Value already released");
        }
    }

    public static void checkScript(String str) {
        Objects.requireNonNull(str, "Script is null");
    }

    public static V8 createV8Runtime() {
        return createV8Runtime((String) null, (String) null);
    }

    public static int getActiveRuntimes() {
        return runtimeCounter;
    }

    private Object[] getArgs(V8Object v8Object, MethodDescriptor methodDescriptor, V8Array v8Array, boolean z11) {
        int length = methodDescriptor.method.getParameterTypes().length;
        int i11 = z11 ? length - 1 : length;
        Object[] defaultValues = setDefaultValues(new Object[length], methodDescriptor.method.getParameterTypes(), v8Object, methodDescriptor.includeReceiver);
        ArrayList arrayList = new ArrayList();
        populateParamters(v8Array, i11, defaultValues, arrayList, methodDescriptor.includeReceiver);
        if (z11) {
            Object varArgContainer = getVarArgContainer(methodDescriptor.method.getParameterTypes(), arrayList.size());
            System.arraycopy(arrayList.toArray(), 0, varArgContainer, 0, arrayList.size());
            defaultValues[i11] = varArgContainer;
        }
        return defaultValues;
    }

    private Object getArrayItem(V8Array v8Array, int i11) {
        try {
            int type = v8Array.getType(i11);
            if (type == 10) {
                return v8Array.get(i11);
            }
            if (type == 99) {
                return getUndefined();
            }
            switch (type) {
                case 1:
                    return Integer.valueOf(v8Array.getInteger(i11));
                case 2:
                    return Double.valueOf(v8Array.getDouble(i11));
                case 3:
                    return Boolean.valueOf(v8Array.getBoolean(i11));
                case 4:
                    return v8Array.getString(i11);
                case 5:
                case 8:
                    return v8Array.getArray(i11);
                case 6:
                    return v8Array.getObject(i11);
                case 7:
                    return v8Array.getObject(i11);
                default:
                    return null;
            }
        } catch (V8ResultUndefined unused) {
            return null;
        }
    }

    public static long getBuildID() {
        return _getBuildID();
    }

    private Object getDefaultValue(Class<?> cls) {
        if (cls.equals(V8Object.class)) {
            return new V8Object.Undefined();
        }
        if (cls.equals(V8Array.class)) {
            return new V8Array.Undefined();
        }
        return invalid;
    }

    public static String getSCMRevision() {
        return "Unknown revision ID";
    }

    public static V8Value getUndefined() {
        return undefined;
    }

    public static String getV8Version() {
        return _getVersion();
    }

    private Object getVarArgContainer(Class<?>[] clsArr, int i11) {
        Class<?> cls = clsArr[clsArr.length - 1];
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return Array.newInstance(cls, i11);
    }

    public static boolean isLoaded() {
        return nativeLibraryLoaded;
    }

    public static boolean isNodeCompatible() {
        if (!nativeLibraryLoaded) {
            synchronized (lock) {
                if (!nativeLibraryLoaded) {
                    load((String) null);
                }
            }
        }
        return _isNodeCompatible();
    }

    private boolean isVoidMethod(Method method) {
        return method.getReturnType().equals(Void.TYPE);
    }

    private static synchronized void load(String str) {
        synchronized (V8.class) {
            try {
                LibraryLoader.loadLibrary(str);
                nativeLibraryLoaded = true;
            } catch (Error e11) {
                nativeLoadError = e11;
            } catch (Exception e12) {
                nativeLoadException = e12;
            }
        }
    }

    private void notifyReferenceCreated(V8Value v8Value) {
        Iterator it2 = this.referenceHandlers.iterator();
        while (it2.hasNext()) {
            ((ReferenceHandler) it2.next()).v8HandleCreated(v8Value);
        }
    }

    private void notifyReferenceDisposed(V8Value v8Value) {
        Iterator it2 = this.referenceHandlers.iterator();
        while (it2.hasNext()) {
            ((ReferenceHandler) it2.next()).v8HandleDisposed(v8Value);
        }
    }

    private void notifyReleaseHandlers(V8 v82) {
        Iterator it2 = this.releaseHandlers.iterator();
        while (it2.hasNext()) {
            ((V8Runnable) it2.next()).run(v82);
        }
    }

    private void populateParamters(V8Array v8Array, int i11, Object[] objArr, List<Object> list, boolean z11) {
        for (int i12 = z11; i12 < v8Array.length() + (z11 ? 1 : 0); i12++) {
            if (i12 >= i11) {
                list.add(getArrayItem(v8Array, i12 - z11));
            } else {
                objArr[i12] = getArrayItem(v8Array, i12 - z11);
            }
        }
    }

    private void releaseArguments(Object[] objArr, boolean z11) {
        if (z11 && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
            for (Object obj : objArr[objArr.length - 1]) {
                if (obj instanceof V8Value) {
                    ((V8Value) obj).close();
                }
            }
        }
        for (V8Value v8Value : objArr) {
            if (v8Value instanceof V8Value) {
                v8Value.close();
            }
        }
    }

    private void releaseNativeMethodDescriptors() {
        for (Long longValue : this.functionRegistry.keySet()) {
            releaseMethodDescriptor(this.v8RuntimePtr, longValue.longValue());
        }
    }

    private void releaseResources() {
        List<Releasable> list = this.resources;
        if (list != null) {
            for (Releasable release : list) {
                release.release();
            }
            this.resources.clear();
            this.resources = null;
        }
    }

    private Object[] setDefaultValues(Object[] objArr, Class<?>[] clsArr, V8Object v8Object, boolean z11) {
        int i11 = 0;
        if (z11) {
            objArr[0] = v8Object;
            i11 = 1;
        }
        while (i11 < objArr.length) {
            objArr[i11] = getDefaultValue(clsArr[i11]);
            i11++;
        }
        return objArr;
    }

    public static void setFlags(String str) {
        v8Flags = str;
        initialized = false;
    }

    public void acquireLock(long j11) {
        _acquireLock(j11);
    }

    public void add(long j11, long j12, String str, int i11) {
        _add(j11, j12, str, i11);
    }

    public void addArrayBooleanItem(long j11, long j12, boolean z11) {
        _addArrayBooleanItem(j11, j12, z11);
    }

    public void addArrayDoubleItem(long j11, long j12, double d11) {
        _addArrayDoubleItem(j11, j12, d11);
    }

    public void addArrayIntItem(long j11, long j12, int i11) {
        _addArrayIntItem(j11, j12, i11);
    }

    public void addArrayNullItem(long j11, long j12) {
        _addArrayNullItem(j11, j12);
    }

    public void addArrayObjectItem(long j11, long j12, long j13) {
        _addArrayObjectItem(j11, j12, j13);
    }

    public void addArrayStringItem(long j11, long j12, String str) {
        _addArrayStringItem(j11, j12, str);
    }

    public void addArrayUndefinedItem(long j11, long j12) {
        _addArrayUndefinedItem(j11, j12);
    }

    public void addNull(long j11, long j12, String str) {
        _addNull(j11, j12, str);
    }

    public void addObjRef(V8Value v8Value) {
        this.objectReferences++;
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceCreated(v8Value);
        }
    }

    public void addObject(long j11, long j12, String str, long j13) {
        _addObject(j11, j12, str, j13);
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.add(0, referenceHandler);
    }

    public void addReleaseHandler(V8Runnable v8Runnable) {
        this.releaseHandlers.add(v8Runnable);
    }

    public void addUndefined(long j11, long j12, String str) {
        _addUndefined(j11, j12, str);
    }

    public Object arrayGet(long j11, int i11, long j12, int i12) {
        return _arrayGet(j11, i11, j12, i12);
    }

    public boolean arrayGetBoolean(long j11, long j12, int i11) {
        return _arrayGetBoolean(j11, j12, i11);
    }

    public boolean[] arrayGetBooleans(long j11, long j12, int i11, int i12) {
        return _arrayGetBooleans(j11, j12, i11, i12);
    }

    public byte arrayGetByte(long j11, long j12, int i11) {
        return _arrayGetByte(j11, j12, i11);
    }

    public byte[] arrayGetBytes(long j11, long j12, int i11, int i12) {
        return _arrayGetBytes(j11, j12, i11, i12);
    }

    public double arrayGetDouble(long j11, long j12, int i11) {
        return _arrayGetDouble(j11, j12, i11);
    }

    public double[] arrayGetDoubles(long j11, long j12, int i11, int i12) {
        return _arrayGetDoubles(j11, j12, i11, i12);
    }

    public int arrayGetInteger(long j11, long j12, int i11) {
        return _arrayGetInteger(j11, j12, i11);
    }

    public int[] arrayGetIntegers(long j11, long j12, int i11, int i12) {
        return _arrayGetIntegers(j11, j12, i11, i12);
    }

    public int arrayGetSize(long j11, long j12) {
        return _arrayGetSize(j11, j12);
    }

    public String arrayGetString(long j11, long j12, int i11) {
        return _arrayGetString(j11, j12, i11);
    }

    public String[] arrayGetStrings(long j11, long j12, int i11, int i12) {
        return _arrayGetStrings(j11, j12, i11, i12);
    }

    public Object callObjectJavaMethod(long j11, V8Object v8Object, V8Array v8Array) throws Throwable {
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j11));
        JavaCallback javaCallback = methodDescriptor.callback;
        if (javaCallback != null) {
            return checkResult(javaCallback.invoke(v8Object, v8Array));
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            Object checkResult = checkResult(methodDescriptor.method.invoke(methodDescriptor.object, args));
            releaseArguments(args, isVarArgs);
            return checkResult;
        } catch (InvocationTargetException e11) {
            throw e11.getTargetException();
        } catch (IllegalAccessException e12) {
            throw e12;
        } catch (IllegalArgumentException e13) {
            throw e13;
        } catch (Throwable th2) {
            releaseArguments(args, isVarArgs);
            throw th2;
        }
    }

    public void callVoidJavaMethod(long j11, V8Object v8Object, V8Array v8Array) throws Throwable {
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j11));
        JavaVoidCallback javaVoidCallback = methodDescriptor.voidCallback;
        if (javaVoidCallback != null) {
            javaVoidCallback.invoke(v8Object, v8Array);
            return;
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            methodDescriptor.method.invoke(methodDescriptor.object, args);
            releaseArguments(args, isVarArgs);
        } catch (InvocationTargetException e11) {
            throw e11.getTargetException();
        } catch (IllegalAccessException e12) {
            throw e12;
        } catch (IllegalArgumentException e13) {
            throw e13;
        } catch (Throwable th2) {
            releaseArguments(args, isVarArgs);
            throw th2;
        }
    }

    public void checkRuntime(V8Value v8Value) {
        if (v8Value != null && !v8Value.isUndefined()) {
            V8 runtime = v8Value.getRuntime();
            if (runtime == null || runtime.isReleased() || runtime != this) {
                throw new Error("Invalid target runtime");
            }
        }
    }

    public void checkThread() {
        this.locker.checkThread();
        if (isReleased()) {
            throw new Error("Runtime disposed error");
        }
    }

    public void clearWeak(long j11, long j12) {
        _clearWeak(j11, j12);
    }

    public void close() {
        release(true);
    }

    public boolean contains(long j11, long j12, String str) {
        return _contains(j11, j12, str);
    }

    public void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j11) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.callback = javaCallback;
        this.functionRegistry.put(Long.valueOf(j11), methodDescriptor);
    }

    public long createInspector(V8InspectorDelegate v8InspectorDelegate, String str) {
        return _createInspector(this.v8RuntimePtr, v8InspectorDelegate, str);
    }

    public void createNodeRuntime(String str) {
        _startNodeJS(this.v8RuntimePtr, str);
    }

    public void createTwin(V8Value v8Value, V8Value v8Value2) {
        checkThread();
        createTwin(this.v8RuntimePtr, v8Value.getHandle(), v8Value2.getHandle());
    }

    public ByteBuffer createV8ArrayBufferBackingStore(long j11, long j12, int i11) {
        return _createV8ArrayBufferBackingStore(j11, j12, i11);
    }

    public void dispatchProtocolMessage(long j11, String str) {
        checkThread();
        _dispatchProtocolMessage(this.v8RuntimePtr, j11, str);
    }

    public void disposeMethodID(long j11) {
        this.functionRegistry.remove(Long.valueOf(j11));
    }

    public boolean equals(long j11, long j12, long j13) {
        return _equals(j11, j12, j13);
    }

    public V8Array executeArrayScript(String str) {
        return executeArrayScript(str, (String) null, 0);
    }

    public boolean executeBooleanFunction(long j11, long j12, String str, long j13) {
        return _executeBooleanFunction(j11, j12, str, j13);
    }

    public boolean executeBooleanScript(String str) {
        return executeBooleanScript(str, (String) null, 0);
    }

    public double executeDoubleFunction(long j11, long j12, String str, long j13) {
        return _executeDoubleFunction(j11, j12, str, j13);
    }

    public double executeDoubleScript(String str) {
        return executeDoubleScript(str, (String) null, 0);
    }

    public Object executeFunction(long j11, int i11, long j12, String str, long j13) {
        return _executeFunction(j11, i11, j12, str, j13);
    }

    public int executeIntegerFunction(long j11, long j12, String str, long j13) {
        return _executeIntegerFunction(j11, j12, str, j13);
    }

    public int executeIntegerScript(String str) {
        return executeIntegerScript(str, (String) null, 0);
    }

    public Object executeModule(String str, String str2, String str3, String str4) {
        checkThread();
        checkScript(str);
        long v8RuntimePtr2 = getV8RuntimePtr();
        return executeScript(v8RuntimePtr2, 0, str2 + str + str3, str4, 0);
    }

    public V8Object executeObjectScript(String str) {
        return executeObjectScript(str, (String) null, 0);
    }

    public Object executeScript(String str) {
        return executeScript(str, (String) null, 0);
    }

    public String executeStringFunction(long j11, long j12, String str, long j13) {
        return _executeStringFunction(j11, j12, str, j13);
    }

    public String executeStringScript(String str) {
        return executeStringScript(str, (String) null, 0);
    }

    public void executeVoidFunction(long j11, long j12, String str, long j13) {
        _executeVoidFunction(j11, j12, str, j13);
    }

    public void executeVoidScript(String str) {
        executeVoidScript(str, (String) null, 0);
    }

    public Object get(long j11, int i11, long j12, String str) {
        return _get(j11, i11, j12, str);
    }

    public int getArrayType(long j11, long j12) {
        return _getArrayType(j11, j12);
    }

    public boolean getBoolean(long j11, long j12, String str) {
        return _getBoolean(j11, j12, str);
    }

    public String getConstructorName(long j11, long j12) {
        return _getConstructorName(j11, j12);
    }

    public Object getData(String str) {
        Map<String, Object> map = this.data;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public double getDouble(long j11, long j12, String str) {
        return _getDouble(j11, j12, str);
    }

    public V8Executor getExecutor(V8Object v8Object) {
        checkThread();
        V8Map<V8Executor> v8Map = this.executors;
        if (v8Map == null) {
            return null;
        }
        return v8Map.get(v8Object);
    }

    public int getInteger(long j11, long j12, String str) {
        return _getInteger(j11, j12, str);
    }

    public String[] getKeys(long j11, long j12) {
        return _getKeys(j11, j12);
    }

    public V8Locker getLocker() {
        return this.locker;
    }

    public long getObjectReferenceCount() {
        return this.objectReferences - ((long) this.v8WeakReferences.size());
    }

    public String getString(long j11, long j12, String str) {
        return _getString(j11, j12, str);
    }

    public int getType(long j11, long j12) {
        return _getType(j11, j12);
    }

    public long getV8RuntimePtr() {
        return this.v8RuntimePtr;
    }

    public int identityHash(long j11, long j12) {
        return _identityHash(j11, j12);
    }

    public long initEmptyContainer(long j11) {
        return _initEmptyContainer(j11);
    }

    public long initNewV8Array(long j11) {
        return _initNewV8Array(j11);
    }

    public long initNewV8ArrayBuffer(long j11, ByteBuffer byteBuffer, int i11) {
        return _initNewV8ArrayBuffer(j11, byteBuffer, i11);
    }

    public long initNewV8Float32Array(long j11, long j12, int i11, int i12) {
        return _initNewV8Float32Array(j11, j12, i11, i12);
    }

    public long initNewV8Float64Array(long j11, long j12, int i11, int i12) {
        return _initNewV8Float64Array(j11, j12, i11, i12);
    }

    public long[] initNewV8Function(long j11) {
        checkThread();
        return _initNewV8Function(j11);
    }

    public long initNewV8Int16Array(long j11, long j12, int i11, int i12) {
        return _initNewV8Int16Array(j11, j12, i11, i12);
    }

    public long initNewV8Int32Array(long j11, long j12, int i11, int i12) {
        return _initNewV8Int32Array(j11, j12, i11, i12);
    }

    public long initNewV8Int8Array(long j11, long j12, int i11, int i12) {
        return _initNewV8Int8Array(j11, j12, i11, i12);
    }

    public long initNewV8Object(long j11) {
        return _initNewV8Object(j11);
    }

    public long initNewV8UInt16Array(long j11, long j12, int i11, int i12) {
        return _initNewV8UInt16Array(j11, j12, i11, i12);
    }

    public long initNewV8UInt32Array(long j11, long j12, int i11, int i12) {
        return _initNewV8UInt32Array(j11, j12, i11, i12);
    }

    public long initNewV8UInt8Array(long j11, long j12, int i11, int i12) {
        return _initNewV8UInt8Array(j11, j12, i11, i12);
    }

    public long initNewV8UInt8ClampedArray(long j11, long j12, int i11, int i12) {
        return _initNewV8UInt8ClampedArray(j11, j12, i11, i12);
    }

    public boolean isRunning() {
        return _isRunning(this.v8RuntimePtr);
    }

    public boolean isWeak(long j11, long j12) {
        return _isWeak(j11, j12);
    }

    public void lowMemoryNotification() {
        checkThread();
        lowMemoryNotification(getV8RuntimePtr());
    }

    public boolean pumpMessageLoop() {
        return _pumpMessageLoop(this.v8RuntimePtr);
    }

    public void registerCallback(Object obj, Method method, long j11, String str, boolean z11) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.object = obj;
        methodDescriptor.method = method;
        methodDescriptor.includeReceiver = z11;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j11, str, isVoidMethod(method))), methodDescriptor);
    }

    public long registerJavaMethod(long j11, long j12, String str, boolean z11) {
        return _registerJavaMethod(j11, j12, str, z11);
    }

    public void registerResource(Releasable releasable) {
        checkThread();
        if (this.resources == null) {
            this.resources = new ArrayList();
        }
        this.resources.add(releasable);
    }

    public void registerV8Executor(V8Object v8Object, V8Executor v8Executor) {
        checkThread();
        if (this.executors == null) {
            this.executors = new V8Map<>();
        }
        this.executors.put((V8Value) v8Object, v8Executor);
    }

    public void registerVoidCallback(JavaVoidCallback javaVoidCallback, long j11, String str) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.voidCallback = javaVoidCallback;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j11, str, true)), methodDescriptor);
    }

    @Deprecated
    public void release() {
        release(true);
    }

    public void releaseLock(long j11) {
        _releaseLock(j11);
    }

    public void releaseMethodDescriptor(long j11, long j12) {
        _releaseMethodDescriptor(j11, j12);
    }

    public void releaseObjRef(V8Value v8Value) {
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceDisposed(v8Value);
        }
        this.objectReferences--;
    }

    public V8Executor removeExecutor(V8Object v8Object) {
        checkThread();
        V8Map<V8Executor> v8Map = this.executors;
        if (v8Map == null) {
            return null;
        }
        return v8Map.remove(v8Object);
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        this.referenceHandlers.remove(referenceHandler);
    }

    public void removeReleaseHandler(V8Runnable v8Runnable) {
        this.releaseHandlers.remove(v8Runnable);
    }

    public boolean sameValue(long j11, long j12, long j13) {
        return _sameValue(j11, j12, j13);
    }

    public void schedulePauseOnNextStatement(long j11, String str) {
        checkThread();
        _schedulePauseOnNextStatement(this.v8RuntimePtr, j11, str);
    }

    public synchronized void setData(String str, Object obj) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, obj);
    }

    public void setPrototype(long j11, long j12, long j13) {
        _setPrototype(j11, j12, j13);
    }

    public void setSignatureProvider(SignatureProvider signatureProvider2) {
        this.signatureProvider = signatureProvider2;
    }

    public void setWeak(long j11, long j12) {
        _setWeak(j11, j12);
    }

    public void shutdownExecutors(boolean z11) {
        checkThread();
        V8Map<V8Executor> v8Map = this.executors;
        if (v8Map != null) {
            for (V8Executor next : v8Map.values()) {
                if (z11) {
                    next.forceTermination();
                } else {
                    next.shutdown();
                }
            }
        }
    }

    public boolean strictEquals(long j11, long j12, long j13) {
        return _strictEquals(j11, j12, j13);
    }

    public void terminateExecution() {
        this.forceTerminateExecutors = true;
        terminateExecution(this.v8RuntimePtr);
    }

    public String toString(long j11, long j12) {
        return _toString(j11, j12);
    }

    public void weakReferenceReleased(long j11) {
        V8Value v8Value = this.v8WeakReferences.get(Long.valueOf(j11));
        if (v8Value != null) {
            this.v8WeakReferences.remove(Long.valueOf(j11));
            try {
                v8Value.close();
            } catch (Exception unused) {
            }
        }
    }

    public V8(String str) {
        super((V8) null);
        this.v8WeakReferences = new HashMap();
        this.data = null;
        this.signatureProvider = null;
        this.objectReferences = 0;
        this.v8RuntimePtr = 0;
        this.resources = null;
        this.executors = null;
        this.forceTerminateExecutors = false;
        this.functionRegistry = new HashMap();
        this.referenceHandlers = new LinkedList<>();
        this.releaseHandlers = new LinkedList<>();
        this.released = false;
        this.v8RuntimePtr = _createIsolate(str);
        this.locker = new V8Locker(this);
        checkThread();
        this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
    }

    public static V8 createV8Runtime(String str) {
        return createV8Runtime(str, (String) null);
    }

    public void add(long j11, long j12, String str, boolean z11) {
        _add(j11, j12, str, z11);
    }

    public int arrayGetBooleans(long j11, long j12, int i11, int i12, boolean[] zArr) {
        return _arrayGetBooleans(j11, j12, i11, i12, zArr);
    }

    public int arrayGetBytes(long j11, long j12, int i11, int i12, byte[] bArr) {
        return _arrayGetBytes(j11, j12, i11, i12, bArr);
    }

    public int arrayGetDoubles(long j11, long j12, int i11, int i12, double[] dArr) {
        return _arrayGetDoubles(j11, j12, i11, i12, dArr);
    }

    public int arrayGetIntegers(long j11, long j12, int i11, int i12, int[] iArr) {
        return _arrayGetIntegers(j11, j12, i11, i12, iArr);
    }

    public int arrayGetStrings(long j11, long j12, int i11, int i12, String[] strArr) {
        return _arrayGetStrings(j11, j12, i11, i12, strArr);
    }

    public V8Array executeArrayScript(String str, String str2, int i11) {
        checkThread();
        Object executeScript = executeScript(str, str2, i11);
        if (executeScript instanceof V8Array) {
            return (V8Array) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public boolean executeBooleanScript(String str, String str2, int i11) {
        checkThread();
        checkScript(str);
        return executeBooleanScript(this.v8RuntimePtr, str, str2, i11);
    }

    public double executeDoubleScript(String str, String str2, int i11) {
        checkThread();
        checkScript(str);
        return executeDoubleScript(this.v8RuntimePtr, str, str2, i11);
    }

    public Object executeFunction(long j11, long j12, long j13, long j14) {
        return _executeFunction(j11, j12, j13, j14);
    }

    public int executeIntegerScript(String str, String str2, int i11) {
        checkThread();
        checkScript(str);
        return executeIntegerScript(this.v8RuntimePtr, str, str2, i11);
    }

    public V8Object executeObjectScript(String str, String str2, int i11) {
        checkThread();
        Object executeScript = executeScript(str, str2, i11);
        if (executeScript instanceof V8Object) {
            return (V8Object) executeScript;
        }
        throw new V8ResultUndefined();
    }

    public Object executeScript(String str, String str2) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, 0);
    }

    public String executeStringScript(String str, String str2, int i11) {
        checkThread();
        checkScript(str);
        return executeStringScript(this.v8RuntimePtr, str, str2, i11);
    }

    public void executeVoidScript(String str, String str2, int i11) {
        checkThread();
        checkScript(str);
        executeVoidScript(this.v8RuntimePtr, str, str2, i11);
    }

    public int getType(long j11, long j12, String str) {
        return _getType(j11, j12, str);
    }

    public long initNewV8ArrayBuffer(long j11, int i11) {
        return _initNewV8ArrayBuffer(j11, i11);
    }

    public void release(boolean z11) {
        if (!isReleased()) {
            checkThread();
            try {
                notifyReleaseHandlers(this);
                releaseResources();
                shutdownExecutors(this.forceTerminateExecutors);
                V8Map<V8Executor> v8Map = this.executors;
                if (v8Map != null) {
                    v8Map.clear();
                }
                releaseNativeMethodDescriptors();
                synchronized (lock) {
                    runtimeCounter--;
                }
                _releaseRuntime(this.v8RuntimePtr);
                this.v8RuntimePtr = 0;
                this.released = true;
                if (z11 && getObjectReferenceCount() > 0) {
                    throw new IllegalStateException(getObjectReferenceCount() + " Object(s) still exist in runtime");
                }
            } catch (Throwable th2) {
                releaseResources();
                shutdownExecutors(this.forceTerminateExecutors);
                if (this.executors != null) {
                    this.executors.clear();
                }
                releaseNativeMethodDescriptors();
                synchronized (lock) {
                    runtimeCounter--;
                    _releaseRuntime(this.v8RuntimePtr);
                    this.v8RuntimePtr = 0;
                    this.released = true;
                    if (!z11 || getObjectReferenceCount() <= 0) {
                        throw th2;
                    }
                    throw new IllegalStateException(getObjectReferenceCount() + " Object(s) still exist in runtime");
                }
            }
        }
    }

    public static V8 createV8Runtime(String str, String str2) {
        if (!nativeLibraryLoaded) {
            synchronized (lock) {
                if (!nativeLibraryLoaded) {
                    load(str2);
                }
            }
        }
        checkNativeLibraryLoaded();
        if (!initialized) {
            _setFlags(v8Flags);
            initialized = true;
        }
        V8 v82 = new V8(str);
        synchronized (lock) {
            runtimeCounter++;
        }
        return v82;
    }

    public void add(long j11, long j12, String str, double d11) {
        _add(j11, j12, str, d11);
    }

    public void createTwin(long j11, long j12, long j13) {
        _createTwin(j11, j12, j13);
    }

    public int getType(long j11, long j12, int i11) {
        return _getType(j11, j12, i11);
    }

    public void lowMemoryNotification(long j11) {
        _lowMemoryNotification(j11);
    }

    public void terminateExecution(long j11) {
        _terminateExecution(j11);
    }

    public void add(long j11, long j12, String str, String str2) {
        _add(j11, j12, str, str2);
    }

    public int getType(long j11, long j12, int i11, int i12) {
        return _getType(j11, j12, i11, i12);
    }

    public boolean executeBooleanScript(long j11, String str, String str2, int i11) {
        return _executeBooleanScript(j11, str, str2, i11);
    }

    public double executeDoubleScript(long j11, String str, String str2, int i11) {
        return _executeDoubleScript(j11, str, str2, i11);
    }

    public int executeIntegerScript(long j11, String str, String str2, int i11) {
        return _executeIntegerScript(j11, str, str2, i11);
    }

    public Object executeScript(String str, String str2, int i11) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, i11);
    }

    public String executeStringScript(long j11, String str, String str2, int i11) {
        return _executeStringScript(j11, str, str2, i11);
    }

    public void executeVoidScript(long j11, String str, String str2, int i11) {
        _executeVoidScript(j11, str, str2, i11);
    }

    public void registerCallback(JavaCallback javaCallback, long j11, String str) {
        createAndRegisterMethodDescriptor(javaCallback, registerJavaMethod(getV8RuntimePtr(), j11, str, false));
    }

    public Object executeScript(long j11, int i11, String str, String str2, int i12) {
        return _executeScript(j11, i11, str, str2, i12);
    }

    public void release(long j11, long j12) {
        _release(j11, j12);
    }
}
