package com.chatbonfire.server.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chatbonfire.server.Models.UserModel;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AuthService {

    private final static String PrivateKey = "SUPER_SECRET_KEY";

    private final static String JwtIssuer = "YOUR_ISSUER";

    public static String GenerateJwt(UserModel userModel) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(AuthService.PrivateKey);
            String generatedToken = JWT.create()
                    .withIssuer(AuthService.JwtIssuer)
                    .withClaim("id", userModel.id)
                    .withClaim("mail", userModel.mail)
                    .withClaim("name", userModel.name)
                    .withClaim("last_name", userModel.last_name)
                    .sign(algorithm);
            return generatedToken;
        }
        catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    public static Integer DecodeJwt(String JsonWebToken) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC256(AuthService.PrivateKey);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(AuthService.JwtIssuer).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(JsonWebToken);
            return Integer.parseInt(decodedJWT.getClaim("id").toString());
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static String hashData(String password) throws Exception {
        Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(PrivateKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        hmacSHA256.init(secretKeySpec);
        String hashToHex = Hex.encodeHexString(hmacSHA256.doFinal(password.getBytes(StandardCharsets.UTF_8)));
        return hashToHex;
    }

}