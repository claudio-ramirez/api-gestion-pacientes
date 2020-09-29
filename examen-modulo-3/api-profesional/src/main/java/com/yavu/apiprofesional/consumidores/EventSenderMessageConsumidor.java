package com.yavu.apiprofesional.consumidores;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.yavu.apiprofesional.modelos.ProfesionalModelo;

public class EventSenderMessageConsumidor {
//	@Autowired
//	private MongoTemplate mongoTemplate;

//	@RabbitListener(queues="rollbackProfesional")
//	public void receive(ProfesionalModelo profesional) {
//		Query query = new Query();
//
//		query.addCriteria(Criteria.where("codigo").is(profesional.getCodProd()));
//
//		Update update = new Update();
//
//		update.inc("unidades", profesional.getUnidades());
//
//		mongoTemplate.updateFirst(query, update, ProfesionalModelo.class);
//	}
}
