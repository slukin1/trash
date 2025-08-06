package zendesk.commonui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlmostRealProgressBar extends ProgressBar {

    /* renamed from: h  reason: collision with root package name */
    public static final List<Step> f62909h = Arrays.asList(new Step[]{new Step(60, 4000), new Step(90, 15000)});

    /* renamed from: b  reason: collision with root package name */
    public c f62910b;

    /* renamed from: c  reason: collision with root package name */
    public c f62911c;

    /* renamed from: d  reason: collision with root package name */
    public List<Step> f62912d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f62913e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public Runnable f62914f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f62915g;

    public static class State extends View.BaseSavedState {
        public static final Parcelable.Creator<State> CREATOR = new a();
        /* access modifiers changed from: private */
        public final int progress;
        /* access modifiers changed from: private */
        public final List<Step> steps;

        public class a implements Parcelable.Creator<State> {
            /* renamed from: a */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel, (a) null);
            }

            /* renamed from: b */
            public State[] newArray(int i11) {
                return new State[i11];
            }
        }

        public /* synthetic */ State(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.progress);
            parcel.writeTypedList(this.steps);
        }

        public State(Parcelable parcelable, int i11, List<Step> list) {
            super(parcelable);
            this.progress = i11;
            this.steps = list;
        }

        private State(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
            ArrayList arrayList = new ArrayList();
            this.steps = arrayList;
            parcel.readTypedList(arrayList, Step.CREATOR);
        }
    }

    public static class Step implements Parcelable, Comparable<Step> {
        public static final Parcelable.Creator<Step> CREATOR = new a();
        /* access modifiers changed from: private */
        public final int target;
        /* access modifiers changed from: private */
        public final long time;

        public class a implements Parcelable.Creator<Step> {
            /* renamed from: a */
            public Step createFromParcel(Parcel parcel) {
                return new Step(parcel);
            }

            /* renamed from: b */
            public Step[] newArray(int i11) {
                return new Step[i11];
            }
        }

        public Step(int i11, long j11) {
            this.target = i11;
            this.time = j11;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.target);
            parcel.writeLong(this.time);
        }

        public int compareTo(Step step) {
            return this.target - step.target;
        }

        public Step(Parcel parcel) {
            this.target = parcel.readInt();
            this.time = parcel.readLong();
        }
    }

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f62916b;

        public a(List list) {
            this.f62916b = list;
        }

        public void run() {
            Runnable unused = AlmostRealProgressBar.this.f62915g = null;
            List c11 = mz.a.c(this.f62916b);
            Collections.sort(c11);
            List unused2 = AlmostRealProgressBar.this.f62912d = c11;
            AlmostRealProgressBar almostRealProgressBar = AlmostRealProgressBar.this;
            almostRealProgressBar.j(almostRealProgressBar.f62912d, 0);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f62918b;

        public b(long j11) {
            this.f62918b = j11;
        }

        public void run() {
            Runnable unused = AlmostRealProgressBar.this.f62914f = null;
            AlmostRealProgressBar.this.i(this.f62918b);
        }
    }

    public static class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final Animator f62920b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f62921c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f62922d = false;

        public c(Animator animator) {
            this.f62920b = animator;
            animator.addListener(this);
        }

        public Animator a() {
            return this.f62920b;
        }

        public boolean b() {
            return this.f62922d;
        }

        public boolean c() {
            return this.f62921c;
        }

        public void onAnimationCancel(Animator animator) {
            this.f62921c = false;
            this.f62922d = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.f62921c = false;
            this.f62922d = true;
        }

        public void onAnimationRepeat(Animator animator) {
            this.f62921c = true;
            this.f62922d = false;
        }

        public void onAnimationStart(Animator animator) {
            this.f62921c = true;
            this.f62922d = false;
        }
    }

    public AlmostRealProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final Step g(int i11, int i12, Step step) {
        float f11 = (float) (i11 - i12);
        return new Step(step.target, (long) (((float) step.time) * (1.0f - (f11 / ((float) (step.target - i12))))));
    }

    public final c h(long j11) {
        Animator k11 = k(getProgress(), 100, j11);
        Animator l11 = l(1.0f, 0.0f, 100);
        Animator k12 = k(100, 0, 0);
        Animator l12 = l(0.0f, 1.0f, 0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(k11).before(l11);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(k12).before(l12);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(j11);
        animatorSet3.play(animatorSet).before(animatorSet2);
        return new c(animatorSet3);
    }

    public final void i(long j11) {
        c cVar = this.f62910b;
        if (cVar != null) {
            cVar.a().cancel();
            this.f62910b = null;
            c h11 = h(j11);
            this.f62911c = h11;
            h11.a().start();
        }
    }

    public final void j(List<Step> list, int i11) {
        if (this.f62910b == null) {
            long j11 = 0;
            c cVar = this.f62911c;
            if (cVar != null && cVar.c() && !this.f62911c.b()) {
                j11 = this.f62911c.a().getDuration();
            }
            this.f62911c = null;
            c o11 = o(list, i11, j11);
            this.f62910b = o11;
            o11.a().start();
        }
    }

    public final Animator k(int i11, int i12, long j11) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "progress", new int[]{i11, i12});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j11);
        return ofInt;
    }

    public final Animator l(float f11, float f12, long j11) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{f11, f12});
        ofFloat.setDuration(j11);
        return ofFloat;
    }

    public final void m(State state) {
        if (state.progress > 0) {
            ArrayList arrayList = new ArrayList(state.steps);
            ArrayList arrayList2 = new ArrayList();
            int i11 = 0;
            for (Step step : state.steps) {
                if (state.progress < step.target) {
                    arrayList2.add(step);
                } else {
                    i11 = step.target;
                }
            }
            if (mz.a.i(arrayList2)) {
                arrayList2.add(0, g(state.progress, i11, (Step) arrayList2.remove(0)));
            }
            j(arrayList2, state.progress);
            this.f62912d = arrayList;
            return;
        }
        setProgress(0);
    }

    public void n(List<Step> list) {
        Runnable runnable = this.f62914f;
        if (runnable != null) {
            this.f62913e.removeCallbacks(runnable);
            this.f62914f = null;
        } else if (this.f62915g == null) {
            a aVar = new a(list);
            this.f62915g = aVar;
            this.f62913e.postDelayed(aVar, 100);
        }
    }

    public final c o(List<Step> list, int i11, long j11) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Step next : list) {
            Animator k11 = k(i11, next.target, next.time);
            int access$500 = next.target;
            arrayList.add(k11);
            i11 = access$500;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        animatorSet.setStartDelay(j11);
        return new c(animatorSet);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof State) {
            State state = (State) parcelable;
            m(state);
            parcelable = state.getSuperState();
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.f62910b != null && this.f62914f == null) {
            return new State(super.onSaveInstanceState(), getProgress(), this.f62912d);
        }
        setProgress(0);
        return super.onSaveInstanceState();
    }

    public void p(long j11) {
        Runnable runnable = this.f62915g;
        if (runnable != null) {
            this.f62913e.removeCallbacks(runnable);
            this.f62915g = null;
        } else if (this.f62914f == null) {
            b bVar = new b(j11);
            this.f62914f = bVar;
            this.f62913e.postDelayed(bVar, 200);
        }
    }

    public AlmostRealProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
