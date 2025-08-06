package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import java.util.ArrayList;
import java.util.List;

public class DebugHandler implements Releasable {
    private static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
    private static final String CLEAR_BREAK_POINT = "clearBreakPoint";
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
    private static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
    private static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
    private static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
    private static final String NUMBER = "number";
    private static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
    private static final String SET_BREAK_POINT = "setBreakPoint";
    private static final String SET_LISTENER = "setListener";
    private static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
    private static final String V8_DEBUG_OBJECT = "Debug";
    /* access modifiers changed from: private */
    public List<BreakHandler> breakHandlers = new ArrayList();
    private V8Object debugObject;
    private V8 runtime;

    /* renamed from: com.eclipsesource.v8.debug.DebugHandler$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.eclipsesource.v8.debug.DebugHandler$DebugEvent[] r0 = com.eclipsesource.v8.debug.DebugHandler.DebugEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent = r0
                com.eclipsesource.v8.debug.DebugHandler$DebugEvent r1 = com.eclipsesource.v8.debug.DebugHandler.DebugEvent.Break     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent     // Catch:{ NoSuchFieldError -> 0x001d }
                com.eclipsesource.v8.debug.DebugHandler$DebugEvent r1 = com.eclipsesource.v8.debug.DebugHandler.DebugEvent.BeforeCompile     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.eclipsesource.v8.debug.DebugHandler$DebugEvent r1 = com.eclipsesource.v8.debug.DebugHandler.DebugEvent.AfterCompile     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.eclipsesource.v8.debug.DebugHandler$DebugEvent r1 = com.eclipsesource.v8.debug.DebugHandler.DebugEvent.Exception     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.debug.DebugHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public class BreakpointHandler implements JavaVoidCallback {
        private BreakpointHandler() {
        }

        private EventData createDebugEvent(DebugEvent debugEvent, V8Object v8Object) {
            int i11 = AnonymousClass1.$SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[debugEvent.ordinal()];
            if (i11 == 1) {
                return new BreakEvent(v8Object);
            }
            if (i11 == 2) {
                return new CompileEvent(v8Object);
            }
            if (i11 == 3) {
                return new CompileEvent(v8Object);
            }
            if (i11 != 4) {
                return new EventData(v8Object);
            }
            return new ExceptionEvent(v8Object);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.eclipsesource.v8.V8Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.eclipsesource.v8.debug.ExecutionState} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.eclipsesource.v8.debug.EventData} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void invokeHandler(com.eclipsesource.v8.V8Array r6, int r7, com.eclipsesource.v8.debug.BreakHandler r8) {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
                com.eclipsesource.v8.V8Object r0 = r6.getObject(r0)     // Catch:{ all -> 0x0044 }
                r2 = 2
                com.eclipsesource.v8.V8Object r2 = r6.getObject(r2)     // Catch:{ all -> 0x003d }
                r3 = 3
                com.eclipsesource.v8.V8Object r6 = r6.getObject(r3)     // Catch:{ all -> 0x0038 }
                com.eclipsesource.v8.debug.ExecutionState r3 = new com.eclipsesource.v8.debug.ExecutionState     // Catch:{ all -> 0x0035 }
                r3.<init>(r0)     // Catch:{ all -> 0x0035 }
                com.eclipsesource.v8.debug.DebugHandler$DebugEvent[] r4 = com.eclipsesource.v8.debug.DebugHandler.DebugEvent.values()     // Catch:{ all -> 0x0032 }
                r7 = r4[r7]     // Catch:{ all -> 0x0032 }
                com.eclipsesource.v8.debug.EventData r1 = r5.createDebugEvent(r7, r2)     // Catch:{ all -> 0x0032 }
                r8.onBreak(r7, r3, r1, r6)     // Catch:{ all -> 0x0032 }
                r5.safeRelease(r0)
                r5.safeRelease(r2)
                r5.safeRelease(r6)
                r5.safeRelease(r3)
                r5.safeRelease(r1)
                return
            L_0x0032:
                r7 = move-exception
                r8 = r1
                goto L_0x0042
            L_0x0035:
                r7 = move-exception
                r8 = r1
                goto L_0x003b
            L_0x0038:
                r7 = move-exception
                r6 = r1
                r8 = r6
            L_0x003b:
                r3 = r8
                goto L_0x0042
            L_0x003d:
                r7 = move-exception
                r6 = r1
                r8 = r6
                r2 = r8
                r3 = r2
            L_0x0042:
                r1 = r0
                goto L_0x0049
            L_0x0044:
                r7 = move-exception
                r6 = r1
                r8 = r6
                r2 = r8
                r3 = r2
            L_0x0049:
                r5.safeRelease(r1)
                r5.safeRelease(r2)
                r5.safeRelease(r6)
                r5.safeRelease(r3)
                r5.safeRelease(r8)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.debug.DebugHandler.BreakpointHandler.invokeHandler(com.eclipsesource.v8.V8Array, int, com.eclipsesource.v8.debug.BreakHandler):void");
        }

        private void safeRelease(Releasable releasable) {
            if (releasable != null) {
                releasable.release();
            }
        }

        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array != null && !v8Array.isUndefined()) {
                int integer = v8Array.getInteger(0);
                for (BreakHandler invokeHandler : DebugHandler.this.breakHandlers) {
                    invokeHandler(v8Array, integer, invokeHandler);
                }
            }
        }

        public /* synthetic */ BreakpointHandler(DebugHandler debugHandler, AnonymousClass1 r22) {
            this();
        }
    }

    public enum DebugEvent {
        Undefined(0),
        Break(1),
        Exception(2),
        NewFunction(3),
        BeforeCompile(4),
        AfterCompile(5),
        CompileError(6),
        PromiseError(7),
        AsyncTaskEvent(8);
        
        public int index;

        private DebugEvent(int i11) {
            this.index = i11;
        }
    }

    public DebugHandler(V8 v82) {
        this.runtime = v82;
        setupDebugObject(v82);
        setupBreakpointHandler();
    }

    private void setupBreakpointHandler() {
        V8Array v8Array;
        Throwable th2;
        V8Function v8Function;
        this.debugObject.registerJavaMethod((JavaVoidCallback) new BreakpointHandler(this, (AnonymousClass1) null), DEBUG_BREAK_HANDLER);
        try {
            v8Function = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
            try {
                v8Array = new V8Array(this.runtime);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                v8Array = null;
                th2 = th4;
                v8Function.close();
                v8Array.close();
                throw th2;
            }
            try {
                v8Array.push((V8Value) v8Function);
                this.debugObject.executeFunction(SET_LISTENER, v8Array);
                if (v8Function != null && !v8Function.isReleased()) {
                    v8Function.close();
                }
                if (!v8Array.isReleased()) {
                    v8Array.close();
                }
            } catch (Throwable th5) {
                th2 = th5;
                v8Function.close();
                v8Array.close();
                throw th2;
            }
        } catch (Throwable th6) {
            v8Array = null;
            th2 = th6;
            v8Function = null;
            if (v8Function != null && !v8Function.isReleased()) {
                v8Function.close();
            }
            if (v8Array != null && !v8Array.isReleased()) {
                v8Array.close();
            }
            throw th2;
        }
    }

    private void setupDebugObject(V8 v82) {
        V8Object object = v82.getObject(DEBUG_OBJECT_NAME);
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
        } finally {
            object.close();
        }
    }

    public void addBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.add(breakHandler);
    }

    public void changeBreakPointCondition(int i11, String str) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i11);
        v8Array.push(str);
        try {
            this.debugObject.executeVoidFunction(CHANGE_BREAK_POINT_CONDITION, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public void clearBreakPoint(int i11) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i11);
        try {
            this.debugObject.executeVoidFunction(CLEAR_BREAK_POINT, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public void close() {
        this.debugObject.close();
    }

    public void disableAllBreakPoints() {
        this.debugObject.executeVoidFunction(DISABLE_ALL_BREAK_POINTS, (V8Array) null);
    }

    public void disableScriptBreakPoint(int i11) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i11);
        try {
            this.debugObject.executeVoidFunction(DISABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public void enableScriptBreakPoint(int i11) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i11);
        try {
            this.debugObject.executeVoidFunction(ENABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public ScriptBreakPoint getScriptBreakPoint(int i11) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i11);
        v8Array.push(false);
        V8Object v8Object = null;
        try {
            v8Object = this.debugObject.executeObjectFunction(FIND_SCRIPT_BREAK_POINT, v8Array);
            return new ScriptBreakPoint(v8Object);
        } finally {
            v8Array.close();
            if (v8Object != null) {
                v8Object.close();
            }
        }
    }

    public int getScriptBreakPointCount() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, (V8Array) null);
        try {
            return executeArrayFunction.length();
        } finally {
            executeArrayFunction.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int[] getScriptBreakPointIDs() {
        /*
            r6 = this;
            com.eclipsesource.v8.V8Object r0 = r6.debugObject
            java.lang.String r1 = "scriptBreakPoints"
            r2 = 0
            com.eclipsesource.v8.V8Array r0 = r0.executeArrayFunction(r1, r2)
            int r1 = r0.length()     // Catch:{ all -> 0x0031 }
            int[] r1 = new int[r1]     // Catch:{ all -> 0x0031 }
            r3 = 0
        L_0x0010:
            int r4 = r0.length()     // Catch:{ all -> 0x0031 }
            if (r3 >= r4) goto L_0x002d
            com.eclipsesource.v8.V8Object r4 = r0.getObject(r3)     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = "number"
            int r5 = r4.executeIntegerFunction(r5, r2)     // Catch:{ all -> 0x0028 }
            r1[r3] = r5     // Catch:{ all -> 0x0028 }
            r4.close()     // Catch:{ all -> 0x0031 }
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0028:
            r1 = move-exception
            r4.close()     // Catch:{ all -> 0x0031 }
            throw r1     // Catch:{ all -> 0x0031 }
        L_0x002d:
            r0.close()
            return r1
        L_0x0031:
            r1 = move-exception
            r0.close()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.debug.DebugHandler.getScriptBreakPointIDs():int[]");
    }

    @Deprecated
    public void release() {
        close();
    }

    public void removeBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.remove(breakHandler);
    }

    public int setBreakpoint(V8Function v8Function) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push((V8Value) v8Function);
        try {
            return this.debugObject.executeIntegerFunction(SET_BREAK_POINT, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public int setScriptBreakpoint(String str, int i11) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        v8Array.push(i11);
        try {
            return this.debugObject.executeIntegerFunction(SET_SCRIPT_BREAK_POINT_BY_NAME, v8Array);
        } finally {
            v8Array.close();
        }
    }
}
