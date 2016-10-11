package app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CoverImage {

    @Expose
    private String url;
    @Expose
    private int width;
    @SerializedName("is_default")
    @Expose
    private boolean isDefault;
    @Expose
    private int height;

    /**
     *
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     *     The width
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     *     The width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     *     The isDefault
     */
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     *
     * @param isDefault
     *     The is_default
     */
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     *
     * @return
     *     The height
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     *     The height
     */
    public void setHeight(int height) {
        this.height = height;
    }

}


