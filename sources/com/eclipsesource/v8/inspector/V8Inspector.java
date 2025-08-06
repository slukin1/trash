package com.eclipsesource.v8.inspector;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import java.util.ArrayList;
import java.util.List;

public class V8Inspector {
    private List<DebuggerConnectionListener> debuggerConnectionListeners;
    private long inspectorPtr = 0;
    private V8 runtime;
    private boolean waitingForConnection = true;

    public V8Inspector(V8 v82, V8InspectorDelegate v8InspectorDelegate, String str) {
        this.runtime = v82;
        this.inspectorPtr = v82.createInspector(v8InspectorDelegate, str);
        this.debuggerConnectionListeners = new ArrayList();
    }

    public static V8Inspector createV8Inspector(V8 v82, V8InspectorDelegate v8InspectorDelegate, String str) {
        return new V8Inspector(v82, v8InspectorDelegate, str);
    }

    private void verifyDebuggerConnection(String str) {
        V8Value v8Value = null;
        try {
            V8 v82 = this.runtime;
            V8Object executeObjectScript = v82.executeObjectScript("JSON.parse(JSON.stringify(" + str + "))");
            if (executeObjectScript.getString("method").equals("Runtime.runIfWaitingForDebugger")) {
                this.waitingForConnection = false;
                this.runtime.schedulePauseOnNextStatement(this.inspectorPtr, "");
                for (DebuggerConnectionListener onDebuggerConnected : this.debuggerConnectionListeners) {
                    onDebuggerConnected.onDebuggerConnected();
                }
            }
            executeObjectScript.close();
        } catch (Throwable th2) {
            if (v8Value != null) {
                v8Value.close();
            }
            throw th2;
        }
    }

    public void addDebuggerConnectionListener(DebuggerConnectionListener debuggerConnectionListener) {
        this.debuggerConnectionListeners.add(debuggerConnectionListener);
    }

    public void dispatchProtocolMessage(String str) {
        try {
            this.runtime.dispatchProtocolMessage(this.inspectorPtr, str);
            if (this.waitingForConnection) {
                verifyDebuggerConnection(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void removeDebuggerConnectionListener(DebuggerConnectionListener debuggerConnectionListener) {
        this.debuggerConnectionListeners.remove(debuggerConnectionListener);
    }

    public static V8Inspector createV8Inspector(V8 v82, V8InspectorDelegate v8InspectorDelegate) {
        return new V8Inspector(v82, v8InspectorDelegate, (String) null);
    }
}
