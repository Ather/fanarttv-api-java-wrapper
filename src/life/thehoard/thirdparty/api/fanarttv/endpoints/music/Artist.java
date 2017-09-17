/**
 * 
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints.music;

import java.util.List;
import java.util.Map;

import life.thehoard.thirdparty.api.fanarttv.endpoints.GenericImageResponse;
import life.thehoard.thirdparty.api.fanarttv.http.GenericJson;

/**
 * Artist object for Gson returned from the Fanart.TV API
 * @author Michael Haas
 *
 */
public class Artist extends GenericJson {
	/**
	 * Name of the artist
	 */
	private String name;

	/**
	 * MusicBrainz UUID of the artist
	 */
	private String mbid_id;

	/**
	 * List of artist background images
	 */
	private List<GenericImageResponse> artistbackground;

	/**
	 * List of artist thumbnails
	 */
	private List<GenericImageResponse> artistthumb;

	/**
	 * List of music logos
	 */
	private List<GenericImageResponse> musiclogo;

	/**
	 * List of HD music logos
	 */
	private List<GenericImageResponse> hdmusiclogo;

	/**
	 * Map of albums for the artist with the MusicBrainz UUID as the key
	 */
	private Map<String, AlbumItem> albums;

	/**
	 * List of music banner images
	 */
	private List<GenericImageResponse> musicbanner;

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
	protected Artist setName(String name) {
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
	 * @param mbid_id
	 *            the mbid_id to set
	 */
	protected Artist setMusicBrainzId(String mbid_id) {
		this.mbid_id = mbid_id;
		return this;
	}

	/**
	 * @return the artistbackground
	 */
	public List<GenericImageResponse> getArtistBackgrounds() {
		return artistbackground;
	}

	/**
	 * @param artistbackground
	 *            the artistbackground to set
	 */
	protected Artist setArtistBackgrounds(List<GenericImageResponse> artistbackground) {
		this.artistbackground = artistbackground;
		return this;
	}

	/**
	 * @return the artistthumb
	 */
	public List<GenericImageResponse> getArtistThumbs() {
		return artistthumb;
	}

	/**
	 * @param artistthumb
	 *            the artistthumb to set
	 */
	protected Artist setArtistThumbs(List<GenericImageResponse> artistthumb) {
		this.artistthumb = artistthumb;
		return this;
	}

	/**
	 * @return the musiclogo
	 */
	public List<GenericImageResponse> getMusicLogos() {
		return musiclogo;
	}

	/**
	 * @param musiclogo
	 *            the musiclogo to set
	 */
	protected Artist setMusicLogos(List<GenericImageResponse> musiclogo) {
		this.musiclogo = musiclogo;
		return this;
	}

	/**
	 * @return the hdmusiclogo
	 */
	public List<GenericImageResponse> getHDMusicLogos() {
		return hdmusiclogo;
	}

	/**
	 * @param hdmusiclogo
	 *            the hdmusiclogo to set
	 */
	protected Artist setHDMusicLogos(List<GenericImageResponse> hdmusiclogo) {
		this.hdmusiclogo = hdmusiclogo;
		return this;
	}

	/**
	 * @return the albums
	 */
	public Map<String, AlbumItem> getAlbums() {
		return albums;
	}

	/**
	 * @param albums
	 *            the albums to set
	 */
	protected Artist setAlbums(Map<String, AlbumItem> albums) {
		this.albums = albums;
		return this;
	}

	/**
	 * @return the musicbanner
	 */
	public List<GenericImageResponse> getMusicBanners() {
		return musicbanner;
	}

	/**
	 * @param musicbanner
	 *            the musicbanner to set
	 */
	protected Artist setMusicBanners(List<GenericImageResponse> musicbanner) {
		this.musicbanner = musicbanner;
		return this;
	}
}
