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
package life.thehoard.thirdparty.api.fanarttv.endpoints;

import life.thehoard.thirdparty.api.fanarttv.http.GenericJson;

/**
 * Generic image response for most image responses from Fanart.TV This includes
 * the ID of the image, the URL to the image, and the number of likes
 * 
 * @author Michael Haas
 *
 */
public class GenericImageResponse extends GenericJson {
	/**
	 * ID of the image
	 */
	private Integer id;

	/**
	 * URL to the image
	 */
	private String url;

	/**
	 * Number of likes the image has
	 */
	private Integer likes;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	protected GenericImageResponse setId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	protected GenericImageResponse setUrl(String url) {
		this.url = url;
		return this;
	}

	/**
	 * @return the likes
	 */
	public Integer getLikes() {
		return likes;
	}

	/**
	 * @param likes
	 *            the likes to set
	 */
	protected GenericImageResponse setLikes(Integer likes) {
		this.likes = likes;
		return this;
	}
}