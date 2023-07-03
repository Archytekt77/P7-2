package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.Type;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Data
@Service
public class TypeService {
    
    @Autowired
    ApiProxy apiProxy;


    public Type getType(int id){
        return apiProxy.getType(id);
    }

    public Collection<Type> getTypes(){
        return apiProxy.getTypes();
    }

}
