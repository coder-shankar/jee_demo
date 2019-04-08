package com.example.jeedemo.restclients;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GithubReposService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubReposService.class);
    private static final GenericType<List<Repo>> REPOS_TYPE = new GenericType<List<Repo>>() {
    };

    @Inject
    @Github
    private Client client;



    @ErrorHandler
    public List<Repo> listRepos(final String username) {
        LOGGER.info("github link is being called");
        return client.target("https://api.github.com/users").path(username).path("repos").request().get(REPOS_TYPE);
    }
}
