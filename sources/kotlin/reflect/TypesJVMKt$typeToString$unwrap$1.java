package kotlin.reflect;

import d10.l;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements l<Class<?>, Class<?>> {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    public TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    public final Class<?> invoke(Class<?> cls) {
        return cls.getComponentType();
    }
}
