package com.my.demo.repoexplorer.model;

import java.util.Date;

/**
 * Created by Administrator on 2017-04-27.
 */

public class User {
    public int id;
    public String login;
    public String avatarUrl;
    public String gravatarId;
    public String url;
    public String htmlUrl;
    public String followersUrl;
    public String followingUrl;
    public String gistsUrl;
    public String starredUrl;
    public String subscriptionsUrl;
    public String organizationsUrl;
    public String reposUrl;
    public String eventsUrl;
    public String receivedEventsUrl;
    public String type;
    public boolean siteAdmin;
    public String name;
    public String company;
    public String blog;
    public String location;
    public String email;
    public boolean hireable;
    public String bio;
    public long publicRepos;
    public long publicGists;
    public long followers;
    public long following;
    public Date createdAt;
    public Date updatedAt;
    public int contributions;
    public String followingName;
    public String followerName;
    public Date date;
    public String repoId;
    public String description;

    public User(int id, String login, String avatarUrl, String gravatarId, String url, String htmlUrl, String followersUrl, String followingUrl,
                String gistsUrl, String starredUrl, String subscriptionsUrl, String organizationsUrl, String reposUrl, String eventsUrl,
                String receivedEventsUrl, String type, boolean siteAdmin, String name, String company, String blog, String location, String email,
                boolean hireable, String bio, long publicRepos, long publicGists, long followers, long following, Date createdAt, Date updatedAt,
                int contributions, String followingName, String followerName, Date date, String repoId, String description) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.gravatarId = gravatarId;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.followersUrl = followersUrl;
        this.followingUrl = followingUrl;
        this.gistsUrl = gistsUrl;
        this.starredUrl = starredUrl;
        this.subscriptionsUrl = subscriptionsUrl;
        this.organizationsUrl = organizationsUrl;
        this.reposUrl = reposUrl;
        this.eventsUrl = eventsUrl;
        this.receivedEventsUrl = receivedEventsUrl;
        this.type = type;
        this.siteAdmin = siteAdmin;
        this.name = name;
        this.company = company;
        this.blog = blog;
        this.location = location;
        this.email = email;
        this.hireable = hireable;
        this.bio = bio;
        this.publicRepos = publicRepos;
        this.publicGists = publicGists;
        this.followers = followers;
        this.following = following;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.contributions = contributions;
        this.followingName = followingName;
        this.followerName = followerName;
        this.date = date;
        this.repoId = repoId;
        this.description = description;
    }
}
