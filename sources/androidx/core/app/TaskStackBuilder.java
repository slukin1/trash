package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import p0.j;

public final class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Intent> f8309b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final Context f8310c;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public TaskStackBuilder(Context context) {
        this.f8310c = context;
    }

    public static TaskStackBuilder e(Context context) {
        return new TaskStackBuilder(context);
    }

    public TaskStackBuilder a(Intent intent) {
        this.f8309b.add(intent);
        return this;
    }

    public TaskStackBuilder b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f8310c.getPackageManager());
        }
        if (component != null) {
            d(component);
        }
        a(intent);
        return this;
    }

    public TaskStackBuilder c(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = j.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f8310c.getPackageManager());
            }
            d(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public TaskStackBuilder d(ComponentName componentName) {
        int size = this.f8309b.size();
        try {
            Intent b11 = j.b(this.f8310c, componentName);
            while (b11 != null) {
                this.f8309b.add(size, b11);
                b11 = j.b(this.f8310c, b11.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e11);
        }
    }

    public void g() {
        h((Bundle) null);
    }

    public void h(Bundle bundle) {
        if (!this.f8309b.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f8309b.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!ContextCompat.startActivities(this.f8310c, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f8310c.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f8309b.iterator();
    }
}
