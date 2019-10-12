package stone.domain;

import stone.enums.AccessLevel;

public class User {
    private final String email;
    private final String password;
    private final String name;
    private final String surName;
    private final String phone;
    private Long id;
    private AccessLevel accessLevel;

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    private User(Builder builder) {
        id = builder.id;
        email = builder.email;
        password = builder.password;
        name = builder.name;
        surName = builder.surName;
        this.phone = builder.phone;
        this.accessLevel = builder.accessLevel;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private Long id;
        private String phone;
        private String email;
        private String password;
        private String name;
        private String surName;
        private AccessLevel accessLevel = AccessLevel.CLIENT;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withAccessLevel(AccessLevel accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withSurName(String val) {
            surName = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
