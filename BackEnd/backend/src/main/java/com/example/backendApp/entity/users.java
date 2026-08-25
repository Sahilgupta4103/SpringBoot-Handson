package com.example.backendApp.entity;

import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")  //<-- added this to map this with the collections in DB -->
public class users {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NotBlank(message = "Username is required")
    private String userName;
    @NotBlank(message = "password is required")
    private String password;
    @DBRef
    private List<backendEntry> backendEntries = new ArrayList<>();

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<backendEntry> getBackendEntries() {
        return backendEntries;
    }

    public void setBackendEntries(List<backendEntry> backendEntries) {
        this.backendEntries = backendEntries;
    }
}
