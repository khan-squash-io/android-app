package app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Source {

    @Expose
    private String link;
    @Expose
    private String name;
    @SerializedName("client_id")
    @Expose
    private String clientId;

    /**
     *
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
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

    /**
     *
     * @return
     *     The clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     *
     * @param clientId
     *     The client_id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

}
