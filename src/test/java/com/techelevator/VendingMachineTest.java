//
//package com.techelevator;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import junit.framework.Assert;
//
//public class VendingMachineTest {
//	
//	@Test
//	public void getSlotItem_returns_Potato_Crisps() throws Exception {
//		VendingMachine vm = new VendingMachine();
//		Product crisps = new Product("A1", "Potato Crisps", "3.25");
//		vm.stock();
//		Product result = vm.getSlotItem("A1");
//		assertEquals(crisps.getName(), result.getName());
//	}
//	
//	@Test
//	public void getSlotItem_returns_Triplemint() throws Exception {
//		VendingMachine vm = new VendingMachine();
//		Product triplemint = new Product("D4", "Triplemint", "0.75");
//		vm.stock();
//		Product result = vm.getSlotItem("D4");
//		assertEquals(triplemint.getPrice(), result.getPrice());
//	}
//
//}
//=======
////package com.techelevator;
////
////import static org.junit.Assert.*;
////
////import org.junit.Test;
////
////import junit.framework.Assert;
////
////public class VendingMachineTest {
////	
////	@Test
////	public void getPrice_returns_200() {
////		Product product = new Product("A1", "200", "Coke");
////		String result = product.getPrice();
////		assertEquals(200, result);
////	}
////	
////	@Test
////	public void getName_returns_Coke() {
////		Product product = new Product("A1","200", "Coke");
////		String result = product.getName();
////		assertEquals("Coke", result);
////	}
////	
////	@Test
////	public void getSlotItem_returns_Potato_Crisps() {
////		VendingMachine vm = new VendingMachine();
////		Product crisps = new Product("A1", "Potato Crisps", "3.25");
////		Product result = vm.getSlotItem("A1");
////		assertEquals("Potato Crisps", result);
////	}
////
////}
//>>>>>>> 834d810a205933732f49f423c3252a35aacf3d50
