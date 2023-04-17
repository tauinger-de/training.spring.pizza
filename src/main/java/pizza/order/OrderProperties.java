package pizza.order;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Map;

@ConstructorBinding
@ConfigurationProperties("app.order")
public class OrderProperties {

    private final Integer deliveryTimeInMinutes;
    private final Map<String, Double> dailyDiscounts;

    public OrderProperties(Integer deliveryTimeInMinutes, Map<String, Double> dailyDiscounts) {
        this.deliveryTimeInMinutes = deliveryTimeInMinutes;
        this.dailyDiscounts = dailyDiscounts;
    }

    public Integer getDeliveryTimeInMinutes() {
        return deliveryTimeInMinutes;
    }

    public Map<String, Double> getDailyDiscounts() {
        return dailyDiscounts;
    }
}

