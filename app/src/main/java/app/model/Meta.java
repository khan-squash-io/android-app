package app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Meta {

    @SerializedName("min_id")
    @Expose
    private String minId;
    @Expose
    private int code;
    @SerializedName("max_id")
    @Expose
    private String maxId;
    @Expose
    private boolean more;

    /**
     *
     * @return
     *     The minId
     */
    public String getMinId() {
        return minId;
    }

    /**
     *
     * @param minId
     *     The min_id
     */
    public void setMinId(String minId) {
        this.minId = minId;
    }

    /**
     *
     * @return
     *     The code
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     *     The code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     *     The maxId
     */
    public String getMaxId() {
        return maxId;
    }

    /**
     *
     * @param maxId
     *     The max_id
     */
    public void setMaxId(String maxId) {
        this.maxId = maxId;
    }

    /**
     *
     * @return
     *     The more
     */
    public boolean isMore() {
        return more;
    }

    /**
     *
     * @param more
     *     The more
     */
    public void setMore(boolean more) {
        this.more = more;
    }

}