/**
 * 
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints.tv;

import life.thehoard.thirdparty.api.fanarttv.endpoints.Latest;

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
