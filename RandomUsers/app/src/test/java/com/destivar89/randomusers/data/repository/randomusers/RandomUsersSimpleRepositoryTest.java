package com.destivar89.randomusers.data.repository.randomusers;

import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.repository.RepositoryCallback;
import com.destivar89.randomusers.data.repository.randomusers.data.api.RestApiMock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RandomUsersSimpleRepositoryTest {

    private static final String RESPONSE_BODY_ERROR = "{\n" +
            "  error: \"Uh oh, something has gone wrong. Please tweet us @randomapi about the issue. Thank you.\"\n" +
            "}";

    private static final String RESPONSE_BODY_SUCCESS = "{\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"gender\": \"male\",\n" +
            "      \"name\": {\n" +
            "        \"title\": \"mr\",\n" +
            "        \"first\": \"romain\",\n" +
            "        \"last\": \"hoogmoed\"\n" +
            "      },\n" +
            "      \"location\": {\n" +
            "        \"street\": \"1861 jan pieterszoon coenstraat\",\n" +
            "        \"city\": \"maasdriel\",\n" +
            "        \"state\": \"zeeland\",\n" +
            "        \"postcode\": 69217\n" +
            "      },\n" +
            "      \"email\": \"romain.hoogmoed@example.com\",\n" +
            "      \"login\": {\n" +
            "        \"username\": \"lazyduck408\",\n" +
            "        \"password\": \"jokers\",\n" +
            "        \"salt\": \"UGtRFz4N\",\n" +
            "        \"md5\": \"6d83a8c084731ee73eb5f9398b923183\",\n" +
            "        \"sha1\": \"cb21097d8c430f2716538e365447910d90476f6e\",\n" +
            "        \"sha256\": \"5a9b09c86195b8d8b01ee219d7d9794e2abb6641a2351850c49c309f1fc204a0\"\n" +
            "      },\n" +
            "      \"dob\": \"1983-07-14 07:29:45\",\n" +
            "      \"registered\": \"2010-09-24 02:10:42\",\n" +
            "      \"phone\": \"(656)-976-4980\",\n" +
            "      \"cell\": \"(065)-247-9303\",\n" +
            "      \"id\": {\n" +
            "        \"name\": \"BSN\",\n" +
            "        \"value\": \"04242023\"\n" +
            "      },\n" +
            "      \"picture\": {\n" +
            "        \"large\": \"https://randomuser.me/api/portraits/men/83.jpg\",\n" +
            "        \"medium\": \"https://randomuser.me/api/portraits/med/men/83.jpg\",\n" +
            "        \"thumbnail\": \"https://randomuser.me/api/portraits/thumb/men/83.jpg\"\n" +
            "      },\n" +
            "      \"nat\": \"NL\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"info\": {\n" +
            "    \"seed\": \"2da87e9305069f1d\",\n" +
            "    \"results\": 1,\n" +
            "    \"page\": 1,\n" +
            "    \"version\": \"1.1\"\n" +
            "  }\n" +
            "}";

    private MockWebServer mockWebServer;
    private RandomUsersSimpleRepository repository;

    @Mock
    RepositoryCallback repositoryCallback;

    @Before
    public void setUp() throws IOException{

        mockWebServer = new MockWebServer();
        mockWebServer.start();

        repository = new RandomUsersSimpleRepository(new RestApiMock(mockWebServer.url("/")));

    }

    @Test
    public void retrieveRandomUsers_withSuccessfullResponse_shouldCallRepositorySuccess() throws Exception {

        mockWebServer.enqueue(
                new MockResponse().setResponseCode(200).setBody(RESPONSE_BODY_SUCCESS));

        repository.retrieveRandomUsers(0, 20, repositoryCallback);

        Thread.sleep(1000);
        verify(repositoryCallback).repositorySuccess(Matchers.any(RandomUsersDTO.class));

    }

    @Test
    public void retrieveRandomUsers_withResponse_shouldCallRepositorySuccess() throws Exception {

        mockWebServer.enqueue(
                new MockResponse().setResponseCode(404).setBody(RESPONSE_BODY_ERROR));

        repository.retrieveRandomUsers(0, 20, repositoryCallback);

        Thread.sleep(1000);
        verify(repositoryCallback).repositoryFail(Matchers.any(Throwable.class));

    }

    @After
    public void tearDown() throws Exception{
        mockWebServer.shutdown();
    }

}