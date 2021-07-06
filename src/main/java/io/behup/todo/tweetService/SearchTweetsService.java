package io.behup.todo.tweetService;

import java.io.IOException;
import java.util.List;

import twitter4j.Status;

public interface SearchTweetsService {
	public List<Status> searchTweets(String word) ;
}
