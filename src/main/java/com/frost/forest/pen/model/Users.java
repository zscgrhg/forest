/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frost.forest.pen.model;


import com.frost.forest.gen.anotation.query.Header;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.security.SecureRandom;

/**
 *
 * @author wenkui
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(6, new SecureRandom());
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Header
    private String username;
    @Basic(optional = false)
    @NotNull
    @Header
    private boolean enabled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Header(hidden = true,updater = true,editable = false)
    private String password;
    @JoinColumn(name = "authorities_authority", referencedColumnName = "authority")
    @ManyToOne(optional = false)
    @Header
    private Authorities authoritiesAuthority;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, boolean enabled, String password) {
        this.username = username;
        this.enabled = enabled;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authorities getAuthoritiesAuthority() {
        return authoritiesAuthority;
    }

    public void setAuthoritiesAuthority(Authorities authoritiesAuthority) {
        this.authoritiesAuthority = authoritiesAuthority;
    }

    public void setPasswordUpdater(String password){
        this.password=passwordEncoder.encode(password);
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.auth2.yhsg.model.Users[ username=" + username + " ]";
    }
    
}
