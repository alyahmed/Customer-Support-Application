/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wrox.site.social.facebook;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrox.config.annotation.WebController;

@WebController
public class FacebookFriendsController {
	
	private static final Logger log = LogManager.getLogger(FacebookFriendsController.class);
	
	private final Facebook facebook;

	@Inject
	public FacebookFriendsController(Facebook facebook) {
		this.facebook = facebook;
	}

	@RequestMapping(value="/facebook/friends", method=RequestMethod.GET)
	public String showFeed(Model model) {
		log.info("GET /facebook/friends, adding friends and friendIds to model");
		model.addAttribute("friends", facebook.friendOperations().getFriendProfiles());
		model.addAttribute("friendIds", facebook.friendOperations().getFriendIds());
		log.info("friends: " + facebook.friendOperations().getFriendProfiles());
		log.info("friendIds: " + facebook.friendOperations().getFriendIds());
		log.info(facebook.mediaOperations().getAlbums());
		log.info("providing friends VIEW");
		return "facebook/friends";
	}
	
}
