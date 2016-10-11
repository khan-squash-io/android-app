package app.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entities_ {

    @Expose
    private List<Object> mentions = new ArrayList<Object>();
    @Expose
    private List<Object> hashtags = new ArrayList<Object>();
    @Expose
    private List<Link_> links = new ArrayList<Link_>();

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
    public List<Object> getHashtags() {
        return hashtags;
    }

    /**
     *
     * @param hashtags
     *     The hashtags
     */
    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     *
     * @return
     *     The links
     */
    public List<Link_> getLinks() {
        return links;
    }

    /**
     *
     * @param links
     *     The links
     */
    public void setLinks(List<Link_> links) {
        this.links = links;
    }

}