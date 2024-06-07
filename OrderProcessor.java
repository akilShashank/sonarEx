public class OrderProcessor {
    public void processOrders(List<Order> orders) {
        for (Order order : orders) {
            if (order.isValid()) {
                if (order.isHighPriority()) {
                    if (order.getCustomer().isVIP()) {
                        expediteOrder(order);
                    } else {
                        approveOrder(order);
                    }
                } else {
                    approveOrder(order);
                }
            } else {
                if (order.getCustomer().isBlacklisted()) {
                    rejectOrder(order);
                } else if (order.isPendingReview()) {
                    if (order.getReviewScore() > 7) {
                        approveOrder(order);
                    } else {
                        rejectOrder(order);
                    }
                } else {
                    rejectOrder(order);
                }
            }
        }
    }

    private void approveOrder(Order order) {
        // Approve order logic
    }

    private void rejectOrder(Order order) {
        // Reject order logic
    }

    private void expediteOrder(Order order) {
        // Expedite order logic
    }
}
