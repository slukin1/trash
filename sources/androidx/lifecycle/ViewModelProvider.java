package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.r;

public class ViewModelProvider {

    /* renamed from: a  reason: collision with root package name */
    public final ViewModelStore f9959a;

    /* renamed from: b  reason: collision with root package name */
    public final Factory f9960b;

    /* renamed from: c  reason: collision with root package name */
    public final CreationExtras f9961c;

    public interface Factory {

        /* renamed from: e  reason: collision with root package name */
        public static final a f9967e = a.f9968a;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ a f9968a = new a();
        }

        <T extends ViewModel> T create(Class<T> cls);

        <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras);
    }

    public static class NewInstanceFactory implements Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final a f9969a = new a((r) null);

        /* renamed from: b  reason: collision with root package name */
        public static NewInstanceFactory f9970b;

        /* renamed from: c  reason: collision with root package name */
        public static final CreationExtras.b<String> f9971c = a.C0044a.f9972a;

        public static final class a {

            /* renamed from: androidx.lifecycle.ViewModelProvider$NewInstanceFactory$a$a  reason: collision with other inner class name */
            public static final class C0044a implements CreationExtras.b<String> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0044a f9972a = new C0044a();
            }

            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }

            public final NewInstanceFactory a() {
                if (NewInstanceFactory.f9970b == null) {
                    NewInstanceFactory.f9970b = new NewInstanceFactory();
                }
                return NewInstanceFactory.f9970b;
            }
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            try {
                return (ViewModel) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (NoSuchMethodException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (InstantiationException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (IllegalAccessException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return o0.b(this, cls, creationExtras);
        }
    }

    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
        }
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this(viewModelStore, factory, (CreationExtras) null, 4, (r) null);
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
        this.f9959a = viewModelStore;
        this.f9960b = factory;
        this.f9961c = creationExtras;
    }

    public <T extends ViewModel> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T b(String str, Class<T> cls) {
        T t11;
        T b11 = this.f9959a.b(str);
        if (cls.isInstance(b11)) {
            Factory factory = this.f9960b;
            OnRequeryFactory onRequeryFactory = factory instanceof OnRequeryFactory ? (OnRequeryFactory) factory : null;
            if (onRequeryFactory != null) {
                onRequeryFactory.onRequery(b11);
            }
            return b11;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.f9961c);
        mutableCreationExtras.c(NewInstanceFactory.f9971c, str);
        try {
            t11 = this.f9960b.create(cls, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t11 = this.f9960b.create(cls);
        }
        this.f9959a.d(str, t11);
        return t11;
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {

        /* renamed from: f  reason: collision with root package name */
        public static final a f9962f = new a((r) null);

        /* renamed from: g  reason: collision with root package name */
        public static AndroidViewModelFactory f9963g;

        /* renamed from: h  reason: collision with root package name */
        public static final CreationExtras.b<Application> f9964h = a.C0043a.f9966a;

        /* renamed from: d  reason: collision with root package name */
        public final Application f9965d;

        public static final class a {

            /* renamed from: androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory$a$a  reason: collision with other inner class name */
            public static final class C0043a implements CreationExtras.b<Application> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0043a f9966a = new C0043a();
            }

            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }

            public final Factory a(q0 q0Var) {
                return q0Var instanceof o ? ((o) q0Var).getDefaultViewModelProviderFactory() : NewInstanceFactory.f9969a.a();
            }

            public final AndroidViewModelFactory b(Application application) {
                if (AndroidViewModelFactory.f9963g == null) {
                    AndroidViewModelFactory.f9963g = new AndroidViewModelFactory(application);
                }
                return AndroidViewModelFactory.f9963g;
            }
        }

        public AndroidViewModelFactory(Application application, int i11) {
            this.f9965d = application;
        }

        public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            if (this.f9965d != null) {
                return create(cls);
            }
            Application application = (Application) creationExtras.a(f9964h);
            if (application != null) {
                return e(cls, application);
            }
            if (!a.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public final <T extends ViewModel> T e(Class<T> cls, Application application) {
            if (!a.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application});
            } catch (NoSuchMethodException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (IllegalAccessException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InstantiationException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            } catch (InvocationTargetException e14) {
                throw new RuntimeException("Cannot create an instance of " + cls, e14);
            }
        }

        public AndroidViewModelFactory() {
            this((Application) null, 0);
        }

        public AndroidViewModelFactory(Application application) {
            this(application, 0);
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Application application = this.f9965d;
            if (application != null) {
                return e(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i11, r rVar) {
        this(viewModelStore, factory, (i11 & 4) != 0 ? CreationExtras.a.f10040b : creationExtras);
    }

    public ViewModelProvider(q0 q0Var) {
        this(q0Var.getViewModelStore(), AndroidViewModelFactory.f9962f.a(q0Var), p0.a(q0Var));
    }

    public ViewModelProvider(q0 q0Var, Factory factory) {
        this(q0Var.getViewModelStore(), factory, p0.a(q0Var));
    }
}
