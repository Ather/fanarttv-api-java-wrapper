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
package media.thehoard.thirdparty.api.fanarttv.endpoints;

import media.thehoard.thirdparty.api.fanarttv.http.GenericJson;

/**
 * Generic Latest object response This is extended to add IDs based on the
 * object type, such as IMDb, TMDb, TheTVDB, or MusicBrainz IDs
 * 
 * @author Michael Haas
 *
 */
public class Latest extends GenericJson {
	/**
	 * Name of the object the response concerns. This is normally a TV show name,
	 * Movie name, or Artist name
	 */
	private String name;

	/**
	 * Number of new images added in the update
	 */
	private Integer new_images;

	/**
	 * Number of total images for the given object after the update
	 */
	private Integer total_images;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	protected Latest setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the new_images
	 */
	public Integer getNewImages() {
		return new_images;
	}

	/**
	 * @param new_images
	 *            the new_images to set
	 */
	protected Latest setNewImages(Integer new_images) {
		this.new_images = new_images;
		return this;
	}

	/**
	 * @return the total_images
	 */
	public Integer getTotalImages() {
		return total_images;
	}

	/**
	 * @param total_images
	 *            the total_images to set
	 */
	protected Latest setTotalImages(Integer total_images) {
		this.total_images = total_images;
		return this;
	}
}
