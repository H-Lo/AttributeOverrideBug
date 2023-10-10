/*
 * TheVegCat - The Vegan Catalog.
 * Copyright (C) H.Lo
 * mailto:horvoje@gmail.com
 */
package org.hibernate.bugs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author H.Lo
 */
@AllArgsConstructor @Getter
public enum SocialMedia {

    FACEBOOK("Facebook",  "Facebook" ),
   INSTAGRAM("Instagram", "Instagram"),
     TWITTER("Twitter",   "Twitter"  ),
    HAPPYCOW("Happy Cow", "HappyCow" ),
     YOUTUBE("YouTube",   "YouTube"  ),
    LINKEDIN("LinkedIn",  "LinkedIn" ),
      TIKTOK("Tik-Tok",   "TikTok"   ),
   PINTEREST("Pinterest", "Pinterest");

	private final String prettyName;
	private final String cssClass;

}
