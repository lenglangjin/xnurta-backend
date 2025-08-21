package com.leda.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET = "M4iJ9X65t4QZ5FTeC82BcSW4yp1D3PfM";

    public static String createToken(Long userId, String openId) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, 24);
        Date time = instance.getTime();
        String sign = JWT.create()
                .withClaim("openid", openId)
                .withClaim("userid", userId)
                .withSubject("登陆")
                .withIssuedAt(new Date())
                .withExpiresAt(time)
                .sign(Algorithm.HMAC256(SECRET));
        return sign;
    }

    public static Map<String, Claim> verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        try {
            return verifier.verify(token).getClaims();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
      * @desc 解析token的userId
      * @auth Frank
      * @date 2024-11-25
      */
    public static Long getUserId(String token){
        return verifyToken(token).get("userid").asLong();
    }



    /**
     * @desc 解析token的userId
     * @auth Frank
     * @date 2024-11-25
     */
    public static String getOpenid(String token){
        return verifyToken(token).get("openid").asString();
    }


    public static void main(String[] args) {
        String token = JwtUtils.createToken(100L, "oL8h87YIPIBvHuteLDdWORRdV1xc");
        System.out.println(token);
        Map<String, Claim> data = verifyToken(token);
        System.out.println(data.get("userid").asLong());
        System.out.println(data.get("openid").asString());
    }
}
