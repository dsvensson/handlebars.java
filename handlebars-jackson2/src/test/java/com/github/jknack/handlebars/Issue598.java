/*
 * Handlebars.java: https://github.com/jknack/handlebars.java
 * Apache License Version 2.0 http://www.apache.org/licenses/LICENSE-2.0
 * Copyright (c) 2012 Edgar Espina
 */
package com.github.jknack.handlebars;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jknack.handlebars.context.MapValueResolver;

public class Issue598 extends AbstractTest {

  @Override
  protected Object configureContext(final Object model) {
    return Context.newBuilder(model)
        .resolver(MapValueResolver.INSTANCE, JsonNodeValueResolver.INSTANCE)
        .build();
  }

  @Test
  public void shouldExtendJsonArrayWithLenghtProperty() throws IOException {
    JsonNode tree = new ObjectMapper().readTree("[1, 2, 3]");
    shouldCompileTo("{{this.length}}", tree, "3");
  }
}
