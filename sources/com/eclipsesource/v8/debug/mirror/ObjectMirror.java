package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;

public class ObjectMirror extends ValueMirror {
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY_NAMES = "propertyNames";

    public enum PropertyKind {
        Named(1),
        Indexed(2);
        
        public int index;

        private PropertyKind(int i11) {
            this.index = i11;
        }
    }

    public ObjectMirror(V8Object v8Object) {
        super(v8Object);
    }

    public PropertiesArray getProperties(PropertyKind propertyKind, int i11) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i11);
        V8Array v8Array2 = null;
        try {
            v8Array2 = this.v8Object.executeArrayFunction(PROPERTIES, v8Array);
            return new PropertiesArray(v8Array2);
        } finally {
            v8Array.close();
            if (v8Array2 != null && !v8Array2.isReleased()) {
                v8Array2.close();
            }
        }
    }

    public String[] getPropertyNames(PropertyKind propertyKind, int i11) {
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(propertyKind.index);
        v8Array.push(i11);
        V8Value v8Value = null;
        try {
            V8Array executeArrayFunction = this.v8Object.executeArrayFunction(PROPERTY_NAMES, v8Array);
            int length = executeArrayFunction.length();
            String[] strArr = new String[length];
            for (int i12 = 0; i12 < length; i12++) {
                strArr[i12] = executeArrayFunction.getString(i12);
            }
            v8Array.close();
            executeArrayFunction.close();
            return strArr;
        } catch (Throwable th2) {
            v8Array.close();
            if (v8Value != null) {
                v8Value.close();
            }
            throw th2;
        }
    }

    public boolean isObject() {
        return true;
    }

    public String toString() {
        return this.v8Object.toString();
    }
}
