/**
 * 
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints.music;

import java.util.Map;

import life.thehoard.thirdparty.api.fanarttv.http.GenericJson;

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
