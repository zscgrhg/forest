/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frost.forest.pen.model;



import com.frost.forest.gen.anotation.query.Header;
import com.frost.forest.gen.anotation.update.Assistant;
import com.frost.forest.gen.literal.AssistStrategy;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wenkui
 */
@Assistant(AssistStrategy.SELECT)
@Entity
@NamedQueries({
    @NamedQuery(name = "Resources.findAll", query = "SELECT r FROM Resources r")})
public class Resources implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Header
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Header
    private int type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Header
    private String url;
    @ManyToMany(mappedBy = "resourcesCollection")

    private Collection<Authorities> authoritiesCollection;

    public Resources() {
    }

    public Resources(Integer id) {
        this.id = id;
    }

    public Resources(Integer id, int type, String url) {
        this.id = id;
        this.type = type;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Collection<Authorities> getAuthoritiesCollection() {
        return authoritiesCollection;
    }

    public void setAuthoritiesCollection(Collection<Authorities> authoritiesCollection) {
        this.authoritiesCollection = authoritiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resources)) {
            return false;
        }
        Resources other = (Resources) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.auth2.yhsg.model.Resources[ id=" + id + " ]";
    }
    
}
