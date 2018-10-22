package com.sample.benchmark.suite;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class SomePublicClass {

    @Benchmark
    public double someMethodThatNeedsBenchmarking() {
        final int i = Collections.binarySearch(getList(), Math.random());
        return i * Math.random();
    }

    private List<Double> getList() {
        return DoubleStream.of(1.1231231231312, 2.12312312312, 1.1231213211111, 2.3231231213123).boxed().collect(Collectors.toList());
    }
}
