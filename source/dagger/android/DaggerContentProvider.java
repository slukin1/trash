package dagger.android;

import android.content.ContentProvider;
import pz.a;

public abstract class DaggerContentProvider extends ContentProvider {
    public boolean onCreate() {
        a.f(this);
        return true;
    }
}
