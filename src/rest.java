/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adityabarna
 */

import java.util.*;
public class rest {
    private String restId;
    private String restName;
    private String restAdd;
    
    public rest(String restId,String restName,String restAdd){
        this.restId = restId;
        this.restName = restName;
        this.restAdd = restAdd;
    }

    public rest() {
		// TODO Auto-generated constructor stub
	}

	public String getRestId() {
        return restId;
    }

    public void setRestId(String restId) {
        this.restId = restId;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestAdd() {
        return restAdd;
    }

    public void setRestAdd(String restAdd) {
        this.restAdd = restAdd;
    }
    
    
}