package com.zopim.android.sdk.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.zendesk.logger.Logger;
import java.util.ArrayList;

@TargetApi(11)
public class AnimatorPack {
    private static final long DURATION = 400;
    private static final String LOG_TAG = "AnimatorPack";

    /* renamed from: com.zopim.android.sdk.anim.AnimatorPack$7  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$anim$AnimatorPack$Direction;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.zopim.android.sdk.anim.AnimatorPack$Direction[] r0 = com.zopim.android.sdk.anim.AnimatorPack.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$anim$AnimatorPack$Direction = r0
                com.zopim.android.sdk.anim.AnimatorPack$Direction r1 = com.zopim.android.sdk.anim.AnimatorPack.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$anim$AnimatorPack$Direction     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.anim.AnimatorPack$Direction r1 = com.zopim.android.sdk.anim.AnimatorPack.Direction.TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$anim$AnimatorPack$Direction     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.anim.AnimatorPack$Direction r1 = com.zopim.android.sdk.anim.AnimatorPack.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$anim$AnimatorPack$Direction     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zopim.android.sdk.anim.AnimatorPack$Direction r1 = com.zopim.android.sdk.anim.AnimatorPack.Direction.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.anim.AnimatorPack.AnonymousClass7.<clinit>():void");
        }
    }

    public enum Direction {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    public static AnimatorSet crossfade(final View view, final View view2, Animator.AnimatorListener animatorListener, Animator.AnimatorListener animatorListener2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.5f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "alpha", new float[]{0.5f, 1.0f});
        AnimatorSet scale = scale(view, 1.0f, 0.5f);
        AnimatorSet scale2 = scale(view2, 0.5f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(DURATION);
        animatorSet.play(ofFloat).with(scale).before(ofFloat2).before(scale2);
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        if (animatorListener2 != null) {
            ofFloat2.addListener(animatorListener2);
        }
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }
        });
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view2.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public static Animator fadeIn(final View view) {
        if (view == null) {
            return new AnimatorSet();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet scale = scale(view, 0.5f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(DURATION);
        animatorSet.play(ofFloat).with(scale);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }
        });
        return animatorSet;
    }

    public static Animator fadeOut(final View view) {
        if (view == null) {
            return new AnimatorSet();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet scale = scale(view, 1.0f, 0.5f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(DURATION);
        animatorSet.play(ofFloat).with(scale);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(4);
            }
        });
        return animatorSet;
    }

    public static AnimatorSet scale(View view, float f11, float f12) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{f11, f12});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{f11, f12});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(DURATION);
        return animatorSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.Animator slideIn(final android.view.View r12, com.zopim.android.sdk.anim.AnimatorPack.Direction r13) {
        /*
            r0 = 0
            if (r13 == 0) goto L_0x00e3
            if (r12 == 0) goto L_0x00e3
            float r1 = r12.getTranslationX()
            float r2 = r12.getTranslationY()
            r3 = 2
            int[] r4 = new int[r3]
            r12.getLocationOnScreen(r4)
            android.graphics.Rect r5 = new android.graphics.Rect
            r6 = 0
            r7 = r4[r6]
            r8 = 1
            r9 = r4[r8]
            r10 = r4[r6]
            int r11 = r12.getWidth()
            int r10 = r10 + r11
            r4 = r4[r8]
            int r11 = r12.getHeight()
            int r4 = r4 + r11
            r5.<init>(r7, r9, r10, r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            android.content.Context r7 = r12.getContext()     // Catch:{ Exception -> 0x0043 }
            android.app.Activity r7 = (android.app.Activity) r7     // Catch:{ Exception -> 0x0043 }
            android.view.Window r7 = r7.getWindow()     // Catch:{ Exception -> 0x0043 }
            android.view.View r7 = r7.getDecorView()     // Catch:{ Exception -> 0x0043 }
            r7.getWindowVisibleDisplayFrame(r4)     // Catch:{ Exception -> 0x0043 }
            goto L_0x0067
        L_0x0043:
            r7 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Can not get activity visible rectangle, will use phone view. "
            r9.append(r10)
            java.lang.String r7 = r7.getMessage()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.Object[] r9 = new java.lang.Object[r6]
            java.lang.String r10 = "AnimatorPack"
            com.zendesk.logger.Logger.l(r10, r7, r9)
            android.view.View r7 = r12.getRootView()
            r7.getLocalVisibleRect(r4)
        L_0x0067:
            int[] r7 = com.zopim.android.sdk.anim.AnimatorPack.AnonymousClass7.$SwitchMap$com$zopim$android$sdk$anim$AnimatorPack$Direction
            int r13 = r13.ordinal()
            r13 = r7[r13]
            java.lang.String r7 = "translationX"
            if (r13 == r8) goto L_0x00be
            java.lang.String r9 = "translationY"
            if (r13 == r3) goto L_0x00a8
            r10 = 3
            if (r13 == r10) goto L_0x0093
            r1 = 4
            if (r13 == r1) goto L_0x007e
            goto L_0x00d4
        L_0x007e:
            float[] r13 = new float[r3]
            int r0 = r4.bottom
            int r1 = r5.top
            int r0 = r0 - r1
            int r0 = java.lang.Math.abs(r0)
            float r0 = (float) r0
            r13[r6] = r0
            r13[r8] = r2
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r12, r9, r13)
            goto L_0x00d3
        L_0x0093:
            float[] r13 = new float[r3]
            int r0 = r4.right
            int r2 = r5.left
            int r0 = r0 - r2
            int r0 = java.lang.Math.abs(r0)
            float r0 = (float) r0
            r13[r6] = r0
            r13[r8] = r1
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r12, r7, r13)
            goto L_0x00d3
        L_0x00a8:
            float[] r13 = new float[r3]
            int r0 = r4.top
            int r1 = r5.bottom
            int r0 = r0 - r1
            int r0 = java.lang.Math.abs(r0)
            int r0 = -r0
            float r0 = (float) r0
            r13[r6] = r0
            r13[r8] = r2
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r12, r9, r13)
            goto L_0x00d3
        L_0x00be:
            float[] r13 = new float[r3]
            int r0 = r4.left
            int r2 = r5.right
            int r0 = r0 - r2
            int r0 = java.lang.Math.abs(r0)
            int r0 = -r0
            float r0 = (float) r0
            r13[r6] = r0
            r13[r8] = r1
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r12, r7, r13)
        L_0x00d3:
            r0 = r13
        L_0x00d4:
            if (r0 == 0) goto L_0x00e3
            r1 = 400(0x190, double:1.976E-321)
            r0.setDuration(r1)
            com.zopim.android.sdk.anim.AnimatorPack$4 r13 = new com.zopim.android.sdk.anim.AnimatorPack$4
            r13.<init>(r12)
            r0.addListener(r13)
        L_0x00e3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.anim.AnimatorPack.slideIn(android.view.View, com.zopim.android.sdk.anim.AnimatorPack$Direction):android.animation.Animator");
    }

    public static Animator slideInSequentially(Direction direction, long j11, boolean z11, boolean z12, View... viewArr) {
        if (direction == null || viewArr == null) {
            return new AnimatorSet();
        }
        long j12 = 0;
        ArrayList arrayList = new ArrayList();
        for (View view : viewArr) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setStartDelay(j12);
            animatorSet.play(slideIn(view, direction));
            if (z11) {
                animatorSet.play(ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f}).setDuration(DURATION));
            }
            if (z12) {
                animatorSet.play(scale(view, 0.5f, 1.0f));
            }
            arrayList.add(animatorSet);
            j12 += j11;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(arrayList);
        return animatorSet2;
    }

    public static Animator slideOut(final View view, Direction direction) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (!(direction == null || view == null)) {
            final float translationX = view.getTranslationX();
            final float translationY = view.getTranslationY();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
            Rect rect2 = new Rect();
            try {
                ((Activity) view.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            } catch (Exception e11) {
                Logger.l(LOG_TAG, "Can not get activity visible rectangle, will use phone view. " + e11.getMessage(), new Object[0]);
                view.getRootView().getLocalVisibleRect(rect2);
            }
            int i11 = AnonymousClass7.$SwitchMap$com$zopim$android$sdk$anim$AnimatorPack$Direction[direction.ordinal()];
            if (i11 == 1) {
                objectAnimator = ObjectAnimator.ofFloat(view, "translationX", new float[]{translationX, translationX - ((float) Math.abs(rect2.left - rect.right))});
            } else if (i11 == 2) {
                objectAnimator = ObjectAnimator.ofFloat(view, "translationY", new float[]{translationY, translationY - ((float) Math.abs(rect2.top - rect.bottom))});
            } else if (i11 != 3) {
                if (i11 == 4) {
                    objectAnimator = ObjectAnimator.ofFloat(view, "translationY", new float[]{translationY, ((float) Math.abs(rect2.bottom - rect.top)) + translationY});
                }
                objectAnimator2.setDuration(DURATION);
                objectAnimator2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        view.setVisibility(4);
                        view.setTranslationX(translationX);
                        view.setTranslationY(translationY);
                    }

                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        view.setVisibility(0);
                    }
                });
            } else {
                objectAnimator = ObjectAnimator.ofFloat(view, "translationX", new float[]{translationX, ((float) Math.abs(rect2.right - rect.left)) + translationX});
            }
            objectAnimator2 = objectAnimator;
            objectAnimator2.setDuration(DURATION);
            objectAnimator2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    view.setVisibility(4);
                    view.setTranslationX(translationX);
                    view.setTranslationY(translationY);
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    view.setVisibility(0);
                }
            });
        }
        return objectAnimator2;
    }

    public static Animator slideOutSequentially(Direction direction, long j11, boolean z11, boolean z12, View... viewArr) {
        if (direction == null || viewArr == null) {
            return new AnimatorSet();
        }
        long j12 = 0;
        ArrayList arrayList = new ArrayList();
        for (View view : viewArr) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setStartDelay(j12);
            animatorSet.play(slideOut(view, direction));
            if (z11) {
                animatorSet.play(ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f}).setDuration(DURATION));
            }
            if (z12) {
                animatorSet.play(scale(view, 1.0f, 0.5f));
            }
            arrayList.add(animatorSet);
            j12 += j11;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(arrayList);
        return animatorSet2;
    }

    public static AnimatorSet crossfade(View view, View view2) {
        return crossfade(view, view2, (Animator.AnimatorListener) null, (Animator.AnimatorListener) null);
    }
}
