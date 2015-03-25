package com.travel.customerFeedback;

import java.util.Properties;

import org.apache.log4j.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.travel.customerFeedback.service.NLPService;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
public class Application extends WebMvcConfigurerAdapter {
	private static final Category LOGGER = Category
			.getInstance(Application.class);
//private static String currentVersion="5.0";
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(
				Application.class, args);
		LOGGER.info("Setting up the NLP properties");

		NLPService nlpService=context.getBean(NLPService.class);
		Properties props = new Properties();
		nlpService.setProps(props);
		props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
		String[] sentimentText = { "Very Negative","Negative", "Neutral", "Positive", "Very Positive"};
		nlpService.setSentimentText(sentimentText);
		LOGGER.info("Application started");
	
	
	}
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	       // registry.addViewController("/pingSample").setViewName("sample");
	       
	    }

	
	
	
}
