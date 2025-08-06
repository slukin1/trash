package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlPullParserException;

public class n0 extends w {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4652c = false;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f4653b;

    public n0(Context context, Resources resources) {
        super(resources);
        this.f4653b = new WeakReference<>(context);
    }

    public static boolean b() {
        return f4652c;
    }

    public static void c(boolean z11) {
        f4652c = z11;
    }

    public static boolean d() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getAnimation(int i11) throws Resources.NotFoundException {
        return super.getAnimation(i11);
    }

    public /* bridge */ /* synthetic */ boolean getBoolean(int i11) throws Resources.NotFoundException {
        return super.getBoolean(i11);
    }

    public /* bridge */ /* synthetic */ int getColor(int i11) throws Resources.NotFoundException {
        return super.getColor(i11);
    }

    public /* bridge */ /* synthetic */ ColorStateList getColorStateList(int i11) throws Resources.NotFoundException {
        return super.getColorStateList(i11);
    }

    public /* bridge */ /* synthetic */ Configuration getConfiguration() {
        return super.getConfiguration();
    }

    public /* bridge */ /* synthetic */ float getDimension(int i11) throws Resources.NotFoundException {
        return super.getDimension(i11);
    }

    public /* bridge */ /* synthetic */ int getDimensionPixelOffset(int i11) throws Resources.NotFoundException {
        return super.getDimensionPixelOffset(i11);
    }

    public /* bridge */ /* synthetic */ int getDimensionPixelSize(int i11) throws Resources.NotFoundException {
        return super.getDimensionPixelSize(i11);
    }

    public /* bridge */ /* synthetic */ DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    public /* bridge */ /* synthetic */ Drawable getDrawable(int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return super.getDrawable(i11, theme);
    }

    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i11, int i12) throws Resources.NotFoundException {
        return super.getDrawableForDensity(i11, i12);
    }

    public /* bridge */ /* synthetic */ float getFraction(int i11, int i12, int i13) {
        return super.getFraction(i11, i12, i13);
    }

    public /* bridge */ /* synthetic */ int getIdentifier(String str, String str2, String str3) {
        return super.getIdentifier(str, str2, str3);
    }

    public /* bridge */ /* synthetic */ int[] getIntArray(int i11) throws Resources.NotFoundException {
        return super.getIntArray(i11);
    }

    public /* bridge */ /* synthetic */ int getInteger(int i11) throws Resources.NotFoundException {
        return super.getInteger(i11);
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getLayout(int i11) throws Resources.NotFoundException {
        return super.getLayout(i11);
    }

    public /* bridge */ /* synthetic */ Movie getMovie(int i11) throws Resources.NotFoundException {
        return super.getMovie(i11);
    }

    public /* bridge */ /* synthetic */ String getQuantityString(int i11, int i12) throws Resources.NotFoundException {
        return super.getQuantityString(i11, i12);
    }

    public /* bridge */ /* synthetic */ CharSequence getQuantityText(int i11, int i12) throws Resources.NotFoundException {
        return super.getQuantityText(i11, i12);
    }

    public /* bridge */ /* synthetic */ String getResourceEntryName(int i11) throws Resources.NotFoundException {
        return super.getResourceEntryName(i11);
    }

    public /* bridge */ /* synthetic */ String getResourceName(int i11) throws Resources.NotFoundException {
        return super.getResourceName(i11);
    }

    public /* bridge */ /* synthetic */ String getResourcePackageName(int i11) throws Resources.NotFoundException {
        return super.getResourcePackageName(i11);
    }

    public /* bridge */ /* synthetic */ String getResourceTypeName(int i11) throws Resources.NotFoundException {
        return super.getResourceTypeName(i11);
    }

    public /* bridge */ /* synthetic */ String getString(int i11) throws Resources.NotFoundException {
        return super.getString(i11);
    }

    public /* bridge */ /* synthetic */ String[] getStringArray(int i11) throws Resources.NotFoundException {
        return super.getStringArray(i11);
    }

    public /* bridge */ /* synthetic */ CharSequence getText(int i11) throws Resources.NotFoundException {
        return super.getText(i11);
    }

    public /* bridge */ /* synthetic */ CharSequence[] getTextArray(int i11) throws Resources.NotFoundException {
        return super.getTextArray(i11);
    }

    public /* bridge */ /* synthetic */ void getValue(int i11, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        super.getValue(i11, typedValue, z11);
    }

    public /* bridge */ /* synthetic */ void getValueForDensity(int i11, int i12, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        super.getValueForDensity(i11, i12, typedValue, z11);
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getXml(int i11) throws Resources.NotFoundException {
        return super.getXml(i11);
    }

    public /* bridge */ /* synthetic */ TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    public /* bridge */ /* synthetic */ TypedArray obtainTypedArray(int i11) throws Resources.NotFoundException {
        return super.obtainTypedArray(i11);
    }

    public /* bridge */ /* synthetic */ InputStream openRawResource(int i11) throws Resources.NotFoundException {
        return super.openRawResource(i11);
    }

    public /* bridge */ /* synthetic */ AssetFileDescriptor openRawResourceFd(int i11) throws Resources.NotFoundException {
        return super.openRawResourceFd(i11);
    }

    public /* bridge */ /* synthetic */ void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    public /* bridge */ /* synthetic */ void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    public /* bridge */ /* synthetic */ void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    public Drawable getDrawable(int i11) throws Resources.NotFoundException {
        Context context = (Context) this.f4653b.get();
        if (context != null) {
            return ResourceManagerInternal.h().t(context, this, i11);
        }
        return a(i11);
    }

    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i11, int i12, Resources.Theme theme) {
        return super.getDrawableForDensity(i11, i12, theme);
    }

    public /* bridge */ /* synthetic */ String getQuantityString(int i11, int i12, Object[] objArr) throws Resources.NotFoundException {
        return super.getQuantityString(i11, i12, objArr);
    }

    public /* bridge */ /* synthetic */ String getString(int i11, Object[] objArr) throws Resources.NotFoundException {
        return super.getString(i11, objArr);
    }

    public /* bridge */ /* synthetic */ CharSequence getText(int i11, CharSequence charSequence) {
        return super.getText(i11, charSequence);
    }

    public /* bridge */ /* synthetic */ void getValue(String str, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        super.getValue(str, typedValue, z11);
    }

    public /* bridge */ /* synthetic */ InputStream openRawResource(int i11, TypedValue typedValue) throws Resources.NotFoundException {
        return super.openRawResource(i11, typedValue);
    }
}
