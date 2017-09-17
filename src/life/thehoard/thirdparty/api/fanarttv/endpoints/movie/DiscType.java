/**
 * 
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints.movie;

import com.google.gson.annotations.SerializedName;

/**
 * Possible disc image types for movies
 * @author Michael Haas
 *
 */
public enum DiscType {
	bluray,
	dvd,
	@SerializedName("3d")
	ThreeD
}
