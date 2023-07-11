package ru.job4j.ood.dip.ex1;

import ru.job4j.ood.isp.ex3.RZDCompany;

public class Analyst {
    RZDCompany company;

    public Analyst(RZDCompany company) {
        this.company = company;
    }

    int takeOnlineStats() {
        return company.getOnlineSales();
    }
}
