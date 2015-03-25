package com.travel.customerFeedback.test;

import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class TestClass {
/*public static void main(String[] args) {
	String line="The Room is ok";
	Properties props = new Properties();
	props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
	StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	String[] sentimentText = { "Very Negative","Negative", "Neutral", "Positive", "Very Positive"};
	   if (line != null && line.length() > 0) {
           int longest = 0;
           edu.stanford.nlp.pipeline.Annotation annotation = pipeline.process(line);
	for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
	 Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
	 int score = RNNCoreAnnotations.getPredictedClass(tree);
	 System.out.println(sentimentText[score]);
}
	   }
}*/
}
