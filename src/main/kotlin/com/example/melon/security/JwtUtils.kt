package com.example.melon.security


import com.example.melon.service.UserDetailsServiceImpl
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtils(private val userDetailsService: UserDetailsServiceImpl) {

    val EXP_TIME: Long = 1000L * 60 * 60 * 24 * 7
    val JWT_SECRET: String = "codingistooharduihhuihuihuihiuhuihuihuihuihuihuihuihuibjbhgyugg"
    val SIGNATURE_ALG: SignatureAlgorithm = SignatureAlgorithm.HS256

    // 토큰생성
    fun createToken(userId: Long): String {
        val claims: Claims = Jwts.claims();
        claims["userId"] = userId

        return Jwts.builder()
            .setClaims(claims)
            .setExpiration(Date(System.currentTimeMillis()+ EXP_TIME))
            .signWith(SIGNATURE_ALG, JWT_SECRET)
            .compact()
    }

    // 토큰검증
    fun validation(token: String) : Boolean {
        val claims: Claims = getAllClaims(token)
        val exp: Date = claims.expiration
        return exp.after(Date())
    }

    // 토큰에서 username 파싱
    fun parseUsername(token: String): String {
        val claims: Claims = getAllClaims(token)
        return claims["username"] as String
    }

    // username으로 Authentcation객체 생성
    fun getAuthentication(username: String): Authentication {
        val userDetails: UserDetails = userDetailsService.loadUserByUsername(username)

        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
    }

    fun getUserId(accessToken: String): String {
        return Jwts.parserBuilder().setSigningKey(JWT_SECRET).build().parseClaimsJws(accessToken.substring(6)).body["username"] as String
    }

    fun test(accessToken: String): Claims? {
        println(Jwts.parserBuilder().setSigningKey(JWT_SECRET).build().parseClaimsJws(accessToken.substring(6)).body)
        return Jwts.parserBuilder().setSigningKey(JWT_SECRET).build().parseClaimsJws(accessToken.substring(6)).body
    }
    // 모든 Claims 조회
    private fun getAllClaims(token: String): Claims {
        return Jwts.parser()
            .setSigningKey(JWT_SECRET)
            .parseClaimsJws(token)
            .body
    }
}