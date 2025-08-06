package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.ReferenceHandler;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Value;
import java.util.ArrayList;
import java.util.Iterator;

public class MemoryManager {
    private MemoryManagerReferenceHandler memoryManagerReferenceHandler;
    /* access modifiers changed from: private */
    public ArrayList<V8Value> references = new ArrayList<>();
    private boolean released = false;
    /* access modifiers changed from: private */
    public boolean releasing = false;

    /* renamed from: v8  reason: collision with root package name */
    private V8 f64943v8;

    public class MemoryManagerReferenceHandler implements ReferenceHandler {
        private MemoryManagerReferenceHandler() {
        }

        public void v8HandleCreated(V8Value v8Value) {
            MemoryManager.this.references.add(v8Value);
        }

        public void v8HandleDisposed(V8Value v8Value) {
            if (!MemoryManager.this.releasing) {
                Iterator it2 = MemoryManager.this.references.iterator();
                while (it2.hasNext()) {
                    if (it2.next() == v8Value) {
                        it2.remove();
                        return;
                    }
                }
            }
        }
    }

    public MemoryManager(V8 v82) {
        this.f64943v8 = v82;
        MemoryManagerReferenceHandler memoryManagerReferenceHandler2 = new MemoryManagerReferenceHandler();
        this.memoryManagerReferenceHandler = memoryManagerReferenceHandler2;
        v82.addReferenceHandler(memoryManagerReferenceHandler2);
    }

    private void checkReleased() {
        if (this.released) {
            throw new IllegalStateException("Memory manager released");
        }
    }

    public int getObjectReferenceCount() {
        checkReleased();
        return this.references.size();
    }

    public boolean isReleased() {
        return this.released;
    }

    public void persist(V8Value v8Value) {
        this.f64943v8.getLocker().checkThread();
        checkReleased();
        this.references.remove(v8Value);
    }

    /* JADX INFO: finally extract failed */
    public void release() {
        this.f64943v8.getLocker().checkThread();
        if (!this.released) {
            this.releasing = true;
            try {
                Iterator<V8Value> it2 = this.references.iterator();
                while (it2.hasNext()) {
                    it2.next().close();
                }
                this.f64943v8.removeReferenceHandler(this.memoryManagerReferenceHandler);
                this.references.clear();
                this.releasing = false;
                this.released = true;
            } catch (Throwable th2) {
                this.releasing = false;
                throw th2;
            }
        }
    }
}
