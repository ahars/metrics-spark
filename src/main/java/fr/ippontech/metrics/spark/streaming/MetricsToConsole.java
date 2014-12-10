package fr.ippontech.metrics.spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class MetricsToConsole {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf()
            .setAppName("MetricsToConsole")
            .setMaster("local[2]");

        JavaStreamingContext ssc = new JavaStreamingContext(conf, new Duration(5000));

        ssc.receiverStream(new MetricsReceiver("localhost", 9999)).print();

        ssc.start();
        ssc.awaitTermination();
    }
}
