package com.example.onetoonedemo.Controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.onetoonedemo.Entity.PaymentCharge;
import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@RestController
public class PaymentController {

	 private final String STRIPE_SECRET_KEY = "your_secret_key_here";

	    @PostMapping("/charge")
	    public String charge(@RequestBody PaymentCharge request) throws StripeException  {
	      
	        Stripe.apiKey = STRIPE_SECRET_KEY;

	        try {
	        	 Map<String, Object> chargeParams = new HashMap<>();
	 	        
	 	        chargeParams.put("amount", request.getAmount());
	 	        chargeParams.put("currency", "usd");
	 	        chargeParams.put("source", request.getToken());
	 	       
	            Charge charge = Charge.create(chargeParams);

	            return "Payment successful. Charge ID: " + charge.getId();

	        } catch (AuthenticationException e) //| InvalidRequestException  | ApiConnectionException  | CardException | APIException e) {
	        {
	            
	            return "Payment failed. Error message: " + ((StripeException) e).getMessage();
	        }
	        catch (InvalidRequestException e) {
	        	
	        	 return "Payment failed. Error message: " + ((StripeException) e).getMessage();
	        	
	        }
	        catch (ApiConnectionException e) {
	        	
	        	 return "Payment failed. Error message: " + ((StripeException) e).getMessage();
		        	
	        }
	        catch (CardException e) {
	        	
	        	return "Payment failed. Error message: " + ((StripeException) e).getMessage();
	        }
	        catch(ApiException e) {
	        	
	        	return "Payment failed. Error message: " + ((StripeException) e).getMessage();
	        }
	   }
}
