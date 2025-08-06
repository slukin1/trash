package e6;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.Util;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

public class k extends Resources {

    /* renamed from: a  reason: collision with root package name */
    public Resources f68140a = null;

    public k(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration, Resources resources) {
        super(assetManager, displayMetrics, configuration);
        this.f68140a = resources;
    }

    public static CharSequence b(CharSequence charSequence) {
        return charSequence;
    }

    public static String c(String str) {
        return str;
    }

    public Resources a() {
        return this.f68140a;
    }

    public XmlResourceParser getAnimation(int i11) throws Resources.NotFoundException {
        return this.f68140a.getAnimation(i11);
    }

    public boolean getBoolean(int i11) throws Resources.NotFoundException {
        return this.f68140a.getBoolean(i11);
    }

    public int getColor(int i11) {
        int s11 = b.v().s(i11);
        return s11 != Integer.MIN_VALUE ? s11 : this.f68140a.getColor(i11);
    }

    public ColorStateList getColorStateList(int i11) throws Resources.NotFoundException {
        return this.f68140a.getColorStateList(i11);
    }

    public Configuration getConfiguration() {
        return this.f68140a.getConfiguration();
    }

    public float getDimension(int i11) throws Resources.NotFoundException {
        return this.f68140a.getDimension(i11);
    }

    public int getDimensionPixelOffset(int i11) throws Resources.NotFoundException {
        return this.f68140a.getDimensionPixelOffset(i11);
    }

    public int getDimensionPixelSize(int i11) throws Resources.NotFoundException {
        return this.f68140a.getDimensionPixelSize(i11);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f68140a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i11) {
        Drawable t11 = g.v().t(i11);
        return t11 != null ? t11 : this.f68140a.getDrawable(i11, BaseApplication.b().getTheme());
    }

    public Drawable getDrawableForDensity(int i11, int i12, Resources.Theme theme) {
        return this.f68140a.getDrawableForDensity(i11, i12, theme);
    }

    public float getFloat(int i11) {
        return this.f68140a.getFloat(i11);
    }

    public Typeface getFont(int i11) throws Resources.NotFoundException {
        return this.f68140a.getFont(i11);
    }

    public float getFraction(int i11, int i12, int i13) {
        return this.f68140a.getFraction(i11, i12, i13);
    }

    public int getIdentifier(String str, String str2, String str3) {
        int identifier = this.f68140a.getIdentifier(str, str2, str3);
        if (identifier <= 0 && !TextUtils.isEmpty(str2)) {
            if ("string".equals(str2) && d.r().v(str)) {
                if (Util.a()) {
                    Log.d("HuobiResourceProxy", "getIdentifier() called with: name = [" + str + "], defType = [" + str2 + "], name.hashCode() = [" + str.hashCode() + "]");
                }
                return -Math.abs(str.hashCode());
            } else if ("drawable".equals(str2) && g.v().x(str)) {
                if (Util.a()) {
                    Log.d("HuobiResourceProxy", "getIdentifier() called with: name = [" + str + "], defType = [" + str2 + "], name.hashCode() = [" + str.hashCode() + "]");
                }
                return -Math.abs(str.hashCode());
            } else if ("color".equals(str2) && b.v().x(str)) {
                if (Util.a()) {
                    Log.d("HuobiResourceProxy", "getIdentifier() called with: name = [" + str + "], defType = [" + str2 + "], name.hashCode() = [" + str.hashCode() + "]");
                }
                b.v().z(str, Integer.valueOf(str.hashCode()));
                return str.hashCode();
            }
        }
        return identifier;
    }

    public int[] getIntArray(int i11) throws Resources.NotFoundException {
        return this.f68140a.getIntArray(i11);
    }

    public int getInteger(int i11) throws Resources.NotFoundException {
        return this.f68140a.getInteger(i11);
    }

    public XmlResourceParser getLayout(int i11) throws Resources.NotFoundException {
        return this.f68140a.getLayout(i11);
    }

    public Movie getMovie(int i11) throws Resources.NotFoundException {
        return this.f68140a.getMovie(i11);
    }

    public String getQuantityString(int i11, int i12) throws Resources.NotFoundException {
        return this.f68140a.getQuantityString(i11, i12);
    }

