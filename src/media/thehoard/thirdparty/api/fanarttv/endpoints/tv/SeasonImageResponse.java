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
package media.thehoard.thirdparty.api.fanarttv.endpoints.tv;

import media.thehoard.thirdparty.api.fanarttv.endpoints.ImageLanguageResponse;

/**
 * Season image response for season related images
 * 
 * @author Michael Haas
 *
 */
public class SeasonImageResponse extends ImageLanguageResponse {
	/**
	 * Season number stored as a String to support the "all" response
	 */
	private String season;

	/**
	 * @return The season number, -1 if all seasons
	 */
	public Integer getSeason() {
		if (season.equals("all"))
			return -1;
		else
			return Integer.valueOf(season);
	}

	/**
	 * Update the season number
	 * 
	 * @param seasonNumber
	 *            Integer season (-1 for "all)
	 * @return updated SeasonImageResponse
	 */
	protected SeasonImageResponse setSeason(int seasonNumber) {
		this.season = String.valueOf(seasonNumber);
		return this;
	}

	/**
	 * Update the season number
	 * 
	 * @param seasonNumber
	 *            String season ("all" for all seasons)
	 * @return updated SeasonImageResponse
	 */
	protected SeasonImageResponse setSeason(String seasonNumber) {
		this.season = seasonNumber;
		return this;
	}
}