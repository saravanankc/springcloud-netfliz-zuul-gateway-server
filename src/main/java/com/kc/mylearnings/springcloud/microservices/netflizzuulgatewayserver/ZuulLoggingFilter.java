package com.kc.mylearnings.springcloud.microservices.netflizzuulgatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        //Default "null". This filter needs to run before any request is executed, so return "pre"
        return  "pre";
    }

    @Override
    public int filterOrder() {
        //default 0. Set filter order = 1
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //default false. Enable the filter = true
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        LOGGER.info("Request -> {}, Request URI -> {}", request, request.getRequestURI());

        return null;
    }
}
