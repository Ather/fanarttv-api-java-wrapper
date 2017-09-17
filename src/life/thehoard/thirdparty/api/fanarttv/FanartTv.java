package life.thehoard.thirdparty.api.fanarttv;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import life.thehoard.thirdparty.api.fanarttv.http.FanartTvRequest;
import life.thehoard.thirdparty.api.fanarttv.http.RequestMethod;

/**
 * 
 * Java API Wrapper for <a href="https://fanart.tv">Fanart.TV</a>
 * <br>
 * API Docs available here: <a href="http://docs.fanarttv.apiary.io/">http://docs.fanarttv.apiary.io/</a>
 * 
 * @author Michael Haas
 * @since The Hoard Media Server - 0.3.6.45
 */
public class FanartTv {
	/**
	 * Default API URL root and service URL
	 */
	private static final String DEFAULT_ROOT_URL = "http://webservice.fanart.tv";
	private static final String DEFAULT_SERVICE_URL = "/v3/";
	
	/**
	 * Default complete API URL
	 */
	private static final String DEFAULT_API_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_URL;
	
	/*
	 * Root URL for the API
	 */
	private String apiUrl;

	/*
	 * API Key to be used for requests
	 */
	private String apiKey;

	/**
	 * Create a new FanartTV Client with a given API URL and Key
	 * 
	 * @param apiUrl
	 * @param apiKey
	 */
	public FanartTv(String apiUrl, String apiKey) {
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
	}
	
	/**
	 * Create a new FanartTV Client using the default API URL and the supplied apiKey
	 * @param apiKey API Key to use in the client
	 */
	public FanartTv(String apiKey) {
		this(DEFAULT_API_URL, apiKey);
	}

	/**
	 * Create a new FanartTV Client using the default API URL.
	 * This requires the use of the {@link #setApiKey(String)} method
	 */
	public FanartTv() {
		this(DEFAULT_API_URL, "");
	}

	/**
	 * 
	 * @return Movie related resources of the fanart.tv API
	 */
	public Movies movies() {
		return new Movies();
	}

	/**
	 * Movie related resources of the fanart.tv API
	 * 
	 * @author Michael Haas
	 *
	 */
	public class Movies {
		/**
		 * Get a movie resource based on an IMDb ID
		 * 
		 * @param imdb_id
		 *            IMDb ID of a Movie
		 * @return Get request for movie resource
		 */
		public Get get(String imdb_id) {
			return new Get(imdb_id);
		}

		/**
		 * Get a movie resource based on a TMDb ID
		 * 
		 * @param tmdb_id
		 *            TMDb ID of a Movie
		 * @return Get request for movie resource
		 */
		public Get get(int tmdb_id) {
			return new Get(tmdb_id);
		}

		/**
		 * Get request for movie resources
		 * 
		 * @author Michael Haas
		 *
		 */
		public class Get extends FanartTvRequest<Object, life.thehoard.thirdparty.api.fanarttv.endpoints.movie.Movie> {
			/**
			 * Construct a get request based on an IMDb ID
			 * 
			 * @param imdb_id
			 *            IMDb ID of a Movie
			 */
			protected Get(String imdb_id) {
				super(FanartTv.this, RequestMethod.GET, "movies/" + imdb_id, life.thehoard.thirdparty.api.fanarttv.endpoints.movie.Movie.class);
			}

			/**
			 * Construct a get request based on a TMDd ID This simply converts the integer
			 * ID into a String and passes it to the IMDd constructor.
			 * 
			 * @param tmdb_id
			 *            TMDb ID of a Movie
			 */
			protected Get(int tmdb_id) {
				this(String.valueOf(tmdb_id));
			}
		}

		/**
		 * 
		 * @return Latest movies resource handler
		 */
		public Latest latest() {
			return new Latest();
		}

		/**
		 * Latest movies resource handler
		 * 
		 * @author Michael Haas
		 *
		 */
		public class Latest {
			/**
			 * Create a Get request for the latest movie updates after a given date
			 * 
			 * @param dateFrom
			 *            Form a get request for updates after this date
			 * @return Get request for latest movies
			 */
			public Get get(Date dateFrom) {
				return new Get(dateFrom);
			}

