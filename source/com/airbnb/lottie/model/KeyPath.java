package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    private final List<String> keys;
    private KeyPathElement resolvedElement;

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    private boolean endsWithGlobstar() {
        List<String> list = this.keys;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean isContainer(String str) {
        return "__container".equals(str);
    }

    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(str);
        return keyPath;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyPath keyPath = (KeyPath) obj;
        if (!this.keys.equals(keyPath.keys)) {
            return false;
        }
        KeyPathElement keyPathElement = this.resolvedElement;
        KeyPathElement keyPathElement2 = keyPath.resolvedElement;
        if (keyPathElement != null) {
            return keyPathElement.equals(keyPathElement2);
        }
        if (keyPathElement2 == null) {
            return true;
        }
        return false;
    }

    public boolean fullyResolvesTo(String str, int i11) {
        if (i11 >= this.keys.size()) {
            return false;
        }
        boolean z11 = i11 == this.keys.size() - 1;
        String str2 = this.keys.get(i11);
        if (!str2.equals("**")) {
            boolean z12 = str2.equals(str) || str2.equals("*");
            if ((z11 || (i11 == this.keys.size() - 2 && endsWithGlobstar())) && z12) {
                return true;
            }
            return false;
        }
        if (!z11 && this.keys.get(i11 + 1).equals(str)) {
            if (i11 == this.keys.size() - 2 || (i11 == this.keys.size() - 3 && endsWithGlobstar())) {
                return true;
            }
            return false;
        } else if (z11) {
            return true;
        } else {
            int i12 = i11 + 1;
            if (i12 < this.keys.size() - 1) {
                return false;
            }
            return this.keys.get(i12).equals(str);
        }
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public int hashCode() {
        int hashCode = this.keys.hashCode() * 31;
        KeyPathElement keyPathElement = this.resolvedElement;
        return hashCode + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    public int incrementDepthBy(String str, int i11) {
        if (isContainer(str)) {
            return 0;
        }
        if (!this.keys.get(i11).equals("**")) {
            return 1;
        }
        if (i11 != this.keys.size() - 1 && this.keys.get(i11 + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public String keysToString() {
        return this.keys.toString();
    }

    public boolean matches(String str, int i11) {
        if (isContainer(str)) {
            return true;
        }
        if (i11 >= this.keys.size()) {
            return false;
        }
        if (this.keys.get(i11).equals(str) || this.keys.get(i11).equals("**") || this.keys.get(i11).equals("*")) {
            return true;
        }
        return false;
    }

    public boolean propagateToChildren(String str, int i11) {
        if (!"__container".equals(str) && i11 >= this.keys.size() - 1 && !this.keys.get(i11).equals("**")) {
            return false;
        }
        return true;
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPath{keys=");
        sb2.append(this.keys);
        sb2.append(",resolved=");
        sb2.append(this.resolvedElement != null);
        sb2.append('}');
        return sb2.toString();
    }

    private KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }
}
