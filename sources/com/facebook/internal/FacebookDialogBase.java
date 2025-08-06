package com.facebook.internal;

import android.app.Activity;
import android.util.Log;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.List;

public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    public static final Object BASE_AUTOMATIC_MODE = new Object();
    private static final String TAG = "FacebookDialog";
    private final Activity activity;
    private final FragmentWrapper fragmentWrapper;
    private List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    private int requestCode;

    public abstract class ModeHandler {
        public ModeHandler() {
        }

        public abstract boolean canShow(CONTENT content, boolean z11);

        public abstract AppCall createAppCall(CONTENT content);

        public Object getMode() {
            return FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
    }

    public FacebookDialogBase(Activity activity2, int i11) {
        Validate.notNull(activity2, "activity");
        this.activity = activity2;
        this.fragmentWrapper = null;
        this.requestCode = i11;
    }

    private List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        return this.modeHandlers;
    }

    private AppCall createAppCallForMode(CONTENT content, Object obj) {
        boolean z11 = obj == BASE_AUTOMATIC_MODE;
        AppCall appCall = null;
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it2 = cachedModeHandlers().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ModeHandler next = it2.next();
            if ((z11 || Utility.areObjectsEqual(next.getMode(), obj)) && next.canShow(content, true)) {
                try {
                    appCall = next.createAppCall(content);
                    break;
                } catch (FacebookException e11) {
                    appCall = createBaseAppCall();
                    DialogPresenter.setupAppCallForValidationError(appCall, e11);
                }
            }
        }
        if (appCall != null) {
            return appCall;
        }
        AppCall createBaseAppCall = createBaseAppCall();
        DialogPresenter.setupAppCallForCannotShowError(createBaseAppCall);
        return createBaseAppCall;
    }

    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    public boolean canShowImpl(CONTENT content, Object obj) {
        boolean z11 = obj == BASE_AUTOMATIC_MODE;
        for (ModeHandler next : cachedModeHandlers()) {
            if ((z11 || Utility.areObjectsEqual(next.getMode(), obj)) && next.canShow(content, false)) {
                return true;
            }
        }
        return false;
    }

    public abstract AppCall createBaseAppCall();

    public Activity getActivityContext() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
        if (fragmentWrapper2 != null) {
            return fragmentWrapper2.getActivity();
        }
        return null;
    }

    public abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    public int getRequestCode() {
        return this.requestCode;
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            registerCallbackImpl((CallbackManagerImpl) callbackManager, facebookCallback);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public abstract void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<RESULT> facebookCallback);

    public void setRequestCode(int i11) {
        if (!FacebookSdk.isFacebookRequestCode(i11)) {
            this.requestCode = i11;
            return;
        }
        throw new IllegalArgumentException("Request code " + i11 + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    public void showImpl(CONTENT content, Object obj) {
        AppCall createAppCallForMode = createAppCallForMode(content, obj);
        if (createAppCallForMode != null) {
            FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
            if (fragmentWrapper2 != null) {
                DialogPresenter.present(createAppCallForMode, fragmentWrapper2);
            } else {
                DialogPresenter.present(createAppCallForMode, this.activity);
            }
        } else {
            Log.e(TAG, "No code path should ever result in a null appCall");
            if (FacebookSdk.isDebugEnabled()) {
                throw new IllegalStateException("No code path should ever result in a null appCall");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startActivityForResult(android.content.Intent r3, int r4) {
        /*
            r2 = this;
            android.app.Activity r0 = r2.activity
            java.lang.String r1 = "Failed to find Activity or Fragment to startActivityForResult "
            if (r0 == 0) goto L_0x000a
            r0.startActivityForResult(r3, r4)
            goto L_0x002f
        L_0x000a:
            com.facebook.internal.FragmentWrapper r0 = r2.fragmentWrapper
            if (r0 == 0) goto L_0x0030
            android.app.Fragment r0 = r0.getNativeFragment()
            if (r0 == 0) goto L_0x001e
            com.facebook.internal.FragmentWrapper r0 = r2.fragmentWrapper
            android.app.Fragment r0 = r0.getNativeFragment()
            r0.startActivityForResult(r3, r4)
            goto L_0x002f
        L_0x001e:
            com.facebook.internal.FragmentWrapper r0 = r2.fragmentWrapper
            androidx.fragment.app.Fragment r0 = r0.getSupportFragment()
            if (r0 == 0) goto L_0x0030
            com.facebook.internal.FragmentWrapper r0 = r2.fragmentWrapper
            androidx.fragment.app.Fragment r0 = r0.getSupportFragment()
            r0.startActivityForResult(r3, r4)
        L_0x002f:
            r1 = 0
        L_0x0030:
            if (r1 == 0) goto L_0x0040
            com.facebook.LoggingBehavior r3 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r4 = 6
            java.lang.Class r0 = r2.getClass()
            java.lang.String r0 = r0.getName()
            com.facebook.internal.Logger.log((com.facebook.LoggingBehavior) r3, (int) r4, (java.lang.String) r0, (java.lang.String) r1)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback, int i11) {
        setRequestCode(i11);
        registerCallback(callbackManager, facebookCallback);
    }

    public FacebookDialogBase(FragmentWrapper fragmentWrapper2, int i11) {
        Validate.notNull(fragmentWrapper2, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper2;
        this.activity = null;
        this.requestCode = i11;
        if (fragmentWrapper2.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }
}
