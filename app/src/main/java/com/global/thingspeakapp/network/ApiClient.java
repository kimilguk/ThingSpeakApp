package com.global.thingspeakapp.network;

import com.github.mikephil.charting.BuildConfig;
import com.global.thingspeakapp.model.Channel;
import com.global.thingspeakapp.model.ChannelFeed;

import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Updated by Kim-ilguk on 24.3.2021.
 */
public class ApiClient {

	// singleton instance of this client
	private static ThingSpeakApiInterface clientInstance;

	private static final String DEFAULT_APILOCATION = "https://api.thingspeak.com";
	private static final String ENDPOINT_CHANNELS = "channels";
	private static final String ENDPOINT_USERS = "users";
	private static final String ENDPOINT_FEEDS = "feeds";
	private static final String ENDPOINT_FIELDS = "fields";
	private static final String MARKUP = ".json";


	public static ThingSpeakApiInterface getInstance() {
		if (clientInstance == null) {
			RestAdapter restAdapter = new RestAdapter.Builder()
					.setEndpoint(DEFAULT_APILOCATION)
					.setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.BASIC : RestAdapter.LogLevel.NONE)
					//.setConverter()
					.build();

			clientInstance = restAdapter.create(ThingSpeakApiInterface.class);
		}

		return clientInstance;
	}

	public interface ThingSpeakApiInterface {

		/*
		    page (integer) Page number to retrieve (optional)
			tag (string) Name of tag to search for (optional)
			username (string) Person's username that you want to search Channels for (optional) -> must be exact

			You can also search for Channels within a certain distance of a location by including the following location parameters:
			latitude (decimal) - Latitude of location in degrees. (optional)
			longitude (decimal) - Longitude of location in degrees. (optional)
			distance (decimal) - Distance in kilometers from location. (optional)
		*/

		// Channels

		@GET("/" + ENDPOINT_CHANNELS + "/" + "public" + MARKUP)
		void getPublicChannels(@Query("page") int page, Callback<PaginatedChannelResponce> callback);

		@GET("/" + ENDPOINT_CHANNELS + "/" + "public" + MARKUP)
		void getPublicChannelsByUsername(@Query("page") int page, @Query("username") String username, Callback<PaginatedChannelResponce> callback);

		@GET("/" + ENDPOINT_CHANNELS + "/" + "public" + MARKUP)
		void getPublicChannelsByTag(@Query("page") int page, @Query("tag") String tag, Callback<PaginatedChannelResponce> callback);

		@GET("/" + ENDPOINT_CHANNELS + "/" + "{id}" + MARKUP)
		void getChannel(@Path("id") int id, @Query("api_key") String apiKey, Callback<Channel> callback);

		// Channel Feeds

		@GET("/" + ENDPOINT_CHANNELS + "/" +"{id}" +"/" + ENDPOINT_FEEDS + MARKUP)
		void getChannelFeed(@Path("id") int id, @Query("api_key") String apiKey, @QueryMap Map<String, String> parameters, Callback<ChannelFeed> callback);

		// Channel Field Feed

		@GET("/" + ENDPOINT_CHANNELS + "/" + "{channelId}" + "/" + ENDPOINT_FIELDS + "/" + "{fieldId}" + MARKUP)
		void getChannelFieldFeed(@Path("channelId") int channelId, @Path("fieldId") int fieldId, @Query("api_key") String apiKey, @QueryMap Map<String, String> parameters, Callback<ChannelFeed> callback);

		// User


	}
}
