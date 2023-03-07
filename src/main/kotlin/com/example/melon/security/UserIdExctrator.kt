package com.example.melon.security

import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.servlet.http.HttpServletRequest

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class GetIdFromJwt

@Component
class GetIdFromJwtArgumentResolver(
    private val jwtUtils: JwtUtils,
) : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.getParameterAnnotation(GetIdFromJwt::class.java) != null
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?,
    ): String {
        val request: HttpServletRequest = webRequest.getNativeRequest(HttpServletRequest::class.java) as HttpServletRequest
        return jwtUtils.getUserId(request.getHeader("Authorization"))
    }
}

@Configuration
class WebMvcConfig(
    private val getIdFromJwtArgumentResolver: GetIdFromJwtArgumentResolver,
) : WebMvcConfigurer {
    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(getIdFromJwtArgumentResolver)
    }
}