			/**
			 * Create a Get request for the latest movie updates after a given date
			 * 
			 * @param dateFrom
			 *            Form a get request for updates after this date as a UNIX time
			 *            stamp
			 * @return Get request for latest movies
			 */
			public Get get(Long dateFrom) {
				return new Get(new Date(dateFrom));
			}

			/**
			 * Create a Get request for the latest movie updates
			 * 
			 * @return Get request for latest movies
			 */
			public Get get() {
				return new Get();
			}

			/**
			 * Get request for a list of the latest changes to Movie resources
			 * 
			 * @author Michael Haas
			 *
			 */
			public class Get extends FanartTvRequest<Object, java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.movie.LatestMovie>> {
				/**
				 * Create a Get request for the latest movie updates after a given date
				 * 
				 * @param dateFrom
				 */
				protected Get(Date dateFrom) {
					super(FanartTv.this, RequestMethod.GET, "movies/latest/" + dateFrom.getTime(),
							new TypeToken<java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.movie.LatestMovie>>() {
							}.getType());
				}

				/**
				 * Create a Get request for the latest movie updates after a given date
				 * 
				 * @param dateFrom
				 *            Form a get request for updates after this date as a UNIX time
				 *            stamp
				 */
				protected Get() {
					super(FanartTv.this, RequestMethod.GET, "movies/latest",
							new TypeToken<java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.movie.LatestMovie>>() {
							}.getType());
				}

				/**
				 * Add a date parameter to the Get request
				 * 
				 * @param dateFrom
				 *            Date from as a Date object
				 */
				public void addDateFrom(Date dateFrom) {
					super.addParameter("date", String.valueOf(dateFrom.getTime()));
				}

				/**
				 * Add a date parameter to the Get request
				 * 
				 * @param dateFrom
				 *            Date from as a UNIX time stamp
				 */
				public void addDateFrom(Long dateFrom) {
					addDateFrom(new Date(dateFrom));
				}
			}
		}
	}

	/**
	 * 
	 * @return Music related resources of the fanart.tv API
	 */
	public Music music() {
		return new Music();
	}

	/**
	 * Music related resources of the fanart.tv API
	 * 
	 * @author Michael Haas
	 *
	 */
	public class Music {
		/**
		 * 
		 * @return Artist related resources
		 */
		public Artists artists() {
			return new Artists();
		}

		/**
		 * Artist related resources
		 * 
		 * @author Michael Haas
		 *
		 */
		public class Artists {
			/**
			 * Create a Get request for an artist based on their MusicBrainz ID
			 * 
			 * @param musicbrainz_id
			 *            UUID used on MusicBrainz for the artist
			 * @return Get request for an artist
			 */
			public Get get(String musicbrainz_id) {
				return new Get(musicbrainz_id);
			}

			/**
			 * Get request for a MusicBrainz artist
			 * 
			 * @author Michael Haas
			 *
			 */
			public class Get extends FanartTvRequest<Object, life.thehoard.thirdparty.api.fanarttv.endpoints.music.Artist> {
				protected Get(String musicbrainz_id) {
					super(FanartTv.this, RequestMethod.GET, "music/" + musicbrainz_id, life.thehoard.thirdparty.api.fanarttv.endpoints.music.Artist.class);
				}
			}
		}

		/**
		 * 
		 * @return Album related resources
		 */
		public Albums albums() {
			return new Albums();
		}

		/**
		 * Album related resources
		 * 
		 * @author Michael Haas
		 *
		 */
		public class Albums {
			/**
			 * Create a Get request for an album based on the MusicBrainz release group ID
			 * 
			 * @param musicbrainz_releasegroup_id
			 *            Release group ID used on MusicBrainz
			 * @return Get request for an album
			 */
			public Get get(String musicbrainz_releasegroup_id) {
				return new Get(musicbrainz_releasegroup_id);
			}

