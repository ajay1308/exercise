package com.lloyd.utils;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import com.lloyd.exception.ValidationException;
import com.lloyd.model.Subscription;
import com.lloyd.service.constants.Constants;

/**
 * The Class ValidationUtils.
 * 
 * To handle the validations
 * 
 * @author Ajay
 */
public class ValidationUtils {

	/**
	 * Validate subscription.
	 *
	 * @param subscription
	 *            the subscription
	 * @return true, if successful
	 * @throws ValidationException
	 *             the validation exception
	 */
	public static void validateSubscription(Subscription subscription, Model model) throws ValidationException {

		boolean errorFlag = false;

		if (StringUtils.isEmpty(subscription.getName()) || subscription.getName().trim().equals("")) {
			errorFlag = true;
			model.addAttribute(Constants.INPUT_NAME, Constants.NAME_BLANK);

		}
		if (StringUtils.isEmpty(subscription.getEmail())|| subscription.getEmail().trim().equals("")) {
			errorFlag = true;
			model.addAttribute(Constants.INPUT_EMAIL, Constants.EMAIL_BLANK);
		}
		if (errorFlag) {
			throw new ValidationException("Validation error in the Subscription request");
		}
	}
}
