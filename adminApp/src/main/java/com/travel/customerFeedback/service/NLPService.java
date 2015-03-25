package com.travel.customerFeedback.service;

import java.util.Properties;

import org.apache.log4j.Category;
import org.springframework.stereotype.Service;

import com.travel.customerFeedback.controller.FeedbackController;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

@Service
public class NLPService {
	private Properties props;
	private String[] sentimentText;
	private static final Category LOGGER = Category
			.getInstance(FeedbackController.class);

	
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
		 LOGGER.info("The score for text is "+line+" "+(sentimentText[score]));
	}
		   }

	}*/
	
	public String getFeedbackType(String description){
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		int score =0;
		 if (description != null && description.length() > 0) {
	           int longest = 0;
	           edu.stanford.nlp.pipeline.Annotation annotation = pipeline.process(description);
		for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
		 Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
		  score = RNNCoreAnnotations.getPredictedClass(tree);
		 LOGGER.info("The score for text is "+description+" "+(sentimentText[score]));
	}
		   }
		return sentimentText[score];
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public String[] getSentimentText() {
		return sentimentText;
	}

	public void setSentimentText(String[] sentimentText) {
		this.sentimentText = sentimentText;
	}

}
