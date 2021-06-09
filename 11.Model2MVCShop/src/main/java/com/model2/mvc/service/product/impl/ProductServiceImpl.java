package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.ProductDao; // ProductDao �ν��Ͻ� import

//==> ��ǰ���� ���� ����
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	///Field
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao; //==> ProductDao productDao = new ProductDaoImpl(); �� ���� �ǹ�
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	///Constructor
	public ProductServiceImpl() {
		System.out.println(this.getClass());
	}

	//Method
	public void addProduct(Product product) throws Exception {
		productDao.addProduct(product);
	}

	
	public Product getProduct(int prodNo) throws Exception {
		return productDao.getProduct(prodNo);
	}

	
	public Map<String, Object> getProductList(Search search) throws Exception {
		
		//<Product>�� �޴� List list ���� ���� ��, productDaoImpl.getProductList ��� ����
		//ProductMapper.xml���� product�� ������ ���� ������ list�� ����
		List<Product> list = productDao.getProductList(search);
		System.out.println("list ����Ϸ� : " + list);
		
		//productDaoImpl.getTotalCount ���� ��, ����� ���� totalCount�� ����
		int totalCount = productDao.getTotalCount(search);
		System.out.println("totalCount ����Ϸ� : " + totalCount);
		
		//map�� list, totalCount �� ���
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map; 
	}

	
	public void updateProduct(Product product) throws Exception {
		productDao.updateProduct(product);
	}

}//end of class
