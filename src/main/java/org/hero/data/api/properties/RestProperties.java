package org.hero.data.api.properties;

import java.util.regex.Pattern;

public final class RestProperties {

  public static final String HERO_API_SERVICE = "/superheros";

  public static final Pattern
    PATTERN_UUID = Pattern.compile("([a-fA-F0-9]{8}-(?:[a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}){1}");
}
