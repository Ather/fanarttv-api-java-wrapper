/**
 * 
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints;

import life.thehoard.thirdparty.api.fanarttv.util.Language;

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
