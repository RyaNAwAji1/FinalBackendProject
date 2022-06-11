package com.example.technicalworkshop.Service;

import com.example.technicalworkshop.DTO.CompanyDTO;
import com.example.technicalworkshop.DTO.InvoiceTotalPriceDTO;
import com.example.technicalworkshop.DTO.ProductAddToCompanyDTO;
import com.example.technicalworkshop.Model.Company;
import com.example.technicalworkshop.Model.Invoice;
import com.example.technicalworkshop.Model.Product;
import com.example.technicalworkshop.Model.Troubles;
import com.example.technicalworkshop.Repository.CompanyRepository;
import com.example.technicalworkshop.Repository.InvoiceRepository;
import com.example.technicalworkshop.Repository.ProductRepository;
import com.example.technicalworkshop.Repository.TroublesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ProductRepository productRepository;
    private final TroublesRepository troublesRepository;
    private final InvoiceRepository invoiceRepository;


    public List <Company> getCompanyInfo() {
        return companyRepository.findAll();
    }

    public Company addPrice(Company company) {
      return companyRepository.save(company);
    }

    public Object addProblemToCompany(CompanyDTO companyDTO) {
        Company company= companyRepository.findById(companyDTO.getCompanyID()).get();
        Troubles troubles= troublesRepository.findById(companyDTO.getTroublesID()).get();

        company.getTroubles().add(troubles);
        companyRepository.save(company);

        troubles.setCompany(company);
        troublesRepository.save(troubles);
       return companyRepository.findAll();
    }

    public Object getTotalPrice(InvoiceTotalPriceDTO invoiceTotalPriceDTO) {
        Company company= companyRepository.findById(invoiceTotalPriceDTO.getCompanyID()).get();
        Invoice invoice= invoiceRepository.findById(invoiceTotalPriceDTO.getInvoiceID()).get();

        company.getInvoices().add(invoice);
        companyRepository.save(company);

        invoice.setCompany(company);
        invoiceRepository.save(invoice);

        return companyRepository.findAll();

    }

    public Object addProductToCompany(ProductAddToCompanyDTO productAddToCompanyDTO) {
        Company company =companyRepository.findById(productAddToCompanyDTO.getCompanyID()).get();
        Product product= productRepository.findById(productAddToCompanyDTO.getProductID()).get();

        company.getProducts().add(product);
        companyRepository.save(company);

        product.setCompany(company);
        productRepository.save(product);
        return companyRepository.findAll();
    }

}
