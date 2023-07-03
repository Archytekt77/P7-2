package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.Copy;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Data
@Service
public class CopyService {
    
    @Autowired
    ApiProxy apiProxy;


    public Copy getCopy(int id){
        return apiProxy.getCopy(id);
    }

    public Collection<Copy> getCopies(){
        return apiProxy.getCopies();
    }

    public Copy updateCopy(int id, Copy copy){
        return apiProxy.updateCopy(id, copy);
    }

    
}
