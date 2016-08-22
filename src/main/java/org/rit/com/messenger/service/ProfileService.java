package org.rit.com.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rit.com.messenger.database.DatabaseClass;
import org.rit.com.messenger.model.Profile;

public class ProfileService {
	
	public static Map<String,Profile> profiles=DatabaseClass.getProfiles();
	
	
	public ProfileService(){
		profiles.put("ritesh", new Profile(1l,"ritesh kumar","ritesh","kumar"));
		profiles.put("nitesh", new Profile(2l,"nitesh singh","nitesh","singh"));
	}
	public List<Profile> getAllProfiles(){
		
		return new ArrayList<Profile>(profiles.values());
		
	}
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
		
	}
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile updateProfile(Profile profile){
		if(profile.getFirstName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile removeProfile(String profile){
		return profiles.remove(profile);
		
	}

}
