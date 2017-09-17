/**
 * 
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