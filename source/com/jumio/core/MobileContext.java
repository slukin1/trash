package com.jumio.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.jumio.commons.log.Log;
import com.jumio.core.models.AuthorizationModel;
import d10.p;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import jumio.core.q0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class MobileContext extends ContextWrapper implements q0 {

    /* renamed from: a  reason: collision with root package name */
    public final AuthorizationModel f39021a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39022b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MobileContext(Context context, AuthorizationModel authorizationModel, int i11, int i12, r rVar) {
        this(context, authorizationModel, (i12 & 4) != 0 ? 0 : i11);
    }

    public final int getCustomThemeId() {
        return this.f39022b;
    }

    public final <T> Map<Integer, T> getCustomizations(int i11, int i12, int[] iArr, p<? super TypedArray, ? super Integer, ? extends T> pVar) {
        Resources.Theme theme;
        TypedValue typedValue = new TypedValue();
        if (this.f39022b != 0) {
            theme = new ContextThemeWrapper(this, this.f39022b).getTheme();
        } else {
            theme = getTheme();
        }
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i11, iArr);
        TypedArray typedArray = null;
        HashMap hashMap = new HashMap();
        try {
            if (theme.resolveAttribute(i12, typedValue, true)) {
                typedArray = theme.obtainStyledAttributes(typedValue.data, iArr);
            }
            int length = iArr.length;
            for (int i13 = 0; i13 < length; i13++) {
                hashMap.put(Integer.valueOf(iArr[i13]), pVar.invoke(obtainStyledAttributes, Integer.valueOf(i13)));
                if (typedArray != null && !x.b(pVar.invoke(typedArray, Integer.valueOf(i13)), -1)) {
                    hashMap.put(Integer.valueOf(iArr[i13]), pVar.invoke(typedArray, Integer.valueOf(i13)));
                }
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        return hashMap;
    }

    public AuthorizationModel.SessionKey getSessionKey() {
        return this.f39021a.getSessionKey();
    }

    public MobileContext(Context context, AuthorizationModel authorizationModel, int i11) {
        super(context);
        this.f39021a = authorizationModel;
        this.f39022b = i11;
    }
}
