package com.example.tollbooth;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.money.Money;
import org.junit.After;
import org.junit.Test;

import rx.Observable;
import rx.functions.Action1;

public class TollPaymentAccumulatorTest {
	
	
	List<Money> results = new ArrayList<Money>();

	@Test
	public void testAccumulateTollPayment() {
		
		TollPayment tollPayment1 = new TollPayment(111, Money.parse("USD 1.00"));
		
		TollPayment tollPayment2 = new TollPayment(112, Money.parse("USD 1.00"));

		TollPayment tollPayment3 = new TollPayment(113, Money.parse("USD 1.00"));

		
		TollPaymentAccumulator
			.accumulateTollPayment(Observable.just(tollPayment1,tollPayment1,tollPayment1))
			.subscribe(new Action1<Money>() {
	
				@Override
				public void call(Money t) {
					results.add(t);
				}
		
			});
	
	}
	
	@After
	public void lastValueShouldBeThreeDollars() {
		assertTrue(results.get(results.size()-1).isEqual(Money.parse("USD 3.00")));
	}

}
