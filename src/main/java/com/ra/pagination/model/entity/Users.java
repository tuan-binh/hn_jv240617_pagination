package com.ra.pagination.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private Boolean status;

    @ManyToMany
    @JoinTable(
            name = "user_role", // tên bảng phụ sẽ được sinh ra
            joinColumns = @JoinColumn(name = "user_id"), // bảng chủ thể là User
            inverseJoinColumns = @JoinColumn(name = "role_id") // bảng còn lại chính là role
    )
    private Set<Roles> roles;

    public Users()
    {
    }

    public Users(Long id, String username, String password, String email, Boolean status, Set<Roles> roles)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.roles = roles;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public Set<Roles> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Roles> roles)
    {
        this.roles = roles;
    }
}

