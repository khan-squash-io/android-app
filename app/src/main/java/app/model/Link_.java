package app.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Link_ {

    @Expose
    private String url;
    @Expose
    private String text;
    @Expose
    private int pos;
    @Expose
    private int len;

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
     *     The pos
     */
    public int getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     *     The pos
     */
    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     *
     * @return
     *     The len
     */
    public int getLen() {
        return len;
    }

    /**
     *
     * @param len
     *     The len
     */
    public void setLen(int len) {
        this.len = len;
    }

}
