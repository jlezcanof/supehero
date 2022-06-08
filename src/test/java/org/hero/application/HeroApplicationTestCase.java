package org.hero.application;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.hamcrest.Matchers;
import org.hero.data.api.HeroDataApiApplication;
import org.hero.data.api.dto.SuperHeroResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HeroDataApiApplication.class)
@AutoConfigureMockMvc
public abstract class HeroApplicationTestCase {

  @Autowired
  private MockMvc mockMvc;

  protected void assertResponse(
    String endpoint,
    Integer expectedStatusCode,
    String expectedResponse) throws Exception {
    ResultMatcher response = expectedResponse.isEmpty()
      ? content().string("")
      : content().json(expectedResponse);

    mockMvc
      .perform(get(endpoint))
      .andExpect(status().is(expectedStatusCode))
      .andExpect(response);
  }

  protected void assertResponse(
    String endpoint,
    Integer expectedStatusCode,
    String keyQueryParam,
    String valueQueryParam,
    String expectedResponse) throws Exception {
    String response = expectedResponse.isEmpty()
      ? ""
      : expectedResponse;


    mockMvc
      .perform(get(endpoint).queryParam(keyQueryParam, valueQueryParam))
      .andExpect(status().is(expectedStatusCode))
      .andExpect(content().string(Matchers.containsStringIgnoringCase(expectedResponse)));

  }

  protected void assertResponse(
    String endpoint,
    Integer expectedStatusCode,
    String expectedResponse,
    HttpHeaders headers
                               ) throws Exception {
    ResultMatcher response = expectedResponse.isEmpty()
      ? content().string("")
      : content().json(expectedResponse);

    mockMvc
      .perform(get(endpoint).headers(headers))
      .andExpect(status().is(expectedStatusCode))
      .andExpect(response);
  }

  protected void assertRequestWithBody(
    String method,
    String endpoint,
    String body,
    Integer expectedStatusCode
                                      ) throws Exception {
    mockMvc
      .perform(request(
        HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
      .andExpect(status().is(expectedStatusCode));
      //.andExpect(content().string(Matchers.containsString(new JSONObject(body).toString())));//""
  }

  protected void assertBadRequest(
    String method,
    String endpoint,
    String body,
    Integer expectedStatusCode
                                      ) throws Exception {
    mockMvc
      .perform(request(
        HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
      .andExpect(status().is(expectedStatusCode));
  }

  /*protected void assertRequest(
    String method,
    String endpoint,
    Integer expectedStatusCode
                                 ) throws Exception {
    mockMvc
      .perform(request(
        HttpMethod.valueOf(method), endpoint).contentType(APPLICATION_JSON))
      .andExpect(status().is(expectedStatusCode));
  }*/

  protected void assertRequest(
    String method,
    String endpoint,
    Integer expectedStatusCode
                              ) throws Exception {
    mockMvc
      .perform(request(HttpMethod.valueOf(method), endpoint))
      .andExpect(status().is(expectedStatusCode))
      .andExpect(jsonPath("$").isArray());
  }

  protected void assertRequestNoContent(
    String method,
    String endpoint,
    Integer expectedStatusCode
                              ) throws Exception {
    mockMvc
      .perform(request(HttpMethod.valueOf(method), endpoint))
      .andExpect(status().is(expectedStatusCode));
  }

  private List<SuperHeroResponse> obtainListOfSuperHeros() {
    List<SuperHeroResponse> expectedSuperHero = new ArrayList<>();
    expectedSuperHero.add(new SuperHeroResponse("identifier1","spiderman"));
    expectedSuperHero.add(new SuperHeroResponse("identifier2","enjuto"));

    return expectedSuperHero;
  }

  private String expectedResult() {
    List<SuperHeroResponse> expectedSuperHero = obtainListOfSuperHeros();

    //Converts List items to Map
    Map<String, String>
      result = expectedSuperHero.stream().collect(Collectors.toMap(SuperHeroResponse::getIdentifier,
      SuperHeroResponse::getName));

    JSONObject jsonObject = new JSONObject(result);
    return jsonObject.toString();

  }


}
