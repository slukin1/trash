package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();
    private static final String TAG = "FragmentManager";
    public final int mBreadCrumbShortTitleRes;
    public final CharSequence mBreadCrumbShortTitleText;
    public final int mBreadCrumbTitleRes;
    public final CharSequence mBreadCrumbTitleText;
    public final int[] mCurrentMaxLifecycleStates;
    public final ArrayList<String> mFragmentWhos;
    public final int mIndex;
    public final String mName;
    public final int[] mOldMaxLifecycleStates;
    public final int[] mOps;
    public final boolean mReorderingAllowed;
    public final ArrayList<String> mSharedElementSourceNames;
    public final ArrayList<String> mSharedElementTargetNames;
    public final int mTransition;

    public class a implements Parcelable.Creator<BackStackRecordState> {
        /* renamed from: a */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        /* renamed from: b */
        public BackStackRecordState[] newArray(int i11) {
            return new BackStackRecordState[i11];
        }
    }

    public BackStackRecordState(a aVar) {
        int size = aVar.f9624c.size();
        this.mOps = new int[(size * 6)];
        if (aVar.f9630i) {
            this.mFragmentWhos = new ArrayList<>(size);
            this.mOldMaxLifecycleStates = new int[size];
            this.mCurrentMaxLifecycleStates = new int[size];
            int i11 = 0;
            int i12 = 0;
            while (i11 < size) {
                FragmentTransaction.a aVar2 = aVar.f9624c.get(i11);
                int i13 = i12 + 1;
                this.mOps[i12] = aVar2.f9641a;
                ArrayList<String> arrayList = this.mFragmentWhos;
                Fragment fragment = aVar2.f9642b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.mOps;
                int i14 = i13 + 1;
                iArr[i13] = aVar2.f9643c;
                int i15 = i14 + 1;
                iArr[i14] = aVar2.f9644d;
                int i16 = i15 + 1;
                iArr[i15] = aVar2.f9645e;
                int i17 = i16 + 1;
                iArr[i16] = aVar2.f9646f;
                iArr[i17] = aVar2.f9647g;
                this.mOldMaxLifecycleStates[i11] = aVar2.f9648h.ordinal();
                this.mCurrentMaxLifecycleStates[i11] = aVar2.f9649i.ordinal();
                i11++;
                i12 = i17 + 1;
            }
            this.mTransition = aVar.f9629h;
            this.mName = aVar.f9632k;
            this.mIndex = aVar.f9694v;
            this.mBreadCrumbTitleRes = aVar.f9633l;
            this.mBreadCrumbTitleText = aVar.f9634m;
            this.mBreadCrumbShortTitleRes = aVar.f9635n;
            this.mBreadCrumbShortTitleText = aVar.f9636o;
            this.mSharedElementSourceNames = aVar.f9637p;
            this.mSharedElementTargetNames = aVar.f9638q;
            this.mReorderingAllowed = aVar.f9639r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    private void fillInBackStackRecord(a aVar) {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 < this.mOps.length) {
                FragmentTransaction.a aVar2 = new FragmentTransaction.a();
                int i13 = i11 + 1;
                aVar2.f9641a = this.mOps[i11];
                if (FragmentManager.P0(2)) {
                    Log.v(TAG, "Instantiate " + aVar + " op #" + i12 + " base fragment #" + this.mOps[i13]);
                }
                aVar2.f9648h = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i12]];
                aVar2.f9649i = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i12]];
                int[] iArr = this.mOps;
                int i14 = i13 + 1;
                if (iArr[i13] == 0) {
                    z11 = false;
                }
                aVar2.f9643c = z11;
                int i15 = i14 + 1;
                int i16 = iArr[i14];
                aVar2.f9644d = i16;
                int i17 = i15 + 1;
                int i18 = iArr[i15];
                aVar2.f9645e = i18;
                int i19 = i17 + 1;
                int i21 = iArr[i17];
                aVar2.f9646f = i21;
                int i22 = iArr[i19];
                aVar2.f9647g = i22;
                aVar.f9625d = i16;
                aVar.f9626e = i18;
                aVar.f9627f = i21;
                aVar.f9628g = i22;
                aVar.f(aVar2);
                i12++;
                i11 = i19 + 1;
            } else {
                aVar.f9629h = this.mTransition;
                aVar.f9632k = this.mName;
                aVar.f9630i = true;
                aVar.f9633l = this.mBreadCrumbTitleRes;
                aVar.f9634m = this.mBreadCrumbTitleText;
                aVar.f9635n = this.mBreadCrumbShortTitleRes;
                aVar.f9636o = this.mBreadCrumbShortTitleText;
                aVar.f9637p = this.mSharedElementSourceNames;
                aVar.f9638q = this.mSharedElementTargetNames;
                aVar.f9639r = this.mReorderingAllowed;
                return;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public a instantiate(FragmentManager fragmentManager) {
        a aVar = new a(fragmentManager);
        fillInBackStackRecord(aVar);
        aVar.f9694v = this.mIndex;
        for (int i11 = 0; i11 < this.mFragmentWhos.size(); i11++) {
            String str = this.mFragmentWhos.get(i11);
            if (str != null) {
                aVar.f9624c.get(i11).f9642b = fragmentManager.j0(str);
            }
        }
        aVar.B(1);
        return aVar;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    public a instantiate(FragmentManager fragmentManager, Map<String, Fragment> map) {
        a aVar = new a(fragmentManager);
        fillInBackStackRecord(aVar);
        for (int i11 = 0; i11 < this.mFragmentWhos.size(); i11++) {
            String str = this.mFragmentWhos.get(i11);
            if (str != null) {
                Fragment fragment = map.get(str);
                if (fragment != null) {
                    aVar.f9624c.get(i11).f9642b = fragment;
                } else {
                    throw new IllegalStateException("Restoring FragmentTransaction " + this.mName + " failed due to missing saved state for Fragment (" + str + ")");
                }
            }
        }
        return aVar;
    }

    public BackStackRecordState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }
}
