package com.eclipsesource.v8;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class NodeJS {
    private static final String GLOBAL = "global";
    private static final String NEXT_TICK = "nextTick";
    private static final String NODE = "node";
    private static final String PROCESS = "process";
    private static final String STARTUP_CALLBACK = "__run";
    private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
    private static final String STARTUP_SCRIPT_NAME = "startup";
    private static final String TMP_JS_EXT = ".js.tmp";
    private static final String VERSIONS = "versions";
    private String nodeVersion = null;
    /* access modifiers changed from: private */
    public V8Function require;
    /* access modifiers changed from: private */

    /* renamed from: v8  reason: collision with root package name */
    public V8 f64940v8;

    private NodeJS(V8 v82) {
        this.f64940v8 = v82;
    }

    public static NodeJS createNodeJS() {
        return createNodeJS((File) null);
    }

    private V8Function createScriptExecutionCallback(final File file) {
        return new V8Function(this.f64940v8, new JavaCallback() {
            public Object invoke(V8Object v8Object, V8Array v8Array) {
                V8Array v8Array2 = new V8Array(NodeJS.this.f64940v8);
                try {
                    v8Array2.push(file.getAbsolutePath());
                    return NodeJS.this.require.call((V8Object) null, v8Array2);
                } finally {
                    v8Array2.close();
                }
            }
        });
    }

    private static File createTemporaryScriptFile(String str, String str2) throws IOException {
        File createTempFile = File.createTempFile(str2, TMP_JS_EXT);
        PrintWriter printWriter = new PrintWriter(createTempFile, "UTF-8");
        try {
            printWriter.print(str);
            return createTempFile;
        } finally {
            printWriter.close();
        }
    }

    /* access modifiers changed from: private */
    public void init(V8Function v8Function) {
        this.require = v8Function;
    }

    private void safeRelease(Releasable releasable) {
        if (releasable != null) {
            releasable.release();
        }
    }

    public void exec(File file) {
        V8Array v8Array;
        V8Object v8Object;
        Throwable th2;
        V8Function createScriptExecutionCallback = createScriptExecutionCallback(file);
        try {
            v8Object = this.f64940v8.getObject(PROCESS);
            try {
                v8Array = new V8Array(this.f64940v8);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                v8Array = null;
                th2 = th4;
                safeRelease(v8Object);
                safeRelease(v8Array);
                safeRelease(createScriptExecutionCallback);
                throw th2;
            }
            try {
                v8Array.push((V8Value) createScriptExecutionCallback);
                v8Object.executeObjectFunction(NEXT_TICK, v8Array);
                safeRelease(v8Object);
                safeRelease(v8Array);
                safeRelease(createScriptExecutionCallback);
            } catch (Throwable th5) {
                th2 = th5;
                safeRelease(v8Object);
                safeRelease(v8Array);
                safeRelease(createScriptExecutionCallback);
                throw th2;
            }
        } catch (Throwable th6) {
            v8Array = null;
            th2 = th6;
            v8Object = null;
            safeRelease(v8Object);
            safeRelease(v8Array);
            safeRelease(createScriptExecutionCallback);
            throw th2;
        }
    }

    public String getNodeVersion() {
        V8Object v8Object;
        String str = this.nodeVersion;
        if (str != null) {
            return str;
        }
        V8Object v8Object2 = null;
        try {
            V8Object object = this.f64940v8.getObject(PROCESS);
            try {
                v8Object2 = object.getObject(VERSIONS);
                this.nodeVersion = v8Object2.getString(NODE);
                safeRelease(object);
                safeRelease(v8Object2);
                return this.nodeVersion;
            } catch (Throwable th2) {
                th = th2;
                V8Object v8Object3 = object;
                v8Object = v8Object2;
                v8Object2 = v8Object3;
                safeRelease(v8Object2);
                safeRelease(v8Object);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            v8Object = null;
            safeRelease(v8Object2);
            safeRelease(v8Object);
            throw th;
        }
    }

    public V8 getRuntime() {
        return this.f64940v8;
    }

    public boolean handleMessage() {
        this.f64940v8.checkThread();
        return this.f64940v8.pumpMessageLoop();
    }

    public boolean isRunning() {
        this.f64940v8.checkThread();
        return this.f64940v8.isRunning();
    }

    public void release() {
        this.f64940v8.checkThread();
        if (!this.require.isReleased()) {
            this.require.close();
        }
        if (!this.f64940v8.isReleased()) {
            this.f64940v8.close();
        }
    }

    public V8Object require(File file) {
        this.f64940v8.checkThread();
        V8Array v8Array = new V8Array(this.f64940v8);
        try {
            v8Array.push(file.getAbsolutePath());
            return (V8Object) this.require.call((V8Object) null, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public static NodeJS createNodeJS(File file) {
        File createTemporaryScriptFile;
        V8 createV8Runtime = V8.createV8Runtime(GLOBAL);
        NodeJS nodeJS = new NodeJS(createV8Runtime);
        createV8Runtime.registerJavaMethod((JavaVoidCallback) new JavaVoidCallback(nodeJS) {
            public final /* synthetic */ NodeJS val$node;

            {
                this.val$node = r1;
            }

            public void invoke(V8Object v8Object, V8Array v8Array) {
                V8Function v8Function = (V8Function) v8Array.get(0);
                try {
                    this.val$node.init(v8Function.twin());
                } finally {
                    v8Function.close();
                }
            }
        }, STARTUP_CALLBACK);
        try {
            createTemporaryScriptFile = createTemporaryScriptFile(STARTUP_SCRIPT, STARTUP_SCRIPT_NAME);
            createV8Runtime.createNodeRuntime(createTemporaryScriptFile.getAbsolutePath());
            createTemporaryScriptFile.delete();
            if (file != null) {
                nodeJS.exec(file);
            }
            return nodeJS;
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        } catch (Throwable th2) {
            createTemporaryScriptFile.delete();
            throw th2;
        }
    }
}
