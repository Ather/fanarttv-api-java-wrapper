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
package media.thehoard.thirdparty.api.fanarttv.endpoints.music;

import java.util.Map;

import media.thehoard.thirdparty.api.fanarttv.http.GenericJson;

/**
 * Album object for Gson returned from the Fanart.TV API
 * @author Michael Haas
 *
 */
public class Album extends GenericJson {
	/**
	 * Name of the album
	 */
	private String name;
	
	/**
	 * MusicBrainz UUID of the album
	 */
	private String mbid_id;
	
	/**
	 * Map of album image objects with the MusicBrainz UUID as the key
	 */
	private Map<String, AlbumItem> albums;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	protected Album setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return the mbid_id
	 */
	public String getMusicBrainzId() {
		return mbid_id;
	}

	/**
	 * @param mbid_id the mbid_id to set
	 */
	protected Album setMusicBrainzId(String mbid_id) {
		this.mbid_id = mbid_id;
		return this;
	}

	/**
	 * @return the albums
	 */
	public Map<String, AlbumItem> getAlbums() {
		return albums;
	}

	/**
	 * @param albums the albums to set
	 */
	protected Album setAlbums(Map<String, AlbumItem> albums) {
		this.albums = albums;
		return this;
	}
}
