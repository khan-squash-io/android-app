package app.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Description {

    @Expose
    private String text;
    @Expose
    private String html;
    @Expose
    private Entities_ entities;

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
     *     The entities
     */
    public Entities_ getEntities() {
        return entities;
    }

    /**
     *
     * @param entities
     *     The entities
     */
    public void setEntities(Entities_ entities) {
        this.entities = entities;
    }

}
