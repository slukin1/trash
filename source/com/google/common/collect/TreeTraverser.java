package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

@GwtCompatible
@Deprecated
@Beta
public abstract class TreeTraverser<T> {

    public final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        private final Queue<T> queue;

        public BreadthFirstIterator(T t11) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.queue = arrayDeque;
            arrayDeque.add(t11);
        }

        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        public T next() {
            T remove = this.queue.remove();
            Iterables.addAll(this.queue, TreeTraverser.this.children(remove));
            return remove;
        }

        public T peek() {
            return this.queue.element();
        }
    }

    public final class PostOrderIterator extends AbstractIterator<T> {
        private final ArrayDeque<PostOrderNode<T>> stack;

        public PostOrderIterator(T t11) {
            ArrayDeque<PostOrderNode<T>> arrayDeque = new ArrayDeque<>();
            this.stack = arrayDeque;
            arrayDeque.addLast(expand(t11));
        }

        private PostOrderNode<T> expand(T t11) {
            return new PostOrderNode<>(t11, TreeTraverser.this.children(t11).iterator());
        }

        public T computeNext() {
            while (!this.stack.isEmpty()) {
                PostOrderNode last = this.stack.getLast();
                if (last.childIterator.hasNext()) {
                    this.stack.addLast(expand(last.childIterator.next()));
                } else {
                    this.stack.removeLast();
                    return last.root;
                }
            }
            return endOfData();
        }
    }

    public static final class PostOrderNode<T> {
        public final Iterator<T> childIterator;
        public final T root;

        public PostOrderNode(T t11, Iterator<T> it2) {
            this.root = Preconditions.checkNotNull(t11);
            this.childIterator = (Iterator) Preconditions.checkNotNull(it2);
        }
    }

    public final class PreOrderIterator extends UnmodifiableIterator<T> {
        private final Deque<Iterator<T>> stack;

        public PreOrderIterator(T t11) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.stack = arrayDeque;
            arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(t11)));
        }

        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        public T next() {
            Iterator last = this.stack.getLast();
            T checkNotNull = Preconditions.checkNotNull(last.next());
            if (!last.hasNext()) {
                this.stack.removeLast();
            }
            Iterator it2 = TreeTraverser.this.children(checkNotNull).iterator();
            if (it2.hasNext()) {
                this.stack.addLast(it2);
            }
            return checkNotNull;
        }
    }

    @Deprecated
    public static <T> TreeTraverser<T> using(final Function<T, ? extends Iterable<T>> function) {
        Preconditions.checkNotNull(function);
        return new TreeTraverser<T>() {
            public Iterable<T> children(T t11) {
                return (Iterable) function.apply(t11);
            }
        };
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(final T t11) {
        Preconditions.checkNotNull(t11);
        return new FluentIterable<T>() {
            public UnmodifiableIterator<T> iterator() {
                return new BreadthFirstIterator(t11);
            }
        };
    }

    public abstract Iterable<T> children(T t11);

    public UnmodifiableIterator<T> postOrderIterator(T t11) {
        return new PostOrderIterator(t11);
    }

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(final T t11) {
        Preconditions.checkNotNull(t11);
        return new FluentIterable<T>() {
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.postOrderIterator(t11);
            }
        };
    }

    public UnmodifiableIterator<T> preOrderIterator(T t11) {
        return new PreOrderIterator(t11);
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(final T t11) {
        Preconditions.checkNotNull(t11);
        return new FluentIterable<T>() {
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.preOrderIterator(t11);
            }
        };
    }
}
