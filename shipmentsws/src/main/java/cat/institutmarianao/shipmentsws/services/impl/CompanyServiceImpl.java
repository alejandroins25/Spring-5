package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.shipmentsws.exception.NotFoundException;
import cat.institutmarianao.shipmentsws.model.Company;
import cat.institutmarianao.shipmentsws.repositories.CompanyRepository;
import cat.institutmarianao.shipmentsws.services.CompanyService;
import jakarta.validation.constraints.Positive;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company getById(@Positive Long id) {
		return companyRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

}