package com.sameer.spring.myspring.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.sameer.spring.myspring.dto.CustomerDTO;
import com.sameer.spring.myspring.model.Customer;

@Transactional
public class HibernateCustomerDAO implements CustomerDAO {

	@Autowired
	HibernateTemplate hibernateTemplate ;
	
	@Autowired
	HibernateTransactionManager hibernateTransactionManager ;
	
	public void addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer(customerDTO.getCid(), customerDTO.getCname(), customerDTO.getEmail(), customerDTO.getPhone(), customerDTO.getCity());
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = hibernateTransactionManager.getTransaction(transactionDefinition);
		hibernateTemplate.save(customer);
		hibernateTransactionManager.commit(transactionStatus);
	}

	public void updateCustomer(CustomerDTO customerDTO) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = hibernateTransactionManager.getTransaction(transactionDefinition);
		Customer customer = hibernateTemplate.load(Customer.class, customerDTO.getCid());
		customer.setCid(customerDTO.getCid());
		customer.setCname(customerDTO.getCname());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhone(customerDTO.getPhone());
		customer.setCity(customerDTO.getCity());
		hibernateTemplate.update(customer, LockMode.NONE);
		hibernateTransactionManager.commit(transactionStatus);
	}

	public void deleteCustomer(int cid) {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = hibernateTransactionManager.getTransaction(transactionDefinition); 
		Customer customer = hibernateTemplate.load(Customer.class, cid);
		hibernateTemplate.delete(customer,LockMode.NONE);
		hibernateTransactionManager.commit(transactionStatus);
	}

	public List<CustomerDTO> getAllCustomers() {
		List<CustomerDTO> listCustomerDTO = new ArrayList<CustomerDTO>();
		String hql = "from Customer cust";
		List<Customer> listCustomer = (List<Customer>) hibernateTemplate.find(hql);
		for (Customer customer : listCustomer) {
			CustomerDTO customerDTO = new CustomerDTO(customer.getCid(), customer.getCname(), customer.getEmail(), customer.getPhone(), customer.getCity());
			listCustomerDTO.add(customerDTO);
		}
		return listCustomerDTO;
	}

	public CustomerDTO getCustomerByCid(int cid) {
		Customer customer = hibernateTemplate.load(Customer.class, cid);
		CustomerDTO customerDTO = new CustomerDTO(customer.getCid(), customer.getCname(), customer.getEmail(), customer.getPhone(), customer.getCity());
		return customerDTO;
	}

	public CustomerDTO getCustomerByEmail(String email) {
		String hql = "from Customer cu where cu.email = ?";
		List<Customer>listCustomer = (List<Customer>) hibernateTemplate.find(hql, email);
		Customer customer = listCustomer.get(0);
		return new CustomerDTO(customer.getCid(), customer.getCname(),customer.getEmail(), customer.getPhone(), customer.getCity());
	}

	/*public List<CustomerDTO> getCustomerByCity(String city) {
		List<CustomerDTO> listCustomerDTO = new ArrayList<CustomerDTO>();
		String hql = "from Customer cu where cu.city = :city";
		List<Customer>listCustomer = (List<Customer>) hibernateTemplate.findByNamedParam(hql, "city", city);
		for (Customer customer : listCustomer) {
			CustomerDTO customerDTO = new CustomerDTO(customer.getCid(), customer.getCname(), customer.getEmail(), customer.getPhone(), customer.getCity());
			listCustomerDTO.add(customerDTO);
		}
		return listCustomerDTO;
	}*/
	
	public List<CustomerDTO> getCustomerByCity(String city) {
		List<CustomerDTO> listCustomerDTO = new ArrayList<CustomerDTO>();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.eq("city", city));
		hibernateTemplate.setCacheQueries(true);
		List<Customer>listCustomer = (List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria);
		for (Customer customer : listCustomer) {
			CustomerDTO customerDTO = new CustomerDTO(customer.getCid(), customer.getCname(), customer.getEmail(), customer.getPhone(), customer.getCity());
			listCustomerDTO.add(customerDTO);
		}
		return listCustomerDTO;
	}

	public int getCustoomerCount() {
		String hql = "from Customer cust" ;
		List<Customer>listCustomer = (List<Customer>) hibernateTemplate.find(hql);
		return listCustomer.size();
	}

	public String getCustomerCityByEmail(String email) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		List<Customer>listCustomer = (List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria);
		Customer cust = listCustomer.get(0);
		return cust.getCity();
	}

	public Long getCustomerPhoneByEmail(String email) {
		String hql = "from Customer c where c.email=:email" ;
		List<Customer>listCustomer = (List<Customer>) hibernateTemplate.findByNamedParam(hql, "email", email);
		Customer c = listCustomer.get(0);
		return c.getPhone();
	}
}
