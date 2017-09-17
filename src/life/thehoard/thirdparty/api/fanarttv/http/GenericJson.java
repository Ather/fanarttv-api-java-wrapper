package life.thehoard.thirdparty.api.fanarttv.http;

import life.thehoard.thirdparty.api.fanarttv.FanartTv;

public class GenericJson {
	// Add serializers to output dates in the proper formats.
	public String toJson(boolean prettyPrint) {
		return FanartTv.getGson().toJson(this);
	}
	
	public String toJson() {
		return toJson(false);
	}
}