			/**
			 * Get request for an album
			 * 
			 * @author Michael Haas
			 *
			 */
			public class Get extends FanartTvRequest<Object, life.thehoard.thirdparty.api.fanarttv.endpoints.music.Album> {
				/**
				 * Create a Get request for an album based on the MusicBrainz release group ID
				 * 
				 * @param musicbrainz_releasegroup_id
				 *            Release group ID used on MusicBrainz
				 */
				protected Get(String musicbrainz_releasegroup_id) {
					super(FanartTv.this, RequestMethod.GET, "music/albums/" + musicbrainz_releasegroup_id, life.thehoard.thirdparty.api.fanarttv.endpoints.music.Album.class);
				}
			}
		}

		/**
		 * 
		 * @return Label related resources
		 */
		public Labels labels() {
			return new Labels();
		}

		/**
		 * Label related resources
		 * 
		 * @author Michael Haas
		 *
		 */
		public class Labels {
			/**
			 * Create a get request with a given MusicBrainz label ID
			 * 
			 * @param musicbrainz_label_id
			 *            Label ID from MusicBrainz
			 * @return Get request object for a given Label
			 */
			public Get get(String musicbrainz_label_id) {
				return new Get(musicbrainz_label_id);
			}

			/**
			 * Get request object for getting images from a Label
			 * 
			 * @author Michael Haas
			 *
			 */
			public class Get extends FanartTvRequest<Object, life.thehoard.thirdparty.api.fanarttv.endpoints.music.Label> {
				/**
				 * Create a get request with a given MusicBrainz label ID
				 * 
				 * @param musicbrainz_label_id
				 *            Label ID from MusicBrainz
				 */
				protected Get(String musicbrainz_label_id) {
					super(FanartTv.this, RequestMethod.GET, "music/labels/" + musicbrainz_label_id, life.thehoard.thirdparty.api.fanarttv.endpoints.music.Label.class);
				}
			}
		}

		/**
		 * 
		 * @return Resources related to the latest artists
		 */
		public Latest latest() {
			return new Latest();
		}

		/**
		 * Resources related to the latest artists
		 * 
		 * @author Michael Haas
		 *
		 */
		public class Latest {
			/**
			 * Create a Get request for the latest music artist updates after a given date
			 * 
			 * @param dateFrom
			 *            Form a get request for updates after this date
			 * @return Get request for latest artists
			 */
			public Get get(Date dateFrom) {
				return new Get(dateFrom);
			}

			/**
			 * Create a Get request for the latest music artist updates after a given date
			 * 
			 * @param dateFrom
			 *            Form a get request for updates after this date in UNIX time
			 * @return Get request for latest artists
			 */
			public Get get(Long dateFrom) {
				return new Get(new Date(dateFrom));
			}

			/**
			 * Create a Get request for the latest music artists
			 * 
			 * @return Get request for the latest artists
			 */
			public Get get() {
				return new Get();
			}

			/**
			 * Get request for a list of updates to artists
			 * 
			 * @author Michael Haas
			 *
			 */
			public class Get extends FanartTvRequest<Object, java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.music.LatestArtist>> {
				/**
				 * Create a Get request for the latest music artist updates after a given Date
				 * 
				 * @param dateFrom
				 */
				protected Get(Date dateFrom) {
					super(FanartTv.this, RequestMethod.GET, "music/latest/" + dateFrom.getTime(),
							new TypeToken<java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.music.LatestArtist>>() {
							}.getType());
				}

				/**
				 * Create a Get request for the latest music artist updates
				 */
				protected Get() {
					super(FanartTv.this, RequestMethod.GET, "music/latest",
							new TypeToken<java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.music.LatestArtist>>() {
							}.getType());
				}

				/**
				 * Add the dateFrom parameter to the request
				 * 
				 * @param dateFrom
				 *            Date after which to show updates
				 */
				public void addDateFrom(Date dateFrom) {
					super.addParameter("date", String.valueOf(dateFrom.getTime()));
				}

				/**
				 * Add the date From parameter to the request
				 * 
				 * @param dateFrom
				 *            Date after which to show updates as a UNIX time stamp
				 */
				public void addDateFrom(Long dateFrom) {
					addDateFrom(new Date(dateFrom));
				}
			}
		}
	}

	/**
	 * 
	 * @return TV related resources of the fanart.tv API
	 */
	public TV tv() {
		return new TV();
	}

