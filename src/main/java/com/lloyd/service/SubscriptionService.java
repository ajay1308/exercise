package com.lloyd.service;

import com.lloyd.exception.BusinessException;
import com.lloyd.model.Subscription;

/**
 * The Interface SubscriptionService.
 * To handle the subscription business logic
 * 
 * @author Ajay
 */
public interface SubscriptionService {

	/**
	 * Subscribe user.
	 * 
	 * Validate and subscribe user
	 *
	 * @param subscription the subscription
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	public boolean subscribeUser(Subscription subscription) throws BusinessException;
}
