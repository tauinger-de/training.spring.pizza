package pizza;

import pizza.customer.Address;
import pizza.customer.Customer;
import pizza.customer.CustomerService;
import pizza.product.Product;
import pizza.product.ProductService;

/**
 * The <code>SampleDataLoader</code> interface is simply an extension of the {@link Runnable}
 * interface without any additional functionality.
 * <p>
 * This interface contains multiple implementations to load no or some data into the system for demo
 * purposes.
 */
public interface SampleDataRunner extends Runnable {

    class NoOpSampleDataRunner implements SampleDataRunner {
        @Override
        public void run() {
        }
    }

    class SmallSampleDataRunner implements SampleDataRunner {

        private final ProductService productService;
        private final CustomerService customerService;

        public SmallSampleDataRunner(ProductService productService, CustomerService customerService) {
            this.productService = productService;
            this.customerService = customerService;
        }

        @Override
        public void run() {
            createProduct("S-01", "Thunfisch Salat", 6.90);
            createProduct("S-02", "Salat Italiano", 7.90);
            createProduct("S-03", "Romana Salat", 8.90);
            createProduct("P-10", "Pizza Margarita", 5.50);
            createProduct("P-11", "Pizza Capricciosa", 7.50);
            createProduct("P-12", "Pizza Spinat und Feta", 7.00);

            var address1 = createAddress("Wasserstr. 123", "40302", "Atlantis");
            var address2 = createAddress("Schlossallee 1", "88776", "Monopolhausen");

            createCustomer("Enrico Pallazzo", "+49 123 456789", address1);
            createCustomer("Elizabeth Magie", "+1 77 551237", address2);
        }

        protected void createProduct(String productId, String name, double price) {
            this.productService.createProduct(new Product(productId, name, price));
        }

        protected Address createAddress(String street, String postalCode, String city) {
            return new Address(street, postalCode, city);
        }

        protected void createCustomer(String fullName, String phoneNumber, Address address) {
            this.customerService.createCustomer(new Customer(
                    fullName,
                    address,
                    phoneNumber
            ));
        }
    }

}