	/**
	 * TV related resources of the fanart.tv API
	 * 
	 * @author Michael Haas
	 *
	 */
	public class TV {
		/**
		 * Create a Get request for a TV show based on TheTVDB ID
		 * 
		 * @param thetvdb_id
		 *            TheTVDB ID for a TV Show
		 * @return Get request for a TV show
		 */
		public Get get(int thetvdb_id) {
			return new Get(thetvdb_id);
		}

		/**
		 * Get request for a specific TV Show
		 * 
		 * @author Michael Haas
		 *
		 */
		public class Get extends FanartTvRequest<Object, life.thehoard.thirdparty.api.fanarttv.endpoints.tv.TV> {
			/**
			 * Create a Get request based on an ID From TheTVDB
			 * 
			 * @param thetvdb_id
			 */
			protected Get(int thetvdb_id) {
				super(FanartTv.this, RequestMethod.GET, "tv/" + thetvdb_id, life.thehoard.thirdparty.api.fanarttv.endpoints.tv.TV.class);
			}
		}

		/**
		 * 
		 * @return Resources related to the most recent updates for TV Shows
		 */
		public Latest latest() {
			return new Latest();
		}

		/**
		 * Resources related to the most recent updates for TV Shows
		 * 
		 * @author Michael Haas
		 *
		 */
		public class Latest {
			/**
			 * Create a Get request from a certain date for TV Show updates
			 * 
			 * @param dateFrom
			 *            Date object from which to return TV Show updates
			 * @return Get request for TV Show updates based on the given date
			 */
			public Get get(Date dateFrom) {
				return new Get(dateFrom);
			}

			/**
			 * Create a Get request from a certain date for TV Show updates
			 * 
			 * @param dateFrom
			 *            UNIX time stamp from which to return TV Show updates
			 * @return Get request for TV Show updates based on the given date
			 */
			public Get get(Long dateFrom) {
				return new Get(new Date(dateFrom));
			}

			/**
			 * Create a Get request for TV Show updates
			 * 
			 * @return Get request for TV Show updates
			 */
			public Get get() {
				return new Get();
			}

			/**
			 * Get request which returns a list of updates for TV Shows
			 * 
			 * @author Michael Haas
			 *
			 */
			public class Get extends FanartTvRequest<Object, java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.tv.LatestTV>> {
				/**
				 * Create a Get request for TV show updates based on a Date object
				 * 
				 * @param dateFrom
				 *            Date object from which to request TV Show updates
				 */
				protected Get(Date dateFrom) {
					super(FanartTv.this, RequestMethod.GET, "tv/latest/" + dateFrom.getTime(),
							new TypeToken<java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.tv.LatestTV>>() {
							}.getType());
				}

				/**
				 * Create a Get request for TV show updates
				 */
				protected Get() {
					super(FanartTv.this, RequestMethod.GET, "tv/latest", new TypeToken<java.util.List<life.thehoard.thirdparty.api.fanarttv.endpoints.tv.LatestTV>>() {
					}.getType());
				}

				/**
				 * Add the dateFrom parameter to the request
				 * 
				 * @param dateFrom
				 *            Date after which to show updates
				 */
				public void addDateFrom(Date dateFrom) {
					super.addParameter("date", String.valueOf(dateFrom.getTime()));
				}

				/**
				 * Add the dateFrom parameter to the request
				 * 
				 * @param dateFrom
				 *            Date after which to show updates as a UNIX time stamp
				 */
				public void addDateFrom(Long dateFrom) {
					addDateFrom(new Date(dateFrom));
				}
			}
		}
	}

	/**
	 * 
	 * @return The Root API URL
	 */
	public String getApiUrl() {
		return this.apiUrl;
	}
	
	/**
	 * Set the API URL
	 * @param apiUrl API URL to use for Fanart.TV
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	/**
	 * 
	 * @return The API Key
	 */
	public String getApiKey() {
		return this.apiKey;
	}
	
	/**
	 * Set the API Key
	 * @param apiKey API Key to use
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * 
	 * @return Gson serializer/deserializer used for the Fanart.TV client.
	 */
	public static Gson getGson() {
		return new GsonBuilder().create();
	}
}
