package com.yavu.servidorzuul.filtros;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFiltro2 extends ZuulFilter {
	private static Logger LOGGER = LoggerFactory.getLogger(PreFiltro2.class);

	public PreFiltro2(){ }

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 2;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		final HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();

		LOGGER.info("Peticion de metodo {} a la url {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString());

		return null;
	}
}
