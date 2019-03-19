package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@SequenceGenerator(name="seq",initialValue = 0, allocationSize=100)
public class User {

    public enum Role {
        ADMIN,
        USER
    }

    public enum State {
        PENDING,
        VERIFIED,
        LOCKED
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
//    @JsonProperty("id")
//    private Integer id;

    @Id
    @JsonProperty("username")
    private String username;

    @Basic
    @JsonIgnore
    @JsonProperty("passwordHash")
    private String passwordHash;

    @Basic
    @JsonIgnore
    @JsonProperty("salt")
    private String salt;

    @Basic
    @JsonIgnore
    @JsonProperty("hashIterations")
    private Integer hashIterations;

    @Basic
    @JsonProperty("email")
    private String email;

    @Basic
    @JsonProperty("mobileno")
    private String mobileno;

    @Basic
    @JsonProperty("role")
    private Role role;

    @Basic
    @JsonProperty("state")
    private State state;

    @Basic
    @JsonProperty("accessToken")
    private String accessToken;

//    @OneToMany
//    @JoinColumn(name = "username")
//    private List<Hotel> hotels;

    public User(){

    }

    public User(String username, String passwordHash, String salt, Integer hashIterations, String email, String mobileno , Role role, State state, String accessToken, Set<Hotel> hotels) {
        //this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.hashIterations = hashIterations;
        this.email = email;
        this.mobileno = mobileno;
        this.role = role;
        this.state = state;
        this.accessToken = accessToken;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getHashIterations() {
        return hashIterations;
    }

    public void setHashIterations(Integer hashIterations) {
        this.hashIterations = hashIterations;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}






//package models;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import javax.persistence.*;
//
//@Entity
//public class User {
//
//    public enum Role {
//        ADMIN,
//        USER
//    }
//
//    public enum State {
//        PENDING,
//        VERIFIED,
//        LOCKED
//    }
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    @JsonProperty("id")
////    private Integer id;
//
//    @Id
//    @JsonProperty("username")
//    private String username;
//
//    @Basic
//    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
//    private String password;
//
//    @Basic
//    @JsonProperty("email")
//    private String email;
//
//    @Basic
//    @JsonProperty("role")
//    private Role role;
//
//    @Basic
//    @JsonProperty("state")
//    private State state;
//
//    @Basic
//    @JsonProperty("accessToken")
//    private String accessToken;
//
//    public User() {
//    }
//
////    public User(Integer id, String username, String password, String email, Role role, State state, String accessToken)
//
//    public User(String username, String password, String email, Role role, State state, String accessToken)
//    {
//        //this.id = id;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.role = role;
//        this.state = state;
//        this.accessToken = accessToken;
//    }
//
////    public Integer getId() {
////        return id;
////    }
////
////    public void setId(Integer id) {
////        this.id = id;
////    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public State getState() {
//        return state;
//    }
//
//    public void setState(State state) {
//        this.state = state;
//    }
//
//    public String getAccessToken() {
//        return accessToken;
//    }
//
//    public void setAccessToken(String accessToken) {
//        this.accessToken = accessToken;
//    }
//}