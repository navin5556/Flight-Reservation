package com.bharath.flighreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.bharath.flighreservation.services.ReservationServiceImpl;

@Component
public class EmailUtil {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
	private JavaMailSender sender;

	public void sendItinerary(String toAddress, String filePath) {

		LOGGER.info("inside sendItinerary()");
		
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Itinerary for your flight");
			messageHelper.setText("please find your Itinerary attached ");
			messageHelper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
			
		} catch (MessagingException e) {
			
			LOGGER.error("exception inside sendItinerary() "+e);
			//e.printStackTrace();
		}

	}
}
