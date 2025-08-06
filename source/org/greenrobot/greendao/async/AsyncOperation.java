package org.greenrobot.greendao.async;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.database.Database;

public class AsyncOperation {
    public static final int FLAG_MERGE_TX = 1;
    public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
    public static final int FLAG_TRACK_CREATOR_STACKTRACE = 4;
    private volatile boolean completed;
    public final Exception creatorStacktrace;
    public final AbstractDao<Object, Object> dao;
    private final Database database;
    public final int flags;
    public volatile int mergedOperationsCount;
    public final Object parameter;
    public volatile Object result;
    public int sequenceNumber;
    public volatile Throwable throwable;
    public volatile long timeCompleted;
    public volatile long timeStarted;
    public final OperationType type;

    public enum OperationType {
        Insert,
        InsertInTxIterable,
        InsertInTxArray,
        InsertOrReplace,
        InsertOrReplaceInTxIterable,
        InsertOrReplaceInTxArray,
        Update,
        UpdateInTxIterable,
        UpdateInTxArray,
        Delete,
        DeleteInTxIterable,
        DeleteInTxArray,
        DeleteByKey,
        DeleteAll,
        TransactionRunnable,
        TransactionCallable,
        QueryList,
        QueryUnique,
        Load,
        LoadAll,
        Count,
        Refresh
    }

    public AsyncOperation(OperationType operationType, AbstractDao<?, ?> abstractDao, Database database2, Object obj, int i11) {
        this.type = operationType;
        this.flags = i11;
        this.dao = abstractDao;
        this.database = database2;
        this.parameter = obj;
        this.creatorStacktrace = (i11 & 4) != 0 ? new Exception("AsyncOperation was created here") : null;
    }

    public Exception getCreatorStacktrace() {
        return this.creatorStacktrace;
    }

    public Database getDatabase() {
        Database database2 = this.database;
        return database2 != null ? database2 : this.dao.getDatabase();
    }

    public long getDuration() {
        if (this.timeCompleted != 0) {
            return this.timeCompleted - this.timeStarted;
        }
        throw new DaoException("This operation did not yet complete");
    }

    public int getMergedOperationsCount() {
        return this.mergedOperationsCount;
    }

    public Object getParameter() {
        return this.parameter;
    }

    public synchronized Object getResult() {
        if (!this.completed) {
            waitForCompletion();
        }
        if (this.throwable == null) {
        } else {
            throw new AsyncDaoException(this, this.throwable);
        }
        return this.result;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public long getTimeCompleted() {
        return this.timeCompleted;
    }

    public long getTimeStarted() {
        return this.timeStarted;
    }

    public OperationType getType() {
        return this.type;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean isCompletedSucessfully() {
        return this.completed && this.throwable == null;
    }

    public boolean isFailed() {
        return this.throwable != null;
    }

    public boolean isMergeTx() {
        return (this.flags & 1) != 0;
    }

    public boolean isMergeableWith(AsyncOperation asyncOperation) {
        return asyncOperation != null && isMergeTx() && asyncOperation.isMergeTx() && getDatabase() == asyncOperation.getDatabase();
    }

    public void reset() {
        this.timeStarted = 0;
        this.timeCompleted = 0;
        this.completed = false;
        this.throwable = null;
        this.result = null;
        this.mergedOperationsCount = 0;
    }

    public synchronized void setCompleted() {
        this.completed = true;
        notifyAll();
    }

    public void setThrowable(Throwable th2) {
        this.throwable = th2;
    }

    public synchronized Object waitForCompletion() {
        while (!this.completed) {
            try {
                wait();
            } catch (InterruptedException e11) {
                throw new DaoException("Interrupted while waiting for operation to complete", e11);
            }
        }
        return this.result;
    }

    public synchronized boolean waitForCompletion(int i11) {
        if (!this.completed) {
            try {
                wait((long) i11);
            } catch (InterruptedException e11) {
                throw new DaoException("Interrupted while waiting for operation to complete", e11);
            }
        }
        return this.completed;
    }
}
