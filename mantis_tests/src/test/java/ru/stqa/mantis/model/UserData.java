package ru.stqa.mantis.model;

import io.swagger.client.model.AccessLevel;

public record UserData(String username, String password, String email, Boolean enabled, Boolean _protected, AccessLevel accessLevel) {

    public UserData() {
        this("", "", "", false, false, new AccessLevel().id(1L).name("").label(""));
    }

    public UserData withUsername(String username) {
        return new UserData(username, this.password, this.email, this.enabled, this._protected, this.accessLevel);
    }

    public UserData withPass(String password) {
        return new UserData(this.username, password, this.email, this.enabled, this._protected, this.accessLevel);
    }

    public UserData withEmail(String email) {
        return new UserData(this.username, this.password, email, this.enabled, this._protected, this.accessLevel);
    }

    public UserData withEnabled(Boolean enabled) {
        return new UserData(this.username, this.password, this.email, enabled, this._protected, this.accessLevel);
    }

    public UserData withProtected(Boolean _protected) {
        return new UserData(this.username, this.password, this.email, this.enabled, _protected, this.accessLevel);
    }

    public UserData withAccessLevel(AccessLevel accessLevel) {
        return new UserData(this.username, this.password, email, this.enabled, this._protected, accessLevel);
    }
}
