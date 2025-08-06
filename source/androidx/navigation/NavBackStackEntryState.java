package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.r;

@SuppressLint({"BanParcelableUsage"})
public final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new a();
    public static final b Companion = new b((r) null);
    private final Bundle args;
    private final int destinationId;

    /* renamed from: id  reason: collision with root package name */
    private final String f10251id;
    private final Bundle savedState;

    public static final class a implements Parcelable.Creator<NavBackStackEntryState> {
        /* renamed from: a */
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        /* renamed from: b */
        public NavBackStackEntryState[] newArray(int i11) {
            return new NavBackStackEntryState[i11];
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }
    }

    public NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        this.f10251id = navBackStackEntry.f();
        this.destinationId = navBackStackEntry.e().l();
        this.args = navBackStackEntry.c();
        Bundle bundle = new Bundle();
        this.savedState = bundle;
        navBackStackEntry.i(bundle);
    }

    public int describeContents() {
        return 0;
    }

    public final Bundle getArgs() {
        return this.args;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final String getId() {
        return this.f10251id;
    }

    public final Bundle getSavedState() {
        return this.savedState;
    }

    public final NavBackStackEntry instantiate(Context context, NavDestination navDestination, Lifecycle.State state, NavControllerViewModel navControllerViewModel) {
        Bundle bundle = this.args;
        if (bundle != null) {
            bundle.setClassLoader(context.getClassLoader());
        } else {
            bundle = null;
        }
        return NavBackStackEntry.f10235p.a(context, navDestination, bundle, state, navControllerViewModel, this.f10251id, this.savedState);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f10251id);
        parcel.writeInt(this.destinationId);
        parcel.writeBundle(this.args);
        parcel.writeBundle(this.savedState);
    }

    public NavBackStackEntryState(Parcel parcel) {
        this.f10251id = parcel.readString();
        this.destinationId = parcel.readInt();
        this.args = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.savedState = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
