package com.hdfc.Services;

import com.hdfc.ApiResponse.ApiResponse;
import com.hdfc.Model.Customer;

public interface AccountService {
	public ApiResponse opeanAccount(Customer customer);
	
}
