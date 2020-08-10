package com.example.send_mail.controller;

import com.example.send_mail.models.MailForm;
import com.example.send_mail.service.MailService;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.bind.DataBindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class SendMailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public ResponseEntity<?> sendMail(@Valid @RequestBody MailForm form, BindingResult result){
    	
    	Map<String, Object> response = new HashMap<>();
    	
        String message = form.getBody() +"\nDatos de contacto: " +
                "\nNombre: " + form.getName()+ "\nEmpresa: " + form.getEmpresa() + "\nE-mail: "
        		+ form.getMail()+ "\nNúmero: " + form.getNumber() + "\nEnviado desde ies-systemsmx.com.mx ";        
        
        try {
        	mailService.sendMail("from", "koreback12@gmail.com", "miguel.cruz@ies-systems.com", form.getSubject(), message);
		} catch (DataBindingException e) {
			response.put("message", "Error interno");
			response.put("Error", e.getMessage().concat(": "));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        response.put("message","Correo enviado con éxito");
		response.put("objectData", form);
		response.put("status", HttpStatus.OK );
		response.put("statusCode", 200 );
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}