package com.mob.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.utils.UIHandler;
import java.util.Iterator;

@Deprecated
public class RxMob implements EverythingKeeper {

    public interface OnSubscribe<T> extends EverythingKeeper {
        void call(Subscriber<T> subscriber);
    }

    public static abstract class QuickSubscribe<T> implements OnSubscribe<T> {
        public final void call(Subscriber<T> subscriber) {
            subscriber.onStart();
            try {
                doNext(subscriber);
                subscriber.onCompleted();
            } catch (Throwable th2) {
                subscriber.onError(th2);
            }
        }

        public abstract void doNext(Subscriber<T> subscriber) throws Throwable;
    }

    public static final class Subscribable<T> implements EverythingKeeper {
        /* access modifiers changed from: private */
        public Thread observeThread;
        /* access modifiers changed from: private */
        public OnSubscribe<T> onSubscribe;
        private Thread subscribeThread;

        public Subscribable<T> observeOn(Thread thread) {
            this.observeThread = thread;
            return this;
        }

        public void subscribe(final Subscriber<T> subscriber) {
            OnSubscribe<T> onSubscribe2 = this.onSubscribe;
            if (onSubscribe2 != null) {
                Thread thread = this.subscribeThread;
                if (thread == Thread.UI_THREAD) {
                    UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                        public boolean handleMessage(Message message) {
                            Subscribable.this.onSubscribe.call(new SubscriberWarpper(Subscribable.this, subscriber));
                            return false;
                        }
                    });
                } else if (thread == Thread.NEW_THREAD) {
                    new Thread() {
                        public void run() {
                            Subscribable.this.onSubscribe.call(new SubscriberWarpper(Subscribable.this, subscriber));
                        }
                    }.start();
                } else {
                    onSubscribe2.call(new SubscriberWarpper(this, subscriber));
                }
            }
        }

        public Subscribable<T> subscribeOn(Thread thread) {
            this.subscribeThread = thread;
            return this;
        }

        public void subscribeOnNewThreadAndObserveOnUIThread(Subscriber<T> subscriber) {
            subscribeOn(Thread.NEW_THREAD);
            observeOn(Thread.UI_THREAD);
            subscribe(subscriber);
        }

        private Subscribable() {
        }
    }

    public static class Subscriber<T> implements EverythingKeeper {
        private SubscriberWarpper<T> warpper;

        /* access modifiers changed from: private */
        public void setWarpper(SubscriberWarpper<T> subscriberWarpper) {
            this.warpper = subscriberWarpper;
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(T t11) {
        }

        public void onStart() {
        }

        public final void unsubscribe() {
            SubscriberWarpper<T> subscriberWarpper = this.warpper;
            if (subscriberWarpper != null) {
                subscriberWarpper.removeSubscriber();
                this.warpper = null;
            }
        }
    }

    public static final class SubscriberWarpper<T> extends Subscriber<T> {
        private Subscribable<T> subscribable;
        /* access modifiers changed from: private */
        public Subscriber<T> subscriber;

        public SubscriberWarpper(Subscribable<T> subscribable2, Subscriber<T> subscriber2) {
            this.subscribable = subscribable2;
            this.subscriber = subscriber2;
            subscriber2.setWarpper(this);
        }

        public void onCompleted() {
            if (this.subscriber == null) {
                return;
            }
            if (this.subscribable.observeThread == Thread.UI_THREAD) {
                if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    this.subscriber.onCompleted();
                    removeSubscriber();
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = this.subscriber;
                UIHandler.sendMessage(obtain, new Handler.Callback() {
                    public boolean handleMessage(Message message) {
                        if (message == null) {
                            return false;
                        }
                        try {
                            Subscriber subscriber = (Subscriber) message.obj;
                            if (subscriber != null) {
                                subscriber.onCompleted();
                                SubscriberWarpper.this.removeSubscriber();
                                return false;
                            }
                            MobLog.getInstance().crash(new Throwable("[UIThread/onComplete] Network request interrupted as Subscriber is null"));
                            return false;
                        } catch (Throwable th2) {
                            MobLog.getInstance().crash(th2);
                            return false;
                        }
                    }
                });
            } else if (this.subscribable.observeThread == Thread.NEW_THREAD) {
                new Thread() {
                    public void run() {
                        if (SubscriberWarpper.this.subscriber != null) {
                            SubscriberWarpper.this.subscriber.onCompleted();
                            SubscriberWarpper.this.removeSubscriber();
                            return;
                        }
                        MobLog.getInstance().crash(new Throwable("[NewThread/onComplete] Network request interrupted as Subscriber is null"));
                    }
                }.start();
            } else {
                this.subscriber.onCompleted();
                removeSubscriber();
            }
        }

        public void onError(final Throwable th2) {
            if (this.subscriber == null) {
                return;
            }
            if (this.subscribable.observeThread == Thread.UI_THREAD) {
                if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    this.subscriber.onError(th2);
                    removeSubscriber();
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = this.subscriber;
                UIHandler.sendMessage(obtain, new Handler.Callback() {
                    public boolean handleMessage(Message message) {
                        if (message == null) {
                            return false;
                        }
                        try {
                            Subscriber subscriber = (Subscriber) message.obj;
                            if (subscriber != null) {
                                subscriber.onError(th2);
                                SubscriberWarpper.this.removeSubscriber();
                                return false;
                            }
                            MobLog.getInstance().crash(new Throwable("[UIThread/onError] Network request interrupted as Subscriber is null"));
                            return false;
                        } catch (Throwable th2) {
                            MobLog.getInstance().crash(th2);
                            return false;
                        }
                    }
                });
            } else if (this.subscribable.observeThread == Thread.NEW_THREAD) {
                new Thread() {
                    public void run() {
                        if (SubscriberWarpper.this.subscriber != null) {
                            SubscriberWarpper.this.subscriber.onError(th2);
                            SubscriberWarpper.this.removeSubscriber();
                            return;
                        }
                        MobLog.getInstance().crash(new Throwable("[NewThread/onError] Network request interrupted as Subscriber is null"));
                    }
                }.start();
            } else {
                this.subscriber.onError(th2);
                removeSubscriber();
            }
        }

        public void onNext(final T t11) {
            if (this.subscriber == null) {
                return;
            }
            if (this.subscribable.observeThread == Thread.UI_THREAD) {
                if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    this.subscriber.onNext(t11);
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = this.subscriber;
                UIHandler.sendMessage(obtain, new Handler.Callback() {
                    public boolean handleMessage(Message message) {
                        if (message == null) {
                            return false;
                        }
                        try {
                            Subscriber subscriber = (Subscriber) message.obj;
                            if (subscriber != null) {
                                subscriber.onNext(t11);
                                return false;
                            }
                            MobLog.getInstance().crash(new Throwable("[UIThread/onNext] Network request interrupted as Subscriber is null"));
                            return false;
                        } catch (Throwable th2) {
                            MobLog.getInstance().crash(th2);
                            return false;
                        }
                    }
                });
            } else if (this.subscribable.observeThread == Thread.NEW_THREAD) {
                new Thread() {
                    public void run() {
                        if (SubscriberWarpper.this.subscriber != null) {
                            SubscriberWarpper.this.subscriber.onNext(t11);
                        } else {
                            MobLog.getInstance().crash(new Throwable("[NewThread/onNext] Network request interrupted as Subscriber is null"));
                        }
                    }
                }.start();
            } else {
                this.subscriber.onNext(t11);
            }
        }

        public void onStart() {
            if (this.subscriber == null) {
                return;
            }
            if (this.subscribable.observeThread == Thread.UI_THREAD) {
                if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    this.subscriber.onStart();
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = this.subscriber;
                UIHandler.sendMessage(obtain, new Handler.Callback() {
                    public boolean handleMessage(Message message) {
                        if (message == null) {
                            return false;
                        }
                        try {
                            Subscriber subscriber = (Subscriber) message.obj;
                            if (subscriber != null) {
                                subscriber.onStart();
                                return false;
                            }
                            MobLog.getInstance().crash(new Throwable("[UIThread/onStart] Network request interrupted as Subscriber is null"));
                            return false;
                        } catch (Throwable th2) {
                            MobLog.getInstance().crash(th2);
                            return false;
                        }
                    }
                });
            } else if (this.subscribable.observeThread == Thread.NEW_THREAD) {
                new Thread() {
                    public void run() {
                        if (SubscriberWarpper.this.subscriber != null) {
                            SubscriberWarpper.this.subscriber.onStart();
                        } else {
                            MobLog.getInstance().crash(new Throwable("[NewThread/onStart] Network request interrupted as Subscriber is null"));
                        }
                    }
                }.start();
            } else {
                this.subscriber.onStart();
            }
        }

        public void removeSubscriber() {
            this.subscriber = null;
        }
    }

    public enum Thread implements EverythingKeeper {
        IMMEDIATE,
        UI_THREAD,
        NEW_THREAD
    }

    public static <T> Subscribable<T> create(OnSubscribe<T> onSubscribe) {
        Subscribable<T> subscribable = new Subscribable<>();
        OnSubscribe unused = subscribable.onSubscribe = onSubscribe;
        return subscribable;
    }

    public static <T> Subscribable<T> from(final Iterator<T> it2) {
        return create(new QuickSubscribe<T>() {
            public void doNext(Subscriber<T> subscriber) throws Throwable {
                while (it2.hasNext()) {
                    subscriber.onNext(it2.next());
                }
            }
        });
    }

    public static <T> Subscribable<T> just(final T... tArr) {
        return create(new QuickSubscribe<T>() {
            public void doNext(Subscriber<T> subscriber) throws Throwable {
                for (Object onNext : tArr) {
                    subscriber.onNext(onNext);
                }
            }
        });
    }
}
