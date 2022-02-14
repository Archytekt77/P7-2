package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.Copy;
import com.loicmaria.webapp.form.CopyForm;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Data
@Service
public class CopyService {
    
    @Autowired
    ApiProxy apiProxy;

    public Copy convertCopyFormToCopy(Copy copy, CopyForm copyForm){
        copy.setCopies(copyForm.getCopies());
        copy.setPublisherName(copyForm.getPublisherName());
        copy.setPublicationDate(this.convertDateFormToDate(copyForm));
        copy.setBook(apiProxy.getBook(copyForm.getIdBook()));
        copy.setType(apiProxy.getType(copyForm.getIdType()));

        return copy;
    }

    public Date convertDateFormToDate(CopyForm copyForm){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {

            Date date = formatter.parse(copyForm.getPublicationDate());

            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public Copy createCopy(CopyForm copyForm){
        Copy copy = this.convertCopyFormToCopy(new Copy(), copyForm);
        System.out.println("Exemplaire : " + copy);
        return apiProxy.createCopy(copy);
    }

    public Copy getCopy(int id){
        return apiProxy.getCopy(id);
    }

    public Collection<Copy> getCopies(){
        return apiProxy.getCopys();
    }

    public Copy updateCopy(int id, CopyForm copyForm){
        Copy copy = this.convertCopyFormToCopy(apiProxy.getCopy(id), copyForm);
        return apiProxy.updateCopy(id, copy);
    }

    public void deleteCopy(int id){
        apiProxy.deleteCopy(id);
    }
    
}
