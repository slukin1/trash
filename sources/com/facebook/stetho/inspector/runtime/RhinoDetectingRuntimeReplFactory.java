package com.facebook.stetho.inspector.runtime;

import android.content.Context;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.console.RuntimeRepl;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import java.lang.reflect.InvocationTargetException;

public class RhinoDetectingRuntimeReplFactory implements RuntimeReplFactory {
    private final Context mContext;
    /* access modifiers changed from: private */
    public RuntimeException mRhinoJsUnexpectedError;
    private RuntimeReplFactory mRhinoReplFactory;
    private boolean mSearchedForRhinoJs;

    public RhinoDetectingRuntimeReplFactory(Context context) {
        this.mContext = context;
    }

    private static RuntimeReplFactory findRhinoReplFactory(Context context) throws RuntimeException {
        try {
            return (RuntimeReplFactory) Class.forName("com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder").getDeclaredMethod("defaultFactory", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
        } catch (ClassNotFoundException unused) {
            LogUtil.i("Error finding stetho-js-rhino, cannot enable console evaluation!");
            return null;
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        } catch (IllegalAccessException e13) {
            throw new RuntimeException(e13);
        }
    }

    public RuntimeRepl newInstance() {
        if (!this.mSearchedForRhinoJs) {
            this.mSearchedForRhinoJs = true;
            try {
                this.mRhinoReplFactory = findRhinoReplFactory(this.mContext);
            } catch (RuntimeException e11) {
                this.mRhinoJsUnexpectedError = e11;
            }
        }
        RuntimeReplFactory runtimeReplFactory = this.mRhinoReplFactory;
        if (runtimeReplFactory != null) {
            return runtimeReplFactory.newInstance();
        }
        return new RuntimeRepl() {
            public Object evaluate(String str) throws Exception {
                if (RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError == null) {
                    return "Not supported without stetho-js-rhino dependency";
                }
                return "stetho-js-rhino threw: " + RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError.toString();
            }
        };
    }
}
