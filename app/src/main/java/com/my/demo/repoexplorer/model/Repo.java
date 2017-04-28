package com.my.demo.repoexplorer.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Administrator on 2017-04-27.
 */

public class Repo implements Comparable<Repo> {
    public User owner;
    public String name;
    public String fullName;
    public boolean privateX;
    public String htmlUrl;
    public String description;
    public boolean fork;
    public String url;
    public String forksUrl;
    public String keysUrl;
    public String collaboratorsUrl;
    public String teamsUrl;
    public String hooksUrl;
    public String issueEventsUrl;
    public String eventsUrl;
    public String assigneesUrl;
    public String branchesUrl;
    public String tagsUrl;
    public String blobsUrl;
    public String gitTagsUrl;
    public String gitRefsUrl;
    public String treesUrl;
    public String statusesUrl;
    public String languagesUrl;
    public String stargazersUrl;
    public String contributorsUrl;
    public String subscribersUrl;
    public String subscriptionUrl;
    public String commitsUrl;
    public String gitCommitsUrl;
    public String commentsUrl;
    public String issueCommentUrl;
    public String contentsUrl;
    public String compareUrl;
    public String mergesUrl;
    public String archiveUrl;
    public String downloadsUrl;
    public String issuesUrl;
    public String pullsUrl;
    public String milestonesUrl;
    public String notificationsUrl;
    public String labelsUrl;
    public String releasesUrl;
    public Date createdAt;
    public Date updatedAt;
    public Date pushedAt;
    public String gitUrl;
    public String sshUrl;
    public String cloneUrl;
    public String svnUrl;
    public String homepage;
    public long size;
    public long stargazersCount;
    public long watchersCount;
    public boolean hasIssues;
    public boolean hasDownloads;
    public boolean hasWiki;
    public boolean hasPages;
    public long forksCount;
    public String mirrorUrl;
    public long openIssuesCount;
    public long forks;
    public long openIssues;
    public long watchers;
    public String defaultBranch;
    public int subsCount;
    public int networkCount;
    public String starredUser;
    public String reposOwner;

    public Repo(User owner, String name, String fullName, boolean privateX, String htmlUrl, String description, boolean fork, String url,
                String forksUrl, String keysUrl, String collaboratorsUrl, String teamsUrl, String hooksUrl, String issueEventsUrl,
                String eventsUrl, String assigneesUrl, String branchesUrl, String tagsUrl, String blobsUrl, String gitTagsUrl, String gitRefsUrl,
                String treesUrl, String statusesUrl, String languagesUrl, String stargazersUrl, String contributorsUrl, String subscribersUrl,
                String subscriptionUrl, String commitsUrl, String gitCommitsUrl, String commentsUrl, String issueCommentUrl, String contentsUrl,
                String compareUrl, String mergesUrl, String archiveUrl, String downloadsUrl, String issuesUrl, String pullsUrl, String milestonesUrl,
                String notificationsUrl, String labelsUrl, String releasesUrl, Date createdAt, Date updatedAt, Date pushedAt, String gitUrl, String sshUrl,
                String cloneUrl, String svnUrl, String homepage, long size, long stargazersCount, long watchersCount, boolean hasIssues, boolean hasDownloads,
                boolean hasWiki, boolean hasPages, long forksCount, String mirrorUrl, long openIssuesCount, long forks, long openIssues, long watchers,
                String defaultBranch, int subsCount, int networkCount, String starredUser, String reposOwner) {
        this.owner = owner;
        this.name = name;
        this.fullName = fullName;
        this.privateX = privateX;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.fork = fork;
        this.url = url;
        this.forksUrl = forksUrl;
        this.keysUrl = keysUrl;
        this.collaboratorsUrl = collaboratorsUrl;
        this.teamsUrl = teamsUrl;
        this.hooksUrl = hooksUrl;
        this.issueEventsUrl = issueEventsUrl;
        this.eventsUrl = eventsUrl;
        this.assigneesUrl = assigneesUrl;
        this.branchesUrl = branchesUrl;
        this.tagsUrl = tagsUrl;
        this.blobsUrl = blobsUrl;
        this.gitTagsUrl = gitTagsUrl;
        this.gitRefsUrl = gitRefsUrl;
        this.treesUrl = treesUrl;
        this.statusesUrl = statusesUrl;
        this.languagesUrl = languagesUrl;
        this.stargazersUrl = stargazersUrl;
        this.contributorsUrl = contributorsUrl;
        this.subscribersUrl = subscribersUrl;
        this.subscriptionUrl = subscriptionUrl;
        this.commitsUrl = commitsUrl;
        this.gitCommitsUrl = gitCommitsUrl;
        this.commentsUrl = commentsUrl;
        this.issueCommentUrl = issueCommentUrl;
        this.contentsUrl = contentsUrl;
        this.compareUrl = compareUrl;
        this.mergesUrl = mergesUrl;
        this.archiveUrl = archiveUrl;
        this.downloadsUrl = downloadsUrl;
        this.issuesUrl = issuesUrl;
        this.pullsUrl = pullsUrl;
        this.milestonesUrl = milestonesUrl;
        this.notificationsUrl = notificationsUrl;
        this.labelsUrl = labelsUrl;
        this.releasesUrl = releasesUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pushedAt = pushedAt;
        this.gitUrl = gitUrl;
        this.sshUrl = sshUrl;
        this.cloneUrl = cloneUrl;
        this.svnUrl = svnUrl;
        this.homepage = homepage;
        this.size = size;
        this.stargazersCount = stargazersCount;
        this.watchersCount = watchersCount;
        this.hasIssues = hasIssues;
        this.hasDownloads = hasDownloads;
        this.hasWiki = hasWiki;
        this.hasPages = hasPages;
        this.forksCount = forksCount;
        this.mirrorUrl = mirrorUrl;
        this.openIssuesCount = openIssuesCount;
        this.forks = forks;
        this.openIssues = openIssues;
        this.watchers = watchers;
        this.defaultBranch = defaultBranch;
        this.subsCount = subsCount;
        this.networkCount = networkCount;
        this.starredUser = starredUser;
        this.reposOwner = reposOwner;
    }

    // sort by stargazersCount desc
    public int compareTo(Repo repo) {
        return (int) (repo.stargazersCount - this.stargazersCount);
    }
}
