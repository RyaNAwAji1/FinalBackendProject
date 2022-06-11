package com.example.technicalworkshop.Service;

import com.example.technicalworkshop.Model.Company;
import com.example.technicalworkshop.Model.Invoice;
import com.example.technicalworkshop.Model.User;
import com.example.technicalworkshop.Repository.CompanyRepository;
import com.example.technicalworkshop.Repository.InvoiceRepository;
import com.example.technicalworkshop.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

   private final InvoiceRepository invoiceRepository;
   private final CompanyRepository companyRepository;
   private final UserRepository userRepository;



    public List<Invoice> getAllTotalPrice() {
        return invoiceRepository.findAll();
    }

    public void addNewTotalPrice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void addInvoice(Integer invoiceID, Integer companyID)
    {
        Invoice invoice= invoiceRepository.findById(invoiceID).get();
        Company company= companyRepository.findById(companyID).get();

        invoice.setCompany(company);
        invoiceRepository.save(invoice);

        company.getInvoices().add(invoice);
//        company.setPrice(company.getPrice()+(0.15*company.getPrice());
        companyRepository.save(company);

    }
    public void addUserToInvoice(Integer invoiceID, Integer UserId){

        Invoice invoice= invoiceRepository.findById(invoiceID).get();
        User user= userRepository.findById(UserId).get();

        invoice.setUser(user);
        invoiceRepository.save(invoice);

        user.getInvoices().add(invoice);
        userRepository.save(user);
    }
}
