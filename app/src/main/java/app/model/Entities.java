package app.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entities {

    @Expose
    private List<Object> mentions = new ArrayList<Object>();
    @Expose
    private List<Hashtag> hashtags = new ArrayList<Hashtag>();
    @Expose
    private List<Link> links = new ArrayList<Link>();

    /**
     *
     * @return
     *     The mentions
     */
    public List<Object> getMentions() {
        return mentions;
    }

    /**
     *
     * @param mentions
     *     The mentions
     */
    public void setMentions(List<Object> mentions) {
        this.mentions = mentions;
    }

    /**
     *
     * @return
     *     The hashtags
     */
    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    /**
     *
     * @param hashtags
     *     The hashtags
     */
    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     *
     * @return
     *     The links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     *
     * @param links
     *     The links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
