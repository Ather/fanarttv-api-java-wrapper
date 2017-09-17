/*
 * Copyright 2017 Michael Haas
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package life.thehoard.thirdparty.api.fanarttv.endpoints.movie;

import java.util.List;

import life.thehoard.thirdparty.api.fanarttv.endpoints.ImageLanguageResponse;
import life.thehoard.thirdparty.api.fanarttv.http.GenericJson;

/**
 * Movie object for Gson returned from the Fanart.TV API
 * 
 * @author Michael Haas
 *
 */
public class Movie extends GenericJson {
	/**
	 * Name of the movie
	 */
	private String name;

	/**
	 * TMDb ID of the movie
	 */
	private Integer tmdb_id;

	/**
	 * IMDb ID of the movie
	 */
	private String imdb_id;

	/**
	 * List of HD movie logos
	 */
	private List<ImageLanguageResponse> hdmovielogo;

	/**
	 * List of movie disc images
	 */
	private List<MovieDisc> moviedisc;

	/**
	 * Movie disc object extending the standard movie image response This adds the
	 * disc number and disc type to the response
	 * 
	 * @author Michael Haas
	 *
	 */
	public class MovieDisc extends ImageLanguageResponse {
		/**
		 * Disc number
		 */
		private Integer disc;

		/**
		 * Disc type
		 */
		private DiscType disc_type;

		/**
		 * @return the disc
		 */
		public Integer getDisc() {
			return disc;
		}

		/**
		 * @param disc
		 *            the disc to set
		 */
		protected MovieDisc setDisc(Integer disc) {
			this.disc = disc;
			return this;
		}

		/**
		 * @return the disc_type
		 */
		public DiscType getDiscType() {
			return disc_type;
		}

		/**
		 * @param disc_type
		 *            the disc_type to set
		 */
		protected MovieDisc setDiscType(DiscType disc_type) {
			this.disc_type = disc_type;
			return this;
		}
	}

	/**
	 * List of movie logos
	 */
	private List<ImageLanguageResponse> movielogo;

	/**
	 * List of movie posters
	 */
	private List<ImageLanguageResponse> movieposter;

	/**
	 * List of HD movie clear art images
	 */
	private List<ImageLanguageResponse> hdmovieclearart;

	/**
	 * List of movie art images
	 */
	private List<ImageLanguageResponse> movieart;

	/**
	 * List of movie backgrounds
	 */
	private List<ImageLanguageResponse> moviebackground;

	/**
	 * List of movie banners
	 */
	private List<ImageLanguageResponse> moviebanner;

	/**
	 * List of movie thumbnails
	 */
	private List<ImageLanguageResponse> moviethumb;

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
	protected Movie setName(String name) {
		this.name = name;
		return this;
	}

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
	protected Movie setTMDbId(Integer tmdb_id) {
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
	protected Movie setIMDbId(String imdb_id) {
		this.imdb_id = imdb_id;
		return this;
	}

	/**
	 * @return the hdmovielogo
	 */
	public List<ImageLanguageResponse> getHDMovieLogos() {
		return hdmovielogo;
	}

	/**
	 * @param hdmovielogo
	 *            the hdmovielogo to set
	 */
	protected Movie setHDMovieLogos(List<ImageLanguageResponse> hdmovielogo) {
		this.hdmovielogo = hdmovielogo;
		return this;
	}

	/**
	 * @return the moviedisc
	 */
	public List<MovieDisc> getMovieDiscs() {
		return moviedisc;
	}

	/**
	 * @param moviedisc
	 *            the moviedisc to set
	 */
	protected Movie setMovieDiscs(List<MovieDisc> moviedisc) {
		this.moviedisc = moviedisc;
		return this;
	}

	/**
	 * @return the movielogo
	 */
	public List<ImageLanguageResponse> getMovieLogos() {
		return movielogo;
	}

	/**
	 * @param movielogo
	 *            the movielogo to set
	 */
	protected Movie setMovieLogos(List<ImageLanguageResponse> movielogo) {
		this.movielogo = movielogo;
		return this;
	}

	/**
	 * @return the movieposter
	 */
	public List<ImageLanguageResponse> getMoviePosters() {
		return movieposter;
	}

	/**
	 * @param movieposter
	 *            the movieposter to set
	 */
	protected Movie setMoviePosters(List<ImageLanguageResponse> movieposter) {
		this.movieposter = movieposter;
		return this;
	}

	/**
	 * @return the hdmovieclearart
	 */
	public List<ImageLanguageResponse> getHDMovieClearArt() {
		return hdmovieclearart;
	}

	/**
	 * @param hdmovieclearart
	 *            the hdmovieclearart to set
	 */
	protected Movie setHDMovieClearArt(List<ImageLanguageResponse> hdmovieclearart) {
		this.hdmovieclearart = hdmovieclearart;
		return this;
	}

	/**
	 * @return the movieart
	 */
	public List<ImageLanguageResponse> getMovieArt() {
		return movieart;
	}

	/**
	 * @param movieart
	 *            the movieart to set
	 */
	protected Movie setMovieArt(List<ImageLanguageResponse> movieart) {
		this.movieart = movieart;
		return this;
	}

	/**
	 * @return the moviebackground
	 */
	public List<ImageLanguageResponse> getMovieBackgrounds() {
		return moviebackground;
	}

	/**
	 * @param moviebackground
	 *            the moviebackground to set
	 */
	protected Movie setMovieBackgrounds(List<ImageLanguageResponse> moviebackground) {
		this.moviebackground = moviebackground;
		return this;
	}

	/**
	 * @return the moviebanner
	 */
	public List<ImageLanguageResponse> getMovieBanners() {
		return moviebanner;
	}

	/**
	 * @param moviebanner
	 *            the moviebanner to set
	 */
	protected Movie setMovieBanners(List<ImageLanguageResponse> moviebanner) {
		this.moviebanner = moviebanner;
		return this;
	}

	/**
	 * @return the moviethumb
	 */
	public List<ImageLanguageResponse> getMovieThumbs() {
		return moviethumb;
	}

	/**
	 * @param moviethumb
	 *            the moviethumb to set
	 */
	protected Movie setMovieThumbs(List<ImageLanguageResponse> moviethumb) {
		this.moviethumb = moviethumb;
		return this;
	}
}
