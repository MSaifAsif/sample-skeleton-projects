package com.sample.client;

import com.sample.one.mappers.WordCountMapper;
import com.sample.one.reducers.WordCountReducer;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ClientRunner extends Configured implements Tool {

    public static void main(String[] args) throws Exception {
        int rc = ToolRunner.run(new ClientRunner(), args);
        System.exit(rc);
    }

    @Override
    public int run(String[] args) throws Exception {
        Job job = new Job(getConf());
        job.setJarByClass(getClass());
        job.setJobName(getClass().getSimpleName());

        // the input file name on the HDFS
        FileInputFormat.addInputPath(job, new Path(args[0]));
        // the output file on the hdfs
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // Set the mapper name
        job.setMapperClass(WordCountMapper.class);

        // Set the combiner and the reducer classes
        job.setCombinerClass(WordCountReducer.class);
        job.setReducerClass(WordCountReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // should we wait for job completion or not
        return job.waitForCompletion(true) ? 0 : 1;
    }
}
