package com.lloyd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lloyd.exception.BusinessException;
import com.lloyd.exception.ValidationException;
import com.lloyd.model.Subscription;
import com.lloyd.service.SubscriptionService;
import com.lloyd.service.constants.Constants;
import com.lloyd.service.impl.SubscriptionServiceImpl;
import com.lloyd.utils.ValidationUtils;

/**
 * The Class SubscriptionController.
 * 
 * Controller class for the Subscription requests
 * 
 * @author Ajay
 */
@Controller
public class SubscriptionController {

	/** The log. */
	Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * Subscription form. 
	 * To display the subscription form
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String subscriptionForm(Model model) {
		log.info("Entering method : SubscriptionController.subscriptionForm");
		model.addAttribute(Constants.SUBSCRIPTION, new Subscription());
		log.info("Exiting method : SubscriptionController.subscriptionForm");
		return Constants.RETURN_WELCOME;
	}

	/**
	 * Subscription submit.
	 * Handle the subscription requests
	 *
	 * @param subscription the subscription
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/subscribe", method = RequestMethod.POST)
	public String subscriptionSubmit(@ModelAttribute Subscription subscription, Model model) {

		log.info("Entering method : SubscriptionController.subscriptionSubmit");
		log.debug(String.format("subscription Submission: name = %s, email = %s", subscription.getName(),
				subscription.getEmail()));
		try {
			ValidationUtils.validateSubscription(subscription, model);
			SubscriptionService service = new SubscriptionServiceImpl();
			if (service.subscribeUser(subscription)) {
				model.addAttribute(Constants.MESSAGE, Constants.SUBSCRIPTION_SUCCESS);
			} else {
				model.addAttribute(Constants.MESSAGE, Constants.SUBSCRIPTION_FAILURE);
			}
		} catch (ValidationException e) {
			log.error(e.getMessage(), e);
			return Constants.RETURN_WELCOME;
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return Constants.RETURN_ERROR;
		}

		log.info("Exiting method : SubscriptionController.subscriptionSubmit");
		return Constants.RETURN_RESULT;
	}

}
