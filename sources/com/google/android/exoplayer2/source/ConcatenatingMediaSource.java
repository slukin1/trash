package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> {
    /* access modifiers changed from: private */
    public static final MediaItem EMPTY_MEDIA_ITEM = new MediaItem.Builder().setUri(Uri.EMPTY).build();
    private static final int MSG_ADD = 0;
    private static final int MSG_MOVE = 2;
    private static final int MSG_ON_COMPLETION = 5;
    private static final int MSG_REMOVE = 1;
    private static final int MSG_SET_SHUFFLE_ORDER = 3;
    private static final int MSG_UPDATE_TIMELINE = 4;
    private final Set<MediaSourceHolder> enabledMediaSourceHolders;
    private final boolean isAtomic;
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> mediaSourceByMediaPeriod;
    private final Map<Object, MediaSourceHolder> mediaSourceByUid;
    private final List<MediaSourceHolder> mediaSourceHolders;
    private final List<MediaSourceHolder> mediaSourcesPublic;
    private Set<HandlerAndRunnable> nextTimelineUpdateOnCompletionActions;
    private final Set<HandlerAndRunnable> pendingOnCompletionActions;
    private Handler playbackThreadHandler;
    private ShuffleOrder shuffleOrder;
    private boolean timelineUpdateScheduled;
    private final boolean useLazyPreparation;

    public static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        private final HashMap<Object, Integer> childIndexByUid = new HashMap<>();
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final Timeline[] timelines;
        private final Object[] uids;
        private final int windowCount;

        public ConcatenatedTimeline(Collection<MediaSourceHolder> collection, ShuffleOrder shuffleOrder, boolean z11) {
            super(z11, shuffleOrder);
            int size = collection.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new Timeline[size];
            this.uids = new Object[size];
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            for (MediaSourceHolder next : collection) {
                this.timelines[i13] = next.mediaSource.getTimeline();
                this.firstWindowInChildIndices[i13] = i11;
                this.firstPeriodInChildIndices[i13] = i12;
                i11 += this.timelines[i13].getWindowCount();
                i12 += this.timelines[i13].getPeriodCount();
                Object[] objArr = this.uids;
                objArr[i13] = next.uid;
                this.childIndexByUid.put(objArr[i13], Integer.valueOf(i13));
                i13++;
            }
            this.windowCount = i11;
            this.periodCount = i12;
        }

        public int getChildIndexByChildUid(Object obj) {
            Integer num = this.childIndexByUid.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public int getChildIndexByPeriodIndex(int i11) {
            return Util.binarySearchFloor(this.firstPeriodInChildIndices, i11 + 1, false, false);
        }

        public int getChildIndexByWindowIndex(int i11) {
            return Util.binarySearchFloor(this.firstWindowInChildIndices, i11 + 1, false, false);
        }

        public Object getChildUidByChildIndex(int i11) {
            return this.uids[i11];
        }

        public int getFirstPeriodIndexByChildIndex(int i11) {
            return this.firstPeriodInChildIndices[i11];
        }

        public int getFirstWindowIndexByChildIndex(int i11) {
            return this.firstWindowInChildIndices[i11];
        }

        public int getPeriodCount() {
            return this.periodCount;
        }

        public Timeline getTimelineByChildIndex(int i11) {
            return this.timelines[i11];
        }

        public int getWindowCount() {
            return this.windowCount;
        }
    }

    public static final class FakeMediaSource extends BaseMediaSource {
        private FakeMediaSource() {
        }

        public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
            throw new UnsupportedOperationException();
        }

        public MediaItem getMediaItem() {
            return ConcatenatingMediaSource.EMPTY_MEDIA_ITEM;
        }

        public void maybeThrowSourceInfoRefreshError() {
        }

        public void prepareSourceInternal(TransferListener transferListener) {
        }

        public void releasePeriod(MediaPeriod mediaPeriod) {
        }

        public void releaseSourceInternal() {
        }
    }

    public static final class HandlerAndRunnable {
        private final Handler handler;
        private final Runnable runnable;

        public HandlerAndRunnable(Handler handler2, Runnable runnable2) {
            this.handler = handler2;
            this.runnable = runnable2;
        }

        public void dispatch() {
            this.handler.post(this.runnable);
        }
    }

    public static final class MediaSourceHolder {
        public final List<MediaSource.MediaPeriodId> activeMediaPeriodIds = new ArrayList();
        public int childIndex;
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final Object uid = new Object();

        public MediaSourceHolder(MediaSource mediaSource2, boolean z11) {
            this.mediaSource = new MaskingMediaSource(mediaSource2, z11);
        }

        public void reset(int i11, int i12) {
            this.childIndex = i11;
            this.firstWindowIndexInChild = i12;
            this.isRemoved = false;
            this.activeMediaPeriodIds.clear();
        }
    }

    public static final class MessageData<T> {
        public final T customData;
        public final int index;
        public final HandlerAndRunnable onCompletionAction;

        public MessageData(int i11, T t11, HandlerAndRunnable handlerAndRunnable) {
            this.index = i11;
            this.customData = t11;
            this.onCompletionAction = handlerAndRunnable;
        }
    }

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private void addMediaSourceInternal(int i11, MediaSourceHolder mediaSourceHolder) {
        if (i11 > 0) {
            MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i11 - 1);
            mediaSourceHolder.reset(i11, mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.mediaSource.getTimeline().getWindowCount());
        } else {
            mediaSourceHolder.reset(i11, 0);
        }
        correctOffsets(i11, 1, mediaSourceHolder.mediaSource.getTimeline().getWindowCount());
        this.mediaSourceHolders.add(i11, mediaSourceHolder);
        this.mediaSourceByUid.put(mediaSourceHolder.uid, mediaSourceHolder);
        prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
        if (!isEnabled() || !this.mediaSourceByMediaPeriod.isEmpty()) {
            disableChildSource(mediaSourceHolder);
        } else {
            this.enabledMediaSourceHolders.add(mediaSourceHolder);
        }
    }

    private void addMediaSourcesInternal(int i11, Collection<MediaSourceHolder> collection) {
        for (MediaSourceHolder addMediaSourceInternal : collection) {
            addMediaSourceInternal(i11, addMediaSourceInternal);
            i11++;
        }
    }

    private void addPublicMediaSources(int i11, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        boolean z11 = true;
        if ((handler == null) != (runnable == null)) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        Handler handler2 = this.playbackThreadHandler;
        for (MediaSource checkNotNull : collection) {
            Assertions.checkNotNull(checkNotNull);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (MediaSource mediaSourceHolder : collection) {
            arrayList.add(new MediaSourceHolder(mediaSourceHolder, this.useLazyPreparation));
        }
        this.mediaSourcesPublic.addAll(i11, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new MessageData(i11, arrayList, createOnCompletionAction(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void correctOffsets(int i11, int i12, int i13) {
        while (i11 < this.mediaSourceHolders.size()) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(i11);
            mediaSourceHolder.childIndex += i12;
            mediaSourceHolder.firstWindowIndexInChild += i13;
            i11++;
        }
    }

    private HandlerAndRunnable createOnCompletionAction(Handler handler, Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        HandlerAndRunnable handlerAndRunnable = new HandlerAndRunnable(handler, runnable);
        this.pendingOnCompletionActions.add(handlerAndRunnable);
        return handlerAndRunnable;
    }

    private void disableUnusedMediaSources() {
        Iterator<MediaSourceHolder> it2 = this.enabledMediaSourceHolders.iterator();
        while (it2.hasNext()) {
            MediaSourceHolder next = it2.next();
            if (next.activeMediaPeriodIds.isEmpty()) {
                disableChildSource(next);
                it2.remove();
            }
        }
    }

    private synchronized void dispatchOnCompletionActions(Set<HandlerAndRunnable> set) {
        for (HandlerAndRunnable dispatch : set) {
            dispatch.dispatch();
        }
        this.pendingOnCompletionActions.removeAll(set);
    }

    private void enableMediaSource(MediaSourceHolder mediaSourceHolder) {
        this.enabledMediaSourceHolders.add(mediaSourceHolder);
        enableChildSource(mediaSourceHolder);
    }

    private static Object getChildPeriodUid(Object obj) {
        return AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(obj);
    }

    private static Object getMediaSourceHolderUid(Object obj) {
        return AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(obj);
    }

    private static Object getPeriodUid(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.getConcatenatedUid(mediaSourceHolder.uid, obj);
    }

    private Handler getPlaybackThreadHandlerOnPlaybackThread() {
        return (Handler) Assertions.checkNotNull(this.playbackThreadHandler);
    }

    /* access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            MessageData messageData = (MessageData) Util.castNonNull(message.obj);
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData.index, ((Collection) messageData.customData).size());
            addMediaSourcesInternal(messageData.index, (Collection) messageData.customData);
            scheduleTimelineUpdate(messageData.onCompletionAction);
        } else if (i11 == 1) {
            MessageData messageData2 = (MessageData) Util.castNonNull(message.obj);
            int i12 = messageData2.index;
            int intValue = ((Integer) messageData2.customData).intValue();
            if (i12 == 0 && intValue == this.shuffleOrder.getLength()) {
                this.shuffleOrder = this.shuffleOrder.cloneAndClear();
            } else {
                this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i12, intValue);
            }
            for (int i13 = intValue - 1; i13 >= i12; i13--) {
                removeMediaSourceInternal(i13);
            }
            scheduleTimelineUpdate(messageData2.onCompletionAction);
        } else if (i11 == 2) {
            MessageData messageData3 = (MessageData) Util.castNonNull(message.obj);
            ShuffleOrder shuffleOrder2 = this.shuffleOrder;
            int i14 = messageData3.index;
            ShuffleOrder cloneAndRemove = shuffleOrder2.cloneAndRemove(i14, i14 + 1);
            this.shuffleOrder = cloneAndRemove;
            this.shuffleOrder = cloneAndRemove.cloneAndInsert(((Integer) messageData3.customData).intValue(), 1);
            moveMediaSourceInternal(messageData3.index, ((Integer) messageData3.customData).intValue());
            scheduleTimelineUpdate(messageData3.onCompletionAction);
        } else if (i11 == 3) {
            MessageData messageData4 = (MessageData) Util.castNonNull(message.obj);
            this.shuffleOrder = (ShuffleOrder) messageData4.customData;
            scheduleTimelineUpdate(messageData4.onCompletionAction);
        } else if (i11 == 4) {
            updateTimelineAndScheduleOnCompletionActions();
        } else if (i11 == 5) {
            dispatchOnCompletionActions((Set) Util.castNonNull(message.obj));
        } else {
            throw new IllegalStateException();
        }
        return true;
    }

    private void maybeReleaseChildSource(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.activeMediaPeriodIds.isEmpty()) {
            this.enabledMediaSourceHolders.remove(mediaSourceHolder);
            releaseChildSource(mediaSourceHolder);
        }
    }

    private void moveMediaSourceInternal(int i11, int i12) {
        int min = Math.min(i11, i12);
        int max = Math.max(i11, i12);
        int i13 = this.mediaSourceHolders.get(min).firstWindowIndexInChild;
        List<MediaSourceHolder> list = this.mediaSourceHolders;
        list.add(i12, list.remove(i11));
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(min);
            mediaSourceHolder.childIndex = min;
            mediaSourceHolder.firstWindowIndexInChild = i13;
            i13 += mediaSourceHolder.mediaSource.getTimeline().getWindowCount();
            min++;
        }
    }

    private void movePublicMediaSource(int i11, int i12, Handler handler, Runnable runnable) {
        boolean z11 = true;
        if ((handler == null) != (runnable == null)) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        Handler handler2 = this.playbackThreadHandler;
        List<MediaSourceHolder> list = this.mediaSourcesPublic;
        list.add(i12, list.remove(i11));
        if (handler2 != null) {
            handler2.obtainMessage(2, new MessageData(i11, Integer.valueOf(i12), createOnCompletionAction(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void removeMediaSourceInternal(int i11) {
        MediaSourceHolder remove = this.mediaSourceHolders.remove(i11);
        this.mediaSourceByUid.remove(remove.uid);
        correctOffsets(i11, -1, -remove.mediaSource.getTimeline().getWindowCount());
        remove.isRemoved = true;
        maybeReleaseChildSource(remove);
    }

    private void removePublicMediaSources(int i11, int i12, Handler handler, Runnable runnable) {
        boolean z11 = false;
        if ((handler == null) == (runnable == null)) {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        Handler handler2 = this.playbackThreadHandler;
        Util.removeRange(this.mediaSourcesPublic, i11, i12);
        if (handler2 != null) {
            handler2.obtainMessage(1, new MessageData(i11, Integer.valueOf(i12), createOnCompletionAction(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void scheduleTimelineUpdate() {
        scheduleTimelineUpdate((HandlerAndRunnable) null);
    }

    private void setPublicShuffleOrder(ShuffleOrder shuffleOrder2, Handler handler, Runnable runnable) {
        boolean z11 = true;
        if ((handler == null) != (runnable == null)) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        Handler handler2 = this.playbackThreadHandler;
        if (handler2 != null) {
            int size = getSize();
            if (shuffleOrder2.getLength() != size) {
                shuffleOrder2 = shuffleOrder2.cloneAndClear().cloneAndInsert(0, size);
            }
            handler2.obtainMessage(3, new MessageData(0, shuffleOrder2, createOnCompletionAction(handler, runnable))).sendToTarget();
            return;
        }
        if (shuffleOrder2.getLength() > 0) {
            shuffleOrder2 = shuffleOrder2.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder2;
        if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void updateMediaSourceInternal(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        int windowCount;
        if (mediaSourceHolder.childIndex + 1 < this.mediaSourceHolders.size() && (windowCount = timeline.getWindowCount() - (this.mediaSourceHolders.get(mediaSourceHolder.childIndex + 1).firstWindowIndexInChild - mediaSourceHolder.firstWindowIndexInChild)) != 0) {
            correctOffsets(mediaSourceHolder.childIndex + 1, 0, windowCount);
        }
        scheduleTimelineUpdate();
    }

    private void updateTimelineAndScheduleOnCompletionActions() {
        this.timelineUpdateScheduled = false;
        Set<HandlerAndRunnable> set = this.nextTimelineUpdateOnCompletionActions;
        this.nextTimelineUpdateOnCompletionActions = new HashSet();
        refreshSourceInfo(new ConcatenatedTimeline(this.mediaSourceHolders, this.shuffleOrder, this.isAtomic));
        getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(5, set).sendToTarget();
    }

    public synchronized void addMediaSource(MediaSource mediaSource) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection) {
        addPublicMediaSources(this.mediaSourcesPublic.size(), collection, (Handler) null, (Runnable) null);
    }

    public synchronized void clear() {
        removeMediaSourceRange(0, getSize());
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        Object mediaSourceHolderUid = getMediaSourceHolderUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(getChildPeriodUid(mediaPeriodId.periodUid));
        MediaSourceHolder mediaSourceHolder = this.mediaSourceByUid.get(mediaSourceHolderUid);
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new MediaSourceHolder(new FakeMediaSource(), this.useLazyPreparation);
            mediaSourceHolder.isRemoved = true;
            prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
        }
        enableMediaSource(mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriodIds.add(copyWithPeriodUid);
        MaskingMediaPeriod createPeriod = mediaSourceHolder.mediaSource.createPeriod(copyWithPeriodUid, allocator, j11);
        this.mediaSourceByMediaPeriod.put(createPeriod, mediaSourceHolder);
        disableUnusedMediaSources();
        return createPeriod;
    }

    public void disableInternal() {
        super.disableInternal();
        this.enabledMediaSourceHolders.clear();
    }

    public void enableInternal() {
    }

    public synchronized Timeline getInitialTimeline() {
        ShuffleOrder shuffleOrder2;
        if (this.shuffleOrder.getLength() != this.mediaSourcesPublic.size()) {
            shuffleOrder2 = this.shuffleOrder.cloneAndClear().cloneAndInsert(0, this.mediaSourcesPublic.size());
        } else {
            shuffleOrder2 = this.shuffleOrder;
        }
        return new ConcatenatedTimeline(this.mediaSourcesPublic, shuffleOrder2, this.isAtomic);
    }

    public MediaItem getMediaItem() {
        return EMPTY_MEDIA_ITEM;
    }

    public synchronized MediaSource getMediaSource(int i11) {
        return this.mediaSourcesPublic.get(i11).mediaSource;
    }

    public synchronized int getSize() {
        return this.mediaSourcesPublic.size();
    }

    public boolean isSingleWindow() {
        return false;
    }

    public synchronized void moveMediaSource(int i11, int i12) {
        movePublicMediaSource(i11, i12, (Handler) null, (Runnable) null);
    }

    public synchronized void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.playbackThreadHandler = new Handler(new b(this));
        if (this.mediaSourcesPublic.isEmpty()) {
            updateTimelineAndScheduleOnCompletionActions();
        } else {
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
            addMediaSourcesInternal(0, this.mediaSourcesPublic);
            scheduleTimelineUpdate();
        }
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        mediaSourceHolder.mediaSource.releasePeriod(mediaPeriod);
        mediaSourceHolder.activeMediaPeriodIds.remove(((MaskingMediaPeriod) mediaPeriod).f65979id);
        if (!this.mediaSourceByMediaPeriod.isEmpty()) {
            disableUnusedMediaSources();
        }
        maybeReleaseChildSource(mediaSourceHolder);
    }

    public synchronized void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.mediaSourceHolders.clear();
        this.enabledMediaSourceHolders.clear();
        this.mediaSourceByUid.clear();
        this.shuffleOrder = this.shuffleOrder.cloneAndClear();
        Handler handler = this.playbackThreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.playbackThreadHandler = null;
        }
        this.timelineUpdateScheduled = false;
        this.nextTimelineUpdateOnCompletionActions.clear();
        dispatchOnCompletionActions(this.pendingOnCompletionActions);
    }

    public synchronized MediaSource removeMediaSource(int i11) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(i11);
        removePublicMediaSources(i11, i11 + 1, (Handler) null, (Runnable) null);
        return mediaSource;
    }

    public synchronized void removeMediaSourceRange(int i11, int i12) {
        removePublicMediaSources(i11, i12, (Handler) null, (Runnable) null);
    }

    public synchronized void setShuffleOrder(ShuffleOrder shuffleOrder2) {
        setPublicShuffleOrder(shuffleOrder2, (Handler) null, (Runnable) null);
    }

    public ConcatenatingMediaSource(boolean z11, MediaSource... mediaSourceArr) {
        this(z11, new ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    private void scheduleTimelineUpdate(HandlerAndRunnable handlerAndRunnable) {
        if (!this.timelineUpdateScheduled) {
            getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(4).sendToTarget();
            this.timelineUpdateScheduled = true;
        }
        if (handlerAndRunnable != null) {
            this.nextTimelineUpdateOnCompletionActions.add(handlerAndRunnable);
        }
    }

    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i11 = 0; i11 < mediaSourceHolder.activeMediaPeriodIds.size(); i11++) {
            if (mediaSourceHolder.activeMediaPeriodIds.get(i11).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(getPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    public int getWindowIndexForChildWindowIndex(MediaSourceHolder mediaSourceHolder, int i11) {
        return i11 + mediaSourceHolder.firstWindowIndexInChild;
    }

    public void onChildSourceInfoRefreshed(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, Timeline timeline) {
        updateMediaSourceInternal(mediaSourceHolder, timeline);
    }

    public ConcatenatingMediaSource(boolean z11, ShuffleOrder shuffleOrder2, MediaSource... mediaSourceArr) {
        this(z11, false, shuffleOrder2, mediaSourceArr);
    }

    public synchronized void addMediaSource(MediaSource mediaSource, Handler handler, Runnable runnable) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, handler, runnable);
    }

    public synchronized void clear(Handler handler, Runnable runnable) {
        removeMediaSourceRange(0, getSize(), handler, runnable);
    }

    public synchronized void moveMediaSource(int i11, int i12, Handler handler, Runnable runnable) {
        movePublicMediaSource(i11, i12, handler, runnable);
    }

    public synchronized void removeMediaSourceRange(int i11, int i12, Handler handler, Runnable runnable) {
        removePublicMediaSources(i11, i12, handler, runnable);
    }

    public synchronized void setShuffleOrder(ShuffleOrder shuffleOrder2, Handler handler, Runnable runnable) {
        setPublicShuffleOrder(shuffleOrder2, handler, runnable);
    }

    public ConcatenatingMediaSource(boolean z11, boolean z12, ShuffleOrder shuffleOrder2, MediaSource... mediaSourceArr) {
        for (MediaSource checkNotNull : mediaSourceArr) {
            Assertions.checkNotNull(checkNotNull);
        }
        this.shuffleOrder = shuffleOrder2.getLength() > 0 ? shuffleOrder2.cloneAndClear() : shuffleOrder2;
        this.mediaSourceByMediaPeriod = new IdentityHashMap<>();
        this.mediaSourceByUid = new HashMap();
        this.mediaSourcesPublic = new ArrayList();
        this.mediaSourceHolders = new ArrayList();
        this.nextTimelineUpdateOnCompletionActions = new HashSet();
        this.pendingOnCompletionActions = new HashSet();
        this.enabledMediaSourceHolders = new HashSet();
        this.isAtomic = z11;
        this.useLazyPreparation = z12;
        addMediaSources(Arrays.asList(mediaSourceArr));
    }

    public synchronized MediaSource removeMediaSource(int i11, Handler handler, Runnable runnable) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(i11);
        removePublicMediaSources(i11, i11 + 1, handler, runnable);
        return mediaSource;
    }

    public synchronized void addMediaSource(int i11, MediaSource mediaSource) {
        addPublicMediaSources(i11, Collections.singletonList(mediaSource), (Handler) null, (Runnable) null);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        addPublicMediaSources(this.mediaSourcesPublic.size(), collection, handler, runnable);
    }

    public synchronized void addMediaSources(int i11, Collection<MediaSource> collection) {
        addPublicMediaSources(i11, collection, (Handler) null, (Runnable) null);
    }

    public synchronized void addMediaSource(int i11, MediaSource mediaSource, Handler handler, Runnable runnable) {
        addPublicMediaSources(i11, Collections.singletonList(mediaSource), handler, runnable);
    }

    public synchronized void addMediaSources(int i11, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        addPublicMediaSources(i11, collection, handler, runnable);
    }
}
