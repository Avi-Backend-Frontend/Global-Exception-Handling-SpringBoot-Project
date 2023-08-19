package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BalanceNotFoundException;

@RestController
@RequestMapping("/bank")
public class BankController {

	private int StateBank = 2000;
	private int AxisBank = 15000;
	private int BarodaBank = 4000;

	@GetMapping("/amount/{balance}/{bankName}")
	public Object getbalance(@PathVariable int balance, @PathVariable String bankName) throws BalanceNotFoundException {

		try {
			switch (bankName) {
			case "StateBank":
				if (balance > StateBank)
					throw new BalanceNotFoundException("Unsufficient balance in State Bank");
				break;
			case "AxisBank":
				if (balance > AxisBank)
					throw new BalanceNotFoundException("Unsufficient balance in Axis Bank");
				break;
			case "BarodaBank":
				if (balance > BarodaBank)
					throw new BalanceNotFoundException("Unsufficient balance in Baroda Bank");
				break;
			}

		} catch (BalanceNotFoundException e) {
			throw e;
		}

		return "Tack your amount " + balance + " rupeeis in " + bankName;

	}

}
