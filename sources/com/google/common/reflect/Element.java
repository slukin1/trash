package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

class Element extends AccessibleObject implements Member {
    private final AccessibleObject accessibleObject;
    private final Member member;

    public <M extends AccessibleObject & Member> Element(M m11) {
        Preconditions.checkNotNull(m11);
        this.accessibleObject = m11;
        this.member = (Member) m11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Element)) {
            return false;
        }
        Element element = (Element) obj;
        if (!getOwnerType().equals(element.getOwnerType()) || !this.member.equals(element.member)) {
            return false;
        }
        return true;
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.accessibleObject.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.accessibleObject.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.accessibleObject.getDeclaredAnnotations();
    }

    public Class<?> getDeclaringClass() {
        return this.member.getDeclaringClass();
    }

    public final int getModifiers() {
        return this.member.getModifiers();
    }

    public final String getName() {
        return this.member.getName();
    }

    public TypeToken<?> getOwnerType() {
        return TypeToken.of(getDeclaringClass());
    }

    public int hashCode() {
        return this.member.hashCode();
    }

    public final boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean isAccessible() {
        return this.accessibleObject.isAccessible();
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.accessibleObject.isAnnotationPresent(cls);
    }

    public final boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean isNative() {
        return Modifier.isNative(getModifiers());
    }

    public final boolean isPackagePrivate() {
        return !isPrivate() && !isPublic() && !isProtected();
    }

    public final boolean isPrivate() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean isProtected() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public final boolean isSynchronized() {
        return Modifier.isSynchronized(getModifiers());
    }

    public final boolean isSynthetic() {
        return this.member.isSynthetic();
    }

    public final boolean isTransient() {
        return Modifier.isTransient(getModifiers());
    }

    public final boolean isVolatile() {
        return Modifier.isVolatile(getModifiers());
    }

    public final void setAccessible(boolean z11) throws SecurityException {
        this.accessibleObject.setAccessible(z11);
    }

    public String toString() {
        return this.member.toString();
    }
}
