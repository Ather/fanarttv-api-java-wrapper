/**
 * 
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints.movie;

import life.thehoard.thirdparty.api.fanarttv.endpoints.Latest;

/**
 * Latest movie object used for Gson. This extends the standard Latest object
 * and adds the TMDb and IMDb IDs
 * 
 * @author Michael Haas
 *
 */
public class LatestMovie extends Latest {
	/**
	 * Movie ID on TMDb
	 */
	private Integer tmdb_id;

	/**
	 * Movie ID on IMDb
	 */
	private String imdb_id;

	/**
	 * @return the tmdb_id
	 */
	public Integer getTMDbId() {
		return tmdb_id;
	}

	/**
	 * @param tmdb_id
	 *            the tmdb_id to set
	 */
	protected LatestMovie setTMDbId(Integer tmdb_id) {
		this.tmdb_id = tmdb_id;
		return this;
	}

	/**
	 * @return the imdb_id
	 */
	public String getIMDbId() {
		return imdb_id;
	}

	/**
	 * @param imdb_id
	 *            the imdb_id to set
	 */
	protected LatestMovie setIMDbId(String imdb_id) {
		this.imdb_id = imdb_id;
		return this;
	}
}
