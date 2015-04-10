/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frost.forest.pen.model;


import com.frost.forest.gen.anotation.query.Header;
import com.frost.forest.gen.anotation.update.Assistant;
import com.frost.forest.gen.literal.AssistStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author wenkui
 */
@Assistant(AssistStrategy.SELECT)
@Entity
@NamedQueries({
    @NamedQuery(name = "Authorities.findAll", query = "SELECT a FROM Authorities a")})
public class Authorities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Header
    private String authority;
    @JoinTable(name = "authorities_has_resources", joinColumns = {
        @JoinColumn(name = "authorities_authority", referencedColumnName = "authority")}, inverseJoinColumns = {
        @JoinColumn(name = "resources_id", referencedColumnName = "id")})
    @ManyToMany(targetEntity = Resources.class,fetch = FetchType.EAGER)
    @Header
    private Collection<Resources> resourcesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authoritiesAuthority")
    private Collection<Users> usersCollection;

    public Authorities() {
    }

    public Authorities(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Collection<Resources> getResourcesCollection() {
        return resourcesCollection;
    }

    public void setResourcesCollection(Collection<Resources> resourcesCollection) {
        this.resourcesCollection = resourcesCollection;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authority != null ? authority.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authorities)) {
            return false;
        }
        Authorities other = (Authorities) object;
        if ((this.authority == null && other.authority != null) || (this.authority != null && !this.authority.equals(other.authority))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.auth2.yhsg.model.Authorities[ authority=" + authority + " ]";
    }
    
}
