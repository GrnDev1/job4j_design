package ru.job4j.ood.isp.ex3;

public class Analyst {
    int takeOfflineStats(ProductCompany company) {
        return company.getOfflineSales();
    }

    int takeOnlineStats(ProductCompany company) {
        return company.getOnlineSales();
    }
}
