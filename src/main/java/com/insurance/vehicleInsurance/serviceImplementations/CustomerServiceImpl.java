package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.vehicleInsurance.dao.CustomerRepository;
import com.insurance.vehicleInsurance.dto.CustomerDto;
import com.insurance.vehicleInsurance.entity.Customer;
import com.insurance.vehicleInsurance.exception.CustomerException;
import com.insurance.vehicleInsurance.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(CustomerDto nc) throws CustomerException {
		Optional<Customer> customerOpt = this.customerRepository.findByCustomerName(nc.getCustomerName());
		if(customerOpt.isPresent()) {
			throw new CustomerException("Customer already exist name: "+nc.getCustomerName());
		}
//		List<Vehicle> vehicles = customer.getVehicles();
//		if(vehicles != null) {
//			vehicles = this.vehicleRepository.saveAll(vehicles);
//		}customer.setVehicles(vehicles);
//		Documents documents = customer.getDocuments();
//		if(documents != null) {
//			documents = this.documentRepository.save(documents);
//		}customer.setDocuments(documents);
//		Registration registration = customer.getRegistration();
//		if(registration != null) {
//			registration = this.registrationRepository.save(registration);
//		}customer.setRegistration(registration);
//		List<Insurance> insurances= customer.getInsurances();
//		if(insurances != null) {
//			insurances=this.insuranceRepository.saveAll(insurances);
//		}customer.setInsurances(insurances);
		Customer customer = new Customer(nc.getCustomerName(),nc.getCustomerMobile(),nc.getCustomerEmail(),nc.getCustomerAddress(),nc.getCustomerUserName(),nc.getCustomerPassword());		
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer id) throws CustomerException {
		Optional<Customer> customerOpt = this.customerRepository.findById(id);
		if(!customerOpt.isPresent()) {
			throw new CustomerException("Customer not found for id: "+id);
		}
		return customerOpt.get();
	}

	@Override
	public Customer updateCustomer(CustomerDto newCustomer) throws CustomerException {
		if(newCustomer==null) {
			throw new CustomerException("Please enter valid values.");
		}
		Customer customer = new Customer(newCustomer.getCustomerName(),newCustomer.getCustomerMobile(),newCustomer.getCustomerEmail(),newCustomer.getCustomerAddress(),newCustomer.getCustomerUserName(),newCustomer.getCustomerPassword());
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer deleteCustomerById(Integer id) throws CustomerException {
		Optional<Customer> customerOpt = this.customerRepository.findById(id);
		if(!customerOpt.isPresent()) {
			throw new CustomerException("Customer not found to delete, id: "+id);
		}
		Customer customer = customerOpt.get();
		this.customerRepository.delete(customer);
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return this.customerRepository.findAll();
	}

}
