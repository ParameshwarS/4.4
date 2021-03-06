import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 


public class AssgnMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	Text g = new Text();
	IntWritable v= new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] data = value.toString().split(",");
		int i = Integer.parseInt(data[1]);
		if(i==1){
			Gender.set(data[4]);
			context.write(g,v);
		}
	}
}