package app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Datum {

    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("num_stars")
    @Expose
    private int numStars;
    @SerializedName("num_replies")
    @Expose
    private int numReplies;
    @Expose
    private Source source;
    @Expose
    private String text;
    @SerializedName("num_reposts")
    @Expose
    private int numReposts;
    @Expose
    private String id;
    @SerializedName("canonical_url")
    @Expose
    private String canonicalUrl;
    @Expose
    private Entities entities;
    @Expose
    private String html;
    @SerializedName("machine_only")
    @Expose
    private boolean machineOnly;
    @Expose
    private User user;
    @SerializedName("thread_id")
    @Expose
    private String threadId;
    @SerializedName("pagination_id")
    @Expose
    private String paginationId;

    /**
     *
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     *     The numStars
     */
    public int getNumStars() {
        return numStars;
    }

    /**
     *
     * @param numStars
     *     The num_stars
     */
    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    /**
     *
     * @return
     *     The numReplies
     */
    public int getNumReplies() {
        return numReplies;
    }

    /**
     *
     * @param numReplies
     *     The num_replies
     */
    public void setNumReplies(int numReplies) {
        this.numReplies = numReplies;
    }

    /**
     *
     * @return
     *     The source
     */
    public Source getSource() {
        return source;
    }

    /**
     *
     * @param source
     *     The source
     */
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     *
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     *     The numReposts
     */
    public int getNumReposts() {
        return numReposts;
    }

    /**
     *
     * @param numReposts
     *     The num_reposts
     */
    public void setNumReposts(int numReposts) {
        this.numReposts = numReposts;
    }

    /**
     *
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The canonicalUrl
     */
    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    /**
     *
     * @param canonicalUrl
     *     The canonical_url
     */
    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    /**
     *
     * @return
     *     The entities
     */
    public Entities getEntities() {
        return entities;
    }

    /**
     *
     * @param entities
     *     The entities
     */
    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    /**
     *
     * @return
     *     The html
     */
    public String getHtml() {
        return html;
    }

    /**
     *
     * @param html
     *     The html
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     *
     * @return
     *     The machineOnly
     */
    public boolean isMachineOnly() {
        return machineOnly;
    }

    /**
     *
     * @param machineOnly
     *     The machine_only
     */
    public void setMachineOnly(boolean machineOnly) {
        this.machineOnly = machineOnly;
    }

    /**
     *
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     *     The threadId
     */
    public String getThreadId() {
        return threadId;
    }

    /**
     *
     * @param threadId
     *     The thread_id
     */
    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    /**
     *
     * @return
     *     The paginationId
     */
    public String getPaginationId() {
        return paginationId;
    }

    /**
     *
     * @param paginationId
     *     The pagination_id
     */
    public void setPaginationId(String paginationId) {
        this.paginationId = paginationId;
    }

}
