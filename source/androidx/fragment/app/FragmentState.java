package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();
    public final String mClassName;
    public final int mContainerId;
    public final boolean mDetached;
    public final int mFragmentId;
    public final boolean mFromLayout;
    public final boolean mHidden;
    public final int mMaxLifecycleState;
    public final boolean mRemoving;
    public final boolean mRetainInstance;
    public final String mTag;
    public final int mTargetRequestCode;
    public final String mTargetWho;
    public final boolean mUserVisibleHint;
    public final String mWho;

    public class a implements Parcelable.Creator<FragmentState> {
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* renamed from: b */
        public FragmentState[] newArray(int i11) {
            return new FragmentState[i11];
        }
    }

    public FragmentState(Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mWho = fragment.mWho;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mRemoving = fragment.mRemoving;
        this.mDetached = fragment.mDetached;
        this.mHidden = fragment.mHidden;
        this.mMaxLifecycleState = fragment.mMaxState.ordinal();
        this.mTargetWho = fragment.mTargetWho;
        this.mTargetRequestCode = fragment.mTargetRequestCode;
        this.mUserVisibleHint = fragment.mUserVisibleHint;
    }

    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        Fragment a11 = fragmentFactory.a(classLoader, this.mClassName);
        a11.mWho = this.mWho;
        a11.mFromLayout = this.mFromLayout;
        a11.mRestored = true;
        a11.mFragmentId = this.mFragmentId;
        a11.mContainerId = this.mContainerId;
        a11.mTag = this.mTag;
        a11.mRetainInstance = this.mRetainInstance;
        a11.mRemoving = this.mRemoving;
        a11.mDetached = this.mDetached;
        a11.mHidden = this.mHidden;
        a11.mMaxState = Lifecycle.State.values()[this.mMaxLifecycleState];
        a11.mTargetWho = this.mTargetWho;
        a11.mTargetRequestCode = this.mTargetRequestCode;
        a11.mUserVisibleHint = this.mUserVisibleHint;
        return a11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.mClassName);
        sb2.append(" (");
        sb2.append(this.mWho);
        sb2.append(")}:");
        if (this.mFromLayout) {
            sb2.append(" fromLayout");
        }
        if (this.mContainerId != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.mContainerId));
        }
        String str = this.mTag;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.mTag);
        }
        if (this.mRetainInstance) {
            sb2.append(" retainInstance");
        }
        if (this.mRemoving) {
            sb2.append(" removing");
        }
        if (this.mDetached) {
            sb2.append(" detached");
        }
        if (this.mHidden) {
            sb2.append(" hidden");
        }
        if (this.mTargetWho != null) {
            sb2.append(" targetWho=");
            sb2.append(this.mTargetWho);
            sb2.append(" targetRequestCode=");
            sb2.append(this.mTargetRequestCode);
        }
        if (this.mUserVisibleHint) {
            sb2.append(" userVisibleHint");
        }
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mClassName);
        parcel.writeString(this.mWho);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mRemoving ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeInt(this.mHidden ? 1 : 0);
        parcel.writeInt(this.mMaxLifecycleState);
        parcel.writeString(this.mTargetWho);
        parcel.writeInt(this.mTargetRequestCode);
        parcel.writeInt(this.mUserVisibleHint ? 1 : 0);
    }

    public FragmentState(Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mWho = parcel.readString();
        boolean z11 = true;
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mRemoving = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mHidden = parcel.readInt() != 0;
        this.mMaxLifecycleState = parcel.readInt();
        this.mTargetWho = parcel.readString();
        this.mTargetRequestCode = parcel.readInt();
        this.mUserVisibleHint = parcel.readInt() == 0 ? false : z11;
    }
}
