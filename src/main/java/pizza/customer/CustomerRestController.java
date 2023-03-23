package pizza.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {

    //
    // --- constants ---
    //

    private static final String ROOT = "/customers";
    public static final String GET_ALL_ENDPOINT = ROOT;
    public static final String CREATE_ENDPOINT = ROOT;

    //
    // --- injected beans ---
    //

    private final CustomerService customerService;

    //
    // --- constructors and setup ---
    //

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //
    // --- REST endpoints ---
    //

    @GetMapping(GET_ALL_ENDPOINT)
    public Iterable<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    @PostMapping(CREATE_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return this.customerService.createCustomer(
                new Customer(
                        createCustomerRequest.fullName(),
                        createCustomerRequest.address(),
                        createCustomerRequest.phoneNumber()
                )
        );
    }

}