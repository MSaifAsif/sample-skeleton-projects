package com.sample.one.reducers;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * The {@link Reducer} class based on the <code>KEY</code> type.
 * Will patch up the individual keys and sum up their values to get the sum
 *
 * @param <KEY>
 * @author saifasif
 */
public class WordCountReducer<KEY> extends Reducer<KEY, LongWritable, KEY, LongWritable> {

    private LongWritable result = new LongWritable();

    public void reduce(KEY key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long sum = 0;
        for (LongWritable val : values) {
            sum += val.get();
        }
        result.set(sum);
        context.write(key, result);
    }

}
