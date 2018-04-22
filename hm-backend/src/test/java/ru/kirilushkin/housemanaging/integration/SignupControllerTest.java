package ru.kirilushkin.housemanaging.integration;

import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.kirilushkin.housemanaging.dto.RegistrationInfo;

import java.nio.charset.Charset;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SignupControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldSignup() {
        String username = "owner@app";
        String password = "password";
        RegistrationInfo registrationInfo = getRegistrationInfo(username, password);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RegistrationInfo> entity = new HttpEntity<>(registrationInfo, headers);
        ResponseEntity<Object> responseEntity = restTemplate.exchange("/signup", HttpMethod.POST, entity, Object.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(shouldLogin(username, password));
    }

    @Test
    public void shouldSignupAsManager() {
        String username = "manager@app";
        String password = "password";
        RegistrationInfo registrationInfo = getRegistrationInfo(username, password);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RegistrationInfo> entity = new HttpEntity<>(registrationInfo, headers);
        ResponseEntity<Object> responseEntity = restTemplate.exchange("/signup?manager", HttpMethod.POST, entity, Object.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(shouldLogin(username, password));
    }

    private RegistrationInfo getRegistrationInfo(String username, String password) {
        RegistrationInfo registrationInfo = new RegistrationInfo();
        registrationInfo.setLogin(username);
        registrationInfo.setPassword(password);
        return registrationInfo;
    }

    private String shouldLogin(String username, String password) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "client");
        params.add("username", username);
        params.add("password", password);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                "/oauth/token",
                HttpMethod.POST,
                new HttpEntity<>(params, createHeaders("client", "secret")),
                Object.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Map<String, String> bodyMap = (Map<String, String>) responseEntity.getBody();
        return bodyMap.get("access_token");
    }

    private HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }
}