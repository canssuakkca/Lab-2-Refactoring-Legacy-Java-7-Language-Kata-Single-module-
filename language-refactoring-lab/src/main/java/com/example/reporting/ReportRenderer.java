package com.example.reporting;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.model.Order;

public class ReportRenderer {

    public String render(List<Order> orders, Map<String, Object> stats) {
        var sb = new StringBuilder()
                .append("=== ORDER REPORT ===\n")
                .append("count=").append(stats.get("count")).append("\n")
                .append("totalRevenueCents=").append(stats.get("totalRevenue")).append("\n\n");

        String orderLines = orders.stream()
                .filter(o -> o != null)
                .map(o -> String.format(
                        "Order %s tier=%s pay=%s gross=%d status=%s",
                        o.getId(),
                        o.getCustomer() == null ? "UNKNOWN" : o.getCustomer().getTier(),
                        o.getPayment() == null ? "NONE" : o.getPayment().masked(),
                        o.totalCents(),
                        o.getStatus()
                ))
                .collect(Collectors.joining("\n"));

        sb.append(orderLines);
        return sb.toString();
    }
}