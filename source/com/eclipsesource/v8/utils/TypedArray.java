package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8TypedArray;

public class TypedArray {
    private V8TypedArray typedArray;

    public TypedArray(V8TypedArray v8TypedArray) {
        this.typedArray = (V8TypedArray) v8TypedArray.twin().setWeak();
    }

    public V8TypedArray getV8TypedArray() {
        return (V8TypedArray) this.typedArray.twin();
    }

    public boolean isAvailable() {
        return !this.typedArray.isReleased();
    }

    public TypedArray(V8 v82, ArrayBuffer arrayBuffer, int i11, int i12, int i13) {
        V8ArrayBuffer v8ArrayBuffer = arrayBuffer.getV8ArrayBuffer();
        V8TypedArray v8TypedArray = new V8TypedArray(v82, v8ArrayBuffer, i11, i12, i13);
        try {
            this.typedArray = (V8TypedArray) v8TypedArray.twin().setWeak();
        } finally {
            v8ArrayBuffer.close();
            v8TypedArray.close();
        }
    }
}
