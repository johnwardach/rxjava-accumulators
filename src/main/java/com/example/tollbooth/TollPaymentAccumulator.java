package com.example.tollbooth;

import org.joda.money.Money;

import rx.Observable;

public interface TollPaymentAccumulator {
	
	static Observable<Money> accumulateTollPayment(Observable<TollPayment> tollPayentObservable) {
		
		return tollPayentObservable
				.scan(Money.parse("USD 0.00"), (accumulator, currentPayment) -> {
					return accumulator.plus(currentPayment.getAmount());
				});
	}

}
