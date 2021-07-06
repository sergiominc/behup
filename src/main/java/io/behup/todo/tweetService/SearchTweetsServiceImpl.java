package io.behup.todo.tweetService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


@Service
public class SearchTweetsServiceImpl implements SearchTweetsService{



	
	public List<Status> searchTweets(String word)  {
		
	       File file = new File("twitter4j.properties");
           Properties prop = new Properties();
           if (file.exists()) {       	   
               try {
				prop.load(new FileInputStream(file));
			} catch (Exception e) {
				e.printStackTrace();
			}
           }

		  QueryResult result=null;
		  List<Status> tweets=null;
	      ConfigurationBuilder cb = new ConfigurationBuilder();
	        cb.setDebugEnabled(true)
	          .setOAuthConsumerKey(prop.getProperty("oauth.consumerKey"))
	         .setOAuthConsumerSecret(prop.getProperty("oauth.consumerSecret"))
	          .setOAuthAccessToken(prop.getProperty("oauth.accessToken"))
	        .setOAuthAccessTokenSecret(prop.getProperty("oauth.accessTokenSecret"));
	 
	        TwitterFactory tf = new TwitterFactory(cb.build());
	        Twitter twitter = tf.getInstance();        
	        try {
	            Query query = new Query(word);
                result = twitter.search(query);
                tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("Tweet de saida: @" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
	         

	        } catch (TwitterException te) {
	        	 System.out.println("Falhou na busca de tweets: " + te.getMessage());
	            return null;
	        }       
	        
	        return tweets;
	        
	}

    /**
    
     * @param args search query
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("eYdKvOAMz0SbAKOcYrU0E72AG")
         .setOAuthConsumerSecret("AJZMYG65CzxJX3bamm79F15W4tVGmurwt6lJ3Eaqj91Dxj2c1A")
          .setOAuthAccessToken("40341223-u6QrgGvQqFLQuxhaScaUYmZDlvUoy0B2vuYWVh190")
        .setOAuthAccessTokenSecret("NKj2JrlicPCZ3mGC5WIjn15bCBLIKl4OhWZKRf6X3TknW");
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();        
        try {
            Query query = new Query(args[0]);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            //System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            //System.exit(-1);
        }
    }
}