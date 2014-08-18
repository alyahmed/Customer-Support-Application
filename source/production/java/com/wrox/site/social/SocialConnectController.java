package com.wrox.site.social;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;

import com.wrox.config.annotation.WebController;

@WebController("/connect")
public class SocialConnectController extends ConnectController {
	
	
	@Inject
	public SocialConnectController(
			ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository) {
		super(connectionFactoryLocator, connectionRepository);
	}
	
	
	
}