package com.example.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.Notification;

@Service
public class NotificationListener {


	@RabbitListener(queues = "Omersqueue")
	public void handleMessage(Notification notification) {
		System.out.println("Message received..");
		System.out.println(notification);
	}

}
