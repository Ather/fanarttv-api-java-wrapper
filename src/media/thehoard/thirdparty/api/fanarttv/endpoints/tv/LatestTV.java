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

import media.thehoard.thirdparty.api.fanarttv.endpoints.Latest;

/**
 * Latest TV object used for Gson. This extends the standard Latest object and
 * adds TheTVDB ID
 * 
 * @author Michael Haas
 *
 */
public class LatestTV extends Latest {
	/**
	 * TheTVDB ID of the TV Show
	 */
	private Integer id;

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
	protected LatestTV setId(Integer id) {
		this.id = id;
		return this;
	}
}
