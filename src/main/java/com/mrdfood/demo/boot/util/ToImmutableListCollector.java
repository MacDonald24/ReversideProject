package com.mrdfood.demo.boot.util;

import com.google.common.collect.ImmutableList;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Implementation of a Collector able to collect to a guava {@link ImmutableList}.
 *
 * @param <T> type of elements in the list
 */
public class ToImmutableListCollector<T> implements Collector<T, List<T>, ImmutableList<T>> {

    private ToImmutableListCollector() {
    }

    public static <T> ToImmutableListCollector<T> toImmutableList() {
        return new ToImmutableListCollector<T>();
    }

    @Override
    public Supplier<List<T>> supplier() {
        return () -> new ArrayList<>();
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, item) -> list.add(item);
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, ImmutableList<T>> finisher() {
        return list -> ImmutableList.copyOf(list);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.CONCURRENT));
    }
}
