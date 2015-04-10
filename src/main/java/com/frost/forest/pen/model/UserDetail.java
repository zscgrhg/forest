/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frost.forest.pen.model;



import com.frost.forest.gen.anotation.query.Header;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author wenkui
 */

@Entity
@Table(name = "user_detail")
@NamedQueries({
    @NamedQuery(name = "UserDetail.findAll", query = "SELECT u FROM UserDetail u")})
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "display_name")
    @Header
    private String displayName;
    @Size(max = 255)
    @Header
    @Pattern(regexp = "\\p{IsHan}{2,10}",message = "必须是2到10个汉字",flags = {Pattern.Flag.MULTILINE})
    private String company;
    @Size(max = 30)
    @Column(name = "company_tel")
    @Header
    private String companyTel;
    @Size(max = 255)
    @Header
    private String fullname;
    @Size(max = 30)
    @Header
    private String tel;
    @Size(max = 255)
    @Header
    private String profession;
    @Size(max = 255)
    @Header
    private String city;
    @Size(max = 255)
    @Header
    private String address;
    @Size(max = 255)
    @Header
    private String introduce;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Header
    private String username;

    public UserDetail() {
    }

    public UserDetail(String username) {
        this.username = username;
    }

    public UserDetail(String username, String displayName) {
        this.username = username;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (!(object instanceof UserDetail)) {
            return false;
        }
        UserDetail other = (UserDetail) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.auth2.yhsg.model.UserDetail[ username=" + username + " ]";
    }
    
}
