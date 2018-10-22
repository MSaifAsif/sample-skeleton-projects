package com.sample.one.mappers;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * The {@link Mapper} class.
 * This will read the input file and map keys with values
 *
 * @author saifasif
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    private Text word = new Text();
    private LongWritable count = new LongWritable();

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] split = value.toString().split("\t+");
        word.set(split[0]);
        if (split.length > 2) {
            count.set(Long.parseLong(split[2]));
            context.write(word, count);
        }
    }
}
