package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.hbg.lib.network.pro.core.util.Period;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.Calendar;
import q0.e;

public class m {

    /* renamed from: d  reason: collision with root package name */
    public static m f3947d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3948a;

    /* renamed from: b  reason: collision with root package name */
    public final LocationManager f3949b;

    /* renamed from: c  reason: collision with root package name */
    public final a f3950c = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3951a;

        /* renamed from: b  reason: collision with root package name */
        public long f3952b;
    }

    public m(Context context, LocationManager locationManager) {
        this.f3948a = context;
        this.f3949b = locationManager;
    }

    public static m a(Context context) {
        if (f3947d == null) {
            Context applicationContext = context.getApplicationContext();
            f3947d = new m(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f3947d;
    }

    @SuppressLint({"MissingPermission"})
    public final Location b() {
        Location location = null;
        Location c11 = e.b(this.f3948a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c(OptionsBridge.NETWORK_KEY) : null;
        if (e.b(this.f3948a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = c("gps");
        }
        return (location == null || c11 == null) ? location != null ? location : c11 : location.getTime() > c11.getTime() ? location : c11;
    }

    public final Location c(String str) {
        try {
            if (this.f3949b.isProviderEnabled(str)) {
                return this.f3949b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e11) {
            Log.d("TwilightManager", "Failed to get last known location", e11);
            return null;
        }
    }

    public boolean d() {
        a aVar = this.f3950c;
        if (e()) {
            return aVar.f3951a;
        }
        Location b11 = b();
        if (b11 != null) {
            f(b11);
            return aVar.f3951a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i11 = Calendar.getInstance().get(11);
        return i11 < 6 || i11 >= 22;
    }

    public final boolean e() {
        return this.f3950c.f3952b > System.currentTimeMillis();
    }

    public final void f(Location location) {
        long j11;
        a aVar = this.f3950c;
        long currentTimeMillis = System.currentTimeMillis();
        l b11 = l.b();
        l lVar = b11;
        lVar.a(currentTimeMillis - Period.DAY_MILLS, location.getLatitude(), location.getLongitude());
        lVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z11 = true;
        if (b11.f3946c != 1) {
            z11 = false;
        }
        boolean z12 = z11;
        long j12 = b11.f3945b;
        long j13 = b11.f3944a;
        long j14 = j12;
        b11.a(currentTimeMillis + Period.DAY_MILLS, location.getLatitude(), location.getLongitude());
        long j15 = b11.f3945b;
        if (j14 == -1 || j13 == -1) {
            j11 = 43200000 + currentTimeMillis;
        } else {
            j11 = (currentTimeMillis > j13 ? j15 + 0 : currentTimeMillis > j14 ? j13 + 0 : j14 + 0) + 60000;
        }
        aVar.f3951a = z12;
        aVar.f3952b = j11;
    }
}
