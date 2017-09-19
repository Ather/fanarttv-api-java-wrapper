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
package media.thehoard.thirdparty.api.fanarttv.endpoints.music;

import java.util.List;

import media.thehoard.thirdparty.api.fanarttv.endpoints.GenericImageResponse;
import media.thehoard.thirdparty.api.fanarttv.http.GenericJson;

/**
 * AlbumItem object for use within a Map of albums returned from the Fanart.TV
 * API This is used for Gson
 * 
 * @author Michael Haas
 *
 */
public class AlbumItem extends GenericJson {
	/**
	 * List of album cover images for a given album
	 */
	private List<GenericImageResponse> albumcover;

	/**
	 * List of CD art images for a given album
	 */
	private List<CdImageResponse> cdart;

	/**
	 * CD Image Response object for Gson returned from the Fanart.TV API Used to add
	 * the disc and size field to a standard image response
	 * 
	 * @author Michael Haas
	 *
	 */
	public class CdImageResponse extends GenericImageResponse {
		/**
		 * Disc number
		 */
		private Integer disc;

		/**
		 * Width/Height of the disc image. Normally 450 or 1000 Disc images are square,
		 * so the dimensions are the same.
		 */
		private Integer size;

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
		protected CdImageResponse setDisc(Integer disc) {
			this.disc = disc;
			return this;
		}

		/**
		 * @return the size
		 */
		public Integer getSize() {
			return size;
		}

		/**
		 * @param size
		 *            the size to set
		 */
		protected CdImageResponse setSize(Integer size) {
			this.size = size;
			return this;
		}
	}

	/**
	 * @return the albumcover
	 */
	public List<GenericImageResponse> getAlbumCovers() {
		return albumcover;
	}

	/**
	 * @param albumcover
	 *            the albumcover to set
	 */
	protected AlbumItem setAlbumCovers(List<GenericImageResponse> albumcover) {
		this.albumcover = albumcover;
		return this;
	}

	/**
	 * @return the cdart
	 */
	public List<CdImageResponse> getCdArt() {
		return cdart;
	}

	/**
	 * @param cdart
	 *            the cdart to set
	 */
	protected AlbumItem setCdArt(List<CdImageResponse> cdart) {
		this.cdart = cdart;
		return this;
	}
}
