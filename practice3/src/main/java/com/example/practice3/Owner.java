package com.example.practice3;

public class Owner {
    private static final int IDENTITY_NUMBER_LENGTH = 12;

    private final String identityNumber;
    private final String fullName;
    private final String email;

    public Owner(String identityNumber, String fullName, String email) {
        if (identityNumber == null
                || identityNumber.length() != IDENTITY_NUMBER_LENGTH
                || !identityNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException(
                    "Identity number must contain exactly "
                    + IDENTITY_NUMBER_LENGTH + " digits");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name must not be blank");
        }
        if (email == null
                || !email.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+")) {
            throw new IllegalArgumentException("Invalid email");
        }

        this.identityNumber = identityNumber;
        this.fullName = fullName;
        this.email = email;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}
