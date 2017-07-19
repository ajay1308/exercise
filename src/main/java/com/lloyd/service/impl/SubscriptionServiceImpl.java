package com.lloyd.service.impl;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.lloyd.exception.BusinessException;
import com.lloyd.model.Subscription;
import com.lloyd.service.SubscriptionService;

/**
 * The Class SubscriptionServiceImpl.
 * To handle the subscription business logic
 * 
 * @author Ajay
 */
public class SubscriptionServiceImpl implements SubscriptionService {

	/** The log. */
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	/** The Constant EMAIL_PATTERN. */
	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");

	/**
	 * Subscribe user.
	 *
	 * Validate and subscribe user
	 *
	 * @param subscription the subscription
	 * @return true, if successful
	 * @throws BusinessException the business exception
	 */
	@Override
	public boolean subscribeUser(Subscription subscription) throws BusinessException{
		log.info("Entering method : SubscriptionServiceImpl.subscribeUser");
		if (StringUtils.isEmpty(subscription.getEmail()) || !EMAIL_PATTERN.matcher(subscription.getEmail()).matches()) {
			return false;
		} else {
			return true;
		}
	}

}
