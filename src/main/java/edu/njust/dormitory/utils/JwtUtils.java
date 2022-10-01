package edu.njust.dormitory.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.deploy.cache.JarSigningData;
import edu.njust.dormitory.entity.Login;


import java.util.Date;
import java.util.Map;

public class JwtUtils{
    /**
     * 过期5分钟
     * */
    private static final long EXPIRE_TIME = 60 * 60 * 1000;

    /**
     * jwt密钥
     * */
    private static final String SECRET = "BaoZhiGuo_secret";

    /**
     * 签名生成
     * @param login 登录信息
     * @return jwt字符串
     */
    public static String sign(Login login){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userAccount", login.getUserName())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }
    /**
     * 签名验证
     * @param token jwt字符串
     * @return jwt信息
     */
    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("userAccount: " + jwt.getClaim("userAccount").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 从token获取用户信息
     * @param token jwt字符串
     * @return 用户名
     */
    public static String getUserName(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("userAccount").asString();
        } catch (Exception e){
            return null;
        }
    }
}