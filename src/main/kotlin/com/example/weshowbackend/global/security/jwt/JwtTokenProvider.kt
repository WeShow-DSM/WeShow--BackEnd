package com.example.weshowbackend.global.security.jwt

import com.example.weshowbackend.domain.user.present.dto.TokenResponse
import com.example.weshowbackend.global.error.exception.InvalidJwtException
import com.example.weshowbackend.global.security.auth.AuthDetailService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
        private val authDetailService: AuthDetailService,
        private val jwtProperties: JwtProperties
) {

    fun getToken(id: String):TokenResponse {
        return TokenResponse(
                accessToken = generateToken(id, jwtProperties.accessExp, "access")
        )
    }

    private fun generateToken(id: String, expired: Long, type: String): String {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
                .setSubject(id)
                .setHeaderParam("type", type)
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + expired * 1000))
                .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val token: String? = request.getHeader(jwtProperties.header)
        return parseToken(token)
    }

    private fun parseToken(token: String?): String? {
        return if(token != null && token.startsWith(jwtProperties.prefix)) {
            token.replace(jwtProperties.prefix, "")
        } else null
    }

    fun authentication(token: String): Authentication {
        val userDetails: UserDetails = authDetailService.loadUserByUsername(getTokenSubject(token))

        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getTokenSubject(token: String): String {
        return getTokenBody(token).subject
    }

    fun getTokenBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey)
                    .parseClaimsJws(token).body
        } catch (e: Exception) {
            e.printStackTrace()
            when(e) {
                is ExpiredJwtException -> throw com.example.weshowbackend.global.error.exception.ExpiredJwtException.EXCEPTION
                else -> throw InvalidJwtException.EXCEPTION
            }
        }
    }
}