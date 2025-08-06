package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.view.View;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Caller {
    private static final String TAG = "SA.Caller";
    private final Object[] mMethodArgs;
    private final String mMethodName;
    private final Class<?> mMethodResultType;
    private final Class<?> mTargetClass;
    private final Method mTargetMethod;

    public Caller(Class<?> cls, String str, Object[] objArr, Class<?> cls2) throws NoSuchMethodException {
        this.mMethodName = str;
        this.mMethodArgs = objArr;
        this.mMethodResultType = cls2;
        Method pickMethod = pickMethod(cls);
        this.mTargetMethod = pickMethod;
        if (pickMethod != null) {
            this.mTargetClass = pickMethod.getDeclaringClass();
            pickMethod.setAccessible(true);
            return;
        }
        throw new NoSuchMethodException("Method " + cls.getName() + InstructionFileId.DOT + str + " doesn't exit");
    }

    private static Class<?> assignableArgType(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return cls == Character.class ? Character.TYPE : cls;
    }

    private Method pickMethod(Class<?> cls) {
        Class[] clsArr = new Class[this.mMethodArgs.length];
        int i11 = 0;
        while (true) {
            Object[] objArr = this.mMethodArgs;
            if (i11 >= objArr.length) {
                break;
            }
            clsArr[i11] = objArr[i11].getClass();
            i11++;
        }
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.mMethodName) && parameterTypes.length == this.mMethodArgs.length && assignableArgType(this.mMethodResultType).isAssignableFrom(assignableArgType(method.getReturnType()))) {
                boolean z11 = true;
                for (int i12 = 0; i12 < parameterTypes.length && z11; i12++) {
                    z11 = assignableArgType(parameterTypes[i12]).isAssignableFrom(assignableArgType(clsArr[i12]));
                }
                if (z11) {
                    return method;
                }
            }
        }
        return null;
    }

    public Object applyMethod(View view) {
        return applyMethodWithArguments(view, this.mMethodArgs);
    }

    public Object applyMethodWithArguments(View view, Object[] objArr) {
        if (!this.mTargetClass.isAssignableFrom(view.getClass())) {
            return null;
        }
        try {
            return this.mTargetMethod.invoke(view, objArr);
        } catch (IllegalAccessException e11) {
            SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " appears not to be public", e11);
            return null;
        } catch (IllegalArgumentException e12) {
            SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " called with arguments of the wrong type", e12);
            return null;
        } catch (InvocationTargetException e13) {
            SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " threw an exception", e13);
            return null;
        }
    }

    public boolean argsAreApplicable(Object[] objArr) {
        Class[] parameterTypes = this.mTargetMethod.getParameterTypes();
        if (objArr.length != parameterTypes.length) {
            return false;
        }
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Class<?> assignableArgType = assignableArgType(parameterTypes[i11]);
            if (objArr[i11] == null) {
                if (assignableArgType == Byte.TYPE || assignableArgType == Short.TYPE || assignableArgType == Integer.TYPE || assignableArgType == Long.TYPE || assignableArgType == Float.TYPE || assignableArgType == Double.TYPE || assignableArgType == Boolean.TYPE || assignableArgType == Character.TYPE) {
                    return false;
                }
            } else if (!assignableArgType.isAssignableFrom(assignableArgType(objArr[i11].getClass()))) {
                return false;
            }
        }
        return true;
    }

    public Object[] getArgs() {
        return this.mMethodArgs;
    }

    public String toString() {
        return "[Caller " + this.mMethodName + "(" + this.mMethodArgs + ")]";
    }
}
