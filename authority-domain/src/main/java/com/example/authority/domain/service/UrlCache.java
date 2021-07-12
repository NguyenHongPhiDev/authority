package com.example.authority.domain.service;

import com.example.authority.domain.model.UrlRolesBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UrlCache {
	
	HashMap<String, List<String>> urlRoles=new HashMap<String, List<String>>();

	public HashMap<String, List<String>> getUrlRoles() {
		return this.urlRoles;
	}

	public void setUrlRoles(HashMap<String, List<String>> urlRoles) {
		this.urlRoles = urlRoles;
	}
	
	public List<String> getUrlRoles(String key) {
		return urlRoles.get(key);
	}

	public void mapUrlToRole(List<UrlRolesBean> roleActions){
		String dbUrl=null;
		for (UrlRolesBean urlRolesBean : roleActions) {
			dbUrl=urlRolesBean.getUrl();
			if(this.urlRoles.containsKey(dbUrl)){
				List<String> roles=this.urlRoles.get(dbUrl);
				roles.add(urlRolesBean.getRole());
				
			}else{
				List<String> roles=new ArrayList<String>();
				roles.add(urlRolesBean.getRole());
				this.urlRoles.put(dbUrl, roles);
			}
		}
	}
		
}
