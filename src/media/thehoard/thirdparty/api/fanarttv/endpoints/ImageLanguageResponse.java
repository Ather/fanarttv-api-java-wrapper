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

import media.thehoard.thirdparty.api.fanarttv.util.Language;

/**
 * Generic image response with the language of the response added This is mostly
 * used for posters
 * 
 * @author Michael Haas
 *
 */
public class ImageLanguageResponse extends GenericImageResponse {
	/*
	 * Language used in the image
	 */
	private Language lang;

	/**
	 * @return the lang
	 */
	public Language getLang() {
		return lang;
	}

	/**
	 * @param lang
	 *            the lang to set
	 */
	protected ImageLanguageResponse setLang(Language lang) {
		this.lang = lang;
		return this;
	}
}
