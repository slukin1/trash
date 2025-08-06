package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

public class Service {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f37518a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f37519b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f37520c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f37521d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f37522e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f37523f;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f37524a;

        /* renamed from: b  reason: collision with root package name */
        public Class<?> f37525b;

        /* renamed from: c  reason: collision with root package name */
        public Object f37526c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f37527d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f37528e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f37529f;

        public Service build() {
            Class<?> cls = this.f37524a;
            if (cls != null) {
                Class<?> cls2 = this.f37525b;
                if (cls2 == null) {
                    Object obj = this.f37526c;
                    if (obj != null) {
                        Service service = new Service((Class) cls, obj);
                        boolean unused = service.f37521d = this.f37527d;
                        return service;
                    }
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                } else if (cls2.isInterface() || !Modifier.isPublic(this.f37525b.getModifiers())) {
                    throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
                } else {
                    Service service2 = new Service((Class) this.f37524a, (Class) this.f37525b);
                    boolean unused2 = service2.f37521d = this.f37527d;
                    boolean unused3 = service2.f37522e = this.f37528e;
                    boolean unused4 = service2.f37523f = this.f37529f;
                    return service2;
                }
            } else {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
        }

        public Builder isAutoCreated(boolean z11) {
            this.f37529f = z11;
            return this;
        }

        public Builder isSharedInstance(boolean z11) {
            this.f37528e = z11;
            return this;
        }

        public Builder isSingleton(boolean z11) {
            this.f37527d = z11;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.f37525b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f37524a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f37526c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f37518a = cls;
        this.f37519b = cls2;
        this.f37520c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.f37518a = cls;
        this.f37519b = null;
        this.f37520c = obj;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.f37520c;
    }

    public Class<?> getInterface() {
        return this.f37518a;
    }

    public Class<?> getType() {
        return this.f37519b;
    }

    public boolean isAutoCreated() {
        return this.f37523f;
    }

    public boolean isSharedInstance() {
        return this.f37522e;
    }

    public boolean isSingleton() {
        return this.f37521d;
    }
}
