package com.alibaba.android.arouter.facade;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import b2.a;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.IProvider;
import java.io.Serializable;
import java.util.ArrayList;
import p0.c;

public final class Postcard extends RouteMeta {
    private String action;
    private int enterAnim;
    private int exitAnim;
    private int flags;
    private boolean greenChannel;
    private Bundle mBundle;
    private Bundle optionsCompat;
    private IProvider provider;
    private SerializationService serializationService;
    private Object tag;
    private int timeout;
    private Uri uri;

    public Postcard() {
        this((String) null, (String) null);
    }

    public Postcard addFlags(int i11) {
        this.flags = i11 | this.flags;
        return this;
    }

    public String getAction() {
        return this.action;
    }

    public int getEnterAnim() {
        return this.enterAnim;
    }

    public int getExitAnim() {
        return this.exitAnim;
    }

    public Bundle getExtras() {
        return this.mBundle;
    }

    public int getFlags() {
        return this.flags;
    }

    public Bundle getOptionsBundle() {
        return this.optionsCompat;
    }

    public IProvider getProvider() {
        return this.provider;
    }

    public Object getTag() {
        return this.tag;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public Uri getUri() {
        return this.uri;
    }

    public Postcard greenChannel() {
        this.greenChannel = true;
        return this;
    }

    public boolean isGreenChannel() {
        return this.greenChannel;
    }

    public Object navigation() {
        return navigation((Context) null);
    }

    public Postcard setProvider(IProvider iProvider) {
        this.provider = iProvider;
        return this;
    }

    public Postcard setTag(Object obj) {
        this.tag = obj;
        return this;
    }

    public Postcard setTimeout(int i11) {
        this.timeout = i11;
        return this;
    }

    public Postcard setUri(Uri uri2) {
        this.uri = uri2;
        return this;
    }

    public String toString() {
        return "Postcard{uri=" + this.uri + ", tag=" + this.tag + ", mBundle=" + this.mBundle + ", flags=" + this.flags + ", timeout=" + this.timeout + ", provider=" + this.provider + ", greenChannel=" + this.greenChannel + ", optionsCompat=" + this.optionsCompat + ", enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + "}\n" + super.toString();
    }

    public Postcard with(Bundle bundle) {
        if (bundle != null) {
            this.mBundle = bundle;
        }
        return this;
    }

    public Postcard withAction(String str) {
        this.action = str;
        return this;
    }

    public Postcard withBoolean(String str, boolean z11) {
        this.mBundle.putBoolean(str, z11);
        return this;
    }

    public Postcard withBundle(String str, Bundle bundle) {
        this.mBundle.putBundle(str, bundle);
        return this;
    }

    public Postcard withByte(String str, byte b11) {
        this.mBundle.putByte(str, b11);
        return this;
    }

    public Postcard withByteArray(String str, byte[] bArr) {
        this.mBundle.putByteArray(str, bArr);
        return this;
    }

    public Postcard withChar(String str, char c11) {
        this.mBundle.putChar(str, c11);
        return this;
    }

    public Postcard withCharArray(String str, char[] cArr) {
        this.mBundle.putCharArray(str, cArr);
        return this;
    }

    public Postcard withCharSequence(String str, CharSequence charSequence) {
        this.mBundle.putCharSequence(str, charSequence);
        return this;
    }

    public Postcard withCharSequenceArray(String str, CharSequence[] charSequenceArr) {
        this.mBundle.putCharSequenceArray(str, charSequenceArr);
        return this;
    }

    public Postcard withCharSequenceArrayList(String str, ArrayList<CharSequence> arrayList) {
        this.mBundle.putCharSequenceArrayList(str, arrayList);
        return this;
    }

    public Postcard withDouble(String str, double d11) {
        this.mBundle.putDouble(str, d11);
        return this;
    }

    public Postcard withFlags(int i11) {
        this.flags = i11;
        return this;
    }

    public Postcard withFloat(String str, float f11) {
        this.mBundle.putFloat(str, f11);
        return this;
    }

    public Postcard withFloatArray(String str, float[] fArr) {
        this.mBundle.putFloatArray(str, fArr);
        return this;
    }

    public Postcard withInt(String str, int i11) {
        this.mBundle.putInt(str, i11);
        return this;
    }

    public Postcard withIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        this.mBundle.putIntegerArrayList(str, arrayList);
        return this;
    }

    public Postcard withLong(String str, long j11) {
        this.mBundle.putLong(str, j11);
        return this;
    }

    public Postcard withObject(String str, Object obj) {
        SerializationService serializationService2 = (SerializationService) a.d().h(SerializationService.class);
        this.serializationService = serializationService2;
        this.mBundle.putString(str, serializationService2.object2Json(obj));
        return this;
    }

    public Postcard withOptionsCompat(c cVar) {
        if (cVar != null) {
            this.optionsCompat = cVar.b();
        }
        return this;
    }

    public Postcard withParcelable(String str, Parcelable parcelable) {
        this.mBundle.putParcelable(str, parcelable);
        return this;
    }

    public Postcard withParcelableArray(String str, Parcelable[] parcelableArr) {
        this.mBundle.putParcelableArray(str, parcelableArr);
        return this;
    }

    public Postcard withParcelableArrayList(String str, ArrayList<? extends Parcelable> arrayList) {
        this.mBundle.putParcelableArrayList(str, arrayList);
        return this;
    }

    public Postcard withSerializable(String str, Serializable serializable) {
        this.mBundle.putSerializable(str, serializable);
        return this;
    }

    public Postcard withShort(String str, short s11) {
        this.mBundle.putShort(str, s11);
        return this;
    }

    public Postcard withShortArray(String str, short[] sArr) {
        this.mBundle.putShortArray(str, sArr);
        return this;
    }

    public Postcard withSparseParcelableArray(String str, SparseArray<? extends Parcelable> sparseArray) {
        this.mBundle.putSparseParcelableArray(str, sparseArray);
        return this;
    }

    public Postcard withString(String str, String str2) {
        this.mBundle.putString(str, str2);
        return this;
    }

    public Postcard withStringArrayList(String str, ArrayList<String> arrayList) {
        this.mBundle.putStringArrayList(str, arrayList);
        return this;
    }

    public Postcard withTransition(int i11, int i12) {
        this.enterAnim = i11;
        this.exitAnim = i12;
        return this;
    }

    public Postcard(String str, String str2) {
        this(str, str2, (Uri) null, (Bundle) null);
    }

    public Object navigation(Context context) {
        return navigation(context, (NavigationCallback) null);
    }

    public Postcard(String str, String str2, Uri uri2, Bundle bundle) {
        this.flags = -1;
        this.timeout = 300;
        this.enterAnim = -1;
        this.exitAnim = -1;
        setPath(str);
        setGroup(str2);
        setUri(uri2);
        this.mBundle = bundle == null ? new Bundle() : bundle;
    }

    public Object navigation(Context context, NavigationCallback navigationCallback) {
        return a.d().g(context, this, -1, navigationCallback);
    }

    public void navigation(Activity activity, int i11) {
        navigation(activity, i11, (NavigationCallback) null);
    }

    public void navigation(Activity activity, int i11, NavigationCallback navigationCallback) {
        a.d().g(activity, this, i11, navigationCallback);
    }
}
