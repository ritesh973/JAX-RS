package org.rit.com.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rit.com.messenger.model.Message;
import org.rit.com.messenger.resource.beans.MessageFilterBean;
import org.rit.com.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService  messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean messageFilter){
		if(messageFilter.getYear()>0){
			return messageService.getAllMessagesForYear(messageFilter.getYear());
		}
		if(messageFilter.getStart()>=0&&messageFilter.getSize()>=0){
			return messageService.getMessagePaginated(messageFilter.getStart(), messageFilter.getSize());
		}
		return messageService.getAllMessages();
	}
	
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long messageId){
		return messageService.getMessage(messageId);
	}
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
		
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long messageId,Message message){
		message.setId(messageId);
		return messageService.updateMessage(message);
		
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long messageId){
		
		 messageService.removeMessage(messageId);
		
	}
	
	

}
