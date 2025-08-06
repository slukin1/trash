package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import e.a;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

public class w extends Resources {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f4698a;

    public w(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f4698a = resources;
    }

    public final Drawable a(int i11) throws Resources.NotFoundException {
        return super.getDrawable(i11);
    }

    public XmlResourceParser getAnimation(int i11) throws Resources.NotFoundException {
        return this.f4698a.getAnimation(i11);
    }

    public boolean getBoolean(int i11) throws Resources.NotFoundException {
        return this.f4698a.getBoolean(i11);
    }

    public int getColor(int i11) throws Resources.NotFoundException {
        return this.f4698a.getColor(i11);
    }

    public ColorStateList getColorStateList(int i11) throws Resources.NotFoundException {
        return this.f4698a.getColorStateList(i11);
    }

    public Configuration getConfiguration() {
        return this.f4698a.getConfiguration();
    }

    public float getDimension(int i11) throws Resources.NotFoundException {
        return this.f4698a.getDimension(i11);
    }

    public int getDimensionPixelOffset(int i11) throws Resources.NotFoundException {
        return this.f4698a.getDimensionPixelOffset(i11);
    }

    public int getDimensionPixelSize(int i11) throws Resources.NotFoundException {
        return this.f4698a.getDimensionPixelSize(i11);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f4698a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.f(this.f4698a, i11, theme);
    }

    public Drawable getDrawableForDensity(int i11, int i12) throws Resources.NotFoundException {
        return ResourcesCompat.g(this.f4698a, i11, i12, (Resources.Theme) null);
    }

    public float getFraction(int i11, int i12, int i13) {
        return this.f4698a.getFraction(i11, i12, i13);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f4698a.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i11) throws Resources.NotFoundException {
        return this.f4698a.getIntArray(i11);
    }

    public int getInteger(int i11) throws Resources.NotFoundException {
        return this.f4698a.getInteger(i11);
    }

    public XmlResourceParser getLayout(int i11) throws Resources.NotFoundException {
        return this.f4698a.getLayout(i11);
    }

    public Movie getMovie(int i11) throws Resources.NotFoundException {
        return this.f4698a.getMovie(i11);
    }

    public String getQuantityString(int i11, int i12, Object... objArr) throws Resources.NotFoundException {
        return this.f4698a.getQuantityString(i11, i12, objArr);
    }

    public CharSequence getQuantityText(int i11, int i12) throws Resources.NotFoundException {
        return this.f4698a.getQuantityText(i11, i12);
    }

    public String getResourceEntryName(int i11) throws Resources.NotFoundException {
        return this.f4698a.getResourceEntryName(i11);
    }

    public String getResourceName(int i11) throws Resources.NotFoundException {
        return this.f4698a.getResourceName(i11);
    }

    public String getResourcePackageName(int i11) throws Resources.NotFoundException {
        return this.f4698a.getResourcePackageName(i11);
    }

    public String getResourceTypeName(int i11) throws Resources.NotFoundException {
        return this.f4698a.getResourceTypeName(i11);
    }

    public String getString(int i11) throws Resources.NotFoundException {
        return this.f4698a.getString(i11);
    }

    public String[] getStringArray(int i11) throws Resources.NotFoundException {
        return this.f4698a.getStringArray(i11);
    }

    public CharSequence getText(int i11) throws Resources.NotFoundException {
        return this.f4698a.getText(i11);
    }

    public CharSequence[] getTextArray(int i11) throws Resources.NotFoundException {
        return this.f4698a.getTextArray(i11);
    }

    public void getValue(int i11, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.f4698a.getValue(i11, typedValue, z11);
    }

    public void getValueForDensity(int i11, int i12, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        a.a(this.f4698a, i11, i12, typedValue, z11);
    }

    public XmlResourceParser getXml(int i11) throws Resources.NotFoundException {
        return this.f4698a.getXml(i11);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f4698a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i11) throws Resources.NotFoundException {
        return this.f4698a.obtainTypedArray(i11);
    }

    public InputStream openRawResource(int i11) throws Resources.NotFoundException {
        return this.f4698a.openRawResource(i11);
    }

    public AssetFileDescriptor openRawResourceFd(int i11) throws Resources.NotFoundException {
        return this.f4698a.openRawResourceFd(i11);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f4698a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f4698a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f4698a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public Drawable getDrawableForDensity(int i11, int i12, Resources.Theme theme) {
        return ResourcesCompat.g(this.f4698a, i11, i12, theme);
    }

    public String getQuantityString(int i11, int i12) throws Resources.NotFoundException {
        return this.f4698a.getQuantityString(i11, i12);
    }

    public String getString(int i11, Object... objArr) throws Resources.NotFoundException {
        return this.f4698a.getString(i11, objArr);
    }

    public CharSequence getText(int i11, CharSequence charSequence) {
        return this.f4698a.getText(i11, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.f4698a.getValue(str, typedValue, z11);
    }

    public InputStream openRawResource(int i11, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f4698a.openRawResource(i11, typedValue);
    }
}
