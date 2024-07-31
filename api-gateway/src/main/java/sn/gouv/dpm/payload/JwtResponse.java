package sn.gouv.dpm.payload;

public class JwtResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    // getters and setters
}
