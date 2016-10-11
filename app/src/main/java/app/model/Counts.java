package app.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Counts {

    @Expose
    private int following;
    @Expose
    private int posts;
    @Expose
    private int followers;
    @Expose
    private int stars;

    /**
     *
     * @return
     *     The following
     */
    public int getFollowing() {
        return following;
    }

    /**
     *
     * @param following
     *     The following
     */
    public void setFollowing(int following) {
        this.following = following;
    }

    /**
     *
     * @return
     *     The posts
     */
    public int getPosts() {
        return posts;
    }

    /**
     *
     * @param posts
     *     The posts
     */
    public void setPosts(int posts) {
        this.posts = posts;
    }

    /**
     *
     * @return
     *     The followers
     */
    public int getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers
     *     The followers
     */
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /**
     *
     * @return
     *     The stars
     */
    public int getStars() {
        return stars;
    }

    /**
     *
     * @param stars
     *     The stars
     */
    public void setStars(int stars) {
        this.stars = stars;
    }

}