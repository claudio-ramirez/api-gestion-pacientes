package com.yavu.servidorzuul.filtros;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PostFiltro extends ZuulFilter {
	private static Logger LOGGER = LoggerFactory.getLogger(PostFiltro.class);

	public PostFiltro(){ }

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();

		long startTime = (long) requestContext.get("startTime");
		long duration = Instant.now().toEpochMilli() - startTime;

		LOGGER.info("Duracion de la solicitud = " + duration + " milisegundos");

		return null;
	}
}
