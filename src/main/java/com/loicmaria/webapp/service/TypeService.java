package com.loicmaria.webapp.service;

import com.loicmaria.webapp.form.TypeForm;
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

    public Type convertTypeFormToType(Type type, TypeForm typeForm){
        type.setName(typeForm.getName());

        return type;
    }

    public Type createType(TypeForm typeForm){
        Type type = this.convertTypeFormToType(new Type(), typeForm);
        System.out.println("Type : " + type);
        return apiProxy.createType(type);
    }

    public Type getType(int id){
        return apiProxy.getType(id);
    }

    public Collection<Type> getTypes(){
        return apiProxy.getTypes();
    }

    public Type updateType(int id, TypeForm typeForm){
        Type type = this.convertTypeFormToType(apiProxy.getType(id), typeForm);
        return apiProxy.updateType(id, type);
    }

    public void deleteType(int id){
        apiProxy.deleteType(id);
    }
}
