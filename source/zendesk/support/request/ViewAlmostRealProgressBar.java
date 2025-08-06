package zendesk.support.request;

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
import mz.a;

public class ViewAlmostRealProgressBar extends ProgressBar {
    public static final long ALPHA_FADE_DURATION = 100;
    public static final List<Step> DONT_STOP_MOVING = Arrays.asList(new Step[]{new Step(60, 4000), new Step(90, 15000)});
    public static final List<Step> SIMPLE_PROGRESSBAR = Collections.singletonList(new Step(60, 4000));
    public static final long START_DEBOUNCE_TIME = 100;
    public static final long STOP_ANIMATION_DURATION = 300;
    public static final long STOP_DEBOUNCE_TIME = 200;
    private StateAwareAnimator finishAnimator;
    private Handler handler = new Handler(Looper.getMainLooper());
    private StateAwareAnimator progressAnimator;
    /* access modifiers changed from: private */
    public Runnable startDebounceRunnable;
    /* access modifiers changed from: private */
    public List<Step> steps;
    /* access modifiers changed from: private */
    public Runnable stopDebounceRunnable;

    public static class State extends View.BaseSavedState {
        public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() {
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            public State[] newArray(int i11) {
                return new State[i11];
            }
        };
        /* access modifiers changed from: private */
        public final int progress;
        /* access modifiers changed from: private */
        public final List<Step> steps;

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

    public static class StateAwareAnimator extends AnimatorListenerAdapter {
        private final Animator animatorSet;
        private boolean ended = false;
        private boolean started = false;

        public StateAwareAnimator(Animator animator) {
            this.animatorSet = animator;
            animator.addListener(this);
        }

        public Animator get() {
            return this.animatorSet;
        }

        public boolean isEnded() {
            return this.ended;
        }

        public boolean isStarted() {
            return this.started;
        }

        public void onAnimationCancel(Animator animator) {
            this.started = false;
            this.ended = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.started = false;
            this.ended = true;
        }

        public void onAnimationRepeat(Animator animator) {
            this.started = true;
            this.ended = false;
        }

        public void onAnimationStart(Animator animator) {
            this.started = true;
            this.ended = false;
        }
    }

    public static class Step implements Parcelable, Comparable<Step> {
        public static final Parcelable.Creator<Step> CREATOR = new Parcelable.Creator<Step>() {
            public Step createFromParcel(Parcel parcel) {
                return new Step(parcel);
            }

            public Step[] newArray(int i11) {
                return new Step[i11];
            }
        };
        /* access modifiers changed from: private */
        public final int target;
        /* access modifiers changed from: private */
        public final long time;

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

    public ViewAlmostRealProgressBar(Context context) {
        super(context);
    }

    private Step adjustTime(int i11, int i12, Step step) {
        float f11 = (float) (i11 - i12);
        return new Step(step.target, (long) (((float) step.time) * (1.0f - (f11 / ((float) (step.target - i12))))));
    }

    private StateAwareAnimator endAnimation(long j11) {
        Animator progressAnimator2 = progressAnimator(getProgress(), 100, j11);
        Animator progressBarAlphaAnimator = progressBarAlphaAnimator(1.0f, 0.0f, 100);
        Animator progressAnimator3 = progressAnimator(100, 0, 0);
        Animator progressBarAlphaAnimator2 = progressBarAlphaAnimator(0.0f, 1.0f, 0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(progressAnimator2).before(progressBarAlphaAnimator);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(progressAnimator3).before(progressBarAlphaAnimator2);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(j11);
        animatorSet3.play(animatorSet).before(animatorSet2);
        return new StateAwareAnimator(animatorSet3);
    }

    /* access modifiers changed from: private */
    public void finishAnimation(long j11) {
        StateAwareAnimator stateAwareAnimator = this.progressAnimator;
        if (stateAwareAnimator != null) {
            stateAwareAnimator.get().cancel();
            this.progressAnimator = null;
            StateAwareAnimator endAnimation = endAnimation(j11);
            this.finishAnimator = endAnimation;
            endAnimation.get().start();
        }
    }

    /* access modifiers changed from: private */
    public void kickOffAnimation(List<Step> list, int i11) {
        if (this.progressAnimator == null) {
            long j11 = 0;
            StateAwareAnimator stateAwareAnimator = this.finishAnimator;
            if (stateAwareAnimator != null && stateAwareAnimator.isStarted() && !this.finishAnimator.isEnded()) {
                j11 = this.finishAnimator.get().getDuration();
            }
            this.finishAnimator = null;
            StateAwareAnimator startAnimation = startAnimation(list, i11, j11);
            this.progressAnimator = startAnimation;
            startAnimation.get().start();
        }
    }

    private Animator progressAnimator(int i11, int i12, long j11) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "progress", new int[]{i11, i12});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j11);
        return ofInt;
    }

    private Animator progressBarAlphaAnimator(float f11, float f12, long j11) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{f11, f12});
        ofFloat.setDuration(j11);
        return ofFloat;
    }

    private void restoreProgress(State state) {
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
            if (a.i(arrayList2)) {
                arrayList2.add(0, adjustTime(state.progress, i11, (Step) arrayList2.remove(0)));
            }
            kickOffAnimation(arrayList2, state.progress);
            this.steps = arrayList;
            return;
        }
        setProgress(0);
    }

    private StateAwareAnimator startAnimation(List<Step> list, int i11, long j11) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Step next : list) {
            Animator progressAnimator2 = progressAnimator(i11, next.target, next.time);
            int access$500 = next.target;
            arrayList.add(progressAnimator2);
            i11 = access$500;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(arrayList);
        animatorSet.setStartDelay(j11);
        return new StateAwareAnimator(animatorSet);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof State) {
            State state = (State) parcelable;
            restoreProgress(state);
            parcelable = state.getSuperState();
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.progressAnimator != null && this.stopDebounceRunnable == null) {
            return new State(super.onSaveInstanceState(), getProgress(), this.steps);
        }
        setProgress(0);
        return super.onSaveInstanceState();
    }

    public void start(final List<Step> list) {
        Runnable runnable = this.stopDebounceRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.stopDebounceRunnable = null;
        } else if (this.startDebounceRunnable == null) {
            AnonymousClass1 r02 = new Runnable() {
                public void run() {
                    Runnable unused = ViewAlmostRealProgressBar.this.startDebounceRunnable = null;
                    List c11 = a.c(list);
                    Collections.sort(c11);
                    List unused2 = ViewAlmostRealProgressBar.this.steps = c11;
                    ViewAlmostRealProgressBar viewAlmostRealProgressBar = ViewAlmostRealProgressBar.this;
                    viewAlmostRealProgressBar.kickOffAnimation(viewAlmostRealProgressBar.steps, 0);
                }
            };
            this.startDebounceRunnable = r02;
            this.handler.postDelayed(r02, 100);
        }
    }

    public void stop(final long j11) {
        Runnable runnable = this.startDebounceRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.startDebounceRunnable = null;
        } else if (this.stopDebounceRunnable == null) {
            AnonymousClass2 r02 = new Runnable() {
                public void run() {
                    Runnable unused = ViewAlmostRealProgressBar.this.stopDebounceRunnable = null;
                    ViewAlmostRealProgressBar.this.finishAnimation(j11);
                }
            };
            this.stopDebounceRunnable = r02;
            this.handler.postDelayed(r02, 200);
        }
    }

    public ViewAlmostRealProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ViewAlmostRealProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
