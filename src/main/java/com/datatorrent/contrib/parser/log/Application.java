/**
 * Put your copyright and license info here.
 */
package com.datatorrent.contrib.parser.log;

import org.apache.apex.malhar.lib.fs.LineByLineFileInputOperator;
import org.apache.hadoop.conf.Configuration;

import com.datatorrent.api.annotation.ApplicationAnnotation;
import com.datatorrent.api.StreamingApplication;
import com.datatorrent.api.DAG;
import com.datatorrent.api.DAG.Locality;
import com.datatorrent.lib.io.ConsoleOutputOperator;

@ApplicationAnnotation(name="MyFirstApplication")
public class Application implements StreamingApplication
{

  @Override
  public void populateDAG(DAG dag, Configuration conf)
  {
    // Sample DAG with 2 operators
    // Replace this code with the DAG you want to build

//    RandomNumberGenerator randomGenerator = dag.addOperator("randomGenerator", RandomNumberGenerator.class);
//    randomGenerator.setNumTuples(500);


    LineByLineFileInputOperator lineByLineFileInputOperator = dag.addOperator("randomGenerator", LineByLineFileInputOperator.class);

    lineByLineFileInputOperator.setDirectory("/home/synerzip/log_test/te.erl");

    LogParser parser=dag.addOperator("parser",LogParser.class);

    //dag.addStream("log", lineByLineFileInputOperator.output,parser.inputPort ).setLocality(Locality.CONTAINER_LOCAL);

    ConsoleOutputOperator cons = dag.addOperator("console", new ConsoleOutputOperator());

    dag.addStream("parser",parser.outputPort , cons.input).setLocality(Locality.CONTAINER_LOCAL);
  }
}