    public CharSequence getQuantityText(int i11, int i12) throws Resources.NotFoundException {
        return this.f68140a.getQuantityText(i11, i12);
    }

    public String getResourceEntryName(int i11) throws Resources.NotFoundException {
        return this.f68140a.getResourceEntryName(i11);
    }

    public String getResourceName(int i11) throws Resources.NotFoundException {
        return this.f68140a.getResourceName(i11);
    }

    public String getResourcePackageName(int i11) throws Resources.NotFoundException {
        return this.f68140a.getResourcePackageName(i11);
    }

    public String getResourceTypeName(int i11) throws Resources.NotFoundException {
        return this.f68140a.getResourceTypeName(i11);
    }

    public String getString(int i11) throws Resources.NotFoundException {
        String t11 = d.r().t(i11);
        if (t11 == null) {
            t11 = this.f68140a.getText(i11).toString();
        }
        return c(t11);
    }

    public String[] getStringArray(int i11) throws Resources.NotFoundException {
        return this.f68140a.getStringArray(i11);
    }

    public CharSequence getText(int i11, CharSequence charSequence) {
        CharSequence t11 = d.r().t(i11);
        if (t11 == null) {
            t11 = this.f68140a.getText(i11, charSequence);
        }
        return b(t11);
    }

    public CharSequence[] getTextArray(int i11) throws Resources.NotFoundException {
        return this.f68140a.getTextArray(i11);
    }

    public void getValue(int i11, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.f68140a.getValue(i11, typedValue, z11);
    }

    public void getValueForDensity(int i11, int i12, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.f68140a.getValueForDensity(i11, i12, typedValue, z11);
    }

    public XmlResourceParser getXml(int i11) throws Resources.NotFoundException {
        return this.f68140a.getXml(i11);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f68140a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i11) throws Resources.NotFoundException {
        return this.f68140a.obtainTypedArray(i11);
    }

    public InputStream openRawResource(int i11) throws Resources.NotFoundException {
        return this.f68140a.openRawResource(i11);
    }

    public AssetFileDescriptor openRawResourceFd(int i11) throws Resources.NotFoundException {
        return this.f68140a.openRawResourceFd(i11);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f68140a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws IOException, XmlPullParserException {
        this.f68140a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public String toString() {
        return "HuobiResourceProxy{" + this.f68140a + '}';
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        this.f68140a.updateConfiguration(configuration, displayMetrics);
    }

    public ColorStateList getColorStateList(int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return this.f68140a.getColorStateList(i11, theme);
    }

    @Deprecated
    public Drawable getDrawableForDensity(int i11, int i12) throws Resources.NotFoundException {
        return this.f68140a.getDrawableForDensity(i11, i12, (Resources.Theme) null);
    }

    public String getQuantityString(int i11, int i12, Object... objArr) throws Resources.NotFoundException {
        return this.f68140a.getQuantityString(i11, i12, objArr);
    }

    public void getValue(String str, TypedValue typedValue, boolean z11) throws Resources.NotFoundException {
        this.f68140a.getValue(str, typedValue, z11);
    }

    public InputStream openRawResource(int i11, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f68140a.openRawResource(i11, typedValue);
    }

    public int getColor(int i11, Resources.Theme theme) {
        int t11 = b.v().t(i11, theme);
        return t11 != Integer.MIN_VALUE ? t11 : this.f68140a.getColor(i11, theme);
    }

    public Drawable getDrawable(int i11, Resources.Theme theme) {
        Drawable u11 = g.v().u(i11, theme);
        return u11 != null ? u11 : this.f68140a.getDrawable(i11, theme);
    }

    public String getString(int i11, Object... objArr) throws Resources.NotFoundException {
        String t11 = d.r().t(i11);
        if (t11 == null) {
            t11 = this.f68140a.getText(i11).toString();
        }
        return c(String.format(this.f68140a.getConfiguration().getLocales().get(0), t11, objArr));
    }

    public CharSequence getText(int i11) {
        CharSequence t11 = d.r().t(i11);
        if (t11 == null) {
            t11 = this.f68140a.getText(i11);
        }
        return b(t11);
    }
}
