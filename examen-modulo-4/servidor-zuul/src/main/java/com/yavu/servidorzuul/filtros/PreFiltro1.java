package com.yavu.servidorzuul.filtros;

import java.time.Instant;
import java.util.Enumeration;

import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFiltro1 extends ZuulFilter {
	public PreFiltro1(){ }

	@Override
	public String filterType() {
		return "pre";
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

		requestContext.set("startTime", Instant.now().toEpochMilli());

		Enumeration < String > enumeration = requestContext.getRequest().getHeaderNames();

		String cabecera;
		String cabeceraRequerida = "from";

		boolean tieneCabeceraRequerida = false;

		while (enumeration.hasMoreElements()) {
			cabecera = enumeration.nextElement();

			if (cabecera.equals(cabeceraRequerida)) {
				tieneCabeceraRequerida = true;
			}
		};

		if (!tieneCabeceraRequerida) {
			requestContext.setResponseBody("Peticion rechazada por falta de parametro From en la cabecera de la solicitud");
			requestContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
			requestContext.setSendZuulResponse(false);

			return null;
		}

		return null;
	}
}
