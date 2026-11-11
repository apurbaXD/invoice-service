package com.bits.invoice;
public class InvoiceCalculator {
public double netAmount(double gross, double discountPct) {
if (discountPct < 0 || discountPct > 100)
throw new IllegalArgumentException("Invalid discount");
return gross - (gross * discountPct / 100);
}
public double total(double gross, double discountPct, double gstPct) {
double net = netAmount(gross, discountPct);
return net + (net * gstPct / 100);
}
}
// BITS ID: 2024sl70048
