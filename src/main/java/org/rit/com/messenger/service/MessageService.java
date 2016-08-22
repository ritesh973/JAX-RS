package org.rit.com.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.rit.com.messenger.database.DatabaseClass;
import org.rit.com.messenger.model.Message;

public class MessageService {
	
	public static Map<Long,Message> messages=DatabaseClass.getMessages();
	
	
	public MessageService(){
		messages.put(1L, new Message(1,"hii ritesh","ritesh"));
		messages.put(2L, new Message(2,"hii govind","govind"));
	}
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
		
	}
	public List<Message> getAllMessagesForYear(int year){
		List<Message>messagesForYear=new ArrayList<>();
		Calendar calender=Calendar.getInstance();
		for (Message message : messages.values()) {
			calender.setTime(message.getCreated());
			if(calender.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
			
			
		}
		return messagesForYear;
	}
	public List<Message> getMessagePaginated(int start,int size){
		MessageService msg=new MessageService();
		List<Message> list=msg.getAllMessages();
		if(start+size>list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	public Message getMessage(Long id){
		return messages.get(id);
		
	}
	public Message addMessage(Message msg){
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	public Message updateMessage(Message msg){
		if(msg.getId()<=0){
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}
	public Message removeMessage(Long id){
		return messages.remove(id);
		
	}

}
