package com.mob.tools.utils;

import android.os.Parcelable;
import com.mob.MobSDK;
import com.mob.commons.m;
import com.mob.tools.utils.MobPersistence;
import java.util.List;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28216a = m.a("006[bdbiddbfba4f");

    /* renamed from: b  reason: collision with root package name */
    private static volatile h f28217b;

    /* renamed from: c  reason: collision with root package name */
    private SharePrefrenceHelper f28218c;

    private h() {
        if (this.f28218c == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            this.f28218c = sharePrefrenceHelper;
            sharePrefrenceHelper.open(f28216a, 1, m.a("016b*dd^aFbacdKd3dffhfbgifffdfchdfjfg"));
        }
    }

    public static h a() {
        if (f28217b == null) {
            synchronized (h.class) {
                if (f28217b == null) {
                    f28217b = new h();
                }
            }
        }
        return f28217b;
    }

    public String b(String str, String str2) throws MobPersistence.NoValidDataException {
        return this.f28218c.getStringThrowable(str, str2);
    }

    public long c(String str) {
        return this.f28218c.getLong(str);
    }

    public long d(String str) throws MobPersistence.NoValidDataException {
        return this.f28218c.getLongThrowable(str);
    }

    public int e(String str) {
        return this.f28218c.getInt(str);
    }

    public double f(String str) throws MobPersistence.NoValidDataException {
        return this.f28218c.getDoubleThrowable(str);
    }

    public Object g(String str) throws MobPersistence.NoValidDataException {
        return this.f28218c.getThrowable(str);
    }

    public void h(String str) {
        this.f28218c.remove(str);
    }

    public boolean b(String str) throws MobPersistence.NoValidDataException {
        return this.f28218c.getBooleanThrowable(str);
    }

    public <T extends Parcelable> List<T> c(String str, Class<T> cls) throws MobPersistence.NoValidDataException {
        return this.f28218c.getParcelListThrowable(str, cls);
    }

    public <T extends Parcelable> T[] d(String str, Class<T> cls) throws MobPersistence.NoValidDataException {
        return this.f28218c.getParcelArrayThrowable(str, cls);
    }

    public int b(String str, int i11) throws MobPersistence.NoValidDataException {
        return this.f28218c.getIntThrowable(str, i11);
    }

    public <T extends Parcelable> Map<String, T> b(String str, Class<T> cls) throws MobPersistence.NoValidDataException {
        return this.f28218c.getParcelMapThrowable(str, cls);
    }

    public Object b(String str, Object obj) throws MobPersistence.NoValidDataException {
        return this.f28218c.getThrowable(str, obj);
    }

    public void a(String str, String str2) {
        this.f28218c.putString(str, str2);
    }

    public void a(String str, String str2, long j11) {
        this.f28218c.putString(str, str2, j11);
    }

    public String a(String str) throws MobPersistence.NoValidDataException {
        return this.f28218c.getStringThrowable(str);
    }

    public void a(String str, Boolean bool) {
        this.f28218c.putBoolean(str, bool);
    }

    public void a(String str, Boolean bool, long j11) {
        this.f28218c.putBoolean(str, bool, j11);
    }

    public boolean a(String str, boolean z11) throws MobPersistence.NoValidDataException {
        return this.f28218c.getBooleanThrowable(str, z11);
    }

    public void a(String str, Long l11) {
        this.f28218c.putLong(str, l11);
    }

    public void a(String str, Long l11, long j11) {
        this.f28218c.putLong(str, l11, j11);
    }

    public long a(String str, long j11) throws MobPersistence.NoValidDataException {
        return this.f28218c.getLongThrowable(str, j11);
    }

    public void a(String str, Integer num) {
        this.f28218c.putInt(str, num);
    }

    public void a(String str, Integer num, long j11) {
        this.f28218c.putInt(str, num, j11);
    }

    public int a(String str, int i11) {
        return this.f28218c.getInt(str, i11);
    }

    public void a(String str, Double d11) {
        this.f28218c.putDouble(str, d11);
    }

    public void a(String str, Double d11, long j11) {
        this.f28218c.putDouble(str, d11, j11);
    }

    public double a(String str, double d11) throws MobPersistence.NoValidDataException {
        return this.f28218c.getDoubleThrowable(str, d11);
    }

    public void a(String str, Parcelable parcelable) {
        this.f28218c.putParcel(str, parcelable);
    }

    public void a(String str, Parcelable parcelable, long j11) {
        this.f28218c.putParcel(str, parcelable, j11);
    }

    public <T extends Parcelable> T a(String str, Class<T> cls) throws MobPersistence.NoValidDataException {
        return this.f28218c.getParcelThrowable(str, cls);
    }

    public <T> T a(String str, Class<T> cls, T t11) throws MobPersistence.NoValidDataException {
        return this.f28218c.getParcelThrowable(str, cls, t11);
    }

    public <T extends Parcelable> void a(String str, Map<String, T> map) {
        this.f28218c.putParcelMap(str, map);
    }

    public <T extends Parcelable> void a(String str, Map<String, T> map, long j11) {
        this.f28218c.putParcelMap(str, map, j11);
    }

    public <T extends Parcelable> Map<String, T> a(String str, Class<T> cls, Map<String, T> map) throws MobPersistence.NoValidDataException {
        return this.f28218c.getParcelMapThrowable(str, cls, map);
    }

    public <T extends Parcelable> void a(String str, List<T> list) {
        this.f28218c.putParcelList(str, list);
    }

    public <T extends Parcelable> void a(String str, List<T> list, long j11) {
        this.f28218c.putParcelList(str, list, j11);
    }

    public <T extends Parcelable> List<T> a(String str, Class<T> cls, List<T> list) throws MobPersistence.NoValidDataException {
        return this.f28218c.getParcelListThrowable(str, cls, list);
    }

    public <T extends Parcelable> void a(String str, T[] tArr) {
        this.f28218c.putParcelArray(str, tArr);
    }

    public <T extends Parcelable> void a(String str, T[] tArr, long j11) {
        this.f28218c.putParcelArray(str, tArr, j11);
    }

    public <T extends Parcelable> T[] a(String str, Class<T> cls, T[] tArr) throws MobPersistence.NoValidDataException {
        return this.f28218c.getParcelArrayThrowable(str, cls, tArr);
    }

    public void a(String str, Object obj) {
        this.f28218c.put(str, obj);
    }

    public void a(String str, Object obj, long j11) {
        this.f28218c.put(str, obj, j11);
    }
}
