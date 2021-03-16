package com.pooney.book.config.auth;

import com.pooney.book.config.auth.LoginUser;
import com.pooney.book.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    //컨트롤로 메서드의 특정 파라미터를 지원하는지 판단한다.
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //@LoginUser 어노테이션이 붙어 있는 지 확인
        boolean isLoginUserAnnotiotion = parameter.getParameterAnnotation(LoginUser.class) != null;
        //파라미터 클래스 타입이 SesstionUser.class 인지 확인
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotiotion && isUserClass;
    }
    //파라미터에 전달할 객체를 생성한다.
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user");
    }
}
