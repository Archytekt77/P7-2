package com.loicmaria.webapp.service;

import com.loicmaria.webapp.form.LoanForm;
import com.loicmaria.webapp.model.Loan;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Data
@Service
public class LoanService {
    
    @Autowired
    ApiProxy apiProxy;

    public Loan convertLoanFormToLoan(Loan loan, LoanForm loanForm){
        loan.setStatus(loanForm.getStatus());
        loan.setExtraTime(loanForm.isExtraTime());
        loan.setBook(apiProxy.getBook(loanForm.getIdBook()));
        loan.setUser(apiProxy.getUser(loanForm.getIdUser()));

        return loan;
    }

    public Loan createLoan(LoanForm loanForm){
        Loan loan = convertLoanFormToLoan(new Loan(), loanForm);
        return apiProxy.createLoan(loan);
    }

    public Loan getLoan(int id){
        return apiProxy.getLoan(id);
    }

    public Collection<Loan> getLoans(){
        return apiProxy.getLoans();
    }

    public Loan updateLoan(int id, LoanForm loanForm){
        Loan loan = convertLoanFormToLoan(apiProxy.getLoan(id), loanForm);
        return apiProxy.updateLoan(id, loan);
    }

    public void deleteLoan(int id){
        apiProxy.deleteLoan(id);
    }
}
