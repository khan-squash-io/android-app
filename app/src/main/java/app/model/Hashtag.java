package app.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Hashtag {

    @Expose
    private String name;
    @Expose
    private int len;
    @Expose
    private int pos;

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

}
