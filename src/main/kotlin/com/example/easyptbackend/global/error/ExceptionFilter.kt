package com.example.easyptbackend.global.error
import com.example.easyptbackend.global.error.exception.BaseException
import com.example.easyptbackend.global.exception.InternalServerErrorException
import org.springframework.http.MediaType
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.http.HttpServletRequest

class ExceptionFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BaseException) {
            errorToJson(e.errorProperty, response)
        } catch (e: Exception) {
            when (e.cause) {
                is BaseException -> errorToJson((e.cause as BaseException).errorProperty, response)
                else -> {
                    errorToJson(InternalServerErrorException.EXCEPTION.errorProperty, response)
                    e.printStackTrace()
                }
            }
        }
    }

    private fun errorToJson(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.writer.write(ErrorResponse(errorProperty.status(), errorProperty.message()).toString())
    }
}