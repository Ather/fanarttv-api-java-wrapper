/**
 * 
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints.music;

import java.util.List;

import life.thehoard.thirdparty.api.fanarttv.endpoints.GenericImageResponse;
import life.thehoard.thirdparty.api.fanarttv.http.GenericJson;

/**
 * Label object for Gson returned from the Fanart.TV API
 * 
 * @author Michael Haas
 *
 */
public class Label extends GenericJson {
	/**
	 * Label name
	 */
	private String name;

	/**
	 * Label UUID on MusicBrainz
	 */
	private String id;

	/**
	 * List of music label images
	 */
	private List<MusicLabel> musiclabel;

	/**
	 * Music label object used to add the Colour to a generic image response
	 * 
	 * @author Michael Haas
	 *
	 */
	public class MusicLabel extends GenericImageResponse {
		/**
		 * Colour of the music label
		 */
		private Colour colour;

		/**
		 * @return the colour
		 */
		public Colour getColour() {
			return colour;
		}

		/**
		 * @param colour
		 *            the colour to set
		 */
		protected MusicLabel setColour(Colour colour) {
			this.colour = colour;
			return this;
		}
	}

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
	protected Label setName(String name) {
		this.name = name;
		return this;
	}

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
	protected Label setId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the musiclabel
	 */
	public List<MusicLabel> getMusicLabels() {
		return musiclabel;
	}

	/**
	 * @param musiclabel
	 *            the musiclabel to set
	 */
	protected Label setMusicLabels(List<MusicLabel> musiclabel) {
		this.musiclabel = musiclabel;
		return this;
	}
}
