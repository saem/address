package opus.address.security;

import org.jasypt.digest.StandardStringDigester;

public final class PasswordDigester {
    private final StandardStringDigester digester;

    public PasswordDigester() {
        digester = new StandardStringDigester();
        digester.setAlgorithm("SHA-256");
        digester.setIterations(100000);
        digester.setSaltSizeBytes(16);
        digester.initialize();
    }

    public String digestPassword(final String plainTextPassword) {
        return digester.digest(plainTextPassword);
    }

    public boolean matchPassword(final String plainTextPassword, final String digestedPassword) {
        return this.digester.matches(plainTextPassword, digestedPassword);
    }
}