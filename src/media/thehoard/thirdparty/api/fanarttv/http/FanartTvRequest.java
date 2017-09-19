/*
 * Copyright 2017 Michael Haas
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package media.thehoard.thirdparty.api.fanarttv.http;

import java.io.IOException;
import java.lang.reflect.Type;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import media.thehoard.thirdparty.api.fanarttv.FanartTv;

/**
 * Generic Fanart.TV API response object
 * 
 * @author Michael Haas
 *
 * @param <ContentType>
 *            Object used in the request body
 *            Unused for Fanart.TV, but kept for future ease-of-upgrade
 * @param <ResponseType>
 *            Object used in the response body
 */
public class FanartTvRequest<ContentType, ResponseType> {
	/**
	 * Fanart.TV client being used for the request
	 */
	private FanartTv FANART_TV_CLIENT;

	/**
	 * Request method to be used in the request
	 */
	private RequestMethod requestMethod;

	/**
	 * HTTP client used for the request
	 */
	private HttpClient httpClient;

	/**
	 * Request builder to ease the process of creating the request
	 */
	private RequestBuilder requestBuilder;

	/**
	 * URL to make the request to
	 */
	private String requestUrl;

	/**
	 * Request body
	 */
	protected ContentType content;

	/**
	 * Type of response expected
	 */
	private Type responseType;

	/**
	 * Create a Fanart.TV API Request
	 * @param fanartTvClient Fanart.TV API Client to use for the request
	 * @param requestMethod Request type (only GET is supported for Fanart)
	 * @param endpoint URL To the endpoint (appended to the base URL)
	 * @param content Request body (not used for Fanart.tv)
	 * @param responseType Response type to be used
	 */
	protected FanartTvRequest(FanartTv fanartTvClient, RequestMethod requestMethod, String endpoint, ContentType content, Type responseType) {
		// This is a temporary fix to a larger issue. This messes up logging, but
		// removes log4j warnings.
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

		this.FANART_TV_CLIENT = fanartTvClient;
		this.requestMethod = requestMethod;
		this.requestUrl = FANART_TV_CLIENT.getApiUrl() + endpoint;

		this.content = content;

		this.responseType = responseType;

		this.httpClient = HttpClientBuilder.create().build();

		switch (this.requestMethod) {

		/* POST, PUT, and DELETE are not supported by Fanart.TV,
		 * but this is kept for ease-of-upgrade in case this changes in the future.
		case POST:
			requestBuilder = RequestBuilder.post();
			break;
		case PUT:
			requestBuilder = RequestBuilder.put();
			break;
		case DELETE:
			requestBuilder = RequestBuilder.delete();
			break;
		*/
		case GET:
		default:
			requestBuilder = RequestBuilder.get();
			break;
		}
		;

		// Append the endpoint URL
		requestBuilder.setUri(requestUrl);

		// Add the API key to the request
		requestBuilder.addParameter("api_key", FANART_TV_CLIENT.getApiKey());
	}

	/**
	 * Create a Fanart.TV API Request
	 * @param fanartTvClient Fanart.TV API Client to use for the request
	 * @param requestMethod Request type (only GET is supported for Fanart)
	 * @param endpoint URL To the endpoint (appended to the base URL)
	 * @param responseType Response type to be used
	 */
	protected FanartTvRequest(FanartTv fanartTvClient, RequestMethod requestMethod, String endpoint, Type responseType) {
		this(fanartTvClient, requestMethod, endpoint, null, responseType);
	}

	/**
	 * @return The request builder
	 */
	public RequestBuilder getRequestBuilder() {
		return this.requestBuilder;
	}

	/**
	 * @return The content of the request (this is not useful for Fanart.TV)
	 *
	public ContentType getContent() {
		return this.content;
	}
	*/

	/**
	 * Add a parameter to the request
	 * 
	 * For Example:
	 * .addParameter("api_key", "1234")
	 * would add either ?api_key=1234 or &api_key=1234 for the query string 
	 * 
	 * @param parameterName Name of the parameter to add
	 * @param parameterValue Value of the parameter
	 */
	public void addParameter(String parameterName, String parameterValue) {
		requestBuilder.addParameter(parameterName, parameterValue);
	}

	/**
	 * Add a Gson type adapter to handle responses
	 * @param adapter
	 *
	public void addGsonTypeAdapter(RuntimeTypeAdapterFactory<?> adapter) {
		gsonBuilder.registerTypeAdapterFactory(adapter);
	}
	*/

	/**
	 * Execute the request
	 * @param responseType
	 * @return
	 * @throws IOException
	 */
	protected ResponseType execute(Type responseType) throws IOException {
		Gson gson = getGson();

		/* This would add the body to the request if necessary, but Fanart.TV does not required
		 * request bodies
		if (this.requestMethod == RequestMethod.POST || this.requestMethod == RequestMethod.PUT) {
			try {
				requestBuilder.setEntity(new StringEntity(gson.toJson(content)));
			} catch (UnsupportedEncodingException e) {
				// TODO logging
				// This shouldn't happen
				e.printStackTrace();
			}
		}
		*/

		HttpResponse response = httpClient.execute(requestBuilder.build());

		try {
			/*
			 * Get the Json response, then convert it to a Gson object
			 */
			String json = EntityUtils.toString(response.getEntity());
			ResponseType jsonResp = gson.fromJson(json, responseType);
			return jsonResp;
		} catch (JsonSyntaxException | ParseException e) {
			// TODO Logging
			System.out.println("Failed to prepare return response");
			e.printStackTrace();

			return null;
		}
	}

	public ResponseType execute() throws IOException {
		return execute(responseType);
	}

	private GsonBuilder gsonBuilder = new GsonBuilder();

	public Gson getGson() {
		return gsonBuilder.create();
	}
}
