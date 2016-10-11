package app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class User {

    @Expose
    private String username;
    @SerializedName("avatar_image")
    @Expose
    private AvatarImage avatarImage;
    @Expose
    private Description description;
    @Expose
    private String locale;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("canonical_url")
    @Expose
    private String canonicalUrl;
    @SerializedName("cover_image")
    @Expose
    private CoverImage coverImage;
    @Expose
    private String timezone;
    @Expose
    private Counts counts;
    @Expose
    private String type;
    @Expose
    private String id;
    @Expose
    private String name;

    /**
     *
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     *     The avatarImage
     */
    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    /**
     *
     * @param avatarImage
     *     The avatar_image
     */
    public void setAvatarImage(AvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    /**
     *
     * @return
     *     The description
     */
    public Description getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *     The description
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     *
     * @return
     *     The locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     *
     * @param locale
     *     The locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

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
     *     The coverImage
     */
    public CoverImage getCoverImage() {
        return coverImage;
    }

    /**
     *
     * @param coverImage
     *     The cover_image
     */
    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }

    /**
     *
     * @return
     *     The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     *
     * @param timezone
     *     The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     *
     * @return
     *     The counts
     */
    public Counts getCounts() {
        return counts;
    }

    /**
     *
     * @param counts
     *     The counts
     */
    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    /**
     *
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

}
