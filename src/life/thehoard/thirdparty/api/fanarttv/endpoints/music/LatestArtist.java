/**
 * 
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints.music;

import life.thehoard.thirdparty.api.fanarttv.endpoints.Latest;

/**
 * Latest artist object used for music, adding the UUID from MusicBrainz
 * 
 * @author Michael Haas
 *
 */
public class LatestArtist extends Latest {
	/**
	 * MusicBrainz UUID of the artist that was updated
	 */
	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	protected LatestArtist setId(String id) {
		this.id = id;
		return this;
	}
}
