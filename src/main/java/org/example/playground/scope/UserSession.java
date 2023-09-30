package org.example.playground.scope;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Component
@Scope(scopeName = "session")
public class UserSession implements Serializable {
    private String username;
    private int userId;

    // Getters and setters for username and userId

    public void clear() {
        // Implement a method to clear the session data when the user logs out
        this.username = null;
        this.userId = 0;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

}
